/*
 * Copyright (c) Nmote Ltd. 2015. All rights reserved.
 * See LICENSE doc in a root of project folder for additional information.
 */

package com.nmote.oembed.embedly;

import org.apache.http.client.HttpClient;
import org.apache.http.client.utils.URIBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nmote.oembed.AbstractOEmbedProvider;
import com.nmote.oembed.OEmbed;
import com.nmote.oembed.OEmbedProvider;
import com.nmote.oembed.ProviderEndpoint;

public class EmbedlyProvider extends AbstractOEmbedProvider {

	private static final ProviderEndpoint PROVIDER_ENDPOINT = new ProviderEndpoint("http://api.embed.ly/1/oembed", EmbedlyEmbed.class);

	public static void main(String[] args) throws Exception {
		OEmbedProvider provider = new EmbedlyProvider("cf3025e4000e4fe8a8601a173a42abc4");
		String[] urls = { "http://bit.ly/cXVifg", "http://yfrog.com/ng41306327j" };
		for (String url : urls) {
			OEmbed embed = provider.resolve(url);
			System.out.println(url);
			System.out.println(embed);
			System.out.println();
		}
	}

	public EmbedlyProvider(String apiKey) {
		super();

		assert apiKey != null;

		this.apiKey = apiKey;
	}

	public EmbedlyProvider(String apiKey, HttpClient httpClient, ObjectMapper mapper) {
		super(httpClient, mapper);

		assert apiKey != null;
		assert httpClient != null;
		assert mapper != null;

		this.apiKey = apiKey;
	}

	@Override
	protected ProviderEndpoint getProviderEndpointFor(String url) {
		return PROVIDER_ENDPOINT;
	}

	@Override
	protected void prepareRequestURI(URIBuilder builder, String url, Integer... maxSize) {
		super.prepareRequestURI(builder, url, maxSize);
		builder.addParameter("key", apiKey);
	}

	private final String apiKey;
}
