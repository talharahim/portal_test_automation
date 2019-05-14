package com.NexusPortalAutomation.TestCases.Java;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.NexusPortalAutomation.PageObjects.Java.DashBoard;
import com.NexusPortalAutomation.PageObjects.Java.DashBoardSearch;
import com.NexusPortalAutomation.Utilities.Java.CommonMethods;

public class TC0002_TestSearchAutobyFirstName extends BaseClass {

	public String UserName = "Mr. Automation Mate";
	CommonMethods ComMethd = new CommonMethods();

//This Test will test the search by Customer Name
	@Test(priority = 2)
	public void TestSearchAutobyFirstName() throws IOException, InterruptedException {
		DashBoardSearch dbSrch = new DashBoardSearch(driver);
		DashBoard dashBoard = new DashBoard(driver);
		WaitAngular();
		login();
		WaitAngular();
		dbSrch.EnterSearchText("Automation");
		WaitAngular();
		dbSrch.ClickCustomer();
		WaitAngular();
		// Verify Login Name
		boolean Match = ComMethd.VerifyString(UserName, dashBoard.GetLoggedCustomerName());
		if (!Match) {
			log("User Name Not Matched");
		} else {
			log("User Name Matched =" + UserName);
		}
		dashBoard.LogOut();
		
	}

}
