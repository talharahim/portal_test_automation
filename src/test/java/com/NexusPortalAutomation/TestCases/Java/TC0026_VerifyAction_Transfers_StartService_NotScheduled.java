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

public class TC0026_VerifyAction_Transfers_StartService_NotScheduled extends BaseClass {

	/*
	 * This test the search by Recent Customer Name
	 * 
	 * @author Talha Rahim
	 * 
	 * @version 1.0
	 * 
	 * @Since 2019-06-10
	 */
	public String locationID = getCellvalue("TC0026", "locationID");//"LOC@0004";
	public String locationID2 = getCellvalue("TC0026", "locationID2");//"LOC@0005";
	public String defaultCustomer = getCellvalue("TC0026", "defaultCustomer");//"Mr. VACANT VACANT";
	public String requestedbY = getCellvalue("TC0026", "requestedbY");//"Mr. Automation Mate";
	public String moveOutCustomer = getCellvalue("TC0026", "moveOutCustomer");//"Mr. Automation Mate";
	public String loc2moveOutCustomer = getCellvalue("TC0026", "loc2moveOutCustomer");//"Mr. Movein Cus";
	public String moveInCustomer = getCellvalue("TC0026", "moveInCustomer");//"Mr. Vacant Vacant (Vacant)";
	public String loc2moveInCustomer = getCellvalue("TC0026", "loc2moveInCustomer");//"Mr. Automation Mate (0000011111)";
	public String serverUrl = getDrillbackServerUrl();
	public String task1 = getCellvalue("TC0026", "task1");//"Meter Reading-electric";
	public String task2 = getCellvalue("TC0026", "task2");//"Charge New Customer";
	public String task3 = getCellvalue("TC0026", "task3");//"Property Transfer";
	public String task4 = getCellvalue("TC0026", "task4");//"Deposit Request-new Customer";
	public String task5 = getCellvalue("TC0026", "task5");//"Deposit Payment-new Customer E";
	public String task6 = getCellvalue("TC0026", "task6");//"Prepayment Required-new Custom";
	public String message = getCellvalue("TC0026", "message");//"Transfer initiated";
	
	

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
		dashBoard.clickActionDropDown();
		dashBoard.clickActionDropDown_TransferService();
		dashBoard.selectTransferStart();
		dashBoard.enterRequest("TRANSFER");
		// Entering data for Move Out
		//Scroll down
		JavascriptExecutor jsx = (JavascriptExecutor)driver;
		jsx.executeScript("window.scrollBy(0,450)", "");
		//
		String moveInrequestedDate = dashBoard.startService_getRequestedDate();
		dashBoard.verifydefaultCustomerStartService(defaultCustomer);
		dashBoard.enterdefaultCustomerStartService(defaultCustomer);
		dashBoard.enterDescription("AUTOMATION TEST");
		dashBoard.clickMoveInSubmit();
		Thread.sleep(1000);
		dashBoard.clickDone();
		String[] arrOfStr = moveInrequestedDate.split(" ", 2);
		String moveOutstart_dt = arrOfStr[0];
		DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		Date date = (Date) formatter.parse(moveOutstart_dt);
		SimpleDateFormat newFormat = new SimpleDateFormat("MMM d, yyyy");
		String moveOutstart_dtfinalString = newFormat.format(date);
		// Verify Updated details IN SERVICE TAB order number from database
		
		dashBoard.clickServiceorderLink();
		CommonMethods.verifyString(dashBoard.getSOrequestedDate(), moveOutstart_dtfinalString);
		String serviceOrder = dashBoard.getserviceOrderNum();
		String serviceOrderUrl = dashBoard.getServiceOrderDrillbackURL();
		CommonMethods.verifyStringContains(serviceOrderUrl, serviceOrder);
		//
		CommonMethods.verifyString(dashBoard.getRequestedSOcustomerName(), requestedbY);
		CommonMethods.verifyString(dashBoard.getSOrequestedDate(), moveOutstart_dtfinalString);
		//
		CommonMethods.verifyString(dashBoard.getMoveOutSOcustomerName(), moveOutCustomer);
		CommonMethods.verifyString(dashBoard.getMoveInSOcustomerName(), moveInCustomer);
		CommonMethods.verifyString(dashBoard.getSOTask1Description() ,task1);
		CommonMethods.verifyString(dashBoard.getSOTask2Description() ,task2);
		CommonMethods.verifyString(dashBoard.getSOTask3Description() ,task3);
		CommonMethods.verifyString(dashBoard.getSOTask4Description() ,task4);
		CommonMethods.verifyString(dashBoard.getSOTask5Description() ,task5);
		CommonMethods.verifyString(dashBoard.getSOTask6Description() ,task6);
		log(serviceOrder);
		sql.verifyServiceOrders(locationID, serviceOrder);
		dashBoard.logout();
	}

}
