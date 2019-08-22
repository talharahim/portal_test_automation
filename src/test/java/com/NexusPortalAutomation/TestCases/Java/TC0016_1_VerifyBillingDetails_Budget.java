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

	public String LocationID = "BUDGETLOC02";
	CommonMethods ComMethd = new CommonMethods();
	String Due = "$0.00";
	String Current = "$100.00";
	String Unposted = "$0.00";
	String Account = "$255.00";
	String Installment = "$100.00";
	String OverDue = "$155.00";
	String AmountDue = "$100.00";
	String AutoPay = "OFF";
	String EBill = "OFF";
	String Deposit = "$0.00";
	String budgetUrl = "cogsdrillback://DGPB/?Db=SQL_2017&Srv=RND-BASE-A&Cmp=TWO&Prod=229&Act=OPEN&Func=BudgetRegular&DocumentNumber=BUDG00000002800&LocationID=BUDGETLOC02&CustomerID=03332301204&CogsDrillback=1";

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
		ComMethd.VerifyString(dashBoard.getEBill(), EBill);
		ComMethd.VerifyString(dashBoard.getAutoPay(), AutoPay);
		ComMethd.VerifyString(dashBoard.getDepositAmount(), Deposit);
//		/*
//		 * Verify Text required for Service Order Section
//		 */
//		HashMap<String, String> BillingSrvInfo = dashBoard.GetBillingServiceElectricInfo();
//		ComMethd.VerifyString(BillingSrvInfo.get("Service1"), Electric.get(0));
//		ComMethd.VerifyString(BillingSrvInfo.get("Service1Equipment"), Electric.get(1));
//		ComMethd.VerifyString(BillingSrvInfo.get("Service1Rate"), Electric.get(2));
//		ComMethd.VerifyString(BillingSrvInfo.get("Service1Multi"), Electric.get(3));
//		ComMethd.VerifyString(BillingSrvInfo.get("Service1Status"), Electric.get(4));
//
//		BillingSrvInfo = dashBoard.GetBillingServiceGasInfo();
//
//		ComMethd.VerifyString(BillingSrvInfo.get("Service2"), Gas1.get(0));
//		ComMethd.VerifyString(BillingSrvInfo.get("Service2Equipment"), Gas1.get(1));
//		ComMethd.VerifyString(BillingSrvInfo.get("Service2Rate"), Gas1.get(2));
//		ComMethd.VerifyString(BillingSrvInfo.get("Service2Multi"), Gas1.get(3));
//		ComMethd.VerifyString(BillingSrvInfo.get("Service2Status"), Gas1.get(4));
//
//		BillingSrvInfo = dashBoard.GetBillingServiceInternetInfo();
//
//		ComMethd.VerifyString(BillingSrvInfo.get("Service3"), Internet.get(0));
//		ComMethd.VerifyString(BillingSrvInfo.get("Service3Equipment"), Internet.get(1));
//		ComMethd.VerifyString(BillingSrvInfo.get("Service3Rate"), Internet.get(2));
//		ComMethd.VerifyString(BillingSrvInfo.get("Service3Multi"), Internet.get(3));
//		ComMethd.VerifyString(BillingSrvInfo.get("Service3Status"), Internet.get(4));
//
//		// Verify Service by Clicking on Electricity icon
//		dashBoard.ClickServElecIcon();
//		BillingSrvInfo = dashBoard.GetBillingServiceElectricTABInfo();
//		ComMethd.VerifyString(BillingSrvInfo.get("Service1"), Electric.get(0));
//		ComMethd.VerifyString(BillingSrvInfo.get("Service1Equipment"), Electric.get(1));
//		ComMethd.VerifyString(BillingSrvInfo.get("Service1Rate"), Electric.get(2));
//		ComMethd.VerifyString(BillingSrvInfo.get("Service1Multi"), Electric.get(3));
//		ComMethd.VerifyString(BillingSrvInfo.get("Service1Status"), Electric.get(4));
//
//		dashBoard.ClickServGasIcon();
//		BillingSrvInfo = dashBoard.GetBillingServiceGasTABInfo();
//		
//		ComMethd.VerifyString(BillingSrvInfo.get("Service2"), Gas1.get(0));
//		ComMethd.VerifyString(BillingSrvInfo.get("Service2Equipment"), Gas1.get(1));
//		ComMethd.VerifyString(BillingSrvInfo.get("Service2Rate"), Gas1.get(2));
//		ComMethd.VerifyString(BillingSrvInfo.get("Service2Multi"), Gas1.get(3));
//		ComMethd.VerifyString(BillingSrvInfo.get("Service2Status"), Gas1.get(4));
//
//		dashBoard.ClickServInternetIcon();
//		BillingSrvInfo = dashBoard.GetBillingServiceInternetTABInfo();
//
//		ComMethd.VerifyString(BillingSrvInfo.get("Service3"), Internet.get(0));
//		ComMethd.VerifyString(BillingSrvInfo.get("Service3Equipment"), Internet.get(1));
//		ComMethd.VerifyString(BillingSrvInfo.get("Service3Rate"), Internet.get(2));
//		ComMethd.VerifyString(BillingSrvInfo.get("Service3Multi"), Internet.get(3));
//		ComMethd.VerifyString(BillingSrvInfo.get("Service3Status"), Internet.get(4));

		dashBoard.LogOut();
	}

}
