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

	public String username = "Automation Mate";
	public String title = "Mr.";
	public CommonMethods cmnMethods = new CommonMethods();

	@Test(priority = 3)
	public void TestSearchAutobyLastName() throws IOException, InterruptedException {
		DashBoardSearch dbSrch = new DashBoardSearch(driver);
		DashBoard dashBoard = new DashBoard(driver);
		login();
		dbSrch.enterSearchText("Mate");
		dbSrch.clickCustomerName();
		// Verify Login by Last Name
		cmnMethods.verifyString(title, dashBoard.getCustomertitle());
		cmnMethods.verifyString(username, dashBoard.getLoggedCustomerName());
		dashBoard.logout();

	}

}
