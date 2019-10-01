package com.NexusPortalAutomation.PageObjects.Java;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.NexusPortalAutomation.Utilities.Java.CommonMethods;

/**
 * 
 * All WebElements are identified by @FindBy annotation
 * 
 * @author Talha Rahim
 * @since 2019-04-25
 */

public class DashBoard extends CommonMethods {

	public boolean HighLight = false;

	WebDriver driver;
	@FindBy(id = "USR_Name")
	WebElement LoggedUserLink;

	@FindBy(id = "ACTION_Logout")
	WebElement logoutLink;

	@FindBy(id = "'LOC_Location_Id'")
	WebElement CustomerLocId;

	@FindBy(id = "CUST_Customer_Id")
	WebElement CustomerId;

	@FindBy(id = "CUST_First_Last_Name")
	WebElement CustomerName;

	@FindBy(id = "'LOC_Address_City'")
	@CacheLookup
	WebElement customerAddressCity;

	@FindBy(id = "'LOC_Address_State'")
	@CacheLookup
	WebElement customerAddressState;

	@FindBy(id = "'LOC_Address_ZipCode'")
	@CacheLookup
	WebElement customerAddressZip;

	@FindBy(id = "ALERTO_Action_Button")
	WebElement AlertOk;

	@FindBy(id = "ALERT_1_Description")
	@CacheLookup
	WebElement AlertDesc;

	@FindBy(id = "BILL_Past_Due")
	WebElement BILL_PastDue;

	@FindBy(id = "BILL_Current_Balance")
	WebElement BILL_CurrentBalance;

	@FindBy(id = "BILL_Unposted_Balance")
	WebElement BILL_UnpostedBalance;

	@FindBy(id = "BILL_Account_Balance")
	WebElement BILL_AccountBalance;

	@FindBy(id = "BILL_Installment_Budget")
	WebElement BILL_Installment;

	@FindBy(id = "BILL_Over_Short")
	WebElement BILL_Over_Short;

	@FindBy(id = "SERV_Service_1_1")
	WebElement Service1;

	@FindBy(id = "SERV_Service_2_1")
	WebElement Service1Tab;

	@FindBy(id = "SERV_Service_1_2")
	WebElement Service2;

	@FindBy(id = "SERV_Service_3_1")
	WebElement Service2Tab;

	@FindBy(id = "SERV_Service_1_3")
	WebElement Service3;

	@FindBy(id = "SERV_Service_4_1")
	WebElement Service3Tab;

	@FindBy(id = "SERV_Service_1_4")
	WebElement Service4;

	@FindBy(css = "#mat-tab-label-0-1 > div:nth-child(1)")
	@CacheLookup
	WebElement TransactionLink;

	@FindBy(css = "#mat-tab-label-0-2 > div")
	@CacheLookup
	WebElement ServiceOrderLink;

	@FindBy(id = "SODV_Service_Order_Id")
	WebElement serviceOrderNum;

	@FindBy(css = "#mat-tab-label-0-0 > div:nth-child(1)")
	@CacheLookup
	WebElement SummaryLink;

	@FindBy(id = "'LOC_Address_Line'")
	@CacheLookup
	WebElement AddressLine;

	@FindBy(id = "'LOC_Address_City'")
	@CacheLookup
	WebElement AddressCity;

	@FindBy(id = "'LOC_Address_State'")
	@CacheLookup
	WebElement AddressState;

	@FindBy(id = "'LOC_Address_ZipCode'")
	@CacheLookup
	WebElement AddressZipCode;

	@FindBy(id = "SRCH_Accounts_Label")
	@CacheLookup
	WebElement AccountDropdown;

	@FindBy(id = "SRCH_Accounts")
	@CacheLookup
	WebElement AccountSearchText;

	@FindBy(id = "SRCH_Accounts_Result1")
	WebElement AccountSearchResult1;

	@FindBy(id = "SRCH_Accounts_Result2")
	WebElement AccountSearchResult2;

	@FindBy(id = "SRCH_Accounts_Result3")
	WebElement AccountSearchResult3;

	@FindBy(id = "SRCH_Accounts_Result4")
	WebElement AccountSearchResult4;

	@FindBy(id = "CUST_SSN")
	@CacheLookup
	WebElement CustomerSSN;

	@FindBy(id = "CUST_Drivers_License")
	@CacheLookup
	WebElement DriverLic;

	@FindBy(id = "CUST_Phone_Number_1")
	WebElement Phone1;

	@FindBy(id = "CUST_Phone_Number_Ext_1")
	WebElement PhoneExt1;

	@FindBy(id = "'CUST_Email'")
	WebElement Email;

	@FindBy(id = "'CUST_No_Email'")
	WebElement NoEmail;

	@FindBy(id = "'CUST_Address_Line'")
	WebElement AddressLine1;

	@FindBy(id = "'CUST_Address_City_State_Zip'")
	WebElement AddressCityStateZip;

	@FindBy(id = "ACTION_BOOKMARK")
	WebElement BookMarkIconEnabled;

	@FindBy(id = "ACTION_BOOKMARK_Selected")
	WebElement BookMarkIconDisabled;

	@FindBy(id = "credit-great")
	WebElement creditGreat;

	@FindBy(id = "'CUST_Drillback_Button'")
	WebElement ContactEdit;

	@FindBy(id = "ECI_Phone_Number_1")
	WebElement ContactPhone1;

	@FindBy(id = "ECI_Email")
	WebElement ContactEmail1;

	@FindBy(id = "ECI_Action_Button")
	WebElement ContactUpdateBtn;

	@FindBy(id = "SCUST_Label")
	WebElement SecondCust;

	@FindBy(id = "SCUST_1_Customer_Name")
	WebElement SecondCustName;

	@FindBy(id = "SCUST_Label")
	WebElement SecondCustCnt;

	@FindBy(id = "'CL_Note'")
	WebElement Notes;

	@FindBy(id = "CL_Action_Button")
	WebElement SubmitNotes;

	@FindBy(id = "'CL_Historical_Note_Additional_Text'")
	WebElement AddedNotes;

	@FindBy(id = "BILL_Amount_Due")
	WebElement BILL_Amount_Due;

	@FindBy(id = "BILL_Statement_Button")
	WebElement BILLStatementBtn;

	@FindBy(id = "BILL_Statement_1")
	WebElement BILLStatement1;
	// *[@id=""]

	@FindBy(id = "BILL_Auto_Pay")
	WebElement AutoPay;

	@FindBy(id = "BILL_E_Bill")
	WebElement EBill;

	@FindBy(id = "BILL_Deposit_Amount")
	WebElement DepositAmount;

	@FindBy(id = "BILL_Statement_1")
	WebElement BillStatementDate;

	@FindBy(id = "BILL_Statement_Value_1")
	WebElement BillStatementValue;

	@FindBy(className = "cdk-overlay-container")
	WebElement OverLay;

	@FindBy(id = "SERV_Tab_Type_1_Icon")
	@CacheLookup
	WebElement ServElectricIcon;

	@FindBy(id = "SERV_Tab_Type_2_Icon")
	@CacheLookup
	WebElement ServGasIcon;

	@FindBy(id = "SERV_Tab_Type_3_Icon")
	@CacheLookup
	WebElement ServInternetIcon;

	@FindBy(id = "ACTION_Drillback")
	@CacheLookup
	WebElement CustDrillBack;

	@FindBy(id = "SCUST_Drillback")
	@CacheLookup
	WebElement SecondayCustDrillBack;

	@FindBy(id = "SERV_Tab_Drillback")
	@CacheLookup
	WebElement ServiceTabDrillBack;

	@FindBy(id = "ACCIT_1_Drillback")
	@CacheLookup
	WebElement contLogTabDrillBack;

	@FindBy(id = "ACTION_Button")
	@CacheLookup
	WebElement actionDropDown;

	@FindBy(id = "SOLV_Select_Date_Range")
	@CacheLookup
	WebElement ServOrder_dateDropDown;

	@FindBy(id = "SOLV_Select_Date_Range_Option_4")
	@CacheLookup
	WebElement ServOrder_Anytime;

	@FindBy(id = "SOLV_Service_Order_1_Request_Id")
	@CacheLookup
	WebElement ServOrder_Order_RequestID;

	@FindBy(id = "SOLV_Service_Order_1_Description")
	@CacheLookup
	WebElement SOLV_Service_Order_Description;

	@FindBy(id = "SOLV_Service_Order_1_Scheduled_Date")
	@CacheLookup
	WebElement SOLV_Service_Order_Scheduled_Date;

	@FindBy(id = "SODV_Service_Order_Id")
	@CacheLookup
	WebElement SOLV_Service_Order_Id;

	@FindBy(id = "SODV_Status")
	@CacheLookup
	WebElement SODV_Status;

	@FindBy(id = "SODV_Description_Request")
	@CacheLookup
	WebElement SODV_Description_Request;

	@FindBy(id = "SODV_Request_Id")
	@CacheLookup
	WebElement SODV_Request_Id;
	// done
	@FindBy(id = "SODV_Requested_Date")
	@CacheLookup
	WebElement SODV_Requested_Date;

	@FindBy(id = "SODV_Requested_Time")
	@CacheLookup
	WebElement SODV_Requested_Time;

	@FindBy(id = "SODV_Scheduled_Date")
	@CacheLookup
	WebElement SODV_Scheduled_Date;

	@FindBy(id = "SODV_Scheduled_Time")
	@CacheLookup
	WebElement SODV_Scheduled_Time;

	@FindBy(id = "SODV_Task_1_Description")
	@CacheLookup
	WebElement SODV_Task_Description;

	@FindBy(id = "SODV_Task_1_Employee_Id")
	@CacheLookup
	WebElement SODV_Task_Employee_Id;

	@FindBy(id = "SODV_Task_1_Completed_Date")
	@CacheLookup
	WebElement SODV_Task_Completed_Date;

	@FindBy(id = "SRCH_Button_Favorites")
	@CacheLookup
	WebElement Dashboard_BookMark;

	@FindBy(id = "SRCH_Option_1_Location_Id")
	@CacheLookup
	WebElement Dashboard_BookMarkedLocation;

	@FindBy(id = "SODV_Drillback")
	@CacheLookup
	WebElement ServiceOerder_Drillback;

	@FindBy(id = "CUST_Title")
	@CacheLookup
	WebElement Customer_title;

	@FindBy(id = "ACTION_Payment")
	@CacheLookup
	WebElement Action_Payment;

	@FindBy(id = "ACTION_Service_Order")
	@CacheLookup
	WebElement Action_ServiceOrder;

	@FindBy(id = "REC_1_Document_Type")
	WebElement Recent_Record1_Type;

	@FindBy(id = "REC_2_Document_Type")
	@CacheLookup
	WebElement Recent_Record2_Type;

	@FindBy(id = "REC_1_Document_Date")
	@CacheLookup
	WebElement Recent_Record1_Date;

	@FindBy(id = "REC_2_Document_Date")
	@CacheLookup
	WebElement Recent_Record2_Date;

	@FindBy(id = "REC_1_Amount")
	@CacheLookup
	WebElement Recent_Record1_Amount;

	@FindBy(id = "REC_2_Amount")
	@CacheLookup
	WebElement Recent_Record2_Amount;

	@FindBy(id = "REC_Footer_Button_Label")
	@CacheLookup
	WebElement Recent_ViewAll;

	@FindBy(id = "TRAN_Title")
	@CacheLookup
	WebElement TransactionPage_title;

	@FindBy(id = "SOACT_Search_Input")
	@CacheLookup
	WebElement SOACTSearchInput;

	@FindBy(id = "SOACT_Date_Picker_Requested")
	@CacheLookup
	WebElement SOACTDateRequested;

	@FindBy(id = "SOACT_Date_Picker_Scheduled")
	@CacheLookup
	WebElement SOACTDateScheduled;

	@FindBy(id = "SOACT_Description")
	@CacheLookup
	WebElement SOACTDescription;

	@FindBy(id = "SOACT_Button_Action")
	@CacheLookup
	WebElement SOACTButtonAction;

	@FindBy(id = "SOACT_Button_Done")
	@CacheLookup
	WebElement SOACTButtonDone;

	@FindBy(id = "XFER_Button_Done")
	@CacheLookup
	WebElement XFERButtonDone;

	@FindBy(id = "SOACT_Search_Option_1_Request_Id")
	@CacheLookup
	WebElement SOACTSearchOption1;

	@FindBy(className = "transfer-success-message")
	@CacheLookup
	WebElement transferSuccessMessage;

	@FindBy(id = "SRCH_Input")
	@CacheLookup
	WebElement DashboardSearch;

	@FindBy(id = "SRCH_Option_1_Customer_Name")
	WebElement DashboardSearchResult1Name;

	@FindBy(id = "SRCH_Option_1_Customer_Id")
	WebElement DashboardSearchResult1CustomerId;

	@FindBy(id = "SRCH_Option_1_Location_Id")
	WebElement DashboardSearchResult1Location;

	@FindBy(id = "ACTION_Refresh_Page")
	WebElement RefreshButton;

	@FindBy(id = "ENH_Result_1_Message")
	WebElement CustomerNotes;

	@FindBy(id = "ENH_Result_2_Message")
	WebElement LocationNotes;

	@FindBy(id = "CUST_Credit_Rating")
	WebElement CreditRating;

	@FindBy(xpath = "/html/body/wo-root/wo-dashboard/div/mat-drawer-container/mat-drawer-content/div/div/div[2]/csm-customer-balances/csm-generic-widget/div/div/div[2]/div[1]/div[2]/div[1]/div[1]")
	WebElement BudgetIcon;

	@FindBy(xpath = "//div[contains(text(),'No Other Accounts')]")
	WebElement NoOtherAccounts;

	@FindBy(xpath = "/html/body/wo-root/wo-dashboard/div/mat-drawer-container/mat-drawer-content/div/div/div[2]/csm-customer-balances/csm-generic-widget/div/div/div[2]/div[2]/div/div[1]/a[2]")
	WebElement AutoPayURL;

	@FindBy(xpath = "//span[contains(text(),'Payment Arrangement Due')]")
	WebElement PaymentArrangementDue;

	@FindBy(xpath = "/html/body/wo-root/wo-dashboard/div/mat-drawer-container/mat-drawer-content/div/div/div[2]/csm-customer-balances/csm-generic-widget/div/div/div[2]/div[1]/div[3]/div[1]/a")
	WebElement PaymentArrangementDueURL;

	@FindBy(id = "BILL_Installment_SPA")
	WebElement PaymentArrangementDueAmount;

	@FindBy(id = "BILL_Budget")
	WebElement BILLBudget;

	public String getBillBudgetURL() {

		waitForObject(driver, BILLBudget);
		log("get Payments Arrangement Due", driver);
		return BILLBudget.getAttribute("href");
	}

	public String getPaymentArrangementDueAmount() {

		waitForObject(driver, PaymentArrangementDueAmount);
		log("get Payments Arrangement Due", driver);
		return PaymentArrangementDueAmount.getText();
	}

	public String getPaymentArrangementDue() {

		waitForObject(driver, PaymentArrangementDue);
		log("get Payments Arrangement Due", driver);
		return PaymentArrangementDue.getText();
	}

	public String getPaymentArrangementDueURL() {

		log("get Payments Arrangement Due", driver);
		return PaymentArrangementDueURL.getAttribute("href");
	}

	public String getNoOtherAccount() {
		return NoOtherAccounts.getText();
	}

	public String GetBudgetIcon() {
		log("This will verify budget icon");
		return BudgetIcon.getText();

	}

	public void verifyEnhancedNotes(String LocNotes,String CusNotes) {

		verifyString(getElementText(CustomerNotes, "Customer Notes"), CusNotes);
		verifyString(getElementText(LocationNotes, "Location Notes"), LocNotes);
		log("VerifyEnhancedNotes", driver);

	}

	public void clickrefreshPage() throws InterruptedException {

		waitForObject(driver, RefreshButton);
		ClickElement(RefreshButton, "Refresh Button");
		log("Refresh Page", driver);
		Thread.sleep(1000);
	}

	public void enterDashBoardSearch(String SearchText) {

		waitForObject(driver, DashboardSearch);
		setElementText(DashboardSearch, SearchText, "Search Text");
		log("Search Text", driver);
	}

	public String getDashBoardSearchResult1Name() {

		waitForObject(driver, DashboardSearchResult1Name);
		log("Get DashBoard Search Result", driver);
		return DashboardSearchResult1Name.getText();
	}

	public void clickDashBoardSearchResult1() {

		waitForObject(driver, DashboardSearchResult1Name);
		DashboardSearchResult1Name.click();
		log("Click DashBoard Search Result ", driver);
		WaitAngular(driver);
	}

	public String getDashBoardSearchResult1CustomerId() {

		waitForObject(driver, DashboardSearchResult1CustomerId);
		log("Click DashBoard Search Result Customer Id", driver);
		return DashboardSearchResult1CustomerId.getText();
	}

	public String getDashBoardSearchResult1Location() {

		waitForObject(driver, DashboardSearchResult1Location);
		log("Click DashBoard Search Result Location", driver);
		return DashboardSearchResult1Location.getText();
	}

	public void submitServiceRequest(String SearchInput, String DateRequested, String DateScheduled,
			String DateDescription) {
		// todo
		log("Entering Service Name");
		setElementText(SOACTSearchInput, SearchInput, "Service Name");
		if (SOACTSearchOption1.isDisplayed()) {
			SOACTSearchOption1.click();
		}
		log("Entering Date Requested");
		setElementText(SOACTDateRequested, DateRequested, "Date Description");
		log("Entering Date Scheduled");
		setElementText(SOACTDateScheduled, DateScheduled, "Date Scheduled");
		log("Entering Date Description");
		setElementText(SOACTDescription, DateDescription, "Date Description");
		log("Click Action Button");
		ClickElement(SOACTButtonAction, "Action Button");
		log("Submit Service Request", driver);

	}

	public void ClickSerOrderDne() {
		ClickElement(SOACTButtonDone, "Done Button");
	}

	public void verifySubmitMessage(String Message) {
		if (transferSuccessMessage.isDisplayed()) {
			verifyStringContains(transferSuccessMessage.getText(), Message);
		} else {
			Assert.fail("Order not submitted");
		}
	}

	public void submitTransferServiceRequest(String SearchInput, String DateRequested, String DateScheduled,
			String DateDescription) {
		// todo
		log("Entering Service Name");
		setElementText(SOACTSearchInput, SearchInput, "Service Name");
		if (SOACTSearchOption1.isDisplayed()) {
			SOACTSearchOption1.click();
		}
		log("Entering Date Requested");
		setElementText(SOACTDateRequested, DateRequested, "Date Description");
		log("Entering Date Scheduled");
		setElementText(SOACTDateScheduled, DateScheduled, "Date Scheduled");
		log("Entering Date Description");
		setElementText(SOACTDescription, DateDescription, "Date Description");
		log("Click Action Button");
		ClickElement(SOACTButtonAction, "Action Button");

		if (transferSuccessMessage.isDisplayed()) {
			verifyString(transferSuccessMessage.getText(), "Service successfully Started");
			ClickElement(SOACTButtonDone, "Done Button");
		} else {
			Assert.fail("Order not submitted");
		}

	}

	public void verifyRecentRecord1(String Type, String Date, String Amount) {
		log("Verifying Recent Records");
		verifyString(Type, getElementText(Recent_Record1_Type, "Recent Record Type"));
		verifyString(Date, getElementText(Recent_Record1_Date, "Recent Record Date"));
		verifyString(Amount, getElementText(Recent_Record1_Amount, "Recent Record Amount"));

	}

	public void verifyRecentRecord2(String Type, String Date, String Amount) {
		log("Verifying Recent Records");
		verifyString(Type, getElementText(Recent_Record2_Type, "Recent Record Type"));
		verifyString(Date, getElementText(Recent_Record2_Date, "Recent Record Date"));
		verifyString(Amount, getElementText(Recent_Record2_Amount, "Recent Record Amount"));

	}

	public void clickRecentSearch_ViewAll() {
		ClickElement(Recent_ViewAll, "Recent View All");
	}

	public String getTransactionPageTitle() {
		return getElementText(TransactionPage_title, "Transaction Page title");
	}

	public void clickDashBoardBookMark() {

		waitForObject(driver, Dashboard_BookMark);
		ClickElement(Dashboard_BookMark, "Dashboard BookMark Clicked");

	}

	public String getDashBoardBookMarkValue() {

		waitForObject(driver, Dashboard_BookMarkedLocation);
		return Dashboard_BookMarkedLocation.getText();

	}

	public String getCustomertitle() {
		waitForObject(driver, Customer_title);
		return getElementText(Customer_title, "Customertitle");

	}

	public HashMap<String, String> GetServiceOrderDetails() {
		// This method will fetch the service order details and returns it in a map
		WaitAngular(driver);
		log("Verifying Service Order Details using HashMap");
		HashMap<String, String> SrvcOrderInfo = new HashMap<String, String>();
		SrvcOrderInfo.put("serviceOrderReqId", ServOrder_Order_RequestID.getText());
		SrvcOrderInfo.put("serviceOrderDescription", SOLV_Service_Order_Description.getText());
		SrvcOrderInfo.put("serviceOrderScheduledDate", SOLV_Service_Order_Scheduled_Date.getText());
		SrvcOrderInfo.put("solvserviceOrderId", SOLV_Service_Order_Id.getText());
		SrvcOrderInfo.put("sodvStatus", SODV_Status.getText());
		SrvcOrderInfo.put("sodvDescriptionRequest", SODV_Description_Request.getText());
		SrvcOrderInfo.put("sodvRequestId", SODV_Request_Id.getText());
		SrvcOrderInfo.put("sodvRequestedDate", SODV_Requested_Date.getText());
		SrvcOrderInfo.put("sodvRequestedTime", SODV_Requested_Time.getText());
		SrvcOrderInfo.put("sodvScheduledDate", SODV_Scheduled_Date.getText());
		SrvcOrderInfo.put("sodvScheduledTime", SODV_Scheduled_Time.getText());
		SrvcOrderInfo.put("sodvTaskDescription", SODV_Task_Description.getText());
		SrvcOrderInfo.put("sodvTaskEmployeeId", SODV_Task_Employee_Id.getText());
		SrvcOrderInfo.put("sodvTaskCompletedDate", SODV_Task_Completed_Date.getText());
		return SrvcOrderInfo;

	}

	public void ServOrd_SelectDateAnyTime() {
		ClickElement(ServOrder_dateDropDown, "Date Drop Down");
		log("Date Drop Down Clicked");
		ClickElement(ServOrder_Anytime, "Any Time");
		log("All time date selected");
		WaitAngular(driver);
	}

	public void ClickElement(WebElement element, String ElementName) {

		try {

			waitForObject(driver, element);
			if (element.isDisplayed()) {
				element.click();
				WaitAngular(driver);
			}
			log("Click " + ElementName, driver);
			WaitAngular(driver);

		} catch (NoSuchElementException e) {
			log(e.getMessage());
			Assert.fail(ElementName + " not found");

		}
	}

	public String getElementText(WebElement element, String ElementName) {

		try {
			waitForObject(driver, element);
			WaitAngular(driver);
			log("got Text " + ElementName + " = " + element.getText(), driver);
			return element.getText().trim();

		} catch (NoSuchElementException e) {
			log(e.getMessage(), driver);
			Assert.assertTrue(false, ElementName + " not found");

		}
		return null;
	}

	public void setElementText(WebElement element, String Text, String ElementName) {

		try {

			waitForObject(driver, element);
			log("Setting Text on " + ElementName + " with Text = " + Text, driver);
			WaitAngular(driver);
			element.clear();
			if (element.isDisplayed() && element.isEnabled()) {
				element.sendKeys(Text);
			} else {
				Assert.fail(ElementName + " not enabled or visible");
			}

		} catch (NoSuchElementException e) {
			log(e.getMessage(), driver);
			Assert.fail(ElementName + " not found");

		}

	}

	public void clickActionDropDown() {
		log("Click Action Dropdown", driver);
		waitForObject(driver, actionDropDown);
		ClickElement(actionDropDown, "Action Drop down");

	}

	public void clickActionDropDown_Payment() {
		log("Click Action Dropdown Payments", driver);
		waitForObject(driver, Action_Payment);
		ClickElement(Action_Payment, "Action Payment Drop down");

	}

	public void clickActionDropDown_ServiceOrder() {

		waitForObject(driver, Action_ServiceOrder);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log("Click Action Dropdown Service Order", driver);
		ClickElement(Action_ServiceOrder, "Action Service Order Drop down");

	}

	public WebElement findElementByid(String id) {

		WebElement element = driver.findElement(By.id(id));

		try {
			waitForObject(driver, element);

		} catch (NoSuchElementException e) {
			log(e.getMessage());
			Assert.assertTrue(false, "Element not found using id " + id);

		}
		return element;
	}

	public WebElement findElementByxpath(String id) {

		WebElement element = driver.findElement(By.xpath(id));

		try {
			waitForObject(driver, element);

		} catch (NoSuchElementException e) {
			if (!element.isDisplayed()) {
				log(e.getMessage());
				Assert.fail("Element not found using xpath " + id);
			}

		}
		return element;
	}

	// This method will find the elements of Action Panel using the URL
	public void VerifyActionDrillBacks(String Csharing, String Cmemo, String Depo, String Misc, String PayAr,
			String PayExt, String Void, String ContLog, String Mreader) throws InterruptedException {
		Thread.sleep(1000);
		findElementByid("ACTION_Cashiering").getAttribute(Csharing);
		findElementByid("ACTION_Credit_Memo").getAttribute(Cmemo);
		findElementByid("ACTION_Deposit").getAttribute(Depo);
		findElementByid("ACTION_Misc._Charge").getAttribute(Misc);
		findElementByid("ACTION_Payment_Arrangement").getAttribute(PayAr);
		findElementByid("ACTION_Payment_Extension").getAttribute(PayExt);
		findElementByid("ACTION_Void").getAttribute(Void);
		findElementByid("ACTION_Contact_Log").getAttribute(Mreader);
		findElementByid("ACTION_Meter_Reading").getAttribute(ContLog);
		log("Verify Action Drillbacks", driver);

	}

	public void verifyDrillback(String ElementID, String drillBackURL) throws InterruptedException {
		Thread.sleep(1000);

		log("Verifying Drill back for " + drillBackURL, driver);
		findElementByid(ElementID).getAttribute(drillBackURL);
	}

	// This method will find the elements of Transaction Panel using the URL
	public void verifyTransDrillbacks(String payment, String bill, String meter) throws InterruptedException {
		Thread.sleep(1000);
		findElementByid("TRAN_1_Drillback").getAttribute(payment);
		findElementByid("TRAN_2_Drillback").getAttribute(bill);
		findElementByid("TRAN_3_Drillback").getAttribute(meter);
		log("Verify Transfer Drillback", driver);

	}

	// This method will find the elements of Transaction Panel using the URL
	public void verifyNotesDrillbacks() throws InterruptedException {
		Thread.sleep(1000);
		findElementByid("ENH_Drillback_Location");
		findElementByid("customer-person");
		findElementByid("ENH_Title");
		log("Verify Notes Drillback ", driver);

	}

	// This method will find the elements of Transaction Panel using the URL
	public void verifyServiceorderDrillbacks(String ServOrder) throws InterruptedException {
		Thread.sleep(1000);
		waitForObject(driver, ServiceOerder_Drillback);
		ServiceOerder_Drillback.getAttribute(ServOrder);
		log("Verify Service Order Drillback", driver);

	}

	public String getContLogDrillBackUrl() {
		try {
			waitForObject(driver, contLogTabDrillBack);

		} catch (NoSuchElementException e) {
			log(e.getMessage());
			Assert.assertTrue(false, "Contat Log Drillback not found");
		}
		return contLogTabDrillBack.getAttribute("href");
	}

	public String GetCustDrillBackUrl() {
		try {
			waitForObject(driver, CustDrillBack);

		} catch (NoSuchElementException e) {
			log(e.getMessage());
			Assert.assertTrue(false, "Customer Drillback not found");
		}
		return CustDrillBack.getAttribute("href");
	}

	public void verifyServiceWarningSingleSO(String serviceOrder) {
		verifyString(findElementByid("XFER_Warning_Message").getText(), "Service Order Exist. TRANSFER");
		verifyStringContains(findElementByid("XFER_Warning_Drillback").getAttribute("href"), serviceOrder);

	}

	public void verifyServiceWarningMultiSO(String serviceOrder) {
		verifyString(findElementByid("XFER_Warning_Message").getText(), "Multiple Service Orders Exist. TRANSFER");
		verifyStringContains(findElementByid("XFER_Warning_Drillback").getAttribute("href"), serviceOrder);

	}

	public void verifyServiceWarningSOExists(String serviceOrder) {
		verifyString(findElementByid("XFER_Warning_Message").getText(), "Service Order Exist. TRANSFER");
		verifyStringContains(findElementByid("XFER_Warning_Drillback").getAttribute("href"), serviceOrder);

	}

	public String GetSecondCustDrillBackUrl() {
		try {
			waitForObject(driver, SecondayCustDrillBack);

		} catch (NoSuchElementException e) {
			log(e.getMessage());
			Assert.fail("Seconday Customer Drillback not found");
		}
		return SecondayCustDrillBack.getAttribute("href");
	}

	public String GetServiceTabDrillBackUrl() {
		try {
			waitForObject(driver, ServiceTabDrillBack);

		} catch (NoSuchElementException e) {
			log(e.getMessage());
			Assert.fail("Service Drillback not found");
		}
		return ServiceTabDrillBack.getAttribute("href");
	}

	public DashBoard(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void ClickServElecIcon() {
		log("Click Service Electric Dropdown", driver);
		waitForObject(driver, ServElectricIcon);
		ClickElement(ServElectricIcon, "Electric Icon");
	}

	public void ClickServGasIcon() {

		log("Click Service Gas Dropdown", driver);
		waitForObject(driver, ServGasIcon);
		ClickElement(ServGasIcon, "Gas Icon");

	}

	public void ClickServInternetIcon() {
		log("Click Service Internet Dropdown", driver);
		waitForObject(driver, ServInternetIcon);
		ClickElement(ServInternetIcon, "Internet Icon");

	}

	public String getAutoPay() {
		String result = "OFF";
		try {
			waitForObject(driver, AutoPay);
			if (!(getElementText(AutoPay, "AutoPay Switch")).equals("OFF")) {
				result = "ON";
			}
		} catch (NoSuchElementException e) {
			log(e.getMessage());
			Assert.assertTrue(false, "BILL Statement Button not found");
		}
		log("get Service AutpPay");
		return result;
	}

	public String getAutoPayURL() {
		String result = null;
		try {
			waitForObject(driver, AutoPayURL);
			if (AutoPayURL.isDisplayed()) {
				result = AutoPayURL.getAttribute("href");
			}
		} catch (NoSuchElementException e) {
			log(e.getMessage());
			Assert.fail("Auto Pay URL not found");
		}
		log("get Service AutpPay");
		return result;
	}

	public String getDepositAmount() {
		String result = "";
		try {
			waitForObject(driver, DepositAmount);
			if (!getElementText(DepositAmount, "Get Deposit Amount").equals("")) {
				result = DepositAmount.getText();
			}
		} catch (NoSuchElementException e) {
			log(e.getMessage());
			Assert.assertTrue(false, "BILL Statement Button not found");
		}
		log("Get Deposit Amount");
		return result;
	}

	public String getEBill() {
		String result = "OFF";
		try {
			waitForObject(driver, EBill);
			if (!getElementText(EBill, "EBill Swtich ").equals("OFF")) {
				result = "ON";
			}
		} catch (NoSuchElementException e) {
			log(e.getMessage());
			Assert.assertTrue(false, "BILL Statement Button not found");
		}
		log("Get Electronic Bill Status");
		return result;
	}

	public void ClickBillStatementBtn() {
		log("Click Bill Statement Button");
		WaitAngular(driver);
		ClickElement(BILLStatementBtn, "Bill Statement Button");

	}

	public void ClickBillStatement() {
		log("Click Bill Statement");
		waitForObject(driver, BILLStatement1);
		ClickElement(BILLStatement1, "Statement");

	}

	public String getBillStatementDate() {
		log("Verify Bill Statement Date");
		try {
			WaitAngular(driver);
			waitForObject(driver, BillStatementDate);
		} catch (NoSuchElementException e) {
			log(e.getMessage());
			Assert.assertTrue(false, "BILL Statement Button not found");
		}

		return BillStatementDate.getText();

	}

	public String getBillStatementAmount() {
		try {
			WaitAngular(driver);
			waitForObject(driver, BillStatementValue);
		} catch (NoSuchElementException e) {
			log(e.getMessage());
			Assert.assertTrue(false, "BILL Statement Button not found");
		}
		return BillStatementValue.getText();

	}

	public void clickSecondaryCustomer() {

		WaitAngular(driver);
		ClickElement(SecondCust, "Secondary Customer");

	}

	public void AddNotes(String notes) {
		try {
			WaitAngular(driver);
			waitForObject(driver, Notes);
			setElementText(Notes, notes, "notes text");
			WaitAngular(driver);
			ClickElement(SubmitNotes, "Submit Notes");
			WaitAngular(driver);
		} catch (NoSuchElementException e) {
			log(e.getMessage());
			Assert.assertTrue(false, "Notes Text not found");
		}
	}

	public String GetNotes() {
		try {
			WaitAngular(driver);
			waitForObject(driver, AddedNotes);
			return getElementText(AddedNotes, "Added Notes");

		} catch (NoSuchElementException e) {
			log(e.getMessage());
			Assert.assertTrue(false, "Notes Text not found");
		}
		return null;
	}

	public String getSecondCustName() {
		String name = "";
		try {
			WaitAngular(driver);
			waitForObject(driver, SecondCustName);
			name = getElementText(SecondCustName, "Secondary Customer Name");
			WaitAngular(driver);

		} catch (NoSuchElementException e) {
			log(e.getMessage());
			Assert.assertTrue(false, "Secondary Customer not found");
		}
		return name;

	}

	public String getSecondCustomerCount() {
		String name = "";
		try {
			WaitAngular(driver);
			waitForObject(driver, SecondCustCnt);
			name = getElementText(SecondCustCnt, "Secondary Customer Count");
			WaitAngular(driver);

		} catch (NoSuchElementException e) {
			log(e.getMessage());
			Assert.assertTrue(false, "Secondary Customer not found");
		}
		return name;

	}

	public void verifyCustDetails(String ssn, String lic, String phone, String ext, String email, String add,
			String acsz) {
		WaitAngular(driver);
		log("Verifying Customer Details");
		waitForObject(driver, CustomerSSN);
		verifyString(ssn, getElementText(CustomerSSN, "Customer SSN"));

		waitForObject(driver, DriverLic);
		verifyString(lic, getElementText(DriverLic, "Driver License"));

		waitForObject(driver, Phone1);
		verifyString(phone, getElementText(Phone1, "Phone Number"));

		waitForObject(driver, PhoneExt1);
		verifyString(ext, getElementText(PhoneExt1, "Phone Ext"));

		waitForObject(driver, Email);
		verifyString(email, getElementText(Email, "Email"));

		waitForObject(driver, AddressLine1);
		verifyString(add, getElementText(AddressLine1, "AddressLine1"));

		waitForObject(driver, AddressCityStateZip);
		verifyString(acsz, getElementText(AddressCityStateZip, "AddressCityStateZip"));
	}

	public void verifyCustDetailsNoEmailExt(String ssn, String lic, String phone, String add, String acsz) {
		WaitAngular(driver);
		log("Verifying Customer Details");
		waitForObject(driver, CustomerSSN);
		verifyString(ssn, getElementText(CustomerSSN, "Customer SSN"));

		waitForObject(driver, DriverLic);
		verifyString(lic, getElementText(DriverLic, "Driver License"));

		waitForObject(driver, Phone1);
		verifyString(phone, getElementText(Phone1, "Phone Number"));

		waitForObject(driver, NoEmail);
		verifyString("none", getElementText(NoEmail, "Email"));

		waitForObject(driver, AddressLine1);
		verifyString(add, getElementText(AddressLine1, "AddressLine1"));

		waitForObject(driver, AddressCityStateZip);
		verifyString(acsz, getElementText(AddressCityStateZip, "AddressCityStateZip"));
	}

	public void editContact() {

		WaitAngular(driver);
		waitForObject(driver, ContactEdit);
		ClickElement(ContactEdit, "Edit Contact");

	}

	public void updatePhone1(String phoneNum) {
		try {
			WaitAngular(driver);
			waitForObject(driver, ContactPhone1);
			ContactPhone1.clear();
			WaitAngular(driver);
			waitForObject(driver, ContactPhone1);
			setElementText(ContactPhone1, phoneNum, "Phone Number");
			WaitAngular(driver);
		} catch (NoSuchElementException e) {
			log(e.getMessage());
			Assert.assertTrue(false, "Phone field not found");
		}

	}

	public void updateEmail(String email) {
		try {
			WaitAngular(driver);
			waitForObject(driver, ContactEmail1);
			ContactEmail1.clear();
			WaitAngular(driver);
			waitForObject(driver, ContactEmail1);
			setElementText(ContactEmail1, email, "Email id");
			WaitAngular(driver);
		} catch (NoSuchElementException e) {
			log(e.getMessage());
			Assert.assertTrue(false, "Email field not found");
		}
	}

	public void clickContactUpdate() {
		WaitAngular(driver);
		ClickElement(ContactUpdateBtn, "Contact Update");

	}

	public void clickBookmarkDisabled() {
		try {
			log("Click Bookmark");
			if (BookMarkIconEnabled.isDisplayed()) {
				ClickElement(BookMarkIconEnabled, "Book Mark");
			} else if (BookMarkIconDisabled.isDisplayed()) {
				try {
					ClickElement(BookMarkIconDisabled, "Book Mark");
					WaitAngular(driver);
					try {
						if (BookMarkIconEnabled.isDisplayed()) {
							ClickElement(BookMarkIconEnabled, "Book Mark");
						}
					} catch (NoSuchElementException e) {
						Assert.assertTrue(false, "Bookmark not found");
					}

				} catch (NoSuchElementException e) {
					Assert.assertTrue(false, "Bookmark not found");
				}
			}
			WaitAngular(driver);
		} catch (NoSuchElementException e) {
			log(e.getMessage());

		}
	}

	public void VerifyBookMarkEnabled() {
		try {
			log("Click Bookmark");
			if (BookMarkIconEnabled.isDisplayed()) {
				waitForObject(driver, BookMarkIconEnabled);
				log("Book Mark Verified");
				Assert.assertTrue(true);
			} else {
				Assert.assertTrue(false);
				log("Book Mark Not Verified");
			}
		}

		catch (NoSuchElementException e) {
			log(e.getMessage());

		}
	}

	public void verifyCreditStatus(String creditStatus) {
		log("Verify Credit Status");
		verifyString(CreditRating.getText(), creditStatus);
		WaitAngular(driver);
	}

	public void clickBookmarkEnabled() {

		ClickElement(BookMarkIconDisabled, "Book Mark");

	}

	public void SearchAccountWidget(String AccountId) throws InterruptedException {
		WaitAngular(driver);
		log("Click on Account Drop down");
		waitForObject(driver, AccountDropdown);
		ClickElement(AccountDropdown, "Account Drop down");
		log("Enter Account Name");
		WaitAngular(driver);
		waitForObject(driver, AccountSearchText);
		ClickElement(AccountSearchText, "Search Account");
		setElementText(AccountSearchText, AccountId, "Account Search Text");
		WaitAngular(driver);
	}

	public void SearchAccountWidgetExpanded(String AccountId) throws InterruptedException {
		WaitAngular(driver);
		log("Click on Account Drop down");
		log("Enter Account Name");
		WaitAngular(driver);
		waitForObject(driver, AccountSearchText);
		ClickElement(AccountSearchText, "Search Account");
		setElementText(AccountSearchText, AccountId, "Account Search Text");
		WaitAngular(driver);
	}

	public void verifySearchAccountResult(String elementString, String elementid) {
		try {
			verifyString(elementString, (findElementByid(elementid).getText()));
		} catch (NoSuchElementException e) {
			Assert.fail("Element Not found");
		}
	}

	public void clickSearchAccountResult(String id) {
		try {
			findElementByid(id).click();
		} catch (NoSuchElementException e) {
			Assert.fail("Element Not found");
		}

	}

	public void clickSarchAccountWidget() throws InterruptedException {
		WaitAngular(driver);
		log("Click on Account Drop down");
		waitForObject(driver, AccountDropdown);
		ClickElement(AccountDropdown, "Account Drop down");
		log("Enter Account Name");
		WaitAngular(driver);
		waitForObject(driver, AccountSearchText);
		ClickElement(AccountSearchText, "Search Account");
	}

	public void VerifySearchAccountResult1(String AccountName) throws InterruptedException {
		WaitAngular(driver);
		log("Verify Account Name =" + AccountName);
		waitForObject(driver, AccountSearchResult1);
		verifyStringContains(getElementText(AccountSearchResult1, "Account Search Result"), AccountName);
		WaitAngular(driver);
	}

	public void VerifySearchAccountResult2(String AccountName) throws InterruptedException {
		WaitAngular(driver);
		log("Verify Account Name =" + AccountName);
		waitForObject(driver, AccountSearchResult2);
		verifyStringContains(AccountName, getElementText(AccountSearchResult2, "Account Search Result"));
		WaitAngular(driver);
	}

	public void VerifySearchAccountResult3(String AccountName) throws InterruptedException {
		WaitAngular(driver);
		log("Verify Account Name =" + AccountName);
		waitForObject(driver, AccountSearchResult3);
		verifyStringContains(AccountName, getElementText(AccountSearchResult3, "Account Result"));
		WaitAngular(driver);
	}

	public void VerifySearchAccountResult4(String AccountName) throws InterruptedException {
		WaitAngular(driver);
		log("Verify Account Name =" + AccountName);
		waitForObject(driver, AccountSearchResult4);
		verifyStringContains(AccountName, getElementText(AccountSearchResult4, "Account Result"));
		WaitAngular(driver);
	}

	public void verifyAddressDetails(String addline, String addCity, String addState, String addZip) {
		WaitAngular(driver);
		log("Verifying Address Details");
		waitForObject(driver, AddressLine);
		verifyString(addline, getElementText(AddressLine, "Address Line Result"));
		waitForObject(driver, AddressCity);
		verifyString(addCity, getElementText(AddressCity, "Address City Result"));
		waitForObject(driver, AddressState);
		verifyString(addState, getElementText(AddressState, "Address State Result"));
		waitForObject(driver, AddressZipCode);
		verifyString(addZip, getElementText(AddressZipCode, "Address State Result"));

	}

	public void ClickSummaryLink() {
		log("Clicking Summary Link");
		ClickElement(SummaryLink, "Summary Link");

	}

	public void clickTransactionLink() {
		log("Clicking Transaction Link");
		ClickElement(TransactionLink, "Transaction Link");

	}

	public void clickServiceorderLink() {
		log("Clicking Servic Order Link");
		ClickElement(ServiceOrderLink, "Service Order Link");

	}

	public String getserviceOrderNum() {
		log("Capturing Servic Order Number");
		return getElementText(serviceOrderNum, "Service Order Number");

	}

	public String getServiceOrderDrillbackURL() {
		return findElementByid("SODV_Drillback").getAttribute("href");
	}

	public HashMap<String, String> GetBillingInfo() {
		WaitAngular(driver);
		waitforObjectById(driver, "BILL_Current_Balance");
		waitforObjectById(driver, "BILL_Unposted_Balance");
		waitforObjectById(driver, "BILL_Account_Balance");
		waitforObjectById(driver, "BILL_Past_Due");
		waitforObjectById(driver, "BILL_Installment_Budget");
		waitforObjectById(driver, "BILL_Over_Short");

		HashMap<String, String> BillingInfo = new HashMap<String, String>();
		BillingInfo.put("BillDue", BILL_PastDue.getText());
		BillingInfo.put("BillCurrent", BILL_CurrentBalance.getText());
		BillingInfo.put("BillUnposted", BILL_UnpostedBalance.getText());
		BillingInfo.put("BillAccount", BILL_AccountBalance.getText());
		BillingInfo.put("BillInstallment", BILL_Installment.getText());
		BillingInfo.put("BillOverDue", BILL_Over_Short.getText());
		BillingInfo.put("AmountDue", BILL_Amount_Due.getText());

		return BillingInfo;
	}

	public HashMap<String, String> GetBillingServiceElectricInfo() {
		WaitAngular(driver);
		log("Verifying Service Type 1");
		HashMap<String, String> BillingSrvcInfo = new HashMap<String, String>();
		BillingSrvcInfo.put("Service1", Service1.findElement(By.id("SERV_Service_1_Service_Type_1")).getText());
		BillingSrvcInfo.put("Service1Equipment",
				Service1.findElement(By.id("SERV_Service_1_Equipment_Id_1")).getText());
		BillingSrvcInfo.put("Service1Rate", Service1.findElement(By.id("SERV_Service_1_Rate_Id_1")).getText());
		BillingSrvcInfo.put("Service1Multi", Service1.findElement(By.id("SERV_Service_1_Multiplier_1")).getText());
		BillingSrvcInfo.put("Service1Status",
				Service1.findElement(By.id("SERV_Service_1_Connection_Status")).getText());
		return BillingSrvcInfo;

	}

	public HashMap<String, String> GetBillingServiceElectricTABInfo() {
		WaitAngular(driver);
		log("Verifying Service TAB, Row 1");
		HashMap<String, String> BillingSrvcInfo = new HashMap<String, String>();
		BillingSrvcInfo.put("Service1", Service1Tab.findElement(By.id("SERV_Service_2_Service_Type_1")).getText());
		BillingSrvcInfo.put("Service1Equipment",
				Service1Tab.findElement(By.id("SERV_Service_2_Equipment_Id_1")).getText());
		BillingSrvcInfo.put("Service1Rate", Service1Tab.findElement(By.id("SERV_Service_2_Rate_Id_1")).getText());
		BillingSrvcInfo.put("Service1Multi", Service1Tab.findElement(By.id("SERV_Service_2_Multiplier_1")).getText());
		BillingSrvcInfo.put("Service1Status",
				Service1Tab.findElement(By.id("SERV_Service_2_Connection_Status")).getText());
		return BillingSrvcInfo;

	}

	public HashMap<String, String> GetBillingServiceGasInfo() {
		WaitAngular(driver);
		HashMap<String, String> BillingSrvcInfo = new HashMap<String, String>();
		log("Verifying Service GAS ");
		BillingSrvcInfo.put("Service2", Service2.findElement(By.id("SERV_Service_1_Service_Type_2")).getText());
		BillingSrvcInfo.put("Service2Equipment",
				Service2.findElement(By.id("SERV_Service_1_Equipment_Id_2")).getText());
		BillingSrvcInfo.put("Service2Rate", Service2.findElement(By.id("SERV_Service_1_Rate_Id_2")).getText());
		BillingSrvcInfo.put("Service2Multi", Service2.findElement(By.id("SERV_Service_1_Multiplier_2")).getText());
		BillingSrvcInfo.put("Service2Status",
				Service2.findElement(By.id("SERV_Service_1_Connection_Status")).getText());
		return BillingSrvcInfo;
	}

	public HashMap<String, String> GetBillingServiceGasTABInfo() {
		WaitAngular(driver);
		HashMap<String, String> BillingSrvcInfo = new HashMap<String, String>();
		log("Verifying Service GAS Row 1");
		BillingSrvcInfo.put("Service2", Service2Tab.findElement(By.id("SERV_Service_3_Service_Type_1")).getText());
		BillingSrvcInfo.put("Service2Equipment",
				Service2Tab.findElement(By.id("SERV_Service_3_Equipment_Id_1")).getText());
		BillingSrvcInfo.put("Service2Rate", Service2Tab.findElement(By.id("SERV_Service_3_Rate_Id_1")).getText());
		BillingSrvcInfo.put("Service2Multi", Service2Tab.findElement(By.id("SERV_Service_3_Multiplier_1")).getText());
		BillingSrvcInfo.put("Service2Status",
				Service2Tab.findElement(By.id("SERV_Service_3_Connection_Status")).getText());
		return BillingSrvcInfo;
	}

	public HashMap<String, String> GetBillingServiceInternetInfo() {
		WaitAngular(driver);

		HashMap<String, String> BillingSrvcInfo = new HashMap<String, String>();
		log("Verifying Service Type Internet");
		BillingSrvcInfo.put("Service3", Service3.findElement(By.id("SERV_Service_1_Service_Type_3")).getText());
		BillingSrvcInfo.put("Service3Equipment",
				Service3.findElement(By.id("SERV_Service_1_Equipment_Id_3")).getText());
		BillingSrvcInfo.put("Service3Rate", Service3.findElement(By.id("SERV_Service_1_Rate_Id_3")).getText());
		BillingSrvcInfo.put("Service3Multi", Service3.findElement(By.id("SERV_Service_1_Multiplier_3")).getText());
		BillingSrvcInfo.put("Service3Status",
				Service3.findElement(By.id("SERV_Service_1_Connection_Status")).getText());
		return BillingSrvcInfo;
	}

	public HashMap<String, String> GetBillingServiceInternetTABInfo() {
		WaitAngular(driver);

		HashMap<String, String> BillingSrvcInfo = new HashMap<String, String>();
		log("Verifying Service Type Internet Tab Row 1");
		BillingSrvcInfo.put("Service3", Service3Tab.findElement(By.id("SERV_Service_4_Service_Type_1")).getText());
		BillingSrvcInfo.put("Service3Equipment",
				Service3Tab.findElement(By.id("SERV_Service_4_Equipment_Id_1")).getText());
		BillingSrvcInfo.put("Service3Rate", Service3Tab.findElement(By.id("SERV_Service_4_Rate_Id_1")).getText());
		BillingSrvcInfo.put("Service3Multi", Service3Tab.findElement(By.id("SERV_Service_4_Multiplier_1")).getText());
		BillingSrvcInfo.put("Service3Status",
				Service3Tab.findElement(By.id("SERV_Service_4_Connection_Status")).getText());
		return BillingSrvcInfo;
	}

	public String GetLogusername() throws InterruptedException {

		String result = "";
		try {
			WaitAngular(driver);
			if (LoggedUserLink.isDisplayed())

				result = getElementText(LoggedUserLink, "LoggedUserLink");
			log("username found " + result);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false, "User Name not found");
		}
		return result;
	}

	public String getLoggedCustId() throws InterruptedException {

		String result = "";
		try {
			WaitAngular(driver);
			if (CustomerId.isDisplayed())
				result = getElementText(CustomerId, "Customer Id");
			log("CustomerId found " + result);

		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false, "Customer Id not found");
		}
		return result;

	}

	public String getLoggedCustomerLocationId() throws InterruptedException {

		String result = "";
		try {
			WaitAngular(driver);
			if (CustomerLocId.isDisplayed())
				result = getElementText(CustomerLocId, "CustomerLocId");
			log("Customer Location Id found " + result);

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Customer Location not found");
		}
		return result;

	}

	public String getLoggedCustomerName() throws InterruptedException {

		String result = "";
		try {
			WaitAngular(driver);
			if (CustomerName.isDisplayed())
				result = getElementText(CustomerName, "Customer Name");
			log("Customer Name found " + result);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Customer Name not found =" + result);
		}
		return result;
	}

	public String getLoggedCustomerAddress() throws InterruptedException {

		String result = "";
		try {
			WaitAngular(driver);
			if (customerAddressCity.isDisplayed())
				result = getElementText(customerAddressCity, "Customer City") + " "
						+ getElementText(customerAddressState, "Customer State") + " "
						+ getElementText(customerAddressZip, "Customer Zip");
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false, "Customer Address not found =" + result);
		}

		return result;

	}

	public void logout() throws InterruptedException {
		try {

			WaitAngular(driver);
			// Use Actions to specify an x,y coordinate for your click,
			if (OverLay.isDisplayed()) {
				Actions a = new Actions(driver);
				a.moveToElement(OverLay, 10, 10).click().perform();
			}

		} catch (NoSuchElementException e) {
			log(e.getMessage());

		}
		try {
			WaitAngular(driver);
			waitForObject(this.driver, LoggedUserLink);
			ClickElement(LoggedUserLink, "Logged User Link");

		} catch (NoSuchElementException e) {
			log(e.getMessage());
			Assert.assertTrue(false, "Unable to find User Link");
		}

		try {
			waitForObject(this.driver, logoutLink);
			Thread.sleep(300);
			ClickElement(logoutLink, "logout Link");
			WaitAngular(driver);
		} catch (NoSuchElementException e) {
			log(e.getMessage());
			Assert.fail("logout Link not found");
		}

	}

	public void Clickusername() throws InterruptedException {

		ClickElement(LoggedUserLink, "User Name Link");

	}

	public void clickOk() throws InterruptedException {

		waitforObjectById(this.driver, "ALERTO_Action_Button");
		ClickElement(AlertOk, "Alert OK");

	}

	public void clickDynamicOk() {

		log("Click Dynamic Ok");
		// Not waiting for element as it will throw exception
		try {

			AlertOk.click();

		} catch (NoSuchElementException e) {
			log("Alet not configured");
		}

	}

	public void clickAlertdesc() throws InterruptedException {

		log("Click Alert Description");
		ClickElement(AlertDesc, "Alert Description");
		log("Click Description");

	}

}
