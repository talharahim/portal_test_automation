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

	public String LocationID = "LOC@0004";
	public String LocationID2 = "LOC@0005";
	public String LocationID3 = "AUTOLOC001";
	public String LocationID4 = "STATEMENTS001";
	public String ServerURL = GetDrillBackServerURL();
	public String DefaultCustomer = "Mr. VACANT VACANT";
	public String requestedbY = "Mr. Automation Mate";
	public String moveOutCustomer = "Mr. Automation Mate";
	public String loc2moveOutCustomer = "Mr. Movein Cus";
	public String moveInCustomer = "Mr. Vacant Vacant (Vacant)";
	public String loc2moveInCustomer = "Mr. Automation Mate (0000011111)";
	public String Task1 = "Meter Reading-electric";
	public String Task2 = "Charge New Customer";
	public String Task3 = "Property Transfer";
	public String Task4 = "Deposit Request-new Customer";
	public String Task5 = "Deposit Payment-new Customer E";
	public String Task6 = "Prepayment Required-new Custom";
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
		Sql.DeleteServiceOrders(LocationID4);
		Sql.DeleteServiceOrdersHistory(LocationID4);
		login();
		dbSrch.EnterSearchText(LocationID);
		dbSrch.ClickCustomer();
		// Verify Customer Location Id Updated for Test
		ComMethd.VerifyString(LocationID, dashBoard.GetLoggedCustomerLocationId());
		dashBoard.clickActionDropDown();
		dashBoard.clickActionDropDown_TransferService();
		dashBoard.SelectTransferType_Transfer_Start();
		dashBoard.enterRequest("TRANSFER");
		dashBoard.enterScheduleDate_StartService(dashBoard.startService_getRequestedDate());
		String moveOutrequestedDate = dashBoard.startService_getRequestedDate();
		// Entering data for Move Out
		// Scroll down
		JavascriptExecutor jsx = (JavascriptExecutor) driver;
		jsx.executeScript("window.scrollBy(0,450)", "");
		String moveinCustomer = "Mr. Movein Cus";
		dashBoard.verifyDefaultCustomerStartService(DefaultCustomer);
		dashBoard.enterDefaultCustomerStartService(moveinCustomer);
		dashBoard.enterDescription("AUTOMATION TEST");
		// Entering data for Move In
		dashBoard.Click_MoveInSubmit();
		Thread.sleep(1000);
		dashBoard.ClickDone();
		// Verify Updated details IN SERVICE TAB order number from database
		dashBoard.ClickServiceOrderLink();
		dashBoard.ClickServOrder1();
		String ServiceOrder = dashBoard.getServiceOrderNumber();
		String ServiceOrderURL = dashBoard.getServiceOrderDrillbackURL();
		ComMethd.VerifyStringContains(ServiceOrderURL, ServiceOrder);
		String[] arrOfStr = moveOutrequestedDate.split(" ", 2);
		String moveOutstart_dt = arrOfStr[0];
		DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		Date date = (Date) formatter.parse(moveOutstart_dt);
		SimpleDateFormat newFormat = new SimpleDateFormat("MMM d, yyyy");
		String moveOutstart_dtfinalString = newFormat.format(date);
		ComMethd.VerifyString(dashBoard.getSOrequestedDate(), moveOutstart_dtfinalString);
		ComMethd.VerifyString(dashBoard.getSOscheduledDate(), moveOutstart_dtfinalString);
		log(ServiceOrder);
		Sql.VerifyServiceOrders(LocationID, ServiceOrder);
		dashBoard.clickrefreshPage();

		/*
		 * // Adding Second Service with two dates ahead of current date
		 */
		dashBoard.clickActionDropDown();
		dashBoard.clickActionDropDown_TransferService();
		dashBoard.SelectTransferType_Transfer_Start();
		dashBoard.verifyServiceWarningSingleSO(ServiceOrder);
		dashBoard.enterRequest("TRANSFER");
		Calendar c = Calendar.getInstance();
		c.setTime(newFormat.parse(moveOutstart_dtfinalString));
		c.add(Calendar.DAY_OF_MONTH, 2);
		// Date after adding the days to the given date
		String newDate = newFormat.format(c.getTime());
		// Displaying the new Date after addition of Days
		System.out.println("Date after Addition of two days " + newDate);
		// Entering date
		dashBoard.enterScheduleDate_StartService(newDate);
		// Entering data for Move Out
		// Scroll down
		jsx.executeScript("window.scrollBy(0,450)", "");
		moveInCustomer = "STATEMENT";
		dashBoard.verifyDefaultCustomerStartService(DefaultCustomer);
		dashBoard.enterDefaultCustomerStartService(moveInCustomer);
		dashBoard.enterDescription("AUTOMATION TEST");
		// Entering data for Move In
		dashBoard.Click_MoveInSubmit();
		Thread.sleep(1000);
		dashBoard.ClickDone();
		dashBoard.clickrefreshPage();
		dashBoard.ClickServiceOrderLink();
		dashBoard.ClickServOrder1();
		String ServiceOrder2 = dashBoard.getServiceOrderNumber();
		String ServiceOrderURL2 = dashBoard.getServiceOrderDrillbackURL();
		ComMethd.VerifyStringContains(ServiceOrderURL2, ServiceOrder2);
		ComMethd.VerifyString(dashBoard.getSOrequestedDate(), moveOutstart_dtfinalString);
		log(ServiceOrder2);
		Sql.VerifyServiceOrders(LocationID, ServiceOrder2);
		dashBoard.clickrefreshPage();

		/*
		 * // Adding Third Service Order having date between first two
		 */
		dashBoard.clickActionDropDown();
		dashBoard.clickActionDropDown_TransferService();
		dashBoard.SelectTransferType_Transfer_Start();
		dashBoard.verifyServiceWarningMultiSO(ServiceOrder2);
		dashBoard.enterRequest("TRANSFER");
		c = Calendar.getInstance();
		c.setTime(newFormat.parse(moveOutstart_dtfinalString));
		c.add(Calendar.DAY_OF_MONTH, 1);
		// Date after adding the days to the given date
		String newDate2 = newFormat.format(c.getTime());
		// Displaying the new Date after addition of Days
		System.out.println("Date after Addition of two days " + newDate2);
		// Entering date
		dashBoard.enterScheduleDate_StartService(newDate2);
		// Entering data for Move Out
		// Scroll down
		jsx.executeScript("window.scrollBy(0,450)", "");
		//
		moveInCustomer = "Alert";
		dashBoard.verifyDefaultCustomerStartService(DefaultCustomer);
		dashBoard.enterDefaultCustomerStartService(moveInCustomer);
		dashBoard.enterDescription("AUTOMATION TEST");
		// Entering data for Move In
		dashBoard.Click_MoveInSubmit();
		Thread.sleep(1000);
		dashBoard.ClickDone();
		dashBoard.clickrefreshPage();
		// Verify Updated details IN SERVICE TAB order number from database
		dashBoard.ClickServiceOrderLink();
		dashBoard.ClickServOrder1();
		String ServiceOrder3 = dashBoard.getServiceOrderNumber();
		String ServiceOrderURL3 = dashBoard.getServiceOrderDrillbackURL();
		ComMethd.VerifyStringContains(ServiceOrderURL3, ServiceOrder3);
		ComMethd.VerifyString(dashBoard.getSOrequestedDate(), moveOutstart_dtfinalString);
		log(ServiceOrder);

		// Verify First Service Order in the Stack
		moveOutCustomer = "Mr. Movein Cus";
		moveInCustomer = "Mr. Alert Test (Customeralert01)";
		ComMethd.VerifyString(dashBoard.getRequestedSOcustomerName(),moveOutCustomer);
		ComMethd.VerifyString(dashBoard.getMoveOutSOcustomerName(), moveOutCustomer);
		ComMethd.VerifyString(dashBoard.getMoveInSOcustomerName(), moveInCustomer);
		ComMethd.VerifyString(dashBoard.getSOscheduledDate(), newDate2);
		ComMethd.VerifyString(dashBoard.getSOTask1Description(), Task1);
		ComMethd.VerifyString(dashBoard.getSOTask2Description(), Task2);
		ComMethd.VerifyString(dashBoard.getSOTask3Description(), Task3);
		ComMethd.VerifyString(dashBoard.getSOTask4Description(), Task4);
		ComMethd.VerifyString(dashBoard.getSOTask5Description(), Task5);
		ComMethd.VerifyString(dashBoard.getSOTask6Description(), Task6);
		Sql.VerifyServiceOrders(LocationID, ServiceOrder3);

		// Verifying Second order in the stack
		dashBoard.ClickServOrder2();
		ComMethd.VerifyStringContains(ServiceOrderURL2, ServiceOrder2);
		ComMethd.VerifyString(dashBoard.getSOrequestedDate(), moveOutstart_dtfinalString);
		moveOutCustomer = "Mr. Alert Test";
		moveInCustomer = "Mr. Statement Pdf (Autostatement)";
		ComMethd.VerifyString(dashBoard.getRequestedSOcustomerName(),moveOutCustomer);
		ComMethd.VerifyString(dashBoard.getMoveOutSOcustomerName(), moveOutCustomer);
		ComMethd.VerifyString(dashBoard.getMoveInSOcustomerName(), moveInCustomer);
		ComMethd.VerifyString(dashBoard.getSOscheduledDate(), newDate);
		ComMethd.VerifyString(dashBoard.getSOTask1Description(), Task1);
		ComMethd.VerifyString(dashBoard.getSOTask2Description(), Task2);
		ComMethd.VerifyString(dashBoard.getSOTask3Description(), Task3);
		ComMethd.VerifyString(dashBoard.getSOTask4Description(), Task4);
		ComMethd.VerifyString(dashBoard.getSOTask5Description(), Task5);
		ComMethd.VerifyString(dashBoard.getSOTask6Description(), Task6);
		Sql.VerifyServiceOrders(LocationID, ServiceOrder2);

		// Verifying Third Transfer order in the stack
		dashBoard.ClickServOrder3();
		ComMethd.VerifyStringContains(ServiceOrderURL, ServiceOrder);
		ComMethd.VerifyString(dashBoard.getSOrequestedDate(), moveOutstart_dtfinalString);
		moveOutCustomer = "Mr. Automation Mate";
		moveInCustomer = "Mr. Movein Cus (Moveincus2)";
		ComMethd.VerifyString(dashBoard.getRequestedSOcustomerName(),moveOutCustomer);
		ComMethd.VerifyString(dashBoard.getMoveOutSOcustomerName(), moveOutCustomer);
		ComMethd.VerifyString(dashBoard.getMoveInSOcustomerName(), moveInCustomer);
		ComMethd.VerifyString(dashBoard.getSOscheduledDate(), moveOutstart_dtfinalString);
		ComMethd.VerifyString(dashBoard.getSOTask1Description(), Task1);
		ComMethd.VerifyString(dashBoard.getSOTask2Description(), Task2);
		ComMethd.VerifyString(dashBoard.getSOTask3Description(), Task3);
		ComMethd.VerifyString(dashBoard.getSOTask4Description(), Task4);
		ComMethd.VerifyString(dashBoard.getSOTask5Description(), Task5);
		ComMethd.VerifyString(dashBoard.getSOTask6Description(), Task6);
		Sql.VerifyServiceOrders(LocationID, ServiceOrder);
		dashBoard.LogOut();
	}

}
