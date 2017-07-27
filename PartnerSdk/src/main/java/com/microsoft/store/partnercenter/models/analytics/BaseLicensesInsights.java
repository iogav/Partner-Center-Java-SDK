package com.microsoft.store.partnercenter.models.analytics;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.microsoft.store.partnercenter.models.ResourceBase;

/**
 * Represents common properties for Partner and Customer license insights
 */
public class BaseLicensesInsights extends ResourceBase {
	/***
	 * The service name (e.g. o365, crm).
	 */
	@JsonProperty("serviceName")
	private String __ServiceName;

	public String getServiceName() {
		return __ServiceName;
	}

	public void setServiceName(String value) {
		__ServiceName = value;
	}

	/***
	 * The channel name of the service (e.g. reseller).
	 */
	@JsonProperty("channel")
	private String __Channel;

	public String getChannel() {
		return __Channel;
	}

	public void setChannel(String value) {
		__Channel = value;
	}

	/***
	 * The date and time when the data was aggregated.
	 */
	@JsonProperty("processedDateTime")
	private DateTime __ProcessedDateTime;

	public DateTime getProcessedDateTime() {
		return __ProcessedDateTime;
	}

	public void setProcessedDateTime(DateTime value) {
		__ProcessedDateTime = value;
	}
}
