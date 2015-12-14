/*
 * Copyright (c) Nmote Ltd. 2015. All rights reserved.
 * See LICENSE doc in a root of project folder for additional information.
 */

package com.nmote.oembed.ext;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nmote.oembed.About;
import com.nmote.oembed.BasicOEmbed;

/**
 * MobyPicture oEmbed extension.
 *
 * @author vnesek
 */
public class MobyPictureEmbed extends BasicOEmbed {

	private static final long serialVersionUID = About.SERIAL_VERSION_UID;

	/**
	 * Getter for provider name.
	 *
	 * @return property value
	 */
	@JsonProperty("provider")
	public String getProvider() {
		return super.getProviderName();
	}

	/**
	 * Setter for provider name
	 *
	 * @param providerName
	 *            property value
	 */
	public void setProvider(String providerName) {
		super.setProviderName(providerName);
	}
}
