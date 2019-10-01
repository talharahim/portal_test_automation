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

public class TC0034_VerifyAction_Transfers_Stack_TwoLocations extends BaseClass {

	/*
	 * This test the search by Recent Customer Name
	 * 
	 * @author Talha Rahim
	 * 
	 * @version 1.0
	 * 
	 * @Since 2019-07-29
	 */

	public String locationID = getCellvalue("TC0034", "locationID");//"LOC@0004";
	public String locationID2 =getCellvalue("TC0034", "locationID2");// "LOC@0002";
	public String defaultCustomer = getCellvalue("TC0034", "defaultCustomer");//"Mr. VACANT VACANT";
	public String Message = getCellvalue("TC0034", "message");//"Transfer initiated";
	public String[] Task = {"Meter Reading-electric", "Charge New Customer","Property Transfer", "Deposit Request-new Customer", "Deposit Payment-new Customer E","Prepayment Required-new Custom"};
	CommonMethods cmnMethods = new CommonMethods();

//This Test will test the search by Customer ID
	@Test(priority = 1)
	public void VerifyAction_Transfers_Stack_TwoLocations() throws IOException, InterruptedException, ClassNotFoundException,
			SQLServerException, SQLException, ParseException {
		DashBoardSearch dbSrch = new DashBoardSearch(driver);
		Dashboard_Transfers dashBoard = new Dashboard_Transfers(driver);
		MySQLDataExec sql = new MySQLDataExec();
		sql.deleteServiceorder(locationID);
		sql.deleteServiceorderHistory(locationID);
		sql.deleteServiceorder(locationID2);
		sql.deleteServiceorderHistory(locationID2);
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
		dashBoard.submitStartStopServiceTransferOrder(moveOutrequestedDate, "TRANSFER", defaultCustomer, defaultCustomer,"Description for Stop Service");
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
   		String moveInCustomer = "Mr. Automation Mate";
   		dashBoard.submitStartStopServiceTransferOrder(newDate, "TRANSFER", defaultCustomer, moveInCustomer,"Description for Stop Service");
		dashBoard.clickrefreshPage();
		dashBoard.clickServiceorderLink();
		dashBoard.clickServiceorder1();
		//String ServiceOrder2 = dashBoard.getserviceOrderNum();
		dashBoard.clickrefreshPage();
		
		
		/*
		// Adding Thir Service with one day ahead of current date
		*/
		dashBoard.enterDashBoardSearch(locationID2);
		dashBoard.clickDashBoardSearchResult1();
		
		dashBoard.clickActionDropDown();
		dashBoard.clickActionDropDown_TransferService();
		dashBoard.selectTransferTypeTransfer();
		dashBoard.enterRequest("Transfer");
		// Move Out
		moveOutrequestedDate = dashBoard.Movin_getMoveOutRequestedDate();
		dashBoard.verifydefaultCustomer(defaultCustomer);
		dashBoard.enterdefaultCustomer(defaultCustomer);
		dashBoard.enterDescription("AUTOMATION TEST");
		// Move In
		dashBoard.ClickMoveTo();
		Calendar c1 = Calendar.getInstance();
		c1.add(Calendar.DAY_OF_MONTH, 1);
		// Date after adding the days to the given date
		String newDate2 = newFormat.format(c1.getTime());
		dashBoard.movinEnterMoveToScheduleDate(newDate2);
		dashBoard.movinEnterRequest("TRANSFER");
		dashBoard.movinEnterLocation(locationID);
		dashBoard.movinEnterDescription("Move in from location "+locationID);
		dashBoard.clickMoveInSubmit();
		Thread.sleep(1000);
		dashBoard.verifySubmitMessage(Message);
		dashBoard.clickDone();
		
		dashBoard.enterDashBoardSearch(locationID);
		dashBoard.clickDashBoardSearchResult1();
		//Navigate to Service Order
		dashBoard.clickrefreshPage();
		dashBoard.clickServiceorderLink();
		dashBoard.clickServiceorder1();
		String moveOutCustomer = "Mr. Vacant Vacant";
		moveInCustomer = "Mrs. Gail M Dewar (Customer010)";
		dashBoard.verifyServiceOrderdetails(moveOutCustomer,moveOutCustomer,moveInCustomer,newDate2,moveOutstart_dtfinalString,Task,locationID);
		
		//Verifying Service Order 2
		dashBoard.clickServiceorder2();
		moveOutCustomer = "Mrs. Gail M Dewar";
		moveInCustomer = "Mr. Automation Mate (0000011111)";
		dashBoard.verifyServiceOrderdetails(moveOutCustomer,moveOutCustomer,moveInCustomer,newDate,moveOutstart_dtfinalString,Task,locationID);
		// Verifying Third Transfer order in the stack
 		dashBoard.clickServiceorder3();
 	   	moveOutCustomer = "Mr. Automation Mate";
 		moveInCustomer = "Mr. Vacant Vacant (Vacant)";
		dashBoard.verifyServiceOrderdetails(moveOutCustomer,moveOutCustomer,moveInCustomer,moveOutstart_dtfinalString,moveOutstart_dtfinalString,Task,locationID);
		dashBoard.logout();
	}

}

