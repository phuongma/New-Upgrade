package managers;
/**
 * Webdriver initialization and closure are handled in this class
 * Only create FirefoxDriver for the simplicity of this exercise.  Could add other drivers later on.
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverManager {
	private WebDriver driver;

	public WebDriver getDriver()
	{
		if (driver == null) driver = new FirefoxDriver();
		driver.manage().window().maximize();
		return driver;
	}

	
	public void quitDriver()
	{
		driver.close();
		driver.quit();
	}
	
	public void closeDriver()
	{
		driver.close();	
	}
}
