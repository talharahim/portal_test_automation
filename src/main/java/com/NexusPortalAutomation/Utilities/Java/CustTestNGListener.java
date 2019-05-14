package com.NexusPortalAutomation.Utilities.Java;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

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
		String fileName = String.format(methodName+"Screenshot-%s.jpg", Calendar.getInstance().getTimeInMillis());
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// The below method will save the screen shot in d drive with test method name
		try {
			String filePath = Read.ReadFile("ScreenShots");
			FileUtils.copyFile(scrFile, new File(filePath + fileName));
			System.out.println("***Placed screen shot in " + filePath + " ***");
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
