package com.NexusPortalAutomation.TestCases.Java;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.Test;

import com.NexusPortalAutomation.PageObjects.Java.DashBoard;
import com.NexusPortalAutomation.PageObjects.Java.DashBoardSearch;
import com.NexusPortalAutomation.Utilities.Java.CommonMethods;

public class TC0015_VerifyContactLogs extends BaseClass {

	/*
	 * This test the search by Recent Customer Name
	 * 
	 * @author Talha Rahim
	 * 
	 * @version 1.0
	 * 
	 * @Since 2019-04-11
	 */

	public String locationID = getCellvalue("TC0015", "locationEdit");//"LOC@0004";
	
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date date = new Date();
	//String comments = "Notes added" + dateFormat.format(date);

//This Test will test the search by Customer ID
	@Test(priority = 1)
	public void TestContactLogs() throws IOException, InterruptedException {
		DashBoardSearch dbSrch = new DashBoardSearch(driver);
		DashBoard dashBoard = new DashBoard(driver);
		login();
		dbSrch.enterSearchText(locationID);
		dbSrch.clickCustomerName();
		// Verify Customer Location Id Updated for Test
		CommonMethods.verifyString(locationID, dashBoard.getLoggedCustomerLocationId());
		// Verify Contact is updated accordingly
		///dashBoard.AddNotes(Comments);  -- Functionality Removed
		// Verify Updated details
		//CommonMethods.VerifyString(dashBoard.GetNotes(), Comments);  -- Functionality Removed
		dashBoard.verifyNotesDrillbacks();
		dashBoard.logout();
	}

}
