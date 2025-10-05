package com.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.base.TestBase;

public class TestUtil extends TestBase {
	

	public static long PAGE_LOAD_TIMEOUT = 10;
	public static long IMPLICIT_WAIT = 10;
	public static String TEST_DATA_SHEET_PATH = "";
	public static FileInputStream file = null;
	public static XSSFWorkbook wb = null;
	public static Object[][] data = null;

	public static Object[][] getTestData(String sheetName) throws IOException {

		file = new FileInputStream(TEST_DATA_SHEET_PATH);
		wb = new XSSFWorkbook(file);

		XSSFSheet sheet = wb.getSheet(sheetName);
		int rows = sheet.getLastRowNum();
		int cols = sheet.getRow(0).getLastCellNum();
		data = new Object[rows][cols];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
			}
		}

		wb.close();
		file.close();

		return data;

	}
	
	
//	public void takeScreenshotOnFailure(String testMethodName) throws IOException {
//		TakesScreenshot ts = (TakesScreenshot) driver;
//		File fileSource = ts.getScreenshotAs(OutputType.FILE);
//		File fileDestination = new File(System.getProperty("user.dir") + "//screenshots//" + testMethodName + ".png");
//		FileUtils.copyFile(fileSource, fileDestination);
//		
//	}
	
	public static String getScreenshot(String testCaseName, WebDriver driver) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File(System.getProperty("user.dir") + "//reports" + testCaseName + ".png");
		FileUtils.copyFile(source, destination);
		return System.getProperty("user.dir") + "//extentReports" + testCaseName + ".png";
	}
	
	

}
