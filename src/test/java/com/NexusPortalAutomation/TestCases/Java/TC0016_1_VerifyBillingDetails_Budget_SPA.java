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

	public String locationID = "LOC@0001";
	CommonMethods cmnMethods = new CommonMethods();
	String spaURL = "CustomerID=0000011111&locationID=LOC@0001&CogsDrillback=1";
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
	String budgetUrl = "BudgetRegular&DocumentNumber=BUDG00000002700&locationID=LOC@0001&CustomerID=0000011111&CogsDrillback=1";

//This Test will test the search by Customer ID
	@Test(priority = 1)
	public void VerifyBillingDetails() throws IOException, InterruptedException {
		DashBoardSearch dbSrch = new DashBoardSearch(driver);
		DashBoard dashBoard = new DashBoard(driver);
		login();
		dbSrch.enterSearchText(locationID);
		dbSrch.clickCustomerName();
		// Verify Customer Location Id Updated for Test
		cmnMethods.verifyString(locationID, dashBoard.getLoggedCustomerName());
		
		cmnMethods.verifyString(dashBoard.GetBudgetIcon(), "Budget");
		// Verify Contact is updated accordingly
		 //Verify Billing Information
		HashMap<String, String> BillingInfo = dashBoard.GetBillingInfo();
		cmnMethods.verifyString(BillingInfo.get("BillDue"), Due);
		cmnMethods.verifyString(BillingInfo.get("BillCurrent"), Current);
		cmnMethods.verifyString(BillingInfo.get("BillUnposted"), Unposted);
		cmnMethods.verifyString(BillingInfo.get("BillAccount"), Account);
		cmnMethods.verifyString(BillingInfo.get("BillInstallment"), Installment);
		cmnMethods.verifyString(BillingInfo.get("BillOverDue"), OverDue);
		cmnMethods.verifyString(BillingInfo.get("AmountDue"), AmountDue);
		cmnMethods.VerifyStringContains(dashBoard.getBillBudgetURL(), budgetUrl);
		cmnMethods.verifyString(dashBoard.getEBill(), EBill);
		cmnMethods.verifyString(dashBoard.getAutoPay(), AutoPay);
		cmnMethods.verifyString(dashBoard.getDepositAmount(), Deposit);
		cmnMethods.verifyString(dashBoard.getPaymentArrangementDue(), "Payment Arrangement Due");
		cmnMethods.verifyString(dashBoard.getPaymentArrangementDueAmount(), paymentArrangementAmount);
		cmnMethods.VerifyStringContains(dashBoard.getPaymentArrangementDueURL(), spaURL);

		dashBoard.logout();
	}

}
