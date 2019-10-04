package com.NexusPortalAutomation.TestCases.Java;

import java.io.IOException;
import java.util.HashMap;

import org.testng.annotations.Test;

import com.NexusPortalAutomation.PageObjects.Java.DashBoard;
import com.NexusPortalAutomation.PageObjects.Java.DashBoardSearch;
import com.NexusPortalAutomation.PageObjects.Java.Dashboard_Transactions;
import com.NexusPortalAutomation.Utilities.Java.CommonMethods;

public class TC0016_1_VerifyBillingDetails_VerifyBillSaperately extends BaseClass {

	/*
	 * This test the search by Recent Customer Name
	 * 
	 * @author Talha Rahim
	 * 
	 * @version 1.0
	 * 
	 * @Since 2019-06-11
	 */
	public String locationID = getCellvalue("TC0016", "locationID");// "BILLSAPERATE01";
	public String recordType =  getCellvalue("TC0016", "recordType");//"Regular Bill";
	public String recordAmount =  getCellvalue("TC0016", "recordAmount");//"$17.10";
	public String recordDate =  getCellvalue("TC0016", "recordDate");//"Sep 30, 2019";

	public String recordType2 =  getCellvalue("TC0016", "recordType2");//"Regular Bill";
	public String recordAmount2 =  getCellvalue("TC0016", "recordAmount2");//"$27.12";
	public String recordDate2 = getCellvalue("TC0016", "recordDate2");// "Sep 30, 2019";
	public String title = getCellvalue("TC0016", "title");// "Transactions";

	String drillback = getCellvalue("TC0016", "drillback");// "&Func=TransactionBillInquiry&DocumentNumber=BILL00000000612&CogsDrillback=1";
	String docType =  getCellvalue("TC0016", "docType");//"Bill";
	String documentNum =  getCellvalue("TC0016", "documentNum");//"BILL00000000612";
	String status =  getCellvalue("TC0016", "status");//"Open";
	String transAmount =  getCellvalue("TC0016", "transAmount");//"$27.12";
	String transDocDate =  getCellvalue("TC0016", "transDocDate");//"Sep 30, 2019";
	String transDueDate =  getCellvalue("TC0016", "transDueDate");//"Oct 31, 2019";
	String outstanding =  getCellvalue("TC0016", "outstanding");//"$27.12";

	String drillbackBill2 = getCellvalue("TC0016", "drillbackBill2");// "&Func=TransactionBillInquiry&DocumentNumber=BILL00000000611&CogsDrillback=1";
	String docTypeBill2 =  getCellvalue("TC0016", "docTypeBill2");//"Bill";
	String documentNumBill2 =  getCellvalue("TC0016", "documentNumBill2");//"BILL00000000611";
	String statusBill2 = getCellvalue("TC0016", "statusBill2");// "Open";
	String transAmountBill2 =  getCellvalue("TC0016", "transAmountBill2");//"$17.10";
	String transDocDateBill2 = getCellvalue("TC0016", "transDocDateBill2");// "Sep 30, 2019";
	String transDueDateBill2 =  getCellvalue("TC0016", "transDueDateBill2");//"Oct 31, 2019";
	String outstandingBill2 =  getCellvalue("TC0016", "outstandingBill2");//"$17.10";

	@Test
	public void VerifyTransactionsSaperatebill_saperate() throws IOException, InterruptedException {

		CommonMethods cmnMethods = new CommonMethods();
		DashBoardSearch dbSrch = new DashBoardSearch(driver);
		Dashboard_Transactions dashBoardTransactions = new Dashboard_Transactions(driver);
		login();
		dbSrch.enterSearchText(locationID);
		dbSrch.clickCustomerName();
		// Verify Customer Location Id Updated for Test
		cmnMethods.verifyString(locationID, dashBoardTransactions.getLoggedCustomerLocationId());
		// Verify Contact is updated accordingly

		// Verify Recent
		dashBoardTransactions.verifyRecentRecord1(recordType, recordDate, recordAmount);
		dashBoardTransactions.verifyRecentRecord2(recordType2, recordDate2, recordAmount2);
		dashBoardTransactions.clickRecentSearch_ViewAll();
		cmnMethods.verifyString(title, dashBoardTransactions.getTransactionPageTitle());
		dashBoardTransactions.clickTransactionLink();
		dashBoardTransactions.transaction_filterbyBill();
		//Verify Transaction details for Bill 1
		HashMap<String, String> billingInfo1 = dashBoardTransactions.getTransactionsRecord(1);
		cmnMethods.verifyStringContains(billingInfo1.get("drillback"), drillback);
		cmnMethods.verifyString(billingInfo1.get("docType"), docType);
		cmnMethods.verifyString(billingInfo1.get("documentNum"), documentNum);
		cmnMethods.verifyString(billingInfo1.get("status"), status);
		cmnMethods.verifyString(billingInfo1.get("transAmount"), transAmount);
		cmnMethods.verifyString(billingInfo1.get("transDocDate"), transDocDate);
		cmnMethods.verifyString(billingInfo1.get("transDueDate"), transDueDate);
		cmnMethods.verifyString(billingInfo1.get("outstanding"), outstanding);
		// Verify Transaction details for Bill 2
		HashMap<String, String> billingInfo2 = dashBoardTransactions.getTransactionsRecord(2);
		cmnMethods.verifyStringContains(billingInfo2.get("drillback"), drillbackBill2);
		cmnMethods.verifyString(billingInfo2.get("docType"), docTypeBill2);
		cmnMethods.verifyString(billingInfo2.get("documentNum"), documentNumBill2);
		cmnMethods.verifyString(billingInfo2.get("status"), statusBill2);
		cmnMethods.verifyString(billingInfo2.get("transAmount"), transAmountBill2);
		cmnMethods.verifyString(billingInfo2.get("transDocDate"), transDocDateBill2);
		cmnMethods.verifyString(billingInfo2.get("transDueDate"), transDueDateBill2);
		cmnMethods.verifyString(billingInfo2.get("outstanding"), outstandingBill2);

		dashBoardTransactions.logout();
	}

}