package javaScriptExecutorPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptScrolling3 
{
public static void main(String[] args) throws InterruptedException 
{
	System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
	WebDriver driver = new  ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.location='https://www.htmlelements.com/demos/table/overview/'");
//	driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
	
	WebElement ele = driver.findElement(By.xpath("(//div[@smart-id='container'])[3]"));
	
//	js.executeScript("document.querySelector('#table').scrollBy(0,50000)");
	
	js.executeScript("arguments[0].scrollBy(0,50000)", ele);
	
	
	Thread.sleep(5000);
	driver.close();
	driver.quit();
}
}
