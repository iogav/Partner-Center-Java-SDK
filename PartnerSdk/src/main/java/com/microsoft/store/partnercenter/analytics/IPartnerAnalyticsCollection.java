package com.microsoft.store.partnercenter.analytics;

import com.microsoft.store.partnercenter.IPartnerComponentString;

/**
 * Contains a collection of partner level analytics operations interfaces.
 */
public interface IPartnerAnalyticsCollection extends IPartnerComponentString {

	/**
	 * Gets an interface to customer level licenses analytics operations.
	 */
	IPartnerLicensesAnalyticsCollection getLicenses();

}
