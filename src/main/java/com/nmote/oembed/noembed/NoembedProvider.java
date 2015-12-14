/*
 * Copyright (c) Nmote Ltd. 2015. All rights reserved.
 * See LICENSE doc in a root of project folder for additional information.
 */

package com.nmote.oembed.noembed;

import java.io.IOException;

import org.apache.http.client.HttpClient;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nmote.oembed.AbstractOEmbedProvider;
import com.nmote.oembed.OEmbed;
import com.nmote.oembed.ProviderEndpoint;

public class NoembedProvider extends AbstractOEmbedProvider {

	private static final ProviderEndpoint PROVIDER_ENDPOINT = new ProviderEndpoint("http://noembed.com/embed", NoembedEmbed.class);

	public NoembedProvider() {
		super();
	}

	public NoembedProvider(HttpClient httpClient, ObjectMapper mapper) {
		super(httpClient, mapper);
	}

	@Override
	protected void checkEmbedForErrors(OEmbed e) throws IOException {
		String error = ((NoembedEmbed) e).error;
		if (error != null) {
			throw new IOException("noembed: " + error);
		}
	}

	@Override
	protected ProviderEndpoint getProviderEndpointFor(String url) {
		return PROVIDER_ENDPOINT;
	}

}
