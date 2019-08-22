package com.NexusPortalAutomation.TestCases.Java;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import com.NexusPortalAutomation.PageObjects.Java.DashBoardSearch;
import com.NexusPortalAutomation.PageObjects.Java.Dashboard_Transfers;
import com.NexusPortalAutomation.Utilities.Java.CommonMethods;
import com.NexusPortalAutomation.Utilities.Java.MySQLDataExec;
import com.microsoft.sqlserver.jdbc.SQLServerException;

public class TC0029_VerifyAction_Transfers_Scheduled extends BaseClass {

	/*
	 * This test the search by Recent Customer Name
	 * 
	 * @author Talha Rahim
	 * 
	 * @version 1.0
	 * 
	 * @Since 2019-06-10
	 */

	public String LocationID = "LOC@0004";
	public String LocationID2 = "LOC@0005";
	public String DefaultCustomer = "Mr. VACANT VACANT";
	public String requestedbY = "Mr. Automation Mate";
	public String moveOutCustomer = "Mr. Automation Mate";
	public String loc2moveOutCustomer = "Mr. Movein Cus";
	public String moveInCustomer = "Mr. Vacant Vacant (Vacant)";
	public String loc2moveInCustomer = "Mr. Automation Mate (0000011111)";
	public String ServerURL = GetDrillBackServerURL();
	public String Task1 = "Meter Reading-electric";
	public String Task2 = "Charge New Customer";
	public String Task3 = "Property Transfer";
	public String Task4 = "Deposit Request-new Customer";
	public String Task5 = "Deposit Payment-new Customer E";
	public String Task6 = "Prepayment Required-new Custom";
	CommonMethods ComMethd = new CommonMethods();

//This Test will test the search by Customer ID
	@Test(priority = 1)
	public void VerifyActionServiceOrder() throws IOException, InterruptedException, ClassNotFoundException,
			SQLServerException, SQLException, ParseException {
		DashBoardSearch dbSrch = new DashBoardSearch(driver);
		Dashboard_Transfers dashBoard = new Dashboard_Transfers(driver);
		MySQLDataExec Sql = new MySQLDataExec();
		Sql.DeleteServiceOrders(LocationID);
		Sql.DeleteServiceOrders(LocationID2);
		Sql.DeleteServiceOrdersHistory(LocationID);
		Sql.DeleteServiceOrdersHistory(LocationID2);
		login();
		dbSrch.EnterSearchText(LocationID);
		dbSrch.ClickCustomer();
		// Verify Customer Location Id Updated for Test
		ComMethd.VerifyString(LocationID, dashBoard.GetLoggedCustomerLocationId());
		// Verify Contact is updated accordingly
		dashBoard.clickActionDropDown();

		dashBoard.clickActionDropDown_TransferService();
		dashBoard.SelectTransferType_Transfer();
		String moveOutrequestedDate = dashBoard.Movin_getMoveOutRequestedDate();
		String[] arrOfStr1 = moveOutrequestedDate.split(" ", 2);
		String moveOutstart_dt1 = arrOfStr1[0];
		DateFormat formatter1 = new SimpleDateFormat("MM/dd/yyyy");
		Date date1 = (Date) formatter1.parse(moveOutstart_dt1);
		SimpleDateFormat newFormat1 = new SimpleDateFormat("MMM d, yyyy");
		String moveOutstart_dtfinalString1 = newFormat1.format(date1);
		Calendar c1 = Calendar.getInstance();
		c1.setTime(newFormat1.parse(moveOutstart_dtfinalString1));
		c1.add(Calendar.DAY_OF_MONTH, -5);
		// Date after adding the days to the given date
		String beforeDate = newFormat1.format(c1.getTime());
		dashBoard.Movin_ScheduleDate(beforeDate);
		Thread.sleep(2000);

		// dashBoard.Movin_EnterRequestDate(beforeDate);
		dashBoard.VerifyString(dashBoard.getInvalidDate(), "Invalid date");
		Thread.sleep(2000);
		for (int i = 0; i < 19; i++) {

			dashBoard.XFERMoveFromDatePickerScheduled.sendKeys(Keys.BACK_SPACE);
		}
		Thread.sleep(2000);
		dashBoard.Movin_ScheduleDate(moveOutrequestedDate);

		dashBoard.enterRequest("Transfer");
		// Move Out

		dashBoard.verifyDefaultCustomer(DefaultCustomer);
		dashBoard.enterDefaultCustomer(DefaultCustomer);
		dashBoard.enterDescription("AUTOMATION TEST");

		// Move In

		dashBoard.ClickMoveTo();

		String moveInrequestedDate = dashBoard.Movin_getMoveFromRequestedDate();
		dashBoard.Movin_EnterMoveToScheduleDate(moveInrequestedDate);
		dashBoard.Movin_EnterRequest("TRANSFER");
		dashBoard.Movin_EnterLocation(LocationID2);
		dashBoard.Movin_EnterDescription("Move in from location");
		dashBoard.Click_MoveInSubmit();
		Thread.sleep(1000);
		dashBoard.ClickDone();
		// Verify Updated details IN SERVICE TAB order number from database
		dashBoard.ClickServiceOrderLink();
		// Verifying Service Order details
		String ServiceOrder = dashBoard.getServiceOrderNumber();
		String ServiceOrderURL = dashBoard.getServiceOrderDrillbackURL();
		ComMethd.VerifyStringContains(ServiceOrderURL, ServiceOrder);
		//
		ComMethd.VerifyString(dashBoard.getRequestedSOcustomerName(), requestedbY);
		// Get request Date and Compare
		String[] arrOfStr = moveInrequestedDate.split(" ", 2);
		String[] arrOfStr2 = moveOutrequestedDate.split(" ", 2);
		String moveOutstart_dt = arrOfStr[0];
		DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		Date date = (Date) formatter.parse(moveOutstart_dt);
		SimpleDateFormat newFormat = new SimpleDateFormat("MMM d, yyyy");
		String moveOutstart_dtfinalString = newFormat.format(date);

		ComMethd.VerifyString(dashBoard.getSOrequestedDate(), moveOutstart_dtfinalString);
		ComMethd.VerifyString(dashBoard.getSOscheduledDate(), moveOutstart_dtfinalString);
		ComMethd.VerifyString(dashBoard.getMoveOutSOcustomerName(), moveOutCustomer);
		ComMethd.VerifyString(dashBoard.getMoveInSOcustomerName(), moveInCustomer);
		ComMethd.VerifyString(dashBoard.getSOTask1Description(), Task1);
		ComMethd.VerifyString(dashBoard.getSOTask2Description(), Task2);
		ComMethd.VerifyString(dashBoard.getSOTask3Description(), Task3);
		ComMethd.VerifyString(dashBoard.getSOTask4Description(), Task4);
		ComMethd.VerifyString(dashBoard.getSOTask5Description(), Task5);
		ComMethd.VerifyString(dashBoard.getSOTask6Description(), Task6);
		log(ServiceOrder);
		Sql.VerifyServiceOrders(LocationID, ServiceOrder);
		// Entering location ID 2 and verifying
		dashBoard.enterDashBoardSearch(LocationID2);
		dashBoard.clickDashBoardSearchResult1();
		dashBoard.ClickServiceOrderLink();
		ServiceOrder = dashBoard.getServiceOrderNumber();
		ServiceOrderURL = dashBoard.getServiceOrderDrillbackURL();
		ComMethd.VerifyStringContains(ServiceOrderURL, ServiceOrder);

		String moveInstart_dt = arrOfStr2[0];
		date = (Date) formatter.parse(moveInstart_dt);
		String moveInstart_dtfinalString = newFormat.format(date);
		ComMethd.VerifyString(dashBoard.getSOrequestedDate(), moveInstart_dtfinalString);
		ComMethd.VerifyString(dashBoard.getSOscheduledDate(), moveOutstart_dtfinalString);
		ComMethd.VerifyString(dashBoard.getMoveOutSOcustomerName(), loc2moveOutCustomer);
		ComMethd.VerifyString(dashBoard.getMoveInSOcustomerName(), loc2moveInCustomer);
		ComMethd.VerifyString(dashBoard.getSOTask1Description(), Task1);
		ComMethd.VerifyString(dashBoard.getSOTask2Description(), Task2);
		ComMethd.VerifyString(dashBoard.getSOTask3Description(), Task3);
		ComMethd.VerifyString(dashBoard.getSOTask4Description(), Task4);
		ComMethd.VerifyString(dashBoard.getSOTask5Description(), Task5);
		ComMethd.VerifyString(dashBoard.getSOTask6Description(), Task6);

		log(ServiceOrder);
		Sql.VerifyServiceOrders(LocationID2, ServiceOrder);
		dashBoard.LogOut();
	}

}
