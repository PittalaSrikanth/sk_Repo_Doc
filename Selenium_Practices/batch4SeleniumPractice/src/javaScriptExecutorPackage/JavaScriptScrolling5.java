package javaScriptExecutorPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptScrolling5 
{
public static void main(String[] args) throws InterruptedException 
{
	System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
	WebDriver driver = new  ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.location='https://demoqa.com/automation-practice-form'");
	
	
	WebElement fn = driver.findElement(By.id("firstName"));
	WebElement ln = driver.findElement(By.id("lastName"));

	js.executeScript("arguments[0].value='Srikanth';arguments[1].value='P'", fn,ln);
	
	js.executeScript("arguments[0].style.borderColor='red'", fn);
	
	js.executeScript("history.go(0)");
	
	Thread.sleep(5000);
	driver.close();
	driver.quit();
}
}
