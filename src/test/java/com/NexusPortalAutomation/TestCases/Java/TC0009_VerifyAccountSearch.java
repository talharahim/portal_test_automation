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
	String addLine = "Water";
	String addCity = "New York";
	String addState = "NY";
	String addZip = "MYPD0-201";
	String AccountId = "TESTLOCATION01";
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
		// Verify the type/status of the account
		dashBoard.verifySearchAccountResult("Current", "SRCH_Accounts_Result1_Customer_Status");
		dashBoard.verifySearchAccountResult("Former", "SRCH_Accounts_Result2_Customer_Status");
		dashBoard.verifySearchAccountResult("Move In", "SRCH_Accounts_Result3_Customer_Status");

		// Verify addresses of Searched Accounts
		dashBoard.verifySearchAccountResult("123213 Qweqwe Apt", "SRCH_Accounts_Result1_Address_Line");
		dashBoard.verifySearchAccountResult("Water", "SRCH_Accounts_Result2_Address_Line");
		dashBoard.verifySearchAccountResult("4 Water 145 Unit", "SRCH_Accounts_Result3_Address_Line");

		// verify State/ZipCode
		dashBoard.verifySearchAccountResult("Cartersville GA 12345-6789",
				"SRCH_Accounts_Result1_Address_City_State_ZipCode");
		dashBoard.verifySearchAccountResult("New York NY MYPD0-201",
				"SRCH_Accounts_Result2_Address_City_State_ZipCode");
		dashBoard.verifySearchAccountResult("New York NY 12311", "SRCH_Accounts_Result3_Address_City_State_ZipCode");

		// Verify Move-in Date
		dashBoard.verifySearchAccountResult("Jul 15, 2019", "SRCH_Accounts_Result1_Move_In_Date");
		dashBoard.verifySearchAccountResult("Aug 07, 2019", "SRCH_Accounts_Result2_Move_In_Date");

		// Verify Current Date
		dashBoard.verifySearchAccountResult("- Current", "SRCH_Accounts_Result1_Current_Date");
		dashBoard.verifySearchAccountResult("- Current", "SRCH_Accounts_Result2_Current_Date");

		// Select account and verify the change
		dashBoard.clickSearchAccountResult("SRCH_Accounts_Result2_Address_Line");
		dashBoard.verifyAddressDetails(addLine, addCity, addState, addZip);
		dashBoard.SearchAccountWidgetExpanded(AccountId);
		dashBoard.VerifySearchAccountResult1(AccountId);
	
		dashBoard.LogOut();
	}
}
