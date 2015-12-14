/*
 * Copyright (c) Nmote Ltd. 2015. All rights reserved.
 * See LICENSE doc in a root of project folder for additional information.
 */

package com.nmote.oembed.ext;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nmote.oembed.About;
import com.nmote.oembed.BasicOEmbed;

/**
 * FunnyOrDie oEmbed extension.
 *
 * @author vnesek
 */
public class FunnyOrDieEmbed extends BasicOEmbed {

	private static final long serialVersionUID = About.SERIAL_VERSION_UID;

	/**
	 * Getter for extension property.
	 *
	 * @return property value
	 */
	public Float getDuration() {
		return duration;
	}

	/**
	 * Setter for extension property.
	 *
	 * @param duration
	 *            property value
	 */
	public void setDuration(Float duration) {
		this.duration = duration;
	}

	@JsonProperty("duration")
	private Float duration;

}
