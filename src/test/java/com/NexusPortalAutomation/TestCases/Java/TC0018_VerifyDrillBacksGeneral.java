package com.NexusPortalAutomation.TestCases.Java;

import java.io.IOException;

import org.testng.annotations.Test;

import com.NexusPortalAutomation.PageObjects.Java.DashBoard;
import com.NexusPortalAutomation.PageObjects.Java.DashBoardSearch;
import com.NexusPortalAutomation.Utilities.Java.CommonMethods;

public class TC0018_VerifyDrillBacksGeneral extends BaseClass {

	/*
	 * This test the search by Recent Customer Name
	 * 
	 * @author Talha Rahim
	 * 
	 * @version 1.0
	 * 
	 * @Since 2019-06-10
	 */

	public String locationID = "LOC@0004";
	public String locationID2 = "LOC@0001";
	public String CustomerID = "0000011111";
	public String ServerURL = GetDrillBackServerURL();

	public String custURL = ServerURL + "Prod=229&Act=OPEN&Func=CustomerMaintenance&CustomerID=" + CustomerID
			+ "&locationID=" + locationID + "&CogsDrillback=1";

	public String secondCustURL = ServerURL + "Bug reported";

	public String servTabURL = ServerURL + "kk";

	public String contLogURL = ServerURL + "Prod=229&Act=OPEN&Func=ContactLog&CustomerID=" + CustomerID + "&locationID="
			+ locationID + "&ContactLog=1&CogsDrillback=1";

	// Cashiering
	public String cashieringURL = ServerURL + "Prod=229&Act=OPEN&Func=Cashiering&CustomerID=" + CustomerID
			+ "&locationID=" + locationID + "&CogsDrillback=1";

	// Credit Memo
	public String creditMemoURL = ServerURL + "Prod=229&Act=OPEN&Func=CreditMemo&CustomerID=" + CustomerID
			+ "&locationID=" + locationID + "&CogsDrillback=1";

	// Deposit
	public String depositURL = ServerURL + "Prod=229&Act=OPEN&Func=Deposits&CustomerID=" + CustomerID + "&locationID="
			+ locationID + "&CogsDrillback=1";

	// Misc Charges
	public String miscChargesURL = ServerURL + "Prod=229&Act=OPEN&Func=MiscellaneousCharges&CustomerID=" + CustomerID
			+ "&locationID=" + locationID + "&CogsDrillback=1";
	// Payment Arrangements
	public String paymentArrURL = ServerURL + "Prod=229&Act=OPEN&Func=SPA&CustomerID=" + CustomerID + "&locationID="
			+ locationID + "&CogsDrillback=1";

	// Payment Extensions
	public String paymentExtURL = ServerURL + "Prod=229&Act=OPEN&Func=PaymentExtensions&CustomerID=" + CustomerID
			+ "&locationID=" + locationID + "&CogsDrillback=1";

	// Void
	public String voidURL = ServerURL + "Prod=229&Act=OPEN&Func=VoidEntry&CustomerID=" + CustomerID + "&locationID="
			+ locationID + "&CogsDrillback=1";
	// ContactLog
	public String contactLogURL = ServerURL + "Prod=229&Act=OPEN&Func=ContactLog&CustomerID=" + CustomerID
			+ "&locationID=" + locationID + "&CogsDrillback=1";

	// Meter Reading
	public String meterReadingURL = ServerURL + "Prod=229&Act=OPEN&Func=Meterreading&CustomerID=" + CustomerID
			+ "&locationID=" + locationID + "&CogsDrillback=1";

	public String scondaryCustomerURL = ServerURL + "Prod=229&Act=OPEN&Func=SecondaryCustomer&locationID=" + locationID
			+ "&CustomerID=" + CustomerID
			+ "&Address=1  Water ALY  BLDG 1 NEW SMYRNA  BEACH FL 123123&CustName=Mr. Auto Contact&CogsDrillback=1";

	public String serviceURL = ServerURL
			+ "Prod=229&Act=OPEN&Func=LocationAccountServices&CustomerID=DRILBACK&locationID=" + locationID2
			+ "&CogsDrillback=1";

	public String enhancedNotesCustURL = ServerURL
			+ "Prod=0&Act=OPEN&Func=EnhansedNote&NoteId=DRILBACK&NoteIndex=49.00000&CogsDrillback=1";

	public String enhancedNotesLocURL = ServerURL + "Prod=0&Act=OPEN&Func=EnhansedNote&NoteId=" + locationID2
			+ "&NoteIndex=52.00000&CogsDrillback=1";

	CommonMethods cmnMethods = new CommonMethods();

//This Test will test the search by Customer ID
	@Test(priority = 1)
	public void VerifyDrillBacksGeneral() throws IOException, InterruptedException {
		DashBoardSearch dbSrch = new DashBoardSearch(driver);
		DashBoard dashBoard = new DashBoard(driver);
		login();
		dbSrch.enterSearchText(locationID);
		dbSrch.clickCustomerName();
		// Verify Customer Location Id Updated for Test
		cmnMethods.verifyString(locationID, dashBoard.getLoggedCustomerName());
		// Verify Contact is updated accordingly

		cmnMethods.verifyString(custURL, dashBoard.GetCustDrillBackUrl());
		/*
		 * Secondary Customer URL NOT Present
		 * cmnMethods.VerifyString(secondCustURL,dashBoard.GetSecondCustDrillBackUrl());
		 */
		cmnMethods.verifyString(contLogURL, dashBoard.getContLogDrillBackUrl());
		dashBoard.clickActionDropDown();
		// Action DrillBacks
		dashBoard.VerifyActionDrillBacks(cashieringURL, creditMemoURL, depositURL, miscChargesURL, paymentArrURL,
				paymentExtURL, voidURL, contactLogURL, meterReadingURL);
		// Secondary Customer URL
		dashBoard.VerifyDrillBack("SCUST_Drillback", scondaryCustomerURL);
		// Change User
		dashBoard.enterDashBoardSearch(locationID2);
		dashBoard.clickDashBoardSearchResult1();
		// Service Drillback
		dashBoard.VerifyDrillBack("SERV_Tab_Drillback", serviceURL);
		dashBoard.VerifyDrillBack("ENH_Drillback_Customer", enhancedNotesCustURL);
		dashBoard.VerifyDrillBack("ENH_Drillback_Location", enhancedNotesLocURL);
		// Verify Updated details
		dashBoard.logout();
	}

}
