package ActinsPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MoveToElementClass3 {

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new  ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://demoqa.com/menu");
		WebElement aboutus = driver.findElement(By.xpath("//a[text()='Main Item 2']"));
		WebElement list = driver.findElement(By.xpath("//a[text()='SUB SUB LIST »']"));
		
		Actions act = new Actions(driver);
		act.moveToElement(aboutus).moveToElement(list).build().perform();
		
		Thread.sleep(15000);
		
		driver.close();
		driver.quit();

	}

}
