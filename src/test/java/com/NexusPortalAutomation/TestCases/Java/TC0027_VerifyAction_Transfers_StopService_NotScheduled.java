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
	public String ServerURL = GetDrillBackServerURL();
	public String DefaultCustomer = "Mr. VACANT VACANT";
	public String requestedbY = "Mr. Automation Mate";
	public String moveOutCustomer = "Mr. Automation Mate";
	public String loc2moveOutCustomer = "Mr. Movein Cus";
	public String moveInCustomer = "Mr. Vacant Vacant (Vacant)";
	public String loc2moveInCustomer = "Mr. Automation Mate (0000011111)";
	public String Task1 = "Meter Reading-electric";
	public String Task2 = "Charge New Customer";
	public String Task3 = "Property Transfer";
	public String Task4 = "Deposit Request-new Customer";
	public String Task5 = "Deposit Payment-new Customer E";
	public String Task6 = "Prepayment Required-new Custom";
	CommonMethods cmnMethods = new CommonMethods();

//This Test will test the search by Customer ID
	@Test(priority = 1)
	public void VerifyTransferActionServiceOrder()
			throws IOException, InterruptedException, ClassNotFoundException, SQLServerException, SQLException, ParseException {
		DashBoardSearch dbSrch = new DashBoardSearch(driver);
		Dashboard_Transfers dashBoard = new Dashboard_Transfers(driver);
		MySQLDataExec Sql = new MySQLDataExec();
		Sql.DeleteServiceOrders(locationID);
		Sql.DeleteServiceOrdersHistory(locationID);
		login();
		dbSrch.enterSearchText(locationID);
		dbSrch.clickCustomerName();
		// Verify Customer Location Id Updated for Test
		cmnMethods.verifyString(locationID, dashBoard.getLoggedCustomerName());
		// Verify Contact is updated accordingly
		// cmnMethods.VerifyString(servTabURL, dashBoard.GetServiceTabDrillBackUrl());
		dashBoard.clickActionDropDown();
		dashBoard.clickActionDropDown_TransferService();
		//DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		//Date date = new Date();
		//String DateRequested = dateFormat.format(date);
		dashBoard.SelectTransferType_Transfer_Stop();
		dashBoard.enterRequest("TRANSFER");
		String moveOutrequestedDate = dashBoard.startService_getRequestedDate();
		// Entering data for Move Out
		//Scroll down
		JavascriptExecutor jsx = (JavascriptExecutor)driver;
		jsx.executeScript("window.scrollBy(0,450)", "");
		//
		dashBoard.verifyDefaultCustomerStartService(DefaultCustomer);
		dashBoard.enterDefaultCustomerStartService(DefaultCustomer);
		dashBoard.enterDescription("AUTOMATION TEST");
		// Entering data for Move In
		dashBoard.Click_MoveInSubmit();
		Thread.sleep(1000);
		dashBoard.ClickDone();
		// Verify Updated details IN SERVICE TAB order number from database
		dashBoard.ClickServiceOrderLink();
		String ServiceOrder = dashBoard.getServiceOrderNumber();
		String ServiceOrderURL = dashBoard.getServiceOrderDrillbackURL();
		cmnMethods.VerifyStringContains(ServiceOrderURL, ServiceOrder);
		
		String[] arrOfStr = moveOutrequestedDate.split(" ", 2);
		String moveOutstart_dt = arrOfStr[0];
		DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		Date date = (Date) formatter.parse(moveOutstart_dt);
		SimpleDateFormat newFormat = new SimpleDateFormat("MMM d, yyyy");
		String moveOutstart_dtfinalString = newFormat.format(date);
		cmnMethods.verifyString(dashBoard.getSOrequestedDate(), moveOutstart_dtfinalString);
		log(ServiceOrder);
		cmnMethods.verifyString(dashBoard.getMoveOutSOcustomerName(), moveOutCustomer);
		cmnMethods.verifyString(dashBoard.getMoveInSOcustomerName(), moveInCustomer);
		cmnMethods.verifyString(dashBoard.getSOTask1Description() ,Task1);
		cmnMethods.verifyString(dashBoard.getSOTask2Description() ,Task2);
		cmnMethods.verifyString(dashBoard.getSOTask3Description() ,Task3);
		cmnMethods.verifyString(dashBoard.getSOTask4Description() ,Task4);
		cmnMethods.verifyString(dashBoard.getSOTask5Description() ,Task5);
		cmnMethods.verifyString(dashBoard.getSOTask6Description() ,Task6);
		Sql.VerifyServiceOrders(locationID, ServiceOrder);
		dashBoard.logout();
	}

}
