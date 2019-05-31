package com.NexusPortalAutomation.TestCases.Java;

import java.io.IOException;

import org.testng.annotations.Test;

import com.NexusPortalAutomation.PageObjects.Java.DashBoard;
import com.NexusPortalAutomation.PageObjects.Java.DashBoardSearch;
import com.NexusPortalAutomation.Utilities.Java.CommonMethods;

public class TC0003_TestSearchAutobyLastName extends BaseClass {

	/*
	 * This test the search by Customer's Last Name
	 * 
	 * @author Talha Rahim
	 * 
	 * @version 1.0
	 * 
	 * @Since 2019-04-11
	 */

	public String UserName = "Mr. Automation Mate";
	public CommonMethods ComMethd = new CommonMethods();

	@Test(priority = 3)
	public void TestSearchAutobyLastName() throws IOException, InterruptedException {
		DashBoardSearch dbSrch = new DashBoardSearch(driver);
		DashBoard dashBoard = new DashBoard(driver);
		login();
		dbSrch.EnterSearchText("Mate");
		dbSrch.ClickCustomer();
		// Verify Login by Last Name
		ComMethd.VerifyString(UserName, dashBoard.GetLoggedCustomerName());
		dashBoard.LogOut();

	}

}
