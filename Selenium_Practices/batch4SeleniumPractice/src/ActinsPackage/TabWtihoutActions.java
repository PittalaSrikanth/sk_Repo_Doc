package ActinsPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TabWtihoutActions 
{
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();		
		driver.get("https://demoqa.com/automation-practice-form");
		WebElement fn =	driver.findElement(By.id("firstName"));
		
		fn.sendKeys("srikanth"+Keys.TAB+"lastName"+Keys.TAB+"s@gmail.com");
		
		Thread.sleep(5000);
		driver.close();
		driver.quit();
	}
	
}
