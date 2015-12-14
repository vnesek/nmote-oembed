/*
 * Copyright (c) Nmote Ltd. 2015. All rights reserved.
 * See LICENSE doc in a root of project folder for additional information.
 */

package com.nmote.oembed.ext;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nmote.oembed.About;
import com.nmote.oembed.BasicOEmbed;

/**
 * Vimeo oEmbed extension.
 *
 * @author vnesek
 */
public class VimeoEmbed extends BasicOEmbed {

	private static final long serialVersionUID = About.SERIAL_VERSION_UID;

	/**
	 * Getter for extension property.
	 *
	 * @return property value
	 */
	public Float getDuration() {
		return duration;
	}

	/**
	 * Getter for extension property.
	 *
	 * @return property value
	 */
	public Integer getIsPlus() {
		return isPlus;
	}

	/**
	 * Getter for extension property.
	 *
	 * @return property value
	 */
	public String getUri() {
		return uri;
	}

	/**
	 * Getter for extension property.
	 *
	 * @return property value
	 */
	public String getVideoId() {
		return videoId;
	}

	/**
	 * Setter for extension property.
	 *
	 * @param duration
	 *            property value
	 */
	public void setDuration(Float duration) {
		this.duration = duration;
	}

	/**
	 * Setter for extension property.
	 *
	 * @param isPlus
	 *            property value
	 */
	public void setIsPlus(Integer isPlus) {
		this.isPlus = isPlus;
	}

	/**
	 * Setter for extension property.
	 *
	 * @param uri
	 *            property value
	 */
	public void setUri(String uri) {
		this.uri = uri;
	}

	/**
	 * Setter for extension property.
	 *
	 * @param videoId
	 *            property value
	 */
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
