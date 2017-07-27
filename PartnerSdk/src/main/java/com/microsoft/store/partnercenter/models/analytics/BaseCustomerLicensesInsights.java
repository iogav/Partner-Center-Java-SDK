package com.microsoft.store.partnercenter.models.analytics;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents common properties for Customer license insights
 */
public class BaseCustomerLicensesInsights extends BaseLicensesInsights {

	/***
	 * The customer identifier.
	 */
	@JsonProperty("customerId")
	private String __CustomerId;

	public String getCustomerId() {
		return __CustomerId;
	}

	public void setCustomerId(String value) {
		__CustomerId = value;
	}

	/***
	 * The customer name.
	 */
	@JsonProperty("customerName")
	private String __CustomerName;

	public String getCustomerName() {
		return __CustomerName;
	}

	public void setCustomerName(String value) {
		__CustomerName = value;
	}

	/***
	 * The product name.
	 */
	@JsonProperty("productName")
	private String __ProductName;

	public String getProductName() {
		return __ProductName;
	}

	public void setProductName(String value) {
		__ProductName = value;
	}

	/***
	 * The service code of the license.
	 */
	@JsonProperty("serviceCode")
	private String __ServiceCode;

	public String getServiceCode() {
		return __ServiceCode;
	}

	public void setServiceCode(String value) {
		__ServiceCode = value;
	}
}
