/*
 * Copyright (c) Nmote Ltd. 2015. All rights reserved.
 * See LICENSE doc in a root of project folder for additional information.
 */

package com.nmote.oembed.ext;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nmote.oembed.About;
import com.nmote.oembed.BasicOEmbed;

public class WebPageAndLicenseEmbed extends BasicOEmbed {

	private static final long serialVersionUID = About.SERIAL_VERSION_UID;

	public String getLicense() {
		return license;
	}

	public String getLicenseId() {
		return licenseId;
	}

	public String getLicenseUrl() {
		return licenseUrl;
	}

	public String getWebPage() {
		return webPage;
	}

	public String getWebPageShortUrl() {
		return webPageShortUrl;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	public void setLicenseId(String licenseId) {
		this.licenseId = licenseId;
	}

	public void setLicenseUrl(String licenseUrl) {
		this.licenseUrl = licenseUrl;
	}

	public void setWebPage(String webPage) {
		this.webPage = webPage;
	}

	public void setWebPageShortUrl(String webPageShortUrl) {
		this.webPageShortUrl = webPageShortUrl;
	}

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
