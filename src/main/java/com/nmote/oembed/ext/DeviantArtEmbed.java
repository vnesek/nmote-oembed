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
