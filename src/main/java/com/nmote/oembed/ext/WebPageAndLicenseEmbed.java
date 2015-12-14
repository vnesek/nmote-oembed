/*
 * Copyright (c) Nmote Ltd. 2015. All rights reserved.
 * See LICENSE doc in a root of project folder for additional information.
 */

package com.nmote.oembed.ext;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nmote.oembed.About;
import com.nmote.oembed.BasicOEmbed;

/**
 * Flickr and Croud Ratings oEmbed extension.
 *
 * @author vnesek
 */
public class WebPageAndLicenseEmbed extends BasicOEmbed {

	private static final long serialVersionUID = About.SERIAL_VERSION_UID;

	/**
	 * Getter for extension property.
	 *
	 * @return property value
	 */
	public String getLicense() {
		return license;
	}

	/**
	 * Getter for extension property.
	 *
	 * @return property value
	 */
	public String getLicenseId() {
		return licenseId;
	}

	/**
	 * Getter for extension property.
	 *
	 * @return property value
	 */
	public String getLicenseUrl() {
		return licenseUrl;
	}

	/**
	 * Getter for extension property.
	 *
	 * @return property value
	 */
	public String getWebPage() {
		return webPage;
	}

	/**
	 * Getter for extension property.
	 *
	 * @return property value
	 */
	public String getWebPageShortUrl() {
		return webPageShortUrl;
	}

	/**
	 * Setter for extension property.
	 *
	 * @param license
	 *            property value
	 */
	public void setLicense(String license) {
		this.license = license;
	}

	/**
	 * Setter for extension property.
	 *
	 * @param licenseId
	 *            property value
	 */
	public void setLicenseId(String licenseId) {
		this.licenseId = licenseId;
	}

	/**
	 * Setter for extension property.
	 *
	 * @param licenseUrl
	 *            property value
	 */
	public void setLicenseUrl(String licenseUrl) {
		this.licenseUrl = licenseUrl;
	}

	/**
	 * Setter for extension property.
	 *
	 * @param webPage
	 *            property value
	 */
	public void setWebPage(String webPage) {
		this.webPage = webPage;
	}

	/**
	 * Setter for extension property.
	 *
	 * @param webPageShortUrl
	 *            property value
	 */
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
