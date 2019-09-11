package com.NexusPortalAutomation.TestCases.Java;

import java.io.IOException;

import org.testng.annotations.Test;

import com.NexusPortalAutomation.PageObjects.Java.DashBoard;
import com.NexusPortalAutomation.PageObjects.Java.DashBoardSearch;
import com.NexusPortalAutomation.Utilities.Java.CommonMethods;
import com.NexusPortalAutomation.Utilities.Java.ExcelData;

public class TC0001_VerifySignInbyID extends BaseClass {

	
	public String customerID = ExcelData.ReadVariant("Customers",1,1);
	//public String customerID = "0000011111";
	CommonMethods commonMethod = new CommonMethods();
	/*
	 * This Class Will Test the search by Customer ID
	 * @author Talha Rahim
	 * @version 1.0
	 *  @Since 2019-04-11
	 */
 //This Test will test the search by Customer ID
	@Test(priority = 1)
	public void VerifySignInbyID() throws IOException, InterruptedException {
		DashBoardSearch dashBoardSearch = new DashBoardSearch(driver);
		DashBoard dashBoard = new DashBoard(driver);
		login();
		dashBoardSearch.enterSearchText(customerID);
		dashBoardSearch.clickCustomerName();
		// Verify Login Name Updated for Test
		commonMethod.verifyString(customerID, dashBoard.getLoggedCustId());
		dashBoard.logout();
	}

}
