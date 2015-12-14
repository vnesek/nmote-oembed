/*
 * Copyright (c) Nmote Ltd. 2015. All rights reserved.
 * See LICENSE doc in a root of project folder for additional information.
 */

package com.nmote.oembed.ext;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nmote.oembed.About;
import com.nmote.oembed.BasicOEmbed;

/**
 * Viddler oEmbed extension.
 *
 * @author vnesek
 */
public class ViddlerEmbed extends BasicOEmbed {

	private static final long serialVersionUID = About.SERIAL_VERSION_UID;

	/**
	 * Getter for author name
	 *
	 * @return property value
	 */
	@JsonProperty("author_name ")
	public String getAuthorNameBroken() {
		return super.getAuthorName();
	}

	/**
	 * Setter for author name
	 *
	 * @param authorName
	 *            property value
	 */
	public void setAuthorNameBroken(String authorName) {
		super.setAuthorName(authorName);
	}
}
