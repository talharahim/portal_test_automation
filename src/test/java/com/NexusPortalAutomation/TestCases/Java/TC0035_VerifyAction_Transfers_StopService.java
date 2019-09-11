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

	public String locationID = "LOC@0004";
	public String locationID2 = "LOC@0005";
	public String locationID3 = "TESTLOCATION02";
	public String serverUrl = getDrillbackServerUrl();
	public String defaultCustomer = "Mr. VACANT VACANT";
	
	public String[] Task = {"Meter Reading-electric", "Charge New Customer","Property Transfer", "Deposit Request-new Customer", "Deposit Payment-new Customer E","Prepayment Required-new Custom"};
	CommonMethods cmnMethods = new CommonMethods();

//This Test will test the search by Customer ID
	@Test(priority = 1)
	public void VerifyAction_Transfers_StopService() throws IOException, InterruptedException, ClassNotFoundException,
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
		login();
		dbSrch.enterSearchText(locationID);
		dbSrch.clickCustomerName();
		// Verify Customer Location Id Updated for Test
		cmnMethods.verifyString(locationID, dashBoard.getLoggedCustomerLocationId());
		dashBoard.clickActionDropDown();
		dashBoard.clickActionDropDown_TransferService();
		dashBoard.selectTransferStop();
		String moveOutrequestedDate = dashBoard.startService_getRequestedDate();
		// Entering data for Move Out
		// Scroll down
		dashBoard.submitStartStopServiceTransferOrder(moveOutrequestedDate, "", "TRANSFER", defaultCustomer, defaultCustomer, "Description for Stop Service");
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
   		String moveInCustomer = "TestCust";
   		dashBoard.submitStartStopServiceTransferOrder(newDate, "", "TRANSFER", defaultCustomer, moveInCustomer,"Description for Stop Service");
		dashBoard.clickrefreshPage();
		dashBoard.clickServiceorderLink();
		dashBoard.clickServiceorder2();
		String ServiceOrder2 = dashBoard.getserviceOrderNum();
		dashBoard.clickrefreshPage();
		/*
		// Adding Third Service Order having date between first two
		*/
		dashBoard.clickActionDropDown();
		dashBoard.clickActionDropDown_TransferService();
		dashBoard.selectTransferStop();
		dashBoard.verifyServiceWarningMultiSO(ServiceOrder2);
		c = Calendar.getInstance();
		c.setTime(newFormat.parse(moveOutstart_dtfinalString));
		c.add(Calendar.DAY_OF_MONTH, 1);
		// Date after adding 1 day to the given date
		String newDate2 = newFormat.format(c.getTime());
		// Displaying the new Date after addition of Days
		moveInCustomer =  "MOVEIN";
		dashBoard.submitStartStopServiceTransferOrder(newDate2, "", "TRANSFER", defaultCustomer, moveInCustomer,"Description for Stop Service");
		dashBoard.clickrefreshPage();

	
		// Verify First Service Order in the Stack
		dashBoard.clickServiceorderLink();
		dashBoard.clickServiceOrder3();
		String moveOutCustomer = "Mr. Automation Mate";
		moveInCustomer = "Mr. Movein Cus (Moveincus2)";
		dashBoard.verifyServiceOrderdetails(moveOutCustomer,moveOutCustomer,moveInCustomer,"Not Scheduled",moveOutstart_dtfinalString,Task,locationID);

		// Verifying Second order in the stack
		dashBoard.clickServiceorder2();
		moveOutCustomer ="Mr. Automation Mate";
		moveInCustomer =  "Mr. Test Mid Customer Suf (Testcustomer1)";
		dashBoard.verifyServiceOrderdetails(moveOutCustomer,moveOutCustomer,moveInCustomer,"Not Scheduled",moveOutstart_dtfinalString,Task,locationID);

		// Verifying Third Transfer order in the stack
		dashBoard.clickServiceorder1();
	   	moveOutCustomer = "Mr. Automation Mate";
		moveInCustomer = "Mr. Vacant Vacant (Vacant)";
		dashBoard.verifyServiceOrderdetails(moveOutCustomer,moveOutCustomer,moveInCustomer,"Not Scheduled",moveOutstart_dtfinalString,Task,locationID);
		dashBoard.logout();
	}

}

