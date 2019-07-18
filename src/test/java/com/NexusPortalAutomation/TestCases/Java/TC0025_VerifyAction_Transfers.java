package com.NexusPortalAutomation.TestCases.Java;

import java.io.IOException;
import java.sql.SQLException;

import org.testng.annotations.Test;

import com.NexusPortalAutomation.PageObjects.Java.DashBoardSearch;
import com.NexusPortalAutomation.PageObjects.Java.Dashboard_Transfers;
import com.NexusPortalAutomation.Utilities.Java.CommonMethods;
import com.NexusPortalAutomation.Utilities.Java.MySQLDataExec;
import com.microsoft.sqlserver.jdbc.SQLServerException;

public class TC0025_VerifyAction_Transfers extends BaseClass {

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
	public String ServerURL = GetDrillBackServerURL();
	CommonMethods ComMethd = new CommonMethods();

//This Test will test the search by Customer ID
	@Test(priority = 1)
	public void VerifyActionServiceOrder()
			throws IOException, InterruptedException, ClassNotFoundException, SQLServerException, SQLException {
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
		dashBoard.enterRequest("Transfer");
		//Move Out
		dashBoard.verifyDefaultCustomer(DefaultCustomer);
		dashBoard.enterDefaultCustomer(DefaultCustomer);
		dashBoard.enterDescription("AUTOMATION TEST");
		//Move In
		dashBoard.ClickMoveIn();
		dashBoard.Movin_EnterRequestDate("07/15/2019 07:52");
		dashBoard.Movin_EnterRequest("TRANSFER");
		dashBoard.Movin_EnterLocation(LocationID2);
		dashBoard.Movin_EnterDescription("Move in from location");
		dashBoard.Click_MoveInSubmit();
		Thread.sleep(1000);
		dashBoard.ClickDone();
		// Verify Updated details IN SERVICE TAB order number from database
		dashBoard.ClickServiceOrderLink();
		String ServiceOrder = dashBoard.getServiceOrderNumber();
		log(ServiceOrder);
		Sql.VerifyServiceOrders(LocationID, ServiceOrder);
		// Entering location ID 2 and verifying
		dashBoard.enterDashBoardSearch(LocationID2);
		dashBoard.clickDashBoardSearchResult1();
		dashBoard.ClickServiceOrderLink();
		ServiceOrder = dashBoard.getServiceOrderNumber();
		log(ServiceOrder);
		Sql.VerifyServiceOrders(LocationID2, ServiceOrder);
		dashBoard.LogOut();
	}

}
