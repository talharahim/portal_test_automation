package com.NexusPortalAutomation.TestCases.Java;

import java.io.IOException;
import java.sql.SQLException;

import org.testng.annotations.Test;

import com.NexusPortalAutomation.PageObjects.Java.DashBoard;
import com.NexusPortalAutomation.PageObjects.Java.DashBoardSearch;
import com.NexusPortalAutomation.Utilities.Java.CommonMethods;
import com.NexusPortalAutomation.Utilities.Java.MySQLDataExec;

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
	public String StatementDateValue = "Jul 31, 2019";
	public String StatementValue = "$56.71";
	

	CommonMethods ComMethd = new CommonMethods();

//This Test will test the 
	@Test(priority = 1)
	public void TestBillingStatements() throws IOException, InterruptedException, ClassNotFoundException, SQLException {
		DashBoardSearch dbSrch = new DashBoardSearch(driver);
		DashBoard dashBoard = new DashBoard(driver);
		MySQLDataExec Sql = new MySQLDataExec();
		login();
		dbSrch.EnterSearchText(LocationID);
		dbSrch.ClickCustomer();
		// Verify Customer Location Id Updated for Test
		ComMethd.VerifyString(LocationID, dashBoard.GetLoggedCustomerLocationId());
		// Verify Contact is updated accordingly
		dashBoard.ClickBillStatementBtn();
		ComMethd.VerifyString(StatementDateValue,dashBoard.getBillStatementDate());
		ComMethd.VerifyString(StatementValue,dashBoard.getBillStatementAmount());
		Sql.VerifyStatementsData(LocationID,StatementValue.substring(1));
		dashBoard.LogOut();
	}

}
