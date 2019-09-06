package com.NexusPortalAutomation.TestCases.Java;

import java.io.IOException;

import org.testng.annotations.Test;

import com.NexusPortalAutomation.PageObjects.Java.DashBoard;
import com.NexusPortalAutomation.PageObjects.Java.DashBoardSearch;
import com.NexusPortalAutomation.Utilities.Java.CommonMethods;

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

	public String username = "Alert Test";
	public CommonMethods cmnMethods = new CommonMethods();

	@Test(priority = 2)
	public void TestSearchAlertOnLoad() throws IOException, InterruptedException {
		DashBoardSearch dbSrch = new DashBoardSearch(driver);
		DashBoard dashBoard = new DashBoard(driver);
		login();
		cmnMethods.waitObjectByXpath(driver, "//input[@id='SRCH_Input']");
		cmnMethods.waitforObjectById(driver, "toolbar-saved");
		dbSrch.enterSearchText("Alert");
		dbSrch.clickCustomerName();
		cmnMethods.waitObjectByXpath(driver, "//div[@class='address-details']");
		// Verify Login Name
		cmnMethods.verifyString(username, dashBoard.getLoggedCustomerName());
		dashBoard.ClickOk();
		log("Alert on Load Clicked");
		dashBoard.ClickAlertDescription();
		Thread.sleep(300);
		dashBoard.ClickOk();
		log("Alert on description Clicked");
		dashBoard.logout();

	}

}
