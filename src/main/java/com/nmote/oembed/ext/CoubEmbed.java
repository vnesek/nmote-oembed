/*
 * Copyright (c) Nmote Ltd. 2015. All rights reserved.
 * See LICENSE doc in a root of project folder for additional information.
 */

package com.nmote.oembed.ext;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nmote.oembed.About;
import com.nmote.oembed.BasicOEmbed;

/**
 * Coub oEmbed extension.
 *
 * @author vnesek
 */
public class CoubEmbed extends BasicOEmbed {

	private static final long serialVersionUID = About.SERIAL_VERSION_UID;

	/**
	 * Getter for extension property.
	 *
	 * @return property value
	 */
	public String getChannelUrl() {
		return channelUrl;
	}

	/**
	 * Setter for extension property.
	 *
	 * @param channelUrl
	 *            property value
	 */
	public void setChannelUrl(String channelUrl) {
		this.channelUrl = channelUrl;
	}

	@JsonProperty("channel_url")
	private String channelUrl;
}
