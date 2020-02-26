package contextreader;

/**
 * This class creates an instance of webDriverManager and an instance of pageObjectManager
 * And passes the webDriverManager to pageObjectManager
 */

import managers.PageObjectManager;
import managers.WebDriverManager;

public class TestContext {
	
	private WebDriverManager webDriverManager;
	private PageObjectManager pageObjectManager;
	
	public TestContext()
	{
		webDriverManager 	= new WebDriverManager();
		pageObjectManager 	= new PageObjectManager(webDriverManager.getDriver());
	}
	
	public WebDriverManager getWebDriverManager()
	{
		return webDriverManager;
	}

	public PageObjectManager getPageObjectManager()
	{
		return pageObjectManager;
	}
	
	public void closeWebDriver() {
		webDriverManager.closeDriver();;
	}
	
}