package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

import pageObjects.Dashboard;
import utilities.PerformAction;
import utilities.PropertyFileReader;

public class BaseObject 
{
	
	public static WebDriver driver;
	Dashboard db;
	PerformAction perform;
	PropertyFileReader pfr = new PropertyFileReader();
	
	
	@Parameters("browserName")
	@BeforeMethod
	public void setUp(@Optional("chrome") String browser) 
	{		
		if(browser.equalsIgnoreCase("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver", pfr.getChromeDriverpath());
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(pfr.getAppURL());
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			db = new Dashboard(driver);
			perform = new PerformAction(driver);
			
		}
		else if (browser.equalsIgnoreCase("firefox")) 
		{
			System.setProperty("webdriver.gecko.driver", pfr.getFirefoxDriverpath());
			driver = new FirefoxDriver();
			driver.get(pfr.getAppURL());
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			db = new Dashboard(driver);			
			perform = new PerformAction(driver);
		}
		
		else if (browser.equalsIgnoreCase("ie")) 
		{
			System.setProperty("webdriver.ie.driver", pfr.getiedriverpath());
			driver = new FirefoxDriver();
			driver.get(pfr.getAppURL());
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			db = new Dashboard(driver);
			perform = new PerformAction(driver);
			
		}
		
		
	}
	
	@AfterMethod(alwaysRun = true)
	public void tearDown() 
	{
		perform.actionClick(db.Logout);		
		driver.quit();
	}
}
