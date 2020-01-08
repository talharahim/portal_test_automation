package com.NexusPortalAutomation.TestCases.Java;

import java.sql.SQLException;

import org.testng.annotations.Test;

import com.NexusPortalAutomation.Utilities.Java.DataBackupRestore;

public class DataBackup extends BaseClass {

	/*
	 * This Class Will Test the search by Customer ID
	 * @author Talha Rahim
	 *  @version 1.0
	 *  @Since 2019-09-11
	 */

//This Test will Create Test Data Backup
//	@Test(priority = 1)
	public void runDataBackup() throws ClassNotFoundException, SQLException {

		DataBackupRestore DataRes = new DataBackupRestore();
		DataRes.CompanyDBBackup();

	}

}
