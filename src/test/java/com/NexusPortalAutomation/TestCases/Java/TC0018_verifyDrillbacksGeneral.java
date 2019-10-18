package com.NexusPortalAutomation.TestCases.Java;

import java.io.IOException;

import org.testng.annotations.Test;

import com.NexusPortalAutomation.PageObjects.Java.DashBoard;
import com.NexusPortalAutomation.PageObjects.Java.DashBoardSearch;
import com.NexusPortalAutomation.Utilities.Java.CommonMethods;

public class TC0018_verifyDrillbacksGeneral extends BaseClass {

	/*
	 * This test the search by Recent Customer Name
	 * 
	 * @author Talha Rahim
	 * 
	 * @version 1.0
	 * 
	 * @Since 2019-06-10
	 */

	public String locationID = getCellvalue("TC0018", "drillbackLoc");//"LOC@0004";
	public String locationID2 =getCellvalue("TC0018", "loc1");// "LOC@0001";
	public String customerId =getCellvalue("TC0018", "drillbackCustId");// "0000011111";
	public String serverUrl = getDrillbackServerUrl();

	public String custURL = serverUrl + "Prod=229&Act=OPEN&Func=CustomerMaintenance&CustomerID=" + customerId
			+ "&LocationID=" + locationID + "&CogsDrillback=1";
	//cogsdrillback://DGPB/?Db=SQL_2017&Srv=RND-BASE-A&Cmp=TWO&Prod=229&Act=OPEN&Func=CustomerMaintenance&CustomerID=0000011111&LocationID=LOC@0004&CogsDrillback=1' not Matched the expected value 'cogsdrillback://DGPB/?Db=SQL_2017&Srv=RND-BASE-A&Cmp=TWO&Prod=229&Act=OPEN&Func=CustomerMaintenance&CustomerId=0000011111&LocationID=LOC@0004&CogsDrillback=1
	public String secondCustURL = serverUrl + "Bug reported";

	public String servTabURL = serverUrl + "kk";

	public String contLogURL = serverUrl + "Prod=229&Act=OPEN&Func=ContactLog&CustomerID=" + customerId + "&LocationID="
			+ locationID + "&ContactLog=1&CogsDrillback=1";

	// Cashiering
	public String cashieringURL = serverUrl + "Prod=229&Act=OPEN&Func=Cashiering&CustomerID=" + customerId
			+ "&LocationID=" + locationID + "&CogsDrillback=1";

	// Credit Memo
	public String creditMemoURL = serverUrl + "Prod=229&Act=OPEN&Func=CreditMemo&CustomerID=" + customerId
			+ "&LocationID=" + locationID + "&CogsDrillback=1";

	// Deposit
	public String depositURL = serverUrl + "Prod=229&Act=OPEN&Func=Deposits&CustomerID=" + customerId + "&LocationID="
			+ locationID + "&CogsDrillback=1";

	// Misc Charges
	public String miscChargesURL = serverUrl + "Prod=229&Act=OPEN&Func=MiscellaneousCharges&CustomerID=" + customerId
			+ "&LocationID=" + locationID + "&CogsDrillback=1";
	// Payment Arrangements
	public String paymentArrURL = serverUrl + "Prod=229&Act=OPEN&Func=SPA&CustomerID=" + customerId + "&LocationID="
			+ locationID + "&CogsDrillback=1";

	// Payment Extensions
	public String paymentExtURL = serverUrl + "Prod=229&Act=OPEN&Func=PaymentExtensions&CustomerID=" + customerId
			+ "&LocationID=" + locationID + "&CogsDrillback=1";

	// Void
	public String voidURL = serverUrl + "Prod=229&Act=OPEN&Func=VoidEntry&CustomerID=" + customerId + "&LocationID="
			+ locationID + "&CogsDrillback=1";
	// ContactLog
	public String contactLogURL = serverUrl + "Prod=229&Act=OPEN&Func=ContactLog&CustomerID=" + customerId
			+ "&LocationID=" + locationID + "&CogsDrillback=1";

	// Meter Reading
	public String meterReadingURL = serverUrl + "Prod=229&Act=OPEN&Func=Meterreading&CustomerID=" + customerId
			+ "&LocationID=" + locationID + "&CogsDrillback=1";

	public String scondaryCustomerURL = serverUrl + "Prod=229&Act=OPEN&Func=SecondaryCustomer&LocationID=" + locationID
			+ "&CustomerID=" + customerId
			+ "&Address=1  Water ALY  BLDG 1 NEW SMYRNA  BEACH FL 123123&CustName=Mr. Auto Contact&CogsDrillback=1";

	public String serviceURL = serverUrl
			+ "Prod=229&Act=OPEN&Func=LocationAccountServices&CustomerID=DRILBACK&LocationID=" + locationID2
			+ "&CogsDrillback=1";

	public String enhancedNotesCustURL = serverUrl
			+ "Prod=0&Act=OPEN&Func=EnhansedNote&NoteID=DRILBACK&NoteIndex=49.00000&CogsDrillback=1";

	public String enhancedNotesLocURL = serverUrl + "Prod=0&Act=OPEN&Func=EnhansedNote&NoteID=" + locationID2
			+ "&NoteIndex=52.00000&CogsDrillback=1";

	

//This Test will test the search by Customer ID
	@Test(priority = 1)
	public void verifyDrillbacksGeneral() throws IOException, InterruptedException {
		DashBoardSearch dbSrch = new DashBoardSearch(driver);
		DashBoard dashBoard = new DashBoard(driver);
		login();
		dbSrch.enterSearchText(locationID);
		dbSrch.clickCustomerName();
		// Verify Customer Location Id Updated for Test
		CommonMethods.verifyString(locationID, dashBoard.getLoggedCustomerLocationId());
		// Verify Contact is updated accordingly

		CommonMethods.verifyString(custURL, dashBoard.GetCustDrillBackUrl());
		/*
		 * Secondary Customer URL NOT Present
		 * CommonMethods.VerifyString(secondCustURL,dashBoard.GetSecondCustDrillBackUrl());
		 */
		CommonMethods.verifyString(contLogURL, dashBoard.getContLogDrillBackUrl());
		dashBoard.clickActionDropDown();
		// Action DrillBacks
		dashBoard.VerifyActionDrillBacks(cashieringURL, creditMemoURL, depositURL, miscChargesURL, paymentArrURL,
				paymentExtURL, voidURL, contactLogURL, meterReadingURL);
		// Secondary Customer URL
		dashBoard.verifyDrillback("SCUST_Drillback", scondaryCustomerURL);
		// Change User
		dashBoard.enterDashBoardSearch(locationID2);
		dashBoard.clickDashBoardSearchResult1();
		// Service Drillback
		dashBoard.verifyDrillback("SERV_Tab_Drillback", serviceURL);
		dashBoard.verifyDrillback("customer-person", enhancedNotesCustURL);
		dashBoard.verifyDrillback("ENH_Location_Drillback", enhancedNotesLocURL);
		// Verify Updated details
		dashBoard.logout();
	}

}
