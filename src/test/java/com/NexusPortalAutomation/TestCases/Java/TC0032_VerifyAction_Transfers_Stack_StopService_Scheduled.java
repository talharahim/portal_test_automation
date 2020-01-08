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

public class TC0032_VerifyAction_Transfers_Stack_StopService_Scheduled extends BaseClass {

	/*
	 * This test the search by Recent Customer Name
	 * 
	 * @author Talha Rahim
	 * 
	 * @version 1.0
	 * 
	 * @Since 2019-07-29
	 */

	public String locationId = getCellvalue("TC0032", "locationID");//"LOC@0004";
	public String locationId2 = getCellvalue("TC0032", "locationID2");//"LOC@0005";
	public String serverUrl = getDrillbackServerUrl();
	public String defaultCustomer =getCellvalue("TC0032", "defaultCustomer");// "Mr. VACANT VACANT";
	
	public String[] task = {"Meter Reading-electric", "Charge New Customer","Property Transfer", "Deposit Request-new Customer", "Deposit Payment-new Customer E","Prepayment Required-new Custom"};
	

//This Test will test the search by Customer ID
	@Test(priority = 1)
	public void VerifyTransferActionServiceOrder() throws IOException, InterruptedException, ClassNotFoundException,
			SQLServerException, SQLException, ParseException {
		DashBoardSearch dbSrch = new DashBoardSearch(driver);
		Dashboard_Transfers dashBoard = new Dashboard_Transfers(driver);
		MySQLDataExec sql = new MySQLDataExec();
		sql.deleteServiceorder(locationId);
		sql.deleteServiceorderHistory(locationId);
		sql.deleteServiceorder(locationId2);
		sql.deleteServiceorderHistory(locationId2);
		login();
		dbSrch.enterSearchText(locationId);
		dbSrch.clickCustomerName();
		// Verify Customer Location Id Updated for Test
		CommonMethods.verifyString(locationId, dashBoard.getLoggedCustomerLocationId());
		dashBoard.clickActionDropDown();
		dashBoard.clickActionDropDown_TransferService();
		dashBoard.selectTransferStop();
		String moveOutrequestedDate = dashBoard.startService_getRequestedDate();
		// Entering data for Move Out
		// Scroll down
		dashBoard.submitStartStopServiceTransferOrder( moveOutrequestedDate, "TRANSFER", defaultCustomer, defaultCustomer,"Description for Stop Service");
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
   		String moveInCustomer = "Mr. Automation Mate";
   		dashBoard.submitStartStopServiceTransferOrder(newDate, "TRANSFER", defaultCustomer, moveInCustomer, "Description for Move from Service");
		dashBoard.clickrefreshPage();
		dashBoard.clickServiceorderLink();
		dashBoard.clickServiceorder1();
		String serviceOrder2 = dashBoard.getserviceOrderNum();
		dashBoard.clickrefreshPage();
		
		/*
		// Adding Third Service Order having date between first two
		*/
		dashBoard.clickActionDropDown();
		dashBoard.clickActionDropDown_TransferService();
		dashBoard.selectTransferStop();
		dashBoard.verifyServiceWarningMultiSOStop(serviceOrder2);
		c = Calendar.getInstance();
		c.setTime(newFormat.parse(moveOutstart_dtfinalString));
		c.add(Calendar.DAY_OF_MONTH, 1);
		// Date after adding 1 day to the given date
		String newDate2 = newFormat.format(c.getTime());
		// Displaying the new Date after addition of Days
		moveInCustomer =  "MOVEIN";
		dashBoard.submitStartStopServiceTransferOrder(newDate2, "TRANSFER", defaultCustomer, moveInCustomer, "Description for Stop Service");
		dashBoard.clickrefreshPage();

	
		// Verify First Service Order in the Stack
		dashBoard.clickServiceorderLink();
		dashBoard.clickServiceorder1();
		String moveOutCustomer = "Mr. Vacant Vacant";
		moveInCustomer = "Mr. Movein Cus (Moveincus2)";
		dashBoard.verifyServiceOrderdetails(moveOutCustomer,moveOutCustomer,moveInCustomer,newDate2,moveOutstart_dtfinalString,task,locationId);

		// Verifying Second order in the stack
		dashBoard.clickServiceorder2();
		moveOutCustomer ="Mr. Movein Cus";
		moveInCustomer =  "Mr. Automation Mate (0000011111)";
		dashBoard.verifyServiceOrderdetails(moveOutCustomer,moveOutCustomer,moveInCustomer,newDate,moveOutstart_dtfinalString,task,locationId);

		// Verifying Third Transfer order in the stack
		dashBoard.clickServiceorder3();
	   	moveOutCustomer = "Mr. Automation Mate";
		moveInCustomer = "Mr. Vacant Vacant (Vacant)";
		dashBoard.verifyServiceOrderdetails(moveOutCustomer,moveOutCustomer,moveInCustomer,moveOutstart_dtfinalString,moveOutstart_dtfinalString,task,locationId);
		dashBoard.logout();
	}

}

