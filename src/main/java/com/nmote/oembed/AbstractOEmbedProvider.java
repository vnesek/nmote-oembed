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

public abstract class AbstractOEmbedProvider implements OEmbedProvider {

	public AbstractOEmbedProvider() {
		this(HttpClients.createDefault(), new ObjectMapper());
	}

	public AbstractOEmbedProvider(HttpClient httpClient, ObjectMapper mapper) {
		Objects.requireNonNull(httpClient);
		Objects.requireNonNull(mapper);

		this.httpClient = httpClient;
		this.mapper = mapper;
	}

	public <T extends OEmbed> T get(String url, final Class<T> embedClass) throws IOException {
		return httpClient.execute(new HttpGet(url), new ResponseHandler<T>() {
			@Override
			public T handleResponse(HttpResponse response) throws ClientProtocolException, IOException {
				StatusLine statusLine = response.getStatusLine();
				int status = statusLine.getStatusCode();
				if (status < 200 || status > 299) {
					throw new HttpResponseException(status, statusLine.getReasonPhrase());
				}
				HttpEntity entity = response.getEntity();
				T embed;
				try {
					embed = mapper.readValue(entity.getContent(), embedClass);
				} finally {
					EntityUtils.consumeQuietly(entity);
				}
				checkEmbedForErrors(embed);
				return embed;
			}
		});
	}

	@Override
	public OEmbed resolve(String url, Integer... maxSize) throws IOException {
		ProviderEndpoint provider = getProviderEndpointFor(url);
		if (provider == null) {
			throw new IOException("no oEmbed provider endpoint configured for: " + url);
		}
		return resolve(url, provider, maxSize);
	}

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

	protected void checkEmbedForErrors(OEmbed e) throws IOException {
	}

	protected Class<? extends BasicOEmbed> getEmbedClass(ProviderEndpoint endpoint) {
		return endpoint.embedClass != null ? endpoint.embedClass : BasicOEmbed.class;
	}

	protected abstract ProviderEndpoint getProviderEndpointFor(String url);

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

	protected final HttpClient httpClient;
	protected final ObjectMapper mapper;
}
