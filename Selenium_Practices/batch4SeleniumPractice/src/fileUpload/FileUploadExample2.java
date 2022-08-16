package fileUpload;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FileUploadExample2 {

	public static void main(String[] args) throws IOException, InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new  ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demoqa.com/automation-practice-form");
		Actions action = new Actions(driver);
		action.click(driver.findElement(By.xpath("//input[@id='uploadPicture']"))).build().perform();
			
		
		
		Runtime.getRuntime().exec("C:\\Users\\spittala\\Desktop\\FileUpload.exe");
		
		Thread.sleep(5000);
	    driver.close();
	    driver.quit();
	}

}
