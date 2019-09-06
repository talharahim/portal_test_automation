package com.NexusPortalAutomation.TestCases.Java;

import java.io.IOException;
import java.util.HashMap;

import org.testng.annotations.Test;

import com.NexusPortalAutomation.PageObjects.Java.DashBoard;
import com.NexusPortalAutomation.PageObjects.Java.DashBoardSearch;
import com.NexusPortalAutomation.Utilities.Java.CommonMethods;

public class TC0021_VerifyServicesOrderDetails extends BaseClass {

	/*
	 * This test the search Drill Back for Services TAB
	 * 
	 * @author Talha Rahim
	 * 
	 * @version 1.0
	 * 
	 * @Since 2019-06-14
	 */
	public String locationID = "LOC@0001";
	public String CustomerID = "0000011111";
	public String ServerURL = GetDrillBackServerURL();
	CommonMethods cmnMethods = new CommonMethods();
	String ServiceOrderReqId = "REQ-EST-ELE";
	String ServiceOrderDescription = "Meter Reading For Estimate Electric";
	String ServiceOrderScheduledDate = "May 17, 2019";
	String SOLVServiceOrderId = "SORD00000000057";
	String SODVStatus = "Completed";
	String SODVDescriptionRequest = "Meter Reading For Estimate Electric";
	String SODVRequestId = "REQ-EST-ELE";
	String SODVRequestedDate = "May 17, 2019";
	String SODVRequestedTime = "5:53 AM";
	String SODVScheduledDate = "May 17, 2019";
	String SODVScheduledTime = "5:53 AM";
	String SODVTaskDescription = "Meter Reading-electric";
	String SODVTaskEmployeeId = "CARN0001";
	String SODVTaskCompletedDate = "Apr 12, 2027";
	// This Test will test the search by Customer ID

	@Test
	public void TestServiceOrderDetails() throws IOException, InterruptedException {
		DashBoardSearch dbSrch = new DashBoardSearch(driver);
		DashBoard dashBoard = new DashBoard(driver);
		CommonMethods cmnMethods = new CommonMethods();
		login();
		dbSrch.enterSearchText(locationID);
		dbSrch.clickCustomerName();
		// Verify Customer Location Id Updated for Test
		cmnMethods.verifyString(locationID, dashBoard.getLoggedCustomerName());
		// Verify Contact is updated accordingly
		dashBoard.ClickServiceOrderLink();
		dashBoard.ServOrd_SelectDateAnyTime();
		// Verify Service Order details
		HashMap<String, String> SrvcOrderInfo = dashBoard.GetServiceOrderDetails();
		cmnMethods.verifyString(ServiceOrderReqId, SrvcOrderInfo.get("ServiceOrderReqId"));
		cmnMethods.verifyString(ServiceOrderDescription, SrvcOrderInfo.get("ServiceOrderDescription"));
		cmnMethods.verifyString(ServiceOrderScheduledDate, SrvcOrderInfo.get("ServiceOrderScheduledDate"));
		cmnMethods.verifyString(SOLVServiceOrderId, SrvcOrderInfo.get("SOLVServiceOrderId"));
		cmnMethods.verifyString(SODVStatus, SrvcOrderInfo.get("SODVStatus"));
		cmnMethods.verifyString(SODVDescriptionRequest, SrvcOrderInfo.get("SODVDescriptionRequest"));
		cmnMethods.verifyString(SODVRequestId, SrvcOrderInfo.get("SODVRequestId"));
		cmnMethods.verifyString(SODVRequestedDate, SrvcOrderInfo.get("SODVRequestedDate"));
		cmnMethods.verifyString(SODVRequestedTime, SrvcOrderInfo.get("SODVRequestedTime"));
		cmnMethods.verifyString(SODVScheduledDate, SrvcOrderInfo.get("SODVScheduledDate"));
		cmnMethods.verifyString(SODVScheduledTime, SrvcOrderInfo.get("SODVScheduledTime"));
		cmnMethods.verifyString(SODVTaskDescription, SrvcOrderInfo.get("SODVTaskDescription"));
		cmnMethods.verifyString(SODVTaskEmployeeId, SrvcOrderInfo.get("SODVTaskEmployeeId"));
		cmnMethods.verifyString(SODVTaskCompletedDate, SrvcOrderInfo.get("SODVTaskCompletedDate"));
		dashBoard.logout();
	}

}
