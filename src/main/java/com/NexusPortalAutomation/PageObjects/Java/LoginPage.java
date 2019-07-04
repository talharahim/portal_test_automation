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
	@FindBy(id = "username")
	@CacheLookup
	WebElement userName;
	
	@FindBy(id = "password")
	@CacheLookup
	WebElement passWord;
	
	@FindBy(id = "kc-header-wrapper")
	@CacheLookup
	WebElement titleText;
	
	@FindBy(id = "kc-login")
	@CacheLookup
	WebElement loginBtn;

	public LoginPage(WebDriver driver) {

		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}

	public void VerifyTitle(String title) {
		waitForObject(driver, titleText);
		Assert.assertEquals(titleText.getText(), title, "Verifying Title");
		log("Login Page Title Verified");
	}

	public void Login(String Username, String Password) throws InterruptedException {
		waitForObject(driver, userName);
		userName.sendKeys(Username);
		waitForObject(driver, passWord);
		passWord.sendKeys(Password);
		waitForObject(driver, loginBtn);
		loginBtn.click();
		Thread.sleep(5000);
	}

}