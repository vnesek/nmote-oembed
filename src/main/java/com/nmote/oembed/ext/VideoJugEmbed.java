package com.nmote.oembed.ext;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nmote.oembed.About;
import com.nmote.oembed.BasicOEmbed;

public class VideoJugEmbed extends BasicOEmbed {

	private static final long serialVersionUID = About.SERIAL_VERSION_UID;

	@JsonProperty("id")
	private String id;
}