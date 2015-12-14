package com.nmote.oembed.noembed;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nmote.oembed.About;
import com.nmote.oembed.BasicOEmbed;

public class NoembedEmbed extends BasicOEmbed {

	private static final long serialVersionUID = About.SERIAL_VERSION_UID;

	@Override
	public String getThumbnailUrl() {
		String result = super.getThumbnailUrl();
		if (result == null) {
			result = mediaUrl;
		}
		return result;
	}

	@JsonProperty("error")
	String error;

	@JsonProperty("media_url")
	String mediaUrl;
}