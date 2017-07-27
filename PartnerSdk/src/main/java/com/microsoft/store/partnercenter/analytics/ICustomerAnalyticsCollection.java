package com.microsoft.store.partnercenter.analytics;

import com.microsoft.store.partnercenter.IPartnerComponentString;

/**
 * Contains customer level analytics collection operations.
 */
public interface ICustomerAnalyticsCollection extends IPartnerComponentString {

	/**
	 * Gets an interface to customer level licenses analytics operations.
	 */
	ICustomerLicensesAnalyticsCollection getLicenses();

}
