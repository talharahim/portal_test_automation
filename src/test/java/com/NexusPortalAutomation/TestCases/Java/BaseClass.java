package com.NexusPortalAutomation.TestCases.Java;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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
	private static Logger LOG = LogManager.getLogger(BaseClass.class);
	public static NgWebDriver ngWebDriver;
	public static ReadProjectProperties Read = new ReadProjectProperties();
	public static int delay = 2000;
	final String ESCAPE_PROPERTY = "org.uncommons.reportng.escape-output";
   

	public void log(String message)
	{
		Reporter.log("<p>"+message+"</p>");
	}
	public static void WaitAngular() {
		ngWebDriver.waitForAngularRequestsToFinish();
		//Delay();
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
	public void readProp(ITestContext context) {
		try {

			browserName = Read.ReadFile("CurrentBrowser");

			if (browserName.contains("Firefox")) {
				// Launching Firefox
				LOG.info("Launching Firefox");
				// Setting up Webdriver and path
				String fDriver = Read.ReadFile("FirefoxDriverPath");
				String browserPath = Read.ReadFile("FirefoxInstallPath");
				System.setProperty("webdriver.gecko.driver", fDriver);
				System.setProperty(ESCAPE_PROPERTY, "false");
				// Creating Instance for Firefox
				FirefoxOptions firefoxOptions = new FirefoxOptions();
				firefoxOptions.setBinary(browserPath);
				firefoxOptions.setCapability("marionette", true);
				driver = new FirefoxDriver(firefoxOptions);
				log("Firefox Launched");

			}

			else if (browserName.contains("Chrome")) {

				// Launching Chrome
				LOG.info("Launching Chrome");
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
				LOG.error("Browser Name not found");
			}
			ngWebDriver = new NgWebDriver((JavascriptExecutor) driver);
			driver.manage().window().maximize();
			log("Browser Maximised");
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
			context.setAttribute("webDriver", driver);

		} catch (IOException e) {
			e.printStackTrace();
		}

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
		log("User signed "+Read.ReadFile("UserName"));

	}
	
		
	@AfterClass
	void TearDown() {

		LOG.info("Closing Browser");
		log("All Tests Completed...");
		driver.close();

	}

}
