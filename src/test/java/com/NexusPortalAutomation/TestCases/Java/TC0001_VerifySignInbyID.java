package com.NexusPortalAutomation.TestCases.Java;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.NexusPortalAutomation.PageObjects.Java.DashBoard;
import com.NexusPortalAutomation.PageObjects.Java.DashBoardSearch;
import com.NexusPortalAutomation.Utilities.Java.CommonMethods;

public class TC0001_VerifySignInbyID extends BaseClass {

	public String CustomerID = "0000011111";
	CommonMethods ComMethd = new CommonMethods();
	

//This Test will test the search by Customer Name
	@Test(priority = 1)
	public void TestSearchID() throws IOException, InterruptedException {
		DashBoardSearch dbSrch = new DashBoardSearch(driver);
		DashBoard dashBoard = new DashBoard(driver);
		WaitAngular();
		login();
		WaitAngular();
		dbSrch.EnterSearchText(CustomerID);
		WaitAngular();
		dbSrch.ClickCustomer();
		WaitAngular();
		// Verify Login Name Updated for Test
		boolean Match = ComMethd.VerifyString(CustomerID, dashBoard.GetLoggedCustomerId());
		if (!Match) {
			log("Customer ID Not Matched");
		} else {
			log("Customer ID Matched =" + CustomerID);
		}
		dashBoard.LogOut();
		
	}

}
