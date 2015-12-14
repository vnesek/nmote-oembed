package com.nmote.oembed.ext;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nmote.oembed.About;
import com.nmote.oembed.BasicOEmbed;

public class SapoVideosEmbed extends BasicOEmbed {

	private static final long serialVersionUID = About.SERIAL_VERSION_UID;

	@JsonProperty("synopse")
	public String getSynopse() {
		return super.getDescription();
	}

	public void setSynopse(String videoDescription) {
		super.setDescription(videoDescription);
	}

	@JsonProperty("hd")
	private boolean hd;
}
