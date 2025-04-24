package utilPack;
import java.awt.Dimension;
import java.util.Arrays;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class DriverInitialization {
	public WebDriver driver;

	@BeforeMethod
	@Parameters("Browser")
	public void initializeDriver(String browser) throws InterruptedException {
		if (browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().browserVersion("132.0.6834.84").setup(); // Specify the correct version
			ChromeOptions options = new ChromeOptions();
			options.setAcceptInsecureCerts(true);
			driver = new ChromeDriver(options);
		} else if (browser.equalsIgnoreCase("Firefox")) {
			//	        WebDriverManager.firefoxdriver().setup();
			//	        driver = new FirefoxDriver();
		} else {
			System.out.println("Invalid browser type");
			return;
		}
 
		driver.manage().window().maximize();
		driver.get("https://www.demoblaze.com/");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.body.style.zoom='65%'");
	}
 
	@AfterMethod
	public void closeDriver() {
		if (driver!=null) {
			driver.quit();
		}
	}
	public WebDriver getDriver() {
		return driver;
	}
}
