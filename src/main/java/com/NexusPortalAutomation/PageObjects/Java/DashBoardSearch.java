package com.NexusPortalAutomation.PageObjects.Java;

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

	@FindBy(xpath = "/html/body/div[2]/div/div/mat-option[1]/span/div[1]/div[1]/div/div[1]")
	@CacheLookup
	WebElement SrchCustomer;

	@FindBy(css = "#SRCH_Button_Favorites > svg:nth-child(1)")
	@CacheLookup
	WebElement HistCustomer;

	@FindBy(id = "SRCH_Option_1_Address_Line")
	@CacheLookup
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
	}

	public String GetRecentCustomerName() {
		log("Recent Customer =" + RecentCustomerName.getText());
		return RecentCustomerName.getText();
	}

	public void ClickHistoryCustomer() {
		log("Click History Customer");
		HistCustomer.click();
	}

}
