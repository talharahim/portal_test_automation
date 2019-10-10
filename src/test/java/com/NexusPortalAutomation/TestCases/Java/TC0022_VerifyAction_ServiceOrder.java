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

	public String locationID = getCellvalue("TC0022", "loc7");//"LOC@0007";
	public String customerId = getCellvalue("TC0022", "drillbackCustId");//"0000011111";
	public String serverUrl = getDrillbackServerUrl();
	public String searchInput = getCellvalue("TC0022", "SearchInput");//"REQ-DEP-WATER";
	public String dateDescription = getCellvalue("TC0022", "DateDescription");//"AutomationRequest";
	public String message = getCellvalue("TC0022", "Message");//"Service Order successfully created";
	

//This Test will test the search by Customer ID
	@Test(priority = 1)
	public void VerifyActionServiceOrder()
			throws IOException, InterruptedException, ClassNotFoundException, SQLServerException, SQLException {
		DashBoardSearch dbSrch = new DashBoardSearch(driver);
		DashBoard dashBoard = new DashBoard(driver);
		MySQLDataExec sql = new MySQLDataExec();
		sql.deleteServiceorder(locationID);
		login();
		dbSrch.enterSearchText(locationID);
		dbSrch.clickCustomerName();
		// Verify Customer Location Id Updated for Test
		CommonMethods.verifyString(locationID, dashBoard.getLoggedCustomerLocationId());
		// Verify Contact is updated accordingly
		// CommonMethods.VerifyString(servTabURL, dashBoard.GetServiceTabDrillBackUrl());
		dashBoard.clickActionDropDown();
		dashBoard.clickActionDropDown_ServiceOrder();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();
		String DateRequested = dateFormat.format(date);
		dashBoard.submitServiceRequest(searchInput, DateRequested, DateRequested, dateDescription);
		Thread.sleep(1000);
		dashBoard.verifySubmitMessage(message);
		dashBoard.ClickSerOrderDne();
		
		//sql.VerifyServiceOrders(locationID, DateRequested);
		// Verify Updated details IN SERVICE TAB order number from database
		dashBoard.clickServiceorderLink();
		String ServiceOrder = dashBoard.getserviceOrderNum();
		sql.verifyServiceOrders(locationID, ServiceOrder);
		dashBoard.logout();
	}

}
