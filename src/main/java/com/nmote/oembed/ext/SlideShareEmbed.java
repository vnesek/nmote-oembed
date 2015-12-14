package com.nmote.oembed.ext;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nmote.oembed.About;
import com.nmote.oembed.BasicOEmbed;

public class SlideShareEmbed extends BasicOEmbed {

	private static final long serialVersionUID = About.SERIAL_VERSION_UID;

	@JsonProperty("thumbnail")
	public String getThumbnail() {
		return super.getThumbnailUrl();
	}

	public void setThumbnail(String thumbnailUrl) {
		super.setThumbnailUrl(thumbnailUrl);
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
