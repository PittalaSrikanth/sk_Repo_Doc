package dayOne;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectClassEx {

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new  ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://register.rediff.com/register/register.php");
		WebElement countryDD = driver.findElement(By.id("country"));
		
		Select select = new Select(countryDD);
		// select by index (always start with 0)
		select.selectByIndex(5);
		Thread.sleep(2000);
		
		//select by value
		select.selectByValue("8");
		Thread.sleep(2000);
		
		//select by visible text
		select.selectByVisibleText("Belgium");
		Thread.sleep(2000);
		
		//get all items of a dropdown
		List<WebElement> alloptions = select.getOptions();
		System.out.println(alloptions.size());
		for(WebElement option : alloptions)
		{
			System.out.println(option.getText());
			if(option.getText().equals("Iceland")) {
				option.click();
				break;
			}
		}
		
		
		
		
		
		
		Thread.sleep(5000);
		driver.close();
		driver.quit();
	}

}
