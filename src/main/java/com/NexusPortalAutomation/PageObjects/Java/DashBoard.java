package com.NexusPortalAutomation.PageObjects.Java;

import java.util.HashMap;

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

	public DashBoard(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void verifyAddressDetails(String addline, String addCity, String addState, String addZip) {
		log("Verifying Address Details");

		VerifyString(addline, AddressLine.getText());
		VerifyString(addCity, AddressCity.getText());
		VerifyString(addState, AddressState.getText());
		VerifyString(addZip, AddressZipCode.getText());

	}

	public void ClickSummaryLink() {
		SummaryLink.click();
		Reporter.log("Summary Link Clicked");
	}

	public void ClickTransactionLink() {
		TransactionLink.click();
		Reporter.log("Transaction Link Clicked");
	}

	public HashMap<String, String> GetBillingInfo() {
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
			if (CustomerAddress.isDisplayed())
				result = CustomerAddress.getText();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;

	}

	public void LogOut() throws InterruptedException {

		waitForObject(this.driver, LoggedUserLink);
		if (LoggedUserLink.isDisplayed()) {
			LoggedUserLink.click();
			waitForObject(this.driver, LogOutLink);
			LogOutLink.click();
		} else {
			Assert.assertFalse(true, "Log out link not found");
		}

	}

	public void ClickOk() throws InterruptedException {
		WaitForObjectbyId(this.driver, "ALERTO_Action_Button");
		Thread.sleep(300);
		if (AlertOk.isDisplayed()) {
			AlertOk.click();
			Reporter.log("Click Ok");
		}
	}

	public void ClickDynamicOk() {
		try {
			if (AlertOk.isDisplayed()) {
				AlertOk.click();
				Reporter.log("Click Ok");
			}
		} catch (NoSuchElementException e) {
			Reporter.log("Alert not configured");
		}
	}

	public void ClickAlertDescription() throws InterruptedException {
		waitForObject(this.driver, AlertDesc);
		AlertDesc.click();
		Reporter.log("Click Description");
	}

}
