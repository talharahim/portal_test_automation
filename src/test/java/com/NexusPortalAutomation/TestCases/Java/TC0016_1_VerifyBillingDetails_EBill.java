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

	public String locationID =  getCellvalue("TC0016", "loc1");//"LOC@0001";
	public String locationID2 =  getCellvalue("TC0016", "loc2");//"LOC@0002";
	CommonMethods cmnMethods = new CommonMethods();
	String ebill = getCellvalue("TC0016", "eBill");// "ON";
	String ebilloff = getCellvalue("TC0016", "eBillBudget");//"OFF";
	String autoPayURL =  getCellvalue("TC0016", "autoPayUrl");//"https://www.invoicecloud.com/integrations/redirect/Csr?BillerGUID";

//This Test will test the search by Customer ID
	@Test(priority = 1)
	public void VerifyBillingDetails() throws IOException, InterruptedException {
		DashBoardSearch dbSrch = new DashBoardSearch(driver);
		DashBoard dashBoard = new DashBoard(driver);
		login();
		dbSrch.enterSearchText(locationID);
		dbSrch.clickCustomerName();
		// Verify Customer Location Id Updated for Test
		cmnMethods.verifyString(locationID, dashBoard.getLoggedCustomerLocationId());
		// Verify Billing Information
		cmnMethods.verifyString(dashBoard.getEBill(), ebill);
		dashBoard.logout();
		// Verifying Ebill Location off
		login();
		dbSrch.enterSearchText(locationID2);
		dbSrch.clickCustomerName();
		// Verify Customer Location Id Updated for Test
		cmnMethods.verifyString(locationID2, dashBoard.getLoggedCustomerLocationId());
		// Verify Billing Information
		cmnMethods.verifyString(dashBoard.getEBill(), ebilloff);
		dashBoard.logout();
	}

}
