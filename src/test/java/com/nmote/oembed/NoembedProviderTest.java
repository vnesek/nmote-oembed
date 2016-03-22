/*
 * Copyright (c) Nmote Ltd. 2015. All rights reserved.
 * See LICENSE doc in a root of project folder for additional information.
 */

package com.nmote.oembed;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Ignore;
import org.junit.Test;

import com.nmote.oembed.noembed.NoembedProvider;

public class NoembedProviderTest {

    @Ignore // Network access
    @Test(expected = IOException.class)
    public void instantcom() throws IOException {
        provider.resolve("http://www.instantcom.net");
    }

    @Test
    @Ignore
    public void yfrog() throws IOException {
        OEmbed e = provider.resolve("http://yfrog.com/ng41306327j");
        assertEquals("YFrog", e.getProviderName());
        assertEquals("photo", e.getType());
        assertNotNull(e.getUrl());
        assertNotNull(e.getHtml());
    }

    private OEmbedProvider provider = new NoembedProvider();
}
