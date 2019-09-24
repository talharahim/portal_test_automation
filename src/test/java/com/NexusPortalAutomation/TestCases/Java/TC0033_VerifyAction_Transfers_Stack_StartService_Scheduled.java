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

public class TC0033_VerifyAction_Transfers_Stack_StartService_Scheduled extends BaseClass {

	/*
	 * This test the search by Recent Customer Name
	 * 
	 * @author Talha Rahim
	 * 
	 * @version 1.0
	 * 
	 * @Since 2019-07-29
	 */
	public String[] task = { "Meter Reading-electric", "Charge New Customer", "Property Transfer",
			"Deposit Request-new Customer", "Deposit Payment-new Customer E", "Prepayment Required-new Custom" };
	public String locationId = getCellvalue("TC0033", "locationID");//"LOC@0004";
	public String locationID3 = getCellvalue("TC0033", "locationID3");//"AUTOLOC001";
	public String locationID4 = getCellvalue("TC0033", "locationID4");//"STATEMENTS001";
	public String serverUrl = getDrillbackServerUrl();
	public String locationID = getCellvalue("TC0033", "locationID");//"LOC@0004";
	public String locationID2 = getCellvalue("TC0033", "locationID2");//"LOC@0005";
	public String defaultCustomer = getCellvalue("TC0033", "defaultCustomer");//"Mr. VACANT VACANT";
	public String requestedbY = getCellvalue("TC0033", "requestedbY");//"Mr. Automation Mate";
	public String moveOutCustomer = getCellvalue("TC0033", "moveOutCustomer");//"Mr. Automation Mate";
	public String loc2moveOutCustomer = getCellvalue("TC0033", "loc2moveOutCustomer");//"Mr. Movein Cus";
	public String moveInCustomer = getCellvalue("TC0033", "moveInCustomer");//"Mr. Vacant Vacant (Vacant)";
	public String loc2moveInCustomer = getCellvalue("TC0033", "loc2moveInCustomer");//"Mr. Automation Mate (0000011111)";
	public String task1 = getCellvalue("TC0033", "task1");//"Meter Reading-electric";
	public String task2 = getCellvalue("TC0033", "task2");//"Charge New Customer";
	public String task3 = getCellvalue("TC0033", "task3");//"Property Transfer";
	public String task4 = getCellvalue("TC0033", "task4");//"Deposit Request-new Customer";
	public String task5 = getCellvalue("TC0033", "task5");//"Deposit Payment-new Customer E";
	public String task6 = getCellvalue("TC0033", "task6");//"Prepayment Required-new Custom";
	public String message = getCellvalue("TC0033", "message");//"Transfer initiated";
	CommonMethods cmnMethods = new CommonMethods();

//This Test will test the search by Customer ID
	@Test(priority = 1)
	public void VerifyAction_Transfers_Stack_StartService_Scheduled() throws IOException, InterruptedException, ClassNotFoundException,
			SQLServerException, SQLException, ParseException {
		DashBoardSearch dbSrch = new DashBoardSearch(driver);
		Dashboard_Transfers dashBoard = new Dashboard_Transfers(driver);
		MySQLDataExec sql = new MySQLDataExec();
		sql.deleteServiceorder(locationId);
		sql.deleteServiceorderHistory(locationId);
		sql.deleteServiceorder(locationID2);
		sql.deleteServiceorderHistory(locationID2);
		sql.deleteServiceorder(locationID3);
		sql.deleteServiceorderHistory(locationID3);
		sql.deleteServiceorder(locationID4);
		sql.deleteServiceorderHistory(locationID4);
		login();
		dbSrch.enterSearchText(locationId);
		dbSrch.clickCustomerName();
		// Verify Customer Location Id Updated for Test
		cmnMethods.verifyString(locationId, dashBoard.getLoggedCustomerLocationId());
		dashBoard.clickActionDropDown();
		dashBoard.clickActionDropDown_TransferService();
		dashBoard.selectTransferStart();
		String moveOutrequestedDate = dashBoard.startService_getRequestedDate();
		// Entering data for Move Out
		// Scroll down
		String moveInCustomer = "MoveinCus";
		dashBoard.submitStartStopServiceTransferOrder(moveOutrequestedDate, moveOutrequestedDate, "TRANSFER",
				defaultCustomer, moveInCustomer,"Description for Start Service");
		// Verify Updated details IN SERVICE TAB order number from database
		dashBoard.clickServiceorderLink();
		dashBoard.clickServiceorder1();
		String ServiceOrder = dashBoard.getserviceOrderNum();
		dashBoard.clickrefreshPage();
		String[] arrOfStr = moveOutrequestedDate.split(" ", 2);
		String moveOutstart_dt = arrOfStr[0];
		DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		Date date = (Date) formatter.parse(moveOutstart_dt);
		SimpleDateFormat newFormat = new SimpleDateFormat("MMM d, yyyy");
		String moveOutstart_dtfinalString = newFormat.format(date);

		/*
		 * // Adding Second Service with two dates ahead of current date
		 */
		dashBoard.clickActionDropDown();
		dashBoard.clickActionDropDown_TransferService();
		dashBoard.selectTransferStart();
		dashBoard.verifyServiceWarningSingleSO(ServiceOrder);

		Calendar c = Calendar.getInstance();
		c.setTime(newFormat.parse(moveOutstart_dtfinalString));
		c.add(Calendar.DAY_OF_MONTH, 2);
		// Date after adding the days to the given date
		String newDate = newFormat.format(c.getTime());
		dashBoard.submitStartStopServiceTransferOrder(moveOutrequestedDate, newDate, "TRANSFER", defaultCustomer,
				moveInCustomer,"Description for Start Service");

		dashBoard.clickrefreshPage();
		dashBoard.clickServiceorderLink();
		
		dashBoard.clickServiceorder1();
		String ServiceOrder2 = dashBoard.getserviceOrderNum();
		String ServiceOrderURL2 = dashBoard.getServiceOrderDrillbackURL();
		cmnMethods.verifyStringContains(ServiceOrderURL2, ServiceOrder2);
		cmnMethods.verifyString(dashBoard.getSOrequestedDate(), moveOutstart_dtfinalString);
		log(ServiceOrder2);
		sql.verifyServiceOrders(locationId, ServiceOrder2);
		dashBoard.clickrefreshPage();

		/*
		 * // Adding Third Service Order having date between first two
		 */
		dashBoard.clickActionDropDown();
		dashBoard.clickActionDropDown_TransferService();
		dashBoard.selectTransferStart();
		dashBoard.verifyServiceWarningMultiSO(ServiceOrder2);
		dashBoard.enterRequest("TRANSFER");
		c = Calendar.getInstance();
		c.setTime(newFormat.parse(moveOutstart_dtfinalString));
		c.add(Calendar.DAY_OF_MONTH, 1);
		// Date after adding the days to the given date
		String newDate2 = newFormat.format(c.getTime());
		// Entering data for Move Out
		// Scroll down
		moveInCustomer = "Alert";
		dashBoard.submitStartStopServiceTransferOrder(moveOutrequestedDate, newDate2, "TRANSFER", defaultCustomer,
				moveInCustomer,"Description for Start Service");
		dashBoard.clickrefreshPage();

		dashBoard.clickServiceorder1();
		// Verify First Service Order in the Stack
		moveOutCustomer = "Mr. Movein Cus";
		moveInCustomer = "Mr. Alert Test (Customeralert01)";
		dashBoard.verifyServiceOrderdetails(moveOutCustomer, moveOutCustomer, moveInCustomer, newDate2,
				moveOutstart_dtfinalString, task, locationId);

		// Verifying Second order in the stack
		dashBoard.clickServiceorder2();
		cmnMethods.verifyStringContains(ServiceOrderURL2, ServiceOrder2);
		cmnMethods.verifyString(dashBoard.getSOrequestedDate(), moveOutstart_dtfinalString);
		moveOutCustomer = "Mr. Alert Test";
		moveInCustomer = "Mr. Movein Cus (Moveincus2)";
		dashBoard.verifyServiceOrderdetails(moveOutCustomer, moveOutCustomer, moveInCustomer, newDate,
				moveOutstart_dtfinalString, task, locationId);

		// Verifying Third Transfer order in the stack
		dashBoard.clickServiceorder3();
		moveOutCustomer = "Mr. Automation Mate";
		moveInCustomer = "Mr. Movein Cus (Moveincus2)";
		dashBoard.verifyServiceOrderdetails(moveOutCustomer, moveOutCustomer, moveInCustomer,
				moveOutstart_dtfinalString, moveOutstart_dtfinalString, task, locationId);
		dashBoard.logout();
	}

}
