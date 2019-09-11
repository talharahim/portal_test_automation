package com.NexusPortalAutomation.Utilities.Java;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData {
	static ReadProjectProperties Read = new ReadProjectProperties();
	public static String file_location = Read.ReadFile("ExcelDatasheetPath");

	public static String ReadVariant(String SheetName, int row, int cell) {
		String value = null;
		try {
			FileInputStream fileInputStream;
			fileInputStream = new FileInputStream(file_location);
			// Excel sheet file location get mentioned here
			XSSFWorkbook workbook;
			XSSFSheet worksheet;
			workbook = new XSSFWorkbook(fileInputStream); // get my workbook
			worksheet = workbook.getSheet(SheetName);// get my sheet from workbook
			XSSFRow Row = worksheet.getRow(row); // get my Row which start from 0
			XSSFCell cellData = Row.getCell(cell);
			value = cellData.getStringCellValue();
			System.out.println("Cell Value = " + value);
			workbook.close();
			return value;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return value;

	}
}