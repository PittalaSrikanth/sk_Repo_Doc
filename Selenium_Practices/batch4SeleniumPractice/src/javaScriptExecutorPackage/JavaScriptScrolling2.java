package javaScriptExecutorPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptScrolling2 
{
public static void main(String[] args) throws InterruptedException 
{
	System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
	WebDriver driver = new  ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.location='https://www.w3schools.com/howto/howto_css_table_responsive.asp'");
	
	WebElement hscroll = driver.findElement(By.xpath("(//th[.='First Name']/ancestor::div)[4]"));
	
	js.executeScript("arguments[0].scrollBy(3000,0)", hscroll);
	
	
//	js.executeScript("document.querySelector('#main>div[style=\"overflow-x:auto;\"]').scrollBy(200,0)");
	
	
	
	Thread.sleep(5000);
	driver.close();
	driver.quit();
}
}
