package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utility.WebDriverFunctions;

public class Upgrade_BasicInfoPage {

	private static WebDriver driver;
	private String sFirstName = "FirstName";
	private String sLastName = "LastName";
	private String sStreet = "2727 Barclay way";
	private String sCity = "Ann Arbor";
	private String sState = "MI";
	private String sZipCode ="48105";
	private String sDOB = "07/05/1999";

	
	
	@FindBy(how = How.XPATH, using = "//input[@name='borrowerFirstName']")
	private WebElement firstName;
	
	@FindBy(how = How.XPATH, using = "//input[@name='borrowerLastName']")
	private WebElement lastName;
	
	@FindBy(how=How.ID, using = "borrowerStreet")
	private WebElement street;
	
	@FindBy(how = How.XPATH, using = "//input[@name='borrowerCity']")
	private WebElement city;
	
	@FindBy(how = How.XPATH, using = "//input[@name='borrowerState']")
	private WebElement state;
	
	@FindBy(how = How.XPATH, using = "//input[@name='borrowerZipCode']")
	private WebElement zipCode;
	
	@FindBy(how = How.XPATH, using = "//input[@name='borrowerDateOfBirth']")
	private WebElement dOB;		
	
	@FindBy(how = How.XPATH, using = "//button[@data-auto='continuePersonalInfo']")
	private WebElement continueBttn;
	
	public Upgrade_BasicInfoPage(WebDriver driver) {
		Upgrade_BasicInfoPage.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	public void enterPersonalInfo() {
		WebDriverFunctions.sendkeysWebElement(firstName, sFirstName);
		
		WebDriverFunctions.sendkeysWebElement(lastName, sLastName);
		
		WebDriverFunctions.sendkeysWebElement(street, sStreet);
		
		WebDriverFunctions.sendkeysWebElement(city, sCity);
		
		WebDriverFunctions.sendkeysWebElement(state, sState);
		
		WebDriverFunctions.sendkeysWebElement(zipCode, sZipCode);
		
		WebDriverFunctions.sendkeysWebElement(dOB, sDOB);

		WebDriverFunctions.clickWebElement(continueBttn);
		
	}

}
