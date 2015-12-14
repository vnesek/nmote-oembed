/*
 * Copyright (c) Nmote Ltd. 2015. All rights reserved.
 * See LICENSE doc in a root of project folder for additional information.
 */

package com.nmote.oembed;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

// Comment out ignore properties to catch provider extensions!
/**
 * Standard OEmbed implementation.
 *
 * @author vnesek
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BasicOEmbed implements OEmbed, Serializable, Favicon, Pingback, Webmention {

	private static final long serialVersionUID = About.SERIAL_VERSION_UID;

	@Override
	public String getAuthorName() {
		return authorName;
	}

	@Override
	public String getAuthorUrl() {
		return authorUrl;
	}

	@Override
	public Long getCacheAge() {
		return cacheAge;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public String getFaviconUrl() {
		return faviconUrl;
	}

	@Override
	public Integer getHeight() {
		return height;
	}

	@Override
	public String getHtml() {
		return html;
	}

	@Override
	public String getPingbackUrl() {
		return pingbackUrl;
	}

	@Override
	public String getProviderName() {
		return providerName;
	}

	@Override
	public String getProviderUrl() {
		return providerUrl;
	}

	@Override
	public Integer getThumbnailHeight() {
		return thumbnailHeight;
	}

	@Override
	public String getThumbnailUrl() {
		return thumbnailUrl;
	}

	@Override
	public Integer getThumbnailWidth() {
		return thumbnailWidth;
	}

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public String getType() {
		return type;
	}

	@Override
	public String getUrl() {
		return url;
	}

	@Override
	public String getVersion() {
		return version;
	}

	@Override
	public String getWebmentionUrl() {
		return webmentionUrl;
	}

	@Override
	public Integer getWidth() {
		return width;
	}

	@Override
	public boolean hasDescription() {
		return description != null;
	}

	@Override
	public boolean hasHtml() {
		return getHtml() != null;
	}

	@Override
	public boolean hasThumbnail() {
		return getThumbnailUrl() != null;
	}

	@Override
	public boolean hasTitle() {
		return title != null;
	}

	/**
	 * Set author name
	 *
	 * @param authorName
	 *            author name
	 */
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	/**
	 * Set author URL
	 *
	 * @param authorUrl
	 *            author URL
	 */
	public void setAuthorUrl(String authorUrl) {
		this.authorUrl = authorUrl;
	}

	/**
	 * Set cache age.
	 *
	 * @param cacheAge
	 *            cache age in seconds
	 */
	public void setCacheAge(Long cacheAge) {
		this.cacheAge = cacheAge;
	}

	/**
	 * Set description.
	 *
	 * @param description
	 *            description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Set favicon URL.
	 *
	 * @param faviconUrl
	 *            url
	 */
	public void setFaviconUrl(String faviconUrl) {
		this.faviconUrl = faviconUrl;
	}

	/**
	 * Set height in pixels.
	 *
	 * @param height
	 *            height in px
	 */
	public void setHeight(Integer height) {
		this.height = height;
	}

	/**
	 * Set HTML content.
	 *
	 * @param html
	 *            HTML content
	 */
	public void setHtml(String html) {
		this.html = html;
	}

	/**
	 * Set pingback URL.
	 *
	 * @param pingbackUrl
	 *            url
	 */
	public void setPingbackUrl(String pingbackUrl) {
		this.pingbackUrl = pingbackUrl;
	}

	/**
	 * Set oEmbed provider name.
	 *
	 * @param providerName
	 *            provider name
	 */
	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	/**
	 * Set oEmbed provider URL
	 *
	 * @param providerUrl
	 *            url
	 */
	public void setProviderUrl(String providerUrl) {
		this.providerUrl = providerUrl;
	}

	/**
	 * Set thumbnail height in pixels.
	 *
	 * @param thumbnailHeight
	 *            height in px
	 */
	public void setThumbnailHeight(Integer thumbnailHeight) {
		this.thumbnailHeight = thumbnailHeight;
	}

	/**
	 * Set thumbnail URL.
	 *
	 * @param thumbnailUrl
	 *            url
	 */
	public void setThumbnailUrl(String thumbnailUrl) {
		this.thumbnailUrl = thumbnailUrl;
	}

	/**
	 * Set thumbnail width in pixels
	 *
	 * @param thumbnailWidth
	 *            width in px.
	 */
	public void setThumbnailWidth(Integer thumbnailWidth) {
		this.thumbnailWidth = thumbnailWidth;
	}

	/**
	 * Set title
	 *
	 * @param title
	 *            title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Set oEmbed type.
	 *
	 * @param type
	 *            type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Set content URL.
	 *
	 * @param url
	 *            url
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * Set oEmbed version.
	 *
	 * @param version
	 *            oEmbed version
	 */
	public void setVersion(String version) {
		this.version = version;
	}

	/**
	 * Set webmention URL.
	 *
	 * @param webmentionUrl
	 *            callback url
	 */
	public void setWebmentionUrl(String webmentionUrl) {
		this.webmentionUrl = webmentionUrl;
	}

	/**
	 * Set width in pixels.
	 *
	 * @param width
	 *            width in px.
	 */
	public void setWidth(Integer width) {
		this.width = width;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ToJsonString.toJsonString(this);
	}

	@JsonProperty("author_name")
	private String authorName;

	@JsonProperty("author_url")
	private String authorUrl;

	@JsonProperty("cache_age")
	private Long cacheAge;

	private String description;

	@JsonProperty("favicon_url")
	private String faviconUrl;

	private Integer height;

	private String html;

	@JsonProperty("pingback_url")
	private String pingbackUrl;

	@JsonProperty("provider_name")
	private String providerName;

	@JsonProperty("provider_url")
	private String providerUrl;

	@JsonProperty("thumbnail_height")
	private Integer thumbnailHeight;

	@JsonProperty("thumbnail_url")
	private String thumbnailUrl;

	@JsonProperty("thumbnail_width")
	private Integer thumbnailWidth;

	private String title;

	private String type;

	private String url;

	private String version;

	@JsonProperty("webmention_url")
	private String webmentionUrl;

	private Integer width;
}