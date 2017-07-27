package com.microsoft.store.partnercenter.samples.customers;

import com.microsoft.store.partnercenter.IPartner;
import com.microsoft.store.partnercenter.models.ResourceCollection;
import com.microsoft.store.partnercenter.models.analytics.CustomerLicensesUsageInsights;
import com.microsoft.store.partnercenter.samples.BasePartnerScenario;
import com.microsoft.store.partnercenter.samples.IScenarioContext;

public class GetCustomerLicensesUsage extends BasePartnerScenario {

	/**
	 * Initializes a new instance of the {@link #GetCustomerLicenseUsage} class.
	 * 
	 * @param context
	 *            The scenario context.
	 */
	public GetCustomerLicensesUsage(IScenarioContext context) {
		super("Get customer license usage", context);
	}

	/**
	 * Executes the scenario.
	 */
	@Override
	protected void runScenario() {
		String customerId = this.obtainCustomerId();
		IPartner partnerOperations = this.getContext()
				.getUserPartnerOperations();
		this.getContext().getConsoleHelper()
				.startProgress("Getting the customer's license usage");
		ResourceCollection<CustomerLicensesUsageInsights> usage = partnerOperations
				.getCustomers().byId(customerId).getAnalytics().getLicenses()
				.getUsage().get();
		this.getContext().getConsoleHelper().stopProgress();
		this.getContext().getConsoleHelper()
				.writeObject(usage, "Customer license usage");
	}
}
