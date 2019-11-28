package com.NexusPortalAutomation.PageObjects.Java;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Dashboard_Transactions extends DashBoard {
	/**
	 * All WebElements are identified by @FindBy annotation
	 * 
	 * @author Talha Rahim
	 * @since 2019-09-12
	 */
	@FindBy(id = "TRAN_Select_Type")
	WebElement Trans_type;

	@FindBy(id = "TRAN_Select_Type_Option_0")
	WebElement TransType_all;

	@FindBy(id = "TRAN_Select_Type_Option_3")
	WebElement TransType_bill;

	@FindBy(xpath = "//button[contains(text(),'Date')]")
	WebElement dateFilter;

	@FindBy(xpath = "//button[contains(text(),'Due/Billed')]")
	WebElement dueFilter;

	@FindBy(xpath = "//button[contains(text(),'Amount')]")
	WebElement amountFilter;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]")
	WebElement overlay;

	public Dashboard_Transactions(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void clickDateFilter_TransactionsRecord() {

		waitForObject(driver, dateFilter);
		dateFilter.click();

	}

	public void clickDueFilter_TransactionsRecord() {

		waitForObject(driver, dueFilter);
		dueFilter.click();

	}

	public void clickAmountFilter_TransactionsRecord() {

		waitForObject(driver, amountFilter);
		amountFilter.click();

	}

	public void transaction_filterbyBill() throws InterruptedException {
		Trans_type.click();
		TransType_all.click();
		Thread.sleep(2000);
		TransType_all.click();
		Thread.sleep(2000);
		TransType_bill.click();
	}

	public HashMap<String, String> getTransactionsRecord(int index) {
		WaitAngular(driver);
		WebElement drillback = waitforObjectById(driver, "TRAN_" + index + "_Drillback");
		WebElement docType = waitforObjectById(driver, "TRAN_Document_Type_" + index);
		WebElement transDesc = waitforObjectById(driver, "TRAN_Description_" + index);
		WebElement documentNum = waitforObjectById(driver, "TRAN__Document_Number_" + index);
		WebElement status = waitforObjectById(driver, "TRAN_Status_" + index);
		WebElement transAmount = waitforObjectById(driver, "TRAN_Amount_" + index);
		WebElement transDocDate = waitforObjectById(driver, "TRAN_Document_Date_" + index);
		WebElement transDueDate = waitforObjectById(driver, "TRAN_Reference_Date_" + index);
		WebElement outstanding = waitforObjectById(driver, "TRAN_Outstanding_" + index);

		HashMap<String, String> transactionDetails = new HashMap<String, String>();
		transactionDetails.put("drillback", drillback.getAttribute("href"));
		transactionDetails.put("docType", docType.getText());
		transactionDetails.put("transDesc", transDesc.getText());
		transactionDetails.put("documentNum", documentNum.getText());
		transactionDetails.put("status", status.getText());
		transactionDetails.put("transAmount", transAmount.getText());
		transactionDetails.put("transDocDate", transDocDate.getText());
		transactionDetails.put("transDueDate", transDueDate.getText());
		transactionDetails.put("outstanding", outstanding.getText());

		return transactionDetails;

	}

}
