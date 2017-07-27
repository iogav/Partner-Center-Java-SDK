package com.microsoft.store.partnercenter.analytics;

import com.microsoft.store.partnercenter.BasePartnerComponentString;
import com.microsoft.store.partnercenter.IPartner;
import com.microsoft.store.partnercenter.utils.StringHelper;

public class CustomerAnalyticsCollectionOperations extends
		BasePartnerComponentString implements ICustomerAnalyticsCollection {

	private ICustomerLicensesAnalyticsCollection licenses;

	/**
	 * Initializes a new instance of the
	 * {@link #CustomerUsersCollectionOperations} class.
	 * 
	 * @param rootPartnerOperations
	 *            The root partner operations instance.
	 * @param customerId
	 *            The customer Id.
	 */
	public CustomerAnalyticsCollectionOperations(
			IPartner rootPartnerOperations, String customerId) {
		super(rootPartnerOperations, customerId);
		if (StringHelper.isNullOrWhiteSpace(customerId)) {
			throw new IllegalArgumentException("customerId must be set");
		}
	}

	/**
	 * Gets an interface to customer level licenses analytics operations.
	 */
	@Override
	public ICustomerLicensesAnalyticsCollection getLicenses() {
		if (this.licenses == null) {
			this.licenses = new CustomerLicensesAnalyticsCollectionOperations(
					this.getPartner(), this.getContext());
		}
		return this.licenses;
	}

}
