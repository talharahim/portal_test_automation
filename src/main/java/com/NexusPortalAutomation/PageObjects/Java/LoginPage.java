package com.NexusPortalAutomation.PageObjects.Java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

public class LoginPage extends CommonMethods {

	WebDriver driver;
	@FindBy(xpath = "//input[@id='mat-input-0']")
	@CacheLookup
	WebElement userName;
	@FindBy(xpath = "//input[@id='mat-input-1']")
	@CacheLookup
	WebElement passWord;
	@FindBy(xpath = "//div[@class='login-title']")
	@CacheLookup
	WebElement titleText;
	@FindBy(xpath = "//span[@class='label ng-star-inserted']")
	@CacheLookup
	WebElement loginBtn;

	public LoginPage(WebDriver driver) {

		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}

	public void VerifyTitle(String title) {
		Assert.assertEquals(titleText.getText(), title, "Verifying Title");
		log("Sign in Page Title Verified");
	}

	public void Login(String Username, String Password) throws InterruptedException {
		userName.sendKeys(Username);
		passWord.sendKeys(Password);
		loginBtn.click();
		Thread.sleep(5000);
	}

}