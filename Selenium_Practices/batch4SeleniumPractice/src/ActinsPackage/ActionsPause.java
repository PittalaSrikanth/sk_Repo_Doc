package ActinsPackage;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsPause {

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new  ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.instagram.com/");
		
		
		WebElement firstName = driver.findElement(By.name("username"));
		WebElement lastName = driver.findElement(By.name("password"));
		
		Actions act = new Actions(driver);
		act.sendKeys(firstName,"firstName").pause(Duration.ofSeconds(2))
		.sendKeys(lastName,"lastName").pause(Duration.ofSeconds(2)).build().perform();
		
		
//		Thread.sleep(5000);
		
		driver.close();
		driver.quit();

	}

}
