package com.microsoft.store.partnercenter.models.subscriptions;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Enum representing the available states for a subscription
 */
public enum ProvisioningStatus {
	/**
	 * Indicates nothing - no status, used as the default
	 */
	@JsonProperty("none")
	NONE,
	/**
	 * The subscription was successfully provisioned.
	 */
	@JsonProperty("success")
	SUCCESS,
	/**
	 * The subscription provisioning status is pending.
	 */
	@JsonProperty("pending")
	PENDING,
	/**
	 * The attempt to provision the subscription failed.
	 */
	@JsonProperty("failed")
	FAILED
}
