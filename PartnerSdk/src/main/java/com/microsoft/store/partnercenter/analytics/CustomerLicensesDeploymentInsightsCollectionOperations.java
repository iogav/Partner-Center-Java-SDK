package com.microsoft.store.partnercenter.analytics;

import java.text.MessageFormat;
import java.util.Locale;

import com.fasterxml.jackson.core.type.TypeReference;
import com.microsoft.store.partnercenter.BasePartnerComponentString;
import com.microsoft.store.partnercenter.IPartner;
import com.microsoft.store.partnercenter.PartnerService;
import com.microsoft.store.partnercenter.models.ResourceCollection;
import com.microsoft.store.partnercenter.models.analytics.CustomerLicensesDeploymentInsights;
import com.microsoft.store.partnercenter.network.IPartnerServiceProxy;
import com.microsoft.store.partnercenter.network.PartnerServiceProxy;
import com.microsoft.store.partnercenter.utils.StringHelper;

public class CustomerLicensesDeploymentInsightsCollectionOperations extends
		BasePartnerComponentString implements
		ICustomerLicensesDeploymentInsightsCollection {

	/**
	 * Initializes a new instance of the
	 * {@link #CustomerLicensesDeploymentInsightsCollectionOperations} class.
	 * 
	 * @param rootPartnerOperations
	 *            The root partner operations instance.
	 * @param customerId
	 *            The customer Id.
	 */
	public CustomerLicensesDeploymentInsightsCollectionOperations(
			IPartner rootPartnerOperations, String customerId) {
		super(rootPartnerOperations, customerId);
		if (StringHelper.isNullOrWhiteSpace(customerId)) {
			throw new IllegalArgumentException("customerId must be set");
		}
	}

	/***
	 * Gets all customer license deployment insights
	 * 
	 * @return: The license deployment insights.
	 */
	@Override
	public ResourceCollection<CustomerLicensesDeploymentInsights> get() {
		IPartnerServiceProxy<CustomerLicensesDeploymentInsights, ResourceCollection<CustomerLicensesDeploymentInsights>> partnerServiceProxy = new PartnerServiceProxy<CustomerLicensesDeploymentInsights, ResourceCollection<CustomerLicensesDeploymentInsights>>(
				new TypeReference<ResourceCollection<CustomerLicensesDeploymentInsights>>() {
				}, this.getPartner(), MessageFormat.format(
						PartnerService.getInstance().getConfiguration()
								.getApis().get("GetCustomerLicensesDeployment")
								.getPath(), this.getContext(), Locale.US));
		return partnerServiceProxy.get();
	}

}
