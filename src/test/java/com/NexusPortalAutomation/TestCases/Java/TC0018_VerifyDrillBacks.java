package com.NexusPortalAutomation.TestCases.Java;

import java.io.IOException;

import org.testng.annotations.Test;

import com.NexusPortalAutomation.PageObjects.Java.DashBoard;
import com.NexusPortalAutomation.PageObjects.Java.DashBoardSearch;
import com.NexusPortalAutomation.Utilities.Java.CommonMethods;

public class TC0018_VerifyDrillBacks extends BaseClass {

	/*
	 * This test the search by Recent Customer Name
	 * 
	 * @author Talha Rahim
	 * 
	 * @version 1.0
	 * 
	 * @Since 2019-04-11
	 */

	public String LocationID = "LOC@0004";
	public String CustomerID ="0000011111";
	public String SecondCust = "Secondary Customer (SECONDARY)";
	public String ServerURL = GetDrillBackServerURL();

	public String custURL = ServerURL
			+ "Prod=229&Act=OPEN&Func=CustomerMaintenance&CustomerID=0000011111&LocationID=LOC@0004&CogsDrillback=1";

	public String servTabURL = ServerURL + "kk";

	public String contLogURL = ServerURL
			+ "Prod=229&Act=OPEN&Func=ContactLog&CustomerID=0000011111&LocationID=LOC@0004&ContactLog=1&CogsDrillback=1";

	// Cashiering
	public String cashieringURL = ServerURL
			+ "Prod=229&Act=OPEN&Func=Cashiering&CustomerID=0000011111&LocationID=LOC@0004&CogsDrillback=1";
	
	// Credit Memo
	public String creditMemoURL = ServerURL
			+ "Prod=229&Act=OPEN&Func=CreditMemo&CustomerID=0000011111&LocationID=LOC@0004&CogsDrillback=1";
	
	//Deposit
	public String depositURL = ServerURL
			+ "Prod=229&Act=OPEN&Func=Deposits&CustomerID=0000011111&LocationID=LOC@0004&CogsDrillback=1";
	
	//Misc Charges
	public String miscChargesURL = ServerURL
			+ "Prod=229&Act=OPEN&Func=MiscellaneousCharges&CustomerID=0000011111&LocationID=LOC@0004&CogsDrillback=1";
	//Payment Arrangements
	public String paymentArrURL = ServerURL
			+ "Prod=229&Act=OPEN&Func=SPA&CustomerID=0000011111&LocationID=LOC@0004&CogsDrillback=1";

	//Payment Extensions
	public String paymentExtURL = ServerURL
			+ "Prod=229&Act=OPEN&Func=PaymentExtensions&CustomerID=0000011111&LocationID=LOC@0004&CogsDrillback=1";
	
	//Void
	public String voidURL = ServerURL
			+ "Prod=229&Act=OPEN&Func=VoidEntry&CustomerID=0000011111&LocationID=LOC@0004&CogsDrillback=1";
	//ContactLog
	public String contactLogURL = ServerURL
			+ "Prod=229&Act=OPEN&Func=ContactLog&CustomerID=0000011111&LocationID=LOC@0004&CogsDrillback=1";
	
	//Meter Reading
	public String meterReadingURL = ServerURL
			+ "Prod=229&Act=OPEN&Func=Meterreading&CustomerID=0000011111&LocationID=LOC@0004&CogsDrillback=1";
	
	CommonMethods ComMethd = new CommonMethods();

//This Test will test the search by Customer ID
	@Test(priority = 1)
	public void TestSecondayContact() throws IOException, InterruptedException {
		DashBoardSearch dbSrch = new DashBoardSearch(driver);
		DashBoard dashBoard = new DashBoard(driver);
		login();
		dbSrch.EnterSearchText(LocationID);
		dbSrch.ClickCustomer();
		// Verify Customer Location Id Updated for Test
		ComMethd.VerifyString(LocationID, dashBoard.GetLoggedCustomerLocationId());
		// Verify Contact is updated accordingly

		ComMethd.VerifyString(custURL, dashBoard.GetCustDrillBackUrl());
		// ComMethd.VerifyString(servTabURL, dashBoard.GetServiceTabDrillBackUrl());
		ComMethd.VerifyString(contLogURL, dashBoard.getContLogDrillBackUrl());
		dashBoard.clickActionDropDown();

		
		// Verify Updated details
		dashBoard.LogOut();
	}

}
