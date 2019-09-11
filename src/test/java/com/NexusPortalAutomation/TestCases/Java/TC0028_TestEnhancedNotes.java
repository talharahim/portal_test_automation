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

	public String username = "Automation Mate";
	CommonMethods cmnMethods = new CommonMethods();
	public String notes1 = "Customer Test notes for AuTOMation";
	public String notes2 = "Location Test Notes for Automation";
	public String title = "Mr.";

//This Test will test the search by Customer's First Name
	@Test(priority = 2)
	public void TestSearchAutobyFirstName() throws IOException, InterruptedException {
		DashBoardSearch dbSrch = new DashBoardSearch(driver);
		DashBoard dashBoard = new DashBoard(driver);
		login();
		dbSrch.enterSearchText(username);
		dbSrch.clickCustomerName();
		// Verify Login Name

		cmnMethods.verifyString(title, dashBoard.getCustomertitle());
		cmnMethods.verifyString(username, dashBoard.getLoggedCustomerName());
		dashBoard.verifyEnhancedNotes(notes2, notes1);
		dashBoard.logout();

	}

}
