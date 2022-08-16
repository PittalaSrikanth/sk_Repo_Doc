package javaScriptExecutorPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptScrolling4 
{
public static void main(String[] args) throws InterruptedException 
{
	System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
	WebDriver driver = new  ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.location='https://www.redbus.in/'");
	
//	// scroll complete down
//	js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
//	
//	Thread.sleep(5000);
//	// scroll complete up
//	js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
	
	
	//height of my webpage
	String height =	js.executeScript("return window.innerHeight").toString();
	System.out.println(height);
	
	//width of my webpage
	String width =	js.executeScript("return window.innerWidth").toString();
	System.out.println(width);
	
	WebElement text = driver.findElement(By.xpath("(//div[contains(.,'The numbers are growing!')])[5]"));
	
	js.executeScript("arguments[0].scrollIntoView(true);", text);
	
	
	
	Thread.sleep(5000);
	driver.close();
	driver.quit();
}
}
