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

	public String UserName = "Mr. Alert Test";
	public CommonMethods ComMethd = new CommonMethods();

	@Test(priority = 2)
	public void TestSearchAlertOnLoad() throws IOException, InterruptedException {
		DashBoardSearch dbSrch = new DashBoardSearch(driver);
		DashBoard dashBoard = new DashBoard(driver);
		login();
		ComMethd.WaitForObjectbyXpath(driver, "//input[@id='SRCH_Input']");
		ComMethd.WaitForObjectbyId(driver, "toolbar-saved");
		dbSrch.EnterSearchText("Alert");
		dbSrch.ClickCustomer();
		ComMethd.WaitForObjectbyXpath(driver, "//div[@class='address-details']");
		// Verify Login Name
		ComMethd.VerifyString(UserName, dashBoard.GetLoggedCustomerName());
		dashBoard.ClickOk();
		log("Alert on Load Clicked");
		dashBoard.ClickAlertDescription();
		Thread.sleep(300);
		dashBoard.ClickOk();
		log("Alert on description Clicked");
		dashBoard.LogOut();

	}

}
