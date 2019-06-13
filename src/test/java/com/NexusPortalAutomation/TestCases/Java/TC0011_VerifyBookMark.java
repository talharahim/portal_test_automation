package com.NexusPortalAutomation.TestCases.Java;

import java.io.IOException;

import org.testng.annotations.Test;

import com.NexusPortalAutomation.PageObjects.Java.DashBoard;
import com.NexusPortalAutomation.PageObjects.Java.DashBoardSearch;
import com.NexusPortalAutomation.Utilities.Java.CommonMethods;

public class TC0011_VerifyBookMark extends BaseClass {

	/*
	 * This test the search by Recent Customer Name
	 * 
	 * @author Talha Rahim
	 * 
	 * @version 1.0
	 * 
	 * @Since 2019-04-11
	 */

	public String LocationID = "STATEMENTS001";
	CommonMethods ComMethd = new CommonMethods();

//This Test will test the search by Customer ID
	@Test
	public void TestBookMark() throws IOException, InterruptedException {
		DashBoardSearch dbSrch = new DashBoardSearch(driver);
		DashBoard dashBoard = new DashBoard(driver);
		login();
		dbSrch.EnterSearchText(LocationID);
		dbSrch.ClickRecentCustomerName();
		// Verify Customer Location Id Updated for Test
		ComMethd.VerifyString(LocationID,dashBoard.GetLoggedCustomerLocationId());
		// Click BookMark
		dashBoard.ClickBookMarkDisabled();
		dashBoard.LogOut();
		login();
		dbSrch.ClickHistoryCustomer();
		dbSrch.ClickRecentCustomerName();
		ComMethd.VerifyString(LocationID,dashBoard.GetLoggedCustomerLocationId());
		// Clear BookMark
		dashBoard.ClickBookMarkEnabled();
		// Verify if it is Marked
		// Click BookMark
		// Verify if it is UnMarked

		dashBoard.LogOut();

	}

}
