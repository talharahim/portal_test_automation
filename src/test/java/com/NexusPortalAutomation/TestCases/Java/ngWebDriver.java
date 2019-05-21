package com.NexusPortalAutomation.TestCases.Java;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.NexusPortalAutomation.PageObjects.Java.DashBoard;
import com.NexusPortalAutomation.PageObjects.Java.DashBoardSearch;
import com.paulhammant.ngwebdriver.ByAngular;

public class ngWebDriver extends BaseClass {
	
	@Test	
	 public void find_by_angular_model() throws IOException, InterruptedException {

	        //driver.get("http://www.angularjshub.com/code/examples/basics/02_TwoWayDataBinding_HTML/index.demo.php");
		DashBoardSearch dbSrch = new DashBoardSearch(driver);
		DashBoard dashBoard = new DashBoard(driver);
		login();
		dbSrch.EnterSearchText("Automation");
		dbSrch.ClickCustomer();
	    WebElement test = driver.findElement(By.id("'CUST_Drillback_Button'"));
	    test.click();
	    Thread.sleep(5000);
	 
	}

}
