package com.NexusPortalAutomation.TestCases.Java;

import java.io.IOException;

import org.testng.annotations.Test;

import com.NexusPortalAutomation.PageObjects.Java.DashBoard;
import com.NexusPortalAutomation.PageObjects.Java.DashBoardSearch;
import com.NexusPortalAutomation.Utilities.Java.CommonMethods;

public class TC0004_TestSearchbyRecentFunction extends BaseClass {

	/*
	 * This test the search by Recent Customer Name
	 * 
	 * @author Talha Rahim
	 * 
	 * @version 1.0
	 * 
	 * @Since 2019-04-11
	 */
	public String username = "Sally Mackenzie";
	public String customerAddress;
	public CommonMethods cmnMethods = new CommonMethods();

	@Test(priority = 1)
	public void TestSearchAutobyRecent() throws IOException, InterruptedException {
		DashBoardSearch dbSrch = new DashBoardSearch(driver);
		DashBoard dashBoard = new DashBoard(driver);
		// Search using an account
		login();
		dbSrch.enterSearchText(username);
		dbSrch.clickCustomerName();
		cmnMethods.verifyString(username, dashBoard.getLoggedCustomerName());
		dashBoard.logout(); 
		// Search Using Recent Icon
		login();
		cmnMethods.waitObjectByXpath(driver, "//input[@id='SRCH_Input']");
		dbSrch.clickRecentSearch();
		customerAddress = dbSrch.getRecentCustomerCity();
		dbSrch.clickCustomerName();
		dashBoard.clickDynamicOk();
		cmnMethods.waitObjectByXpath(driver, "//div[@class='address-details']");
		// Verify correct address is loaded
		cmnMethods.verifyString(customerAddress, dashBoard.getLoggedCustomerAddress());
		// Verify correct Customer is loaded
		cmnMethods.verifyString(username, dashBoard.getLoggedCustomerName());
		dashBoard.logout();

	}

}
