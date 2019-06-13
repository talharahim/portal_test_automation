package com.NexusPortalAutomation.TestCases.Java;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.NexusPortalAutomation.PageObjects.Java.LoginPage;
import com.NexusPortalAutomation.Utilities.Java.ReadProjectProperties;
import com.paulhammant.ngwebdriver.NgWebDriver;

/*
 * This Class Will initiate the project setup and cleanup the launched applications
 * This includes Browser Type and Application
 * @author Talha Rahim
 * @version 1.0
 * @Since 2019-04-11
 */

public class BaseClass extends ReadProjectProperties {

	public static WebDriver driver;
	public static String browserName;
	public static NgWebDriver ngWebDriver;
	public static ReadProjectProperties Read = new ReadProjectProperties();
	public static int delay = 2000;
	public static String DrillBackServURL;
	
	public  String GetDrillBackServerURL() {
		DrillBackServURL = Read.ReadFile("DrillBackServ");
		return DrillBackServURL;

	}

	

	// This method writes in report
	public void log(String message) {
		Reporter.log(message);
		System.out.println(message);
	}

	public static void WaitAngular() {
		long begin = System.currentTimeMillis();
		ngWebDriver.waitForAngularRequestsToFinish();
		long end = System.currentTimeMillis();
		long dt = end - begin;
		Reporter.log("Angular Request Completed in " + dt + "ms");
		System.out.println("Angular Request Completed in " + dt + "ms");
	}

	public static void Delay() {
		try {
			Thread.sleep(delay);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@BeforeClass
	public void readProp(ITestContext context) throws AWTException, IOException {
		// Minimize all windows
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_WINDOWS);
		robot.keyPress(KeyEvent.VK_D);
		robot.keyRelease(KeyEvent.VK_D);
		robot.keyRelease(KeyEvent.VK_WINDOWS);

		browserName = Read.ReadFile("CurrentBrowser");

		if (browserName.contains("Firefox")) {
			// Launching Firefox
			// Setting up Webdriver and path
			String fDriver = Read.ReadFile("FirefoxDriverPath");
			String browserPath = Read.ReadFile("FirefoxInstallPath");
			System.setProperty("webdriver.gecko.driver", fDriver);
			// Creating Instance for Firefox
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.setBinary(browserPath);
			firefoxOptions.setCapability("marionette", true);
			driver = new FirefoxDriver(firefoxOptions);
			log("Firefox Launched");

		}

		else if (browserName.contains("Chrome")) {

			// Launching Chrome
			log("Launching Chrome");
			// Setting up Webdriver and path
			String cDriver = Read.ReadFile("ChromeDriverPath");
			String browserPath = Read.ReadFile("ChromeInstallPath");
			System.setProperty("webdriver.chrome.driver", cDriver);
			// Creating Instance for Chrome
			ChromeOptions ChromeOptions = new ChromeOptions();
			ChromeOptions.setBinary(browserPath);
			driver = new ChromeDriver(ChromeOptions);

		}

		else {
			log("Browser Name not found");
		}
		ngWebDriver = new NgWebDriver((JavascriptExecutor) driver);
		driver.manage().window().maximize();
		log("Browser Maximised");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		context.setAttribute("webDriver", driver);
		
	

	}

	public void login() throws IOException, InterruptedException {
		driver.get(Read.ReadFile("PortalUrl"));
		LoginPage lpage = new LoginPage(driver);
		WaitAngular();
		lpage.VerifyTitle("Sign in");
		lpage.Login(Read.ReadFile("UserName"), Read.ReadFile("PassWord"));
		WaitAngular();
		String actualTitle = driver.getTitle();
		String expectedTitle = "Portal";
		assertEquals(expectedTitle, actualTitle);
		log("User signed " + Read.ReadFile("UserName"));

	}

	@AfterClass
	void TearDown() {

		log("Closing Browser");
		driver.close();
		log("Test Completed...");

	}

}
