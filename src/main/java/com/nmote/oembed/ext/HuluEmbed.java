/*
 * Copyright (c) Nmote Ltd. 2015. All rights reserved.
 * See LICENSE doc in a root of project folder for additional information.
 */

package com.nmote.oembed.ext;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nmote.oembed.About;
import com.nmote.oembed.BasicOEmbed;

/**
 * Hulu oEmbed extension.
 *
 * @author vnesek
 */
public class HuluEmbed extends BasicOEmbed {

	private static final long serialVersionUID = About.SERIAL_VERSION_UID;

	/**
	 * Getter for extension property.
	 *
	 * @return property value
	 */
	public String getAirDate() {
		return airDate;
	}

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
	public String getEmbedUrl() {
		return embedUrl;
	}

	/**
	 * Getter for extension property.
	 *
	 * @return property value
	 */
	public Integer getLargeThumbnailHeight() {
		return largeThumbnailHeight;
	}

	/**
	 * Getter for extension property.
	 *
	 * @return property value
	 */
	public String getLargeThumbnailUrl() {
		return largeThumbnailUrl;
	}

	/**
	 * Getter for extension property.
	 *
	 * @return property value
	 */
	public Integer getLargeThumbnailWidth() {
		return largeThumbnailWidth;
	}

	/**
	 * Setter for extension property.
	 *
	 * @param airDate
	 *            property value
	 */
	public void setAirDate(String airDate) {
		this.airDate = airDate;
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
	 * @param embedUrl
	 *            property value
	 */
	public void setEmbedUrl(String embedUrl) {
		this.embedUrl = embedUrl;
	}

	/**
	 * Setter for extension property.
	 *
	 * @param largeThumbnailHeight
	 *            property value
	 */
	public void setLargeThumbnailHeight(Integer largeThumbnailHeight) {
		this.largeThumbnailHeight = largeThumbnailHeight;
	}

	/**
	 * Setter for extension property.
	 *
	 * @param largeThumbnailUrl
	 *            property value
	 */
	public void setLargeThumbnailUrl(String largeThumbnailUrl) {
		this.largeThumbnailUrl = largeThumbnailUrl;
	}

	/**
	 * Setter for extension property.
	 *
	 * @param largeThumbnailWidth
	 *            property value
	 */
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
