/*
 * Copyright (c) Nmote Ltd. 2015. All rights reserved.
 * See LICENSE doc in a root of project folder for additional information.
 */

package com.nmote.oembed;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProviderEndpoint {

	public ProviderEndpoint(String url) {
		this(url, null);
	}

	public ProviderEndpoint(String url, Class<? extends BasicOEmbed> embedClass) {
		this(url, embedClass, Collections.<String> emptySet());
	}

	public ProviderEndpoint(String url, Class<? extends BasicOEmbed> embedClass, Set<String> schemes) {
		setUrl(url);
		this.embedClass = embedClass;
		setSchemes(schemes);
	}

	public ProviderEndpoint(String url, Class<? extends BasicOEmbed> embedClass, String... schemes) {
		this(url, embedClass, new HashSet<>(Arrays.asList(schemes)));
	}

	ProviderEndpoint() {
		this.schemes = Collections.emptySet();
	}

	@JsonProperty("embed_class")
	public String getEmbedClass() {
		return embedClass != null ? embedClass.getName() : null;
	}

	public Set<String> getFormats() {
		return formats;
	}

	public Set<String> getSchemes() {
		return schemes;
	}

	public String getUrl() {
		return url;
	}

	public boolean isDiscovery() {
		return discovery;
	}

	public void setDiscovery(boolean discovery) {
		this.discovery = discovery;
	}

	@SuppressWarnings("unchecked")
	public void setEmbedClass(String className) throws ClassNotFoundException {
		this.embedClass = (Class<? extends BasicOEmbed>) Class.forName(className);
	}

	public void setFormats(Set<String> formats) {
		this.formats = formats;
	}

	public void setSchemes(Set<String> schemes) {
		Objects.requireNonNull(schemes);
		this.schemes = schemes;
	}

	public void setUrl(String endpointUrl) {
		Objects.requireNonNull(endpointUrl);
		this.url = endpointUrl;
	}

	public String toString() {
		return ToJsonString.toJsonString(this);
	}

	Class<? extends BasicOEmbed> embedClass;

	@JsonProperty("discovery")
	private boolean discovery;

	@JsonProperty("formats")
	private Set<String> formats = Collections.singleton("json");

	@JsonProperty("schemes")
	private Set<String> schemes;

	@JsonProperty("url")
	private String url;
}
