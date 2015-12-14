/*
 * Copyright (c) Nmote Ltd. 2015. All rights reserved.
 * See LICENSE doc in a root of project folder for additional information.
 */

package com.nmote.oembed.noembed;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nmote.oembed.About;
import com.nmote.oembed.BasicOEmbed;

public class NoembedEmbed extends BasicOEmbed {

	private static final long serialVersionUID = About.SERIAL_VERSION_UID;

	/**
	 * Getter for extension property.
	 *
	 * @return property value
	 */
	public String getMediaUrl() {
		return mediaUrl;
	}

	/**
	 * @see com.nmote.oembed.BasicOEmbed#getThumbnailUrl()
	 */
	@Override
	public String getThumbnailUrl() {
		String result = super.getThumbnailUrl();
		if (result == null) {
			result = mediaUrl;
		}
		return result;
	}

	/**
	 * Setter for extension property.
	 *
	 * @param mediaUrl
	 *            property value
	 */
	public void setMediaUrl(String mediaUrl) {
		this.mediaUrl = mediaUrl;
	}

	@JsonProperty("error")
	String error;

	@JsonProperty("media_url")
	String mediaUrl;
}