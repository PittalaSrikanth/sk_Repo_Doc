package dayOne;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExceptionsExample {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new  ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/automation-practice-form");
		
		
		
		try
		{
			driver.findElement(By.id("firstNameeeeee")).sendKeys("text");
		}
		catch (Exception e) 
		{
		 System.out.println(e.getMessage());
		}
		
		
		
		
		
		driver.close();
		driver.quit();

	}

}
