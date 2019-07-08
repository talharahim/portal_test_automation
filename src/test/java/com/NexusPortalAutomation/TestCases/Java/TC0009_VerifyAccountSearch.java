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

	String LocationID = "AUTO1001";
	String AccntSrchResult = "1 Water 1 Bldg";
	String addLine = "4 Water 145 Unit";
	String addCity = "New York";
	String addState = "NY";
	String addZip = "65342";
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
		ComMethd.VerifyString(LocationID, dashBoard.GetLoggedCustomerId());
		// Verify Customer Details for location Provided
		dashBoard.clickSarchAccountWidget();
		//This will verify the type/status of the account 
		dashBoard.verifySearchAccountResult("Current","SRCH_Accounts_Result1_Customer_Status");
		dashBoard.verifySearchAccountResult("Current","SRCH_Accounts_Result2_Customer_Status");
		dashBoard.verifySearchAccountResult("Former","SRCH_Accounts_Result3_Customer_Status");
		dashBoard.verifySearchAccountResult("Move In","SRCH_Accounts_Result4_Customer_Status");
		//Select account and verify the change
		dashBoard.clickSearchAccountResult("SRCH_Accounts_Result2_Address_Line");
		dashBoard.verifyAddressDetails(addLine,addCity,addState,addZip);
				
		dashBoard.LogOut();
	}
}
