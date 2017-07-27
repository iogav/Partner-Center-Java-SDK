package com.microsoft.store.partnercenter.models.analytics;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Contains partner level insights about license usage.
 */
public class PartnerLicensesUsageInsights extends BaseLicensesInsights {
	/***
	 * The percentage of licenses deployed.
	 */
	@JsonProperty("proratedLicensesUsagePercent")
	private Integer __ProratedLicensesUsagePercent;

	public Integer getProratedLicensesUsagePercent() {
		return __ProratedLicensesUsagePercent;
	}

	public void setProratedLicensesUsagePercent(Integer value) {
		__ProratedLicensesUsagePercent = value;
	}

	/***
	 * The workload name (e.g. exchange).
	 */
	@JsonProperty("workloadName")
	private String __WorkloadName;

	public String getWorkloadName() {
		return __WorkloadName;
	}

	public void setWorkloadName(String value) {
		__WorkloadName = value;
	}
}
