package com.NexusPortalAutomation.TestCases.Java;

import java.io.IOException;

import org.testng.annotations.Test;

import com.NexusPortalAutomation.PageObjects.Java.DashBoard;
import com.NexusPortalAutomation.PageObjects.Java.DashBoardSearch;
import com.NexusPortalAutomation.Utilities.Java.CommonMethods;

public class TC0012_VerifyCreditStatus extends BaseClass {

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
	public String locationID2 = "TESTLOCATION01";
	public String locationID3 = "TESTLOCATION03";
	CommonMethods cmnMethods = new CommonMethods();

//This Test will test the search by Customer ID
	@Test(priority = 1)
	public void TestCreditStatus() throws IOException, InterruptedException {
		DashBoardSearch dbSrch = new DashBoardSearch(driver);
		DashBoard dashBoard = new DashBoard(driver);
		login();
		dbSrch.enterSearchText(locationID3);
		dbSrch.clickCustomerName();
		// Verify Customer Location Id Updated for Test
		cmnMethods.verifyString(locationID3, dashBoard.getLoggedCustomerName());
		// Verify Good Credit
		dashBoard.VerifyCredit("EXCELLEN");
		dashBoard.logout();
		login();
		dbSrch.enterSearchText(locationID);
		dbSrch.clickCustomerName();
		// Verify Customer Location Id Updated for Test
		cmnMethods.verifyString(locationID, dashBoard.getLoggedCustomerName());
		// Verify Good Credit
		dashBoard.VerifyCredit("BAD");
		dashBoard.logout();
//		login();
//		dbSrch.enterSearchText(locationID2);
//		dbSrch.clickCustomerName();
//		// Verify Customer Location Id Updated for Test
//		cmnMethods.VerifyString(locationID2, dashBoard.GetLoggedCustomerlocationID());
//		// Verify Good Credit
//		dashBoard.VerifyCredit("WORST");
//		dashBoard.logout();

	}

}
