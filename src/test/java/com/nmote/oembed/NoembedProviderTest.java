package com.nmote.oembed;

import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.Ignore;
import org.junit.Test;

import com.nmote.oembed.OEmbed;
import com.nmote.oembed.OEmbedProvider;
import com.nmote.oembed.noembed.NoembedProvider;

import static org.junit.Assert.*;

public class NoembedProviderTest {

	@Ignore // Network access
	@Test(expected = IOException.class)
	public void instantcom() throws IOException, URISyntaxException {
		provider.resolve("http://www.instantcom.net");
	}

	@Test
	@Ignore
	public void yfrog() throws IOException, URISyntaxException {
		OEmbed e = provider.resolve("http://yfrog.com/ng41306327j");
		assertEquals("YFrog", e.getProviderName());
		assertEquals("photo", e.getType());
		assertNotNull(e.getUrl());
		assertNotNull(e.getHtml());
	}

	private OEmbedProvider provider = new NoembedProvider();
}
