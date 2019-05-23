package com.NexusPortalAutomation.TestCases.Java;

import java.io.IOException;
import org.testng.annotations.Test;

import com.NexusPortalAutomation.PageObjects.Java.DashBoard;
import com.NexusPortalAutomation.PageObjects.Java.DashBoardSearch;
import com.NexusPortalAutomation.Utilities.Java.CommonMethods;

public class TC0013_VerifyContactEdit extends BaseClass {

	public String LocationID = "LOC@0004";
	String ssn = "2312";
	String lic = "Driv12312OUL312";
	String phone = "(900) 786-0102";
	String ext = "+ Ext. 0112";
	String email = "automation@cogsdale.com";
	String add = "007 Test Apt";
	String acsz = "New York NY 12345-67890";
	CommonMethods ComMethd = new CommonMethods();

//This Test will test the search by Customer ID
	@Test(priority = 1)
	public void TestContactEdit() throws IOException, InterruptedException {
		DashBoardSearch dbSrch = new DashBoardSearch(driver);
		DashBoard dashBoard = new DashBoard(driver);
		login();
		dbSrch.EnterSearchText(LocationID);
		dbSrch.ClickCustomer();
		// Verify Customer Location Id Updated for Test
	    ComMethd.VerifyString(LocationID, dashBoard.GetLoggedCustomerLocationId());
		// Verify Contact is updated accordingly
		dashBoard.ClickContactEdit();
		dashBoard.updatePhone1("09007860102112");
		dashBoard.updateEmail("automation@cogsdale.com");
		dashBoard.clickContactUpdate();
		// Verify Updated details
		dashBoard.VerifyCustomerDetails(ssn, lic, phone, ext, email, add, acsz);
		dashBoard.LogOut();
	}

}
