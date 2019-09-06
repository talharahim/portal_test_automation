package com.NexusPortalAutomation.TestCases.Java;

import java.io.IOException;

import org.testng.annotations.Test;

import com.NexusPortalAutomation.PageObjects.Java.DashBoard;
import com.NexusPortalAutomation.PageObjects.Java.DashBoardSearch;
import com.NexusPortalAutomation.Utilities.Java.CommonMethods;

public class TC0020_VerifyDrillBackServices extends BaseClass {

	/*
	 * This test the search Drill Back for Services TAB
	 * @author Talha Rahim
	 * @version 1.0
	 * @Since 2019-06-11
	 */
	public String locationID = "LOC@0001";
	public String CustomerID = "0000011111";
	public String ServerURL = GetDrillBackServerURL();
	public String ServiceOrderNumber = "SORD00000000057";
		
	// ServiceOrder
	public String ServiceOrderUrl = ServerURL + "&Prod=229&Act=OPEN&Func=ServiceOrderInquiry&ServiceOrderNumber="+ServiceOrderNumber+"&CogsDrillback=1";
	CommonMethods cmnMethods = new CommonMethods();
    //This Test will test the search by Customer ID
	
	@Test
	public void TestDrillBackServices() throws IOException, InterruptedException {
		DashBoardSearch dbSrch = new DashBoardSearch(driver);
		DashBoard dashBoard = new DashBoard(driver);
		login();
		dbSrch.enterSearchText(locationID);
		dbSrch.clickCustomerName();
		// Verify Customer Location Id Updated for Test
		cmnMethods.verifyString(locationID, dashBoard.getLoggedCustomerName());
		// Verify Contact is updated accordingly
		dashBoard.ClickServiceOrderLink();
		// Verify Transaction details
		dashBoard.VerifyServiceOrderDrillBacks(ServiceOrderUrl);
		dashBoard.logout();
	}

}
