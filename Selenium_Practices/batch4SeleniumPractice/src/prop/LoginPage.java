package prop;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class LoginPage 
{
	public static WebDriver driver;
	
	public void Login(String User,String Password) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		driver = new  ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.guru99.com/test/newtours/");
		
		
		driver.findElement(By.name("userName")).sendKeys(User);
		driver.findElement(By.name("password")).sendKeys(Password);
		Thread.sleep(5000);
		Actions a = new Actions(driver);
		a.click(driver.findElement(By.name("submit"))).build().perform();
		
	}
	
	public void Logout()
	{
		driver.close();
		driver.quit();
	}
	
}
