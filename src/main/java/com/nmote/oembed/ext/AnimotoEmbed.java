/*
 * Copyright (c) Nmote Ltd. 2015. All rights reserved.
 * See LICENSE doc in a root of project folder for additional information.
 */

package com.nmote.oembed.ext;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nmote.oembed.About;
import com.nmote.oembed.BasicOEmbed;

public class AnimotoEmbed extends BasicOEmbed {

	private static final long serialVersionUID = About.SERIAL_VERSION_UID;

	public Integer getIconWidth() {
		return iconWidth;
	}

	public Integer getIconHeight() {
		return iconHeight;
	}

	public String getIconUrl() {
		return iconUrl;
	}

	public String getVideoUrl() {
		return videoUrl;
	}

	public void setIconWidth(Integer icon_width) {
		this.iconWidth = icon_width;
	}

	public void setIconHeight(Integer iconHeight) {
		this.iconHeight = iconHeight;
	}

	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}

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
