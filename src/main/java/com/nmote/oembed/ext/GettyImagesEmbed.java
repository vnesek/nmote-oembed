/*
 * Copyright (c) Nmote Ltd. 2015. All rights reserved.
 * See LICENSE doc in a root of project folder for additional information.
 */

package com.nmote.oembed.ext;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nmote.oembed.About;
import com.nmote.oembed.BasicOEmbed;

/**
 * Getty Images oEmbed extension.
 *
 * @author vnesek
 */
public class GettyImagesEmbed extends BasicOEmbed {

	private static final long serialVersionUID = About.SERIAL_VERSION_UID;

	/**
	 * Getter for description.
	 *
	 * @return property value
	 */
	@JsonProperty("caption")
	public String getCaption() {
		return super.getDescription();
	}

	/**
	 * Getter for author name.
	 *
	 * @return property value
	 */
	@JsonProperty("photographer")
	public String getPhotographer() {
		return super.getAuthorName();
	}

	/**
	 * Setter for description.
	 *
	 * @param caption
	 *            property value
	 */
	public void setCaption(String caption) {
		super.setDescription(caption);
	}

	/**
	 * Setter for author name
	 *
	 * @param photographer
	 *            property value
	 */
	public void setPhotographer(String photographer) {
		super.setAuthorName(photographer);
	}

	@JsonProperty("collection")
	private String collection;

	@JsonProperty("terms_of_use_url")
	private String termsOfUseUrl;
}
