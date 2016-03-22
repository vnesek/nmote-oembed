/*
 * Copyright (c) Nmote Ltd. 2015. All rights reserved.
 * See LICENSE doc in a root of project folder for additional information.
 */

package com.nmote.oembed.noembed;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nmote.oembed.AbstractOEmbedProvider;
import com.nmote.oembed.OEmbed;
import com.nmote.oembed.ProviderEndpoint;

import okhttp3.OkHttpClient;

public class NoembedProvider extends AbstractOEmbedProvider {

	private static final ProviderEndpoint PROVIDER_ENDPOINT = new ProviderEndpoint("http://noembed.com/embed",
			NoembedEmbed.class);

	/**
	 * Makes an instance using default HTTP client and Jackson ObjectMapper.
	 */
	public NoembedProvider() {
		super();
	}

	/**
	 * Makes an instance using supplied httpClient and mapper.
	 *
	 * @param httpClient
	 *            OkHTTP client
	 * @param mapper
	 *            Jackson ObjectMapper instance
	 */
	public NoembedProvider(OkHttpClient httpClient, ObjectMapper mapper) {
		super(httpClient, mapper);
	}

	/**
	 * @see com.nmote.oembed.AbstractOEmbedProvider#checkEmbedForErrors(com.nmote.oembed.OEmbed)
	 */
	@Override
	protected void checkEmbedForErrors(OEmbed e) throws IOException {
		String error = ((NoembedEmbed) e).error;
		if (error != null) {
			throw new IOException("noembed: " + error);
		}
	}

	/**
	 * @see com.nmote.oembed.AbstractOEmbedProvider#getProviderEndpointFor(java.lang.String)
	 */
	@Override
	protected ProviderEndpoint getProviderEndpointFor(String url) {
		return PROVIDER_ENDPOINT;
	}

}
