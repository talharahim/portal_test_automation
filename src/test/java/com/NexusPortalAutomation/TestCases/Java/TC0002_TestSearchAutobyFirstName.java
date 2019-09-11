package com.NexusPortalAutomation.TestCases.Java;

import java.io.IOException;

import org.testng.annotations.Test;

import com.NexusPortalAutomation.PageObjects.Java.DashBoard;
import com.NexusPortalAutomation.PageObjects.Java.DashBoardSearch;
import com.NexusPortalAutomation.Utilities.Java.CommonMethods;
import com.NexusPortalAutomation.Utilities.Java.ExcelData;

public class TC0002_TestSearchAutobyFirstName extends BaseClass {

	public String username = ExcelData.ReadVariant("Customers",2,1);
	CommonMethods commonMethod = new CommonMethods();
	public String title = "Mr.";
	/*
	 * This test the search by Customer's First Name
	 * 
	 * @author Talha Rahim
	 * 
	 * @version 1.0
	 * 
	 * @Since 2019-04-11
	 */

//This Test will test the search by Customer's First Name
	@Test(priority = 2)
	public void TestSearchAutobyFirstName() throws IOException, InterruptedException {
		DashBoardSearch dbSrch = new DashBoardSearch(driver);
		DashBoard dashBoard = new DashBoard(driver);
		login();
		dbSrch.enterSearchText(username);
		dbSrch.clickCustomerName();
		// Verify Login Name
		
		commonMethod.verifyString(title, dashBoard.getCustomertitle());
		commonMethod.verifyString(username, dashBoard.getLoggedCustomerName());
		dashBoard.logout();

	}

}
