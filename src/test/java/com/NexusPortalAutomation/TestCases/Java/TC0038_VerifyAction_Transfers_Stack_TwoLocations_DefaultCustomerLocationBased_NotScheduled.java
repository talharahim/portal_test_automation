package com.NexusPortalAutomation.TestCases.Java;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.NexusPortalAutomation.PageObjects.Java.DashBoardSearch;
import com.NexusPortalAutomation.PageObjects.Java.Dashboard_Transfers;
import com.NexusPortalAutomation.Utilities.Java.CommonMethods;
import com.NexusPortalAutomation.Utilities.Java.MySQLDataExec;
import com.microsoft.sqlserver.jdbc.SQLServerException;

public class TC0038_VerifyAction_Transfers_Stack_TwoLocations_DefaultCustomerLocationBased_NotScheduled extends BaseClass {

	/*
	 * This test the search by Recent Customer Name
	 * 
	 * @author Talha Rahim
	 * 
	 * @version 1.0
	 * 
	 * @Since 2019-07-29
	 */

	public String LocationID = "TESTLOCATION01";
	public String LocationID2 = "LOC@0004";
	public String ServerURL = GetDrillBackServerURL();
	public String DefaultCustomer1= "Mr. Talha Rahim";
	public String DefaultCustomer2 = "Mr. VACANT VACANT";
	public String Message = "Transfer initiated";
	public String[] Task = {"Meter Reading-electric", "Charge New Customer","Property Transfer", "Deposit Request-new Customer", "Deposit Payment-new Customer E","Prepayment Required-new Custom"};
	CommonMethods ComMethd = new CommonMethods();

//This Test will test the search by Customer ID
	@Test(priority = 1)
	public void VerifyTransferActionServiceOrder() throws IOException, InterruptedException, ClassNotFoundException,
			SQLServerException, SQLException, ParseException {
		DashBoardSearch dbSrch = new DashBoardSearch(driver);
		Dashboard_Transfers dashBoard = new Dashboard_Transfers(driver);
		MySQLDataExec Sql = new MySQLDataExec();
		Sql.DeleteServiceOrders(LocationID);
		Sql.DeleteServiceOrdersHistory(LocationID);
		Sql.DeleteServiceOrders(LocationID2);
		Sql.DeleteServiceOrdersHistory(LocationID2);
//		login();
//		dbSrch.EnterSearchText(LocationID);
//		dbSrch.ClickCustomer();
//		// Verify Customer Location Id Updated for Test
//		ComMethd.VerifyString(LocationID, dashBoard.GetLoggedCustomerLocationId());
//		dashBoard.clickActionDropDown();
//		dashBoard.clickActionDropDown_TransferService();
//		dashBoard.SelectTransferType_Transfer_Stop();
//		String moveOutrequestedDate = dashBoard.startService_getRequestedDate();
//		// Entering data for Move Out
//		// Scroll down
//		dashBoard.submitStartStopServiceTransferOrder(moveOutrequestedDate, "", "TRANSFER", DefaultCustomer1, "");
//		// Verify Updated details IN SERVICE TAB order number from database
//		dashBoard.ClickServiceOrderLink();
//		dashBoard.ClickServOrder1();
//		String ServiceOrder = dashBoard.getServiceOrderNumber();
//		String[] arrOfStr = moveOutrequestedDate.split(" ", 2);
//		String moveOutstart_dt = arrOfStr[0];
//		DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
//		Date date = (Date) formatter.parse(moveOutstart_dt);
//		SimpleDateFormat newFormat = new SimpleDateFormat("MMM d, yyyy");
//		String moveOutstart_dtfinalString = newFormat.format(date);
//		dashBoard.clickrefreshPage();
//
////		/*
////		// Adding Second Service with two dates ahead of current date
////		*/
////		dashBoard.clickActionDropDown();
////		dashBoard.clickActionDropDown_TransferService();
////		dashBoard.SelectTransferType_Transfer_Stop();
////		dashBoard.verifyServiceWarningSingleSO(ServiceOrder);
////		Calendar c = Calendar.getInstance();
////		c.setTime(newFormat.parse(moveOutstart_dtfinalString));
////		c.add(Calendar.DAY_OF_MONTH, 2);
////		// Date after adding the days to the given date
////		String newDate = newFormat.format(c.getTime());
////		// Displaying the new Date after addition of Days
////		System.out.println("Date after Addition of two days " + newDate);
////		// Entering data for Move Out
////		// Scroll down
////   		//String moveInCustomer = "Mr. VACANT VACANT";
////   		dashBoard.submitStartStopServiceTransferOrder(moveOutrequestedDate, "", "TRANSFER", DefaultCustomer1, "");
////		dashBoard.clickrefreshPage();
////		dashBoard.ClickServiceOrderLink();
////		dashBoard.ClickServOrder1();
//		
//		//NAVIGATE TO SECOND LOCATION
//		//String ServiceOrder2 = dashBoard.getServiceOrderNumber();
//		dashBoard.clickrefreshPage();
//		
//		dashBoard.enterDashBoardSearch(LocationID2);
//		dashBoard.clickDashBoardSearchResult1();
//		
//		dashBoard.clickActionDropDown();
//		dashBoard.clickActionDropDown_TransferService();
//		dashBoard.SelectTransferType_Transfer();
//		dashBoard.enterRequest("Transfer");
//		// Move Out
//		moveOutrequestedDate = dashBoard.Movin_getMoveOutRequestedDate();
//		dashBoard.verifyDefaultCustomer(DefaultCustomer2);
//		dashBoard.enterDefaultCustomer(DefaultCustomer2);
//		dashBoard.enterDescription("AUTOMATION TEST");
//		// Move In
//		dashBoard.ClickMoveIn();
//		Calendar c1 = Calendar.getInstance();
//		c1.add(Calendar.DAY_OF_MONTH, 1);
//		// Date after adding the days to the given date
//		String newDate2 = newFormat.format(c1.getTime());
//		//dashBoard.Movin_EnterMoveToScheduleDate(newDate2);
//		Thread.sleep(1000);
//		dashBoard.Movin_EnterRequest("TRANSFER");
//		dashBoard.Movin_EnterLocation(LocationID);
//		dashBoard.Movin_EnterDescription("Move in from location "+LocationID);
//		dashBoard.Click_MoveInSubmit();
//		Thread.sleep(1000);
//		dashBoard.verifySubmitMessage(Message);
//		dashBoard.ClickDone();
//		
//		dashBoard.enterDashBoardSearch(LocationID);
//		dashBoard.clickDashBoardSearchResult1();
//		//Navigate to Service Order
//		dashBoard.clickrefreshPage();
//		dashBoard.ClickServiceOrderLink();
//		dashBoard.ClickServOrder1();
//		String moveOutCustomer = "Mr. Test Mid Customer Suf";
//		String moveInCustomer = "Mr. Automation Mate (0000011111)";
//		dashBoard.verifyServiceOrderdetails(moveOutCustomer,moveOutCustomer,moveInCustomer,"Not Scheduled",moveOutstart_dtfinalString,Task,LocationID);
//		
//		//Verifying Service Order 2
//		dashBoard.ClickServOrder2();
//		moveOutCustomer = "Mr. Talha Rahim";
//		moveInCustomer = "Mr. Talha Rahim (03332301204)";
//		dashBoard.verifyServiceOrderdetails(moveOutCustomer,moveOutCustomer,moveInCustomer,"Not Scheduled",moveOutstart_dtfinalString,Task,LocationID);
//		// Verifying Third Transfer order in the stack
//// 		dashBoard.ClickServOrder3();
//// 	   	moveOutCustomer = "Mr. Automation Mate";
//// 		moveInCustomer = "Mr. Talha Rahim (03332301204)";
////		dashBoard.verifyServiceOrderdetails(moveOutCustomer,moveOutCustomer,moveInCustomer,"Not Scheduled",moveOutstart_dtfinalString,Task,LocationID);
//		dashBoard.LogOut();
	}

}

