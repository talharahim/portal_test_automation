package com.NexusPortalAutomation.TestCases.Java;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.NexusPortalAutomation.PageObjects.Java.DashBoard;
import com.NexusPortalAutomation.PageObjects.Java.DashBoardSearch;
import com.NexusPortalAutomation.PageObjects.Java.Dashboard_Transfers;
import com.NexusPortalAutomation.Utilities.Java.CommonMethods;
import com.NexusPortalAutomation.Utilities.Java.MySQLDataExec;
import com.microsoft.sqlserver.jdbc.SQLServerException;

public class TC0027_VerifyAction_Transfers_StopService extends BaseClass {

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
	CommonMethods ComMethd = new CommonMethods();

//This Test will test the search by Customer ID
	@Test(priority = 1)
	public void VerifyActionServiceOrder()
			throws IOException, InterruptedException, ClassNotFoundException, SQLServerException, SQLException {
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
		// Entering data for Move Out
		//Scroll down
		JavascriptExecutor jsx = (JavascriptExecutor)driver;
		jsx.executeScript("window.scrollBy(0,450)", "");
		//
		dashBoard.verifyDefaultCustomerStartService(DefaultCustomer);
		dashBoard.enterDefaultCustomerStartService(DefaultCustomer);
		dashBoard.enterDescription("AUTOMATION TEST");
		// Entering data for Move In
//		dashBoard.ClickMoveIn();
//		dashBoard.Movin_EnterRequestDate("07/15/2019 07:52");
//		dashBoard.Movin_EnterRequest("TRANSFER");
//		dashBoard.Movin_EnterLocation(LocationID2);
//		dashBoard.Movin_EnterDescription("Move in from location");
		dashBoard.Click_MoveInSubmit();
		Thread.sleep(1000);
		dashBoard.ClickDone();
		// Sql.VerifyServiceOrders(LocationID, DateRequested);
		// Verify Updated details IN SERVICE TAB order number from database
		dashBoard.ClickServiceOrderLink();
		String ServiceOrder = dashBoard.getServiceOrderNumber();
		log(ServiceOrder);
		Sql.VerifyServiceOrders(LocationID, ServiceOrder);
		// Entering location ID 2 and verifying
//		dashBoard.enterDashBoardSearch(LocationID2);
//		dashBoard.clickDashBoardSearchResult1();		
//		dashBoard.ClickServiceOrderLink();
//		ServiceOrder = dashBoard.getServiceOrderNumber();
//		log(ServiceOrder);
//		Sql.VerifyServiceOrders(LocationID2, ServiceOrder);
		dashBoard.LogOut();
	}

}
