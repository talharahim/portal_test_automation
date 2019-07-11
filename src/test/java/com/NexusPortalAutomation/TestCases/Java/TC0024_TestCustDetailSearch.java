package com.NexusPortalAutomation.TestCases.Java;

import java.io.IOException;

import org.testng.annotations.Test;

import com.NexusPortalAutomation.PageObjects.Java.DashBoard;
import com.NexusPortalAutomation.PageObjects.Java.DashBoardSearch;
import com.NexusPortalAutomation.Utilities.Java.CommonMethods;

public class TC0024_TestCustDetailSearch extends BaseClass {

	public String UserName = "Automation Mate";
	public String Result1 = "Mate, Automation";
	public String UserFname = "Automation";
	public String UserLname = "Mate";
	public String CustomerId = "AUTO1001";
	public String Location = "LOC@0002";
	CommonMethods ComMethd = new CommonMethods();
	public String Title = "Mr.";
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
		dbSrch.EnterSearchText(UserName);
		dbSrch.ClickCustomer();

		dashBoard.enterDashBoardSearch(UserFname);
		ComMethd.VerifyString(Result1, dashBoard.getDashBoardSearchResult1Name());
		dashBoard.clickDashBoardSearchResult1();
		dashBoard.VerifyString(UserName, dashBoard.GetLoggedCustomerName());

		dashBoard.enterDashBoardSearch(UserLname);
		ComMethd.VerifyString(Result1, dashBoard.getDashBoardSearchResult1Name());
		dashBoard.clickDashBoardSearchResult1();
		dashBoard.VerifyString(UserName, dashBoard.GetLoggedCustomerName());

		dashBoard.enterDashBoardSearch(CustomerId);
		ComMethd.VerifyString(CustomerId, dashBoard.getDashBoardSearchResult1CustomerId());
		dashBoard.clickDashBoardSearchResult1();
		dashBoard.VerifyString(CustomerId, dashBoard.GetLoggedCustomerId());

		dashBoard.enterDashBoardSearch(Location);
		ComMethd.VerifyString(Location, dashBoard.getDashBoardSearchResult1Location());
		dashBoard.clickDashBoardSearchResult1();
		
		dashBoard.VerifyString(Location, dashBoard.GetLoggedCustomerLocationId());
		

		dashBoard.LogOut();

	}

}
