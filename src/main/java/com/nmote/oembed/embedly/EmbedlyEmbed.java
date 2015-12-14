package com.nmote.oembed.embedly;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nmote.oembed.About;
import com.nmote.oembed.BasicOEmbed;

public class EmbedlyEmbed extends BasicOEmbed {

	private static final long serialVersionUID = About.SERIAL_VERSION_UID;

	/**
	 * Mean alpha of the alpha channel on the image, it can be used to detect
	 * for transparent images and logos.
	 *
	 * Embed.ly extension
	 */
	@JsonProperty("mean_alpha")
	private Float meanAlpha;

}