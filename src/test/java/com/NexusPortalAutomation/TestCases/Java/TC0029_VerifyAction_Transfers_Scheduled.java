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

	public String locationID = "LOC@0004";
	public String locationID2 = "LOC@0005";
	public String defaultCustomer = "Mr. VACANT VACANT";
	public String requestedbY = "Mr. Automation Mate";
	public String moveOutCustomer = "Mr. Automation Mate";
	public String loc2moveOutCustomer = "Mr. Movein Cus";
	public String moveInCustomer = "Mr. Vacant Vacant (Vacant)";
	public String loc2moveInCustomer = "Mr. Automation Mate (0000011111)";
	public String serverUrl = getDrillbackServerUrl();
	public String Task1 = "Meter Reading-electric";
	public String Task2 = "Charge New Customer";
	public String Task3 = "Property Transfer";
	public String Task4 = "Deposit Request-new Customer";
	public String Task5 = "Deposit Payment-new Customer E";
	public String Task6 = "Prepayment Required-new Custom";
	CommonMethods cmnMethods = new CommonMethods();

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
		cmnMethods.verifyString(locationID, dashBoard.getLoggedCustomerLocationId());
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
		dashBoard.enterdefaultCustomer(defaultCustomer);
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
		cmnMethods.verifyStringContains(serviceOrderURL, serviceOrder);
		//
		cmnMethods.verifyString(dashBoard.getRequestedSOcustomerName(), requestedbY);
		// Get request Date and Compare
		String[] arrOfStr = moveInrequestedDate.split(" ", 2);
		String[] arrOfStr2 = moveOutrequestedDate.split(" ", 2);
		String moveOutstart_dt = arrOfStr[0];
		DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		Date date = (Date) formatter.parse(moveOutstart_dt);
		SimpleDateFormat newFormat = new SimpleDateFormat("MMM d, yyyy");
		String moveOutstart_dtfinalString = newFormat.format(date);

		cmnMethods.verifyString(dashBoard.getSOrequestedDate(), moveOutstart_dtfinalString);
		cmnMethods.verifyString(dashBoard.getSOscheduledDate(), moveOutstart_dtfinalString);
		cmnMethods.verifyString(dashBoard.getMoveOutSOcustomerName(), moveOutCustomer);
		cmnMethods.verifyString(dashBoard.getMoveInSOcustomerName(), moveInCustomer);
		cmnMethods.verifyString(dashBoard.getSOTask1Description(), Task1);
		cmnMethods.verifyString(dashBoard.getSOTask2Description(), Task2);
		cmnMethods.verifyString(dashBoard.getSOTask3Description(), Task3);
		cmnMethods.verifyString(dashBoard.getSOTask4Description(), Task4);
		cmnMethods.verifyString(dashBoard.getSOTask5Description(), Task5);
		cmnMethods.verifyString(dashBoard.getSOTask6Description(), Task6);
		log(serviceOrder);
		sql.verifyServiceOrders(locationID, serviceOrder);
		// Entering location ID 2 and verifying
		dashBoard.enterDashBoardSearch(locationID2);
		dashBoard.clickDashBoardSearchResult1();
		dashBoard.clickServiceorderLink();
		serviceOrder = dashBoard.getserviceOrderNum();
		serviceOrderURL = dashBoard.getServiceOrderDrillbackURL();
		cmnMethods.verifyStringContains(serviceOrderURL, serviceOrder);

		String moveInstart_dt = arrOfStr2[0];
		date = (Date) formatter.parse(moveInstart_dt);
		String moveInstart_dtfinalString = newFormat.format(date);
		cmnMethods.verifyString(dashBoard.getSOrequestedDate(), moveInstart_dtfinalString);
		cmnMethods.verifyString(dashBoard.getSOscheduledDate(), moveOutstart_dtfinalString);
		cmnMethods.verifyString(dashBoard.getMoveOutSOcustomerName(), loc2moveOutCustomer);
		cmnMethods.verifyString(dashBoard.getMoveInSOcustomerName(), loc2moveInCustomer);
		cmnMethods.verifyString(dashBoard.getSOTask1Description(), Task1);
		cmnMethods.verifyString(dashBoard.getSOTask2Description(), Task2);
		cmnMethods.verifyString(dashBoard.getSOTask3Description(), Task3);
		cmnMethods.verifyString(dashBoard.getSOTask4Description(), Task4);
		cmnMethods.verifyString(dashBoard.getSOTask5Description(), Task5);
		cmnMethods.verifyString(dashBoard.getSOTask6Description(), Task6);

		log(serviceOrder);
		sql.verifyServiceOrders(locationID2, serviceOrder);
		dashBoard.logout();
	}

}
