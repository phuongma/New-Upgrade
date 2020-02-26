package managers;

/**
 * This class creates instances of classes from the pageObjects folder
 * 
 */

import org.openqa.selenium.WebDriver;
import pageObjects.Upgrade_GetStartedPage;
import pageObjects.Upgrade_BasicInfoPage;
import pageObjects.Upgrade_IncomePage;
import pageObjects.Upgrade_CreateAccountPage;
import pageObjects.Upgrade_OfferPage;

import pageObjects.Upgrade_LogInPage;

import utility.WebDriverFunctions;

public class PageObjectManager{
	private WebDriver driver;
	
	private WebDriverFunctions webDriverFunctions;	
	private Upgrade_GetStartedPage getStarted;
	private Upgrade_BasicInfoPage basicInfo;
	private Upgrade_IncomePage income;
	private Upgrade_CreateAccountPage createAccount;
	private Upgrade_OfferPage offerPage;
	private Upgrade_LogInPage loginPage;
	
	public PageObjectManager(WebDriver driver)
	{
		this.driver = driver;
	}	
	
	public WebDriverFunctions getWebDriverFunctions()
	{
		return (webDriverFunctions == null) ? webDriverFunctions = new WebDriverFunctions(driver) : webDriverFunctions;
	}
	
	public Upgrade_GetStartedPage getGetStartedPage() {
		return (getStarted == null) ? getStarted = new Upgrade_GetStartedPage(driver) : getStarted;		
	}	
	
	public Upgrade_BasicInfoPage getGetBasicInfoPage() {
		return (basicInfo == null) ? basicInfo = new Upgrade_BasicInfoPage(driver) : basicInfo;		
	}		
	
	public Upgrade_IncomePage getIncomePage() {
		return (income == null) ? income = new Upgrade_IncomePage(driver) : income;		
	}	
	
	public Upgrade_CreateAccountPage getCreateAccountPage() {
		return (createAccount == null) ? createAccount = new Upgrade_CreateAccountPage(driver) : createAccount;		
	}	

	public Upgrade_OfferPage getOfferPage() {
		return (offerPage == null) ? offerPage = new Upgrade_OfferPage(driver) : offerPage;		
		
	}
	
	public Upgrade_LogInPage getLogInPage() {
		return (loginPage == null) ? loginPage = new Upgrade_LogInPage(driver) : loginPage;		
	}
	
}



