/*
 * Copyright (c) Nmote Ltd. 2015. All rights reserved.
 * See LICENSE doc in a root of project folder for additional information.
 */

package com.nmote.oembed.ext;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nmote.oembed.About;
import com.nmote.oembed.BasicOEmbed;

/**
 * SlideShare oEmbed extension.
 *
 * @author vnesek
 */
public class SlideShareEmbed extends BasicOEmbed {

	private static final long serialVersionUID = About.SERIAL_VERSION_UID;

	/**
	 * Getter for extension property.
	 *
	 * @return property value
	 */
	public Integer getConversionVersion() {
		return conversionVersion;
	}

	/**
	 * Getter for extension property.
	 *
	 * @return property value
	 */
	public String getSlideImageBaseUrl() {
		return slideImageBaseUrl;
	}

	/**
	 * Getter for extension property.
	 *
	 * @return property value
	 */
	public String getSlideImageBaseUrlSuffix() {
		return slideImageBaseUrlSuffix;
	}

	/**
	 * Getter for extension property.
	 *
	 * @return property value
	 */
	public Integer getSlideshowId() {
		return slideshowId;
	}

	/**
	 * Getter for thumbnail URL.
	 *
	 * @return property value
	 */
	@JsonProperty("thumbnail")
	public String getThumbnail() {
		return super.getThumbnailUrl();
	}

	/**
	 * Getter for extension property.
	 *
	 * @return property value
	 */
	public Integer getTotalSlides() {
		return totalSlides;
	}

	/**
	 * Getter for extension property.
	 *
	 * @return property value
	 */
	public String getVersionNo() {
		return versionNo;
	}

	/**
	 * Setter for extension property.
	 *
	 * @param conversionVersion
	 *            property value
	 */
	public void setConversionVersion(Integer conversionVersion) {
		this.conversionVersion = conversionVersion;
	}

	/**
	 * Setter for extension property.
	 *
	 * @param slideImageBaseUrl
	 *            property value
	 */
	public void setSlideImageBaseUrl(String slideImageBaseUrl) {
		this.slideImageBaseUrl = slideImageBaseUrl;
	}

	/**
	 * Setter for extension property.
	 *
	 * @param slideImageBaseUrlSuffix
	 *            property value
	 */
	public void setSlideImageBaseUrlSuffix(String slideImageBaseUrlSuffix) {
		this.slideImageBaseUrlSuffix = slideImageBaseUrlSuffix;
	}

	/**
	 * Setter for extension property.
	 *
	 * @param slideshowId
	 *            property value
	 */
	public void setSlideshowId(Integer slideshowId) {
		this.slideshowId = slideshowId;
	}

	/**
	 * Setter for thumbnail url.
	 *
	 * @param thumbnailUrl
	 *            property value
	 */
	public void setThumbnail(String thumbnailUrl) {
		super.setThumbnailUrl(thumbnailUrl);
	}

	/**
	 * Setter for extension property.
	 *
	 * @param totalSlides
	 *            property value
	 */
	public void setTotalSlides(Integer totalSlides) {
		this.totalSlides = totalSlides;
	}

	/**
	 * Setter for extension property.
	 *
	 * @param versionNo
	 *            property value
	 */
	public void setVersionNo(String versionNo) {
		this.versionNo = versionNo;
	}

	@JsonProperty("conversion_version")
	private Integer conversionVersion;

	@JsonProperty("slide_image_baseurl")
	private String slideImageBaseUrl;

	@JsonProperty("slide_image_baseurl_suffix")
	private String slideImageBaseUrlSuffix;

	@JsonProperty("slideshow_id")
	private Integer slideshowId;

	@JsonProperty("total_slides")
	private Integer totalSlides;

	@JsonProperty("version_no")
	private String versionNo;
}
