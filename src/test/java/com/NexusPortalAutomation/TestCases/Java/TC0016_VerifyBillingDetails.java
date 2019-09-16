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

	public String locationID = getCellvalue("Locations", "loc1");//"LOC@0001";
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
	String eBill = getCellvalue("Billing1", "eBill");// "ON";
	String deposit = getCellvalue("Billing1", "deposit");// "$0.00";

	List<String> electric = Arrays.asList("ELECTRIC", "163598645", "GS-PK ENERGY", "1.00000", "Active");
	List<String> gas1 = Arrays.asList("GAS", "EQUIP-GAS-3", "GRESMTR40", "1.00000", "Active");
	List<String> internet = Arrays.asList("INTERNET", "EQUIP-PHONE-02", "INTERNET-60", "1.00000", "Active");
	List<String> gas2 = Arrays.asList("GAS", "GAS100001", "GRESMTR40", "1.00000", "Active");

//This Test will test the search by Customer ID
	@Test(priority = 1)
	public void VerifyBillingDetails() throws IOException, InterruptedException {
		DashBoardSearch dbSrch = new DashBoardSearch(driver);
		DashBoard dashBoard = new DashBoard(driver);
		login();
		dbSrch.enterSearchText(locationID);
		dbSrch.clickCustomerName();
		// Verify Customer Location Id Updated for Test
		cmnMethods.verifyString(locationID, dashBoard.getLoggedCustomerLocationId());
		// Verify Contact is updated accordingly
		// "Verify Billing Information
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
		/*
		 * Verify Text required for Service Order Section
		 */
		HashMap<String, String> BillingSrvInfo = dashBoard.GetBillingServiceElectricInfo();
		cmnMethods.verifyString(BillingSrvInfo.get("Service1"), electric.get(0));
		cmnMethods.verifyString(BillingSrvInfo.get("Service1Equipment"), electric.get(1));
		cmnMethods.verifyString(BillingSrvInfo.get("Service1Rate"), electric.get(2));
		cmnMethods.verifyString(BillingSrvInfo.get("Service1Multi"), electric.get(3));
		cmnMethods.verifyString(BillingSrvInfo.get("Service1Status"), electric.get(4));

		BillingSrvInfo = dashBoard.GetBillingServiceGasInfo();

		cmnMethods.verifyString(BillingSrvInfo.get("Service2"), gas1.get(0));
		cmnMethods.verifyString(BillingSrvInfo.get("Service2Equipment"), gas1.get(1));
		cmnMethods.verifyString(BillingSrvInfo.get("Service2Rate"), gas1.get(2));
		cmnMethods.verifyString(BillingSrvInfo.get("Service2Multi"), gas1.get(3));
		cmnMethods.verifyString(BillingSrvInfo.get("Service2Status"), gas1.get(4));

		BillingSrvInfo = dashBoard.GetBillingServiceInternetInfo();

		cmnMethods.verifyString(BillingSrvInfo.get("Service3"), internet.get(0));
		cmnMethods.verifyString(BillingSrvInfo.get("Service3Equipment"), internet.get(1));
		cmnMethods.verifyString(BillingSrvInfo.get("Service3Rate"), internet.get(2));
		cmnMethods.verifyString(BillingSrvInfo.get("Service3Multi"), internet.get(3));
		cmnMethods.verifyString(BillingSrvInfo.get("Service3Status"), internet.get(4));

		// Verify Service by Clicking on Electricity icon
		dashBoard.ClickServElecIcon();
		BillingSrvInfo = dashBoard.GetBillingServiceElectricTABInfo();
		cmnMethods.verifyString(BillingSrvInfo.get("Service1"), electric.get(0));
		cmnMethods.verifyString(BillingSrvInfo.get("Service1Equipment"), electric.get(1));
		cmnMethods.verifyString(BillingSrvInfo.get("Service1Rate"), electric.get(2));
		cmnMethods.verifyString(BillingSrvInfo.get("Service1Multi"), electric.get(3));
		cmnMethods.verifyString(BillingSrvInfo.get("Service1Status"), electric.get(4));

		dashBoard.ClickServGasIcon();
		BillingSrvInfo = dashBoard.GetBillingServiceGasTABInfo();
		
		cmnMethods.verifyString(BillingSrvInfo.get("Service2"), gas1.get(0));
		cmnMethods.verifyString(BillingSrvInfo.get("Service2Equipment"), gas1.get(1));
		cmnMethods.verifyString(BillingSrvInfo.get("Service2Rate"), gas1.get(2));
		cmnMethods.verifyString(BillingSrvInfo.get("Service2Multi"), gas1.get(3));
		cmnMethods.verifyString(BillingSrvInfo.get("Service2Status"), gas1.get(4));

		dashBoard.ClickServInternetIcon();
		BillingSrvInfo = dashBoard.GetBillingServiceInternetTABInfo();

		cmnMethods.verifyString(BillingSrvInfo.get("Service3"), internet.get(0));
		cmnMethods.verifyString(BillingSrvInfo.get("Service3Equipment"), internet.get(1));
		cmnMethods.verifyString(BillingSrvInfo.get("Service3Rate"), internet.get(2));
		cmnMethods.verifyString(BillingSrvInfo.get("Service3Multi"), internet.get(3));
		cmnMethods.verifyString(BillingSrvInfo.get("Service3Status"), internet.get(4));

		dashBoard.logout();
	}

}
