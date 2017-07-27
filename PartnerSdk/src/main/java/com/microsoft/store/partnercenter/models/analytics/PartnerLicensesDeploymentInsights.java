package com.microsoft.store.partnercenter.models.analytics;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Contains partner level insights about license deployment.
 */
public class PartnerLicensesDeploymentInsights extends BaseLicensesInsights {

	/***
	 * Gets or sets the percentage of licenses deployed.
	 */
	@JsonProperty("proratedDeploymentPercent")
	private Integer __ProratedDeploymentPercent;

	public Integer getProratedDeploymentPercent() {
		return __ProratedDeploymentPercent;
	}

	public void setProratedDeploymentPercent(Integer value) {
		__ProratedDeploymentPercent = value;
	}

	/***
	 * The number of licenses sold.
	 */
	@JsonProperty("licensesSold")
	private Integer __LicensesSold;

	public Integer getLicensesSold() {
		return __LicensesSold;
	}

	public void setLicensesSold(Integer value) {
		__LicensesSold = value;
	}
}
