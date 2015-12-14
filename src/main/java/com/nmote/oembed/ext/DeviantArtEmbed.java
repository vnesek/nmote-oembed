/*
 * Copyright (c) Nmote Ltd. 2015. All rights reserved.
 * See LICENSE doc in a root of project folder for additional information.
 */

package com.nmote.oembed.ext;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nmote.oembed.About;
import com.nmote.oembed.BasicOEmbed;

/**
 * DeviantArt oEmbed extension.
 *
 * @author vnesek
 */
public class DeviantArtEmbed extends BasicOEmbed {

	private static final long serialVersionUID = About.SERIAL_VERSION_UID;

	/**
	 * Getter for extension property.
	 *
	 * @return property value
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * Getter for extension property.
	 *
	 * @return property value
	 */
	public Integer getThumbnailHeight200h() {
		return thumbnailHeight200h;
	}

	/**
	 * Getter for extension property.
	 *
	 * @return property value
	 */
	public String getThumbnailUrl150() {
		return thumbnailUrl150;
	}

	/**
	 * Getter for extension property.
	 *
	 * @return property value
	 */
	public String getThumbnailUrl200h() {
		return thumbnailUrl200h;
	}

	/**
	 * Getter for extension property.
	 *
	 * @return property value
	 */
	public Integer getThumbnailWidth200h() {
		return thumbnailWidth200h;
	}

	/**
	 * Setter for extension property.
	 *
	 * @param category
	 *            property value
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * Setter for extension property.
	 *
	 * @param thumbnailHeight200h
	 *            property value
	 */
	public void setThumbnailHeight200h(Integer thumbnailHeight200h) {
		this.thumbnailHeight200h = thumbnailHeight200h;
	}

	/**
	 * Setter for extension property.
	 *
	 * @param thumbnailUrl150
	 *            property value
	 */
	public void setThumbnailUrl150(String thumbnailUrl150) {
		this.thumbnailUrl150 = thumbnailUrl150;
	}

	/**
	 * Setter for extension property.
	 *
	 * @param thumbnailUrl200h
	 *            property value
	 */
	public void setThumbnailUrl200h(String thumbnailUrl200h) {
		this.thumbnailUrl200h = thumbnailUrl200h;
	}

	/**
	 * Setter for extension property.
	 *
	 * @param thumbnailWidth200h
	 *            property value
	 */
	public void setThumbnailWidth200h(Integer thumbnailWidth200h) {
		this.thumbnailWidth200h = thumbnailWidth200h;
	}

	@JsonProperty("category")
	private String category;

	@JsonProperty("thumbnail_height_200h")
	private Integer thumbnailHeight200h;

	@JsonProperty("thumbnail_url_150")
	private String thumbnailUrl150;

	@JsonProperty("thumbnail_url_200h")
	private String thumbnailUrl200h;

	@JsonProperty("thumbnail_width_200h")
	private Integer thumbnailWidth200h;
}
