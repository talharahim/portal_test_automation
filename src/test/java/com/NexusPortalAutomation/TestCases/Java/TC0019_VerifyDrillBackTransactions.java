package com.NexusPortalAutomation.TestCases.Java;

import java.io.IOException;

import org.testng.annotations.Test;

import com.NexusPortalAutomation.PageObjects.Java.DashBoard;
import com.NexusPortalAutomation.PageObjects.Java.DashBoardSearch;
import com.NexusPortalAutomation.Utilities.Java.CommonMethods;

public class TC0019_VerifyDrillBackTransactions extends BaseClass {

	/*
	 * This test the search by Recent Customer Name
	 * 
	 * @author Talha Rahim
	 * 
	 * @version 1.0
	 * 
	 * @Since 2019-06-11
	 */
	public String locationID = "LOC@0001";
	public String CustomerID = "0000011111";
	public String ServerURL = GetDrillBackServerURL();
	public String PayDocNum = "PYMT00000000425";
	public String BillDocNum = "BILL00000000563";
	public String MetDocNum = "READ00000000813";
	// Payment
	public String PaymentURL = ServerURL + "Prod=229&Act=OPEN&Func=TransactionPymtOrCreditMemoInquiry&DocumentNumber="
			+ PayDocNum + "&CogsDrillback=1";
	// Bill
	public String BillURL = ServerURL + "Prod=229&Act=OPEN&Func=TransactionBillInquiry&DocumentNumber=" + BillDocNum
			+ "&CogsDrillback=1";

	// Meter
	public String MeterURL = ServerURL + "Prod=229&Act=OPEN&Func=TransactionReadInquiry&DocumentNumber=" + MetDocNum
			+ "&DocumentLocation=3&CogsDrillback=1";
	CommonMethods cmnMethods = new CommonMethods();
    //This Test will test the search by Customer ID
	@Test
	public void VerifyDrillBackTransactions() throws IOException, InterruptedException {
		DashBoardSearch dbSrch = new DashBoardSearch(driver);
		DashBoard dashBoard = new DashBoard(driver);
		login();
		dbSrch.enterSearchText(locationID);
		dbSrch.clickCustomerName();
		// Verify Customer Location Id Updated for Test
		cmnMethods.verifyString(locationID, dashBoard.getLoggedCustomerName());
		// Verify Contact is updated accordingly
		dashBoard.clickTransactionLink();
		// Verify Transaction details
		dashBoard.VerifyTransDrillBacks(PaymentURL, BillURL, MeterURL);
		dashBoard.logout();
	}

}
