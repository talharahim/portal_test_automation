package com.NexusPortalAutomation.TestCases.Java;

import java.io.IOException;

import org.testng.annotations.Test;

import com.NexusPortalAutomation.PageObjects.Java.DashBoard;
import com.NexusPortalAutomation.PageObjects.Java.DashBoardSearch;
import com.NexusPortalAutomation.Utilities.Java.CommonMethods;

public class TC0009_1_VerifyAccountSearch_NoAccounts extends BaseClass {

	/*
	 * This test the search by Recent Customer Name
	 * 
	 * @author Talha Rahim
	 * 
	 * @version 1.0
	 * 
	 * @Since 2019-04-11
	 */
 String locationID = "SINGLECUST01";
 String VerifyText ="No Other Accounts";
 CommonMethods cmnMethods = new CommonMethods();

//This Test will test the search by Customer ID
	@Test(priority = 1)
	public void TestSearchAccount() throws IOException, InterruptedException {
		DashBoardSearch dbSrch = new DashBoardSearch(driver);
		DashBoard dashBoard = new DashBoard(driver);
		login();
		dbSrch.enterSearchText(locationID);
		dbSrch.clickCustomerName();
		// Verify Customer Location Id Updated for Test
		cmnMethods.verifyString(locationID, dashBoard.GetLoggedCustomerId());
		// Verify Customer Details for location Provided
		cmnMethods.verifyString(VerifyText,dashBoard.getNoOtherAccount());
		// Verify the type/status of the account
		dashBoard.logout();
	}
}
