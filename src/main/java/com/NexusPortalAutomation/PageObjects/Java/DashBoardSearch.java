package com.NexusPortalAutomation.PageObjects.Java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.NexusPortalAutomation.Utilities.Java.CommonMethods;

/**
 * 
 * This Class will be for DashBoard Search Page (First Page After Login) All
 * WebElements are identified by @FindBy annotation
 * 
 * @author Talha Rahim
 * @since 2019-04-25
 */

public class DashBoardSearch extends CommonMethods {

	WebDriver driver;
	@FindBy(id = "SRCH_Input")
	@CacheLookup
	WebElement searchBar;

	@FindBy(id = "SRCH_Button_Recent")
	@CacheLookup
	WebElement recentBar;

	@FindBy(css = "a.search-toolbar-btn:nth-child(2) > svg:nth-child(1)")
	@CacheLookup
	WebElement toolBarSaved;

	@FindBy(id = "SRCH_Option_1_Address_Line")
	@CacheLookup
	WebElement SrchCustomer;

	@FindBy(id = "SRCH_Button_Favorites")
	@CacheLookup
	WebElement BookMarked;

	@FindBy(id = "SRCH_Option_1_Address_Line")
	WebElement RecentCustomerName;

	// @ByAngularBinding.FindBy(rootSelector = "i18n", binding = "cheese")
	// public WebElement findBy_binding;

	public DashBoardSearch(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void EnterSearchText(String txt) {
		log("Enter Text for Search =" + txt);
		waitForObject(this.driver, searchBar);
		searchBar.sendKeys(txt);
		WaitAngular(driver);
	}

	public void ClickRecent() {
		log("Click Recent");
		recentBar.click();
	}

	public void ClickSaved() throws InterruptedException {

		log("Tool Bar Clicked");
		toolBarSaved.click();
	}

	public void ClickCustomer() {
		log("Click Customer");
		SrchCustomer.click();
		WaitAngular(driver);
	}

	public String GetRecentCustomerName() {
		log("Recent Customer =" + RecentCustomerName.getText());
		return RecentCustomerName.getText();
	}

	public void ClickRecentCustomerName() {
		log("Recent Customer =" + RecentCustomerName.getText());
		RecentCustomerName.click();
	}

	public void ClickHistoryCustomer() {
		log("Click BookMarked Customer");
		BookMarked.click();
	}

}
