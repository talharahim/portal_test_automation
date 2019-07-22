package com.NexusPortalAutomation.PageObjects.Java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import junit.framework.Assert;

/**
 * 
 * All WebElements are identified by @FindBy annotation
 * 
 * @author Talha Rahim
 * @since 2019-07-10
 */
public class Dashboard_Transfers extends DashBoard {

	@FindBy(id = "ACTION_Transfer_Service")
	@CacheLookup
	WebElement ACTIONTransferService;

	@FindBy(id = "XFER_Select")
	@CacheLookup
	WebElement TransferType;

	@FindBy(id = "XFER_MoveFrom_Date_Picker_Requested")
	@CacheLookup
	WebElement TranferDateRequested;

	@FindBy(id = "CLO_Service_Order_Input")
	@CacheLookup
	WebElement SearchRequest;

	@FindBy(id = "XFER_Search_Input")
	WebElement DefaultCsutomer;

	@FindBy(id = "XFER_Description")
	WebElement Description;

	@FindBy(xpath = "//*[@id=\"mat-tab-label-2-1\"]/div")
	@CacheLookup
	WebElement MoveInTab;

	@FindBy(id = "XFER_Select_Option_1")
	@CacheLookup
	WebElement XFER_Select_Option_1;

	@FindBy(id = "XFER_Select_Option_2")
	@CacheLookup
	WebElement XFER_Select_Option_2;

	@FindBy(id = "XFER_Select_Option_3")
	@CacheLookup
	WebElement XFER_Select_Option_3;

	@FindBy(id = "XFER_Search_Option_1_Customer_Name")
	WebElement XFERSearchOption1CustomerName;

	@FindBy(id = "XFER_Search_Option_1")
	WebElement XFERSearchOption1;

	@FindBy(id = "XFER_MoveTo_Date_Picker_Requested")
	WebElement XFERMoveToDatePickerRequested;
	
	@FindBy(id = "XFER_MoveFrom_Date_Picker_Requested")
	WebElement XFERMoveFromDatePickerRequested;

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

	public String getRequestedSOcustomerName() {
		return SO_RequestedCusName.getText();
	}

	public String getMoveOutSOcustomerName() {
		return SO_MoveoutCusName.getText();
	}

	public String getMoveInSOcustomerName() {
		return SO_MoveInCusName.getText();
	}

	public String getMoveInSOcustomerNameDrillBackURL() {
		return SO_MoveInCusNameDrillback.getText();
	}

	public String getSOrequestedDate() {
		return SO_Requested_Date.getText();
	}

	public String getSOscheduledDate() {
		return SO_ScheduledDate.getText();
	}

	public String getSOTask2Description() {
		return SO_Task_2_Description.getText();
	}

	public String getSOTask3Description() {
		return SO_Task_3_Description.getText();
	}

	public String getSOTask4Description() {
		return SO_Task_4_Description.getText();
	}

	public String getSOTask5Description() {
		return SO_Task_5_Description.getText();
	}

	public String getSOTask6Description() {
		return SO_Task_6_Description.getText();
	}

	public String getSOTask1Description() {
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
		System.out.println("TEST DEFAULT VALUE FOR REQUEST===" + SearchRequest.getAttribute("value"));
		setElementText(SearchRequest, Request, "Search Request");
	}

	public void enterDefaultCustomer(String Customer) {
		System.out.println("TEST DEFAULT VALUE FOR CUSTOMER ===" + DefaultCsutomer.getAttribute("value"));
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
			VerifyString(Customer, Found);
		} else {
			Assert.assertTrue(Found, false);
		}

	}

	public void verifyDefaultCustomer(String Customer) {

		String Found = DefaultCsutomer.getAttribute("value");
		if (Found != "") {
			VerifyString(Customer, Found);
		} else {
			Assert.assertTrue(Found, false);
		}

	}

	public void enterDescription(String Desc) {
		setElementText(Description, Desc, "Description Request");
	}

	public void ClickMoveIn() {
		ClickElement(MoveInTab, "Move In");
	}

	public void clickActionDropDown_TransferService() {

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

		waitForObject(driver, XFERMoveToDatePickerRequested);
		setElementText(XFERMoveToDatePickerRequested, Date, "DatePicket");

	}
	
	public String Movin_getMoveOutRequestedDate() {

		waitForObject(driver, XFERMoveFromDatePickerRequested);
		System.out.println(XFERMoveFromDatePickerRequested.getAttribute("value"));
		return XFERMoveFromDatePickerRequested.getAttribute("value");

	}
	
	public String Movin_getMoveFromRequestedDate() {

		waitForObject(driver, XFERMoveToDatePickerRequested);
		System.out.println(XFERMoveToDatePickerRequested.getAttribute("value"));
		return XFERMoveToDatePickerRequested.getAttribute("value");

	}

	public void Movin_EnterRequest(String Request) {
		waitForObject(driver, CLOServiceOrderInput);
		setElementText(CLOServiceOrderInput, Request, "Service Order Input");

	}

	public void Movin_EnterLocation(String Location) {
		waitForObject(driver, XFERSearchInput);
		setElementText(XFERSearchInput, Location, "XFERSearchInput");
		ClickElement(XFERSearchOption1CustomerName, "XFER_Search_Option_1_Customer_Name");

	}

	public void Movin_EnterDescription(String Desc) {
		waitForObject(driver, XFERDescription);
		setElementText(XFERDescription, Desc, "XFER Description");

	}

	public void Click_MoveInSubmit() {
		waitForObject(driver, MoveInSubmit);
		ClickElement(MoveInSubmit, "MoveInSubmit Button");

	}

}
