package com.NexusPortalAutomation.TestCases.Java;

import java.io.IOException;

import org.testng.annotations.Test;

import com.NexusPortalAutomation.PageObjects.Java.DashBoard;
import com.NexusPortalAutomation.PageObjects.Java.DashBoardSearch;
import com.NexusPortalAutomation.Utilities.Java.CommonMethods;

public class TC0010_1_verifyCustDetails_Business extends BaseClass {

	/*
	 * This test the search by Recent Customer Name
	 * 
	 * @author Talha Rahim
	 * 
	 * @version 1.0
	 * 
	 * @Since 2019-04-11
	 */

	String locationID = getCellvalue("Locations","businessLoc");//"BUSINESSLOC01";
	String ssn =  getCellvalue("Locations","businessSsn");//"5232";
	String lic =  getCellvalue("Locations","businessLic");//"none";
	String phone =  getCellvalue("Locations","businessPhone");//"(090) 123-1231";
	String ext =  getCellvalue("Locations","businessExt");//"+ Ext. 2312";
	String email =  getCellvalue("Locations","businessEmail");//"automation@cogsdale.com";
	String add =  getCellvalue("Locations","businessAdd");//"Iqbal";
	String acsz = getCellvalue("Locations","businessAcsz");// "Miami Beach FL";
	CommonMethods cmnMethods = new CommonMethods();

//This Test will test the search by Customer ID
	@Test(priority = 1)
	public void TestCustomerDetails() throws IOException, InterruptedException {
		DashBoardSearch dbSrch = new DashBoardSearch(driver);
		DashBoard dashBoard = new DashBoard(driver);
		login();
		dbSrch.enterSearchText(locationID);
		dbSrch.clickCustomerName();
		// Verify Customer Location Id Updated for Test
		cmnMethods.verifyString(locationID, dashBoard.getLoggedCustomerLocationId());
		dashBoard.verifyCustDetails(ssn, lic, phone, ext, email, add, acsz);
		dashBoard.logout();
	}
}
