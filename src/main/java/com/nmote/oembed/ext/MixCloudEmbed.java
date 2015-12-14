/*
 * Copyright (c) Nmote Ltd. 2015. All rights reserved.
 * See LICENSE doc in a root of project folder for additional information.
 */

package com.nmote.oembed.ext;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nmote.oembed.About;
import com.nmote.oembed.BasicOEmbed;

/**
 * Mix Club oEmbed extension.
 *
 * @author vnesek
 */
@JsonIgnoreProperties("embed")
public class MixCloudEmbed extends BasicOEmbed {

	private static final long serialVersionUID = About.SERIAL_VERSION_UID;

	/**
	 * Getter for extension property.
	 *
	 * @return property value
	 */
	public String getImageUrl() {
		return imageUrl;
	}

	/**
	 * Setter for extension property.
	 *
	 * @param imageUrl
	 *            property value
	 */
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@JsonProperty("image")
	private String imageUrl;

}
