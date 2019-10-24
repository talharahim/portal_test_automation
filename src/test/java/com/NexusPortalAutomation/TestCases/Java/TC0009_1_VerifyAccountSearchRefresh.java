package com.NexusPortalAutomation.TestCases.Java;

import java.io.IOException;

import org.testng.annotations.Test;

import com.NexusPortalAutomation.PageObjects.Java.DashBoard;
import com.NexusPortalAutomation.PageObjects.Java.DashBoardSearch;
import com.NexusPortalAutomation.Utilities.Java.CommonMethods;
import com.NexusPortalAutomation.Utilities.Java.ExcelData;

public class TC0009_1_VerifyAccountSearchRefresh extends BaseClass {

	/*
	 * This test the search by Recent Customer Name
	 * 
	 * @author Talha Rahim
	 * 
	 * @version 1.0
	 * 
	 * @Since 2019-10-11
	 */

	String locationID =  ExcelData.getExcelData("TC0009","accSearchLoc1");//"500001";
	String locationID2 =  ExcelData.getExcelData("TC0009","accSearchLoc2");//"CUS@0004";
	String accSrchResult =  ExcelData.getExcelData("TC0009","accSearchRslt");//"1 Water 1 Bldg";
	String addLine =  ExcelData.getExcelData("TC0009","accAddLine");//"8 Orchard";
	String addCity =  ExcelData.getExcelData("TC0009","accAddCity");//"Troy";
	String addState =  ExcelData.getExcelData("TC0009","accAddState");//"NY";
	String addZip =  ExcelData.getExcelData("TC0009","accAddZip");//"12180";
	String AccountId =  ExcelData.getExcelData("TC0009","accAddId");//"TESTLOCATION05";
	
	
	//second account
	String addLine2 =  ExcelData.getExcelData("TC0009_1","accAddLine2");//"8 Orchard";
	String addCity2 =  ExcelData.getExcelData("TC0009_1","accAddCity2");//"Troy";
	String addState2 =  ExcelData.getExcelData("TC0009_1","accAddState2");//"NY";
	String addZip2 =  ExcelData.getExcelData("TC0009_1","accAddZip2");//"12180";
	String AccountId2 =  ExcelData.getExcelData("TC0009_1","accAddId2");//"TESTLOCATION05";
	
	String address1 =  ExcelData.getExcelData("TC0009","accAddLine");//"8 Orchard";
	String address2 =  ExcelData.getExcelData("TC0009","accAddLine");//"8 Orchard";
	String address3 =  ExcelData.getExcelData("TC0009","accAddLine");//"8 Orchard";
	String cityzip1 =  ExcelData.getExcelData("TC0009","accCityZip");//"Troy NY 12180";
	String cityzip2 =  ExcelData.getExcelData("TC0009","accCityZip");//"Troy NY 12180";
	String cityzip3 =  ExcelData.getExcelData("TC0009","accCityZip");//"Troy NY 12180";
	//

//This Test will test the search by Customer ID
	@Test(priority = 1)
	public void TestSearchAccount() throws IOException, InterruptedException {
		DashBoardSearch dbSrch = new DashBoardSearch(driver);
		DashBoard dashBoard = new DashBoard(driver);
		login();
		dbSrch.enterSearchText(locationID);
		dbSrch.clickCustomerName();
		// Verify Customer Location Id Updated for Test
		CommonMethods.verifyString(locationID, dashBoard.getLoggedCustId());
		// Verify Customer Details for location Provided
		dashBoard.clickSarchAccountWidget();
		// Verify the type/status of the account
		dashBoard.verifySearchAccountResult("Current", "SRCH_Accounts_Result1_Customer_Status");
		dashBoard.verifySearchAccountResult("Former", "SRCH_Accounts_Result2_Customer_Status");
		dashBoard.verifySearchAccountResult("Former", "SRCH_Accounts_Result3_Customer_Status");
		
		

		// Verify addresses of Searched Accounts
		dashBoard.verifySearchAccountResult(address1, "SRCH_Accounts_Result1_Address_Line");
		dashBoard.verifySearchAccountResult(address2, "SRCH_Accounts_Result2_Address_Line");
		dashBoard.verifySearchAccountResult(address3, "SRCH_Accounts_Result3_Address_Line");

		// verify State/ZipCode
		dashBoard.verifySearchAccountResult(cityzip1, "SRCH_Accounts_Result1_Address_City_State_ZipCode");
		dashBoard.verifySearchAccountResult(cityzip2, "SRCH_Accounts_Result2_Address_City_State_ZipCode");
		dashBoard.verifySearchAccountResult(cityzip3, "SRCH_Accounts_Result3_Address_City_State_ZipCode");

		// Verify Move-in Date
		//dashBoard.verifySearchAccountResult("", "SRCH_Accounts_Result1_Move_In_Date");
		dashBoard.verifySearchAccountResult("Aug 08, 2019", "SRCH_Accounts_Result2_Move_In_Date");
		dashBoard.verifySearchAccountResult("Aug 08, 2019", "SRCH_Accounts_Result2_Move_In_Date");

		// Verify Current Date
		//dashBoard.verifySearchAccountResult("- Current", "SRCH_Accounts_Result1_Current_Date");
		//dashBoard.verifySearchAccountResult("Aug 08, 2019", "SRCH_Accounts_Result2_Current_Date");
		//dashBoard.verifySearchAccountResult("Aug 09, 2019", "SRCH_Accounts_Result3_Current_Date");

		// Select account and verify the change
		dashBoard.clickSearchAccountResult("SRCH_Accounts_Result2_Address_Line");
		dashBoard.verifyAddressDetails(addLine, addCity, addState, addZip);
		dashBoard.SearchAccountWidgetExpanded(AccountId);
		dashBoard.VerifySearchAccountResult1(AccountId);
		
		dashBoard.enterDashBoardSearch(locationID2);
		dashBoard.clickDashBoardSearchResult1();
		dashBoard.verifyAddressDetails(addLine2, addCity2, addState2, addZip2);
		dashBoard.clickrefreshPage();
		dashBoard.verifyAddressDetails(addLine2, addCity2, addState2, addZip2);
		
		
		
		dashBoard.findElementByxpath("//div[contains(text(),'No Other Accounts')]");

		dashBoard.logout();
	}
}
