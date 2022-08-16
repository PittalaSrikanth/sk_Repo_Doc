package ActinsPackage;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActiosMoveByOffSet {

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new  ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://demoqa.com/droppable");
		
		
		
		WebElement rd = driver.findElement(By.xpath("//a[text()='Revert Draggable']"));
		WebElement revertable = driver.findElement(By.id("revertable"));
		WebElement droppable = driver.findElement(By.xpath("(//div[@id='droppable'])[3]"));
		
		Actions act = new Actions(driver);
		act.click(rd).pause(2000).clickAndHold(revertable)
		.pause(2000).moveByOffset(100,50).build().perform();

		
		Thread.sleep(5000);
		
		driver.close();
		driver.quit();

	}

}
