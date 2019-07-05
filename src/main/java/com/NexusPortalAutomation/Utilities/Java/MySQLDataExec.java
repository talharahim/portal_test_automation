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
		log("Deleting Records for "+Result);
		String Command2 = "delete from [SO10101] WHERE soServiceOrderNumber ='" + Result + "'";
		deleteFromDb(Command2, ConnectionString, columnName);
		String Command3 = "delete from SO10100 where umLocationID  ='" + Location + "'";
		deleteFromDb(Command3, ConnectionString, columnName);
	}

	public void VerifyServiceOrders(String Location, String DateRequested)
			throws ClassNotFoundException, SQLException, SQLServerException {

		String columnName = "soRequestedDate";
		String Command1 = "select * from [SO10100] where umLocationID ='" + Location + "' And soRequestedDate ='"
				+ DateRequested + "'";
		String Result = selectFromDb(Command1, ConnectionString, columnName);
		if (Result != "") {
			log("Service Order verified = " + Result);
		} else {
			Assert.fail();
		}

	}

	/*
	 * public String getServOrderNumber(String Location) throws
	 * ClassNotFoundException, SQLException { // Following will created database
	 * String Command1 = "select * from [SO10100] where umLocationID ='" + Location
	 * + "'"; Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); //
	 * Creating connection to the database Connection con =
	 * DriverManager.getConnection(ConnectionString); // Executing the SQL Query and
	 * store the results in ResultSet Statement stmt = con.createStatement();
	 * ResultSet rs = stmt.executeQuery(Command1); while (rs.next()) { Result =
	 * rs.getString("soServiceOrderNumber"); System.out.println(Result); } // While
	 * loop to iterate through all data and print results con.close(); return
	 * Result;
	 * 
	 * }
	 */
}
