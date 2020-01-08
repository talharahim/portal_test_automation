package com.NexusPortalAutomation.TestCases.Java;

import java.io.IOException;

import org.testng.annotations.Test;

import com.NexusPortalAutomation.PageObjects.Java.DashBoard;
import com.NexusPortalAutomation.PageObjects.Java.DashBoardSearch;
import com.NexusPortalAutomation.Utilities.Java.CommonMethods;

public class TC0010_verifyCustDetails extends BaseClass {

	/*
	 * This test the search by Recent Customer Name
	 * 
	 * @author Talha Rahim
	 * 
	 * @version 1.0
	 * 
	 * @Since 2019-04-11
	 */

	String locationID = getCellvalue("TC0010","loc1");
	String ssn = getCellvalue("TC0010","ssn");// "2312";
	String lic = getCellvalue("TC0010","lic");//"Driv12312OUL312";
	String phone = getCellvalue("TC0010","phone");//"(090) 078-6010";
	String ext = getCellvalue("TC0010","ext");//"+ Ext. 2112";
	String email = getCellvalue("TC0010","email");//"automation@cogsdale.com";
	String add = getCellvalue("TC0010","add");//"007 Test Apt";
	String acsz = getCellvalue("TC0010","acsz");//"New York NY 12345-67890";
	

//This Test will test the search by Customer ID
	@Test(priority = 1)
	public void TestCustomerDetails() throws IOException, InterruptedException {
		DashBoardSearch dbSrch = new DashBoardSearch(driver);
		DashBoard dashBoard = new DashBoard(driver);
		login();
		dbSrch.enterSearchText(locationID);
		dbSrch.clickCustomerName();
		// Verify Customer Location Id Updated for Test
		CommonMethods.verifyString(locationID, dashBoard.getLoggedCustomerLocationId());
		dashBoard.verifyCustDetails(ssn, lic, phone, ext, email, add, acsz);
		dashBoard.logout();
	}
}
