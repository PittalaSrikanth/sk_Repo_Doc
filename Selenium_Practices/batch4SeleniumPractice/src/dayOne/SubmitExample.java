package dayOne;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.chrome.ChromeDriver;

public class SubmitExample {

	public static void main(String[] args) throws InterruptedException   
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		Timeouts t = driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		System.out.println(t);
		Thread.sleep(2000);
		driver.findElement(By.name("email")).sendKeys("SiddhiBatch3@gmail.com");
		String tagValue =	driver.findElement(By.name("email")).getTagName();
		System.out.println(tagValue);
		String attributeValue =	driver.findElement(By.name("email")).getAttribute("placeholder");
		System.out.println(attributeValue);		
		driver.findElement(By.name("pass")).sendKeys("admin");
		
		String textValue = driver.findElement(By.xpath("//a[.='Forgotten password?']")).getText();
		System.out.println(textValue);
		
		
		
		
		driver.findElement(By.name("login")).submit();
		driver.close();
		driver.quit();
		

	}

}
