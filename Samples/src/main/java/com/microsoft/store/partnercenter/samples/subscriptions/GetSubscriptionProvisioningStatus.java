package com.microsoft.store.partnercenter.samples.subscriptions;

import com.microsoft.store.partnercenter.IPartner;
import com.microsoft.store.partnercenter.samples.BasePartnerScenario;
import com.microsoft.store.partnercenter.samples.IScenarioContext;

public class GetSubscriptionProvisioningStatus extends BasePartnerScenario {
	/**
	 * Initializes a new instance of the {@link #GetCustomerDetails} class.
	 * 
	 * @param context
	 *            The scenario context.
	 */
	public GetSubscriptionProvisioningStatus(IScenarioContext context) {
		super("Get subscription provisioning status", context);
	}

	/**
	 * Executes the get customer details scenario.
	 */
	@Override
	protected void runScenario() {
		String customerId = this
				.obtainCustomerId("Enter the ID of the customer to retrieve");
		String subscriptionId = this
				.obtainSubscriptionId(customerId,
						"Enter the ID of the subscription to retrieve provisioning status for");
		IPartner partnerOperations = this.getContext()
				.getUserPartnerOperations();
		this.getContext().getConsoleHelper()
				.startProgress("Retrieving subscription provisioning status");

		com.microsoft.store.partnercenter.models.subscriptions.SubscriptionProvisioningStatus status = partnerOperations
				.getCustomers().byId(customerId) //
				.getSubscriptions().byId(subscriptionId) //
				.getProvisioningStatus().get();

		this.getContext().getConsoleHelper().stopProgress();
		this.getContext().getConsoleHelper()
				.writeObject(status, "Subscription provisioning status");
	}

}
