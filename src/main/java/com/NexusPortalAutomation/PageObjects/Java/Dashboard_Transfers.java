package com.NexusPortalAutomation.PageObjects.Java;

import java.sql.SQLException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.NexusPortalAutomation.Utilities.Java.MySQLDataExec;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import junit.framework.Assert;

/**
 * 
 * All WebElements are identified by @FindBy annotation
 * 
 * @author Talha Rahim
 * @since 2019-07-10
 */
public class Dashboard_Transfers extends DashBoard {

	public static String moveOutrequestedDate;
	MySQLDataExec Sql = new MySQLDataExec();

	@FindBy(id = "ACTION_Transfer_Service")
	WebElement ACTIONTransferService;

	@FindBy(id = "XFER_Select")
	WebElement TransferType;

	@FindBy(id = "XFER_MoveFrom_Date_Picker_Requested")
	WebElement TranferDateRequested;

	@FindBy(id = "CLO_Service_Order_Input")
	WebElement SearchRequest;

	@FindBy(id = "XFER_Search_Input")
	WebElement DefaultCsutomer;

	@FindBy(id = "XFER_Description")
	WebElement Description;

	// *[@id="mat-tab-label-2-1"]/div

	@FindBy(id = "XFER_MoveTo_Tab")
	WebElement MoveTo;

	@FindBy(id = "XFER_Select_Option_1")
	WebElement XFER_Select_Option_1;

	@FindBy(id = "XFER_Select_Option_2")
	WebElement XFER_Select_Option_2;

	@FindBy(id = "XFER_Select_Option_3")
	WebElement XFER_Select_Option_3;

	@FindBy(id = "XFER_Search_Option_1_Customer_Name")
	WebElement XFERSearchOption1CustomerName;

	@FindBy(id = "XFER_Search_Option_1")
	WebElement XFERSearchOption1;

	@FindBy(id = "XFER_MoveTo_Date_Picker_Requested")
	WebElement XFERMoveToDatePickerRequested;

	@FindBy(id = "XFER_MoveFrom_Date_Picker_Scheduled")
	public
	WebElement XFERMoveFromDatePickerScheduled;

	@FindBy(id = "XFER_MoveFrom_Date_Picker_Requested")
	WebElement XFERMoveFromDatePickerRequested;

	@FindBy(id = "XFER_MoveTo_Date_Picker_Scheduled")
	WebElement XFERMoveToDatePickerScheduled;

	@FindBy(id = "CLO_Service_Order_Input")
	WebElement CLOServiceOrderInput;

	@FindBy(id = "XFER_Search_Input")
	WebElement XFERSearchInput;

	@FindBy(id = "XFER_Description")
	WebElement XFERDescription;

	@FindBy(id = "XFER_Button_Action")
	WebElement MoveInSubmit;

	@FindBy(id = "XFER_Button_Done")
	WebElement XFERButtonDone;

	@FindBy(id = "SODV_Requested_By_Customer_Name")
	WebElement SO_RequestedCusName;

	@FindBy(id = "SODV_Move_Out_Customer_Name")
	WebElement SO_MoveoutCusName;

	@FindBy(id = "SODV_Move_In_Customer_Name")
	WebElement SO_MoveInCusName;

	@FindBy(id = "SODV_Move_In_Customer_Drillback")
	WebElement SO_MoveInCusNameDrillback;

	@FindBy(id = "SODV_Requested_Date")
	WebElement SO_Requested_Date;

	@FindBy(id = "SODV_Scheduled_Date")
	WebElement SO_ScheduledDate;

	@FindBy(id = "SODV_Task_1_Description")
	WebElement SO_Task_1_Description;

	@FindBy(id = "SODV_Task_2_Description")
	WebElement SO_Task_2_Description;

	@FindBy(id = "SODV_Task_3_Description")
	WebElement SO_Task_3_Description;

	@FindBy(id = "SODV_Task_4_Description")
	WebElement SO_Task_4_Description;

	@FindBy(id = "SODV_Task_5_Description")
	WebElement SO_Task_5_Description;

	@FindBy(id = "SODV_Task_6_Description")
	WebElement SO_Task_6_Description;

	@FindBy(id = "XFER_Date_Picker_Requested")
	WebElement XFERDatePickerRequested;

	@FindBy(id = "XFER_Date_Picker_Scheduled")
	WebElement XFERDatePickerScheduled;

	@FindBy(id = "SOLV_Service_Order_1")
	WebElement ServiceOrder1;

	@FindBy(id = "SOLV_Service_Order_2")
	WebElement ServiceOrder2;

	@FindBy(id = "SOLV_Service_Order_3")
	WebElement ServiceOrder3;

	@FindBy(id = "SOLV_Service_Order_4")
	WebElement ServiceOrder4;

	@FindBy(id = "SODV_Description")
	WebElement SODVDescription;

	@FindBy(xpath = "//div[@class='requiered-field text ng-star-inserted']")
	WebElement invalidDate;

	public String getInvalidDate() {
		waitForObject(driver, invalidDate);
		WaitAngular(driver);
		return getElementText(invalidDate, "Service Order invalidDate");

	}

	public String getServiceOrderDescription() {
		waitForObject(driver, SODVDescription);
		WaitAngular(driver);
		return getElementText(SODVDescription, "Service Order Description");

	}

	public void ClickServOrder1() {
		waitForObject(driver, ServiceOrder1);
		ClickElement(ServiceOrder1, "Clicking Service Order 1");
		WaitAngular(driver);

	}

	public void ClickServOrder2() {
		waitForObject(driver, ServiceOrder2);
		ClickElement(ServiceOrder2, "Clicking Service Order 2");
		WaitAngular(driver);

	}

	public void ClickServOrder3() {
		waitForObject(driver, ServiceOrder3);
		ClickElement(ServiceOrder3, "Clicking Service Order 3");
		WaitAngular(driver);

	}

	public void ClickServOrder4() {
		waitForObject(driver, ServiceOrder4);
		ClickElement(ServiceOrder4, "Clicking Service Order 4");

	}

	public void enterScheduleDate_StartService(String Date) {
		waitForObject(driver, XFERDatePickerScheduled);
		log("Enter Schedule Date Date");
		setElementText(XFERDatePickerScheduled, Date, "DatePicket");
	}

	public String getRequestedSOcustomerName() {
		log("get Requested Customer Name");
		return SO_RequestedCusName.getText();
	}

	public String getMoveOutSOcustomerName() {
		log("get Move Out Customer Date");
		return SO_MoveoutCusName.getText();
	}

	public String getMoveInSOcustomerName() {
		log("get Movein Customer Name Date");
		return SO_MoveInCusName.getText();
	}

	public String getMoveInSOcustomerNameDrillBackURL() {
		log("get Move In Suctomer DrillBackURL Date");
		return SO_MoveInCusNameDrillback.getText();
	}

	public String getSOrequestedDate() {
		log("get Requested Date");
		return SO_Requested_Date.getText();
	}

	public String getSOscheduledDate() {
		log("get Scheduled Date");
		return SO_ScheduledDate.getText();
	}

	public String getSOTask2Description() {
		log("get Task Description");
		return SO_Task_2_Description.getText();
	}

	public String getSOTask3Description() {
		log("get Task Description");
		return SO_Task_3_Description.getText();
	}

	public String getSOTask4Description() {
		log("get Task Description");
		return SO_Task_4_Description.getText();
	}

	public String getSOTask5Description() {
		log(SO_Task_5_Description.getText());
		return SO_Task_5_Description.getText();
	}

	public String getSOTask6Description() {
		log(SO_Task_6_Description.getText());
		return SO_Task_6_Description.getText();
	}

	public String getSOTask1Description() {
		log(SO_Task_1_Description.getText());
		return SO_Task_1_Description.getText();
	}

	public Dashboard_Transfers(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void ClickDone() {
		ClickElement(XFERButtonDone, "Done Button for Transfer");
	}

	public void SelectTransferType_Transfer() {
		// Select combo box
		ClickElement(TransferType, "Transfer Combo");
		ClickElement(XFER_Select_Option_1, "Transfer Option 1");

	}

	public void SelectTransferType_Transfer_Start() {
		// Select combo box
		ClickElement(TransferType, "Transfer Combo");
		ClickElement(XFER_Select_Option_2, "Transfer Option 2");

	}

	public void SelectTransferType_Transfer_Stop() {
		// Select combo box
		ClickElement(TransferType, "Transfer Combo");
		ClickElement(XFER_Select_Option_3, "Transfer Option 3");

	}

	public void enterRequest(String Request) {
		log(SearchRequest.getAttribute("value"));
		setElementText(SearchRequest, Request, "Search Request");
	}

	public void enterDefaultCustomer(String Customer) {
		log("TEST DEFAULT VALUE FOR CUSTOMER ===" + DefaultCsutomer.getAttribute("value"));
		setElementText(DefaultCsutomer, Customer, "Customer Name Request");
		ClickElement(XFERSearchOption1CustomerName, "XFER_Search_Option_1_Customer_Name");

	}

	public void enterDefaultCustomerStartService(String Customer) {
		setElementText(DefaultCsutomer, Customer, "Customer Name Request");
		ClickElement(XFERSearchOption1, "XFER_Search_Option_1_Customer_Name");

	}

	public void verifyDefaultCustomerStartService(String Customer) {
		String Found = DefaultCsutomer.getAttribute("value");
		if (Found != "") {
			verifyString(Customer, Found);
		} else {
			Assert.assertTrue(Found, false);
		}

	}

	public void verifyDefaultCustomer(String Customer) {

		String Found = DefaultCsutomer.getAttribute("value");
		if (Found != "") {
			verifyString(Customer, Found);
		} else {
			Assert.assertTrue(Found, false);
		}

	}

	public void enterDescription(String Desc) {
		setElementText(Description, Desc, "Description Request");
	}

	public void ClickMoveTo() throws InterruptedException {
		ClickElement(MoveTo, "Move To Tab (Transfers)");
	}

	public void clickActionDropDown_TransferService() throws InterruptedException {

		waitForObject(driver, ACTIONTransferService);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ClickElement(ACTIONTransferService, "Action Transfer Service Drop down");

	}

	public void Movin_EnterRequestDate(String Date) {
		log("Enter Request Date");
		waitForObject(driver, XFERMoveToDatePickerRequested);
		setElementText(XFERMoveToDatePickerRequested, Date, "DatePicket");

	}

	public void Movin_EnterMoveToScheduleDate(String Date) {

		log("Enter Schedule Date");
		waitForObject(driver, XFERMoveToDatePickerScheduled);
		setElementText(XFERMoveToDatePickerScheduled, Date, "DatePicket");

	}

	public void Movin_ScheduleDate(String Date) {

		log("Enter Schedule Date");
		waitForObject(driver, XFERMoveFromDatePickerScheduled);
		setElementText(XFERMoveFromDatePickerScheduled, Date, "DatePicket");

	}

	public String Movin_getMoveOutRequestedDate() {

		waitForObject(driver, XFERMoveFromDatePickerRequested);
		log(XFERMoveFromDatePickerRequested.getAttribute("value"));
		return XFERMoveFromDatePickerRequested.getAttribute("value");

	}

	public String Movin_getMoveFromRequestedDate() {

		waitForObject(driver, XFERMoveToDatePickerRequested);
		log(XFERMoveToDatePickerRequested.getAttribute("value"));
		return XFERMoveToDatePickerRequested.getAttribute("value");
	}

	public String startService_getRequestedDate() {

		waitForObject(driver, XFERDatePickerRequested);
		log(XFERDatePickerRequested.getAttribute("value"));
		return XFERDatePickerRequested.getAttribute("value");

	}

	public void Movin_EnterRequest(String Request) {
		waitForObject(driver, CLOServiceOrderInput);
		log("Enter Request Name");
		setElementText(CLOServiceOrderInput, Request, "Service Order Input");

	}

	public void Movin_EnterLocation(String Location) {
		waitForObject(driver, XFERSearchInput);
		setElementText(XFERSearchInput, Location, "XFERSearchInput");
		ClickElement(XFERSearchOption1CustomerName, "XFER_Search_Option_1_Customer_Name");

	}

	public void Movin_EnterDescription(String Desc) {
		log("Enter Request Description");
		waitForObject(driver, XFERDescription);
		setElementText(XFERDescription, Desc, "XFER Description");

	}

	public void Click_MoveInSubmit() {
		log("Click Submit");
		waitForObject(driver, MoveInSubmit);
		ClickElement(MoveInSubmit, "MoveInSubmit Button");

	}

	public void submitStartStopServiceTransferOrder(String startDate, String scheduleDate, String serviceName,
			String defaultCustomer, String requestCustomer, String description) throws InterruptedException {
		log("Submit Transfer Request");
		enterRequest("TRANSFER");
		enterScheduleDate_StartService(scheduleDate);
		JavascriptExecutor jsx = (JavascriptExecutor) driver;
		jsx = (JavascriptExecutor) driver;
		jsx.executeScript("window.scrollBy(0,450)", "");
		verifyDefaultCustomerStartService(defaultCustomer);
		if (!requestCustomer.isEmpty()) {
			enterDefaultCustomerStartService(requestCustomer);
		}
		enterDescription(description);
		// Entering data for Move In
		Click_MoveInSubmit();
		Thread.sleep(1000);
		ClickDone();

	}

	public void verifyServiceOrderdetails(String requester, String moveOutCustomer, String moveInCustomer,
			String scheduledate, String requestedDate, String[] Task, String locationID, String description)
			throws ClassNotFoundException, SQLServerException, SQLException {

		verifyString(getRequestedSOcustomerName(), requester);
		verifyString(getMoveOutSOcustomerName(), moveOutCustomer);
		verifyString(getMoveInSOcustomerName(), moveInCustomer);
		verifyString(getSOscheduledDate(), scheduledate);
		verifyString(getSOrequestedDate(), requestedDate);
		verifyString(getSOTask1Description(), Task[0]);
		verifyString(getSOTask2Description(), Task[1]);
		verifyString(getSOTask3Description(), Task[2]);
		verifyString(getSOTask4Description(), Task[3]);
		verifyString(getSOTask5Description(), Task[4]);
		verifyString(getSOTask6Description(), Task[5]);
		VerifyStringContains(getServiceOrderDrillbackURL(), getServiceOrderNumber());
		verifyString(getServiceOrderDescription(), description);
		Sql.VerifyServiceOrders(locationID, getServiceOrderNumber());
	}

	public void verifyServiceOrderdetails(String requester, String moveOutCustomer, String moveInCustomer,
			String scheduledate, String requestedDate, String[] Task, String locationID)
			throws ClassNotFoundException, SQLServerException, SQLException {

		verifyString(getRequestedSOcustomerName(), requester);
		verifyString(getMoveOutSOcustomerName(), moveOutCustomer);
		verifyString(getMoveInSOcustomerName(), moveInCustomer);
		verifyString(getSOscheduledDate(), scheduledate);
		verifyString(getSOrequestedDate(), requestedDate);
		verifyString(getSOTask1Description(), Task[0]);
		verifyString(getSOTask2Description(), Task[1]);
		verifyString(getSOTask3Description(), Task[2]);
		verifyString(getSOTask4Description(), Task[3]);
		verifyString(getSOTask5Description(), Task[4]);
		verifyString(getSOTask6Description(), Task[5]);
		VerifyStringContains(getServiceOrderDrillbackURL(), getServiceOrderNumber());
		Sql.VerifyServiceOrders(locationID, getServiceOrderNumber());
	}
}
