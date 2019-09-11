package com.NexusPortalAutomation.TestCases.Java;

import java.io.IOException;
import java.util.HashMap;

import org.testng.annotations.Test;

import com.NexusPortalAutomation.PageObjects.Java.DashBoard;
import com.NexusPortalAutomation.PageObjects.Java.DashBoardSearch;
import com.NexusPortalAutomation.Utilities.Java.CommonMethods;

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
	public String locationID = "LOC@0001";
	public String customerId = "0000011111";
	public String serverUrl = getDrillbackServerUrl();
	CommonMethods cmnMethods = new CommonMethods();
	String serviceOrderReqId = "REQ-EST-ELE";
	String serviceOrderDescription = "Meter Reading For Estimate Electric";
	String serviceOrderScheduledDate = "May 17, 2019";
	String solvserviceOrderId = "SORD00000000057";
	String sodvStatus = "Completed";
	String sodvDescriptionRequest = "Meter Reading For Estimate Electric";
	String sodvRequestId = "REQ-EST-ELE";
	String sodvRequestedDate = "May 17, 2019";
	String sodvRequestedTime = "5:53 AM";
	String sodvScheduledDate = "May 17, 2019";
	String sodvScheduledTime = "5:53 AM";
	String sodvTaskDescription = "Meter Reading-electric";
	String sodvTaskEmployeeId = "CARN0001";
	String sodvTaskCompletedDate = "Apr 12, 2027";
	// This Test will test the search by Customer ID

	@Test
	public void TestserviceOrderDetails() throws IOException, InterruptedException {
		DashBoardSearch dbSrch = new DashBoardSearch(driver);
		DashBoard dashBoard = new DashBoard(driver);
		CommonMethods cmnMethods = new CommonMethods();
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
