// -----------------------------------------------------------------------
// <copyright file="CustomerServiceRequestOperations.java" company="Microsoft">
//      Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
// -----------------------------------------------------------------------

package com.microsoft.store.partnercenter.servicerequests;

import java.text.MessageFormat;
import java.util.Locale;

import com.fasterxml.jackson.core.type.TypeReference;
import com.microsoft.store.partnercenter.BasePartnerComponent;
import com.microsoft.store.partnercenter.IPartner;
import com.microsoft.store.partnercenter.PartnerService;
import com.microsoft.store.partnercenter.models.servicerequests.ServiceRequest;
import com.microsoft.store.partnercenter.models.utils.Tuple;
import com.microsoft.store.partnercenter.network.IPartnerServiceProxy;
import com.microsoft.store.partnercenter.network.PartnerServiceProxy;
import com.microsoft.store.partnercenter.utils.StringHelper;

/**
 * Implements operations that can be performed on a single customer's service requests.
 */
public class CustomerServiceRequestOperations
    extends BasePartnerComponent<Tuple<String, String>>
    implements IServiceRequest
{
    /**
     * Initializes a new instance of the {@link #CustomerServiceRequestOperations} class.
     * 
     * @param rootPartnerOperations The root partner operations instance.
     * @param customerId The customer tenant Id.
     * @param serviceRequestId The service Request Id
     */
    public CustomerServiceRequestOperations( IPartner rootPartnerOperations, String customerId,
                                             String serviceRequestId )
    {
        super( rootPartnerOperations, new Tuple<String, String>( customerId, serviceRequestId ) );
        if ( StringHelper.isNullOrWhiteSpace( customerId ) )
        {
            throw new IllegalArgumentException( "customerId can't be null" );
        }

        if ( StringHelper.isNullOrWhiteSpace( serviceRequestId ) )
        {
            throw new IllegalArgumentException( "serviceRequestId can't be null" );
        }

    }

    /**
     * Get Service Request By customer ID
     * 
     * @return Service Request
     */
    @Override
    public ServiceRequest get()
    {
        IPartnerServiceProxy<ServiceRequest, ServiceRequest> partnerServiceProxy =
            new PartnerServiceProxy<ServiceRequest, ServiceRequest>( new TypeReference<ServiceRequest>()
            {
            }, this.getPartner(), MessageFormat.format( PartnerService.getInstance().getConfiguration().getApis().get( "GetServiceRequestCustomer" ).getPath(),
                                                        this.getContext().getItem1(), this.getContext().getItem2(),
                                                        Locale.US ) );

        return partnerServiceProxy.get();
    }

    /**
     * Patches a Service Request
     * 
     * @param updatePayload Payload of the update request
     * @return Updated Service Request
     */
    @Override
    public ServiceRequest patch( ServiceRequest updatePayload )
    {
        IPartnerServiceProxy<ServiceRequest, ServiceRequest> partnerServiceProxy =
            new PartnerServiceProxy<ServiceRequest, ServiceRequest>( new TypeReference<ServiceRequest>()
            {
            }, this.getPartner(), MessageFormat.format( PartnerService.getInstance().getConfiguration().getApis().get( "UpdateServiceRequestCustomer" ).getPath(),
                                                        this.getContext().getItem1(), this.getContext().getItem2(),
                                                        Locale.US ) );

        return partnerServiceProxy.patch( updatePayload );
    }
}
