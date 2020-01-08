package com.NexusPortalAutomation.TestCases.Java;

import java.io.IOException;
import java.util.HashMap;

import org.testng.annotations.Test;

import com.NexusPortalAutomation.PageObjects.Java.DashBoard;
import com.NexusPortalAutomation.PageObjects.Java.DashBoardSearch;
import com.NexusPortalAutomation.PageObjects.Java.Dashboard_Transactions;
import com.NexusPortalAutomation.Utilities.Java.CommonMethods;

public class TC0042_Transactions_OrderbyDate extends BaseClass {

	/*
	 * This test the search by Recent Customer Name
	 * 
	 * @author Talha Rahim
	 * 
	 * @version 1.0
	 * 
	 * @Since 2019-06-11
	 */
	public String locationID = getCellvalue("TC0042", "locationID");// "BILLSAPERATE01";
	public String recordType = getCellvalue("TC0042", "recordType");// "Regular Bill";
	public String recordAmount = getCellvalue("TC0042", "recordAmount");// "$17.10";
	public String recordDate = getCellvalue("TC0042", "recordDate");// "Sep 30, 2019";

	public String recordType2 = getCellvalue("TC0042", "recordType2");// "Regular Bill";
	public String recordAmount2 = getCellvalue("TC0042", "recordAmount2");// "$27.12";
	public String recordDate2 = getCellvalue("TC0042", "recordDate2");// "Sep 30, 2019";
	public String title = getCellvalue("TC0042", "title");// "Transactions";

	String drillback = getCellvalue("TC0042", "drillback");// "&Func=TransactionBillInquiry&DocumentNumber=BILL00000000612&CogsDrillback=1";
	String docType = getCellvalue("TC0042", "docType");// "Bill";
	String documentNum = getCellvalue("TC0042", "documentNum");// "BILL00000000612";
	String status = getCellvalue("TC0042", "status");// "Open";
	String transAmount = getCellvalue("TC0042", "transAmount");// "$27.12";
	String transDocDate = getCellvalue("TC0042", "transDocDate");// "Sep 30, 2019";
	String transDueDate = getCellvalue("TC0042", "transDueDate");// "Oct 31, 2019";
	String outstanding = getCellvalue("TC0042", "outstanding");// "$27.12";

	String drillbackBill2 = getCellvalue("TC0042", "drillbackBill2");// "&Func=TransactionBillInquiry&DocumentNumber=BILL00000000611&CogsDrillback=1";
	String docTypeBill2 = getCellvalue("TC0042", "docTypeBill2");// "Bill";
	String documentNumBill2 = getCellvalue("TC0042", "documentNumBill2");// "BILL00000000611";
	String statusBill2 = getCellvalue("TC0042", "statusBill2");// "Open";
	String transAmountBill2 = getCellvalue("TC0042", "transAmountBill2");// "$17.10";
	String transDocDateBill2 = getCellvalue("TC0042", "transDocDateBill2");// "Sep 30, 2019";
	String transDueDateBill2 = getCellvalue("TC0042", "transDueDateBill2");// "Oct 31, 2019";
	String outstandingBill2 = getCellvalue("TC0042", "outstandingBill2");// "$17.10";

	@Test
	public void VerifyTransactionsSaperatebill_saperate() throws IOException, InterruptedException {

		
		DashBoardSearch dbSrch = new DashBoardSearch(driver);
		Dashboard_Transactions dashBoardTransactions = new Dashboard_Transactions(driver);
		login();
		dbSrch.enterSearchText(locationID);
		dbSrch.clickCustomerName();
		// Verify Customer Location Id Updated for Test
		CommonMethods.verifyString(locationID, dashBoardTransactions.getLoggedCustomerLocationId());
		// Verify Contact is updated accordingly

		// Verify Recent
		dashBoardTransactions.verifyRecentRecord1(recordType, recordDate, recordAmount);
		dashBoardTransactions.verifyRecentRecord2(recordType2, recordDate2, recordAmount2);
		dashBoardTransactions.clickRecentSearch_ViewAll();
		CommonMethods.verifyString(title, dashBoardTransactions.getTransactionPageTitle());
		dashBoardTransactions.clickTransactionLink();
		//dashBoardTransactions.transaction_filterbyBill();
		
		// Verify Transaction details for Bill 1
		HashMap<String, String> billingInfo1 = dashBoardTransactions.getTransactionsRecord(1);
		CommonMethods.verifyStringContains(billingInfo1.get("drillback"), drillback);
		CommonMethods.verifyString(billingInfo1.get("docType"), docType);
		CommonMethods.verifyString(billingInfo1.get("documentNum"), documentNum);
		CommonMethods.verifyString(billingInfo1.get("status"), status);
		CommonMethods.verifyString(billingInfo1.get("transAmount"), transAmount);
		CommonMethods.verifyString(billingInfo1.get("transDocDate"), transDocDate);
		CommonMethods.verifyString(billingInfo1.get("transDueDate"), transDueDate);
		CommonMethods.verifyString(billingInfo1.get("outstanding"), outstanding);

		// Verify Transaction details for Bill 2
		HashMap<String, String> billingInfo2 = dashBoardTransactions.getTransactionsRecord(2);
		CommonMethods.verifyStringContains(billingInfo2.get("drillback"), drillbackBill2);
		CommonMethods.verifyString(billingInfo2.get("docType"), docTypeBill2);
		CommonMethods.verifyString(billingInfo2.get("documentNum"), documentNumBill2);
		CommonMethods.verifyString(billingInfo2.get("status"), statusBill2);
		CommonMethods.verifyString(billingInfo2.get("transAmount"), transAmountBill2);
		CommonMethods.verifyString(billingInfo2.get("transDocDate"), transDocDateBill2);
		CommonMethods.verifyString(billingInfo2.get("transDueDate"), transDueDateBill2);
		CommonMethods.verifyString(billingInfo2.get("outstanding"), outstandingBill2);

		
		dashBoardTransactions.clickDateFilter_TransactionsRecord();
		billingInfo1 = dashBoardTransactions.getTransactionsRecord(3);
		CommonMethods.verifyStringContains(billingInfo1.get("drillback"), drillback);
		CommonMethods.verifyString(billingInfo1.get("docType"), docType);
		CommonMethods.verifyString(billingInfo1.get("documentNum"), documentNum);
		CommonMethods.verifyString(billingInfo1.get("status"), status);
		CommonMethods.verifyString(billingInfo1.get("transAmount"), transAmount);
		CommonMethods.verifyString(billingInfo1.get("transDocDate"), transDocDate);
		CommonMethods.verifyString(billingInfo1.get("transDueDate"), transDueDate);
		CommonMethods.verifyString(billingInfo1.get("outstanding"), outstanding);

		billingInfo2 = dashBoardTransactions.getTransactionsRecord(4);
		CommonMethods.verifyStringContains(billingInfo2.get("drillback"), drillbackBill2);
		CommonMethods.verifyString(billingInfo2.get("docType"), docTypeBill2);
		CommonMethods.verifyString(billingInfo2.get("documentNum"), documentNumBill2);
		CommonMethods.verifyString(billingInfo2.get("status"), statusBill2);
		CommonMethods.verifyString(billingInfo2.get("transAmount"), transAmountBill2);
		CommonMethods.verifyString(billingInfo2.get("transDocDate"), transDocDateBill2);
		CommonMethods.verifyString(billingInfo2.get("transDueDate"), transDueDateBill2);
		CommonMethods.verifyString(billingInfo2.get("outstanding"), outstandingBill2);

		dashBoardTransactions.logout();
	}

}
