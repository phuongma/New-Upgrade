package runners;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import contextreader.TestContext;
import pageObjects.Upgrade_GetStartedPage;
import pageObjects.Upgrade_BasicInfoPage;
import pageObjects.Upgrade_IncomePage;
import pageObjects.Upgrade_CreateAccountPage;
import pageObjects.Upgrade_OfferPage;
import pageObjects.Upgrade_LogInPage;

import utility.WebDriverFunctions;

//API part
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

public class TestBaseClass{
	public static TestContext testContext = new TestContext();			
	public static WebDriverFunctions webDriverFunctions;
	
	public static Upgrade_GetStartedPage upgrade_GetStartedPage;
	public static Upgrade_BasicInfoPage upgrade_BasicInfoPage;
	public static Upgrade_IncomePage upgrade_IncomePage;
	public static Upgrade_CreateAccountPage upgrade_CreateAccountPage;
	public static Upgrade_OfferPage upgrade_OfferPage;
	public static Upgrade_LogInPage upgrade_LoginPage;
	
	public DocumentContext document;
	private int responseCode;
	private String strResptResponse;
	private String strApiUrl 			= "https://credapi.credify.tech/api/brportorch/v2/login";
	private String strApiBody 			= "{\"username\":\"coding.challenge.login@upgrade.com\",\"password\":\"On$3XcgsW#9q\"}";		
	private String strApiBodyFor401     = "{\"username\":\"test.login123@upgrade.com\",\"password\":\"On$3XcgsW#9q\"}";		
	private String strBody				= strApiBody;
	
	private String getStartedPageUrl 	= "https://www.credify.tech/phone/nonDMFunnel";
	private String loginPageUrl 		= "https://www.credify.tech/portal/login";
	private String offerPageUrl 		= "https://www.credify.tech/funnel/offer-page";
	/**
	 * Create object reference to different pages to be used in the testing
	 */
	@BeforeSuite
	public void beforeSuite() {
		webDriverFunctions 			= testContext.getPageObjectManager().getWebDriverFunctions();
		upgrade_GetStartedPage		= testContext.getPageObjectManager().getGetStartedPage();
		upgrade_BasicInfoPage		= testContext.getPageObjectManager().getGetBasicInfoPage();
		upgrade_IncomePage 			= testContext.getPageObjectManager().getIncomePage();
		upgrade_CreateAccountPage 	= testContext.getPageObjectManager().getCreateAccountPage();
		upgrade_OfferPage 			= testContext.getPageObjectManager().getOfferPage();
		upgrade_LoginPage			= testContext.getPageObjectManager().getLogInPage();
		
		Unirest.setDefaultHeader("x-cf-source-id", "coding-challenge");
		Unirest.setDefaultHeader("x-cf-corr-id", "230ea84a-7199-41c9-bf38-fff27e35970d");
		Unirest.setDefaultHeader("Content-Type", "application/json");
		
	}
	
	@Test
	public void myWebTest() {
		upgrade_GetStartedPage.navigateGetStartedPage(getStartedPageUrl);
		upgrade_GetStartedPage.checkRate();			
		upgrade_BasicInfoPage.enterPersonalInfo();	
		upgrade_IncomePage.enterIncomeInfo();
		upgrade_CreateAccountPage.createAccount();	
		upgrade_OfferPage.setAcctInfo(upgrade_CreateAccountPage.getAcctInfo());
		upgrade_OfferPage.getLoanData();
		
		upgrade_LoginPage.navigateGetStartedPage(loginPageUrl);
		upgrade_LoginPage.setAcctInfo(upgrade_OfferPage.getAcctInfo());
		upgrade_LoginPage.logIn();
		
		WebDriverFunctions.checkUrl(offerPageUrl);
		upgrade_OfferPage.validateLoanData();
		testContext.closeWebDriver();

	}
	
	public void getJsonResponse() throws UnirestException{
	    HttpResponse<JsonNode> jsonResponse ;
	    jsonResponse  	 = Unirest.post(strApiUrl).body(strBody).asJson();
	    strResptResponse = jsonResponse.getBody().toString();
	    responseCode 	 =	jsonResponse.getStatus(); 		
	}
	
	@Test
	public void validateResponseCode200() throws UnirestException {
		strBody = strApiBody;
		getJsonResponse();	
		System.out.println("Status code: " + responseCode);	
		Assert.assertEquals(responseCode, 200);
	}
	
	@Test
	public void validateProductType() throws UnirestException {
		strBody = strApiBody;
		getJsonResponse();
		document = JsonPath.parse(strResptResponse);
		String strProductType;
		
		strProductType = document.read("loansInReview[0].productType").toString();	
		System.out.println("Parse API Response for ProductType: " + strProductType);
		Assert.assertEquals(strProductType, "PERSONAL_LOAN");
	}	

	@Test
	public void validateResponseCode401() throws UnirestException {
		strBody = strApiBodyFor401;
		getJsonResponse();	
		System.out.println("Status code: " + responseCode);
		Assert.assertEquals(responseCode, 401);
	}
	
	@AfterSuite
	public void afterSuite() throws IOException {			
		Unirest.shutdown();
		
	}
	
}