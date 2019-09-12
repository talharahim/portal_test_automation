package com.NexusPortalAutomation.Utilities.Java;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

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

	public static Map<String, Map<String, String>> setMapData(String sheetName) throws IOException {

		String path = file_location;
		FileInputStream fis = new FileInputStream(path);
		Workbook workbook = new XSSFWorkbook(fis);
		Sheet sheet = workbook.getSheet(sheetName);
		int lastRow = sheet.getLastRowNum();
		Map<String, Map<String, String>> excelFileMap = new HashMap<String, Map<String, String>>();
		Map<String, String> dataMap = new HashMap<String, String>();
		// Looping over entire row
		for (int i = 0; i <= lastRow; i++) {
			Row row = sheet.getRow(i);
			// 1st Cell as Value
			Cell valueCell = row.getCell(1);
			// 0th Cell as Key
			Cell keyCell = row.getCell(0);
			String value = valueCell.getStringCellValue().trim();
	     	String key = keyCell.getStringCellValue().trim();
			// Putting key & value in dataMap
			dataMap.put(key, value);
			// Putting dataMap to excelFileMap
			excelFileMap.put("DataSheet", dataMap);
		}
		// Returning excelFileMap
		workbook.close();
		return excelFileMap;

	}

	// Method to retrieve value
	public static String getExcelData(String sheetName, String key) {
		Map<String, String> m;
		String value=null;
		try {
			m = setMapData(sheetName).get("DataSheet");
			value = m.get(key);
			return value;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
		

	}


}
