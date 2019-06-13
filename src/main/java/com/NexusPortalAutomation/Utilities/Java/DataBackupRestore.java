package com.NexusPortalAutomation.Utilities.Java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class DataBackupRestore {

	public static ReadProjectProperties Read = new ReadProjectProperties();
	public String DatabaseName = Read.ReadFile("DatabaseName");
	public String DatabaseLocation = Read.ReadFile("DatabaseLocation");
	public String ApiDatabaseName = Read.ReadFile("ApiDatabaseName");
	public String ApiDatabaseLocation = Read.ReadFile("ApiDatabaseLocation");
	public String ConnectionString = Read.ReadFile("ConnectionStringServ");

	public void CreateDb() throws ClassNotFoundException, SQLException {
		// Following will created database
		String CreatCommand1 = "USE [master] " + "CREATE DATABASE " + DatabaseName;
		String CreatCommand2 = "USE [" + DatabaseName + "]" + "CREATE TABLE SQLTest (" + "ID INT NOT NULL PRIMARY KEY,"
				+ "c1 VARCHAR(100) NOT NULL," + "dt1 DATETIME NOT NULL DEFAULT getdate())";

		String CreateCommand3 = "USE [SQLTestDB] " + "INSERT INTO SQLTest (ID, c1) VALUES (1, 'test1') "
				+ "INSERT INTO SQLTest (ID, c1) VALUES (2, 'test2') "
				+ "INSERT INTO SQLTest (ID, c1) VALUES (3, 'test3') "
				+ "INSERT INTO SQLTest (ID, c1) VALUES (4, 'test4') "
				+ "INSERT INTO SQLTest (ID, c1) VALUES (5, 'test5') ";
		// Load SQL SERVER JDBC Driver
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		// Creating connection to the database
		Connection con = DriverManager.getConnection(ConnectionString);
		Statement st = con.createStatement();
		// Executing the SQL Query and store the results in ResultSet
		st.executeQuery(CreatCommand1);
		st.executeQuery(CreatCommand2);
		st.executeQuery(CreateCommand3);
		// While loop to iterate through all data and print results
		con.close();

	}

	//@Test
	void CompanyDBBackup() throws SQLException, ClassNotFoundException {

		String Backup = "USE MASTER; BACKUP DATABASE "+ DatabaseName+ "TO DISK =" + DatabaseLocation
				+ "  WITH FORMAT, MEDIANAME = 'Z_SQLServerBackups',"
				+ "      NAME = 'Full Backup of "+ DatabaseName+"';";

		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		// Creating connection to the database
		Connection con = DriverManager.getConnection(ConnectionString);
		Statement st = con.createStatement();
		// Executing the SQL command
		st.executeUpdate(Backup);
		
		con.close();
	}
	
	@Test
	void ApiDBBackup() throws SQLException, ClassNotFoundException {

		String Backup = "USE MASTER; BACKUP DATABASE "+ ApiDatabaseName+ "TO DISK =" + ApiDatabaseLocation
				+ "  WITH FORMAT, MEDIANAME = 'Z_SQLServerBackups',"
				+ "      NAME = 'Full Backup of "+ ApiDatabaseName+"';";

		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		// Creating connection to the database
		Connection con = DriverManager.getConnection(ConnectionString);
		Statement st = con.createStatement();
		// Executing the SQL command
		st.executeUpdate(Backup);
		
		con.close();
	}


	
	void RestoreDB() throws SQLException, ClassNotFoundException {

		String Restore = "USE master;   " + "RESTORE DATABASE SQLTestDB FROM DISK = " + DatabaseLocation
				+ " WITH REPLACE;";
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection con = DriverManager.getConnection(ConnectionString);
		Statement st = con.createStatement();
		// Executing the SQL command a
		st.executeUpdate(Restore);
		con.close();
	}

	void GetDb() throws ClassNotFoundException {

		// Load SQL SERVER JDBC Driver
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		// Creating connection to the database
		try {
			Connection con = DriverManager.getConnection(
					"jdbc:sqlserver://RND-BASE-A\\SQL_2017;" + "databaseName=TWO;user=auto;password=password123;");
			Statement st = con.createStatement();
			String selectquery = "SELECT * FROM TWO.dbo.UM00600 ";
			// Executing the SQL Query and store the results in ResultSet
			ResultSet rs = st.executeQuery(selectquery);
			// While loop to iterate through all data and print results

			while (rs.next()) {
				String locationID = rs.getString("umLocationID");
				System.out.print(locationID);

			}
			// Closing DB Connection
			con.close();
		} catch (SQLException ex) {
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}

	}

}
