package com.NexusPortalAutomation.PageObjects.Java;

import java.util.HashMap;

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

public class DashBoard {

	CommonMethods Com = new CommonMethods();
	WebDriver driver;
	@FindBy(css = ".user > a:nth-child(1)")
	@CacheLookup
	WebElement LoggedUserLink;

	@FindBy(css = ".logout-label")
	@CacheLookup
	WebElement LogOutLink;

	@FindBy(css = ".customer-info-id")
	@CacheLookup
	WebElement CustomerId;

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

	public DashBoard(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
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
		Com.waitForObject(this.driver, LoggedUserLink);
		if (LoggedUserLink.isDisplayed()) {
			LoggedUserLink.click();
			Com.waitForObject(this.driver, LogOutLink);
			LogOutLink.click();
		} else {
			Assert.assertFalse(true, "Log out link not found");
		}

	}

	public void ClickOk() throws InterruptedException {
		Com.waitForObject(this.driver, AlertOk);
		if (AlertOk.isDisplayed()) {
			AlertOk.click();
			Reporter.log("Click Ok");
		}
	}

	public void ClickAlertDescription() throws InterruptedException {
		Com.waitForObject(this.driver, AlertDesc);

		AlertDesc.click();
		Reporter.log("Click Description");
	}

}
