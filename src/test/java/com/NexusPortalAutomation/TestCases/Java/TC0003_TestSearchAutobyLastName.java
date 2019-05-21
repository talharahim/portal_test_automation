package com.NexusPortalAutomation.TestCases.Java;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.NexusPortalAutomation.PageObjects.Java.DashBoard;
import com.NexusPortalAutomation.PageObjects.Java.DashBoardSearch;
import com.NexusPortalAutomation.Utilities.Java.CommonMethods;

public class TC0003_TestSearchAutobyLastName extends BaseClass {

	public String UserName = "Mr. Automation Mate";
	public CommonMethods ComMethd = new CommonMethods();

	@Test(priority = 3)
	public void TestSearchAutobyLastName() throws IOException, InterruptedException {
		DashBoardSearch dbSrch = new DashBoardSearch(driver);
		DashBoard dashBoard = new DashBoard(driver);
		login();
		dbSrch.EnterSearchText("Mate");
		dbSrch.ClickCustomer();
		// Verify Login by Last Name
		boolean Match = ComMethd.VerifyString(UserName, dashBoard.GetLoggedCustomerName());
		if (!Match) {
			log("User Name Not Matched");
		} else {
			log("User Name Matched =" + UserName);
		}
		dashBoard.LogOut();

	}

}
