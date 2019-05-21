package com.NexusPortalAutomation.PageObjects.Java;

import java.util.HashMap;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
	@FindBy(css = ".user > a:nth-child(1)")
	WebElement LoggedUserLink;

	@FindBy(css = ".logout-label")
	WebElement LogOutLink;

	@FindBy(css = ".customer-info-id")
	@CacheLookup
	WebElement CustomerId;

	@FindBy(id = "'LOC_Location_Id'")
	@CacheLookup
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

	@FindBy(css = "#mat-tab-label-0-1 > div:nth-child(1)")
	@CacheLookup
	WebElement TransactionLink;

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

	@FindBy(id = "_Label")
	@CacheLookup
	WebElement AccountDropdown;

	@FindBy(xpath = "/html[1]/body[1]/wo-root[1]/wo-dashboard[1]/div[1]/mat-drawer-container[1]/mat-drawer-content[1]/div[1]/div[1]/div[1]/csm-customer-card[1]/csm-selector-inline[1]/csm-generic-expandable-selector[1]/div[1]/input[1]")
	@CacheLookup
	WebElement AccountSearchText;

	@FindBy(xpath = "//div[@class='section']//div[2]//div[2]")
	WebElement AccountSearchResult;

	// SSN 'CUST_SSN'
	@FindBy(id = "'CUST_SSN'")
	@CacheLookup
	WebElement CustomerSSN;

	@FindBy(id = "'CUST_Drivers_License'")
	@CacheLookup
	WebElement DriverLic;

	@FindBy(id = "CUST_Phone_Number_1")
	@CacheLookup
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

	@FindBy(xpath = "/html/body/wo-root/wo-dashboard/div/mat-drawer-container/mat-drawer-content/div/div/div[1]/csm-customer-card/div/div/div/div[2]/div[2]/div[1]")
	@CacheLookup
	WebElement BookMarkIconEnabled;

	@FindBy(xpath = "/html/body/wo-root/wo-dashboard/div/mat-drawer-container/mat-drawer-content/div/div/div[1]/csm-customer-card/div/div/div/div[2]/div[2]/div[1]/a/span/span/svg")
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
	
	@FindBy(id="ECI_Action_Button")
	WebElement ContactUpdateBtn;

	public DashBoard(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void VerifyCustomerDetails(String ssn, String Lic, String phone, String ext, String email, String add,
			String acsz) {
		log("Verifying Customer Details");
		VerifyString(ssn, CustomerSSN.getText());
		VerifyString(Lic, DriverLic.getText());
		VerifyString(phone, Phone1.getText());
		VerifyString(ext, PhoneExt1.getText());
		VerifyString(email, Email.getText());
		VerifyString(add, AddressLine1.getText());
		VerifyString(acsz, AddressCityStateZip.getText());
	}

	public void ClickContactEdit() {
		try {
			WaitAngular(driver);
			ContactEdit.click();
			WaitAngular(driver);
		} catch (NoSuchElementException e) {
			log(e.getMessage());
		}

	}
	
	public void updatePhone1(String phoneNum) {
		try {
			WaitAngular(driver);
			ContactPhone1.clear();
			WaitAngular(driver);
			ContactPhone1.sendKeys(phoneNum);
			WaitAngular(driver);
		} catch (NoSuchElementException e) {
			log(e.getMessage());
		}

	}
	
	public void updateEmail(String email) {
		try {
			WaitAngular(driver);
			ContactEmail1.clear();
			WaitAngular(driver);
			ContactEmail1.sendKeys(email);
			WaitAngular(driver);
		} catch (NoSuchElementException e) {
			log(e.getMessage());
		}
     }
	
	public void clickContactUpdate()
	{
		try {
			WaitAngular(driver);
			ContactUpdateBtn.click();
			WaitAngular(driver);
		} catch (NoSuchElementException e) {
			log(e.getMessage());
		}
     }


	public void ClickBookMarkDisabled() {
		try {
			log("Click Bookmark");
			BookMarkIconEnabled.click();
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
		try {
			log("Click Bookmark");
			BookMarkIconDisabled.click();
			WaitAngular(driver);
		} catch (NoSuchElementException e) {
			log(e.getMessage());
		}

	}

	public void SearchAccountWidget(String AccountId) throws InterruptedException {
		WaitAngular(driver);
		log("Click on Account Drop down");
		waitForObject(driver, AccountDropdown);
		AccountDropdown.click();
		log("Enter Account Name");
		WaitAngular(driver);
		waitForObject(driver, AccountSearchText);
		AccountSearchText.click();
		AccountSearchText.sendKeys(AccountId);
		WaitAngular(driver);
		waitForObject(driver, AccountSearchResult);
		AccountSearchResult.click();
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

		try {
			SummaryLink.click();
			WaitAngular(driver);
			Reporter.log("Summary Link Clicked");
		} catch (NoSuchElementException e) {
			log(e.getMessage());
		}
	}

	public void ClickTransactionLink() {

		try {
			TransactionLink.click();
			WaitAngular(driver);
			Reporter.log("Transaction Link Clicked");
		} catch (NoSuchElementException e) {
			log(e.getMessage());
		}
	}

	public HashMap<String, String> GetBillingInfo() {
		WaitAngular(driver);
		WaitForObjectbyId(driver, "BILL_Current_Balance");
		WaitForObjectbyId(driver, "BILL_Unposted_Balance");
		WaitForObjectbyId(driver, "BILL_Account_Balance");
		WaitForObjectbyId(driver, "BILL_Past_Due");
		HashMap<String, String> BillingInfo = new HashMap<String, String>();
		BillingInfo.put("BillDue", BILL_PastDue.getText());
		BillingInfo.put("BillCurrent", BILL_CurrentBalance.getText());
		BillingInfo.put("BillUnposted", BILL_UnpostedBalance.getText());
		BillingInfo.put("BillAccount", BILL_AccountBalance.getText());
		return BillingInfo;
	}

	public String GetLogUserName() throws InterruptedException {

		String result = "";
		try {
			WaitAngular(driver);
			if (LoggedUserLink.isDisplayed())
				result = LoggedUserLink.getText();
			Reporter.log("UserName found " + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public String GetLoggedCustomerId() throws InterruptedException {

		String result = "";
		try {
			WaitAngular(driver);
			if (CustomerId.isDisplayed())
				result = CustomerId.getText();
			Reporter.log("CustomerId found " + result);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;

	}

	public String GetLoggedCustomerLocationId() throws InterruptedException {

		String result = "";
		try {
			WaitAngular(driver);
			if (CustomerLocId.isDisplayed())
				result = CustomerLocId.getText();
			Reporter.log("Customer Location Id found " + result);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;

	}

	public String GetLoggedCustomerName() throws InterruptedException {

		String result = "";
		try {
			WaitAngular(driver);
			if (CustomerName.isDisplayed())
				result = CustomerName.getText();
			Reporter.log("Customer Name found " + result);
		} catch (Exception e) {
			e.printStackTrace();
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
		}

		return result;

	}

	public void LogOut() throws InterruptedException {
		try {
			WaitAngular(driver);
			waitForObject(this.driver, LoggedUserLink);
			if (LoggedUserLink.isDisplayed()) {
				LoggedUserLink.click();
				waitForObject(this.driver, LogOutLink);
				LogOutLink.click();
				WaitAngular(driver);
			} else {
				Assert.assertFalse(true, "Log out link not found");
			}
		} catch (NoSuchElementException | ElementClickInterceptedException e) {
			log(e.getMessage());
		}

	}

	public void ClickOk() throws InterruptedException {

		try {
			WaitAngular(driver);
			WaitForObjectbyId(this.driver, "ALERTO_Action_Button");
			if (AlertOk.isDisplayed()) {
				AlertOk.click();
				WaitAngular(driver);
				Reporter.log("Click Ok");
			}
		} catch (NoSuchElementException e) {
			log(e.getMessage());
		}
	}

	public void ClickDynamicOk() {

		try {
			if (AlertOk.isDisplayed()) {
				WaitAngular(driver);
				AlertOk.click();
				Reporter.log("Click Ok");
				WaitAngular(driver);
			}
		} catch (NoSuchElementException e) {
			Reporter.log("Alert not configured");
		}
	}

	public void ClickAlertDescription() throws InterruptedException {
		try {
			WaitAngular(driver);
			waitForObject(this.driver, AlertDesc);
			AlertDesc.click();
			WaitAngular(driver);
			Reporter.log("Click Description");
		} catch (NoSuchElementException e) {
			log(e.getMessage());
		}
	}

}
