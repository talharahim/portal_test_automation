package com.NexusPortalAutomation.TestCases.Java;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;

import com.NexusPortalAutomation.PageObjects.Java.DashBoard;
import com.NexusPortalAutomation.PageObjects.Java.DashBoardSearch;
import com.NexusPortalAutomation.Utilities.Java.CommonMethods;

public class TC0016_1_VerifyBillingDetails_Budget extends BaseClass {

	/*
	 * This test the search by Recent Customer Name
	 * 
	 * @author Talha Rahim
	 * 
	 * @version 1.0
	 * 
	 * @Since 2019-04-11
	 */

	public String locationID = "BUDGETLOC02";
	CommonMethods cmnMethods = new CommonMethods();
	String due = "$100.00";
	String current = "$0.00";
	String unposted = "$0.00";
	String account = "$255.00";
	String installment = "$100.00";
	String overDue = "$155.00";
	String amountDue = "$100.00";
	String autoPay = "OFF";
	String eBill = "OFF";
	String deposit = "$0.00";

	List<String> Electric = Arrays.asList("ELECTRIC", "163598645", "GS-PK ENERGY", "1.00000", "Active");
	List<String> Gas1 = Arrays.asList("GAS", "EQUIP-GAS-3", "GRESMTR40", "1.00000", "Active");
	List<String> Internet = Arrays.asList("INTERNET", "EQUIP-PHONE-02", "INTERNET-60", "1.00000", "Active");
	List<String> Gas2 = Arrays.asList("GAS", "GAS100001", "GRESMTR40", "1.00000", "Active");

//This Test will test the search by Customer ID
	@Test(priority = 1)
	public void VerifyBillingDetails_Budget() throws IOException, InterruptedException {
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
		cmnMethods.verifyString(dashBoard.getEBill(), eBill);
		cmnMethods.verifyString(dashBoard.getAutoPay(), autoPay);
		cmnMethods.verifyString(dashBoard.getDepositAmount(), deposit);
		dashBoard.logout();
	}

}
