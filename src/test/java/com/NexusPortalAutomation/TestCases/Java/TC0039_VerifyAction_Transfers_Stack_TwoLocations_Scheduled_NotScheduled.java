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

public class TC0039_VerifyAction_Transfers_Stack_TwoLocations_Scheduled_NotScheduled extends BaseClass {

	/*
	 * This test the search by Recent Customer Name
	 * 
	 * @author Talha Rahim
	 * 
	 * @version 1.0
	 * 
	 * @Since 2019-07-29
	 */

	public String locationID = getCellvalue("TC0039", "locationID");// "LOC@0004";
	public String locationID2 = getCellvalue("TC0039", "locationID2");//"LOC@0002";
	public String locationID3 = getCellvalue("TC0039", "locationID3");//"ELECWAT003";
	public String locationID4 = getCellvalue("TC0039", "locationID4");//"ELECWAT003";
	public String defaultCustomer = getCellvalue("TC0039", "defaultCustomer");//"Mr. VACANT VACANT";
	public String defaultCustomer2 = getCellvalue("TC0039", "defaultCustomer2");//"Mr. VACANT VACANT";
	public String message = getCellvalue("TC0039", "message");//"Transfer initiated";
	public String[] task = {"Meter Reading-electric", "Charge New Customer","Property Transfer", "Deposit Request-new Customer", "Deposit Payment-new Customer E","Prepayment Required-new Custom"};
	
	public String serverUrl = getDrillbackServerUrl();

//This Test will test the search by Customer ID
	@Test(priority = 1)
	public void VerifyAction_Transfers_Stack_TwoLocations_Scheduled_NotScheduled() throws IOException, InterruptedException, ClassNotFoundException,
			SQLServerException, SQLException, ParseException {
		DashBoardSearch dbSrch = new DashBoardSearch(driver);
		Dashboard_Transfers dashBoard = new Dashboard_Transfers(driver);
		MySQLDataExec sql = new MySQLDataExec();
		sql.deleteServiceorder(locationID);
		sql.deleteServiceorderHistory(locationID);
		sql.deleteServiceorder(locationID2);
		sql.deleteServiceorderHistory(locationID2);
		sql.deleteServiceorder(locationID3);
		sql.deleteServiceorderHistory(locationID3);
		sql.deleteServiceorder(locationID4);
		sql.deleteServiceorderHistory(locationID4);
		login();
		dbSrch.enterSearchText(locationID);
		dbSrch.clickCustomerName();
		// Verify Customer Location Id Updated for Test
		CommonMethods.verifyString(locationID, dashBoard.getLoggedCustomerLocationId());
		dashBoard.clickActionDropDown();
		dashBoard.clickActionDropDown_TransferService();
		dashBoard.selectTransferStop();
		String moveOutrequestedDate = dashBoard.startService_getRequestedDate();
		// Entering data for Move Out
		// Scroll down
		dashBoard.submitStartStopServiceTransferOrder("", "TRANSFER", defaultCustomer, defaultCustomer, "Description for Stop Service");
		// Verify Updated details IN SERVICE TAB order number from database
		dashBoard.clickServiceorderLink();
		dashBoard.clickServiceorder1();
		String ServiceOrder = dashBoard.getserviceOrderNum();
		String[] arrOfStr = moveOutrequestedDate.split(" ", 2);
		String moveOutstart_dt = arrOfStr[0];
		DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		Date date = (Date) formatter.parse(moveOutstart_dt);
		SimpleDateFormat newFormat = new SimpleDateFormat("MMM d, yyyy");
		String moveOutstart_dtfinalString = newFormat.format(date);
		dashBoard.clickrefreshPage();

		/*
		// Adding Second Service with two dates ahead of current date
		*/
		dashBoard.clickActionDropDown();
		dashBoard.clickActionDropDown_TransferService();
		dashBoard.selectTransferStop();
		dashBoard.verifyServiceWarningSOSingleStop(ServiceOrder);
		Calendar c = Calendar.getInstance();
		c.setTime(newFormat.parse(moveOutstart_dtfinalString));
		c.add(Calendar.DAY_OF_MONTH, 2);
		// Date after adding the days to the given date
		String newDate = newFormat.format(c.getTime());
		// Displaying the new Date after addition of Days
		System.out.println("Date after Addition of two days " + newDate);
		// Entering data for Move Out
		// Scroll down
   		String moveInCustomer = "Mr. VACANT VACANT";
   		dashBoard.submitStartStopServiceTransferOrder(newDate, "TRANSFER", defaultCustomer, moveInCustomer,"Description for Stop Service");
		dashBoard.clickrefreshPage();
		dashBoard.clickServiceorderLink();
		dashBoard.clickServiceorder1();
		//String ServiceOrder2 = dashBoard.getserviceOrderNum();
		dashBoard.clickrefreshPage();
		
		dashBoard.enterDashBoardSearch(locationID2);
		dashBoard.clickDashBoardSearchResult1();
		
		dashBoard.clickActionDropDown();
		dashBoard.clickActionDropDown_TransferService();
		dashBoard.selectTransferTypeTransfer();
		dashBoard.enterRequest("Transfer");
		// Move Out
		moveOutrequestedDate = dashBoard.Movin_getMoveOutRequestedDate();
		dashBoard.verifydefaultCustomer(defaultCustomer);
		dashBoard.enterdefaultCustomerTransfer(defaultCustomer2);
		dashBoard.enterDescription("AUTOMATION TEST");
		// Move In
		dashBoard.ClickMoveTo();
		Calendar c1 = Calendar.getInstance();
		c1.add(Calendar.DAY_OF_MONTH, 1);
		// Date after adding the days to the given date
		String newDate2 = newFormat.format(c1.getTime());
		dashBoard.movinEnterMoveToScheduleDate(newDate2);
		Thread.sleep(1000);
		dashBoard.movinEnterRequest("TRANSFER");
		dashBoard.movinEnterLocation(locationID4);
		dashBoard.movinEnterDescription("Move in from location "+locationID4);
		dashBoard.clickMoveInSubmit();
		Thread.sleep(1000);
		dashBoard.verifySubmitMessage(message);
		dashBoard.clickDone();
		
		dashBoard.enterDashBoardSearch(locationID);
		dashBoard.clickDashBoardSearchResult1();
		//Navigate to Service Order
		
		dashBoard.clickrefreshPage();
		dashBoard.clickServiceorderLink();
		dashBoard.clickServiceorder1();
		String moveOutCustomer = "Mr. Vacant Vacant";
		moveInCustomer = "Mr. Vacant Vacant (Vacant)";
		dashBoard.verifyServiceOrderdetails(moveOutCustomer,moveOutCustomer,moveInCustomer,newDate,moveOutstart_dtfinalString,task,locationID,"Description For Stop Service");
		
		//Verifying Service Order 2
		dashBoard.clickServiceorder2();
		moveOutCustomer = "Mr. Automation Mate";
		moveInCustomer = "Mr. Vacant Vacant (Vacant)";
		dashBoard.verifyServiceOrderdetails(moveOutCustomer,moveOutCustomer,moveInCustomer,"Not Scheduled",moveOutstart_dtfinalString,task,locationID,"Description For Stop Service");
		// Verifying Third Transfer order in the stack
		
		dashBoard.enterDashBoardSearch(locationID4);
		dashBoard.clickDashBoardSearchResult1();
		
 		dashBoard.clickServiceorder1();
 	   	moveOutCustomer = "Dr. Single Cust";
 		moveInCustomer = "Mrs. Gail M Dewar (Customer010)";
		dashBoard.verifyServiceOrderdetails(moveOutCustomer,moveOutCustomer,moveInCustomer,newDate2,moveOutstart_dtfinalString,task,locationID4,"Move In From Location " + locationID4);
		dashBoard.logout();
	}

}

