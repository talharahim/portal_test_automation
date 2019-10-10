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
	 * @Since 2019-06-11
	 */

	public String locationID = getCellvalue("TC0017", "stLocationID");//""STATEMENTS001";
	public String satementDateValue = getCellvalue("TC0017", "stDateValue");//""Jul 31, 2019";
	public String statementValue = getCellvalue("TC0017", "stValue");//""$56.71";
	

	

//This Test will test the 
	@Test(priority = 1)
	public void TestBillingStatements() throws IOException, InterruptedException, ClassNotFoundException, SQLException {
		DashBoardSearch dbSrch = new DashBoardSearch(driver);
		DashBoard dashBoard = new DashBoard(driver);
		MySQLDataExec sql = new MySQLDataExec();
		login();
		dbSrch.enterSearchText(locationID);
		dbSrch.clickCustomerName();
		// Verify Customer Location Id Updated for Test
		CommonMethods.verifyString(locationID, dashBoard.getLoggedCustomerLocationId());
		// Verify Contact is updated accordingly
		dashBoard.ClickBillStatementBtn();
		CommonMethods.verifyString(satementDateValue,dashBoard.getBillStatementDate());
		CommonMethods.verifyString(statementValue,dashBoard.getBillStatementAmount());
		sql.VerifyStatementsData(locationID,statementValue.substring(1));
		dashBoard.logout();
	}

}
