package com.NexusPortalAutomation.TestCases.Java;

import java.io.IOException;

import org.testng.annotations.Test;

import com.NexusPortalAutomation.PageObjects.Java.DashBoard;
import com.NexusPortalAutomation.PageObjects.Java.DashBoardSearch;
import com.NexusPortalAutomation.Utilities.Java.CommonMethods;
import com.NexusPortalAutomation.Utilities.Java.ExcelData;

public class TC0006_TestAlertOnLoad extends BaseClass {

	/*
	 * This test the search by Recent Customer Name
	 * 
	 * @author Talha Rahim
	 * 
	 * @version 1.0
	 * 
	 * @Since 2019-04-11
	 */

	public String username = ExcelData.getExcelData("TC0006","alUsername");// "AUTOLOC001";
	//public 

	@Test(priority = 2)
	public void TestSearchAlertOnLoad() throws IOException, InterruptedException {
		DashBoardSearch dbSrch = new DashBoardSearch(driver);
		DashBoard dashBoard = new DashBoard(driver);
		login();
		CommonMethods.waitObjectByXpath(driver, "//input[@id='SRCH_Input']");
		CommonMethods.waitforObjectById(driver, "toolbar-saved");
		dbSrch.enterSearchText("Alert");
		dbSrch.clickCustomerName();
		CommonMethods.waitObjectByXpath(driver, "//div[@class='address-details']");
		// Verify Login Name
		CommonMethods.verifyString(username, dashBoard.getLoggedCustomerLocationId());
		dashBoard.clickOk();
		log("Alert on Load Clicked");
		dashBoard.clickAlertdesc();
		Thread.sleep(300);
		dashBoard.clickOk();
		log("Alert on description Clicked");
		dashBoard.logout();

	}

}
