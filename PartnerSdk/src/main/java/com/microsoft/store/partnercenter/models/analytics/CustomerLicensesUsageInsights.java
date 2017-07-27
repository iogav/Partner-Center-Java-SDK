package com.microsoft.store.partnercenter.models.analytics;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Contains customer level insights about license usage.
 */
public class CustomerLicensesUsageInsights extends BaseCustomerLicensesInsights {

	/***
	 * The workload code.
	 */
	@JsonProperty("workloadCode")
	private Integer __WorkloadCode;

	public Integer getWorkloadCode() {
		return __WorkloadCode;
	}

	public void setWorkloadCode(Integer value) {
		__WorkloadCode = value;
	}

	/***
	 * The workload name (e.g. Exchange).
	 */
	@JsonProperty("workloadName")
	private String __WorkloadName;

	public String getWorkloadName() {
		return __WorkloadName;
	}

	public void setWorkloadName(String value) {
		__WorkloadName = value;
	}

	/***
	 * The adjusted percentage of licenses used.
	 */
	@JsonProperty("usagePercent")
	private Integer __UsagePercent;

	public Integer getUsagePercentage() {
		return __UsagePercent;
	}

	public void setUsagePercentage(Integer value) {
		__UsagePercent = value;
	}

	/***
	 * The number of active licenses.
	 */
	@JsonProperty("licensesActive")
	private Integer __LicensesActive;

	public Integer getLicensesActive() {
		return __LicensesActive;
	}

	public void setLicensesActive(Integer value) {
		__LicensesActive = value;
	}

	/***
	 * The number of qualified licenses.
	 */
	@JsonProperty("licensesQualified")
	private Integer __LicensesQualified;

	public Integer getLicensesQualified() {
		return __LicensesQualified;
	}

	public void setLicensesQualified(Integer value) {
		__LicensesQualified = value;
	}

}
