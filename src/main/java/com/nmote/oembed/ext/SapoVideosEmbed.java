/*
 * Copyright (c) Nmote Ltd. 2015. All rights reserved.
 * See LICENSE doc in a root of project folder for additional information.
 */

package com.nmote.oembed.ext;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nmote.oembed.About;
import com.nmote.oembed.BasicOEmbed;

/**
 * Sapo Videos oEmbed extension.
 *
 * @author vnesek
 */
public class SapoVideosEmbed extends BasicOEmbed {

	private static final long serialVersionUID = About.SERIAL_VERSION_UID;

	/**
	 * Getter for description.
	 *
	 * @return property value
	 */
	@JsonProperty("synopse")
	public String getSynopse() {
		return super.getDescription();
	}

	/**
	 * Getter for extension property.
	 *
	 * @return property value
	 */
	public boolean isHd() {
		return hd;
	}

	/**
	 * Setter for extension property.
	 *
	 * @param hd
	 *            property value
	 */
	public void setHd(boolean hd) {
		this.hd = hd;
	}

	/**
	 * Setter for description.
	 *
	 * @param videoDescription
	 *            property value
	 */
	public void setSynopse(String videoDescription) {
		super.setDescription(videoDescription);
	}

	@JsonProperty("hd")
	private boolean hd;
}
