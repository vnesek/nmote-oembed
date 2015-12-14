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

	ProviderInfo() {
		this.endpoints = Collections.emptyList();
	}

	public ProviderInfo(String name, String url, List<ProviderEndpoint> endpoints) {
		setProviderName(name);
		setProviderUrl(url);
		setEndpoints(endpoints);
	}

	public ProviderInfo(String name, String url, ProviderEndpoint... endpoints) {
		this(name, url, Arrays.asList(endpoints));
	}

	public List<ProviderEndpoint> getEndpoints() {
		return endpoints;
	}

	public String getProviderName() {
		return providerName;
	}

	public String getProviderUrl() {
		return providerUrl;
	}

	public void setEndpoints(List<ProviderEndpoint> endpoints) {
		Objects.requireNonNull(endpoints);
		this.endpoints = endpoints;
	}

	public void setProviderName(String providerName) {
		Objects.requireNonNull(providerName);
		this.providerName = providerName;
	}

	public void setProviderUrl(String providerUrl) {
		Objects.requireNonNull(providerUrl);
		this.providerUrl = providerUrl;
	}

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
