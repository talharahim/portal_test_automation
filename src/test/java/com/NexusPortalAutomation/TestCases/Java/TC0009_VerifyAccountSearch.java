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

	String LocationID = "500001";
	String AccntSrchResult = "1 Water 1 Bldg";
	String addLine = "Water";
	String addCity = "New York";
	String addState = "NY";
	String addZip = "MYPD0-201";
	String AccountId = "TESTLOCATION01";
	
	String address1 = "8 Orchard";
	String address2 = "8 Orchard";
	String address3 = "8000 Bsmt";
	String cityzip1 = "Troy NY 12180";
	String cityzip2 = "Troy NY 12180";
	String cityzip3 = "Cartersville GA 09007-8623";
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
		dashBoard.verifySearchAccountResult(address1, "SRCH_Accounts_Result1_Address_Line");
		dashBoard.verifySearchAccountResult(address2, "SRCH_Accounts_Result2_Address_Line");
		dashBoard.verifySearchAccountResult(address3, "SRCH_Accounts_Result3_Address_Line");

		// verify State/ZipCode
		dashBoard.verifySearchAccountResult(cityzip1, "SRCH_Accounts_Result1_Address_City_State_ZipCode");
		dashBoard.verifySearchAccountResult(cityzip2, "SRCH_Accounts_Result2_Address_City_State_ZipCode");
		dashBoard.verifySearchAccountResult(cityzip3, "SRCH_Accounts_Result3_Address_City_State_ZipCode");

		// Verify Move-in Date
		dashBoard.verifySearchAccountResult("", "SRCH_Accounts_Result1_Move_In_Date");
		dashBoard.verifySearchAccountResult("Aug 08, 2019", "SRCH_Accounts_Result2_Move_In_Date");
		dashBoard.verifySearchAccountResult("Aug 08, 2019", "SRCH_Accounts_Result2_Move_In_Date");

		// Verify Current Date
		dashBoard.verifySearchAccountResult("- Current", "SRCH_Accounts_Result1_Current_Date");
		dashBoard.verifySearchAccountResult("- Aug 08, 2019", "SRCH_Accounts_Result2_Current_Date");
		dashBoard.verifySearchAccountResult("", "SRCH_Accounts_Result3_Current_Date");

		// Select account and verify the change
		dashBoard.clickSearchAccountResult("SRCH_Accounts_Result2_Address_Line");
		dashBoard.verifyAddressDetails(addLine, addCity, addState, addZip);
		dashBoard.SearchAccountWidgetExpanded(AccountId);
		dashBoard.VerifySearchAccountResult1(AccountId);

		dashBoard.LogOut();
	}
}
