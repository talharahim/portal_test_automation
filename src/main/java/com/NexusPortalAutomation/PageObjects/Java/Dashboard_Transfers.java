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

	@FindBy(id = "mat-tab-label-2-1")
	@CacheLookup
	WebElement MoveInTab;
	
	@FindBy(id = "XFER_Select_Option_1")
	@CacheLookup
	WebElement XFER_Select_Option_1;
	
	@FindBy(id = "XFER_Search_Option_1_Customer_Name")
	@CacheLookup
	WebElement XFER_Search_Option_1_Customer_Name;

	public Dashboard_Transfers(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void SelectTransferType_Transfer() {
		// Select combo box
		ClickElement(TransferType, "Transfer Combo");
	    ClickElement(XFER_Select_Option_1,"Transfer Option 1");

	}

	public void enterRequest(String Request) {
		setElementText(SearchRequest, Request, "Search Request");
	}

	public void enterDefaultCustomer(String Customer) {
		setElementText(DefaultCsutomer, Customer, "Customer Name Request");
		ClickElement(XFER_Search_Option_1_Customer_Name, "XFER_Search_Option_1_Customer_Name");
	}
	
	public void enterDescription(String Desc) {
		setElementText(Description, Desc, "Description Request");
	}
	
	public void ClickMoveIn()
	{
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

}
