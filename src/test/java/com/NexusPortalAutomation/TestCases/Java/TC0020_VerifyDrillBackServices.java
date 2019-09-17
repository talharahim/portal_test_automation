package com.NexusPortalAutomation.TestCases.Java;

import java.io.IOException;

import org.testng.annotations.Test;

import com.NexusPortalAutomation.PageObjects.Java.DashBoard;
import com.NexusPortalAutomation.PageObjects.Java.DashBoardSearch;
import com.NexusPortalAutomation.Utilities.Java.CommonMethods;

public class TC0020_verifyDrillbackServices extends BaseClass {

	/*
	 * This test the search Drill Back for Services TAB
	 * @author Talha Rahim
	 * @version 1.0
	 * @Since 2019-06-11
	 */
	public String locationID = getCellvalue("TC0020", "loc1");//"LOC@0001";
	public String customerId = getCellvalue("TC0020", "drillbackCustId");//"0000011111";
	public String serverUrl = getDrillbackServerUrl();
	public String serviceOrderNum = getCellvalue("TC0020", "drillbackSNum");//"SORD00000000057";
		
	// ServiceOrder
	public String serviceOrderUrl = serverUrl + "&Prod=229&Act=OPEN&Func=ServiceOrderInquiry&serviceOrderNum="+serviceOrderNum+"&CogsDrillback=1";
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
		cmnMethods.verifyString(locationID, dashBoard.getLoggedCustomerLocationId());
		// Verify Contact is updated accordingly
		dashBoard.clickServiceorderLink();
		// Verify Transaction details
		dashBoard.verifyServiceorderDrillbacks(serviceOrderUrl);
		dashBoard.logout();
	}

}
