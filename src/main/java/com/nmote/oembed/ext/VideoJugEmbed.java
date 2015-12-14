/*
 * Copyright (c) Nmote Ltd. 2015. All rights reserved.
 * See LICENSE doc in a root of project folder for additional information.
 */

package com.nmote.oembed.ext;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nmote.oembed.About;
import com.nmote.oembed.BasicOEmbed;

/**
 * VideoJug oEmbed extension.
 *
 * @author vnesek
 */
public class VideoJugEmbed extends BasicOEmbed {

	private static final long serialVersionUID = About.SERIAL_VERSION_UID;

	/**
	 * Getter for extension property.
	 *
	 * @return property value
	 */
	public String getId() {
		return id;
	}

	/**
	 * Setter for extension property.
	 *
	 * @param id
	 *            property value
	 */
	public void setId(String id) {
		this.id = id;
	}

	@JsonProperty("id")
	private String id;
}
