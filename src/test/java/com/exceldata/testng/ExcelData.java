package com.exceldata.testng;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelData {
	public static FileInputStream ip;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	
@DataProvider(name="login")
public Object [][] Login() throws IOException{
Object[][] data = ExcelData.ExcelDataTng("login");
return data;
}

@DataProvider(name="register")
public Object [][] register() throws IOException{
Object [][] data = ExcelData.ExcelDataTng("register");
return data;
}

	
public static Object[][] ExcelDataTng(String sheetname) throws IOException {
	
	ip = new FileInputStream("C:\\Users\\parth\\eclipse-workspace\\TestNGFramework\\src\\test\\java\\com\\exceldata\\testng\\Tng.xlsx");
	workbook = new XSSFWorkbook(ip);
	sheet = workbook.getSheet(sheetname);

	int rows = sheet.getLastRowNum();
	int cols = sheet.getRow(0).getLastCellNum();

	Object[][] data = new Object[rows][cols];

	for (int i = 0; i < rows; i++) {
		XSSFRow row = sheet.getRow(i + 1);

		for (int j = 0; j < cols; j++) {
			XSSFCell cell = row.getCell(j);
			CellType cellType = cell.getCellType();

			switch (cellType) {

			case STRING:
				data[i][j] = cell.getStringCellValue();
				break;
			case NUMERIC:
				data[i][j] = Integer.toString((int) cell.getNumericCellValue());
				break;
			case BOOLEAN:
				data[i][j] = cell.getBooleanCellValue();
				break;

			}

		}

	}

	return data;
}
}
