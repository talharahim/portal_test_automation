package com.NexusPortalAutomation.Utilities.Java;

import java.awt.geom.Point2D;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Finder;
import org.sikuli.script.Match;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SikuliUtility extends CommonMethods {

	public static double tolerance = 0.9;
	// @Test
	public void nexusPortalLogin() throws FindFailed {

		// Creating Object of 'Screen' class
		// Screen is a base class provided by Sikuli. It allows us to access all the
		// methods provided by Sikuli.
		Screen screen = new Screen();
		// Creating Object of Pattern class and specify the path of specified images
		// I have captured images of portal field, Password field and Login
		// button and placed in my local directory
		Pattern username = new Pattern("./\\TestData\\sikuliimages\\username.png");
		// portal password image
		Pattern password = new Pattern("./\\TestData\\sikuliimages\\password.png");
		// portal login button image
		Pattern login = new Pattern("./\\TestData\\sikuliimages\\signinbutton.png");
		// Initialization of driver object to launch firefox browser
		System.setProperty("webdriver.gecko.driver", "./\\drivers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		// To maximize the browser
		driver.manage().window().maximize();
		// Open portal
		driver.get("http:localhost:3000");
		screen.wait(username, 3);
		// Calling 'type' method to enter username in the email field using 'screen'
		// object
		screen.type(username, "Admin2019");
		// Calling the same 'type' method and passing text in the password field
		screen.type(password, "Admin");

		screen.click(login);
	}

	public static void compareImage(String path, WebDriver driver) throws IOException {

		String fileName = String.format("Screenshot-%s.jpg", Calendar.getInstance().getTimeInMillis());
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// The below method will save the screen shot in d drive with test method name
		String filePath = Read.ReadFile("ScreenShots");
		String screenShotName = filePath + fileName;
		FileUtils.copyFile(scrFile, new File(screenShotName));

		Pattern searchImage = new Pattern(path).similar((float) tolerance);
		String ScreenImage = screenShotName; // In this case, the image you want to search
		Finder objFinder = null;
		Match objMatch = null;
		objFinder = new Finder(ScreenImage);
		objFinder.find(searchImage); // searchImage is the image you want to search within ScreenImage
		int counter = 0;
		while (objFinder.hasNext()) {
			objMatch = objFinder.next(); // objMatch gives you the matching region.
			counter++;
		}
		if (counter != 0) {
			System.out.println("Match Found at x:" + objMatch.x + " y:" + objMatch.y);
		} else {
			Assert.fail("image not matched ");
		}

	}

}