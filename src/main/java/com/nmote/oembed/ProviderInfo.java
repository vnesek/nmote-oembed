/*
 * Copyright (c) Nmote Ltd. 2015. All rights reserved.
 * See LICENSE doc in a root of project folder for additional information.
 */

package com.nmote.oembed;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProviderInfo {

	/**
	 * Constructs new Provider metadata.
	 *
	 * @param name
	 *            provider name
	 * @param url
	 *            provider URL
	 * @param endpoints
	 *            list of provider's endpoints
	 */
	public ProviderInfo(String name, String url, List<ProviderEndpoint> endpoints) {
		setProviderName(name);
		setProviderUrl(url);
		setEndpoints(endpoints);
	}

	/**
	 * Constructs new Provider metadata.
	 *
	 * @param name
	 *            provider name
	 * @param url
	 *            provider URL
	 * @param endpoints
	 *            list of provider's endpoints
	 */
	public ProviderInfo(String name, String url, ProviderEndpoint... endpoints) {
		this(name, url, Arrays.asList(endpoints));
	}

	ProviderInfo() {
		this.endpoints = Collections.emptyList();
	}

	/**
	 * Gets provider's endpoints.
	 *
	 * @return provider's endpoints
	 */
	public List<ProviderEndpoint> getEndpoints() {
		return endpoints;
	}

	/**
	 * The provider name.
	 *
	 * @return provider name
	 */
	public String getProviderName() {
		return providerName;
	}

	/**
	 * The provider URL
	 *
	 * @return url
	 */
	public String getProviderUrl() {
		return providerUrl;
	}

	/**
	 * Sets provider's endpoints.
	 *
	 * @param endpoints
	 *            provider's endpoints
	 */
	public void setEndpoints(List<ProviderEndpoint> endpoints) {
		Objects.requireNonNull(endpoints);
		this.endpoints = endpoints;
	}

	/**
	 * Sets provider name.
	 *
	 * @param providerName
	 *            name
	 */
	public void setProviderName(String providerName) {
		Objects.requireNonNull(providerName);
		this.providerName = providerName;
	}

	/**
	 * Sets provider URL.
	 *
	 * @param providerUrl
	 *            url
	 */
	public void setProviderUrl(String providerUrl) {
		Objects.requireNonNull(providerUrl);
		this.providerUrl = providerUrl;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ToJsonString.toJsonString(this);
	}

	@JsonProperty("endpoints")
	private List<ProviderEndpoint> endpoints;

	@JsonProperty("provider_name")
	private String providerName;

	@JsonProperty("provider_url")
	private String providerUrl;
}
