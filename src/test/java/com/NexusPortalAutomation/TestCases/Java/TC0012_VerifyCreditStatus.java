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

	public String LocationID = "LOC@0001";
	public String LocationID2 = "TESTLOCATION01";
	public String LocationID3 = "TESTLOCATION03";
	CommonMethods ComMethd = new CommonMethods();

//This Test will test the search by Customer ID
	@Test(priority = 1)
	public void TestCreditStatus() throws IOException, InterruptedException {
		DashBoardSearch dbSrch = new DashBoardSearch(driver);
		DashBoard dashBoard = new DashBoard(driver);
		login();
		dbSrch.EnterSearchText(LocationID3);
		dbSrch.ClickCustomer();
		// Verify Customer Location Id Updated for Test
		ComMethd.VerifyString(LocationID3, dashBoard.GetLoggedCustomerLocationId());
		// Verify Good Credit
		dashBoard.VerifyCredit("EXCELLEN");
		dashBoard.LogOut();
		login();
		dbSrch.EnterSearchText(LocationID);
		dbSrch.ClickCustomer();
		// Verify Customer Location Id Updated for Test
		ComMethd.VerifyString(LocationID, dashBoard.GetLoggedCustomerLocationId());
		// Verify Good Credit
		dashBoard.VerifyCredit("BAD");
		dashBoard.LogOut();
//		login();
//		dbSrch.EnterSearchText(LocationID2);
//		dbSrch.ClickCustomer();
//		// Verify Customer Location Id Updated for Test
//		ComMethd.VerifyString(LocationID2, dashBoard.GetLoggedCustomerLocationId());
//		// Verify Good Credit
//		dashBoard.VerifyCredit("WORST");
//		dashBoard.LogOut();

	}

}
