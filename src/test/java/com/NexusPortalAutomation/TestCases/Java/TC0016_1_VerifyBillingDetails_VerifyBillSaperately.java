package com.NexusPortalAutomation.TestCases.Java;

import java.io.IOException;

import org.testng.annotations.Test;

import com.NexusPortalAutomation.PageObjects.Java.DashBoard;
import com.NexusPortalAutomation.PageObjects.Java.DashBoardSearch;
import com.NexusPortalAutomation.Utilities.Java.CommonMethods;

public class TC0016_1_VerifyBillingDetails_VerifyBillSaperately extends BaseClass {

	/*
	 * This test the search by Recent Customer Name
	 * 
	 * @author Talha Rahim
	 * 
	 * @version 1.0
	 * 
	 * @Since 2019-06-11
	 */
	public String locationID = "BILLSAPERATE01";

	@Test
	public void VerifyTransactionsSaperatebill_saperate() throws IOException, InterruptedException {

		CommonMethods cmnMethods = new CommonMethods();
		DashBoardSearch dbSrch = new DashBoardSearch(driver);
		DashBoard dashBoard = new DashBoard(driver);
		login();
		dbSrch.enterSearchText(locationID);
		dbSrch.clickCustomerName();
		// Verify Customer Location Id Updated for Test
		cmnMethods.verifyString(locationID, dashBoard.getLoggedCustomerLocationId());
		// Verify Contact is updated accordingly
		dashBoard.clickTransactionLink();
		dashBoard.transaction_filterbyBill();
		// Verify Transaction details
		dashBoard.logout();
	}

}
