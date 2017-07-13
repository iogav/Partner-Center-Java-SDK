package com.microsoft.store.partnercenter.models.subscriptions;

import org.joda.time.DateTime;

import com.microsoft.store.partnercenter.models.ResourceBase;

public class SubscriptionProvisioningStatus extends ResourceBase {
	/**
	 * Gets or sets the renewal or end date after provisioning.
	 */
	private DateTime __EndDate;

	public DateTime getEndDate() {
		return __EndDate;
	}

	public void setEndDate(DateTime value) {
		__EndDate = value;
	}

	/**
	 * Gets or sets the subscription quantity after provisioning.
	 */
	private int __Quantity;

	public int getQuantity() {
		return __Quantity;
	}

	public void setQuantity(int value) {
		__Quantity = value;
	}

	/**
	 * Gets or sets the subscription SKU identifier.
	 */
	private String __SkuId;

	public String getSkuId() {
		return __SkuId;
	}

	public void setSkuId(String value) {
		__SkuId = value;
	}

	/**
	 * Gets or sets the subscription SKU identifier.
	 */
	private ProvisioningStatus __Status;

	public ProvisioningStatus getStatus() {
		return __Status;
	}

	public void setStatus(ProvisioningStatus value) {
		__Status = value;
	}

}
