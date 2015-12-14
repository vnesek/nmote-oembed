/*
 * Copyright (c) Nmote Ltd. 2015. All rights reserved.
 * See LICENSE doc in a root of project folder for additional information.
 */

package com.nmote.oembed.ext;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nmote.oembed.About;
import com.nmote.oembed.BasicOEmbed;

public class SlideShareEmbed extends BasicOEmbed {

	private static final long serialVersionUID = About.SERIAL_VERSION_UID;

	public Integer getConversionVersion() {
		return conversionVersion;
	}

	public String getSlideImageBaseUrl() {
		return slideImageBaseUrl;
	}

	public String getSlideImageBaseUrlSuffix() {
		return slideImageBaseUrlSuffix;
	}

	public Integer getSlideshowId() {
		return slideshowId;
	}

	@JsonProperty("thumbnail")
	public String getThumbnail() {
		return super.getThumbnailUrl();
	}

	public Integer getTotalSlides() {
		return totalSlides;
	}

	public String getVersionNo() {
		return versionNo;
	}

	public void setConversionVersion(Integer conversionVersion) {
		this.conversionVersion = conversionVersion;
	}

	public void setSlideImageBaseUrl(String slideImageBaseUrl) {
		this.slideImageBaseUrl = slideImageBaseUrl;
	}

	public void setSlideImageBaseUrlSuffix(String slideImageBaseUrlSuffix) {
		this.slideImageBaseUrlSuffix = slideImageBaseUrlSuffix;
	}

	public void setSlideshowId(Integer slideshowId) {
		this.slideshowId = slideshowId;
	}

	public void setThumbnail(String thumbnailUrl) {
		super.setThumbnailUrl(thumbnailUrl);
	}

	public void setTotalSlides(Integer totalSlides) {
		this.totalSlides = totalSlides;
	}

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
