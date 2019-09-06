package com.NexusPortalAutomation.TestCases.Java;

import java.io.IOException;

import org.testng.annotations.Test;

import com.NexusPortalAutomation.PageObjects.Java.DashBoard;
import com.NexusPortalAutomation.PageObjects.Java.DashBoardSearch;
import com.NexusPortalAutomation.Utilities.Java.CommonMethods;

public class TC0024_TestCustDetailSearch extends BaseClass {

	public String username = "Automation Mate";
	public String Result1 = "Mate, Automation";
	public String UserFname = "Automation";
	public String UserLname = "Mate";
	public String CustomerId = "AUTO1001";
	public String Location = "LOC@0002";
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

		dashBoard.enterDashBoardSearch(UserFname);
		cmnMethods.verifyString(Result1, dashBoard.getDashBoardSearchResult1Name());
		dashBoard.clickDashBoardSearchResult1();
		dashBoard.verifyString(username, dashBoard.getLoggedCustomerName());

		dashBoard.enterDashBoardSearch(UserLname);
		cmnMethods.verifyString(Result1, dashBoard.getDashBoardSearchResult1Name());
		dashBoard.clickDashBoardSearchResult1();
		dashBoard.verifyString(username, dashBoard.getLoggedCustomerName());

		dashBoard.enterDashBoardSearch(CustomerId);
		cmnMethods.verifyString(CustomerId, dashBoard.getDashBoardSearchResult1CustomerId());
		dashBoard.clickDashBoardSearchResult1();
		dashBoard.verifyString(CustomerId, dashBoard.GetLoggedCustomerId());

		dashBoard.enterDashBoardSearch(Location);
		cmnMethods.verifyString(Location, dashBoard.getDashBoardSearchResult1Location());
		dashBoard.clickDashBoardSearchResult1();
		
		dashBoard.verifyString(Location, dashBoard.getLoggedCustomerName());
		

		dashBoard.logout();

	}

}
