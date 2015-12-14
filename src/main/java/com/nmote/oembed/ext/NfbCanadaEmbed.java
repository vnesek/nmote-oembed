package com.nmote.oembed.ext;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nmote.oembed.About;
import com.nmote.oembed.BasicOEmbed;

public class NfbCanadaEmbed extends BasicOEmbed {

	private static final long serialVersionUID = About.SERIAL_VERSION_UID;

	@JsonProperty("video_description")
	public String getVideoDescription() {
		return super.getDescription();
	}

	public void setVideoDescription(String videoDescription) {
		super.setDescription(videoDescription);
	}

}
