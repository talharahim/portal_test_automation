package com.NexusPortalAutomation.TestCases.Java;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.NexusPortalAutomation.PageObjects.Java.DashBoard;
import com.NexusPortalAutomation.PageObjects.Java.DashBoardSearch;
import com.NexusPortalAutomation.PageObjects.Java.Dashboard_Transfers;
import com.NexusPortalAutomation.PageObjects.Java.GlobalOptions;
import com.NexusPortalAutomation.Utilities.Java.CommonMethods;
import com.NexusPortalAutomation.Utilities.Java.MySQLDataExec;
import com.microsoft.sqlserver.jdbc.SQLServerException;

public class TC0053_VerifyGlobalOptions_pagetitle extends BaseClass {

    /*
     * This test the search by Recent Customer Name
     * 
     * @author Talha Rahim
     * 
     * @version 1.0
     * 
     * @Since 2019-06-10
     */

    public String locationID = getCellvalue("TC0050", "locationID");// "LOC@0004";
    public String defaultCustomer = getCellvalue("TC0050", "defaultCustomer");// "Mr. VACANT VACANT";
    public String moveInCustomer = getCellvalue("TC0050", "moveInCustomer");// "Mr. Vacant Vacant";
    public String extitle = "Global Options";
    public String contLog = "Contact Log";
    public String transTab = "Transfer Request";
    public String serverUrl = getDrillbackServerUrl();

//This Test will test the search by Customer ID
    @Test(priority = 1)
    public void VerifyTransferActionServiceOrder() throws IOException, InterruptedException, ClassNotFoundException,
	    SQLServerException, SQLException, ParseException {
	DashBoard dboard = new DashBoard(driver);
	GlobalOptions gopt = new GlobalOptions(driver);
	DashBoardSearch dbSrch = new DashBoardSearch(driver);
	Dashboard_Transfers dashBoard = new Dashboard_Transfers(driver);
	MySQLDataExec sql = new MySQLDataExec();
	sql.deleteServiceorder(locationID);
	sql.deleteServiceorderHistory(locationID);
	login();
	dbSrch.enterSearchText(locationID);
	dbSrch.clickCustomerName();
	// Verify Customer Location Id Updated for Test
	CommonMethods.verifyString(locationID, dashBoard.getLoggedCustomerLocationId());
	dboard.clickglobaloptions();

	CommonMethods.verifyString(GlobalOptions.getPageHeader(), extitle);
	CommonMethods.verifyString(GlobalOptions.contactLogtab(), contLog);
	CommonMethods.verifyString(GlobalOptions.transferRequest(), transTab);
	GlobalOptions.backtoaccounts();

	dashBoard.logout();

	// BUG
	// add new user details verfication
    }

}
