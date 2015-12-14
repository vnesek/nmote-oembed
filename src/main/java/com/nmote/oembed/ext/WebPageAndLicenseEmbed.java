package com.nmote.oembed.ext;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nmote.oembed.About;
import com.nmote.oembed.BasicOEmbed;

public class WebPageAndLicenseEmbed extends BasicOEmbed {

	private static final long serialVersionUID = About.SERIAL_VERSION_UID;

	@JsonProperty("license")
	private String license;

	@JsonProperty("license_id")
	private String licenseId;

	@JsonProperty("license_url")
	private String licenseUrl;

	@JsonProperty("web_page")
	private String webPage;

	@JsonProperty("web_page_short_url")
	private String webPageShortUrl;
}
