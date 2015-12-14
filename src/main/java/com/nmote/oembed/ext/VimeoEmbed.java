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

	public Float getDuration() {
		return duration;
	}

	public Integer getIsPlus() {
		return isPlus;
	}

	public String getUri() {
		return uri;
	}

	public String getVideoId() {
		return videoId;
	}

	public void setDuration(Float duration) {
		this.duration = duration;
	}

	public void setIsPlus(Integer isPlus) {
		this.isPlus = isPlus;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public void setVideoId(String videoId) {
		this.videoId = videoId;
	}

	@JsonProperty("duration")
	private Float duration;

	@JsonProperty("is_plus")
	private Integer isPlus;

	@JsonProperty("uri")
	private String uri;

	@JsonProperty("video_id")
	private String videoId;

}
