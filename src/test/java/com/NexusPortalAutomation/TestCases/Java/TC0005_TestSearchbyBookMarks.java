package com.NexusPortalAutomation.TestCases.Java;

import java.io.IOException;

import org.testng.annotations.Test;

import com.NexusPortalAutomation.PageObjects.Java.DashBoard;
import com.NexusPortalAutomation.PageObjects.Java.DashBoardSearch;
import com.NexusPortalAutomation.Utilities.Java.CommonMethods;

public class TC0005_TestSearchbyBookMarks extends BaseClass {

	public String username = "Noel Ford";
	public CommonMethods cmnMethods = new CommonMethods();

	//@Test(priority = 2)
	public void TestSearchAutobyBookMark() throws IOException, InterruptedException {
		DashBoardSearch dbSrch = new DashBoardSearch(driver);
		DashBoard dashBoard = new DashBoard(driver);
		WaitAngular();
		login();
		cmnMethods.waitObjectByXpath(driver, "//input[@id='SRCH_Input']");
		cmnMethods.waitforObjectById(driver, "toolbar-saved");
		WaitAngular();
		dbSrch.clickHistoryCustomer();
		dbSrch.clickCustomerName();
		cmnMethods.waitObjectByXpath(driver, "//div[@class='address-details']");
		// Verify Login Name
		boolean Match = cmnMethods.verifyString(username, dashBoard.getLoggedCustomerLocationId());
		if (!Match) {
			log("User Name Not Verified for Bookmark Functionality");
		} else {
			log("User Name Verified for Bookmark Functionality");
		}
		dashBoard.logout();
	
	}

}
