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

	public String locationID = getCellvalue("TC0016", "loc1");// "LOC@0001";
	
	String spaURL = getCellvalue("TC0016", "spaURL");// "SPA&CustomerID=0000011111&LocationID=LOC@0001&CogsDrillback=1";
	String spaAmnt = getCellvalue("TC0016", "spaAmnt");// "$0.00";
	String due = getCellvalue("TC0016", "due");// "$35.26";
	String current = getCellvalue("TC0016", "current");// "$0.00";
	String unposted = getCellvalue("TC0016", "unposted");// "$0.00";
	String account = getCellvalue("TC0016", "account");// "$212.50";
	String installment = getCellvalue("TC0016", "installment");// "$50.00";
	String overDue = getCellvalue("TC0016", "overDue");// "$57.24";
	String amountDue = getCellvalue("TC0016", "amountDueSPA");// "$35.26";
	String autoPay = getCellvalue("TC0016", "autoPay");// "OFF";
	String ebill = getCellvalue("TC0016", "eBill");// "ON";
	String deposit = getCellvalue("TC0016", "deposit");// "$0.00";
	String budgetUrl = getCellvalue("TC0016", "budgetURL");// "BudgetRegular&DocumentNumber=BUDG00000002700&LocationID=LOC@0001&CustomerID=0000011111&CogsDrillback=1";

//This Test will test the search by Customer ID
	@Test(priority = 1)
	public void VerifyBillingDetails_budgetSPA() throws IOException, InterruptedException {
		DashBoardSearch dbSrch = new DashBoardSearch(driver);
		DashBoard dashBoard = new DashBoard(driver);
		login();
		dbSrch.enterSearchText(locationID);
		dbSrch.clickCustomerName();
		// Verify Customer Location Id Updated for Test
		CommonMethods.verifyString(locationID, dashBoard.getLoggedCustomerLocationId());

		CommonMethods.verifyString(dashBoard.GetBudgetIcon(), "Budget");
		// Verify Contact is updated accordingly
		// Verify Billing Information
		HashMap<String, String> BillingInfo = dashBoard.GetBillingInfo();
		CommonMethods.verifyString(BillingInfo.get("BillDue"), due);
		CommonMethods.verifyString(BillingInfo.get("BillCurrent"), current);
		CommonMethods.verifyString(BillingInfo.get("BillUnposted"), unposted);
		CommonMethods.verifyString(BillingInfo.get("BillAccount"), account);
		CommonMethods.verifyString(BillingInfo.get("BillInstallment"), installment);
		CommonMethods.verifyString(BillingInfo.get("BillOverDue"), overDue);
		CommonMethods.verifyString(BillingInfo.get("AmountDue"), amountDue);
		CommonMethods.verifyStringContains(dashBoard.getBillBudgetURL(), budgetUrl);
		CommonMethods.verifyString(dashBoard.getEBill(), ebill);
		CommonMethods.verifyString(dashBoard.getAutoPay(), autoPay);
		CommonMethods.verifyString(dashBoard.getDepositAmount(), deposit);
		CommonMethods.verifyString(dashBoard.getPaymentArrangementDue(), "Payment Arrangement Due");
		CommonMethods.verifyString(dashBoard.getPaymentArrangementDueAmount(), spaAmnt);
		CommonMethods.verifyStringContains(dashBoard.getPaymentArrangementDueURL(), spaURL);

		dashBoard.logout();
	}

}
