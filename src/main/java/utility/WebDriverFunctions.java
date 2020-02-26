package utility;
/**
 *  All web driver specific common methods are included in this class
 *  @author xt24749
 */

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class WebDriverFunctions {

	static WebDriver driver;
	static WebDriverWait wait;

	public WebDriverFunctions(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver,20);
	}

	public static void checkUrl(String url) {
		wait.until(ExpectedConditions.urlContains("offer"));
		String currentURL = driver.getCurrentUrl();
		Assert.assertEquals(currentURL, url);
	}
	
	/*
	 * Click an element
	 */
	public static void clickWebElement(WebElement ele) {
		try {
			waitUntilElementVisible(ele);
			wait.until(ExpectedConditions.elementToBeClickable(ele));		
			ele.click();	
		}catch(Exception e) {
			throw new RuntimeException("Exception in 'WebDriverFunctions.clickWebElement' : " + e.getMessage());
		}
	}


	public static void sendkeysWebElement(WebElement ele,String textTobeEntered) {
		try {
			// WebDriverWait wait = new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.visibilityOf(ele));
			ele.clear();
			ele.sendKeys(textTobeEntered);	
		}catch(Exception e) {
			throw new RuntimeException("Exception in 'WebDriverFunctions.sendkeysWebElement' : " + e.getMessage());
		}
	}

	/*
	 * check if element is displayed
	 */
	public static boolean waitUntilElementVisible(WebElement element) {
		boolean b = false;
		try {
			b = wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
		} catch (Exception e) {
			// TODO: handle exception
			b = false;
		}
		return b;
	}


	public static boolean waitUntilElementHasText(WebElement element, String text) {
		boolean b = false;
		try {
			if (WebDriverFunctions.waitUntilElementVisible(element))
			{
				b = wait.until(ExpectedConditions.textToBePresentInElement(element, text));
			}			
		} catch (Exception e) {
			// TODO: handle exception
			b = false;
		}

		return b;
	}
	
	public static boolean waitUntilListOfElementVisible(List<WebElement> elements) {
		try {
			wait.until(ExpectedConditions.visibilityOfAllElements(elements));
		} catch (Exception e) {
			// TODO: handle exception
		}
		return elements != null && elements.size() > 0;
	}

/*
	 * Select the Item from drop down list from any web page
	 */
	public static boolean selectOptionDropdown(WebElement ele, String sValue) {
		try {
			Select dropDwn = new Select(ele);
			dropDwn.selectByValue(sValue);
			return true;
		} catch (Exception e) {
			throw new RuntimeException("Exception in 'WebDriverFunctions.selectOptionDropdown' : " + e.getMessage());
		}
	}
}
