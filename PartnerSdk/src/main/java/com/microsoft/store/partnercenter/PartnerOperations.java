// -----------------------------------------------------------------------
// <copyright file="PartnerOperations.java" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------

package com.microsoft.store.partnercenter;

import com.microsoft.store.partnercenter.analytics.IPartnerAnalyticsCollection;
import com.microsoft.store.partnercenter.analytics.PartnerAnalyticsCollectionOperations;
import com.microsoft.store.partnercenter.auditrecords.AuditRecordsCollection;
import com.microsoft.store.partnercenter.auditrecords.IAuditRecordsCollection;
import com.microsoft.store.partnercenter.countryvalidationrules.CountryValidationRulesCollectionOperations;
import com.microsoft.store.partnercenter.countryvalidationrules.ICountryValidationRulesCollection;
import com.microsoft.store.partnercenter.customers.CustomerCollectionOperations;
import com.microsoft.store.partnercenter.customers.ICustomerCollection;
import com.microsoft.store.partnercenter.domains.DomainCollectionOperations;
import com.microsoft.store.partnercenter.domains.IDomainCollection;
import com.microsoft.store.partnercenter.enumerators.IResourceCollectionEnumeratorContainer;
import com.microsoft.store.partnercenter.enumerators.ResourceCollectionEnumeratorContainer;
import com.microsoft.store.partnercenter.genericoperations.ICountrySelector;
import com.microsoft.store.partnercenter.invoices.IInvoiceCollection;
import com.microsoft.store.partnercenter.invoices.InvoiceCollection;
import com.microsoft.store.partnercenter.offers.IOfferCategoryCollection;
import com.microsoft.store.partnercenter.offers.IOfferCollection;
import com.microsoft.store.partnercenter.offers.OfferCategoryCountrySelector;
import com.microsoft.store.partnercenter.offers.OfferCountrySelector;
import com.microsoft.store.partnercenter.profiles.IPartnerProfileCollection;
import com.microsoft.store.partnercenter.profiles.PartnerProfileCollectionOperations;
import com.microsoft.store.partnercenter.ratecards.IRateCardCollection;
import com.microsoft.store.partnercenter.ratecards.RateCardCollectionOperations;
import com.microsoft.store.partnercenter.requestcontext.IRequestContext;
import com.microsoft.store.partnercenter.serviceincidents.IServiceIncidentCollection;
import com.microsoft.store.partnercenter.serviceincidents.ServiceIncidentCollectionOperations;
import com.microsoft.store.partnercenter.servicerequests.IPartnerServiceRequestCollection;
import com.microsoft.store.partnercenter.servicerequests.PartnerServiceRequestCollectionOperations;
import com.microsoft.store.partnercenter.usage.IPartnerUsageSummary;
import com.microsoft.store.partnercenter.usage.PartnerUsageSummaryOperations;

/**
 * The partner implementation class.
 */
public class PartnerOperations implements IPartner {
	// /**
	// * The resource collection enumerator container.
	// */
	private IResourceCollectionEnumeratorContainer enumeratorContainer;

	/**
	 * The partner customers operations.
	 */
	private IPartnerAnalyticsCollection analytics;

	/**
	 * The partner customers operations.
	 */
	private ICustomerCollection customers;

	/**
	 * The offer categories.
	 */
	private ICountrySelector<IOfferCategoryCollection> offerCategories;

	/**
	 * The offers operation.
	 */
	private ICountrySelector<IOfferCollection> offers;

	/**
	 * The profile operations.
	 */
	private IPartnerProfileCollection profiles;

	/**
	 * The partner invoices.
	 */
	private IInvoiceCollection invoices;

	/**
	 * The service request operations.
	 */
	private IPartnerServiceRequestCollection serviceRequests;

	/***
	 * The service incidents operations.
	 */
	private IServiceIncidentCollection serviceIncidents;

	/**
	 * The validations operations.
	 */
	private ICountryValidationRulesCollection countryValidationRules;

	/**
	 * Gets the usage summary operations available to the partner.
	 */
	private IPartnerUsageSummary usageSummary;

	/**
	 * The domain operations.
	 */
	private IDomainCollection domains;

	/**
	 * Gets the audit records collection operations.
	 */
	private IAuditRecordsCollection auditRecords;

	/***
	 * The rate cards collection operations.
	 */
	private IRateCardCollection rateCards;

	/**
	 * Initializes a new instance of the {@link #PartnerOperations} class.
	 * 
	 * @param credentials
	 *            The partner credentials.
	 * @param context
	 *            A partner context.
	 */
	public PartnerOperations(IPartnerCredentials credentials,
			IRequestContext context) {
		if (credentials == null) {
			throw new IllegalArgumentException("credentials can't be null");
		}
		if (context == null) {
			throw new IllegalArgumentException("context can't be null");
		}
		this.setCredentials(credentials);
		this.setRequestContext(context);
	}

	/**
	 * Gets the partner credentials.
	 */
	private IPartnerCredentials __Credentials;

	@Override
	public IPartnerCredentials getCredentials() {
		return __Credentials;
	}

	private void setCredentials(IPartnerCredentials value) {
		__Credentials = value;
	}

	/**
	 * Gets the partner context.
	 */
	private IRequestContext __RequestContext;

	@Override
	public IRequestContext getRequestContext() {
		return __RequestContext;
	}

	private void setRequestContext(IRequestContext value) {
		__RequestContext = value;
	}

	/**
	 * Gets the collection enumerators available for traversing through results.
	 */
	@Override
	public IResourceCollectionEnumeratorContainer getEnumerators() {
		if (this.enumeratorContainer == null) {
			this.enumeratorContainer = new ResourceCollectionEnumeratorContainer(
					this);
		}
		return this.enumeratorContainer;
	}

	/**
	 * Gets the offer categories operations available to the partner.
	 */
	@Override
	public ICountrySelector<IOfferCategoryCollection> getOfferCategories() {
		if (this.offerCategories == null) {
			this.offerCategories = new OfferCategoryCountrySelector(this);
		}
		return this.offerCategories;
	}

	/**
	 * Gets the partner profiles operations.
	 */
	@Override
	public IPartnerProfileCollection getProfiles() {

		if (this.profiles == null) {
			this.profiles = new PartnerProfileCollectionOperations(this);
		}
		return this.profiles;
	}

	/**
	 * Gets the partner customers operations.
	 */
	@Override
	public ICustomerCollection getCustomers() {
		if (this.customers == null) {
			this.customers = new CustomerCollectionOperations(this);
		}
		return this.customers;
	}

	/**
	 * Gets the offer operations available to the partner.
	 */
	@Override
	public ICountrySelector<IOfferCollection> getOffers() {
		if (this.offers == null) {
			this.offers = new OfferCountrySelector(this);
		}
		return this.offers;
	}

	/**
	 * Gets the partner's invoices.
	 */
	@Override
	public IInvoiceCollection getInvoices() {
		if (this.invoices == null) {
			this.invoices = new InvoiceCollection(this);
		}
		return this.invoices;
	}

	/**
	 * Gets the Service Request operations available.
	 */
	@Override
	public IPartnerServiceRequestCollection getServiceRequests() {
		if (this.serviceRequests == null) {
			this.serviceRequests = new PartnerServiceRequestCollectionOperations(
					this);
		}
		return this.serviceRequests;
	}

	/**
	 * Gets the Service incidents operations available.
	 */
	@Override
	public IServiceIncidentCollection getServiceIncidents() {
		if (this.serviceIncidents == null) {
			this.serviceIncidents = new ServiceIncidentCollectionOperations(
					this);
		}
		return this.serviceIncidents;
	}

	/**
	 * Gets the usage summary operations available to the partner.
	 */
	@Override
	public IPartnerUsageSummary getUsageSummary() {
		if (this.usageSummary == null) {
			this.usageSummary = new PartnerUsageSummaryOperations(this);
		}
		return this.usageSummary;
	}

	/**
	 * Gets the audit records operations available to the partner.
	 */
	@Override
	public IAuditRecordsCollection getAuditRecords() {
		if (this.auditRecords == null) {
			this.auditRecords = new AuditRecordsCollection(this);
		}
		return this.auditRecords;
	}

	/**
	 * Gets the country validation rules operations available to the partner.
	 */
	@Override
	public ICountryValidationRulesCollection getCountryValidationRules() {
		if (this.countryValidationRules == null) {
			this.countryValidationRules = new CountryValidationRulesCollectionOperations(
					this);
		}
		return this.countryValidationRules;
	}

	/**
	 * Gets the domain operations available to the partner.
	 */
	@Override
	public IDomainCollection getDomains() {
		if (this.domains == null) {
			this.domains = new DomainCollectionOperations(this);
		}
		return this.domains;
	}

	/**
	 * Gets the rate card operations available to the partner.
	 */
	@Override
	public IRateCardCollection getRateCards() {
		if (this.rateCards == null) {
			this.rateCards = new RateCardCollectionOperations(this);
		}
		return this.rateCards;
	}

	/**
	 * Gets the analytics operations available to the partner
	 */
	@Override
	public IPartnerAnalyticsCollection getAnalytics() {
		if (this.analytics == null) {
			this.analytics = new PartnerAnalyticsCollectionOperations(this);
		}
		return this.analytics;
	}
}
