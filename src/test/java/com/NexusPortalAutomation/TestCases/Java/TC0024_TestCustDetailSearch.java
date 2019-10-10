package com.NexusPortalAutomation.TestCases.Java;

import java.io.IOException;

import org.testng.annotations.Test;

import com.NexusPortalAutomation.PageObjects.Java.DashBoard;
import com.NexusPortalAutomation.PageObjects.Java.DashBoardSearch;
import com.NexusPortalAutomation.Utilities.Java.CommonMethods;

public class TC0024_TestCustDetailSearch extends BaseClass {

	public String username = getCellvalue("TC0024", "username");// "Automation Mate";
	public String Result1 = getCellvalue("TC0024", "Result1");// "Mate, Automation";
	public String userFname = getCellvalue("TC0024", "userFname");// "Automation";
	public String userLname = getCellvalue("TC0024", "userLname");// "Mate";
	public String customerId = getCellvalue("TC0024", "customerId");// "AUTO1001";
	public String locationID = getCellvalue("TC0024", "locationID");// "LOC@0002";
	
	public String title = getCellvalue("TC0024", "title");// "Mr.";
	/*
	 * This test the search by Customer's First Name
	 * 
	 * @author Talha Rahim
	 * 
	 * @version 1.0
	 * 
	 * @Since 2019-04-11
	 */

//This Test will test the search by Customer's First Name
	@Test(priority = 2)
	public void TestSearchAutobyFirstName() throws IOException, InterruptedException {
		DashBoardSearch dbSrch = new DashBoardSearch(driver);
		DashBoard dashBoard = new DashBoard(driver);
		login();
		dbSrch.enterSearchText(username);
		dbSrch.clickCustomerName();
		dashBoard.enterDashBoardSearch(userFname);
		CommonMethods.verifyString(Result1, dashBoard.getDashBoardSearchResult1Name());
		dashBoard.clickDashBoardSearchResult1();
		dashBoard.verifyString(username, dashBoard.getLoggedCustomerName());
		dashBoard.enterDashBoardSearch(userLname);
		CommonMethods.verifyString(Result1, dashBoard.getDashBoardSearchResult1Name());
		dashBoard.clickDashBoardSearchResult1();
		dashBoard.verifyString(username, dashBoard.getLoggedCustomerName());
		dashBoard.enterDashBoardSearch(customerId);
		CommonMethods.verifyString(customerId, dashBoard.getDashBoardSearchResult1CustomerId());
		dashBoard.clickDashBoardSearchResult1();
		dashBoard.verifyString(customerId, dashBoard.getLoggedCustId());
		dashBoard.enterDashBoardSearch(locationID);
		CommonMethods.verifyString(locationID, dashBoard.getDashBoardSearchResult1Location());
		dashBoard.clickDashBoardSearchResult1();
		dashBoard.verifyString(locationID, dashBoard.getLoggedCustomerLocationId());
		dashBoard.logout();

	}

}
