/*
 * Copyright (c) Nmote Ltd. 2015. All rights reserved.
 * See LICENSE doc in a root of project folder for additional information.
 */

package com.nmote.oembed;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Objects;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public abstract class AbstractOEmbedProvider implements OEmbedProvider {

	/**
	 * Makes an instance using default HTTP client and Jackson ObjectMapper.
	 */
	public AbstractOEmbedProvider() {
		this(HttpClients.createDefault(), new ObjectMapper());
	}

	/**
	 * Makes an instance using supplied httpClient and mapper.
	 *
	 * @param httpClient
	 *            Apache HTTP client
	 * @param mapper
	 *            Jackson ObjectMapper instance
	 */
	public AbstractOEmbedProvider(HttpClient httpClient, ObjectMapper mapper) {
		Objects.requireNonNull(httpClient);
		Objects.requireNonNull(mapper);

		this.httpClient = new OkHttpClient();
		this.mapper = mapper;
	}

	/**
	 * Makes HTTP request expecting oEmbed response. Maps to embedClass
	 * instance.
	 *
	 * @param <T>
	 *            oEmbed subclass to map data on
	 * @param url
	 *            oEmbed URL
	 * @param embedClass
	 *            OEmbed implementation class
	 * @return OEmbed instance
	 * @throws IOException
	 *             if HTTP request or mapping fail
	 */
	public <T extends OEmbed> T get(String url, final Class<T> embedClass) throws IOException {
	    Request request = new Request.Builder().url(url).build();
	    Response response = httpClient.newCall(request).execute();
	    if (response.isSuccessful()) {
	        T result = mapper.readValue(response.body().byteStream(), embedClass);
	        checkEmbedForErrors(result);
	        return result;
	    } else {
	        throw new IOException(String.format("HTTP %s while getting %s", response.message(), url));
	    }
	}

	/**
	 * @see com.nmote.oembed.OEmbedProvider#resolve(java.lang.String,
	 *      java.lang.Integer[])
	 */
	@Override
	public OEmbed resolve(String url, Integer... maxSize) throws IOException {
		ProviderEndpoint provider = getProviderEndpointFor(url);
		if (provider == null) {
			throw new IOException("no oEmbed provider endpoint configured for: " + url);
		}
		return resolve(url, provider, maxSize);
	}

	/**
	 * Makes oEmebed request for url using provider.
	 *
	 * @param url
	 *            url to embed
	 * @param provider
	 *            oEmbed provider endpoint
	 * @param maxSize
	 *            max width and height
	 * @return OEmbed instance
	 * @throws IOException
	 *             if oEmbed data can't be fetched
	 */
	public OEmbed resolve(String url, final ProviderEndpoint provider, Integer... maxSize) throws IOException {
		try {
			// Format request url
			URIBuilder b = new URIBuilder(provider.getUrl().replace("{format}", "json"));
			prepareRequestURI(b, url, maxSize);
			return get(b.build().toString(), getEmbedClass(provider));
		} catch (URISyntaxException e) {
			throw new IOException("invalid request url: " + e);
		}
	}

	/**
	 * Some oEmbed providers return errors in response fields instead of using
	 * HTTP response error codes. Check for errors on such providers.
	 *
	 * @param e
	 *            returned instance
	 * @throws IOException
	 *             if error is found on oEmbed instance
	 */
	protected void checkEmbedForErrors(OEmbed e) throws IOException {
	}

	/**
	 * Get's {@link BasicOEmbed} subclass to use for mapping response.
	 *
	 * @param endpoint
	 *            endpoint used for request
	 * @return class used to map oEmbed response.
	 */
	protected Class<? extends BasicOEmbed> getEmbedClass(ProviderEndpoint endpoint) {
		return endpoint.embedClass != null ? endpoint.embedClass : BasicOEmbed.class;
	}

	/**
	 * Returns ProviderEndpoint to use for given resource url.
	 *
	 * @param url
	 *            resource URL
	 * @return ProviderEndoint for url or null if none found.
	 */
	protected abstract ProviderEndpoint getProviderEndpointFor(String url);

	/**
	 * Prepares URL prior to making request.
	 *
	 * @param builder
	 *            URI
	 * @param url
	 *            embed URL
	 * @param maxSize
	 *            max width and height
	 */
	protected void prepareRequestURI(URIBuilder builder, String url, Integer... maxSize) {
		builder.addParameter("url", url);
		builder.addParameter("format", "json");
		if (maxSize != null) {
			if (maxSize.length > 0 && maxSize[0] != null) {
				builder.addParameter("maxwidth", maxSize[0].toString());
			}
			if (maxSize.length > 1 && maxSize[1] != null) {
				builder.addParameter("maxheight", maxSize[1].toString());
			}
		}
	}

	protected final OkHttpClient httpClient;
	protected final ObjectMapper mapper;
}
