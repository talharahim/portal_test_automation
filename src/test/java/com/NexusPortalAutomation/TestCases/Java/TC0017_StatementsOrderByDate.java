package com.NexusPortalAutomation.TestCases.Java;

import java.io.IOException;
import java.sql.SQLException;

import org.testng.annotations.Test;

import com.NexusPortalAutomation.PageObjects.Java.DashBoard;
import com.NexusPortalAutomation.PageObjects.Java.DashBoardSearch;
import com.NexusPortalAutomation.Utilities.Java.CommonMethods;
import com.NexusPortalAutomation.Utilities.Java.MySQLDataExec;

public class TC0017_StatementsOrderByDate extends BaseClass {

    /*
     * This test the search by Recent Customer Name
     * 
     * @author Talha Rahim
     * 
     * @version 1.0
     * 
     * @Since 2019-06-11
     */

    public String locationID = getCellvalue("TC0017_1", "stLocationID");// ""STATEMENTS001";
    public String satementDateValue = getCellvalue("TC0017_1", "stDateValue");// ""Jul 31, 2019";
    public String satementDateValue2 = getCellvalue("TC0017_1", "stDateValue2");// ""Jul 31, 2019";
    public String satementDateValue3 = getCellvalue("TC0017_1", "stDateValue3");// ""Jul 31, 2019";
    public String satementDateValue4 = getCellvalue("TC0017_1", "stDateValue4");// ""Jul 31, 2019";

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
	CommonMethods.verifyString(satementDateValue, dashBoard.getBillStatementDate());
	CommonMethods.verifyString(satementDateValue2, dashBoard.getBillStatementDate2());
	CommonMethods.verifyString(satementDateValue3, dashBoard.getBillStatementDate3());
	CommonMethods.verifyString(satementDateValue4, dashBoard.getBillStatementDate4());

	dashBoard.logout();
    }

}
