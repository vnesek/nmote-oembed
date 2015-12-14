/*
 * Copyright (c) Nmote Ltd. 2015. All rights reserved.
 * See LICENSE doc in a root of project folder for additional information.
 */

package com.nmote.oembed;

import java.io.IOException;

/**
 * Provides oEmbed data from resource URL.
 *
 * @author vnesek
 */
public interface OEmbedProvider {

	/**
	 * Resolves oEmbed data from passed resource URL.
	 *
	 * @param url
	 *            resource URL
	 * @param maxSize
	 *            optional width and height in px
	 * @return oEmbed instance
	 * @throws IOException
	 *             if oEmbed data can't be resolved
	 */
	OEmbed resolve(String url, Integer... maxSize) throws IOException;
}
