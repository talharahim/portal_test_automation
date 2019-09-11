package com.NexusPortalAutomation.TestCases.Java;

import java.io.IOException;

import org.testng.annotations.Test;

import com.NexusPortalAutomation.PageObjects.Java.DashBoard;
import com.NexusPortalAutomation.PageObjects.Java.DashBoardSearch;
import com.NexusPortalAutomation.Utilities.Java.CommonMethods;

public class TC0016_1_VerifyBillingDetails_SPA extends BaseClass {

	/*
	 * This test the search by Recent Customer Name
	 * 
	 * @author Talha Rahim
	 * 
	 * @version 1.0
	 * 
	 * @Since 2019-04-11
	 */

	public String locationID = "LOC@0001";
	CommonMethods cmnMethods = new CommonMethods();
	String spaURL = "CustomerID=0000011111&LocationID=LOC@0001&CogsDrillback=1";
	String paymentArrangementAmount = "$0.00";

//This Test will test the search by Customer ID
	@Test(priority = 1)
	public void VerifyBillingDetails_SPA() throws IOException, InterruptedException {
		DashBoardSearch dbSrch = new DashBoardSearch(driver);
		DashBoard dashBoard = new DashBoard(driver);
		login();
		dbSrch.enterSearchText(locationID);
		dbSrch.clickCustomerName();
		// Verify Customer Location Id Updated for Test
		cmnMethods.verifyString(locationID, dashBoard.getLoggedCustomerLocationId());
		// Verify Contact is updated accordingly
		// Verify SPA Information
		cmnMethods.verifyString(dashBoard.getPaymentArrangementDue(), "Payment Arrangement Due");
		cmnMethods.verifyString(dashBoard.getPaymentArrangementDueAmount(), paymentArrangementAmount);
		cmnMethods.verifyStringContains(dashBoard.getPaymentArrangementDueURL(), spaURL);
		dashBoard.logout();
	}

}
