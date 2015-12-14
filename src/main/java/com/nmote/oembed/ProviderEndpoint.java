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

/**
 * Provider metadata
 *
 * @author vnesek
 */
public class ProviderEndpoint {

	/**
	 * Constructs new ProviderEndpoint.
	 *
	 * @param url
	 *            provider endpoint URL
	 */
	public ProviderEndpoint(String url) {
		this(url, null);
	}

	/**
	 * Constructs new ProviderEndpoint.
	 *
	 * @param url
	 *            provider endpoint URL
	 * @param embedClass
	 *            {@link OEmbed} subclass to use or null
	 */
	public ProviderEndpoint(String url, Class<? extends BasicOEmbed> embedClass) {
		this(url, embedClass, Collections.<String> emptySet());
	}

	/**
	 * Constructs new ProviderEndpoint.
	 *
	 * @param url
	 *            provider endpoint URL
	 * @param embedClass
	 *            {@link OEmbed} subclass to use or null
	 * @param schemes
	 *            list of URL schemes
	 */
	public ProviderEndpoint(String url, Class<? extends BasicOEmbed> embedClass, Set<String> schemes) {
		setUrl(url);
		this.embedClass = embedClass;
		setSchemes(schemes);
	}

	/**
	 * Constructs new ProviderEndpoint.
	 *
	 * @param url
	 *            provider endpoint URL
	 * @param embedClass
	 *            {@link OEmbed} subclass to use or null
	 * @param schemes
	 *            list of URL schemes
	 */
	public ProviderEndpoint(String url, Class<? extends BasicOEmbed> embedClass, String... schemes) {
		this(url, embedClass, new HashSet<>(Arrays.asList(schemes)));
	}

	ProviderEndpoint() {
		this.schemes = Collections.emptySet();
	}

	/**
	 * Get embedClass class name.
	 *
	 * @return embedClass name
	 */
	@JsonProperty("embed_class")
	public String getEmbedClass() {
		return embedClass != null ? embedClass.getName() : null;
	}

	/**
	 * Supported formats i.e. json and or xml.
	 *
	 * @return supported formats
	 */
	public Set<String> getFormats() {
		return formats;
	}

	/**
	 * URL schemes.
	 *
	 * @return URL schems
	 */
	public Set<String> getSchemes() {
		return schemes;
	}

	/**
	 * Provider endpoint URL.
	 *
	 * @return url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Checks if endpoint supports auto discovery.
	 *
	 * @return true is auto discovery is supported.
	 */
	public boolean isDiscovery() {
		return discovery;
	}

	/**
	 * Set auto discovery.
	 *
	 * @param discovery
	 *            discovery
	 */
	public void setDiscovery(boolean discovery) {
		this.discovery = discovery;
	}

	/**
	 * Set oEmbed subclass to use for mapping.
	 *
	 * @param className
	 *            {@link OEmbed} subclass to use or null
	 * @throws ClassNotFoundException
	 *             if className can't be loaded
	 */
	@SuppressWarnings("unchecked")
	public void setEmbedClass(String className) throws ClassNotFoundException {
		this.embedClass = (Class<? extends BasicOEmbed>) Class.forName(className);
	}

	/**
	 * Sets supported formats.
	 *
	 * @param formats
	 *            set of formats
	 */
	public void setFormats(Set<String> formats) {
		this.formats = formats;
	}

	/**
	 * Sets supported URL schemes.
	 *
	 * @param schemes
	 *            URL schemes
	 */
	public void setSchemes(Set<String> schemes) {
		Objects.requireNonNull(schemes);
		this.schemes = schemes;
	}

	/**
	 * Sets endpoint URL.
	 *
	 * @param endpointUrl
	 *            url
	 */
	public void setUrl(String endpointUrl) {
		Objects.requireNonNull(endpointUrl);
		this.url = endpointUrl;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
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
