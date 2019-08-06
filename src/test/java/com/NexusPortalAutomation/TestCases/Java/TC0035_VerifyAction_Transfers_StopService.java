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

public class TC0035_VerifyAction_Transfers_StopService extends BaseClass {

	/*
	 * This test the search by Recent Customer Name
	 * 
	 * @author Talha Rahim
	 * 
	 * @version 1.0
	 * 
	 * @Since 2019-07-29
	 */

	public String LocationID = "LOC@0004";
	public String LocationID2 = "LOC@0005";
	public String LocationID3 = "TESTLOCATION02";
	public String ServerURL = GetDrillBackServerURL();
	public String DefaultCustomer = "Mr. VACANT VACANT";
	
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
		Sql.DeleteServiceOrders(LocationID3);
		Sql.DeleteServiceOrdersHistory(LocationID3);
		login();
		dbSrch.EnterSearchText(LocationID);
		dbSrch.ClickCustomer();
		// Verify Customer Location Id Updated for Test
		ComMethd.VerifyString(LocationID, dashBoard.GetLoggedCustomerLocationId());
		dashBoard.clickActionDropDown();
		dashBoard.clickActionDropDown_TransferService();
		dashBoard.SelectTransferType_Transfer_Stop();
		String moveOutrequestedDate = dashBoard.startService_getRequestedDate();
		// Entering data for Move Out
		// Scroll down
		dashBoard.submitStartStopServiceTransferOrder(moveOutrequestedDate, "", "TRANSFER", DefaultCustomer, DefaultCustomer);
		// Verify Updated details IN SERVICE TAB order number from database
		dashBoard.ClickServiceOrderLink();
		dashBoard.ClickServOrder1();
		String ServiceOrder = dashBoard.getServiceOrderNumber();
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
		dashBoard.SelectTransferType_Transfer_Stop();
		dashBoard.verifyServiceWarningSingleSO(ServiceOrder);
		Calendar c = Calendar.getInstance();
		c.setTime(newFormat.parse(moveOutstart_dtfinalString));
		c.add(Calendar.DAY_OF_MONTH, 2);
		// Date after adding the days to the given date
		String newDate = newFormat.format(c.getTime());
		// Displaying the new Date after addition of Days
		System.out.println("Date after Addition of two days " + newDate);
		// Entering data for Move Out
		// Scroll down
   		String moveInCustomer = "Test Cust";
   		dashBoard.submitStartStopServiceTransferOrder(newDate, "", "TRANSFER", DefaultCustomer, moveInCustomer);
		dashBoard.clickrefreshPage();
		dashBoard.ClickServiceOrderLink();
		dashBoard.ClickServOrder1();
		String ServiceOrder2 = dashBoard.getServiceOrderNumber();
		dashBoard.clickrefreshPage();
		
		/*
		// Adding Third Service Order having date between first two
		*/
		dashBoard.clickActionDropDown();
		dashBoard.clickActionDropDown_TransferService();
		dashBoard.SelectTransferType_Transfer_Stop();
		dashBoard.verifyServiceWarningMultiSO(ServiceOrder2);
		c = Calendar.getInstance();
		c.setTime(newFormat.parse(moveOutstart_dtfinalString));
		c.add(Calendar.DAY_OF_MONTH, 1);
		// Date after adding 1 day to the given date
		String newDate2 = newFormat.format(c.getTime());
		// Displaying the new Date after addition of Days
		moveInCustomer =  "MOVEIN";
		dashBoard.submitStartStopServiceTransferOrder(newDate2, "", "TRANSFER", DefaultCustomer, moveInCustomer);
		dashBoard.clickrefreshPage();

	
		// Verify First Service Order in the Stack
		dashBoard.ClickServiceOrderLink();
		dashBoard.ClickServOrder1();
		String moveOutCustomer = "Mr. Automation Mate";
		moveInCustomer = "Mr. Movein Cus (Moveincus2)";
		dashBoard.verifyServiceOrderdetails(moveOutCustomer,moveOutCustomer,moveInCustomer,"Not Scheduled",moveOutstart_dtfinalString,Task,LocationID);

		// Verifying Second order in the stack
		dashBoard.ClickServOrder2();
		moveOutCustomer ="Mr. Automation Mate";
		moveInCustomer =  "Mr. Alert Test (Customeralert01)";
		dashBoard.verifyServiceOrderdetails(moveOutCustomer,moveOutCustomer,moveInCustomer,"Not Scheduled",moveOutstart_dtfinalString,Task,LocationID);

		// Verifying Third Transfer order in the stack
		dashBoard.ClickServOrder3();
	   	moveOutCustomer = "Mr. Automation Mate";
		moveInCustomer = "Mr. Vacant Vacant (Vacant)";
		dashBoard.verifyServiceOrderdetails(moveOutCustomer,moveOutCustomer,moveInCustomer,"Not Scheduled",moveOutstart_dtfinalString,Task,LocationID);
		dashBoard.LogOut();
	}

}

