package com.microsoft.store.partnercenter.samples.analytics;

import com.microsoft.store.partnercenter.IPartner;
import com.microsoft.store.partnercenter.analytics.IPartnerLicensesAnalyticsCollection;
import com.microsoft.store.partnercenter.models.ResourceCollection;
import com.microsoft.store.partnercenter.models.analytics.PartnerLicensesUsageInsights;
import com.microsoft.store.partnercenter.samples.BasePartnerScenario;
import com.microsoft.store.partnercenter.samples.IScenarioContext;

public class GetPartnerLicenseUsageInsights extends BasePartnerScenario {

	public GetPartnerLicenseUsageInsights(IScenarioContext context) {
		super("Show partner license usage", context);
	}

	@Override
	protected void runScenario() {
		IPartner partnerOperations = this.getContext()
				.getUserPartnerOperations();
		IPartnerLicensesAnalyticsCollection analyticsOperations = partnerOperations
				.getAnalytics().getLicenses();
		this.getContext().getConsoleHelper()
				.startProgress("Getting the partner license usage");
		ResourceCollection<PartnerLicensesUsageInsights> usage = analyticsOperations
				.getUsage().get();
		this.getContext().getConsoleHelper().stopProgress();
		this.getContext().getConsoleHelper()
				.writeObject(usage, "Partner license usage");
	}

}
