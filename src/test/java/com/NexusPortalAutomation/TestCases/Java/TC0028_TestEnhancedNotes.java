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
	public String username = getCellvalue("TC0028", "username");// "Automation Mate";
	public String notes2 =  getCellvalue("TC0028", "notes2");//"Customer Test notes for AuTOMation";
	public String notes1 =  getCellvalue("TC0028", "notes1");//"Location Test Notes for Automation";
	public String title =  getCellvalue("TC0028", "title");//"Mr.";
	
//This Test will test the search by Customer's First Name
	@Test(priority = 2)
	public void TestSearchAutobyFirstName() throws IOException, InterruptedException {
		DashBoardSearch dbSrch = new DashBoardSearch(driver);
		DashBoard dashBoard = new DashBoard(driver);
		login();
		dbSrch.enterSearchText(username);
		dbSrch.clickCustomerName();
		// Verify Login Name
		CommonMethods.verifyString(title, dashBoard.getCustomertitle());
		CommonMethods.verifyString(username, dashBoard.getLoggedCustomerName());
		dashBoard.verifyEnhancedNotes(notes2, notes1);
		dashBoard.logout();

	}

}
