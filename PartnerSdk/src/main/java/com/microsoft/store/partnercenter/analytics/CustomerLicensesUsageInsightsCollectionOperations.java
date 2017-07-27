package com.microsoft.store.partnercenter.analytics;

import java.text.MessageFormat;
import java.util.Locale;

import com.fasterxml.jackson.core.type.TypeReference;
import com.microsoft.store.partnercenter.BasePartnerComponentString;
import com.microsoft.store.partnercenter.IPartner;
import com.microsoft.store.partnercenter.PartnerService;
import com.microsoft.store.partnercenter.models.ResourceCollection;
import com.microsoft.store.partnercenter.models.analytics.CustomerLicensesUsageInsights;
import com.microsoft.store.partnercenter.network.IPartnerServiceProxy;
import com.microsoft.store.partnercenter.network.PartnerServiceProxy;
import com.microsoft.store.partnercenter.utils.StringHelper;

public class CustomerLicensesUsageInsightsCollectionOperations extends
		BasePartnerComponentString implements
		ICustomerLicensesUsageInsightsCollection {

	/**
	 * Initializes a new instance of the
	 * {@link #CustomerLicensesDeploymentInsightsCollectionOperations} class.
	 * 
	 * @param rootPartnerOperations
	 *            The root partner operations instance.
	 * @param customerId
	 *            The customer Id.
	 */
	public CustomerLicensesUsageInsightsCollectionOperations(
			IPartner rootPartnerOperations, String customerId) {
		super(rootPartnerOperations, customerId);
		if (StringHelper.isNullOrWhiteSpace(customerId)) {
			throw new IllegalArgumentException("customerId must be set");
		}
	}

	/***
	 * Gets all customer license usage insights
	 * 
	 * @return: The license usage insights.
	 */
	@Override
	public ResourceCollection<CustomerLicensesUsageInsights> get() {
		IPartnerServiceProxy<CustomerLicensesUsageInsights, ResourceCollection<CustomerLicensesUsageInsights>> partnerServiceProxy = new PartnerServiceProxy<CustomerLicensesUsageInsights, ResourceCollection<CustomerLicensesUsageInsights>>(
				new TypeReference<ResourceCollection<CustomerLicensesUsageInsights>>() {
				}, this.getPartner(), MessageFormat.format(
						PartnerService.getInstance().getConfiguration()
								.getApis().get("GetCustomerLicensesUsage")
								.getPath(), this.getContext(), Locale.US));
		return partnerServiceProxy.get();
	}

}
