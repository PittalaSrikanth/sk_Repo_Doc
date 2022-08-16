package dayOne;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WIndowHandles2Class 
{
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new  ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.redbus.in/");
		// geting parent window handle
		String parentWindowHandle =	driver.getWindowHandle();
		System.out.println(parentWindowHandle);
		
		driver.findElement(By.xpath("//ul[@id='offer_container']/li[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Contact Us")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("About Us")).click();
		Thread.sleep(2000);
		
		Set<String> allwindows = driver.getWindowHandles();
		for(String window : allwindows) 
		{
			if(!window.equals(parentWindowHandle))
			{
				driver.switchTo().window(window);
				Thread.sleep(2000);
				if(driver.getTitle().contains("Offers: Bus Offers & Coupon Codes | Grab Discount on Bus Booking"))
				{
					System.out.println(driver.findElement(By.xpath("//p[.='What is the Offer']")).getText());
				}
				else if(driver.getTitle().equals("Customer Support, 24X7  Customer Service -redBus.in")) 
				{
					System.out.println(driver.findElement(By.xpath("//heading[.='Corporate Head Office-Bangalore']")).getText());
				}
				else if(driver.getTitle().equals("About Us -redBus.in"))
				{
					
					System.out.println(driver.findElement(By.xpath("//h3[.='About us']")).getText());
				}
			}
		}
		driver.switchTo().window(parentWindowHandle);
		// Vaidating parant window
		if(driver.getTitle().contains("Online Bus Tickets Booking, Book Volvo AC Bus Tickets, Confirmed Bus Reservation -redBus"))
		{
			System.out.println("This is parent window");
		}
		else 
		{
			System.out.println("This is not parent window");
		}
		driver.close();
		driver.quit();
	}
}
