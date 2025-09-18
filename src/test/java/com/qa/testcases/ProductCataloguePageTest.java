package com.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.LoginPage;
import com.qa.pages.ProductCatalogue;
import com.qa.util.TestUtil;

public class ProductCataloguePageTest extends TestBase{
	LoginPage loginPage;
	ProductCatalogue productCatalogue;
	String sheetName = "";
	
	public ProductCataloguePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		productCatalogue = loginPage.loginApplication(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void productCataloguePageTitleTest() {
		String title = productCatalogue.verifyProductCataloguePageTitle();
		Assert.assertEquals(title, "Let's Shop", "Title not matched");
	}
	
	@DataProvider
	public Object[][] getTestData() throws IOException {
		Object[][] data = TestUtil.getTestData(sheetName);
		return data;
		
	}
	
//	@Test(priority=1, dataProvide="getTestData")
//	public void productCataloguePageTitleTest(String col1, String col2, String col3) {
//		String title = productCatalogue.verifyProductCataloguePageTitle();
//		Assert.assertEquals(title, "Let's Shop", "Title not matched");
//	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
