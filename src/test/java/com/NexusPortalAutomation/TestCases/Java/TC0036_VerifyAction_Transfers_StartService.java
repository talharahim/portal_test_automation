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

public class TC0036_VerifyAction_Transfers_StartService extends BaseClass {

	/*
	 * This test the search by Recent Customer Name
	 * 
	 * @author Talha Rahim
	 * 
	 * @version 1.0
	 * 
	 * @Since 2019-07-29
	 */
	public String[] Task = { "Meter Reading-electric", "Charge New Customer", "Property Transfer",
			"Deposit Request-new Customer", "Deposit Payment-new Customer E", "Prepayment Required-new Custom" };
	public String locationID = getCellvalue("TC0036", "locationID");//"LOC@0004";
	public String locationID2 = getCellvalue("TC0036", "locationID2");//"LOC@0005";
	public String locationID3 = getCellvalue("TC0036", "locationID3");//"AUTOLOC001";
	public String locationID4 = getCellvalue("TC0036", "locationID4");//"STATEMENTS001";
	public String defaultCustomer = getCellvalue("TC0036", "defaultCustomer");//"Mr. VACANT VACANT";
	public String requestedbY = getCellvalue("TC0036", "requestedbY");//"Mr. Automation Mate";
	public String moveOutCustomer = getCellvalue("TC0036", "moveOutCustomer");//"Mr. Automation Mate";
	public String loc2moveOutCustomer = getCellvalue("TC0036", "loc2moveOutCustomer");//"Mr. Movein Cus";
	public String moveInCustomer = getCellvalue("TC0036", "moveInCustomer");//"Mr. Vacant Vacant (Vacant)";
	public String loc2moveInCustomer = getCellvalue("TC0036", "loc2moveInCustomer");//"Mr. Automation Mate (0000011111)";
	public String serverUrl = getDrillbackServerUrl();
	public String task1 = getCellvalue("TC0036", "task1");//"Meter Reading-electric";
	public String task2 = getCellvalue("TC0036", "task2");//"Charge New Customer";
	public String task3 = getCellvalue("TC0036", "task3");//"Property Transfer";
	public String task4 = getCellvalue("TC0036", "task4");//"Deposit Request-new Customer";
	public String task5 = getCellvalue("TC0036", "task5");//"Deposit Payment-new Customer E";
	public String task6 = getCellvalue("TC0036", "task6");//"Prepayment Required-new Custom";
	public String message = getCellvalue("TC0036", "message");//"Transfer initiated";
	CommonMethods cmnMethods = new CommonMethods();

//This Test will test the search by Customer ID
	@Test(priority = 1)
	public void VerifyTransferActionServiceOrder() throws IOException, InterruptedException, ClassNotFoundException,
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
		cmnMethods.verifyString(locationID, dashBoard.getLoggedCustomerLocationId());
		dashBoard.clickActionDropDown();
		dashBoard.clickActionDropDown_TransferService();
		dashBoard.selectTransferStart();
		String moveOutrequestedDate = dashBoard.startService_getRequestedDate();
		// Entering data for Move Out
		// Scroll down
		String moveInCustomer = "MoveinCus";
		dashBoard.submitStartStopServiceTransferOrder(moveOutrequestedDate, "", "TRANSFER",
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
		dashBoard.submitStartStopServiceTransferOrder(newDate, "", "TRANSFER", defaultCustomer,
				moveInCustomer,"Description for Start Service");

		dashBoard.clickrefreshPage();
		dashBoard.clickServiceorderLink();
		dashBoard.clickServiceorder2();
		String ServiceOrder2 = dashBoard.getserviceOrderNum();
		String ServiceOrderURL2 = dashBoard.getServiceOrderDrillbackURL();
		cmnMethods.verifyStringContains(ServiceOrderURL2, ServiceOrder2);
		cmnMethods.verifyString(dashBoard.getSOrequestedDate(), moveOutstart_dtfinalString);
		log(ServiceOrder2);
		sql.verifyServiceOrders(locationID, ServiceOrder2);
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
		dashBoard.submitStartStopServiceTransferOrder(newDate2, "", "TRANSFER", defaultCustomer,
				moveInCustomer,"Description for Start Service");
		dashBoard.clickrefreshPage();

		// Verify First Service Order in the Stack
		dashBoard.clickServiceOrder3();
		moveOutCustomer = "Mr. Automation Mate";
		moveInCustomer = "Mr. Alert Test (Customeralert01)";
		dashBoard.verifyServiceOrderdetails(moveOutCustomer, moveOutCustomer, moveInCustomer, "Not Scheduled",
				moveOutstart_dtfinalString, Task, locationID);

		// Verifying Second order in the stack
		dashBoard.clickServiceorder2();
		cmnMethods.verifyStringContains(ServiceOrderURL2, ServiceOrder2);
		cmnMethods.verifyString(dashBoard.getSOrequestedDate(), moveOutstart_dtfinalString);
		moveOutCustomer = "Mr. Automation Mate";
		moveInCustomer = "Mr. Movein Cus (Moveincus2)";
		dashBoard.verifyServiceOrderdetails(moveOutCustomer, moveOutCustomer, moveInCustomer,  "Not Scheduled",
				moveOutstart_dtfinalString, Task, locationID);

		// Verifying Third Transfer order in the stack
		dashBoard.clickServiceorder1();
		moveOutCustomer = "Mr. Automation Mate";
		moveInCustomer = "Mr. Movein Cus (Moveincus2)";
		dashBoard.verifyServiceOrderdetails(moveOutCustomer, moveOutCustomer, moveInCustomer,
				 "Not Scheduled", moveOutstart_dtfinalString, Task, locationID);
		dashBoard.logout();
	}

}
