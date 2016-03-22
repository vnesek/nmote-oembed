/*
 * Copyright (c) Nmote Ltd. 2015. All rights reserved.
 * See LICENSE doc in a root of project folder for additional information.
 */

package com.nmote.oembed;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

import com.fasterxml.jackson.databind.ObjectMapper;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public abstract class AbstractOEmbedProvider implements OEmbedProvider {

    /**
     * Makes an instance using default HTTP client and Jackson ObjectMapper.
     */
    public AbstractOEmbedProvider() {
        this(new OkHttpClient(), new ObjectMapper());
    }

    /**
     * Makes an instance using supplied httpClient and mapper.
     *
     * @param httpClient
     *            OkHTTP client
     * @param mapper
     *            Jackson ObjectMapper instance
     */
    public AbstractOEmbedProvider(OkHttpClient httpClient, ObjectMapper mapper) {
        Objects.requireNonNull(httpClient);
        Objects.requireNonNull(mapper);

        this.httpClient = httpClient;
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
            try (InputStream in = response.body().byteStream()) {
                T result = mapper.readValue(in, embedClass);
                checkEmbedForErrors(result);
                return result;
            }
        } else {
            throw new IOException(
                    String.format("HTTP %d/%s while getting %s", response.code(), response.message(), url));
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
        // Format request url
        HttpUrl.Builder b = HttpUrl.parse(provider.getUrl().replace("{format}", "json")).newBuilder();
        prepareRequestURI(b, url, maxSize);
        return get(b.toString(), getEmbedClass(provider));
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
    protected void prepareRequestURI(HttpUrl.Builder builder, String url, Integer... maxSize) {
        builder.addQueryParameter("url", url);
        builder.addQueryParameter("format", "json");
        if (maxSize != null) {
            if (maxSize.length > 0 && maxSize[0] != null) {
                builder.addQueryParameter("maxwidth", maxSize[0].toString());
            }
            if (maxSize.length > 1 && maxSize[1] != null) {
                builder.addQueryParameter("maxheight", maxSize[1].toString());
            }
        }
    }

    protected final OkHttpClient httpClient;
    protected final ObjectMapper mapper;
}
