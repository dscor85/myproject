package com.qa.base;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.qa.util.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;


//("anshika@gmail.com", "Iamking@000");
public class TestBase {

	public static WebDriver driver;
	public static Properties prop;

	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\main\\java\\com\\qa\\config\\config.properties");
			prop.load(ip);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void initialization() {
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")) {
//			System.setProperty("webdriver.chrome.driver", "path");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "path");
			driver = new FirefoxDriver();
			
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
		
		driver.get(prop.getProperty("url"));
		
		
	}
	
	
	
}
