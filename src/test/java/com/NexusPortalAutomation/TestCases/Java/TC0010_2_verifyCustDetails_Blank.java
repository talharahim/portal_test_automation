package com.NexusPortalAutomation.TestCases.Java;

import java.io.IOException;

import org.testng.annotations.Test;

import com.NexusPortalAutomation.PageObjects.Java.DashBoard;
import com.NexusPortalAutomation.PageObjects.Java.DashBoardSearch;
import com.NexusPortalAutomation.Utilities.Java.CommonMethods;

public class TC0010_2_verifyCustDetails_Blank extends BaseClass {

	/*
	 * This test the search by Recent Customer Name
	 * 
	 * @author Talha Rahim
	 * 
	 * @version 1.0
	 * 
	 * @Since 2019-04-11
	 */

	String locationID = getCellvalue("Customers","blankLocation");//"FRESHLOC01";
	String ssn = getCellvalue("Customers","blankssn");//"none";
	String lic = getCellvalue("Customers","blanklic");//"none";
	String phone = getCellvalue("Customers","blankphone");//"none";
	String ext = getCellvalue("Customers","blankext");//null;
	String email = getCellvalue("Customers","blankemail");//"none";
	String add = getCellvalue("Customers","blankadd");//"02 02 Test Te 042";
	String acsz = getCellvalue("Customers","blankacsz");//"Karachi SINDH";
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
		dashBoard.verifyCustDetailsNoEmailExt(ssn, lic, phone, add, acsz);
		dashBoard.logout();
	}
}
