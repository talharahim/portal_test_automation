package com.NexusPortalAutomation.TestCases.Java;

import java.io.IOException;

import org.testng.annotations.Test;

import com.NexusPortalAutomation.PageObjects.Java.DashBoard;
import com.NexusPortalAutomation.PageObjects.Java.DashBoardSearch;
import com.NexusPortalAutomation.Utilities.Java.CommonMethods;

public class TC0005_TestSearchbyBookMarks extends BaseClass {

	public String UserName = "Noel Ford";
	public CommonMethods ComMethd = new CommonMethods();

	@Test(priority = 2)
	public void TestSearchAutobyBookMark() throws IOException, InterruptedException {
		DashBoardSearch dbSrch = new DashBoardSearch(driver);
		DashBoard dashBoard = new DashBoard(driver);
		WaitAngular();
		login();
		ComMethd.WaitForObjectbyXpath(driver, "//input[@id='SRCH_Input']");
		ComMethd.WaitForObjectbyId(driver, "toolbar-saved");
		WaitAngular();
		dbSrch.ClickHistoryCustomer();
		dbSrch.ClickCustomer();
		ComMethd.WaitForObjectbyXpath(driver, "//div[@class='address-details']");
		// Verify Login Name
		boolean Match = ComMethd.VerifyString(UserName, dashBoard.GetLoggedCustomerName());
		if (!Match) {
			log("User Name Not Verified for Bookmark Functionality");
		} else {
			log("User Name Verified for Bookmark Functionality");
		}
		dashBoard.LogOut();
	
	}

}
