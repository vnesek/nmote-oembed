/*
 * Copyright (c) Nmote Ltd. 2015. All rights reserved.
 * See LICENSE doc in a root of project folder for additional information.
 */

package com.nmote.oembed.ext;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nmote.oembed.About;
import com.nmote.oembed.BasicOEmbed;

/**
 * AmCharts oEmbed extension.
 *
 * @author vnesek
 */
public class AmChartsEmbed extends BasicOEmbed {

	private static final long serialVersionUID = About.SERIAL_VERSION_UID;

	/**
	 * Getter for extension property.
	 *
	 * @return property value
	 */
	public String getCanonical() {
		return canonical;
	}

	/**
	 * Setter for extension property.
	 *
	 * @param canonical
	 *            property value
	 */
	public void setCanonical(String canonical) {
		this.canonical = canonical;
	}

	/** Canonical URL */
	@JsonProperty("canonical")
	private String canonical;
}
