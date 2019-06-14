package com.NexusPortalAutomation.TestCases.Java;

import java.io.IOException;

import org.testng.annotations.Test;

import com.NexusPortalAutomation.PageObjects.Java.DashBoard;
import com.NexusPortalAutomation.PageObjects.Java.DashBoardSearch;
import com.NexusPortalAutomation.Utilities.Java.CommonMethods;

public class TC0021_VerifyServicesOrderDetails extends BaseClass {

	/*
	 * This test the search Drill Back for Services TAB
	 * @author Talha Rahim
	 * @version 1.0
	 * @Since 2019-06-14
	 */
	public String LocationID = "LOC@0001";
	public String CustomerID = "0000011111";
	public String ServerURL = GetDrillBackServerURL();
	CommonMethods ComMethd = new CommonMethods();
    //This Test will test the search by Customer ID
	
	@Test
	public void TestSecondayContact() throws IOException, InterruptedException {
		DashBoardSearch dbSrch = new DashBoardSearch(driver);
		DashBoard dashBoard = new DashBoard(driver);
		login();
		dbSrch.EnterSearchText(LocationID);
		dbSrch.ClickCustomer();
		// Verify Customer Location Id Updated for Test
		ComMethd.VerifyString(LocationID, dashBoard.GetLoggedCustomerLocationId());
		// Verify Contact is updated accordingly
		dashBoard.ClickServiceOrderLink();
		dashBoard.ServOrd_SelectDateAnyTime();
		// Verify Service Order details
		
		dashBoard.LogOut();
	}

}
