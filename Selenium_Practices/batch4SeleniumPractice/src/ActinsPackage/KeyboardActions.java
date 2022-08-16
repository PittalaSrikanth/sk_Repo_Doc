package ActinsPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyboardActions {

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();		
		driver.get("https://demoqa.com/automation-practice-form");
		WebElement fn =	driver.findElement(By.id("firstName"));
		WebElement email =	driver.findElement(By.id("userEmail"));
		
		Actions ac = new Actions(driver);
		ac.click(fn).sendKeys("srikanth",Keys.TAB,"LastName",Keys.TAB,"sri@gmail.com")
		.build().perform();
		
		
		Thread.sleep(5000);
		driver.close();
		driver.quit();

	}

}
