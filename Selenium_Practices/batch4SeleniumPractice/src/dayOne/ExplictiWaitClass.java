package dayOne;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplictiWaitClass 
{
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://demoqa.com/automation-practice-form");
		WebElement firstName =	driver.findElement(By.id("firstName"));
		
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		
	WebElement fname =	wait.until(ExpectedConditions.visibilityOf(firstName));
	Boolean attStatus =	wait.until(ExpectedConditions.attributeContains(firstName,"placeholder","First Name"));
	fname.sendKeys("Admin");
	System.out.println(attStatus);
		
		
		driver.findElement(By.id("lastName")).sendKeys("admin123");
		driver.findElement(By.xpath("//*[.='Male']")).click();
		
		WebElement userNumber = driver.findElement(By.id("userNumber"));		
		wait.until(ExpectedConditions.visibilityOf(userNumber));
		userNumber.click();
		
		
		
		
		
		driver.close();
		driver.quit();
	}
}
