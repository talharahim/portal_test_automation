package com.NexusPortalAutomation.TestCases.Java;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;

import com.NexusPortalAutomation.PageObjects.Java.DashBoard;
import com.NexusPortalAutomation.PageObjects.Java.DashBoardSearch;
import com.NexusPortalAutomation.Utilities.Java.CommonMethods;

public class TC0016_1_VerifyBillingDetails_Budget_SPA extends BaseClass {

	/*
	 * This test the search by Recent Customer Name
	 * 
	 * @author Talha Rahim
	 * 
	 * @version 1.0
	 * 
	 * @Since 2019-04-11
	 */

	public String LocationID = "LOC@0001";
	CommonMethods ComMethd = new CommonMethods();
	String spaURL = "CustomerID=0000011111&LocationID=LOC@0001&CogsDrillback=1";
	String paymentArrangementAmount = "$0.00";
	String Due = "$35.26";
	String Current = "$0.00";
	String Unposted = "$0.00";
	String Account = "$212.50";
	String Installment = "$50.00";
	String OverDue = "$57.24";
	String AmountDue = "$35.26";
	String AutoPay = "OFF";
	String EBill = "ON";
	String Deposit = "$0.00";
	String budgetUrl = "BudgetRegular&DocumentNumber=BUDG00000002700&LocationID=LOC@0001&CustomerID=0000011111&CogsDrillback=1";

//This Test will test the search by Customer ID
	@Test(priority = 1)
	public void VerifyBillingDetails() throws IOException, InterruptedException {
		DashBoardSearch dbSrch = new DashBoardSearch(driver);
		DashBoard dashBoard = new DashBoard(driver);
		login();
		dbSrch.EnterSearchText(LocationID);
		dbSrch.ClickCustomer();
		// Verify Customer Location Id Updated for Test
		ComMethd.VerifyString(LocationID, dashBoard.GetLoggedCustomerLocationId());
		
		ComMethd.VerifyString(dashBoard.GetBudgetIcon(), "Budget");
		// Verify Contact is updated accordingly
		 //Verify Billing Information
		HashMap<String, String> BillingInfo = dashBoard.GetBillingInfo();
		ComMethd.VerifyString(BillingInfo.get("BillDue"), Due);
		ComMethd.VerifyString(BillingInfo.get("BillCurrent"), Current);
		ComMethd.VerifyString(BillingInfo.get("BillUnposted"), Unposted);
		ComMethd.VerifyString(BillingInfo.get("BillAccount"), Account);
		ComMethd.VerifyString(BillingInfo.get("BillInstallment"), Installment);
		ComMethd.VerifyString(BillingInfo.get("BillOverDue"), OverDue);
		ComMethd.VerifyString(BillingInfo.get("AmountDue"), AmountDue);
		ComMethd.VerifyStringContains(dashBoard.getBillBudgetURL(), budgetUrl);
		ComMethd.VerifyString(dashBoard.getEBill(), EBill);
		ComMethd.VerifyString(dashBoard.getAutoPay(), AutoPay);
		ComMethd.VerifyString(dashBoard.getDepositAmount(), Deposit);
		ComMethd.VerifyString(dashBoard.getPaymentArrangementDue(), "Payment Arrangement Due");
		ComMethd.VerifyString(dashBoard.getPaymentArrangementDueAmount(), paymentArrangementAmount);
		ComMethd.VerifyStringContains(dashBoard.getPaymentArrangementDueURL(), spaURL);

		dashBoard.LogOut();
	}

}
