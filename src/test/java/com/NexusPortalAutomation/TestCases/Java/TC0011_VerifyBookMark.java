package com.NexusPortalAutomation.TestCases.Java;

import java.io.IOException;

import org.testng.annotations.Test;

import com.NexusPortalAutomation.PageObjects.Java.DashBoard;
import com.NexusPortalAutomation.PageObjects.Java.DashBoardSearch;
import com.NexusPortalAutomation.Utilities.Java.CommonMethods;

public class TC0011_VerifyBookMark extends BaseClass {

	public String LocationID = "LOC@0001";
	CommonMethods ComMethd = new CommonMethods();

//This Test will test the search by Customer ID
	@Test(priority = 1)
	public void TestBookMark() throws IOException, InterruptedException {
		DashBoardSearch dbSrch = new DashBoardSearch(driver);
		DashBoard dashBoard = new DashBoard(driver);
		login();
		dbSrch.EnterSearchText(LocationID);
		dbSrch.ClickCustomer();
		// Verify Customer Location Id Updated for Test
		boolean Match = ComMethd.VerifyString(LocationID, dashBoard.GetLoggedCustomerLocationId());
		if (!Match) {
			log("Location ID Not Matched");
		} else {
			log("LocationID ID Matched =" + LocationID);
		}
		// Click BookMark
		dashBoard.ClickBookMarkDisabled();
		dashBoard.ClickBookMarkEnabled();
		//Verify if it is Marked
		//Click BookMark
		//Verify if it is UnMarked
		
		dashBoard.LogOut();

	}

}
