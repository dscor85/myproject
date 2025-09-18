package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class LoginPage extends TestBase {

	// WebElement userEmail = driver.findElement(By.id("userEmail"));

	// PageFactory
	@FindBy(id = "userEmail")
	@CacheLookup
	WebElement userEmail;

	@FindBy(id = "userPassword")
	WebElement passwordEle;

	@FindBy(id = "login")
	WebElement submit;

	@FindBy(css = "[class*='flyInOut']")
	WebElement errorMessage;

	public LoginPage() {

		PageFactory.initElements(driver, this); //initializing the PageFactory, driver will initialize
		//"this" means pointing the current class objects
	}

	// Actions
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public ProductCatalogue loginApplication(String email, String password) {
		userEmail.sendKeys(email);
		passwordEle.sendKeys(password);
		submit.click();
		return new ProductCatalogue();
	}

//	public void goTo() {
//
//		driver.get("https://rahulshettyacademy.com/client");
//	}

//	public String getErrorMessage() {
//		waitForWebElementToAppear(errorMessage);
//		return errorMessage.getText();
//	}

}
