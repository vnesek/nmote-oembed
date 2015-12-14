package com.nmote.oembed.ext;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nmote.oembed.About;
import com.nmote.oembed.BasicOEmbed;

public class AnimotoEmbed extends BasicOEmbed {

	private static final long serialVersionUID = About.SERIAL_VERSION_UID;

	@JsonProperty("icon_width")
	private Integer icon_width;

	@JsonProperty("icon_height")
	private Integer iconHeight;

	@JsonProperty("icon_url")
	private String iconUrl;

	@JsonProperty("video_url")
	private String videoUrl;

}
