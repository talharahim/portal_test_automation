package com.NexusPortalAutomation.PageObjects.Java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

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
	@CacheLookup
	WebElement DefaultCsutomer;

	@FindBy(id = "XFER_Description")
	@CacheLookup
	WebElement Description;
	
	@FindBy(css = "#mat-tab-label-6-1")
	@CacheLookup
	WebElement MoveInTab;

	@FindBy(id = "XFER_Select_Option_1")
	@CacheLookup
	WebElement XFER_Select_Option_1;

	@FindBy(id = "XFER_Search_Option_1_Customer_Name")
	WebElement XFERSearchOption1CustomerName;
	
	@FindBy(id = "XFER_MoveTo_Date_Picker_Requested")
	@CacheLookup
	WebElement XFERMoveToDatePickerRequested;

	@FindBy(id = "CLO_Service_Order_Input")
	WebElement CLOServiceOrderInput;

	@FindBy(id = "XFER_Search_Input")
	WebElement XFERSearchInput;

	@FindBy(id = "XFER_Description")
	WebElement XFERDescription;

	@FindBy(id = "XFER_Button_Action")
	WebElement MoveInSubmit;

	public Dashboard_Transfers(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void SelectTransferType_Transfer() {
		// Select combo box
		ClickElement(TransferType, "Transfer Combo");
		ClickElement(XFER_Select_Option_1, "Transfer Option 1");

	}

	public void enterRequest(String Request) {
		setElementText(SearchRequest, Request, "Search Request");
	}

	public void enterDefaultCustomer(String Customer) {
		setElementText(DefaultCsutomer, Customer, "Customer Name Request");
		ClickElement(XFERSearchOption1CustomerName, "XFER_Search_Option_1_Customer_Name");
		
		
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
