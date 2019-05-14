package com.NexusPortalAutomation.TestCases.Java;

import java.io.IOException;

import org.testng.Assert;
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
		WaitAngular();
		login();
		ComMethd.WaitForObject(driver, "//input[@id='SRCH_Input']");
		dbSrch.ClickRecent();
		CustomerAddress = dbSrch.GetRecentCustomerName();
		dbSrch.ClickCustomer();
		dashBoard.ClickOk();

		ComMethd.WaitForObject(driver, "//div[@class='address-details']");
		boolean Match = ComMethd.VerifyString(CustomerAddress, dashBoard.GetLoggedCustomerAddress());
		if (!Match) {
			log("User Name Not Verified for Recent Functionality");
		} else {
			log("User Name Verified for Recent Functionality =" + CustomerAddress);
		}
		dashBoard.LogOut();
	
	}

}
