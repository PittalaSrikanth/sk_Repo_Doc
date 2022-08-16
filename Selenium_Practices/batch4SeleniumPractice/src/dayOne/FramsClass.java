package dayOne;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FramsClass {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new  ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String parent = driver.getWindowHandle();
		driver.get("https://www.redbus.in/");
		driver.findElement(By.linkText("Help")).click();
		Set<String> alltabs = driver.getWindowHandles();
		
		for(String tab : alltabs)
		{
			if(tab.equals(parent))
			{
				
			}
			else
			{
				driver.switchTo().window(tab);
			}
		}
		
		
		WebElement frame =	driver.findElement(By.className("modalIframe"));
		
		driver.switchTo().frame(frame);	
		
		String text =	driver.findElement(By.xpath("(//div[.='Sign in for faster support for all your queries!!'])[1]")).getText();
		
		System.out.println(text);
		
		driver.switchTo().defaultContent();
		
		driver.close();
		driver.quit();

	}

}
