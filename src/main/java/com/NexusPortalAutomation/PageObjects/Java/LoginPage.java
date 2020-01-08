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
	WebElement username;
	
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

	public void Verifytitle(String title) {
		waitForObject(driver, username);
		Assert.assertEquals(driver.getTitle(), title, "Verifying title");
		log("Login Page title Verified");
	}

	public void Login(String username, String Password) throws InterruptedException {
		waitForObject(driver, this.username);
		this.username.sendKeys(username);
		waitForObject(driver, passWord);
		passWord.sendKeys(Password);
		waitForObject(driver, loginBtn);
		loginBtn.click();
		Thread.sleep(5000);
	}

}