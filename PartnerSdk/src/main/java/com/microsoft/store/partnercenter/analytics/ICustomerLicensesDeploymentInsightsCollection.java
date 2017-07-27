package com.microsoft.store.partnercenter.analytics;

import com.microsoft.store.partnercenter.IPartnerComponentString;
import com.microsoft.store.partnercenter.genericoperations.IEntireEntityCollectionRetrievalOperations;
import com.microsoft.store.partnercenter.models.ResourceCollection;
import com.microsoft.store.partnercenter.models.analytics.CustomerLicensesDeploymentInsights;

/**
 * Contains a collection of customer level licenses deployment insights
 */
public interface ICustomerLicensesDeploymentInsightsCollection
		extends
		IPartnerComponentString,
		IEntireEntityCollectionRetrievalOperations<CustomerLicensesDeploymentInsights, ResourceCollection<CustomerLicensesDeploymentInsights>> {

}
