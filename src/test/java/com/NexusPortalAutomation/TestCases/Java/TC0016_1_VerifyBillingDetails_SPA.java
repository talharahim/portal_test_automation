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

	public String LocationID = "LOC@0001";

	CommonMethods ComMethd = new CommonMethods();
	String spaURL = "CustomerID=0000011111&LocationID=LOC@0001&CogsDrillback=1";
	String paymentArrangementAmount = "$0.00";

//This Test will test the search by Customer ID
	@Test(priority = 1)
	public void VerifyBillingDetails_SPA() throws IOException, InterruptedException {
		DashBoardSearch dbSrch = new DashBoardSearch(driver);
		DashBoard dashBoard = new DashBoard(driver);
		login();
		dbSrch.EnterSearchText(LocationID);
		dbSrch.ClickCustomer();
		// Verify Customer Location Id Updated for Test
		ComMethd.VerifyString(LocationID, dashBoard.GetLoggedCustomerLocationId());
		// Verify Contact is updated accordingly
		// Verify SPA Information

		ComMethd.VerifyString(dashBoard.getPaymentArrangementDue(), "Payment Arrangement Due");
		ComMethd.VerifyString(dashBoard.getPaymentArrangementDueAmount(), paymentArrangementAmount);
		ComMethd.VerifyStringContains(dashBoard.getPaymentArrangementDueURL(), spaURL);

		dashBoard.LogOut();
	}

}
