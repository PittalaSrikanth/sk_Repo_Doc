package ActinsPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActiosContextClick {

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new  ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://demoqa.com/buttons");
		WebElement doubleClickBtn = driver.findElement(By.id("doubleClickBtn"));
//		WebElement list = driver.findElement(By.xpath("//a[text()='SUB SUB LIST »']"));
		
		Actions act = new Actions(driver);
		act.doubleClick(doubleClickBtn).build().perform();
		
		Thread.sleep(5000);
		
		driver.close();
		driver.quit();

	}

}
