package com.NexusPortalAutomation.Utilities.Java;

import java.sql.SQLException;

import org.testng.Assert;

import com.microsoft.sqlserver.jdbc.SQLServerException;

public class MySQLDataExec extends CommonMethods {

	public static ReadProjectProperties Read = new ReadProjectProperties();
	public String ConnectionString = Read.ReadFile("ConnectionStringServTWO");
	String Result;

	// This Method will delete Service Orders by Location
	public void DeleteServiceOrders(String Location) throws ClassNotFoundException, SQLException, SQLServerException {

		String columnName = "soServiceOrderNumber";
		String Command1 = "select * from [SO10100] where umlocationID ='" + Location + "'";
		String Result = selectFromDb(Command1, ConnectionString, columnName);
		log("Deleting Records for " + Result);
		String Command2 = "delete from [SO10101] WHERE "+columnName+" ='" + Result + "'";
		deleteFromDb(Command2, ConnectionString);
		String Command3 = "delete from SO10100 where umlocationID  ='" + Location + "'";
		deleteFromDb(Command3, ConnectionString);
	}

	public void DeleteServiceOrdersHistory(String Location)
		throws ClassNotFoundException, SQLException, SQLServerException {
		String Command1 = "select * from um00600h where umAccumType = 0 and umlocationID ='" + Location + "'";
		String Result = selectFromDb(Command1, ConnectionString, "umAccumType");
		if (!Result.isEmpty()) {
			log("Deleting Records for " + Location);
			String Command2 = "delete from [UM00600H] WHERE umlocationID ='" + Location + "'";
			deleteFromDb(Command2, ConnectionString);
		}

	}

	public void VerifyServiceOrders(String Location, String soServiceOrderNumber)
			throws ClassNotFoundException, SQLException, SQLServerException {
		String columnName = "soServiceOrderNumber";
		String Command1 = "select * from [SO10100] where umlocationID ='" + Location + "' And soServiceOrderNumber ='"
			+ soServiceOrderNumber + "'";
		String Result = selectFromDb(Command1, ConnectionString, columnName);
		if (Result != "") {
			log("Service Order verified = " + Result);
		} else {
			Assert.fail("Service Order '" + soServiceOrderNumber + "' Not Found");
			;
		}

	}
	
	public void VerifyStatementsData(String Location, String Amount) throws ClassNotFoundException, SQLException
	{
		String columnName = "umStatementDate";
		String Command1 = "select * from [um00701] where umlocationID ='" + Location + "' And umStatementAmount ='"
			+ Amount + "'";
		String Result = selectFromDb(Command1, ConnectionString, columnName);
		if (Result != "") {
			log("Service Order verified = " + Result);
		} else {
			Assert.fail("Statement Data for  '" + Amount + "' Not Found");
			;
		}
		
	}

	
}
