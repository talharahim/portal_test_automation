package com.NexusPortalAutomation.TestCases.Java;

import java.io.IOException;

import org.testng.annotations.Test;

import com.NexusPortalAutomation.PageObjects.Java.DashBoard;
import com.NexusPortalAutomation.PageObjects.Java.DashBoardSearch;
import com.NexusPortalAutomation.Utilities.Java.CommonMethods;

public class TC0009_VerifyAccountSearch extends BaseClass {

	/*
	 * This test the search by Recent Customer Name
	 * 
	 * @author Talha Rahim
	 * 
	 * @version 1.0
	 * 
	 * @Since 2019-04-11
	 */

	String LocationID = "LOC@0004";
	String AccntSrchResult = "1 Water 1 Bldg\r\n" + "New Smyrna Beach FL 12312-3\r\n" + "LOC@0004\r\n" + "$0.00";
	String addLine = "007AAutomation Street Rt 20001 Apt";
	String addCity = "Cloudy";
	String addState = "D";
	String addZip = "00720-017";
	CommonMethods ComMethd = new CommonMethods();

//This Test will test the search by Customer ID
	@Test(priority = 1)
	public void TestSearchAccount() throws IOException, InterruptedException {
		DashBoardSearch dbSrch = new DashBoardSearch(driver);
		DashBoard dashBoard = new DashBoard(driver);
		login();
		dbSrch.EnterSearchText(LocationID);
		dbSrch.ClickCustomer();
		// Verify Customer Location Id Updated for Test
		ComMethd.VerifyString(LocationID, dashBoard.GetLoggedCustomerLocationId());
		// Verify Customer Details for location Provided
		dashBoard.SearchAccountWidget(LocationID);
		dashBoard.VerifySearchAccountResult1(AccntSrchResult);

		dashBoard.LogOut();
	}
}
