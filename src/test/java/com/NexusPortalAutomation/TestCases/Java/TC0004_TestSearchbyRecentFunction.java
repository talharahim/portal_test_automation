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
	public String UserName = "Sally Mackenzie";
	public String CustomerAddress;
	public CommonMethods ComMethd = new CommonMethods();

	@Test(priority = 1)
	public void TestSearchAutobyRecent() throws IOException, InterruptedException {
		DashBoardSearch dbSrch = new DashBoardSearch(driver);
		DashBoard dashBoard = new DashBoard(driver);
		// Search using an account
		login();
		dbSrch.EnterSearchText(UserName);
		dbSrch.ClickCustomer();
		ComMethd.VerifyString(UserName, dashBoard.GetLoggedCustomerName());
		dashBoard.LogOut();
		// Search Using Recent Icon
		login();
		ComMethd.WaitForObjectbyXpath(driver, "//input[@id='SRCH_Input']");
		dbSrch.ClickRecent();
		CustomerAddress = dbSrch.GetRecentCustomerStateCity();
		dbSrch.ClickCustomer();
		dashBoard.ClickDynamicOk();
		ComMethd.WaitForObjectbyXpath(driver, "//div[@class='address-details']");
		// Verify correct address is loaded
		ComMethd.VerifyString(CustomerAddress, dashBoard.GetLoggedCustomerAddress());
		// Verify correct Customer is loaded
		ComMethd.VerifyString(UserName, dashBoard.GetLoggedCustomerName());
		dashBoard.LogOut();

	}

}
