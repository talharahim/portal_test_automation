package com.NexusPortalAutomation.TestCases.Java;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.NexusPortalAutomation.PageObjects.Java.DashBoardSearch;
import com.NexusPortalAutomation.PageObjects.Java.Dashboard_Transfers;
import com.NexusPortalAutomation.Utilities.Java.CommonMethods;
import com.NexusPortalAutomation.Utilities.Java.MySQLDataExec;
import com.microsoft.sqlserver.jdbc.SQLServerException;

public class TC0027_VerifyAction_Transfers_StopService_NotScheduled extends BaseClass {

	/*
	 * This test the search by Recent Customer Name
	 * 
	 * @author Talha Rahim
	 * 
	 * @version 1.0
	 * 
	 * @Since 2019-06-10
	 */

	public String locationID = "LOC@0004";
	public String locationID2 = "LOC@0005";
	public String serverUrl = getDrillbackServerUrl();
	public String defaultCustomer = "Mr. VACANT VACANT";
	public String requestedbY = "Mr. Automation Mate";
	public String moveOutCustomer = "Mr. Automation Mate";
	public String loc2moveOutCustomer = "Mr. Movein Cus";
	public String moveInCustomer = "Mr. Vacant Vacant (Vacant)";
	public String loc2moveInCustomer = "Mr. Automation Mate (0000011111)";
	public String task1 = "Meter Reading-electric";
	public String task2 = "Charge New Customer";
	public String task3 = "Property Transfer";
	public String task4 = "Deposit Request-new Customer";
	public String task5 = "Deposit Payment-new Customer E";
	public String task6 = "Prepayment Required-new Custom";
	CommonMethods cmnMethods = new CommonMethods();

//This Test will test the search by Customer ID
	@Test(priority = 1)
	public void VerifyTransferActionServiceOrder()
			throws IOException, InterruptedException, ClassNotFoundException, SQLServerException, SQLException, ParseException {
		DashBoardSearch dbSrch = new DashBoardSearch(driver);
		Dashboard_Transfers dashBoard = new Dashboard_Transfers(driver);
		MySQLDataExec sql = new MySQLDataExec();
		sql.deleteServiceorder(locationID);
		sql.deleteServiceorderHistory(locationID);
		login();
		dbSrch.enterSearchText(locationID);
		dbSrch.clickCustomerName();
		// Verify Customer Location Id Updated for Test
		cmnMethods.verifyString(locationID, dashBoard.getLoggedCustomerLocationId());
		// Verify Contact is updated accordingly
		// cmnMethods.VerifyString(servTabURL, dashBoard.GetServiceTabDrillBackUrl());
		dashBoard.clickActionDropDown();
		dashBoard.clickActionDropDown_TransferService();
		//DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		//Date date = new Date();
		//String DateRequested = dateFormat.format(date);
		dashBoard.selectTransferStop();
		dashBoard.enterRequest("TRANSFER");
		String moveOutrequestedDate = dashBoard.startService_getRequestedDate();
		// Entering data for Move Out
		//Scroll down
		JavascriptExecutor jsx = (JavascriptExecutor)driver;
		jsx.executeScript("window.scrollBy(0,450)", "");
		//
		dashBoard.verifydefaultCustomerStartService(defaultCustomer);
		dashBoard.enterdefaultCustomerStartService(defaultCustomer);
		dashBoard.enterDescription("AUTOMATION TEST");
		// Entering data for Move In
		dashBoard.clickMoveInSubmit();
		Thread.sleep(1000);
		dashBoard.clickDone();
		// Verify Updated details IN SERVICE TAB order number from database
		dashBoard.clickServiceorderLink();
		String serviceOrder = dashBoard.getserviceOrderNum();
		String serviceOrderurl = dashBoard.getServiceOrderDrillbackURL();
		cmnMethods.verifyStringContains(serviceOrderurl, serviceOrder);
		
		String[] arrOfStr = moveOutrequestedDate.split(" ", 2);
		String moveOutstart_dt = arrOfStr[0];
		DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		Date date = (Date) formatter.parse(moveOutstart_dt);
		SimpleDateFormat newFormat = new SimpleDateFormat("MMM d, yyyy");
		String moveOutstart_dtfinalString = newFormat.format(date);
		cmnMethods.verifyString(dashBoard.getSOrequestedDate(), moveOutstart_dtfinalString);
		log(serviceOrder);
		cmnMethods.verifyString(dashBoard.getMoveOutSOcustomerName(), moveOutCustomer);
		cmnMethods.verifyString(dashBoard.getMoveInSOcustomerName(), moveInCustomer);
		cmnMethods.verifyString(dashBoard.getSOTask1Description() ,task1);
		cmnMethods.verifyString(dashBoard.getSOTask2Description() ,task2);
		cmnMethods.verifyString(dashBoard.getSOTask3Description() ,task3);
		cmnMethods.verifyString(dashBoard.getSOTask4Description() ,task4);
		cmnMethods.verifyString(dashBoard.getSOTask5Description() ,task5);
		cmnMethods.verifyString(dashBoard.getSOTask6Description() ,task6);
		sql.verifyServiceOrders(locationID, serviceOrder);
		dashBoard.logout();
	}

}
