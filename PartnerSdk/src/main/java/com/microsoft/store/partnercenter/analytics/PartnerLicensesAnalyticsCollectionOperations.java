package com.microsoft.store.partnercenter.analytics;

import com.microsoft.store.partnercenter.BasePartnerComponentString;
import com.microsoft.store.partnercenter.IPartner;

public class PartnerLicensesAnalyticsCollectionOperations extends
		BasePartnerComponentString implements
		IPartnerLicensesAnalyticsCollection {

	private IPartnerLicensesDeploymentInsightsCollection deployment;

	private IPartnerLicensesUsageInsightsCollection usage;

	/**
	 * Initializes a new instance of the
	 * {@link #PartnerLicensesAnalyticsCollectionOperations} class.
	 * 
	 * @param rootPartnerOperations
	 *            The root partner operations instance.
	 */
	public PartnerLicensesAnalyticsCollectionOperations(
			IPartner rootPartnerOperations) {
		super(rootPartnerOperations);
	}

	/**
	 * Gets a collection of partner level licenses deployment analytics.
	 */
	@Override
	public IPartnerLicensesDeploymentInsightsCollection getDeployment() {
		if (deployment == null) {
			deployment = new PartnerLicensesDeploymentInsightsCollectionOperations(
					this.getPartner());
		}
		return this.deployment;
	}

	/**
	 * Gets a collection of partner level license usage analytics.
	 */
	@Override
	public IPartnerLicensesUsageInsightsCollection getUsage() {
		if (this.usage == null) {
			this.usage = new PartnerLicensesUsageInsightsCollectionOperations(
					this.getPartner());
		}
		return this.usage;
	}

}
