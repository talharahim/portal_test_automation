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
	public String LocationID = "LOC@0001";
	public String CustomerID = "0000011111";
	public String ServerURL = GetDrillBackServerURL();
	CommonMethods ComMethd = new CommonMethods();
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
	String SODVTaskDescription = "Meter Reading-Electric";
	String SODVTaskEmployeeId = "CARN0001";
	String SODVTaskCompletedDate = "Apr 12, 2027";
	// This Test will test the search by Customer ID

	@Test
	public void TestServiceOrderDetails() throws IOException, InterruptedException {
		DashBoardSearch dbSrch = new DashBoardSearch(driver);
		DashBoard dashBoard = new DashBoard(driver);
		CommonMethods ComMethd = new CommonMethods();
		login();
		dbSrch.EnterSearchText(LocationID);
		dbSrch.ClickCustomer();
		// Verify Customer Location Id Updated for Test
		ComMethd.VerifyString(LocationID, dashBoard.GetLoggedCustomerLocationId());
		// Verify Contact is updated accordingly
		dashBoard.ClickServiceOrderLink();
		dashBoard.ServOrd_SelectDateAnyTime();
		// Verify Service Order details
		HashMap<String, String> SrvcOrderInfo = dashBoard.GetServiceOrderDetails();
		ComMethd.VerifyString(ServiceOrderReqId, SrvcOrderInfo.get("ServiceOrderReqId"));
		ComMethd.VerifyString(ServiceOrderDescription, SrvcOrderInfo.get("ServiceOrderDescription"));
		ComMethd.VerifyString(ServiceOrderScheduledDate, SrvcOrderInfo.get("ServiceOrderScheduledDate"));
		ComMethd.VerifyString(SOLVServiceOrderId, SrvcOrderInfo.get("SOLVServiceOrderId"));
		ComMethd.VerifyString(SODVStatus, SrvcOrderInfo.get("SODVStatus"));
		ComMethd.VerifyString(SODVDescriptionRequest, SrvcOrderInfo.get("SODVDescriptionRequest"));
		ComMethd.VerifyString(SODVRequestId, SrvcOrderInfo.get("SODVRequestId"));
		ComMethd.VerifyString(SODVRequestedDate, SrvcOrderInfo.get("SODVRequestedDate"));
		ComMethd.VerifyString(SODVRequestedTime, SrvcOrderInfo.get("SODVRequestedTime"));
		ComMethd.VerifyString(SODVScheduledDate, SrvcOrderInfo.get("SODVScheduledDate"));
		ComMethd.VerifyString(SODVScheduledTime, SrvcOrderInfo.get("SODVScheduledTime"));
		ComMethd.VerifyString(SODVTaskDescription, SrvcOrderInfo.get("SODVTaskDescription"));
		ComMethd.VerifyString(SODVTaskEmployeeId, SrvcOrderInfo.get("SODVTaskEmployeeId"));
		ComMethd.VerifyString(SODVTaskCompletedDate, SrvcOrderInfo.get("SODVTaskCompletedDate"));
		dashBoard.LogOut();
	}

}
