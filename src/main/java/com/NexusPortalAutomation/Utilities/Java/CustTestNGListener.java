package com.NexusPortalAutomation.Utilities.Java;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class CustTestNGListener implements ITestListener {

	public static ReadProjectProperties Read = new ReadProjectProperties();

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Test started- " + result.getName());

	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Test completed successfully- " + result.getName());

	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub

		System.out.println("***** Error " + result.getName() + " test has failed *****");
		String methodName = result.getName().toString().trim();
		ITestContext context = result.getTestContext();
		WebDriver driver = (WebDriver) context.getAttribute("webDriver");
		takeScreenShot(methodName, driver);

	}

	public void takeScreenShot(String methodName, WebDriver driver) {

		String fileName = String.format(methodName + "Screenshot-%s.jpg", Calendar.getInstance().getTimeInMillis());
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// The below method will save the screen shot in d drive with test method name
		try {
			String filePath = Read.ReadFile("ScreenShots");
			String screenShotName = filePath + fileName;
			FileUtils.copyFile(scrFile, new File(filePath + fileName));
			/*
			 * Reporter.log("<p>***Placed screen shot at " + filePath + " ***</p>");
			 * Reporter.log("<p>  <img src='" + filePath + fileName +
			 * "' height='500' width='1500' />"); Reporter.log("<a alt=" + methodName +
			 * "></a></p>");
			 */
			Reporter.log(
					"<a href=\"" + screenShotName + "\"><align=\"left\">Error screenshot at " + new Date());
			Reporter.log("<img width=\"1024\" src=\"" + screenShotName + "\" alt=\"screenshot at " + new Date()
					+ "\"/></a><br />");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Test Skipped- " + result.getName());

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("Started- " + context.getName());

	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("Finished- " + context.getName());

	}

}
