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

	public String locationID = getCellvalue("Locations", "loc1");// "LOC@0001";
	CommonMethods cmnMethods = new CommonMethods();
	String spaURL = getCellvalue("Billing1", "spaURL");// "SPA&CustomerID=0000011111&LocationID=LOC@0001&CogsDrillback=1";
	String spaAmnt = getCellvalue("Billing1", "spaAmnt");// "$0.00";
	String due = getCellvalue("Billing1", "due");// "$35.26";
	String current = getCellvalue("Billing1", "current");// "$0.00";
	String unposted = getCellvalue("Billing1", "unposted");// "$0.00";
	String account = getCellvalue("Billing1", "account");// "$212.50";
	String installment = getCellvalue("Billing1", "installment");// "$50.00";
	String overDue = getCellvalue("Billing1", "overDue");// "$57.24";
	String amountDue = getCellvalue("Billing1", "amountDue");// "$35.26";
	String autoPay = getCellvalue("Billing1", "autoPay");// "OFF";
	String ebill = getCellvalue("Billing1", "eBill");// "ON";
	String deposit = getCellvalue("Billing1", "deposit");// "$0.00";
	String budgetUrl = getCellvalue("Billing1", "budgetURL");// "BudgetRegular&DocumentNumber=BUDG00000002700&LocationID=LOC@0001&CustomerID=0000011111&CogsDrillback=1";

//This Test will test the search by Customer ID
	@Test(priority = 1)
	public void VerifyBillingDetails_budgetSPA() throws IOException, InterruptedException {
		DashBoardSearch dbSrch = new DashBoardSearch(driver);
		DashBoard dashBoard = new DashBoard(driver);
		login();
		dbSrch.enterSearchText(locationID);
		dbSrch.clickCustomerName();
		// Verify Customer Location Id Updated for Test
		cmnMethods.verifyString(locationID, dashBoard.getLoggedCustomerLocationId());

		cmnMethods.verifyString(dashBoard.GetBudgetIcon(), "Budget");
		// Verify Contact is updated accordingly
		// Verify Billing Information
		HashMap<String, String> BillingInfo = dashBoard.GetBillingInfo();
		cmnMethods.verifyString(BillingInfo.get("BillDue"), due);
		cmnMethods.verifyString(BillingInfo.get("BillCurrent"), current);
		cmnMethods.verifyString(BillingInfo.get("BillUnposted"), unposted);
		cmnMethods.verifyString(BillingInfo.get("BillAccount"), account);
		cmnMethods.verifyString(BillingInfo.get("BillInstallment"), installment);
		cmnMethods.verifyString(BillingInfo.get("BillOverDue"), overDue);
		cmnMethods.verifyString(BillingInfo.get("AmountDue"), amountDue);
		cmnMethods.verifyStringContains(dashBoard.getBillBudgetURL(), budgetUrl);
		cmnMethods.verifyString(dashBoard.getEBill(), ebill);
		cmnMethods.verifyString(dashBoard.getAutoPay(), autoPay);
		cmnMethods.verifyString(dashBoard.getDepositAmount(), deposit);
		cmnMethods.verifyString(dashBoard.getPaymentArrangementDue(), "Payment Arrangement Due");
		cmnMethods.verifyString(dashBoard.getPaymentArrangementDueAmount(), spaAmnt);
		cmnMethods.verifyStringContains(dashBoard.getPaymentArrangementDueURL(), spaURL);

		dashBoard.logout();
	}

}
