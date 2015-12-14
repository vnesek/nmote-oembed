/*
 * Copyright (c) Nmote Ltd. 2015. All rights reserved.
 * See LICENSE doc in a root of project folder for additional information.
 */

package com.nmote.oembed.embedly;

import java.util.Objects;

import org.apache.http.client.HttpClient;
import org.apache.http.client.utils.URIBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nmote.oembed.AbstractOEmbedProvider;
import com.nmote.oembed.ProviderEndpoint;

public class EmbedlyProvider extends AbstractOEmbedProvider {

	private static final ProviderEndpoint PROVIDER_ENDPOINT = new ProviderEndpoint("http://api.embed.ly/1/oembed",
			EmbedlyEmbed.class);

	/**
	 * Makes an instance using default HTTP client and Jackson ObjectMapper.
	 *
	 * @param apiKey
	 *            your's embedly API key
	 */
	public EmbedlyProvider(String apiKey) {
		super();

		Objects.requireNonNull(apiKey);
		this.apiKey = apiKey;
	}

	/**
	 * Makes an instance using supplied httpClient and mapper.
	 *
	 * @param apiKey
	 *            your's embedly API key
	 * @param httpClient
	 *            Apache HTTP client
	 * @param mapper
	 *            Jackson ObjectMapper instance
	 */
	public EmbedlyProvider(String apiKey, HttpClient httpClient, ObjectMapper mapper) {
		super(httpClient, mapper);

		Objects.requireNonNull(apiKey);
		this.apiKey = apiKey;
	}

	/**
	 * @see com.nmote.oembed.AbstractOEmbedProvider#getProviderEndpointFor(java.lang.String)
	 */
	@Override
	protected ProviderEndpoint getProviderEndpointFor(String url) {
		return PROVIDER_ENDPOINT;
	}

	/**
	 * @see com.nmote.oembed.AbstractOEmbedProvider#prepareRequestURI(org.apache.http.client.utils.URIBuilder,
	 *      java.lang.String, java.lang.Integer[])
	 */
	@Override
	protected void prepareRequestURI(URIBuilder builder, String url, Integer... maxSize) {
		super.prepareRequestURI(builder, url, maxSize);
		builder.addParameter("key", apiKey);
	}

	private final String apiKey;
}
