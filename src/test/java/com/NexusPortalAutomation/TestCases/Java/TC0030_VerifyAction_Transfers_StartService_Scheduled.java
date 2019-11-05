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

public class TC0030_VerifyAction_Transfers_StartService_Scheduled extends BaseClass {

	/*
	 * This test the search by Recent Customer Name
	 * 
	 * @author Talha Rahim
	 * 
	 * @version 1.0
	 * 
	 * @Since 2019-06-10
	 */

	public String locationID = getCellvalue("TC0030", "locationID");//"LOC@0004";
	public String locationID2 = getCellvalue("TC0030", "locationID2");//"LOC@0005";
	public String defaultCustomer = getCellvalue("TC0030", "defaultCustomer");//"Mr. VACANT VACANT";
	public String requestedbY = getCellvalue("TC0030", "requestedbY");//"Mr. Automation Mate";
	public String moveOutCustomer = getCellvalue("TC0030", "moveOutCustomer");//"Mr. Automation Mate";
	public String loc2moveOutCustomer = getCellvalue("TC0030", "loc2moveOutCustomer");//"Mr. Movein Cus";
	public String moveInCustomer = getCellvalue("TC0030", "moveInCustomer");//"Mr. Vacant Vacant (Vacant)";
	public String loc2moveInCustomer = getCellvalue("TC0030", "loc2moveInCustomer");//"Mr. Automation Mate (0000011111)";
	public String serverUrl = getDrillbackServerUrl();
	public String task1 = getCellvalue("TC0030", "task1");//"Meter Reading-electric";
	public String task2 = getCellvalue("TC0030", "task2");//"Charge New Customer";
	public String task3 = getCellvalue("TC0030", "task3");//"Property Transfer";
	public String task4 = getCellvalue("TC0030", "task4");//"Deposit Request-new Customer";
	public String task5 = getCellvalue("TC0030", "task5");//"Deposit Payment-new Customer E";
	public String task6 = getCellvalue("TC0030", "task6");//"Prepayment Required-new Custom";
	public String message = getCellvalue("TC0030", "message");//"Transfer initiated";
	public String[] Task = {"Meter Reading-electric", "Charge New Customer","Property Transfer", "Deposit Request-new Customer", "Deposit Payment-new Customer E","Prepayment Required-new Custom"};
	

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
		CommonMethods.verifyString(locationID, dashBoard.getLoggedCustomerLocationId());
		// Verify Contact is updated accordingly
		// CommonMethods.VerifyString(servTabURL, dashBoard.GetServiceTabDrillBackUrl());
		dashBoard.clickActionDropDown();
		dashBoard.clickActionDropDown_TransferService();
		//DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		//Date date = new Date();
		//String DateRequested = dateFormat.format(date);
		dashBoard.selectTransferStart();
		dashBoard.enterRequest("TRANSFER");
		dashBoard.enterScheduleDate_StartService(dashBoard.startService_getRequestedDate());
		String moveOutrequestedDate = dashBoard.startService_getRequestedDate();
	
		// Entering data for Move Out
		//Scroll down
		dashBoard.submitStartStopServiceTransferOrder(moveOutrequestedDate, "TRANSFER", defaultCustomer, defaultCustomer,"Description for Start Service");
		// Verify Updated details IN SERVICE TAB order number from database
		dashBoard.clickServiceorderLink();
		String ServiceOrder = dashBoard.getserviceOrderNum();
		String[] arrOfStr = moveOutrequestedDate.split(" ", 2);
		String moveOutstart_dt = arrOfStr[0];
		DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		Date date = (Date) formatter.parse(moveOutstart_dt);
		SimpleDateFormat newFormat = new SimpleDateFormat("MMM d, yyyy");
		String moveOutstart_dtfinalString = newFormat.format(date);
		dashBoard.verifyServiceOrderdetails(moveOutCustomer,moveOutCustomer,moveInCustomer,moveOutstart_dtfinalString,moveOutstart_dtfinalString,Task,locationID);
		log(ServiceOrder);
		dashBoard.logout();
	}

}



