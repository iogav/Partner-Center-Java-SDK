package com.microsoft.store.partnercenter.subscriptions;

import com.microsoft.store.partnercenter.IPartnerComponent;
import com.microsoft.store.partnercenter.genericoperations.IEntityGetOperations;
import com.microsoft.store.partnercenter.models.subscriptions.SubscriptionProvisioningStatus;
import com.microsoft.store.partnercenter.models.utils.Tuple;

public interface ISubscriptionProvisioningStatus extends
		IPartnerComponent<Tuple<String, String>>,
		IEntityGetOperations<SubscriptionProvisioningStatus> {
	/***
	 * Retrieves the subscription provisioning status.
	 * 
	 * @return The subscription provisioning status
	 */
	@Override
	SubscriptionProvisioningStatus get();
}
