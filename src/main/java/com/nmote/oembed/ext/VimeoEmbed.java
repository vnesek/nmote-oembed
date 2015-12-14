/*
 * Copyright (c) Nmote Ltd. 2015. All rights reserved.
 * See LICENSE doc in a root of project folder for additional information.
 */

package com.nmote.oembed.ext;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nmote.oembed.About;
import com.nmote.oembed.BasicOEmbed;

public class VimeoEmbed extends BasicOEmbed {

	private static final long serialVersionUID = About.SERIAL_VERSION_UID;

	@JsonProperty("duration")
	private Float duration;

	@JsonProperty("is_plus")
	private Integer isPlus;

	@JsonProperty("uri")
	private String uri;

	@JsonProperty("video_id")
	private String videoId;

}
