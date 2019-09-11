package com.NexusPortalAutomation.TestCases.Java;

import java.io.IOException;

import org.testng.annotations.Test;

import com.NexusPortalAutomation.PageObjects.Java.DashBoard;
import com.NexusPortalAutomation.PageObjects.Java.DashBoardSearch;
import com.NexusPortalAutomation.Utilities.Java.CommonMethods;

public class TC0008_VerifySignInbylocationID extends BaseClass {

	/*
	 * This test the search by Recent Customer Name
	 * 
	 * @author Talha Rahim
	 * 
	 * @version 1.0
	 * 
	 * @Since 2019-04-11
	 */

	public String locationID = "LOC@0001";
	CommonMethods cmnMethods = new CommonMethods();
	String addLine = "007 Aut Automation Street Rt 20001 Apt";
	String addCity = "Cloudy";
	String addState = "D";
	String addZip = "00720-019";

	// This Test will test the search by Customer ID
	@Test(priority = 1)
	public void TestSearchbylocationID() throws IOException, InterruptedException {
		DashBoardSearch dbSrch = new DashBoardSearch(driver);
		DashBoard dashBoard = new DashBoard(driver);
		login();
		dbSrch.enterSearchText(locationID);
		dbSrch.clickCustomerName();
		// Verify Customer Location Id Updated for Test
		cmnMethods.verifyString(locationID, dashBoard.getLoggedCustomerLocationId());
		// Verify Address Details
		dashBoard.verifyAddressDetails(addLine, addCity, addState, addZip);
		dashBoard.logout();
	}

}
