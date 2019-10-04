package com.NexusPortalAutomation.Utilities.Java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SikuliUtility extends CommonMethods {

	// @Test
	public void nexusPortalLogin() throws FindFailed {

		// Creating Object of 'Screen' class
		// Screen is a base class provided by Sikuli. It allows us to access all the
		// methods provided by Sikuli.
		Screen screen = new Screen();
		// Creating Object of Pattern class and specify the path of specified images
		// I have captured images of Facebook Email id field, Password field and Login
		// button and placed in my local directory
		// Facebook user id image
		Pattern username = new Pattern("./\\TestData\\sikuliimages\\username.png");
		// Facebook password image
		Pattern password = new Pattern("./\\TestData\\sikuliimages\\password.png");
		// Facebook login button image
		Pattern login = new Pattern("./\\TestData\\sikuliimages\\signinbutton.png");
		// Initialization of driver object to launch firefox browser
		System.setProperty("webdriver.gecko.driver", "./\\drivers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		// To maximize the browser
		driver.manage().window().maximize();
		// Open Facebook
		driver.get("http://localhost:3000");
		screen.wait(username, 3);
		// Calling 'type' method to enter username in the email field using 'screen'
		// object
		screen.type(username, "Admin2019");
		// Calling the same 'type' method and passing text in the password field
		screen.type(password, "Admin");

		screen.click(login);
	}

	public void compareImage(String path) {
		Screen screen = new Screen();
		Pattern image = new Pattern(path);
		try {
			if (screen.wait(image, 10) != null) {
				log("image verified at " + path);
			}
		} catch (FindFailed e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.fail("image at " + path + " not verified");
		}

	}

}
