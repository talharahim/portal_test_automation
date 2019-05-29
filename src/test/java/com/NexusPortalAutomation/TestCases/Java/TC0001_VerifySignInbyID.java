package com.NexusPortalAutomation.TestCases.Java;

import java.io.IOException;

import org.testng.annotations.Test;

import com.NexusPortalAutomation.PageObjects.Java.DashBoard;
import com.NexusPortalAutomation.PageObjects.Java.DashBoardSearch;
import com.NexusPortalAutomation.Utilities.Java.CommonMethods;

public class TC0001_VerifySignInbyID extends BaseClass {

	public String CustomerID = "0000011111";
	CommonMethods ComMethd = new CommonMethods();
	/*
	 * This Class Will Test the search by Customer ID
	 * 
	 * 
	 * @author Talha Rahim
	 * 
	 * @version 1.0
	 * 
	 * @Since 2019-04-11
	 */

//This Test will test the search by Customer ID
	@Test(priority = 1)
	public void TestSearchID() throws IOException, InterruptedException {
		DashBoardSearch dbSrch = new DashBoardSearch(driver);
		DashBoard dashBoard = new DashBoard(driver);
		login();
		dbSrch.EnterSearchText(CustomerID);
		dbSrch.ClickCustomer();
		// Verify Login Name Updated for Test
		ComMethd.VerifyString(CustomerID, dashBoard.GetLoggedCustomerId());
		dashBoard.LogOut();
	}

}
