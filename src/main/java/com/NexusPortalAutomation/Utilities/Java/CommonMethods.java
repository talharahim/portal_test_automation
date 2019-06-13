package com.NexusPortalAutomation.Utilities.Java;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.paulhammant.ngwebdriver.NgWebDriver;

/**
 * 
 * This Class will be used for common methods
 * 
 * @author Talha Rahim
 * @since 2019-05-04
 */

public class CommonMethods {
//This method will compare string values
	public static ReadProjectProperties Read = new ReadProjectProperties();
	public static NgWebDriver ngWebDriver;

	public CommonMethods() {
		// this is the default const
	}

	// This method will be utilized in for PF classes not in TestCases
	public static void WaitAngular(WebDriver driver) {
		long begin = System.currentTimeMillis();
		NgWebDriver ngWebDriver = new NgWebDriver((JavascriptExecutor) driver);
		ngWebDriver.waitForAngularRequestsToFinish();
		long end = System.currentTimeMillis();
		long dt = end - begin;
		log("Angular request time " + dt + "ms");
	}
	
	

	public boolean VerifyString(String str1, String str2) {
		boolean result = false;
		if (str1 != "" && str2 != "") {
			if (str1.equals(str2)) {
				result = true;
				log("Strings Matched: " + str1 + " = " + str2);
				
			} else {
				log("Strings Not Matched: " + str1 + " != " + str2);
				Assert.assertEquals(str2, str1);
			}
		}
		return result;

	}
	
	public boolean VerifyStringContains(String str1, String str2) {
		boolean result = false;
		if (str1 != "" && str2 != "") {
			if (str1.contains(str2)) {
				result = true;
				log("Strings Matched: " + str1 + " = " + str2);
				
			} else {
				log("Strings Not Matched: " + str1 + " != " + str2);
				Assert.assertEquals(str2, str1);
			}
		}
		return result;

	}

	public static void log(String message) {
		Reporter.log(message);
		System.out.println(message);
	}

	public void WaitForObjectbyId(WebDriver driver, String id) {
		long begin = System.currentTimeMillis();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id(id)));
		
		if (element.isDisplayed()) {
			long end = System.currentTimeMillis();
			long dt = end - begin;
			log("Element '"+id+"' is displayed in " + dt + "ms");
		}
	}
	
	public void WaitForObjectbyElement(WebDriver driver, WebElement webElement) {
		long begin = System.currentTimeMillis();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(webElement));
		
		if (element.isDisplayed()) {
			long end = System.currentTimeMillis();
			long dt = end - begin;
			log("Element '"+webElement.toString()+"' is displayed in " + dt + "ms");
		}
	}


	public void WaitForObjectbyXpath(WebDriver driver, String path) {
		long begin = System.currentTimeMillis();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(path)));
		if (element.isDisplayed()) {
			long end = System.currentTimeMillis();
			long dt = end - begin;
			log("Element '"+path+"' is displayed in " + dt + "ms");
		}
	}

	public void takeScreenShot(String TestName, WebDriver driver) {
		String fileName = String.format(TestName + "Screenshot-%s.jpg", Calendar.getInstance().getTimeInMillis());
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// The below method will save the screen shot
		try {
			String filePath = Read.ReadFile("PassScreenShot");
			FileUtils.copyFile(scrFile, new File(filePath + fileName));
			log("***Placed screen shot in " + filePath + " ***");
		} catch (IOException e) {
			e.printStackTrace();
			Assert.assertTrue(false, "Unable to take Screenshot");
		}
	}

	public void waitForObject(WebDriver driver, WebElement element) {
		long begin = System.currentTimeMillis();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		try {
			wait.until(ExpectedConditions.visibilityOf(element));

		} catch (TimeoutException e) {

			Assert.assertTrue(false, "Object Not Found");
			throw new TimeoutException("Object Not Found", e);
		}
		long end = System.currentTimeMillis();
		long dt = end - begin;
		log("Element "+ element.toString()+ " displayed in " + dt + "ms");
	}

	public boolean CheckStringmapsAreEqual(Map<String, String> mapA, Map<String, String> mapB) {

		try {
			for (String k : mapB.keySet()) {
				if (!mapA.get(k).equals(mapB.get(k))) {
					return false;
				}
			}
			for (String y : mapA.keySet()) {
				if (!mapB.containsKey(y)) {
					return false;
				}
			}
		} catch (NullPointerException np) {
			return false;
		}
		return true;
	}
	
	

}
