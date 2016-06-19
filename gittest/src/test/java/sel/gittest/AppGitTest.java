package sel.gittest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class AppGitTest {
	
	@Test
	public void testGoogleSearch() {
		
		// Launch a new Chrome instance
		//System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
		
		// Launch a new IE instance
		System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
		//System.setProperty("webdriver.ie.driver.loglevel", "TRACE");
        //System.setProperty("webdriver.ie.driver.logfile", "log\\selenium.log");
		//DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
		//capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true); 
		WebDriver driver = new InternetExplorerDriver();
		
		// Maximize the browser window
		driver.manage().window().maximize();
		// Navigate to Google
		driver.get("http://www.google.co.in");
				
		// Find the text input element by its name
		WebElement element = driver.findElement(By.name("q"));
		// Clear the existing text value
		element.clear();
		// Enter something to search for
		element.sendKeys("book");
		// Now submit the form
		element.submit();
		
		// Google's search is rendered dynamically with JavaScript.
		// wait for the page to load, timeout after 10 seconds
		new WebDriverWait(driver, 10).until(new
		ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.getTitle().toLowerCase().startsWith("book");
			}
		});
		
		assertEquals("book - Google Search", driver.getTitle());
		
		// Close the browser
		driver.quit();
				
	}
	
}