package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utility.WebDriverFunctions;

public class Upgrade_IncomePage {
	private static WebDriver driver;
	private String strAnnualIncome 	= "More than $120,000";
	private String strAddIncome   	= "More than $5,000";
	
	@FindBy(how = How.XPATH, using = "//input[@name='borrowerIncome']")
	private WebElement annualIncome;
	
	@FindBy(how = How.XPATH, using = "//input[@name='borrowerAdditionalIncome']")
	private WebElement additionalIncome;	

	@FindBy(how = How.XPATH, using = "//button[@data-auto='continuePersonalInfo']")
	private WebElement continueBttn;
	
	public Upgrade_IncomePage(WebDriver driver) {
		Upgrade_IncomePage.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterIncomeInfo() {
		WebDriverFunctions.sendkeysWebElement(annualIncome, strAnnualIncome);
		
		WebDriverFunctions.sendkeysWebElement(additionalIncome, strAddIncome);
		
		additionalIncome.sendKeys(Keys.TAB);

		WebDriverFunctions.clickWebElement(continueBttn);		
	}
}
