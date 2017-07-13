package com.microsoft.store.partnercenter.subscriptions;

import java.text.MessageFormat;
import java.util.Locale;

import com.fasterxml.jackson.core.type.TypeReference;
import com.microsoft.store.partnercenter.BasePartnerComponent;
import com.microsoft.store.partnercenter.IPartner;
import com.microsoft.store.partnercenter.PartnerService;
import com.microsoft.store.partnercenter.models.subscriptions.SubscriptionProvisioningStatus;
import com.microsoft.store.partnercenter.models.utils.Tuple;
import com.microsoft.store.partnercenter.network.IPartnerServiceProxy;
import com.microsoft.store.partnercenter.network.PartnerServiceProxy;
import com.microsoft.store.partnercenter.utils.StringHelper;

public class SubscriptionProvisioningStatusOperations extends
		BasePartnerComponent<Tuple<String, String>> implements
		ISubscriptionProvisioningStatus {

	/**
	 * Initializes a new instance of the
	 * {@link #SubscriptionProvisioningStatusOperations} class.
	 * 
	 * @param rootPartnerOperations
	 *            The root partner operations instance.
	 * @param customerId
	 *            The customer Id.
	 * @param subscriptionId
	 *            The subscription id.
	 */
	public SubscriptionProvisioningStatusOperations(
			IPartner rootPartnerOperations, String customerId,
			String subscriptionId) {
		super(rootPartnerOperations, new Tuple<String, String>(customerId,
				subscriptionId));
		if (StringHelper.isNullOrWhiteSpace(customerId)) {
			throw new IllegalArgumentException("customerId should be set.");
		}

		if (StringHelper.isNullOrWhiteSpace(subscriptionId)) {
			throw new IllegalArgumentException("subscriptionId should be set.");
		}

	}

	@Override
	public SubscriptionProvisioningStatus get() {
		IPartnerServiceProxy<SubscriptionProvisioningStatus, SubscriptionProvisioningStatus> partnerServiceProxy = new PartnerServiceProxy<SubscriptionProvisioningStatus, SubscriptionProvisioningStatus>(
				new TypeReference<SubscriptionProvisioningStatus>() {
				}, this.getPartner(), MessageFormat.format(
						PartnerService.getInstance().getConfiguration()
								.getApis()
								.get("GetSubscriptionProvisionStatus")
								.getPath(), this.getContext().getItem1(), this
								.getContext().getItem2(), Locale.US));
		return partnerServiceProxy.get();
	}

}
