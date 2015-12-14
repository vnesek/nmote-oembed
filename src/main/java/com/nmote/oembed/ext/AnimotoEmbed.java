/*
 * Copyright (c) Nmote Ltd. 2015. All rights reserved.
 * See LICENSE doc in a root of project folder for additional information.
 */

package com.nmote.oembed.ext;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nmote.oembed.About;
import com.nmote.oembed.BasicOEmbed;

/**
 * Animoto oEmbed extension.
 *
 * @author vnesek
 */

public class AnimotoEmbed extends BasicOEmbed {

	private static final long serialVersionUID = About.SERIAL_VERSION_UID;

	/**
	 * Getter for extension property.
	 *
	 * @return property value
	 */
	public Integer getIconWidth() {
		return iconWidth;
	}

	/**
	 * Getter for extension property.
	 *
	 * @return property value
	 */
	public Integer getIconHeight() {
		return iconHeight;
	}

	/**
	 * Getter for extension property.
	 *
	 * @return property value
	 */
	public String getIconUrl() {
		return iconUrl;
	}

	/**
	 * Getter for extension property.
	 *
	 * @return property value
	 */
	public String getVideoUrl() {
		return videoUrl;
	}

	/**
	 * Setter for extension property.
	 *
	 * @param iconWidth
	 *            property value
	 */
	public void setIconWidth(Integer iconWidth) {
		this.iconWidth = iconWidth;
	}

	/**
	 * Setter for extension property.
	 *
	 * @param iconHeight
	 *            property value
	 */
	public void setIconHeight(Integer iconHeight) {
		this.iconHeight = iconHeight;
	}

	/**
	 * Setter for extension property.
	 *
	 * @param iconUrl
	 *            property value
	 */
	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}

	/**
	 * Setter for extension property.
	 *
	 * @param videoUrl
	 *            property value
	 */
	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	@JsonProperty("icon_width")
	private Integer iconWidth;

	@JsonProperty("icon_height")
	private Integer iconHeight;

	@JsonProperty("icon_url")
	private String iconUrl;

	@JsonProperty("video_url")
	private String videoUrl;

}
