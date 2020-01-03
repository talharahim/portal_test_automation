package com.NexusPortalAutomation.PageObjects.Java;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
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

public class GlobalOptions extends CommonMethods {

    static WebDriver driver;

    public GlobalOptions(WebDriver driver) {
	GlobalOptions.driver = driver;
	PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "/html/body/wo-root/wo-dashboard/csm-global-options/div/header/div[1]")
    public static WebElement Header;

    @FindBy(xpath = "/html/body/wo-root/wo-dashboard/csm-global-options/div/div/div/div/mat-expansion-panel/div/div/p[1]")
    public static WebElement contactLogtab;

    @FindBy(xpath = "/html/body/wo-root/wo-dashboard/csm-global-options/div/div/div/div/mat-expansion-panel/div/div/p[2]")
    public static WebElement transferRequest;
    
    @FindBy(xpath = "/html/body/wo-root/wo-dashboard/csm-global-options/div/header/div[2]/div")
    public static WebElement backtoaccounts;
    
    public static String getPageHeader()
    {
	waitForObject(driver, Header);
	return Header.getText();
    }
    
    public static String contactLogtab()
    {
	waitForObject(driver, contactLogtab);
	return contactLogtab.getText();
    }
    
    public static String transferRequest()
    {
	waitForObject(driver, transferRequest);
	return transferRequest.getText();
    }
    
    public static void backtoaccounts()
    {
	waitForObject(driver, backtoaccounts);
	backtoaccounts.click();
    }


}
