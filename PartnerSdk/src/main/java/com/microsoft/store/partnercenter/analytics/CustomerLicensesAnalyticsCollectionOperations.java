package com.microsoft.store.partnercenter.analytics;

import com.microsoft.store.partnercenter.BasePartnerComponentString;
import com.microsoft.store.partnercenter.IPartner;
import com.microsoft.store.partnercenter.utils.StringHelper;

public class CustomerLicensesAnalyticsCollectionOperations extends
		BasePartnerComponentString implements
		ICustomerLicensesAnalyticsCollection {

	private ICustomerLicensesDeploymentInsightsCollection deployment;

	private ICustomerLicensesUsageInsightsCollection usage;

	/**
	 * Initializes a new instance of the
	 * {@link #CustomerUsersCollectionOperations} class.
	 * 
	 * @param rootPartnerOperations
	 *            The root partner operations instance.
	 * @param customerId
	 *            The customer Id.
	 */
	public CustomerLicensesAnalyticsCollectionOperations(
			IPartner rootPartnerOperations, String customerId) {
		super(rootPartnerOperations, customerId);
		if (StringHelper.isNullOrWhiteSpace(customerId)) {
			throw new IllegalArgumentException("customerId must be set");
		}
	}

	/**
	 * Gets an interface to customer level licenses deployment insights.
	 */
	@Override
	public ICustomerLicensesDeploymentInsightsCollection getDeployment() {
		if (this.deployment == null) {
			this.deployment = new CustomerLicensesDeploymentInsightsCollectionOperations(
					this.getPartner(), this.getContext());
		}
		return this.deployment;
	}

	/**
	 * Gets an interface to a collection of customer level usage deployment
	 * insights.
	 */
	@Override
	public ICustomerLicensesUsageInsightsCollection getUsage() {
		if (this.usage == null) {
			this.usage = new CustomerLicensesUsageInsightsCollectionOperations(
					this.getPartner(), this.getContext());
		}
		return this.usage;
	}

}
