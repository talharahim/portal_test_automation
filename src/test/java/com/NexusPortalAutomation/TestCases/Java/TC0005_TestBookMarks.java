package com.NexusPortalAutomation.TestCases.Java;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.NexusPortalAutomation.PageObjects.Java.DashBoard;
import com.NexusPortalAutomation.PageObjects.Java.DashBoardSearch;
import com.NexusPortalAutomation.Utilities.Java.CommonMethods;

public class TC0005_TestBookMarks extends BaseClass {

	/*
	 * This test the search by Recent Customer Name
	 * 
	 * @author Talha Rahim
	 * 
	 * @version 1.0
	 * 
	 * @Since 2019-04-11
	 */
	public String LocationID = "STATEMENTS001";
	public CommonMethods ComMethd = new CommonMethods();

	@Test(priority = 1)
	public void TestSearchAutobyBookMark() throws IOException, InterruptedException {
		DashBoardSearch dbSrch = new DashBoardSearch(driver);
		DashBoard dashBoard = new DashBoard(driver);
		login();
		ComMethd.WaitForObjectbyXpath(driver, "//input[@id='SRCH_Input']");
		ComMethd.WaitForObjectbyId(driver, "SRCH_Button_Favorites");
		dbSrch.EnterSearchText(LocationID);
		dbSrch.ClickRecentCustomerName();
		dashBoard.ClickBookMarkDisabled();
		dashBoard.clickDashBoardBookMark();
		if (dashBoard.getDashBoardBookMarkValue().equals(LocationID)) {
			ComMethd.WaitForObjectbyXpath(driver, "//div[@class='address-details']");
			log("Bookmark saved successfully");
			dashBoard.ClickBookMarkEnabled();
		} else {
			Assert.assertTrue(false,"Location Id not matched "+dashBoard.getDashBoardBookMarkValue());
		}

		// Verify Correct User is appearing by Bookmark

		dashBoard.LogOut();
	}

}
