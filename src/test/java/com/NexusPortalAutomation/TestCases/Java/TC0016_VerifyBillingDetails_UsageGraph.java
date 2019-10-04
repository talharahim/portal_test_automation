package com.NexusPortalAutomation.TestCases.Java;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;

import com.NexusPortalAutomation.PageObjects.Java.DashBoard;
import com.NexusPortalAutomation.PageObjects.Java.DashBoardSearch;
import com.NexusPortalAutomation.Utilities.Java.CommonMethods;
import com.NexusPortalAutomation.Utilities.Java.SikuliUtility;

public class TC0016_VerifyBillingDetails_UsageGraph extends BaseClass {

	/*
	 * This test the search by Recent Customer Name
	 * 
	 * @author Talha Rahim
	 * 
	 * @version 1.0
	 * 
	 * @Since 2019-04-11
	 */

	public String locationID = getCellvalue("TC0016_1", "loc1");//"billgraph";
	CommonMethods cmnMethods = new CommonMethods();


//This Test will test the search by Customer ID
	@Test(priority = 1)
	public void VerifyBillingDetails() throws IOException, InterruptedException {
		DashBoardSearch dbSrch = new DashBoardSearch(driver);
		DashBoard dashBoard = new DashBoard(driver);
		SikuliUtility compare = new SikuliUtility();
		login();
		dbSrch.enterSearchText(locationID);
		dbSrch.clickCustomerName();
		// Verify Customer Location Id Updated for Test
			// Verify Service by Clicking on Electricity icon
		dashBoard.clickService1();
		compare.compareImage("./\\TestData\\sikuliimages\\billgraphwater1.png");
		
		dashBoard.clickService2();
		compare.compareImage("./\\TestData\\sikuliimages\\billgraphelec1.png");
		
		dashBoard.logout();
	}

}
