package com.NexusPortalAutomation.TestCases.Java;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;

import com.NexusPortalAutomation.PageObjects.Java.DashBoard;
import com.NexusPortalAutomation.PageObjects.Java.DashBoardSearch;
import com.NexusPortalAutomation.Utilities.Java.CommonMethods;

public class TC0016_VerifyBillingDetails extends BaseClass {

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

	List<String> Electric = Arrays.asList("ELECTRIC", "163598645", "GS-PK ENERGY", "1.00000", "Active");
	List<String> Gas1 = Arrays.asList("GAS", "EQUIP-GAS-3", "GRESMTR40", "1.00000", "Active");
	List<String> Internet = Arrays.asList("INTERNET", "EQUIP-PHONE-02", "INTERNET-60", "1.00000", "Active");
	List<String> Gas2 = Arrays.asList("GAS", "GAS100001", "GRESMTR40", "1.00000", "Active");

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
		// Verify Contact is updated accordingly
		// "Verify Billing Information
		HashMap<String, String> BillingInfo = dashBoard.GetBillingInfo();
		cmnMethods.verifyString(BillingInfo.get("BillDue"), Due);
		cmnMethods.verifyString(BillingInfo.get("BillCurrent"), Current);
		cmnMethods.verifyString(BillingInfo.get("BillUnposted"), Unposted);
		cmnMethods.verifyString(BillingInfo.get("BillAccount"), Account);
		cmnMethods.verifyString(BillingInfo.get("BillInstallment"), Installment);
		cmnMethods.verifyString(BillingInfo.get("BillOverDue"), OverDue);
		cmnMethods.verifyString(BillingInfo.get("AmountDue"), AmountDue);
		cmnMethods.verifyString(dashBoard.getEBill(), EBill);
		cmnMethods.verifyString(dashBoard.getAutoPay(), AutoPay);
		cmnMethods.verifyString(dashBoard.getDepositAmount(), Deposit);
		/*
		 * Verify Text required for Service Order Section
		 */
		HashMap<String, String> BillingSrvInfo = dashBoard.GetBillingServiceElectricInfo();
		cmnMethods.verifyString(BillingSrvInfo.get("Service1"), Electric.get(0));
		cmnMethods.verifyString(BillingSrvInfo.get("Service1Equipment"), Electric.get(1));
		cmnMethods.verifyString(BillingSrvInfo.get("Service1Rate"), Electric.get(2));
		cmnMethods.verifyString(BillingSrvInfo.get("Service1Multi"), Electric.get(3));
		cmnMethods.verifyString(BillingSrvInfo.get("Service1Status"), Electric.get(4));

		BillingSrvInfo = dashBoard.GetBillingServiceGasInfo();

		cmnMethods.verifyString(BillingSrvInfo.get("Service2"), Gas1.get(0));
		cmnMethods.verifyString(BillingSrvInfo.get("Service2Equipment"), Gas1.get(1));
		cmnMethods.verifyString(BillingSrvInfo.get("Service2Rate"), Gas1.get(2));
		cmnMethods.verifyString(BillingSrvInfo.get("Service2Multi"), Gas1.get(3));
		cmnMethods.verifyString(BillingSrvInfo.get("Service2Status"), Gas1.get(4));

		BillingSrvInfo = dashBoard.GetBillingServiceInternetInfo();

		cmnMethods.verifyString(BillingSrvInfo.get("Service3"), Internet.get(0));
		cmnMethods.verifyString(BillingSrvInfo.get("Service3Equipment"), Internet.get(1));
		cmnMethods.verifyString(BillingSrvInfo.get("Service3Rate"), Internet.get(2));
		cmnMethods.verifyString(BillingSrvInfo.get("Service3Multi"), Internet.get(3));
		cmnMethods.verifyString(BillingSrvInfo.get("Service3Status"), Internet.get(4));

		// Verify Service by Clicking on Electricity icon
		dashBoard.ClickServElecIcon();
		BillingSrvInfo = dashBoard.GetBillingServiceElectricTABInfo();
		cmnMethods.verifyString(BillingSrvInfo.get("Service1"), Electric.get(0));
		cmnMethods.verifyString(BillingSrvInfo.get("Service1Equipment"), Electric.get(1));
		cmnMethods.verifyString(BillingSrvInfo.get("Service1Rate"), Electric.get(2));
		cmnMethods.verifyString(BillingSrvInfo.get("Service1Multi"), Electric.get(3));
		cmnMethods.verifyString(BillingSrvInfo.get("Service1Status"), Electric.get(4));

		dashBoard.ClickServGasIcon();
		BillingSrvInfo = dashBoard.GetBillingServiceGasTABInfo();
		
		cmnMethods.verifyString(BillingSrvInfo.get("Service2"), Gas1.get(0));
		cmnMethods.verifyString(BillingSrvInfo.get("Service2Equipment"), Gas1.get(1));
		cmnMethods.verifyString(BillingSrvInfo.get("Service2Rate"), Gas1.get(2));
		cmnMethods.verifyString(BillingSrvInfo.get("Service2Multi"), Gas1.get(3));
		cmnMethods.verifyString(BillingSrvInfo.get("Service2Status"), Gas1.get(4));

		dashBoard.ClickServInternetIcon();
		BillingSrvInfo = dashBoard.GetBillingServiceInternetTABInfo();

		cmnMethods.verifyString(BillingSrvInfo.get("Service3"), Internet.get(0));
		cmnMethods.verifyString(BillingSrvInfo.get("Service3Equipment"), Internet.get(1));
		cmnMethods.verifyString(BillingSrvInfo.get("Service3Rate"), Internet.get(2));
		cmnMethods.verifyString(BillingSrvInfo.get("Service3Multi"), Internet.get(3));
		cmnMethods.verifyString(BillingSrvInfo.get("Service3Status"), Internet.get(4));

		dashBoard.logout();
	}

}
