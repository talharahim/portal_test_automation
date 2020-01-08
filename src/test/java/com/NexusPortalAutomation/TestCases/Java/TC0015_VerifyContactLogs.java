package com.NexusPortalAutomation.TestCases.Java;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.Test;

import com.NexusPortalAutomation.PageObjects.Java.DashBoard;
import com.NexusPortalAutomation.PageObjects.Java.DashBoardSearch;
import com.NexusPortalAutomation.Utilities.Java.CommonMethods;

public class TC0015_VerifyContactLogs extends BaseClass {

    /*
     * This test the search by Recent Customer Name
     * 
     * @author Talha Rahim
     * 
     * @version 1.0
     * 
     * @Since 2019-04-11
     */

    public String locationID = getCellvalue("TC0015", "locationEdit");// "LOC@0004";

    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    Date date = new Date();

    // String comments = "Notes added" + dateFormat.format(date);
//
    @Test(priority = 1)
    public void TestContactLogs() throws IOException, InterruptedException, ClassNotFoundException, SQLException {
	DashBoardSearch dbSrch = new DashBoardSearch(driver);
	DashBoard dashBoard = new DashBoard(driver);
	String ConnectionString = Read.ReadFile("ConnectionStringServDynamics");
	String Command1 = "SELECT * FROM DYNAMICS.dbo.DU000020 where prodid = 6139";
	boolean enhenabled = false;
	String Result = CommonMethods.selectFromDb(Command1, ConnectionString, "companyID");
	if (Result != "") {
	    log("Enhanced Notes Disabled");
	} else {
	    log("Enhanced Notes Enabled");
	    enhenabled = true;
	}
	login();
	dbSrch.enterSearchText(locationID);
	dbSrch.clickCustomerName();
	// Verify Customer Location Id Updated for Test
	CommonMethods.verifyString(locationID, dashBoard.getLoggedCustomerLocationId());
	// Verify Contact is updated accordingly
	/// dashBoard.AddNotes(Comments); -- Functionality Removed
	// Verify Updated details
	// CommonMethods.VerifyString(dashBoard.GetNotes(), Comments); -- Functionality
	// Removed
	dashBoard.verifyNotesDrillbacks(enhenabled);
	dashBoard.logout();
    }

}
