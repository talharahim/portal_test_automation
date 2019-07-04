package com.NexusPortalAutomation.TestCases.Java;

import java.io.IOException;

import org.testng.annotations.Test;

import com.NexusPortalAutomation.PageObjects.Java.DashBoard;
import com.NexusPortalAutomation.PageObjects.Java.DashBoardSearch;
import com.NexusPortalAutomation.Utilities.Java.CommonMethods;

public class TC0023_VerifyRecentWidget extends BaseClass {

	/*
	 * This test the search by Recent Customer Name
	 * 
	 * @author Talha Rahim
	 * 
	 * @version 1.0
	 * 
	 * @Since 2019-06-10
	 */

	public String LocationID = "LOC@0001";
	public String RecordType = "Payment";
	public String RecordAmount = "$14.74";
	public String RecordDate = "Apr 12, 2027";
	public String Title = "Transactions";

	CommonMethods ComMethd = new CommonMethods();

//This Test will test the search by Customer ID
	@Test(priority = 1)
	public void VerifyRecentWidget() throws IOException, InterruptedException {
		DashBoardSearch dbSrch = new DashBoardSearch(driver);
		DashBoard dashBoard = new DashBoard(driver);
		login();
		dbSrch.EnterSearchText(LocationID);
		dbSrch.ClickCustomer();
		// Verify Customer Location Id Updated for Test
		ComMethd.VerifyString(LocationID, dashBoard.GetLoggedCustomerLocationId());
		// Verify Contact is updated accordingly
		dashBoard.verifyRecent(RecordType, RecordDate, RecordAmount);
		dashBoard.ClickRecent_ViewAll();
		ComMethd.VerifyString(Title, dashBoard.GetTransactionPageTile());
		// Verify Updated details
		dashBoard.LogOut();
	}

}
