package javaScriptExecutorPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptActions {

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new  ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.location='https://demoqa.com/automation-practice-form'");
		
		String title = js.executeScript("return document.title").toString();
		System.out.println(title);
		
		String domain = js.executeScript("return document.domain").toString();
		System.out.println(domain);
		
		String url = js.executeScript("return document.URL").toString();
		System.out.println(url);
		
		System.out.println("*******************");
		String text = js.executeScript("return document.getElementById('userName-label').innerText").toString();
		System.out.println(text);
		
		WebElement fn =	driver.findElement(By.id("userName-label"));
		WebElement male =	driver.findElement(By.id("gender-radio-1"));
		WebElement firstName =	driver.findElement(By.id("firstName"));
		
		
		String text1 = js.executeScript("return arguments[0].innerText",fn).toString();
		System.out.println(text1);
		System.out.println("*******************");
		
		System.out.println("*******************");
		String att = js.executeScript("return document.getElementById('userName-label').getAttribute('class')").toString();
		System.out.println(att);
		
		String att1 = js.executeScript("return arguments[0].getAttribute('class')",fn).toString();
		System.out.println(att1);
		System.out.println("*******************");
		
		System.out.println("*******************");
//		js.executeScript("return document.getElementById('gender-radio-1').click()");
		js.executeScript("return arguments[0].click()",male);
		System.out.println("*******************");
		
		
		System.out.println("*******************");
		js.executeScript("return document.getElementById('firstName').value='Srikanth'");
		js.executeScript("return arguments[0].value='Srikanth'",firstName);
		System.out.println("*******************");
		
		//Vertical Scrolling
		js.executeScript("window.scrollTo(	0,200)");
		
		
		
		Thread.sleep(5000);
		driver.close();
		driver.quit();

	}

}
