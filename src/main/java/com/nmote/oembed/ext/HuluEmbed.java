/*
 * Copyright (c) Nmote Ltd. 2015. All rights reserved.
 * See LICENSE doc in a root of project folder for additional information.
 */

package com.nmote.oembed.ext;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nmote.oembed.About;
import com.nmote.oembed.BasicOEmbed;

public class HuluEmbed extends BasicOEmbed {

	private static final long serialVersionUID = About.SERIAL_VERSION_UID;

	public String getAirDate() {
		return airDate;
	}

	public Float getDuration() {
		return duration;
	}

	public String getEmbedUrl() {
		return embedUrl;
	}

	public Integer getLargeThumbnailHeight() {
		return largeThumbnailHeight;
	}

	public String getLargeThumbnailUrl() {
		return largeThumbnailUrl;
	}

	public Integer getLargeThumbnailWidth() {
		return largeThumbnailWidth;
	}

	public void setAirDate(String airDate) {
		this.airDate = airDate;
	}

	public void setDuration(Float duration) {
		this.duration = duration;
	}

	public void setEmbedUrl(String embedUrl) {
		this.embedUrl = embedUrl;
	}

	public void setLargeThumbnailHeight(Integer largeThumbnailHeight) {
		this.largeThumbnailHeight = largeThumbnailHeight;
	}

	public void setLargeThumbnailUrl(String largeThumbnailUrl) {
		this.largeThumbnailUrl = largeThumbnailUrl;
	}

	public void setLargeThumbnailWidth(Integer largeThumbnailWidth) {
		this.largeThumbnailWidth = largeThumbnailWidth;
	}

	@JsonProperty("air_date")
	private String airDate;

	@JsonProperty("duration")
	private Float duration;

	@JsonProperty("embed_url")
	private String embedUrl;

	@JsonProperty("large_thumbnail_height")
	private Integer largeThumbnailHeight;

	@JsonProperty("large_thumbnail_url")
	private String largeThumbnailUrl;

	@JsonProperty("large_thumbnail_width")
	private Integer largeThumbnailWidth;

}
