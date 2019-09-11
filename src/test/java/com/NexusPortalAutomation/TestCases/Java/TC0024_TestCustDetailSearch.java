package com.NexusPortalAutomation.TestCases.Java;

import java.io.IOException;

import org.testng.annotations.Test;

import com.NexusPortalAutomation.PageObjects.Java.DashBoard;
import com.NexusPortalAutomation.PageObjects.Java.DashBoardSearch;
import com.NexusPortalAutomation.Utilities.Java.CommonMethods;

public class TC0024_TestCustDetailSearch extends BaseClass {

	public String username = "Automation Mate";
	public String Result1 = "Mate, Automation";
	public String userFname = "Automation";
	public String userLname = "Mate";
	public String customerId = "AUTO1001";
	public String locationID = "LOC@0002";
	CommonMethods cmnMethods = new CommonMethods();
	public String title = "Mr.";
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
		cmnMethods.verifyString(Result1, dashBoard.getDashBoardSearchResult1Name());
		dashBoard.clickDashBoardSearchResult1();
		dashBoard.verifyString(username, dashBoard.getLoggedCustomerName());
		dashBoard.enterDashBoardSearch(userLname);
		cmnMethods.verifyString(Result1, dashBoard.getDashBoardSearchResult1Name());
		dashBoard.clickDashBoardSearchResult1();
		dashBoard.verifyString(username, dashBoard.getLoggedCustomerName());
		dashBoard.enterDashBoardSearch(customerId);
		cmnMethods.verifyString(customerId, dashBoard.getDashBoardSearchResult1CustomerId());
		dashBoard.clickDashBoardSearchResult1();
		dashBoard.verifyString(customerId, dashBoard.getLoggedCustId());
		dashBoard.enterDashBoardSearch(locationID);
		cmnMethods.verifyString(locationID, dashBoard.getDashBoardSearchResult1Location());
		dashBoard.clickDashBoardSearchResult1();
		dashBoard.verifyString(locationID, dashBoard.getLoggedCustomerLocationId());
		dashBoard.logout();

	}

}
