package com.NexusPortalAutomation.TestCases.Java;

import java.io.IOException;

import org.testng.annotations.Test;

import com.NexusPortalAutomation.PageObjects.Java.DashBoard;
import com.NexusPortalAutomation.PageObjects.Java.DashBoardSearch;
import com.NexusPortalAutomation.Utilities.Java.CommonMethods;

public class TC0019_verifyDrillbackTransactions extends BaseClass {

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
	public String customerId = "0000011111";
	public String serverUrl = getDrillbackServerUrl();
	public String payDocNum = "PYMT00000000425";
	public String billDocNum = "BILL00000000563";
	public String metDocNum = "READ00000000813";
	// Payment
	public String paymentUrl = serverUrl + "Prod=229&Act=OPEN&Func=TransactionPymtOrCreditMemoInquiry&DocumentNumber="
			+ payDocNum + "&CogsDrillback=1";
	// Bill
	public String billUrl = serverUrl + "Prod=229&Act=OPEN&Func=TransactionBillInquiry&DocumentNumber=" + billDocNum
			+ "&CogsDrillback=1";

	// Meter
	public String meterUrl = serverUrl + "Prod=229&Act=OPEN&Func=TransactionReadInquiry&DocumentNumber=" + metDocNum
			+ "&DocumentLocation=3&CogsDrillback=1";
	CommonMethods cmnMethods = new CommonMethods();
    //This Test will test the search by Customer ID
	@Test
	public void verifyDrillbackTransactions() throws IOException, InterruptedException {
		DashBoardSearch dbSrch = new DashBoardSearch(driver);
		DashBoard dashBoard = new DashBoard(driver);
		login();
		dbSrch.enterSearchText(locationID);
		dbSrch.clickCustomerName();
		// Verify Customer Location Id Updated for Test
		cmnMethods.verifyString(locationID, dashBoard.getLoggedCustomerLocationId());
		// Verify Contact is updated accordingly
		dashBoard.clickTransactionLink();
		// Verify Transaction details
		dashBoard.verifyTransDrillbacks(paymentUrl, billUrl, meterUrl);
		dashBoard.logout();
	}

}
