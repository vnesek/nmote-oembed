/*
 * Copyright (c) Nmote Ltd. 2015. All rights reserved.
 * See LICENSE doc in a root of project folder for additional information.
 */

package com.nmote.oembed.ext;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nmote.oembed.About;

/**
 * GeoGraph oEmbed extension.
 *
 * @author vnesek
 */
public class GeoGraphEmbed extends WebPageAndLicenseEmbed {

	private static final long serialVersionUID = About.SERIAL_VERSION_UID;

	/**
	 * Getter for extension property.
	 *
	 * @return property value
	 */
	public Object getGeo() {
		return geo;
	}

	/**
	 * Setter for extension property.
	 *
	 * @param geo
	 *            property value
	 */
	public void setGeo(Object geo) {
		this.geo = geo;
	}

	@JsonProperty("geo")
	private Object geo;
}
