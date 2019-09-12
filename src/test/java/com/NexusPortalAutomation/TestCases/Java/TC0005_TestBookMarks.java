package com.NexusPortalAutomation.TestCases.Java;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.NexusPortalAutomation.PageObjects.Java.DashBoard;
import com.NexusPortalAutomation.PageObjects.Java.DashBoardSearch;
import com.NexusPortalAutomation.Utilities.Java.CommonMethods;
import com.NexusPortalAutomation.Utilities.Java.ExcelData;

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
	public String locationID = ExcelData.getExcelData("Locations","stLocationID");//"STATEMENTS001";
	public CommonMethods cmnMethods = new CommonMethods();

	@Test(priority = 1)
	public void TestSearchAutobyBookMark() throws IOException, InterruptedException {
		DashBoardSearch dbSrch = new DashBoardSearch(driver);
		DashBoard dashBoard = new DashBoard(driver);
		login();
		cmnMethods.waitObjectByXpath(driver, "//input[@id='SRCH_Input']");
		cmnMethods.waitforObjectById(driver, "SRCH_Button_Favorites");
		dbSrch.enterSearchText(locationID);
		dbSrch.clickRecentSearchCustomerName();
		dashBoard.clickBookmarkDisabled();
		dashBoard.clickDashBoardBookMark();
		if (dashBoard.getDashBoardBookMarkValue().equals(locationID)) {
			cmnMethods.waitObjectByXpath(driver, "//div[@class='address-details']");
			log("Bookmark saved successfully");
			dashBoard.clickBookmarkEnabled();
		} else {
			Assert.fail("Location Id not matched "+dashBoard.getDashBoardBookMarkValue());
		}

		// Verify Correct User is appearing by Bookmark
		dashBoard.logout();
	}

}
