package com.NexusPortalAutomation.TestCases.Java;

import java.io.IOException;

import org.testng.annotations.Test;

import com.NexusPortalAutomation.PageObjects.Java.DashBoard;
import com.NexusPortalAutomation.PageObjects.Java.DashBoardSearch;
import com.NexusPortalAutomation.Utilities.Java.CommonMethods;

public class TC0028_TestEnhancedNotes extends BaseClass {
	/*
	 * This test the search by Customer's First Name
	 * 
	 * @author Talha Rahim
	 * 
	 * @version 1.0
	 * 
	 * @Since 2019-04-11
	 */

	public String UserName = "Automation Mate";
	CommonMethods ComMethd = new CommonMethods();
	public String Notes1 = "Customer Test notes for AuTOMation";
	public String Notes2 = "Location Test Notes for Automation";
	public String Title = "Mr.";

//This Test will test the search by Customer's First Name
	@Test(priority = 2)
	public void TestSearchAutobyFirstName() throws IOException, InterruptedException {
		DashBoardSearch dbSrch = new DashBoardSearch(driver);
		DashBoard dashBoard = new DashBoard(driver);
		login();
		dbSrch.EnterSearchText(UserName);
		dbSrch.ClickCustomer();
		// Verify Login Name

		ComMethd.VerifyString(Title, dashBoard.getCustomerTitle());
		ComMethd.VerifyString(UserName, dashBoard.GetLoggedCustomerName());
		dashBoard.verifyEnhancedNotes(Notes2, Notes1);
		dashBoard.LogOut();

	}

}
