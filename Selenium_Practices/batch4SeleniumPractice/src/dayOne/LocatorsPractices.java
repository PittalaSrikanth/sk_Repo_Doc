package dayOne;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class LocatorsPractices {

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver =  new ChromeDriver();
		driver.get("https://www.facebook.com/");
		Thread.sleep(5000);
		
		WebElement username =	driver.findElement(By.id("email"));
		username.sendKeys("srikanth");
		
		WebElement password =	driver.findElement(By.name("pass"));
		password.sendKeys("gowtham");
		
		
		WebElement loginbtn =	driver.findElement(By.name("login"));
		loginbtn.click();
		Thread.sleep(8000);
		
		WebElement forgotpass =	driver.findElement(By.partialLinkText("Forgotten"));
		forgotpass.click();
		Thread.sleep(5000);
		
		
		driver.close();
		driver.quit();
		
	}

}
