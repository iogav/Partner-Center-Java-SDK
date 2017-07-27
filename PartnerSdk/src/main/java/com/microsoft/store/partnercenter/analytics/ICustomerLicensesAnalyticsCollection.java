package com.microsoft.store.partnercenter.analytics;

import com.microsoft.store.partnercenter.IPartnerComponentString;

public interface ICustomerLicensesAnalyticsCollection extends
		IPartnerComponentString {

	/**
	 * Gets an interface to customer level licenses deployment insights.
	 */
	ICustomerLicensesDeploymentInsightsCollection getDeployment();

	/**
	 * Gets an interface to a collection of customer level usage deployment
	 * insights.
	 */
	ICustomerLicensesUsageInsightsCollection getUsage();

}
