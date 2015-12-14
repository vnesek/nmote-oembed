/*
 * Copyright (c) Nmote Ltd. 2015. All rights reserved.
 * See LICENSE doc in a root of project folder for additional information.
 */

package com.nmote.oembed;

/**
 * OEmbed instance. Returned by {@link OEmbedProvider} from passed resource URL.
 *
 * @author vnesek
 */
public interface OEmbed {

	/**
	 * Standard oEmbed types.
	 */
	public interface Type {
		String LINK = "link";
		String PHOTO = "photo";
		String RICH = "rich";
		String VIDEO = "video";
	}

	/**
	 * The name of the author/owner of the resource.
	 *
	 * @return author name
	 */
	String getAuthorName();

	/**
	 * A URL for the author/owner of the resource.
	 *
	 * @return author url
	 */
	String getAuthorUrl();

	/**
	 * The suggested cache lifetime for this resource, in seconds. Consumers may
	 * choose to ignore this value.
	 *
	 * @return cache age in seconds
	 */
	Long getCacheAge();

	/**
	 * Description
	 *
	 * @return description
	 */
	String getDescription();

	/**
	 * The height in pixels of the image specified in the url parameter.
	 *
	 * @return height in px
	 */
	Integer getHeight();

	/**
	 * The HTML required to embed a video player. The HTML should have no
	 * padding or margins. Consumers may wish to load the HTML in an off-domain
	 * iframe to avoid XSS vulnerabilities.
	 *
	 * @return HTML content
	 */
	String getHtml();

	/**
	 * The name of the resource provider.
	 *
	 * @return provider name
	 */
	String getProviderName();

	/**
	 * The url of the resource provider.
	 *
	 * @return provider url
	 */
	String getProviderUrl();

	/**
	 * The height of the optional thumbnail. If this parameter is present,
	 * thumbnail_url and thumbnail_width must also be present.
	 *
	 * @return height in px
	 */
	Integer getThumbnailHeight();

	/**
	 * A URL to a thumbnail image representing the resource. The thumbnail must
	 * respect any maxwidth and maxheight parameters. If this parameter is
	 * present, thumbnail_width and thumbnail_height must also be present.
	 *
	 * @return url
	 */
	String getThumbnailUrl();

	/**
	 * The width of the optional thumbnail. If this parameter is present,
	 * thumbnail_url and thumbnail_height must also be present.
	 *
	 * @return width in px
	 */
	Integer getThumbnailWidth();

	/**
	 * A text title describing the resource.
	 *
	 * @return title
	 */
	String getTitle();

	/**
	 * The resource type. Valid values, along with value-specific parameters are
	 * described below.
	 *
	 * @return type
	 */
	String getType();

	/**
	 * The source URL of the image. Consumers should be able to insert this URL
	 * into an &lt;img&gt; element. Only HTTP and HTTPS URLs are valid.
	 *
	 * @return url
	 */
	String getUrl();

	/**
	 * The oEmbed version number. This must be 1.0.
	 *
	 * @return version
	 */
	String getVersion();

	/**
	 * The width in pixels of the image specified in the url parameter.
	 *
	 * @return width in px
	 */
	Integer getWidth();

	/**
	 * Returns true if oEmbed has description.
	 *
	 * @return true if oEmbed has description
	 */
	boolean hasDescription();

	/**
	 * Returns true if oEmbed has html.
	 *
	 * @return true if oEmbed has html
	 */
	boolean hasHtml();

	/**
	 * Returns true if oEmbed has thumbnail.
	 *
	 * @return true if oEmbed has thumbnail
	 */
	boolean hasThumbnail();

	/**
	 * Returns true if oEmbed has title.
	 *
	 * @return true if oEmbed has title
	 */
	boolean hasTitle();

}