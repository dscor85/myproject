package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.LoginPage;
import com.qa.pages.ProductCatalogue;

//@Listeners(com.qa.util.Listeners.class)

//@Test(retryAnalyzer = com.qa.util.RetryAnalyzer.class)
public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	ProductCatalogue productCatalogue;

	public LoginPageTest() {
		super(); // Base class TestBase will called and 'prop' will be initialized
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
	}

	@Test(priority = 1)
	public void loginPageTitleTest() {
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Let's Shop");
	}

	@Test(priority = 2)
	public void loginTest() {
		productCatalogue = loginPage.loginApplication(prop.getProperty("username"), prop.getProperty("password"));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
