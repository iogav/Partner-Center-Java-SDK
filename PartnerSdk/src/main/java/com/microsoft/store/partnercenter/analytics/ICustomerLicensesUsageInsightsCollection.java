package com.microsoft.store.partnercenter.analytics;

import com.microsoft.store.partnercenter.IPartnerComponentString;
import com.microsoft.store.partnercenter.genericoperations.IEntireEntityCollectionRetrievalOperations;
import com.microsoft.store.partnercenter.models.ResourceCollection;
import com.microsoft.store.partnercenter.models.analytics.CustomerLicensesUsageInsights;

/**
 * Contains a collection of customer level usage deployment insights.
 */
public interface ICustomerLicensesUsageInsightsCollection
		extends
		IPartnerComponentString,
		IEntireEntityCollectionRetrievalOperations<CustomerLicensesUsageInsights, ResourceCollection<CustomerLicensesUsageInsights>> {

}
