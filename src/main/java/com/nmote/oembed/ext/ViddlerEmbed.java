package com.nmote.oembed.ext;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nmote.oembed.About;
import com.nmote.oembed.BasicOEmbed;

public class ViddlerEmbed extends BasicOEmbed {

	private static final long serialVersionUID = About.SERIAL_VERSION_UID;

	@JsonProperty("author_name ")
	public String getAuthorNameBroken() {
		return super.getAuthorName();
	}

	@JsonProperty("author_name ")
	public void setAuthorNameBroken(String authorName) {
		super.setAuthorName(authorName);
	}
}
