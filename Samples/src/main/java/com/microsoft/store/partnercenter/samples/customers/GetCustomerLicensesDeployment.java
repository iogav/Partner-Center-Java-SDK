package com.microsoft.store.partnercenter.samples.customers;

import com.microsoft.store.partnercenter.IPartner;
import com.microsoft.store.partnercenter.models.ResourceCollection;
import com.microsoft.store.partnercenter.models.analytics.CustomerLicensesDeploymentInsights;
import com.microsoft.store.partnercenter.samples.BasePartnerScenario;
import com.microsoft.store.partnercenter.samples.IScenarioContext;

public class GetCustomerLicensesDeployment extends BasePartnerScenario {

	/**
	 * Initializes a new instance of the {@link #GetCustomerLicenseDeployment}
	 * class.
	 * 
	 * @param context
	 *            The scenario context.
	 */
	public GetCustomerLicensesDeployment(IScenarioContext context) {
		super("Get customer license deployment", context);
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
				.startProgress("Getting the customer's license deployment");
		ResourceCollection<CustomerLicensesDeploymentInsights> deployment = partnerOperations
				.getCustomers().byId(customerId).getAnalytics().getLicenses()
				.getDeployment().get();
		this.getContext().getConsoleHelper().stopProgress();
		this.getContext().getConsoleHelper()
				.writeObject(deployment, "Customer license deployment");
	}
}
