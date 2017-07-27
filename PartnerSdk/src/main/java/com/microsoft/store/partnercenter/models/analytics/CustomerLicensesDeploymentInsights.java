package com.microsoft.store.partnercenter.models.analytics;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Contains customer level insights about license deployment.
 */
public class CustomerLicensesDeploymentInsights extends
		BaseCustomerLicensesInsights {

	/***
	 * The number of licenses deployed.
	 */
	@JsonProperty("licensesDeployed")
	private Integer __LicensesDeployed;

	public Integer getLicensesDeployed() {
		return __LicensesDeployed;
	}

	public void setLicensesDeployed(Integer value) {
		__LicensesDeployed = value;
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

	/***
	 * The adjusted percentage of licenses deployed.
	 */
	@JsonProperty("deploymentPercent")
	private Integer __DeploymentPercent;

	public Integer getDeploymentPercent() {
		return __DeploymentPercent;
	}

	public void setDeploymentPercent(Integer value) {
		__DeploymentPercent = value;
	}
}
