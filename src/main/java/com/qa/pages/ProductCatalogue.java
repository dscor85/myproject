package com.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;



public class ProductCatalogue extends TestBase {
	

	public ProductCatalogue() {
		PageFactory.initElements(driver, this);
	}
	
	//List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
	
	//PageFactory
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	@FindBy(css=".ng-animating")
	WebElement spinner;
	
	By productsBy = By.cssSelector(".mb-3");
	By addToCart = By.cssSelector(".card-body button:last-of-type"); 
	By toastMessage = By.cssSelector("#toast-container");
	
	public String verifyProductCataloguePageTitle() {
		return driver.getTitle();
	}
	
	
//	public List<WebElement> getProductList() throws InterruptedException {
//		
////		waitForElementToAppear(productsBy);
//		Thread.sleep(10);
//		return products;
//	}
	
	
//	public WebElement getProductByName(String productName) throws InterruptedException {
//		WebElement prod = getProductList().stream().filter(product->
//		product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
//		return prod;
//	}
	
//	public void addProductToCart(String productName) {
//		
//		WebElement prod = getProductByName(productName);
//		prod.findElement(addToCart).click();
//		waitForElementToAppear(toastMessage);
//		waitForElementToDisappear(spinner);
//	}

}
