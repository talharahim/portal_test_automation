package com.NexusPortalAutomation.apiTestCases.Java;

import org.testng.annotations.Test;

import com.NexusPortalAutomation.ApiMain.Java.commonApiMethods;

public class TC0002_getaccountbalanceInvalidCustomer {

    @Test
    public void testaccountbalanceresponseforInvalidCustomer() {
	String customerId = "0000011111";
	String locationId = "ELECWAT001";
	String date = "2019-11-20";
	String Message = "CustomerId does not exist or does not exist at this LocationId.";
	String result = "false";
	commonApiMethods.getaccountbalancesInvalidCustomer(customerId, locationId, date, result, Message);

    }
}
