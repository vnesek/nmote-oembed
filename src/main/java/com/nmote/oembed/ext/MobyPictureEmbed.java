package com.nmote.oembed.ext;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nmote.oembed.About;
import com.nmote.oembed.BasicOEmbed;

public class MobyPictureEmbed extends BasicOEmbed {

	private static final long serialVersionUID = About.SERIAL_VERSION_UID;

	@JsonProperty("provider")
	public String getProvider() {
		return super.getProviderName();
	}

	public void setProvider(String providerName) {
		super.setProviderName(providerName);
	}
}
