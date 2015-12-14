/*
 * Copyright (c) Nmote Ltd. 2015. All rights reserved.
 * See LICENSE doc in a root of project folder for additional information.
 */

package com.nmote.oembed.ext;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.nmote.oembed.About;
import com.nmote.oembed.BasicOEmbed;

@JsonIgnoreProperties({ "https" })
public class CollegeHumorEmbed extends BasicOEmbed {

	private static final long serialVersionUID = About.SERIAL_VERSION_UID;
}
