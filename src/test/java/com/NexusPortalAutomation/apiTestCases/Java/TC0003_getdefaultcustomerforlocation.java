package com.NexusPortalAutomation.apiTestCases.Java;

import org.json.JSONException;
import org.testng.annotations.Test;

import com.NexusPortalAutomation.ApiMain.Java.commonApiMethods;

public class TC0003_getdefaultcustomerforlocation {

    @Test
    public void testldefaultcustomerlocation() throws JSONException {
	String customerId = "VACANT";
	String customerName = "Mr. VACANT VACANT";
	String locationId = "LOC@0001";
	commonApiMethods.getdefaultCustomer(customerId, locationId, customerName);
	;

    }

    @Test
    public void testldefaultcustomerlocationOverridden() throws JSONException {
	String customerId = "500001";
	String customerName = "Mr. Gregg Lammon";
	String locationId = "TESTLOCATION001";
	commonApiMethods.getdefaultCustomer(customerId, locationId, customerName);
	;

    }
}
