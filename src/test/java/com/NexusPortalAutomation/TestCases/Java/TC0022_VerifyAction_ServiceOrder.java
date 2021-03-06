package com.NexusPortalAutomation.TestCases.Java;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.Test;

import com.NexusPortalAutomation.PageObjects.Java.DashBoard;
import com.NexusPortalAutomation.PageObjects.Java.DashBoardSearch;
import com.NexusPortalAutomation.Utilities.Java.CommonMethods;
import com.NexusPortalAutomation.Utilities.Java.MySQLDataExec;
import com.microsoft.sqlserver.jdbc.SQLServerException;

public class TC0022_VerifyAction_ServiceOrder extends BaseClass {

	/*
	 * This test the search by Recent Customer Name
	 * 
	 * @author Talha Rahim
	 * 
	 * @version 1.0
	 * 
	 * @Since 2019-06-10
	 */

	public String LocationID = "LOC@0007";
	public String CustomerID = "0000011111";
	public String ServerURL = GetDrillBackServerURL();
	public String SearchInput = "REQ-DEP-WATER";
	public String DateDescription = "AutomationRequest";
	CommonMethods ComMethd = new CommonMethods();

//This Test will test the search by Customer ID
	@Test(priority = 1)
	public void VerifyActionServiceOrder()
			throws IOException, InterruptedException, ClassNotFoundException, SQLServerException, SQLException {
		DashBoardSearch dbSrch = new DashBoardSearch(driver);
		DashBoard dashBoard = new DashBoard(driver);
		MySQLDataExec Sql = new MySQLDataExec();
		Sql.DeleteServiceOrders(LocationID);
		login();
		dbSrch.EnterSearchText(LocationID);
		dbSrch.ClickCustomer();
		// Verify Customer Location Id Updated for Test
		ComMethd.VerifyString(LocationID, dashBoard.GetLoggedCustomerLocationId());
		// Verify Contact is updated accordingly
		// ComMethd.VerifyString(servTabURL, dashBoard.GetServiceTabDrillBackUrl());
		dashBoard.clickActionDropDown();
		dashBoard.clickActionDropDown_ServiceOrder();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();
		String DateRequested = dateFormat.format(date);
		dashBoard.submitServiceRequest(SearchInput, DateRequested, DateRequested, DateDescription);
		Thread.sleep(1000);
		
		//Sql.VerifyServiceOrders(LocationID, DateRequested);
		// Verify Updated details IN SERVICE TAB order number from database
		dashBoard.ClickServiceOrderLink();
		String ServiceOrder = dashBoard.getServiceOrderNumber();
		Sql.VerifyServiceOrders(LocationID, ServiceOrder);
		dashBoard.LogOut();
	}

}
