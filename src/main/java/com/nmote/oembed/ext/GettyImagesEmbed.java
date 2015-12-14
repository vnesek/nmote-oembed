package com.nmote.oembed.ext;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nmote.oembed.About;
import com.nmote.oembed.BasicOEmbed;

public class GettyImagesEmbed extends BasicOEmbed {

	private static final long serialVersionUID = About.SERIAL_VERSION_UID;

	@JsonProperty("caption")
	public String getCaption() {
		return super.getDescription();
	}

	@JsonProperty("photographer")
	public String getPhotographer() {
		return super.getAuthorName();
	}

	public void setCaption(String description) {
		super.setDescription(description);
	}

	public void setPhotographer(String photographer) {
		super.setAuthorName(photographer);
	}

	@JsonProperty("collection")
	private String collection;

	@JsonProperty("terms_of_use_url")
	private String termsOfUseUrl;
}
