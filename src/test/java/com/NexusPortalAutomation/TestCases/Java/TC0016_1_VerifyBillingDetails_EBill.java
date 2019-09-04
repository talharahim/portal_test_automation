package com.NexusPortalAutomation.TestCases.Java;

import java.io.IOException;

import org.testng.annotations.Test;

import com.NexusPortalAutomation.PageObjects.Java.DashBoard;
import com.NexusPortalAutomation.PageObjects.Java.DashBoardSearch;
import com.NexusPortalAutomation.Utilities.Java.CommonMethods;

public class TC0016_1_VerifyBillingDetails_EBill extends BaseClass {

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
	public String LocationID2 = "LOC@0002";

	CommonMethods ComMethd = new CommonMethods();
	String Ebill = "ON";
	String Ebilloff = "OFF";
	String AutoPayURL = "https://www.invoicecloud.com/integrations/redirect/Csr?BillerGUID";

//This Test will test the search by Customer ID
	@Test(priority = 1)
	public void VerifyBillingDetails() throws IOException, InterruptedException {
		DashBoardSearch dbSrch = new DashBoardSearch(driver);
		DashBoard dashBoard = new DashBoard(driver);
		login();
		dbSrch.EnterSearchText(LocationID);
		dbSrch.ClickCustomer();
		// Verify Customer Location Id Updated for Test
		ComMethd.VerifyString(LocationID, dashBoard.GetLoggedCustomerLocationId());
		// Verify Billing Information
		ComMethd.VerifyString(dashBoard.getEBill(), Ebill);
		dashBoard.LogOut();
		// Verifying Ebill Location off
		login();
		dbSrch.EnterSearchText(LocationID2);
		dbSrch.ClickCustomer();
		// Verify Customer Location Id Updated for Test
		ComMethd.VerifyString(LocationID2, dashBoard.GetLoggedCustomerLocationId());
		// Verify Billing Information
		ComMethd.VerifyString(dashBoard.getEBill(), Ebilloff);
		dashBoard.LogOut();
	}

}
