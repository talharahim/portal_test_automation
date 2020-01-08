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

	public String locationID = getCellvalue("TC0023", "loc1");//"LOC@0001";
	public String recordType = getCellvalue("TC0023", "recordType");// "Payment";
	public String recordAmount = getCellvalue("TC0023", "recordAmount");//"$14.74";
	public String recordDate = getCellvalue("TC0023", "recordDate");//"Apr 12, 2027";
	public String title = getCellvalue("TC0023", "title");//"TC0023";

	

//This Test will test the search by Customer ID
	@Test(priority = 1)
	public void VerifyRecentWidget() throws IOException, InterruptedException {
		DashBoardSearch dbSrch = new DashBoardSearch(driver);
		DashBoard dashBoard = new DashBoard(driver);
		login();
		dbSrch.enterSearchText(locationID);
		dbSrch.clickCustomerName();
		// Verify Customer Location Id Updated for Test
		CommonMethods.verifyString(locationID, dashBoard.getLoggedCustomerLocationId());
		// Verify Contact is updated accordingly
		dashBoard.verifyRecentRecord1(recordType, recordDate, recordAmount);
		dashBoard.clickRecentSearch_ViewAll();
		CommonMethods.verifyString(title, dashBoard.getTransactionPageTitle());
		// Verify Updated details
		dashBoard.logout();
	}

}
