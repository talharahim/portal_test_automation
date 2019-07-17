package com.NexusPortalAutomation.Utilities.Java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.microsoft.sqlserver.jdbc.SQLServerException;

public class MySQLDataExec extends CommonMethods {

	public static ReadProjectProperties Read = new ReadProjectProperties();
	public String ConnectionString = Read.ReadFile("ConnectionStringServTWO");
	String Result;

	// This Method will delete Service Orders by Location
	public void DeleteServiceOrders(String Location) throws ClassNotFoundException, SQLException, SQLServerException {

		String columnName = "soServiceOrderNumber";
		String Command1 = "select * from [SO10100] where umLocationID ='" + Location + "'";
		String Result = selectFromDb(Command1, ConnectionString, columnName);
		log("Deleting Records for " + Result);
		String Command2 = "delete from [SO10101] WHERE soServiceOrderNumber ='" + Result + "'";
		deleteFromDb(Command2, ConnectionString);
		String Command3 = "delete from SO10100 where umLocationID  ='" + Location + "'";
		deleteFromDb(Command3, ConnectionString);
	}

	public void DeleteServiceOrdersHistory(String Location)
		throws ClassNotFoundException, SQLException, SQLServerException {
		String Command1 = "select * from um00600h where umAccumType = 0 and umLocationID ='" + Location + "'";
		String Result = selectFromDb(Command1, ConnectionString, "umAccumType");
		if (!Result.isEmpty()) {
			log("Deleting Records for " + Location);
			String Command2 = "delete from [UM00600H] WHERE umLocationID ='" + Location + "'";
			deleteFromDb(Command2, ConnectionString);
		}

	}

	public void VerifyServiceOrders(String Location, String soServiceOrderNumber)
			throws ClassNotFoundException, SQLException, SQLServerException {
		String columnName = "soServiceOrderNumber";
		String Command1 = "select * from [SO10100] where umLocationID ='" + Location + "' And soServiceOrderNumber ='"
			+ soServiceOrderNumber + "'";
		String Result = selectFromDb(Command1, ConnectionString, columnName);
		if (Result != "") {
			log("Service Order verified = " + Result);
		} else {
			Assert.fail("Service Order '" + soServiceOrderNumber + "' Not Found");
			;
		}

	}

	
}
