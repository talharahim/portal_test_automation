package com.NexusPortalAutomation.TestCases.Java;

import java.io.IOException;
import org.testng.annotations.Test;

import com.NexusPortalAutomation.PageObjects.Java.DashBoard;
import com.NexusPortalAutomation.PageObjects.Java.DashBoardSearch;
import com.NexusPortalAutomation.Utilities.Java.CommonMethods;

public class TC0013_VerifyContactEdit extends BaseClass {

	/*
	 * This test the search by Recent Customer Name
	 * 
	 * @author Talha Rahim
	 * 
	 * @version 1.0
	 * 
	 * @Since 2019-04-11
	 */

	public String locationID = getCellvalue("TC0013", "locationEdit");//"LOC@0004";
	String ssn = getCellvalue("TC0013", "ssnEdit");//"2312";
	String lic = getCellvalue("TC0013", "licEdit");//"Driv12312OUL312";
	String phone = getCellvalue("TC0013", "phoneEdit");//"(090) 078-6010";
	String ext = getCellvalue("TC0013", "extEdit");//"+ Ext. 2112";
	String email = getCellvalue("TC0013", "emailEdit");//"automation@cogsdale.com";
	String add = getCellvalue("TC0013", "addEdit");//"007 Test Apt";
	String acsz = getCellvalue("TC0013", "acszEdit");//"New York NY 12345-67890";
	CommonMethods cmnMethods = new CommonMethods();

//This Test will test the search by Customer ID
	@Test(priority = 1)
	public void TestContactEdit() throws IOException, InterruptedException {
		DashBoardSearch dbSrch = new DashBoardSearch(driver);
		DashBoard dashBoard = new DashBoard(driver);
		login();
		dbSrch.enterSearchText(locationID);
		dbSrch.clickCustomerName();
		// Verify Customer Location Id Updated for Test
	    cmnMethods.verifyString(locationID, dashBoard.getLoggedCustomerLocationId());
		// Verify Contact is updated accordingly
		dashBoard.editContact();
		dashBoard.updatePhone1("09007861112112");
		dashBoard.updateEmail("automation1@cogsdale.com");
		dashBoard.clickContactUpdate();
		phone = "(090) 078-6111";
		email = "automation1@cogsdale.com";
		dashBoard.verifyCustDetails(ssn, lic, phone, ext, email, add, acsz);
		
		// Verify Updated details
		phone = "(090) 078-6010";
		email = "automation@cogsdale.com";
		dashBoard.editContact();
		dashBoard.updatePhone1("09007860102112");
		dashBoard.updateEmail("automation@cogsdale.com");
		dashBoard.clickContactUpdate();
		dashBoard.verifyCustDetails(ssn, lic, phone, ext, email, add, acsz);
		dashBoard.logout();
	}

}
