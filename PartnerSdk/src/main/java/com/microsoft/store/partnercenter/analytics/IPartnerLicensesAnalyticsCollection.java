package com.microsoft.store.partnercenter.analytics;

import com.microsoft.store.partnercenter.IPartnerComponentString;

/**
 * Contains a collection of partner level licenses analytics.
 */
public interface IPartnerLicensesAnalyticsCollection extends
		IPartnerComponentString {

	/**
	 * Gets a collection of partner level licenses deployment analytics.
	 */
	IPartnerLicensesDeploymentInsightsCollection getDeployment();

	/**
	 * Gets a collection of partner level license usage analytics.
	 */
	IPartnerLicensesUsageInsightsCollection getUsage();

}
