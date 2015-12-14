package com.nmote.oembed;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

// Comment out ignore properties to catch provider extensions!
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

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public void setAuthorUrl(String authorUrl) {
		this.authorUrl = authorUrl;
	}

	public void setCacheAge(Long cacheAge) {
		this.cacheAge = cacheAge;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setFaviconUrl(String faviconUrl) {
		this.faviconUrl = faviconUrl;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public void setHtml(String html) {
		this.html = html;
	}

	public void setPingbackUrl(String pingbackUrl) {
		this.pingbackUrl = pingbackUrl;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	public void setProviderUrl(String providerUrl) {
		this.providerUrl = providerUrl;
	}

	public void setThumbnailHeight(Integer thumbnailHeight) {
		this.thumbnailHeight = thumbnailHeight;
	}

	public void setThumbnailUrl(String thumbnailUrl) {
		this.thumbnailUrl = thumbnailUrl;
	}

	public void setThumbnailWidth(Integer thumbnailWidth) {
		this.thumbnailWidth = thumbnailWidth;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public void setWebmentionUrl(String webmentionUrl) {
		this.webmentionUrl = webmentionUrl;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

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