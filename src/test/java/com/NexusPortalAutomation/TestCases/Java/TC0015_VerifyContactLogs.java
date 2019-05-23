package com.NexusPortalAutomation.TestCases.Java;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.Test;

import com.NexusPortalAutomation.PageObjects.Java.DashBoard;
import com.NexusPortalAutomation.PageObjects.Java.DashBoardSearch;
import com.NexusPortalAutomation.Utilities.Java.CommonMethods;

/**
 * 
 * This Class will be used for to Test Contact Logs
 * 
 * @author Talha Rahim
 * @since 2019-05-24
 */

public class TC0015_VerifyContactLogs extends BaseClass {

	public String LocationID = "LOC@0004";
	CommonMethods ComMethd = new CommonMethods();
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date date = new Date();
	String Comments = "Notes added" + dateFormat.format(date);

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
		dashBoard.AddNotes(Comments);
		// Verify Updated details
		ComMethd.VerifyString(dashBoard.GetNotes(), Comments);
		dashBoard.LogOut();
	}

}
