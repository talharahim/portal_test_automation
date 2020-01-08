package com.NexusPortalAutomation.TestCases.Java;

import java.io.IOException;

import org.testng.annotations.Test;

import com.NexusPortalAutomation.PageObjects.Java.DashBoard;
import com.NexusPortalAutomation.PageObjects.Java.DashBoardSearch;
import com.NexusPortalAutomation.Utilities.Java.CommonMethods;

public class TC0016_1_VerifyBillingDetails_SPA extends BaseClass {

    /*
     * This test the search by Recent Customer Name
     * 
     * @author Talha Rahim
     * 
     * @version 1.0
     * 
     * @Since 2019-06-11
     */

    public String locationID = getCellvalue("TC0016", "loc1");// "LOC@0001";

    String spaURL = getCellvalue("TC0016", "spaURL");// "CustomerID=0000011111&LocationID=LOC@0001&CogsDrillback=1";
    String paymentArrangementAmount = getCellvalue("TC0016", "spaAmount");

//This Test will test the search by Customer ID
    @Test(priority = 1)
    public void VerifyBillingDetails_SPA() throws IOException, InterruptedException {
	DashBoardSearch dbSrch = new DashBoardSearch(driver);
	DashBoard dashBoard = new DashBoard(driver);
	login();
	dbSrch.enterSearchText(locationID);
	dbSrch.clickCustomerName();
	// Verify Customer Location Id Updated for Test
	CommonMethods.verifyString(locationID, dashBoard.getLoggedCustomerLocationId());
	// Verify Contact is updated accordingly
	// Verify SPA Information
	CommonMethods.verifyString(dashBoard.getPaymentArrangementDue(), "Payment Arrangement Due");
	CommonMethods.verifyString(dashBoard.getPaymentArrangementDueAmount(), paymentArrangementAmount);
	CommonMethods.verifyStringContains(dashBoard.getPaymentArrangementDueURL(), spaURL);
	dashBoard.logout();
    }

}
