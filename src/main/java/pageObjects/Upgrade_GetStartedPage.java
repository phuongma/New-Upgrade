package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utility.WebDriverFunctions;

public class Upgrade_GetStartedPage{

	private static WebDriver driver;
	private String strDesiredAmount = "2,000";
	private String strLoanPurpose = "OTHER";
	
	@FindBy(how =How.NAME, using = "desiredAmount")
	private WebElement desiredAmount;
	
	@FindBy(how = How.XPATH, using = "//select[@data-auto='dropLoanPurpose']")
	private WebElement loanPurposeList;
	
	@FindBy(how = How.XPATH, using = "//button[@data-auto='CheckYourRate']")
	private WebElement checkYourRateBttn;
	
	public Upgrade_GetStartedPage(WebDriver driver) {
		Upgrade_GetStartedPage.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/*
	 * Navigate to GetStartedPage UI.  PM.
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
	
	public void checkRate() {
		try {
			WebDriverFunctions.sendkeysWebElement(desiredAmount, strDesiredAmount);
			
			WebDriverFunctions.selectOptionDropdown(loanPurposeList, strLoanPurpose);
			
			WebDriverFunctions.clickWebElement(checkYourRateBttn);
			
		}	catch (Exception e) {
			//TODO: handle exception	
		}
	}
	
	
}