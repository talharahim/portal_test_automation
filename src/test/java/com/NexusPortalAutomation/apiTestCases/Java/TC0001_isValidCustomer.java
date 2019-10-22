package com.NexusPortalAutomation.apiTestCases.Java;

import org.testng.annotations.Test;

import com.NexusPortalAutomation.ApiMain.Java.commonApiMethods;

public class TC0001_isValidCustomer {

	@Test
	public static void isvalidCustomer() {
		String customerId = "0000011111";
		String locationId = "LOC@0004";
		String date = "2019-11-20";
		boolean response = true;
		commonApiMethods.isValidCustomercanmovein(customerId, locationId, date, response);
	}

	@Test
	public static void isNotvalidCustomer() {
		String customerId = "VACANT";
		String locationId = "LOC@0004";
		String date = "2019-11-20";
		boolean response = true;
		commonApiMethods.isValidCustomercanmovein(customerId, locationId, date, response);
	}
}
