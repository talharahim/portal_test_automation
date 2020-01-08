package com.NexusPortalAutomation.TestCases.Java;

import java.io.IOException;

import org.testng.annotations.Test;

import com.NexusPortalAutomation.PageObjects.Java.DashBoard;
import com.NexusPortalAutomation.PageObjects.Java.DashBoardSearch;
import com.NexusPortalAutomation.Utilities.Java.CommonMethods;
import com.NexusPortalAutomation.Utilities.Java.ExcelData;

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
	public String locationID =   ExcelData.getExcelData("TC0004","locationID");//"ELECWAT001";
	public String customerAddress;
	//public 

	@Test(priority = 1)
	public void TestSearchAutobyRecent() throws IOException, InterruptedException {
		DashBoardSearch dbSrch = new DashBoardSearch(driver);
		DashBoard dashBoard = new DashBoard(driver);
		// Search using an account
		login();
		dbSrch.enterSearchText(locationID);
		dbSrch.clickCustomerName();
		CommonMethods.verifyString(locationID, dashBoard.getLoggedCustomerLocationId());
		dashBoard.logout(); 
		// Search Using Recent Icon
		login();
		CommonMethods.waitObjectByXpath(driver, "//input[@id='SRCH_Input']");
		dbSrch.clickRecentSearch();
		customerAddress = dbSrch.getRecentCustomerCity();
		dbSrch.clickCustomerName();
		dashBoard.clickDynamicOk();
		CommonMethods.waitObjectByXpath(driver, "//div[@class='address-details']");
		// Verify correct address is loaded
		CommonMethods.verifyString(customerAddress, dashBoard.getLoggedCustomerAddress());
		// Verify correct Customer is loaded
		CommonMethods.verifyString(locationID, dashBoard.getLoggedCustomerLocationId());
		dashBoard.logout();

	}

}
