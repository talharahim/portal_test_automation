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

	public String locationID = getCellvalue("TC0027", "locationID");//"LOC@0004";
	public String locationID2 = getCellvalue("TC0027", "locationID2");//"LOC@0005";
	public String defaultCustomer = getCellvalue("TC0027", "defaultCustomer");//"Mr. VACANT VACANT";
	public String requestedbY = getCellvalue("TC0027", "requestedbY");//"Mr. Automation Mate";
	public String moveOutCustomer = getCellvalue("TC0027", "moveOutCustomer");//"Mr. Automation Mate";
	public String loc2moveOutCustomer = getCellvalue("TC0027", "loc2moveOutCustomer");//"Mr. Movein Cus";
	public String moveInCustomer = getCellvalue("TC0027", "moveInCustomer");//"Mr. Vacant Vacant (Vacant)";
	public String loc2moveInCustomer = getCellvalue("TC0027", "loc2moveInCustomer");//"Mr. Automation Mate (0000011111)";
	public String serverUrl = getDrillbackServerUrl();
	public String task1 = getCellvalue("TC0027", "task1");//"Meter Reading-electric";
	public String task2 = getCellvalue("TC0027", "task2");//"Charge New Customer";
	public String task3 = getCellvalue("TC0027", "task3");//"Property Transfer";
	public String task4 = getCellvalue("TC0027", "task4");//"Deposit Request-new Customer";
	public String task5 = getCellvalue("TC0027", "task5");//"Deposit Payment-new Customer E";
	public String task6 = getCellvalue("TC0027", "task6");//"Prepayment Required-new Custom";
	public String message = getCellvalue("TC0027", "message");//"Transfer initiated";
	

//This Test will test the search by Customer ID
	@Test(priority = 1)
	public void VerifyActionServiceOrder() throws IOException, InterruptedException, ClassNotFoundException,
			SQLServerException, SQLException, ParseException {
		DashBoardSearch dbSrch = new DashBoardSearch(driver);
		Dashboard_Transfers dashBoard = new Dashboard_Transfers(driver);
		MySQLDataExec sql = new MySQLDataExec();
		sql.deleteServiceorder(locationID);
		sql.deleteServiceorder(locationID2);
		sql.deleteServiceorderHistory(locationID);
		sql.deleteServiceorderHistory(locationID2);
		login();
		dbSrch.enterSearchText(locationID);
		dbSrch.clickCustomerName();
		// Verify Customer Location Id Updated for Test
		CommonMethods.verifyString(locationID, dashBoard.getLoggedCustomerLocationId());
		// Verify Contact is updated accordingly
		dashBoard.clickActionDropDown();

		dashBoard.clickActionDropDown_TransferService();
		dashBoard.selectTransferTypeTransfer();
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
		dashBoard.moveinScheduledate(beforeDate);
		Thread.sleep(2000);

		// dashBoard.Movin_EnterRequestDate(beforeDate);
		dashBoard.verifyString(dashBoard.getInvalidDate(), "Invalid date");
		Thread.sleep(2000);
		for (int i = 0; i < 19; i++) {

			dashBoard.XFERMoveFromDatePickerScheduled.sendKeys(Keys.BACK_SPACE);
		}
		Thread.sleep(2000);
		dashBoard.moveinScheduledate(moveOutrequestedDate);

		dashBoard.enterRequest("Transfer");
		// Move Out

		dashBoard.verifydefaultCustomer(defaultCustomer);
		dashBoard.enterdefaultCustomerTransfer(defaultCustomer);
		dashBoard.enterDescription("AUTOMATION TEST");

		// Move In

		dashBoard.ClickMoveTo();

		String moveInrequestedDate = dashBoard.Movin_getMoveFromRequestedDate();
		dashBoard.movinEnterMoveToScheduleDate(moveInrequestedDate);
		dashBoard.movinEnterRequest("TRANSFER");
		dashBoard.movinEnterLocation(locationID2);
		dashBoard.movinEnterDescription("Move in from location");
		dashBoard.clickMoveInSubmit();
		Thread.sleep(1000);
		dashBoard.clickDone();
		// Verify Updated details IN SERVICE TAB order number from database
		dashBoard.clickServiceorderLink();
		// Verifying Service Order details
		String serviceOrder = dashBoard.getserviceOrderNum();
		String serviceOrderURL = dashBoard.getServiceOrderDrillbackURL();
		CommonMethods.verifyStringContains(serviceOrderURL, serviceOrder);
		//
		CommonMethods.verifyString(dashBoard.getRequestedSOcustomerName(), requestedbY);
		// Get request Date and Compare
		String[] arrOfStr = moveInrequestedDate.split(" ", 2);
		String[] arrOfStr2 = moveOutrequestedDate.split(" ", 2);
		String moveOutstart_dt = arrOfStr[0];
		DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		Date date = (Date) formatter.parse(moveOutstart_dt);
		SimpleDateFormat newFormat = new SimpleDateFormat("MMM d, yyyy");
		String moveOutstart_dtfinalString = newFormat.format(date);

		CommonMethods.verifyString(dashBoard.getSOrequestedDate(), moveOutstart_dtfinalString);
		CommonMethods.verifyString(dashBoard.getSOscheduledDate(), moveOutstart_dtfinalString);
		CommonMethods.verifyString(dashBoard.getMoveOutSOcustomerName(), moveOutCustomer);
		CommonMethods.verifyString(dashBoard.getMoveInSOcustomerName(), moveInCustomer);
		CommonMethods.verifyString(dashBoard.getSOTask1Description(), task1);
		CommonMethods.verifyString(dashBoard.getSOTask2Description(), task2);
		CommonMethods.verifyString(dashBoard.getSOTask3Description(), task3);
		CommonMethods.verifyString(dashBoard.getSOTask4Description(), task4);
		CommonMethods.verifyString(dashBoard.getSOTask5Description(), task5);
		CommonMethods.verifyString(dashBoard.getSOTask6Description(), task6);
		log(serviceOrder);
		sql.verifyServiceOrders(locationID, serviceOrder);
		// Entering location ID 2 and verifying
		dashBoard.enterDashBoardSearch(locationID2);
		dashBoard.clickDashBoardSearchResult1();
		dashBoard.clickServiceorderLink();
		serviceOrder = dashBoard.getserviceOrderNum();
		serviceOrderURL = dashBoard.getServiceOrderDrillbackURL();
		CommonMethods.verifyStringContains(serviceOrderURL, serviceOrder);

		String moveInstart_dt = arrOfStr2[0];
		date = (Date) formatter.parse(moveInstart_dt);
		String moveInstart_dtfinalString = newFormat.format(date);
		CommonMethods.verifyString(dashBoard.getSOrequestedDate(), moveInstart_dtfinalString);
		CommonMethods.verifyString(dashBoard.getSOscheduledDate(), moveOutstart_dtfinalString);
		CommonMethods.verifyString(dashBoard.getMoveOutSOcustomerName(), loc2moveOutCustomer);
		CommonMethods.verifyString(dashBoard.getMoveInSOcustomerName(), loc2moveInCustomer);
		CommonMethods.verifyString(dashBoard.getSOTask1Description(), task1);
		CommonMethods.verifyString(dashBoard.getSOTask2Description(), task2);
		CommonMethods.verifyString(dashBoard.getSOTask3Description(), task3);
		CommonMethods.verifyString(dashBoard.getSOTask4Description(), task4);
		CommonMethods.verifyString(dashBoard.getSOTask5Description(), task5);
		CommonMethods.verifyString(dashBoard.getSOTask6Description(), task6);

		log(serviceOrder);
		sql.verifyServiceOrders(locationID2, serviceOrder);
		dashBoard.logout();
	}

}
