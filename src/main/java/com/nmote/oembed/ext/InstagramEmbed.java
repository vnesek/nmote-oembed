/*
 * Copyright (c) Nmote Ltd. 2015. All rights reserved.
 * See LICENSE doc in a root of project folder for additional information.
 */

package com.nmote.oembed.ext;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nmote.oembed.About;
import com.nmote.oembed.BasicOEmbed;

/**
 * Instagram oEmbed extension.
 *
 * @author vnesek
 */
public class InstagramEmbed extends BasicOEmbed {

	private static final long serialVersionUID = About.SERIAL_VERSION_UID;

	/**
	 * Getter for extension property.
	 *
	 * @return property value
	 */
	public String getAuthorId() {
		return authorId;
	}

	/**
	 * Getter for extension property.
	 *
	 * @return property value
	 */
	public String getMediaId() {
		return mediaId;
	}

	/**
	 * Setter for extension property.
	 *
	 * @param authorId
	 *            property value
	 */
	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}

	/**
	 * Setter for extension property.
	 *
	 * @param mediaId
	 *            property value
	 */
	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	@JsonProperty("author_id")
	private String authorId;

	@JsonProperty("media_id")
	private String mediaId;
}
