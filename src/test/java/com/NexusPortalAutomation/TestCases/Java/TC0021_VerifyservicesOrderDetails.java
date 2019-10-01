package com.NexusPortalAutomation.TestCases.Java;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

import org.testng.annotations.Test;

import com.NexusPortalAutomation.PageObjects.Java.DashBoard;
import com.NexusPortalAutomation.PageObjects.Java.DashBoardSearch;
import com.NexusPortalAutomation.Utilities.Java.CommonMethods;
import com.NexusPortalAutomation.Utilities.Java.MySQLDataExec;
import com.microsoft.sqlserver.jdbc.SQLServerException;

public class TC0021_VerifyservicesOrderDetails extends BaseClass {

	/*
	 * This test the search Drill Back for services TAB
	 * 
	 * @author Talha Rahim
	 * 
	 * @version 1.0
	 * 
	 * @Since 2019-06-14
	 */
	public String locationID = getCellvalue("TC0021", "loc1");//"LOC@0001";
	public String customerId = getCellvalue("TC0021", "drillbackCustId");//"0000011111";
	public String serverUrl = getDrillbackServerUrl();
	CommonMethods cmnMethods = new CommonMethods();
	String serviceOrderReqId = getCellvalue("TC0021", "serviceOrderReqId");//"REQ-EST-ELE";
	String serviceOrderDescription = getCellvalue("TC0021", "serviceOrderDescription");//"Meter Reading For Estimate Electric";
	String serviceOrderScheduledDate = getCellvalue("TC0021", "serviceOrderScheduledDate");//"May 17, 2019";
	String solvserviceOrderId = getCellvalue("TC0021", "solvserviceOrderId");//"SORD00000000057";
	String sodvStatus = getCellvalue("TC0021", "sodvStatus");//"Completed";
	String sodvDescriptionRequest = getCellvalue("TC0021", "sodvDescriptionRequest");//"Meter Reading For Estimate Electric";
	String sodvRequestId = getCellvalue("TC0021", "sodvRequestId");//"REQ-EST-ELE";
	String sodvRequestedDate = getCellvalue("TC0021", "sodvRequestedDate");//"May 17, 2019";
	String sodvRequestedTime = getCellvalue("TC0021", "sodvRequestedTime");//"5:53 AM";
	String sodvScheduledDate = getCellvalue("TC0021", "sodvScheduledDate");//"May 17, 2019";
	String sodvScheduledTime = getCellvalue("TC0021", "sodvScheduledTime");//"5:53 AM";
	String sodvTaskDescription = getCellvalue("TC0021", "sodvTaskDescription");//"Meter Reading-electric";
	String sodvTaskEmployeeId = getCellvalue("TC0021", "sodvTaskEmployeeId");// "CARN0001";
	String sodvTaskCompletedDate = getCellvalue("TC0021", "sodvTaskCompletedDate");//"Apr 12, 2027";
	// This Test will test the search by Customer ID

	@Test
	public void TestserviceOrderDetails() throws IOException, InterruptedException, ClassNotFoundException, SQLServerException, SQLException {
		DashBoardSearch dbSrch = new DashBoardSearch(driver);
		DashBoard dashBoard = new DashBoard(driver);
		CommonMethods cmnMethods = new CommonMethods();
		MySQLDataExec sql = new MySQLDataExec();
		sql.deleteServiceorder(locationID);
		sql.deleteServiceorderHistory(locationID);
		login();
		dbSrch.enterSearchText(locationID);
		dbSrch.clickCustomerName();
		// Verify Customer Location Id Updated for Test
		cmnMethods.verifyString(locationID, dashBoard.getLoggedCustomerLocationId());
		// Verify Contact is updated accordingly
		dashBoard.clickServiceorderLink();
		dashBoard.ServOrd_SelectDateAnyTime();
		// Verify service Order details
		WaitAngular();
		HashMap<String, String> serviceOrderInfo = dashBoard.GetServiceOrderDetails();
		cmnMethods.verifyString(serviceOrderReqId, serviceOrderInfo.get("serviceOrderReqId"));
		cmnMethods.verifyString(serviceOrderDescription, serviceOrderInfo.get("serviceOrderDescription"));
		cmnMethods.verifyString(serviceOrderScheduledDate, serviceOrderInfo.get("serviceOrderScheduledDate"));
		cmnMethods.verifyString(solvserviceOrderId, serviceOrderInfo.get("solvserviceOrderId"));
		cmnMethods.verifyString(sodvStatus, serviceOrderInfo.get("sodvStatus"));
		cmnMethods.verifyString(sodvDescriptionRequest, serviceOrderInfo.get("sodvDescriptionRequest"));
		cmnMethods.verifyString(sodvRequestId, serviceOrderInfo.get("sodvRequestId"));
		cmnMethods.verifyString(sodvRequestedDate, serviceOrderInfo.get("sodvRequestedDate"));
		cmnMethods.verifyString(sodvRequestedTime, serviceOrderInfo.get("sodvRequestedTime"));
		cmnMethods.verifyString(sodvScheduledDate, serviceOrderInfo.get("sodvScheduledDate"));
		cmnMethods.verifyString(sodvScheduledTime, serviceOrderInfo.get("sodvScheduledTime"));
		cmnMethods.verifyString(sodvTaskDescription, serviceOrderInfo.get("sodvTaskDescription"));
		cmnMethods.verifyString(sodvTaskEmployeeId, serviceOrderInfo.get("sodvTaskEmployeeId"));
		cmnMethods.verifyString(sodvTaskCompletedDate, serviceOrderInfo.get("sodvTaskCompletedDate"));
		dashBoard.logout();
	}

}
