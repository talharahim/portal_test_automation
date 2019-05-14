package com.NexusPortalAutomation.Utilities.Java;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

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

	public boolean VerifyString(String str1, String str2) {
		boolean result = false;
		if (str1 != "" && str2 != "") {
			Assert.assertEquals(str1, str2);
			result = true;
			System.out.println("Strings Matched: " + str1 + " =" + str2);
		} else {
			Assert.assertFalse(true);
		}
		return result;

	}

	// This method will wait until object is visible
	public void WaitForObject(WebDriver driver, String xpath) {
		long begin = System.currentTimeMillis();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
		if (element.isDisplayed()) {
			long end = System.currentTimeMillis();
			long dt = end - begin;
			System.out.println(element.getText() + "is displayed in " + dt / 1000 + "seconds");
		}
	}

	public void WaitForObjectbyId(WebDriver driver, String id) {
		long begin = System.currentTimeMillis();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id(id)));
		if (element.isDisplayed()) {
			long end = System.currentTimeMillis();
			long dt = end - begin;
			System.out.println(element.getText() + "is displayed in " + dt / 1000 + "seconds");
		}
	}

	public void takeScreenShot(String TestName, WebDriver driver) {
		String fileName = String.format(TestName + "Screenshot-%s.jpg", Calendar.getInstance().getTimeInMillis());
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// The below method will save the screen shot
		try {
			String filePath = Read.ReadFile("PassScreenShot");
			FileUtils.copyFile(scrFile, new File(filePath + fileName));
			System.out.println("***Placed screen shot in " + filePath + " ***");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void waitForObject(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 90);
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (TimeoutException e) {
			throw new TimeoutException("Object Not Found", e);
		}
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
