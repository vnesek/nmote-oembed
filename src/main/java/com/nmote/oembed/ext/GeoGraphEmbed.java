/*
 * Copyright (c) Nmote Ltd. 2015. All rights reserved.
 * See LICENSE doc in a root of project folder for additional information.
 */

package com.nmote.oembed.ext;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nmote.oembed.About;

public class GeoGraphEmbed extends WebPageAndLicenseEmbed {

	private static final long serialVersionUID = About.SERIAL_VERSION_UID;

	public Object getGeo() {
		return geo;
	}

	public void setGeo(Object geo) {
		this.geo = geo;
	}

	@JsonProperty("geo")
	private Object geo;
}
