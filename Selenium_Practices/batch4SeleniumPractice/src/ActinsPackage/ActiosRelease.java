package ActinsPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActiosRelease {

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new  ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://demoqa.com/slider");
		
		
		
		WebElement slide = driver.findElement(By.xpath("(//div[@id='sliderContainer']//input)[1]"));
		WebElement complete = driver.findElement(By.id("sliderValue"));
		
		Actions act = new Actions(driver);
		act.clickAndHold(slide).moveToElement(complete).build().perform();
		act.release(slide).build().perform();
		
		Thread.sleep(5000);
		
		driver.close();
		driver.quit();

	}

}
