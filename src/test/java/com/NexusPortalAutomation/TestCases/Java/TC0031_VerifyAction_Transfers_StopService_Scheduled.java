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

public class TC0031_VerifyAction_Transfers_StopService_Scheduled extends BaseClass {

	/*
	 * This test the search by Recent Customer Name
	 * 
	 * @author Talha Rahim
	 * 
	 * @version 1.0
	 * 
	 * @Since 2019-06-10
	 */

	public String LocationID = "LOC@0004";
	public String LocationID2 = "LOC@0005";
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
	public String[] Task = {"Meter Reading-electric", "Charge New Customer","Property Transfer", "Deposit Request-new Customer", "Deposit Payment-new Customer E","Prepayment Required-new Custom"};
	CommonMethods ComMethd = new CommonMethods();

//This Test will test the search by Customer ID
	@Test(priority = 1)
	public void VerifyTransferActionServiceOrder()
			throws IOException, InterruptedException, ClassNotFoundException, SQLServerException, SQLException, ParseException {
		DashBoardSearch dbSrch = new DashBoardSearch(driver);
		Dashboard_Transfers dashBoard = new Dashboard_Transfers(driver);
		MySQLDataExec Sql = new MySQLDataExec();
		Sql.DeleteServiceOrders(LocationID);
		Sql.DeleteServiceOrdersHistory(LocationID);
		login();
		dbSrch.EnterSearchText(LocationID);
		dbSrch.ClickCustomer();
		// Verify Customer Location Id Updated for Test
		ComMethd.VerifyString(LocationID, dashBoard.GetLoggedCustomerLocationId());
		// Verify Contact is updated accordingly
		// ComMethd.VerifyString(servTabURL, dashBoard.GetServiceTabDrillBackUrl());
		dashBoard.clickActionDropDown();
		dashBoard.clickActionDropDown_TransferService();
		//DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		//Date date = new Date();
		//String DateRequested = dateFormat.format(date);
		dashBoard.SelectTransferType_Transfer_Stop();
		dashBoard.enterRequest("TRANSFER");
		dashBoard.enterScheduleDate_StartService(dashBoard.startService_getRequestedDate());
		String moveOutrequestedDate = dashBoard.startService_getRequestedDate();
	
		// Entering data for Move Out
		//Scroll down
		dashBoard.submitStartStopServiceTransferOrder(moveOutrequestedDate, moveOutrequestedDate, "TRANSFER", DefaultCustomer, DefaultCustomer,"Description for Stop Service");
		// Verify Updated details IN SERVICE TAB order number from database
		dashBoard.ClickServiceOrderLink();
		String ServiceOrder = dashBoard.getServiceOrderNumber();
		String[] arrOfStr = moveOutrequestedDate.split(" ", 2);
		String moveOutstart_dt = arrOfStr[0];
		DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		Date date = (Date) formatter.parse(moveOutstart_dt);
		SimpleDateFormat newFormat = new SimpleDateFormat("MMM d, yyyy");
		String moveOutstart_dtfinalString = newFormat.format(date);
		dashBoard.verifyServiceOrderdetails(moveOutCustomer,moveOutCustomer,moveInCustomer,moveOutstart_dtfinalString,moveOutstart_dtfinalString,Task,LocationID);
		log(ServiceOrder);
		dashBoard.LogOut();
	}

}
