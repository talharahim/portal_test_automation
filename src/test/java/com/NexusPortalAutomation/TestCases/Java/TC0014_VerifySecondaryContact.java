package com.NexusPortalAutomation.TestCases.Java;

import java.io.IOException;

import org.testng.annotations.Test;

import com.NexusPortalAutomation.PageObjects.Java.DashBoard;
import com.NexusPortalAutomation.PageObjects.Java.DashBoardSearch;
import com.NexusPortalAutomation.Utilities.Java.CommonMethods;

public class TC0014_VerifySecondaryContact extends BaseClass {

	/*
	 * This test the search by Recent Customer Name
	 * 
	 * @author Talha Rahim
	 * 
	 * @version 1.0
	 * 
	 * @Since 2019-04-11
	 */

	public String locationID = getCellvalue("TC0014", "locationEdit");//"LOC@0004";
	public String SecondCust = getCellvalue("TC0014", "secondaryCust");//"Secondary Customer (SECONDARY)";
	public String SecondCustCnt = getCellvalue("TC0014", "secondaryCustNum");//"Secondary TC0014 (1)";
	

//This Test will test the search by Customer ID
	@Test(priority = 1)
	public void TestSecondayContact() throws IOException, InterruptedException {
		DashBoardSearch dbSrch = new DashBoardSearch(driver);
		DashBoard dashBoard = new DashBoard(driver);
		
		login();
		dbSrch.enterSearchText(locationID);
		dbSrch.clickCustomerName();
		// Verify Customer Location Id Updated for Test
		CommonMethods.verifyString(locationID, dashBoard.getLoggedCustomerLocationId());
		// Verify Contact is updated accordingly
		dashBoard.clickSecondaryCustomer();
		CommonMethods.verifyString(dashBoard.getSecondCustName(), SecondCust);
		CommonMethods.verifyString(dashBoard.getSecondCustomerCount(), SecondCustCnt);
		// Verify Updated details
		dashBoard.logout();
	}

}
