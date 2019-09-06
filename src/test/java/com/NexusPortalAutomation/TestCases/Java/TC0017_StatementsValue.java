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

	public String locationID = "STATEMENTS001";
	public String StatementDateValue = "Jul 31, 2019";
	public String StatementValue = "$56.71";
	

	CommonMethods cmnMethods = new CommonMethods();

//This Test will test the 
	@Test(priority = 1)
	public void TestBillingStatements() throws IOException, InterruptedException, ClassNotFoundException, SQLException {
		DashBoardSearch dbSrch = new DashBoardSearch(driver);
		DashBoard dashBoard = new DashBoard(driver);
		MySQLDataExec Sql = new MySQLDataExec();
		login();
		dbSrch.enterSearchText(locationID);
		dbSrch.clickCustomerName();
		// Verify Customer Location Id Updated for Test
		cmnMethods.verifyString(locationID, dashBoard.getLoggedCustomerName());
		// Verify Contact is updated accordingly
		dashBoard.ClickBillStatementBtn();
		cmnMethods.verifyString(StatementDateValue,dashBoard.getBillStatementDate());
		cmnMethods.verifyString(StatementValue,dashBoard.getBillStatementAmount());
		Sql.VerifyStatementsData(locationID,StatementValue.substring(1));
		dashBoard.logout();
	}

}
