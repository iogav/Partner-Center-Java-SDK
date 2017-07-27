package com.microsoft.store.partnercenter.analytics;

import com.microsoft.store.partnercenter.BasePartnerComponentString;
import com.microsoft.store.partnercenter.IPartner;

public class PartnerAnalyticsCollectionOperations extends
		BasePartnerComponentString implements IPartnerAnalyticsCollection {

	private IPartnerLicensesAnalyticsCollection licenses;

	/**
	 * Initializes a new instance of the
	 * {@link #PartnerAnalyticsCollectionOperations} class.
	 * 
	 * @param rootPartnerOperations
	 *            The root partner operations instance.
	 */
	public PartnerAnalyticsCollectionOperations(IPartner rootPartnerOperations) {
		super(rootPartnerOperations);
	}

	/**
	 * Gets an interface to customer level licenses analytics operations.
	 * 
	 * @return The customer level licenses analytics operations.
	 */
	@Override
	public IPartnerLicensesAnalyticsCollection getLicenses() {
		if (this.licenses == null) {
			this.licenses = new PartnerLicensesAnalyticsCollectionOperations(
					this.getPartner());
		}
		return this.licenses;
	}

}
