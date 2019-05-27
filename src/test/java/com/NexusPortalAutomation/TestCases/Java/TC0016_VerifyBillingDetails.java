package com.NexusPortalAutomation.TestCases.Java;

import java.io.IOException;
import java.util.HashMap;

import org.testng.annotations.Test;

import com.NexusPortalAutomation.PageObjects.Java.DashBoard;
import com.NexusPortalAutomation.PageObjects.Java.DashBoardSearch;
import com.NexusPortalAutomation.Utilities.Java.CommonMethods;

/**
 * 
 * This Class will be used for to Test Contact Logs
 * 
 * @author Talha Rahim
 * @since 2019-05-25
 */

public class TC0016_VerifyBillingDetails extends BaseClass {

	public String LocationID = "LOC@0001";
	CommonMethods ComMethd = new CommonMethods();
	String Due ="$35.26";
	String Current ="$0.00";
	String Unposted ="$0.00";
	String Account ="$92.50";
	String Installment ="$50.00";
	String OverDue ="$57.24";
	String AmountDue = "$35.26";
	

//This Test will test the search by Customer ID
	@Test(priority = 1)
	public void TestSecondayContact() throws IOException, InterruptedException {
		DashBoardSearch dbSrch = new DashBoardSearch(driver);
		DashBoard dashBoard = new DashBoard(driver);
		login();
		dbSrch.EnterSearchText(LocationID);
		dbSrch.ClickCustomer();
		// Verify Customer Location Id Updated for Test
		ComMethd.VerifyString(LocationID, dashBoard.GetLoggedCustomerLocationId());
		// Verify Contact is updated accordingly
		//"Verify Billing Information
		HashMap<String, String> BillingInfo = dashBoard.GetBillingInfo();
		ComMethd.VerifyString(BillingInfo.get("BillDue"),Due);
		ComMethd.VerifyString(BillingInfo.get("BillCurrent"),Current);
		ComMethd.VerifyString(BillingInfo.get("BillUnposted"),Unposted);
		ComMethd.VerifyString(BillingInfo.get("BillAccount"),Account);
		ComMethd.VerifyString(BillingInfo.get("BillInstallment"),Installment);
		ComMethd.VerifyString(BillingInfo.get("BillOverDue"),OverDue);
		ComMethd.VerifyString(BillingInfo.get("AmountDue"),AmountDue );
		//Verify Service Order
		dashBoard.LogOut();
	}

}
