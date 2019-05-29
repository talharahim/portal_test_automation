package com.NexusPortalAutomation.TestCases.Java;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.NexusPortalAutomation.PageObjects.Java.DashBoard;
import com.NexusPortalAutomation.PageObjects.Java.DashBoardSearch;
import com.NexusPortalAutomation.Utilities.Java.CommonMethods;

public class TC0017_StatementsValue extends BaseClass {

	/*
	 * This test the search by Recent Customer Name
	 * 
	 * @author Talha Rahim
	 * 
	 * @version 1.0
	 * 
	 * @Since 2019-04-11
	 */

	public String LocationID = "STATEMENTS001";
	public String StatmentDateValue = "Jul 31, 2019";
	public String StatmentValue = "$56.71";

	CommonMethods ComMethd = new CommonMethods();

//This Test will test the 
	@Test(priority = 1)
	public void TestBillingStatements() throws IOException, InterruptedException {
		DashBoardSearch dbSrch = new DashBoardSearch(driver);
		DashBoard dashBoard = new DashBoard(driver);
		login();
		dbSrch.EnterSearchText(LocationID);
		dbSrch.ClickCustomer();
		// Verify Customer Location Id Updated for Test
		ComMethd.VerifyString(LocationID, dashBoard.GetLoggedCustomerLocationId());
		// Verify Contact is updated accordingly
		// "Verify Billing Information
		System.out.print(driver.getCurrentUrl());
		dashBoard.ClickBillStatementBtn();
		//
		ComMethd.VerifyString(dashBoard.getBillStatementDate(), StatmentDateValue);
		//
		ComMethd.VerifyString(dashBoard.getBillStatementAmount(), StatmentValue);
		//To set the focus back
		dashBoard.OverLay.click();
		dashBoard.LogOut();
	}

}