package com.microsoft.store.partnercenter.analytics;

import java.text.MessageFormat;
import java.util.Locale;

import com.fasterxml.jackson.core.type.TypeReference;
import com.microsoft.store.partnercenter.BasePartnerComponentString;
import com.microsoft.store.partnercenter.IPartner;
import com.microsoft.store.partnercenter.PartnerService;
import com.microsoft.store.partnercenter.models.ResourceCollection;
import com.microsoft.store.partnercenter.models.analytics.PartnerLicensesUsageInsights;
import com.microsoft.store.partnercenter.network.IPartnerServiceProxy;
import com.microsoft.store.partnercenter.network.PartnerServiceProxy;

public class PartnerLicensesUsageInsightsCollectionOperations extends
		BasePartnerComponentString implements
		IPartnerLicensesUsageInsightsCollection {

	/**
	 * Initializes a new instance of the
	 * {@link #PartnerLicensesUsageInsightsCollectionOperations} class.
	 * 
	 * @param rootPartnerOperations
	 *            The root partner operations instance.
	 */
	public PartnerLicensesUsageInsightsCollectionOperations(
			IPartner rootPartnerOperations) {
		super(rootPartnerOperations);
	}

	/***
	 * Gets all partner license usage insights
	 * 
	 * @return: The license usage insights.
	 */
	@Override
	public ResourceCollection<PartnerLicensesUsageInsights> get() {
		IPartnerServiceProxy<PartnerLicensesUsageInsights, ResourceCollection<PartnerLicensesUsageInsights>> partnerServiceProxy = new PartnerServiceProxy<PartnerLicensesUsageInsights, ResourceCollection<PartnerLicensesUsageInsights>>(
				new TypeReference<ResourceCollection<PartnerLicensesUsageInsights>>() {
				}, this.getPartner(), MessageFormat.format(
						PartnerService.getInstance().getConfiguration()
								.getApis().get("GetPartnerLicensesUsage")
								.getPath(), this.getContext(), Locale.US));
		return partnerServiceProxy.get();
	}

}
