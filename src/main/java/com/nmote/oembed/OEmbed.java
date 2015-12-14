package com.nmote.oembed;

public interface OEmbed {

	public interface Type {
		String LINK = "link";
		String PHOTO = "photo";
		String RICH = "rich";
		String VIDEO = "video";
	}

	/** The name of the author/owner of the resource. */
	String getAuthorName();

	/** A URL for the author/owner of the resource. */
	String getAuthorUrl();

	/**
	 * The suggested cache lifetime for this resource, in seconds. Consumers may
	 * choose to ignore this value.
	 */
	Long getCacheAge();

	String getDescription();

	/** The height in pixels of the image specified in the url parameter. */
	Integer getHeight();

	/**
	 * The HTML required to embed a video player. The HTML should have no
	 * padding or margins. Consumers may wish to load the HTML in an off-domain
	 * iframe to avoid XSS vulnerabilities.
	 */
	String getHtml();

	/** The name of the resource provider. */
	String getProviderName();

	/** The url of the resource provider. */
	String getProviderUrl();

	/**
	 * The height of the optional thumbnail. If this parameter is present,
	 * thumbnail_url and thumbnail_width must also be present.
	 */
	Integer getThumbnailHeight();

	/**
	 * A URL to a thumbnail image representing the resource. The thumbnail must
	 * respect any maxwidth and maxheight parameters. If this parameter is
	 * present, thumbnail_width and thumbnail_height must also be present.
	 */
	String getThumbnailUrl();

	/**
	 * The width of the optional thumbnail. If this parameter is present,
	 * thumbnail_url and thumbnail_height must also be present.
	 */
	Integer getThumbnailWidth();

	/** A text title describing the resource. */
	String getTitle();

	/**
	 * The resource type. Valid values, along with value-specific parameters are
	 * described below.
	 */
	String getType();

	/**
	 * The source URL of the image. Consumers should be able to insert this URL
	 * into an <img> element. Only HTTP and HTTPS URLs are valid.
	 */
	String getUrl();

	/** The oEmbed version number. This must be 1.0. */

	String getVersion();

	/** The width in pixels of the image specified in the url parameter. */
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