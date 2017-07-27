package com.microsoft.store.partnercenter.analytics;

import java.text.MessageFormat;
import java.util.Locale;

import com.fasterxml.jackson.core.type.TypeReference;
import com.microsoft.store.partnercenter.BasePartnerComponentString;
import com.microsoft.store.partnercenter.IPartner;
import com.microsoft.store.partnercenter.PartnerService;
import com.microsoft.store.partnercenter.models.ResourceCollection;
import com.microsoft.store.partnercenter.models.analytics.PartnerLicensesDeploymentInsights;
import com.microsoft.store.partnercenter.network.IPartnerServiceProxy;
import com.microsoft.store.partnercenter.network.PartnerServiceProxy;

public class PartnerLicensesDeploymentInsightsCollectionOperations extends
		BasePartnerComponentString implements
		IPartnerLicensesDeploymentInsightsCollection {

	/**
	 * Initializes a new instance of the
	 * {@link #PartnerLicensesDeploymentInsightsCollectionOperations} class.
	 * 
	 * @param rootPartnerOperations
	 *            The root partner operations instance.
	 */
	public PartnerLicensesDeploymentInsightsCollectionOperations(
			IPartner rootPartnerOperations) {
		super(rootPartnerOperations);
	}

	/***
	 * Gets all partner license deployment insights
	 * 
	 * @return: The license deployment insights.
	 */
	@Override
	public ResourceCollection<PartnerLicensesDeploymentInsights> get() {
		IPartnerServiceProxy<PartnerLicensesDeploymentInsights, ResourceCollection<PartnerLicensesDeploymentInsights>> partnerServiceProxy = new PartnerServiceProxy<PartnerLicensesDeploymentInsights, ResourceCollection<PartnerLicensesDeploymentInsights>>(
				new TypeReference<ResourceCollection<PartnerLicensesDeploymentInsights>>() {
				}, this.getPartner(), MessageFormat.format(
						PartnerService.getInstance().getConfiguration()
								.getApis().get("GetPartnerLicensesDeployment")
								.getPath(), this.getContext(), Locale.US));
		return partnerServiceProxy.get();
	}

}
