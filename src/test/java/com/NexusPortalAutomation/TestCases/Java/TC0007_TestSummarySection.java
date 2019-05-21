package com.NexusPortalAutomation.TestCases.Java;

import java.io.IOException;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.NexusPortalAutomation.PageObjects.Java.DashBoard;
import com.NexusPortalAutomation.PageObjects.Java.DashBoardSearch;
import com.NexusPortalAutomation.Utilities.Java.CommonMethods;

public class TC0007_TestSummarySection extends BaseClass {

	public String UserName = "Mr. Automation Mate";
	public CommonMethods ComMethd = new CommonMethods();

	@Test(priority = 2)
	public void TestSummarySectionOnChange() throws IOException, InterruptedException {
		DashBoardSearch dbSrch = new DashBoardSearch(driver);
		DashBoard dashBoard = new DashBoard(driver);
		login();
		ComMethd.WaitForObjectbyXpath(driver, "//input[@id='SRCH_Input']");
		ComMethd.WaitForObjectbyId(driver, "toolbar-saved");
		WaitAngular();
		dbSrch.EnterSearchText("Automation");
		dbSrch.ClickCustomer();
		ComMethd.WaitForObjectbyXpath(driver, "//div[@class='address-details']");
		// Verify Login Name
		boolean Match = ComMethd.VerifyString(UserName, dashBoard.GetLoggedCustomerName());
		if (!Match) {
			log("User Name Not Matched");
			Assert.assertTrue(false);

		} else {
			log("User Name verified =" + UserName);
			Assert.assertTrue(true);
			// Adding to Report

		}
		HashMap<String, String> BillingMap1 = dashBoard.GetBillingInfo();
		dashBoard.ClickTransactionLink();
		dashBoard.ClickSummaryLink();
		HashMap<String, String> BillingMap2 = dashBoard.GetBillingInfo();

		try {
			for (String k : BillingMap2.keySet()) {
				if (!BillingMap1.get(k).equals(BillingMap2.get(k))) {
					System.err.println("values not matched" + BillingMap1.get(k) + " != " + BillingMap2.get(k));
					log("values not matched" + BillingMap1.get(k) + " != " + BillingMap2.get(k));
					Assert.assertTrue(false);
				} else {
					log(BillingMap1.get(k) + " equals" + BillingMap2.get(k));
				}
			}

			for (String y : BillingMap1.keySet()) {
				if (!BillingMap2.containsKey(y)) {
					Assert.assertTrue(false);
				} else {
					log(BillingMap1.get(y) + " equals" + BillingMap2.get(y));
				}
			}
		} catch (NullPointerException np) {
			Assert.assertTrue(false);
		}

		dashBoard.LogOut();

	}

}
