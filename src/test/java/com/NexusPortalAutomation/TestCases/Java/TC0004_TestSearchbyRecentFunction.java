package com.NexusPortalAutomation.TestCases.Java;

import java.io.IOException;

import org.testng.annotations.Test;

import com.NexusPortalAutomation.PageObjects.Java.DashBoard;
import com.NexusPortalAutomation.PageObjects.Java.DashBoardSearch;
import com.NexusPortalAutomation.Utilities.Java.CommonMethods;

public class TC0004_TestSearchbyRecentFunction extends BaseClass {

	public String CustomerAddress;
	public CommonMethods ComMethd = new CommonMethods();

	@Test(priority = 1)
	public void TestSearchAutobyRecent() throws IOException, InterruptedException {
		DashBoardSearch dbSrch = new DashBoardSearch(driver);
		DashBoard dashBoard = new DashBoard(driver);
		login();
		ComMethd.WaitForObjectbyXpath(driver, "//input[@id='SRCH_Input']");
		dbSrch.ClickRecent();
		CustomerAddress = dbSrch.GetRecentCustomerName();
		dbSrch.ClickCustomer();
		dashBoard.ClickDynamicOk();
		ComMethd.WaitForObjectbyXpath(driver, "//div[@class='address-details']");
		ComMethd.VerifyString(CustomerAddress, dashBoard.GetLoggedCustomerAddress());
		dashBoard.LogOut();

	}

}
