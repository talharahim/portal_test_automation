package com.NexusPortalAutomation.PageObjects.Java;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.NexusPortalAutomation.Utilities.Java.CommonMethods;

/**
 * 
 * All WebElements are identified by @FindBy annotation
 * 
 * @author Talha Rahim
 * @since 2019-04-25
 */

public class DashBoard extends CommonMethods {

	WebDriver driver;
	@FindBy(id = "USR_Name")
	WebElement LoggedUserLink;

	@FindBy(id = "ACTION_Logout")
	WebElement LogOutLink;

	@FindBy(css = ".customer-info-id")
	@CacheLookup
	WebElement CustomerId;

	@FindBy(id = "'LOC_Location_Id'")
	WebElement CustomerLocId;

	@FindBy(css = ".text-heading > span:nth-child(1)")
	@CacheLookup
	WebElement CustomerName;

	@FindBy(css = "#\\'LOC_Address_Line\\'")
	@CacheLookup
	WebElement CustomerAddress;

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

	// SSN 'CUST_SSN'
	@FindBy(id = "'CUST_SSN'")
	@CacheLookup
	WebElement CustomerSSN;

	@FindBy(id = "'CUST_Drivers_License'")
	@CacheLookup
	WebElement DriverLic;

	@FindBy(id = "CUST_Phone_Number_1")
	WebElement Phone1;

	@FindBy(id = "CUST_Phone_Number_Ext_1")
	@CacheLookup
	WebElement PhoneExt1;

	// 'CUST_Email'

	@FindBy(id = "'CUST_Email'")
	@CacheLookup
	WebElement Email;

	@FindBy(id = "'CUST_Address_Line'")
	@CacheLookup
	WebElement AddressLine1;

	@FindBy(id = "'CUST_Address_City_State_Zip'")
	@CacheLookup
	WebElement AddressCityStateZip;

	@FindBy(id = "ACTION_BOOKMARK")
	@CacheLookup
	WebElement BookMarkIconEnabled;

	@FindBy(id = "ACTION_BOOKMARK_Selected")
	@CacheLookup
	WebElement BookMarkIconDisabled;

	@FindBy(id = "credit-great")
	@CacheLookup
	WebElement creditGreat;

	@FindBy(id = "'CUST_Drillback_Button'")
	@CacheLookup
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

	// @FindBy(id = "cdk-overlay-1")
	// public WebElement OverLay;

	@FindBy(className = "cdk-overlay-container")
	public WebElement OverLay;

	@FindBy(id = "SERV_Tab_Type_1_Icon")
	@CacheLookup
	WebElement ServElectricIcon;

	@FindBy(id = "SERV_Tab_Type_2_Icon")
	@CacheLookup
	WebElement ServGasIcon;

	@FindBy(id = "SERV_Tab_Type_3_Icon")
	@CacheLookup
	WebElement ServInternetIcon;

	@FindBy(id = "ACTION_DRILLBACK")
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

	public HashMap<String, String> GetServiceOrderDetails() {
		//This method will feth the service order details and returns it in a map
		WaitAngular(driver);
		log("Verifying Service Order Details");
		HashMap<String, String> SrvcOrderInfo = new HashMap<String, String>();
		SrvcOrderInfo.put("ServiceOrderReqId", ServOrder_Order_RequestID.getText());
		SrvcOrderInfo.put("ServiceOrderDescription", SOLV_Service_Order_Description.getText());
		SrvcOrderInfo.put("ServiceOrderScheduledDate", SOLV_Service_Order_Scheduled_Date.getText());
		SrvcOrderInfo.put("SOLVServiceOrderId", SOLV_Service_Order_Id.getText());
		SrvcOrderInfo.put("SODVStatus", SODV_Status.getText());
		SrvcOrderInfo.put("SODVDescriptionRequest", SODV_Description_Request.getText());
		SrvcOrderInfo.put("SODVRequestId", SODV_Request_Id.getText());
		SrvcOrderInfo.put("SODVRequestedDate ", SODV_Requested_Date.getText());
		SrvcOrderInfo.put("SODVRequestedTime", SODV_Requested_Time.getText());
		SrvcOrderInfo.put("SODVScheduledDate", SODV_Scheduled_Date.getText());
		SrvcOrderInfo.put("SODVScheduledTime", SODV_Scheduled_Time.getText());
		SrvcOrderInfo.put("SODVTaskDescription", SODV_Task_Description.getText());
		SrvcOrderInfo.put("SODVTaskEmployeeId", SODV_Task_Employee_Id.getText());
		SrvcOrderInfo.put("SODVTaskCompletedDate", SODV_Task_Completed_Date.getText());
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
			element.click();
			log("Click " + ElementName);
			WaitAngular(driver);

		} catch (NoSuchElementException e) {
			log(e.getMessage());
			Assert.assertTrue(false, ElementName + " not found");

		}
	}

	public void clickActionDropDown() {

		waitForObject(driver, actionDropDown);
		ClickElement(actionDropDown, "Action Drop down");

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

	}

	// This method will find the elements of Transaction Panel using the URL
	public void VerifyTransDrillBacks(String payment, String bill, String meter) throws InterruptedException {
		Thread.sleep(1000);
		findElementByid("TRAN_Drillback_1").getAttribute(payment);
		findElementByid("TRAN_Drillback_2").getAttribute(bill);
		findElementByid("TRAN_Drillback_3").getAttribute(meter);

	}

	// This method will find the elements of Transaction Panel using the URL
	public void VerifyServiceOrderDrillBacks(String ServOrder) throws InterruptedException {
		Thread.sleep(1000);
		findElementByid("SODV_Drillback").getAttribute(ServOrder);

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

	public String GetSecondCustDrillBackUrl() {
		try {
			waitForObject(driver, SecondayCustDrillBack);

		} catch (NoSuchElementException e) {
			log(e.getMessage());
			Assert.assertTrue(false, "Seconday Customer Drillback not found");
		}
		return SecondayCustDrillBack.getAttribute("href");
	}

	public String GetServiceTabDrillBackUrl() {
		try {
			waitForObject(driver, ServiceTabDrillBack);

		} catch (NoSuchElementException e) {
			log(e.getMessage());
			Assert.assertTrue(false, "Service Drillback not found");
		}
		return ServiceTabDrillBack.getAttribute("href");
	}

	public DashBoard(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void ClickServElecIcon() {
		waitForObject(driver, ServElectricIcon);
		ClickElement(ServElectricIcon, "Electric Icon");
	}

	public void ClickServGasIcon() {

		waitForObject(driver, ServGasIcon);
		ClickElement(ServGasIcon, "Gas Icon");

	}

	public void ClickServInternetIcon() {

		waitForObject(driver, ServInternetIcon);
		ClickElement(ServInternetIcon, "Internet Icon");

	}

	public String getAutoPay() {
		String result = "OFF";
		try {
			waitForObject(driver, AutoPay);
			if (!AutoPay.getText().equals("OFF")) {
				result = "ON";
			}
		} catch (NoSuchElementException e) {
			log(e.getMessage());
			Assert.assertTrue(false, "BILL Statement Button not found");
		}

		return result;
	}

	public String getDepositAmount() {
		String result = "";
		try {
			waitForObject(driver, DepositAmount);
			if (!DepositAmount.getText().equals("")) {
				result = DepositAmount.getText();
			}
		} catch (NoSuchElementException e) {
			log(e.getMessage());
			Assert.assertTrue(false, "BILL Statement Button not found");
		}

		return result;
	}

	public String getEBill() {
		String result = "OFF";
		try {
			waitForObject(driver, EBill);
			if (!EBill.getText().equals("OFF")) {
				result = "ON";
			}
		} catch (NoSuchElementException e) {
			log(e.getMessage());
			Assert.assertTrue(false, "BILL Statement Button not found");
		}

		return result;
	}

	public void ClickBillStatementBtn() {

		WaitAngular(driver);
		ClickElement(BILLStatementBtn, "Bill Statement Button");

	}

	public void ClickBillStatement() {

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

	public void ClickSecondCust() {

		WaitAngular(driver);
		ClickElement(SecondCust, "Secondary Customer");

	}

	public void AddNotes(String notes) {
		try {
			WaitAngular(driver);
			Notes.sendKeys(notes);
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
			return AddedNotes.getText();

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
			name = SecondCustName.getText();
			WaitAngular(driver);

		} catch (NoSuchElementException e) {
			log(e.getMessage());
			Assert.assertTrue(false, "Secondary Customer not found");
		}
		return name;

	}

	public void VerifyCustomerDetails(String ssn, String lic, String phone, String ext, String email, String add,
			String acsz) {
		WaitAngular(driver);
		log("Verifying Customer Details");
		VerifyString(ssn, CustomerSSN.getText());
		VerifyString(lic, DriverLic.getText());
		VerifyString(phone, Phone1.getText());
		VerifyString(ext, PhoneExt1.getText());
		VerifyString(email, Email.getText());
		VerifyString(add, AddressLine1.getText());
		VerifyString(acsz, AddressCityStateZip.getText());
	}

	public void ClickContactEdit() {

		WaitAngular(driver);
		ClickElement(ContactEdit, "Edit Contact");

	}

	public void updatePhone1(String phoneNum) {
		try {
			WaitAngular(driver);
			WaitForObjectbyElement(driver, ContactPhone1);
			ContactPhone1.clear();
			WaitAngular(driver);
			ContactPhone1.sendKeys(phoneNum);
			WaitAngular(driver);
		} catch (NoSuchElementException e) {
			log(e.getMessage());
			Assert.assertTrue(false, "Phone field not found");
		}

	}

	public void updateEmail(String email) {
		try {
			WaitAngular(driver);
			WaitForObjectbyElement(driver, ContactEmail1);
			ContactEmail1.clear();
			WaitAngular(driver);
			ContactEmail1.sendKeys(email);
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

	public void ClickBookMarkDisabled() {
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

	public void VerifyGoodCredit() {
		log("Verify Credit Status");
		if (creditGreat.isDisplayed()) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
		WaitAngular(driver);
	}

	public void ClickBookMarkEnabled() {

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
		AccountSearchText.sendKeys(AccountId);
		WaitAngular(driver);

	}

	public void VerifySearchAccountResult1(String AccountName) throws InterruptedException {
		WaitAngular(driver);
		log("Verify Account Name =" + AccountName);
		waitForObject(driver, AccountSearchResult1);
		VerifyStringContains(AccountSearchResult1.getText(), AccountName);
		WaitAngular(driver);
	}

	public void VerifySearchAccountResult2(String AccountName) throws InterruptedException {
		WaitAngular(driver);
		log("Verify Account Name =" + AccountName);
		waitForObject(driver, AccountSearchResult2);
		VerifyStringContains(AccountName, AccountSearchResult2.getText());
		WaitAngular(driver);
	}

	public void VerifySearchAccountResult3(String AccountName) throws InterruptedException {
		WaitAngular(driver);
		log("Verify Account Name =" + AccountName);
		waitForObject(driver, AccountSearchResult3);
		VerifyStringContains(AccountName, AccountSearchResult3.getText());
		WaitAngular(driver);
	}

	public void VerifySearchAccountResult4(String AccountName) throws InterruptedException {
		WaitAngular(driver);
		log("Verify Account Name =" + AccountName);
		waitForObject(driver, AccountSearchResult4);
		VerifyStringContains(AccountName, AccountSearchResult4.getText());
		WaitAngular(driver);
	}

	public void verifyAddressDetails(String addline, String addCity, String addState, String addZip) {
		WaitAngular(driver);
		log("Verifying Address Details");
		VerifyString(addline, AddressLine.getText());
		VerifyString(addCity, AddressCity.getText());
		VerifyString(addState, AddressState.getText());
		VerifyString(addZip, AddressZipCode.getText());

	}

	public void ClickSummaryLink() {

		ClickElement(SummaryLink, "Summary Link");

	}

	public void ClickTransactionLink() {

		ClickElement(TransactionLink, "Transaction Link");

	}

	public void ClickServiceOrderLink() {
		ClickElement(ServiceOrderLink, "Service Order Link");

	}

	public HashMap<String, String> GetBillingInfo() {
		WaitAngular(driver);
		WaitForObjectbyId(driver, "BILL_Current_Balance");
		WaitForObjectbyId(driver, "BILL_Unposted_Balance");
		WaitForObjectbyId(driver, "BILL_Account_Balance");
		WaitForObjectbyId(driver, "BILL_Past_Due");
		WaitForObjectbyId(driver, "BILL_Installment_Budget");
		WaitForObjectbyId(driver, "BILL_Over_Short");

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

	public String GetLogUserName() throws InterruptedException {

		String result = "";
		try {
			WaitAngular(driver);
			if (LoggedUserLink.isDisplayed())
				result = LoggedUserLink.getText();
			log("UserName found " + result);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false, "User Name not found");
		}
		return result;
	}

	public String GetLoggedCustomerId() throws InterruptedException {

		String result = "";
		try {
			WaitAngular(driver);
			if (CustomerId.isDisplayed())
				result = CustomerId.getText();
			log("CustomerId found " + result);

		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false, "Customer Id not found");
		}
		return result;

	}

	public String GetLoggedCustomerLocationId() throws InterruptedException {

		String result = "";
		try {
			WaitAngular(driver);
			if (CustomerLocId.isDisplayed())
				result = CustomerLocId.getText();
			log("Customer Location Id found " + result);

		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false, "Customer Location not found");
		}
		return result;

	}

	public String GetLoggedCustomerName() throws InterruptedException {

		String result = "";
		try {
			WaitAngular(driver);
			if (CustomerName.isDisplayed())
				result = CustomerName.getText();
			log("Customer Name found " + result);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false, "Customer Nuame not found");
		}
		return result;
	}

	public String GetLoggedCustomerAddress() throws InterruptedException {

		String result = "";
		try {
			WaitAngular(driver);
			if (CustomerAddress.isDisplayed())
				result = CustomerAddress.getText();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false, "Customer Address not found");
		}

		return result;

	}

	public void LogOut() throws InterruptedException {
		try {
			WaitAngular(driver);
			// Use Actions to specify an x,y coordinate for your click,
			Actions a = new Actions(driver);
			a.moveToElement(OverLay, 1, 1).click().perform();

		} catch (NoSuchElementException e) {
			log(e.getMessage());

		}
		try {
			WaitAngular(driver);
			waitForObject(this.driver, LoggedUserLink);
			LoggedUserLink.click();

		} catch (NoSuchElementException e) {
			log(e.getMessage());
			Assert.assertTrue(false, "Unable to find User Link");
		}

		try {
			waitForObject(this.driver, LogOutLink);
			Thread.sleep(300);
			LogOutLink.click();
			WaitAngular(driver);
		} catch (NoSuchElementException e) {
			log(e.getMessage());
			Assert.assertTrue(false, "Logout Link not found");
		}

	}

	public void ClickUserName() throws InterruptedException {

		ClickElement(LoggedUserLink, "User Name Link");

	}

	public void ClickOk() throws InterruptedException {

		WaitForObjectbyId(this.driver, "ALERTO_Action_Button");
		ClickElement(AlertOk, "Alert OK");

	}

	public void ClickDynamicOk() {

		WaitForObjectbyId(this.driver, "ALERTO_Action_Button");
		ClickElement(AlertOk, "Ok Button");

	}

	public void ClickAlertDescription() throws InterruptedException {

		ClickElement(AlertDesc, "Alert Description");
		log("Click Description");

	}

}
