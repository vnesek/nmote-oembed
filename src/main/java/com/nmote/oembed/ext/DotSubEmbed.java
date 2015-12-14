package com.nmote.oembed.ext;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nmote.oembed.About;
import com.nmote.oembed.BasicOEmbed;

public class DotSubEmbed extends BasicOEmbed {

	private static final long serialVersionUID = About.SERIAL_VERSION_UID;

	@JsonProperty("thumbnail_wigth")
	public Integer getThumbnailWight() {
		return super.getThumbnailWidth();
	}

	public void setThumbnailWight(Integer width) {
		super.setThumbnailWidth(width);
	}
}
