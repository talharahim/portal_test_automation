package com.NexusPortalAutomation.TestCases.Java;

import java.io.IOException;

import org.testng.annotations.Test;

import com.NexusPortalAutomation.PageObjects.Java.DashBoard;
import com.NexusPortalAutomation.PageObjects.Java.DashBoardSearch;
import com.NexusPortalAutomation.Utilities.Java.CommonMethods;

public class TC0005_TestSearchbyBookMarks extends BaseClass {

	/*
	 * This test the search by Recent Customer Name
	 * 
	 * @author Talha Rahim
	 * 
	 * @version 1.0
	 * 
	 * @Since 2019-04-11
	 */

	public String UserName = "Noel Ford";
	public CommonMethods ComMethd = new CommonMethods();

	@Test(priority = 1)
	public void TestSearchAutobyBookMark() throws IOException, InterruptedException {
		DashBoardSearch dbSrch = new DashBoardSearch(driver);
		DashBoard dashBoard = new DashBoard(driver);
		login();
		ComMethd.WaitForObjectbyXpath(driver, "//input[@id='SRCH_Input']");
		ComMethd.WaitForObjectbyId(driver, "toolbar-saved");
		dbSrch.ClickHistoryCustomer();
		dbSrch.ClickCustomer();
		ComMethd.WaitForObjectbyXpath(driver, "//div[@class='address-details']");
		// Verify Correct User is appearing by Bookmark
	    ComMethd.VerifyString(UserName, dashBoard.GetLoggedCustomerName());
		dashBoard.LogOut();
	}

}
