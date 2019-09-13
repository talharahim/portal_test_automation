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

	public String customerName = getCellvalue("Customers","statementuser");// "Statement Pdf";
	CommonMethods cmnMethods = new CommonMethods();

//This Test will test the search by Customer ID
	@Test
	public void TestBookMark() throws IOException, InterruptedException {
		DashBoardSearch dbSrch = new DashBoardSearch(driver);
		DashBoard dashBoard = new DashBoard(driver);
		login();
		dbSrch.enterSearchText(customerName);
		dbSrch.clickRecentSearchCustomerName();
		// Verify Customer Location Id Updated for Test
		cmnMethods.verifyString(customerName, dashBoard.getLoggedCustomerName());
		// Click BookMark
		dashBoard.clickBookmarkDisabled();
		dashBoard.logout();
		login();
		dbSrch.clickHistoryCustomer();
		dbSrch.clickRecentSearchCustomerName();
		cmnMethods.verifyString(customerName, dashBoard.getLoggedCustomerName());
		// Clear BookMark
		dashBoard.clickBookmarkEnabled();
		// Verify if it is Marked
		// Click BookMark
		// Verify if it is UnMarked

		dashBoard.logout();

	}

}
