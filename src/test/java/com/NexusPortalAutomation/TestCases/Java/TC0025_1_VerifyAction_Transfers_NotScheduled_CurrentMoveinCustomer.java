package com.NexusPortalAutomation.TestCases.Java;

import java.io.IOException;
import java.util.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import com.NexusPortalAutomation.PageObjects.Java.DashBoardSearch;
import com.NexusPortalAutomation.PageObjects.Java.Dashboard_Transfers;
import com.NexusPortalAutomation.Utilities.Java.CommonMethods;
import com.NexusPortalAutomation.Utilities.Java.MySQLDataExec;
import com.microsoft.sqlserver.jdbc.SQLServerException;

public class TC0025_1_VerifyAction_Transfers_NotScheduled_CurrentMoveinCustomer extends BaseClass {

	/*
	 * This test the search by Recent Customer Name
	 * 
	 * @author Talha Rahim
	 * 
	 * @version 1.0
	 * 
	 * @Since 2019-06-10
	 */

	public String locationID = getCellvalue("TC0025", "locationID");//"LOC@0004";
	public String locationID2 = getCellvalue("TC0025", "locationID2");//"LOC@0005";
	public String defaultCustomer = getCellvalue("TC0025", "defaultCustomer");//"Mr. VACANT VACANT";
	public String requestedbY = getCellvalue("TC0025", "requestedbY");//"Mr. Automation Mate";
	public String moveOutCustomer = getCellvalue("TC0025", "moveOutCustomer");//"Mr. Automation Mate";
	public String loc2moveOutCustomer = getCellvalue("TC0025", "loc2moveOutCustomer");//"Mr. Movein Cus";
	public String moveInCustomer = getCellvalue("TC0025", "moveInCustomer");//"Mr. Vacant Vacant (Vacant)";
	public String loc2moveInCustomer = getCellvalue("TC0025", "loc2moveInCustomer");//"Mr. Automation Mate (0000011111)";
	public String serverUrl = getDrillbackServerUrl();
	public String task1 = getCellvalue("TC0025", "task1");//"Meter Reading-electric";
	public String task2 = getCellvalue("TC0025", "task2");//"Charge New Customer";
	public String task3 = getCellvalue("TC0025", "task3");//"Property Transfer";
	public String task4 = getCellvalue("TC0025", "task4");//"Deposit Request-new Customer";
	public String task5 = getCellvalue("TC0025", "task5");//"Deposit Payment-new Customer E";
	public String task6 = getCellvalue("TC0025", "task6");//"Prepayment Required-new Custom";
	public String message = getCellvalue("TC0025", "message");//"Transfer initiated";
	CommonMethods cmnMethods = new CommonMethods();

//This Test will test the search by Customer ID
	@Test(priority = 1)
	public void VerifyActionServiceOrder_Transfers_NotSchedule() throws IOException, InterruptedException, ClassNotFoundException,
			SQLServerException, SQLException, ParseException {
		DashBoardSearch dbSrch = new DashBoardSearch(driver);
		Dashboard_Transfers dashBoard = new Dashboard_Transfers(driver);
		MySQLDataExec sql = new MySQLDataExec();
		sql.deleteServiceorder(locationID);
		sql.deleteServiceorder(locationID2);
		sql.deleteServiceorderHistory(locationID);
		sql.deleteServiceorderHistory(locationID2);
		login();
		dbSrch.enterSearchText(locationID);
		dbSrch.clickCustomerName();
		// Verify Customer Location Id Updated for Test
		cmnMethods.verifyString(locationID, dashBoard.getLoggedCustomerLocationId());
		// Verify Contact is updated accordingly
		dashBoard.clickActionDropDown();

		dashBoard.clickActionDropDown_TransferService();
		dashBoard.selectTransferTypeTransfer();
		dashBoard.enterRequest("Transfer");
		// Move Out
		String moveOutrequestedDate = dashBoard.Movin_getMoveOutRequestedDate();
		dashBoard.verifydefaultCustomer(defaultCustomer);
		dashBoard.enterdefaultCustomer(requestedbY);
		dashBoard.enterDescription("AUTOMATION TEST");

		// Move In
		dashBoard.ClickMoveTo();
		String moveInrequestedDate = dashBoard.Movin_getMoveFromRequestedDate();
		dashBoard.Movin_EnterRequestDate(moveInrequestedDate);
		dashBoard.movinEnterRequest("TRANSFER");
		dashBoard.movinEnterLocation(locationID2);
		dashBoard.movinEnterDescription("Move in from location");
		JavascriptExecutor jsx = (JavascriptExecutor) driver;
		jsx = (JavascriptExecutor) driver;
		jsx.executeScript("window.scrollBy(0,450)", "");
		dashBoard.setElementText(dashBoard.findElementByid("XFER_Search_Input"), requestedbY, "Customer Name Request");
		// Entering data for Move In
		dashBoard.clickMoveInSubmit();
		Thread.sleep(500);
		dashBoard.verifySamemoveinCustomer();
		//dashBoard.clickMoveInSubmit();
		Thread.sleep(1000);
		//dashBoard.verifySubmitMessage(message);
		dashBoard.clickDone();
		// Verify Updated details IN SERVICE TAB order number from database
		dashBoard.clickServiceorderLink();
		// Verifying Service Order details
		String ServiceOrder = dashBoard.getserviceOrderNum();
		String ServiceOrderURL = dashBoard.getServiceOrderDrillbackURL();
		cmnMethods.verifyStringContains(ServiceOrderURL, ServiceOrder);
		//
		cmnMethods.verifyString(dashBoard.getRequestedSOcustomerName(), requestedbY);
		// Get request Date and Compare
		String[] arrOfStr = moveInrequestedDate.split(" ", 2);
		String[] arrOfStr2 = moveOutrequestedDate.split(" ", 2);
		String moveOutstart_dt = arrOfStr[0];
		DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		Date date = (Date) formatter.parse(moveOutstart_dt);
		SimpleDateFormat newFormat = new SimpleDateFormat("MMM d, yyyy");
		String moveOutstart_dtfinalString = newFormat.format(date);
		cmnMethods.verifyString(dashBoard.getSOrequestedDate(), moveOutstart_dtfinalString);
		//
		cmnMethods.verifyString(dashBoard.getMoveOutSOcustomerName(), moveOutCustomer);
		cmnMethods.verifyString(dashBoard.getMoveInSOcustomerName(), moveInCustomer);
		cmnMethods.verifyString(dashBoard.getSOTask1Description(), task1);
		cmnMethods.verifyString(dashBoard.getSOTask2Description(), task2);
		cmnMethods.verifyString(dashBoard.getSOTask3Description(), task3);
		cmnMethods.verifyString(dashBoard.getSOTask4Description(), task4);
		cmnMethods.verifyString(dashBoard.getSOTask5Description(), task5);
		cmnMethods.verifyString(dashBoard.getSOTask6Description(), task6);

		log(ServiceOrder);
		sql.verifyServiceOrders(locationID, ServiceOrder);
		// Entering location ID 2 and verifying
		dashBoard.enterDashBoardSearch(locationID2);
		dashBoard.clickDashBoardSearchResult1();
		dashBoard.clickServiceorderLink();
		ServiceOrder = dashBoard.getserviceOrderNum();
		ServiceOrderURL = dashBoard.getServiceOrderDrillbackURL();
		cmnMethods.verifyStringContains(ServiceOrderURL, ServiceOrder);

		String moveInstart_dt = arrOfStr2[0];
		date = (Date) formatter.parse(moveInstart_dt);
		String moveInstart_dtfinalString = newFormat.format(date);
		cmnMethods.verifyString(dashBoard.getSOrequestedDate(), moveInstart_dtfinalString);
		//

		cmnMethods.verifyString(dashBoard.getMoveOutSOcustomerName(), loc2moveOutCustomer);
		cmnMethods.verifyString(dashBoard.getMoveInSOcustomerName(), loc2moveInCustomer);
		cmnMethods.verifyString(dashBoard.getSOTask1Description(), task1);
		cmnMethods.verifyString(dashBoard.getSOTask2Description(), task2);
		cmnMethods.verifyString(dashBoard.getSOTask3Description(), task3);
		cmnMethods.verifyString(dashBoard.getSOTask4Description(), task4);
		cmnMethods.verifyString(dashBoard.getSOTask5Description(), task5);
		cmnMethods.verifyString(dashBoard.getSOTask6Description(), task6);

		log(ServiceOrder);
		sql.verifyServiceOrders(locationID2, ServiceOrder);
		dashBoard.logout();
	}

}
