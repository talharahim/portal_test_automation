package com.NexusPortalAutomation.Utilities.Java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Match;
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

	public void compareImage(String path) {
		
		Screen screen = new Screen();
		Pattern image = new Pattern(path);
		Match m = screen.exists(image.exact());
		if (m != null) {
			
			log("image verified at " + path);
		}
		else {
			Assert.fail("Image not matched "+ path);
		}

	}

}