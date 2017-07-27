package com.microsoft.store.partnercenter.samples.analytics;

import com.microsoft.store.partnercenter.IPartner;
import com.microsoft.store.partnercenter.analytics.IPartnerLicensesAnalyticsCollection;
import com.microsoft.store.partnercenter.models.ResourceCollection;
import com.microsoft.store.partnercenter.models.analytics.PartnerLicensesDeploymentInsights;
import com.microsoft.store.partnercenter.samples.BasePartnerScenario;
import com.microsoft.store.partnercenter.samples.IScenarioContext;

public class GetPartnerLicenseDeploymentInsights extends BasePartnerScenario {

	public GetPartnerLicenseDeploymentInsights(IScenarioContext context) {
		super("Show partner license deployments", context);
	}

	@Override
	protected void runScenario() {
		IPartner partnerOperations = this.getContext()
				.getUserPartnerOperations();
		IPartnerLicensesAnalyticsCollection analyticsOperations = partnerOperations
				.getAnalytics().getLicenses();
		this.getContext().getConsoleHelper()
				.startProgress("Getting the partner license deployments");
		ResourceCollection<PartnerLicensesDeploymentInsights> deployment = analyticsOperations
				.getDeployment().get();
		this.getContext().getConsoleHelper().stopProgress();
		this.getContext().getConsoleHelper()
				.writeObject(deployment, "Partner license deployments");
	}
}
