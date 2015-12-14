/*
 * Copyright (c) Nmote Ltd. 2015. All rights reserved.
 * See LICENSE doc in a root of project folder for additional information.
 */

package com.nmote.oembed.ext;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nmote.oembed.About;
import com.nmote.oembed.BasicOEmbed;

public class DeviantArtEmbed extends BasicOEmbed {

	private static final long serialVersionUID = About.SERIAL_VERSION_UID;

	public String getCategory() {
		return category;
	}

	public Integer getThumbnailHeight200h() {
		return thumbnailHeight200h;
	}

	public String getThumbnailUrl150() {
		return thumbnailUrl150;
	}

	public String getThumbnailUrl200h() {
		return thumbnailUrl200h;
	}

	public Integer getThumbnailWidth200h() {
		return thumbnailWidth200h;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setThumbnailHeight200h(Integer thumbnailHeight200h) {
		this.thumbnailHeight200h = thumbnailHeight200h;
	}

	public void setThumbnailUrl150(String thumbnailUrl150) {
		this.thumbnailUrl150 = thumbnailUrl150;
	}

	public void setThumbnailUrl200h(String thumbnailUrl200h) {
		this.thumbnailUrl200h = thumbnailUrl200h;
	}

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
