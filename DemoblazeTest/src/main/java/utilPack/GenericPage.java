package utilPack;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import jdk.internal.vm.annotation.Hidden;

public class GenericPage {
	protected WebDriver driver;
	WebElement webElement;
	List<WebElement> webElements;
	Assert asrt;
	JavascriptExecutor js;
	Select select;
	String data;
	int exitVal;
	public GenericPage(WebDriver driver)
	{
		this.driver=driver;	
	}

	/// <summary>
	/// Method to click an element 
	/// </summary>

	public void buttonClick(By locator)
	{
		WebDriverWait wait = getWait();
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		webElement =driver.findElement(locator);
		highLighterMethod(driver, webElement);
		webElement.click();
	}

	/// <summary>
	/// Method to enter value to an element with given timeout
	/// </summary>
	public void setData(By locator, String text) 
	{
		WebDriverWait wait = getWait();
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		webElement =driver.findElement(locator);
		highLighterMethod(driver, webElement);
		webElement.clear();
		webElement.sendKeys(text);
	}
	/// <summary>
	/// Method to get innertext
	/// </summary>
	public String GetText(By locator) 
	{
		WebDriverWait wait = getWait();
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		webElement =driver.findElement(locator);
		data = webElement.getText();
		return data;
	}

	/// <summary>
	/// Method to Switch Window Frame
	/// </summary>
	public void switchToFrame(By locator)
	{
		WebDriverWait wait = getWait();
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
		webElement =driver.findElement(locator);
		driver.switchTo().frame(webElement);
	}
	/// <summary>
	/// Method to Switch Window Frame
	/// </summary>
	public void switchToDefaultContent() 
	{
		driver.switchTo().defaultContent();
	}


	/// <summary>
	/// Method to Validate Text
	/// </summary>

	public void validateText(By locator,String expectedText)
	{
		WebDriverWait wait = getWait();
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		webElement = driver.findElement(locator);
		String actualText = webElement.getText();
		asrt.assertEquals(actualText, expectedText);
	}

	/// <summary>
	/// Method to Validate Text (Return by boolean)
	/// </summary>
	public boolean validateText(By locator)
	{
		WebDriverWait wait = getWait();	    
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		webElement = driver.findElement(locator);
		boolean status = webElement.isDisplayed();
		asrt.assertTrue(status);
		return status;		
	}

	/// <summary>
	/// Fluent wait
	/// </summary>
	public WebDriverWait getWait() {   //explicit wait

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		//	wait.pollingEvery(250,TimeUnit.MILLISECONDS);                //WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.ignoring(NoSuchElementException.class);                 // wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return wait;

	}

	/// <summary>
	/// Fluent wait
	/// </summary>
	public void excuteJsClick(By locator) 
	{

		js = (JavascriptExecutor)driver;
		WebDriverWait wait = getWait();
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		webElement =driver.findElement(locator);
		highLighterMethod(driver, webElement);
		js.executeScript("arguments[0].click();", webElement);
	}

	/// <summary>
	/// Method to Select values in the dropdown
	/// </summary>

	public void selectorByVisibleText(By locator,String text)
	{     
		WebDriverWait wait = getWait();
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		webElement = driver.findElement(locator);
		highLighterMethod(driver, webElement);
		select = new Select(webElement);
		select.selectByVisibleText(text);
	}

	/// <summary>
	/// Method that highLights elements
	/// </summary>
	public void highLighterMethod(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String bgColor = element.getCssValue("backgroundColor");
		js.executeScript("arguments[0].setAttribute('style', 'background: "+bgColor+"; border: 2px solid red;');", element);
	}

	/// <summary>
	/// isExists Validation
	/// </summary>
	public boolean isExists(By locator) {
		boolean status= false;
		WebDriverWait wait = getWait();
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

		try {
			webElement = driver.findElement(locator);
			if(webElement.isDisplayed())
				status=true;
			return status;
		}
		catch(Exception e) {
			e.printStackTrace();
			return status;
		}

	}

	/// <summary>
	/// To create a random string without Numbers by passing number of characters
	/// </summary>
	public static String CreateRandomWithoutNumbers(int n)
	{

		// choose a Character random from this String
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
				+ "abcdefghijklmnopqrstuvxyz";

		// create StringBuffer size of AlphaNumericString
		StringBuilder sb = new StringBuilder(n);

		for (int i = 0; i < n; i++) {

			// generate a random number between
			// 0 to AlphaNumericString variable length
			int index
			= (int)(AlphaNumericString.length()
					* Math.random());

			// add Character one by one in end of sb
			sb.append(AlphaNumericString
					.charAt(index));
		}

		return sb.toString();
	}
	/// <summary>
	/// Get Value
	/// </summary>
	public String GetValue(By locator) {
		WebDriverWait wait = getWait();
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		webElement =driver.findElement(locator);
		data = webElement.getAttribute("value");
		return data;
	}
}
