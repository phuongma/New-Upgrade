package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utility.WebDriverFunctions;
import Data.AccountInfo;

public class Upgrade_LogInPage {

	private static WebDriver driver;
	private AccountInfo acct;
	
	@FindBy(how = How.NAME, using = "username")
	private WebElement username;
	
	@FindBy(how = How.NAME, using = "password")
	private WebElement password;
	
	@FindBy(how = How.XPATH, using = "//button[@data-auto='login']")
	private WebElement signInBttn;
	
	public Upgrade_LogInPage(WebDriver driver) {
		Upgrade_LogInPage.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/*
	 * Navigate to GetStartedPage UI.
	 */
	public void navigateGetStartedPage(String url)
	{
		try {
			driver.get(url);
			//TODO: check if page opened
		} catch (Exception e) {
			//TODO: handle exception
		}
	}
	
	public void setAcctInfo(AccountInfo acctInfo) {
		acct = acctInfo;
	}
	
	public AccountInfo getAcctInfo() {
		return acct;		
	}
	
	public void logIn() {
		try {
			WebDriverFunctions.sendkeysWebElement(username, acct.getUsername());			
			WebDriverFunctions.clickWebElement(password);
			WebDriverFunctions.sendkeysWebElement(password, acct.getPassword());			
			WebDriverFunctions.clickWebElement(signInBttn);
		}	catch (Exception e) {
			//TODO: handle exception	
		}
	}

}
