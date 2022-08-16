package dayOne;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsClass1 {

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new  ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demoqa.com/automation-practice-form");
		Actions action = new Actions(driver);
		WebElement fn = driver.findElement(By.id("firstName"));
		action.keyDown(fn, Keys.SHIFT)
		.sendKeys(fn,"hellow").keyUp(fn, Keys.SHIFT).build().perform();
		
		
		Thread.sleep(5000);
		driver.close();
		driver.quit();
	}

}
