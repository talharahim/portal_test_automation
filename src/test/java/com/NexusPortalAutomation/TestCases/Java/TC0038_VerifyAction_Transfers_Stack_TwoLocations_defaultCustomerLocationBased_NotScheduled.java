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

public class TC0038_VerifyAction_Transfers_Stack_TwoLocations_defaultCustomerLocationBased_NotScheduled extends BaseClass {

	/*
	 * This test the search by Recent Customer Name
	 * 
	 * @author Talha Rahim
	 * 
	 * @version 1.0
	 * 
	 * @Since 2019-07-29
	 */

	public String locationID =getCellvalue("TC0038", "locationID");// "TESTLOCATION01";
	public String locationID2 = getCellvalue("TC0038", "locationID2");//"LOC@0004";
	public String defaultCustomer1= getCellvalue("TC0038", "defaultCustomer1");//"Mr. Talha Rahim";
	public String defaultCustomer2 = getCellvalue("TC0038", "defaultCustomer2");//"Mr. VACANT VACANT";
	public String message = getCellvalue("TC0038", "message");//"Transfer initiated";
	public String[] task = {"Meter Reading-electric", "Charge New Customer","Property Transfer", "Deposit Request-new Customer", "Deposit Payment-new Customer E","Prepayment Required-new Custom"};
	CommonMethods cmnMethods = new CommonMethods();
	public String serverUrl = getDrillbackServerUrl();

//This Test will test the search by Customer ID
	@Test(priority = 1)
	public void VerifyAction_Transfers_Stack_TwoLocations_defaultCustomerLocationBased_NotScheduled() throws IOException, InterruptedException, ClassNotFoundException,
			SQLServerException, SQLException, ParseException {
		DashBoardSearch dbSrch = new DashBoardSearch(driver);
		Dashboard_Transfers dashBoard = new Dashboard_Transfers(driver);
		MySQLDataExec sql = new MySQLDataExec();
		sql.deleteServiceorder(locationID);
		sql.deleteServiceorderHistory(locationID);
		sql.deleteServiceorder(locationID2);
		sql.deleteServiceorderHistory(locationID2);
//		login();
//		dbSrch.enterSearchText(locationID);
//		dbSrch.clickCustomerName();
//		// Verify Customer Location Id Updated for Test
//		cmnMethods.VerifyString(locationID, dashBoard.GetLoggedCustomerlocationID());
//		dashBoard.clickActionDropDown();
//		dashBoard.clickActionDropDown_TransferService();
//		dashBoard.SelectTransferType_Transfer_Stop();
//		String moveOutrequestedDate = dashBoard.startService_getRequestedDate();
//		// Entering data for Move Out
//		// Scroll down
//		dashBoard.submitStartStopServiceTransferOrder(moveOutrequestedDate, "", "TRANSFER", defaultCustomer1, "");
//		// Verify Updated details IN SERVICE TAB order number from database
//		dashBoard.ClickServiceOrderLink();
//		dashBoard.ClickServOrder1();
//		String ServiceOrder = dashBoard.getserviceOrderNum();
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
////   		dashBoard.submitStartStopServiceTransferOrder(moveOutrequestedDate, "", "TRANSFER", defaultCustomer1, "");
////		dashBoard.clickrefreshPage();
////		dashBoard.ClickServiceOrderLink();
////		dashBoard.ClickServOrder1();
//		
//		//NAVIGATE TO SECOND LOCATION
//		//String ServiceOrder2 = dashBoard.getserviceOrderNum();
//		dashBoard.clickrefreshPage();
//		
//		dashBoard.enterDashBoardSearch(locationID2);
//		dashBoard.clickDashBoardSearchResult1();
//		
//		dashBoard.clickActionDropDown();
//		dashBoard.clickActionDropDown_TransferService();
//		dashBoard.SelectTransferType_Transfer();
//		dashBoard.enterRequest("Transfer");
//		// Move Out
//		moveOutrequestedDate = dashBoard.Movin_getMoveOutRequestedDate();
//		dashBoard.verifydefaultCustomer(defaultCustomer2);
//		dashBoard.enterdefaultCustomer(defaultCustomer2);
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
//		dashBoard.Movin_EnterLocation(locationID);
//		dashBoard.Movin_EnterDescription("Move in from location "+locationID);
//		dashBoard.Click_MoveInSubmit();
//		Thread.sleep(1000);
//		dashBoard.verifySubmitMessage(Message);
//		dashBoard.ClickDone();
//		
//		dashBoard.enterDashBoardSearch(locationID);
//		dashBoard.clickDashBoardSearchResult1();
//		//Navigate to Service Order
//		dashBoard.clickrefreshPage();
//		dashBoard.ClickServiceOrderLink();
//		dashBoard.ClickServOrder1();
//		String moveOutCustomer = "Mr. Test Mid Customer Suf";
//		String moveInCustomer = "Mr. Automation Mate (0000011111)";
//		dashBoard.verifyServiceOrderdetails(moveOutCustomer,moveOutCustomer,moveInCustomer,"Not Scheduled",moveOutstart_dtfinalString,Task,locationID);
//		
//		//Verifying Service Order 2
//		dashBoard.ClickServOrder2();
//		moveOutCustomer = "Mr. Talha Rahim";
//		moveInCustomer = "Mr. Talha Rahim (03332301204)";
//		dashBoard.verifyServiceOrderdetails(moveOutCustomer,moveOutCustomer,moveInCustomer,"Not Scheduled",moveOutstart_dtfinalString,Task,locationID);
//		// Verifying Third Transfer order in the stack
//// 		dashBoard.ClickServOrder3();
//// 	   	moveOutCustomer = "Mr. Automation Mate";
//// 		moveInCustomer = "Mr. Talha Rahim (03332301204)";
////		dashBoard.verifyServiceOrderdetails(moveOutCustomer,moveOutCustomer,moveInCustomer,"Not Scheduled",moveOutstart_dtfinalString,Task,locationID);
//		dashBoard.logout();
	}

}

