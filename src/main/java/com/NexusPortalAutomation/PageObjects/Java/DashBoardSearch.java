package com.NexusPortalAutomation.PageObjects.Java;

import java.util.NoSuchElementException;

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
	WebElement searchBar;

	@FindBy(id = "SRCH_Button_Recent")
	@CacheLookup
	WebElement recentBar;

	@FindBy(css = "a.search-toolbar-btn:nth-child(2) > svg:nth-child(1)")
	@CacheLookup
	WebElement toolBarSaved;

	@FindBy(id = "SRCH_Option_1_Address_Line")
	WebElement SrchCustomer;

	@FindBy(id = "SRCH_Button_Favorites")
	@CacheLookup
	WebElement BookMarked;

	@FindBy(id = "SRCH_Option_1_City_State_Zip")
	WebElement RecentCustomerCityState;

	public DashBoardSearch(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterSearchText(String txt) {
		try {
			log("Enter Text for Search =" + txt);
			waitForObject(this.driver, searchBar);
			searchBar.sendKeys(txt);
			WaitAngular(driver);
			takeScreenShot(txt, driver);
		} catch (NoSuchElementException e) {
			e.getStackTrace();
		}
	}

	public void clickRecentSearch() {
		log("Click Recent");
		recentBar.click();
	}

	public void ClickSaved() throws InterruptedException {
		log("Tool Bar Clicked", driver);
		toolBarSaved.click();
	}

	public void clickCustomerName() {

		SrchCustomer.click();
		log("Click Customer", driver);
		WaitAngular(driver);

	}

	public String getRecentCustomerCity() {
		log("Recent Customer =" + RecentCustomerCityState.getText(), driver);
		return RecentCustomerCityState.getText();
	}

	public boolean clickRecentSearchCustomerName() {
		log("Recent Customer =" + RecentCustomerCityState.getText(), driver);
		try {
			RecentCustomerCityState.click();
			WaitAngular(driver);
			return true;
		} catch (NoSuchElementException e) {
			log("Bookmark not found", driver);
		}
		return false;
	}

	public void ClickHistoryCustomer() {

		BookMarked.click();
		WaitAngular(driver);
		log("Click BookMarked Customer", driver);
	}

}
