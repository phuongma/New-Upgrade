package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Data.AccountInfo;
import utility.WebDriverFunctions;

public class Upgrade_OfferPage {
	private static WebDriver driver;
	private AccountInfo acct;
	
	@FindBy(how = How.XPATH, using = "//*[@data-auto='userLoanAmount']")
	private WebElement loanAmount;
	
	@FindBy(how = How.XPATH, using = "//*[@data-auto='defaultMonthlyPayment']")
	private WebElement monthlyPayment;	

	@FindBy(how = How.XPATH, using = "//*[@data-auto='defaultLoanTerm']")
	private WebElement loanTerm;

	@FindBy(how = How.XPATH, using = "//div[@data-auto='defaultLoanInterestRate']")
	private WebElement interestRate;

	@FindBy(how = How.XPATH, using = "//div[@data-auto='defaultMoreInfoAPR']//child::div ")
	private WebElement defaultAPR;	
	
	@FindBy(how = How.XPATH, using = "//div[@class='header-nav']//child::label")
	private WebElement menu;
	
	@FindBy(how = How.XPATH, using = "//*[@href='/funnel/logout']")
	private WebElement signOut;
	
	private String sLoanAmount;
	private String sMonthlyPayment;
	private String sLoanTerm;
	private String sInterestRate;
	private String sDefaultAPR;
	
	public Upgrade_OfferPage(WebDriver driver) {
		Upgrade_OfferPage.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void setAcctInfo(AccountInfo acctInfo) {
		acct = acctInfo;
	}
	
	public AccountInfo getAcctInfo() {
		return acct;		
	}
	
	public void getLoanData() {
		WebDriverFunctions.waitUntilElementHasText(loanAmount, "0");

		sLoanAmount = loanAmount.getText();
		acct.setLoanAmount(sLoanAmount);
		sMonthlyPayment = monthlyPayment.getText();
		acct.setMonthlyPayment(sMonthlyPayment);
		sLoanTerm = loanTerm.getText();
		acct.setTerm(sLoanTerm);
		sInterestRate = interestRate.getText();
		acct.setInterestRate(sInterestRate);
		sDefaultAPR = defaultAPR.getText();
		acct.setApr(sDefaultAPR);
		System.out.println("LoanData " + sLoanAmount + " " + sMonthlyPayment + " " + sLoanTerm + " " + sInterestRate  + " " + sDefaultAPR); 	
		WebDriverFunctions.clickWebElement(menu);
		WebDriverFunctions.clickWebElement(signOut);
	}
	
	public void validateLoanData() {
		WebDriverFunctions.waitUntilElementHasText(loanAmount, "0");

		sLoanAmount = loanAmount.getText();
		Assert.assertEquals(sLoanAmount, acct.getLoanAmount());

		sMonthlyPayment = monthlyPayment.getText();
		Assert.assertEquals(sMonthlyPayment, acct.getMonthlyPayment());
		
		sLoanTerm = loanTerm.getText();
		Assert.assertEquals(sLoanTerm, acct.getTerm());
		
		sInterestRate = interestRate.getText();
		Assert.assertEquals(sInterestRate, acct.getInterestRate());
		
		sDefaultAPR = defaultAPR.getText();
		Assert.assertEquals(sDefaultAPR, acct.getApr());
		
//		System.out.println("LoanData " + sLoanAmount + " " + sMonthlyPayment + " " + sLoanTerm + " " + sInterestRate  + " " + sDefaultAPR); 	
		WebDriverFunctions.clickWebElement(menu);
		WebDriverFunctions.clickWebElement(signOut);
	}
}


