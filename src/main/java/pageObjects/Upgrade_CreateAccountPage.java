package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utility.WebDriverFunctions;
import Data.AccountInfo;

public class Upgrade_CreateAccountPage {
	private static WebDriver driver;
	private static AccountInfo acct;
	
	@FindBy(how =How.NAME, using = "username")
	private WebElement userName;	
	
	@FindBy(how =How.NAME, using = "password")
	private WebElement password;

	@FindBy(how = How.XPATH, using = "//input[@name='agreements']//ancestor::label")
	private WebElement agreementCheckbox;	

	@FindBy(how = How.XPATH, using = "//button[@data-auto='submitPersonalInfo']")
	private WebElement checkYourRateBttn;

	
	public Upgrade_CreateAccountPage(WebDriver driver) {
		Upgrade_CreateAccountPage.driver = driver;
		PageFactory.initElements(driver, this);
		acct = new AccountInfo(); 
	}
	
	public void createAccount() {
		WebDriverFunctions.sendkeysWebElement(userName, acct.getUsername());
		WebDriverFunctions.sendkeysWebElement(password, acct.getPassword());

		WebDriverFunctions.clickWebElement(agreementCheckbox);		
		
		WebDriverFunctions.clickWebElement(checkYourRateBttn);		
	}
	
	public AccountInfo getAcctInfo() {
		return acct;		
	}

}
