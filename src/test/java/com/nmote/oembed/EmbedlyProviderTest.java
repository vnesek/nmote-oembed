/*
 * Copyright (c) Nmote Ltd. 2015. All rights reserved.
 * See LICENSE doc in a root of project folder for additional information.
 */

package com.nmote.oembed;

import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.http.client.HttpResponseException;
import org.junit.Ignore;
import org.junit.Test;

import com.nmote.oembed.OEmbed;
import com.nmote.oembed.OEmbedProvider;
import com.nmote.oembed.embedly.EmbedlyProvider;

import static org.junit.Assert.*;

public class EmbedlyProviderTest {

	@Ignore
	@Test
	public void instantcom() throws IOException, URISyntaxException {
		OEmbed e = provider.resolve("http://www.instantcom.net");
		assertEquals("http://www.instantcom.net", e.getProviderUrl());
		assertEquals("Instantcom", e.getProviderName());
		assertNotNull(e.getUrl());
		System.out.println(e);
	}

	@Ignore
	@Test(expected = HttpResponseException.class)
	public void nmote() throws IOException, URISyntaxException {
		provider.resolve("http://www.nmote.net");
	}

	@Ignore
	@Test
	public void oldSpiceOverBitly() throws IOException, URISyntaxException {
		OEmbed e = provider.resolve("http://bit.ly/cXVifg");
		assertEquals("Old Spice", e.getAuthorName());
		assertEquals("https://www.youtube.com/user/OldSpice", e.getAuthorUrl());
		assertEquals("https://www.youtube.com/", e.getProviderUrl());
		assertEquals("video", e.getType());
		System.out.println(e);
		assertNotNull(e.getHtml());
	}

	@Ignore
	@Test
	public void yfrog() throws IOException, URISyntaxException {
		OEmbed e = provider.resolve("http://yfrog.com/ng41306327j");
		assertEquals("http://a.yfrog.com/img844/1410/41306327.jpg", e.getThumbnailUrl());
		assertEquals("http://yfrog.com", e.getProviderUrl());
		assertEquals("photo", e.getType());
		assertNotNull(e.getUrl());
	}

	private OEmbedProvider provider = new EmbedlyProvider("<enter your API key>");
}
