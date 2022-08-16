package brokenlinks;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BLink 
{

	public static void main(String[] args) throws IOException, InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new  ChromeDriver();
		
		try 
		{
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get("https://www.redbus.in/");
			Thread.sleep(5000);
			List<WebElement> links = driver.findElements(By.tagName("a"));
			List<WebElement> images = driver.findElements(By.tagName("img"));
			
			for(WebElement link : links)
			{
				String ref = link.getAttribute("href");
				URL url = new URL(ref);
				HttpURLConnection con = (HttpURLConnection)url.openConnection();
				con.connect();
				int resCode = con.getResponseCode();
				if(resCode>=400)
				{
					System.out.println("Broken link :" + ref);
				}
				else {
					System.out.println("Valid link :" + ref);
				}
			}
			
			
			for(WebElement image : images)
			{
				String ref = image.getAttribute("src");
				URL url = new URL(ref);
				HttpURLConnection con = (HttpURLConnection)url.openConnection();
				con.connect();
				int resCode = con.getResponseCode();
				if(resCode>=400)
				{
					System.out.println("Broken image :" + ref);
				}
				else {
					System.out.println("Valid image :" + ref);
				}
				
			}
		}
		
		catch (Exception e) 
		{			
			System.out.println(e.getMessage());
		}	
	
	
		Thread.sleep(5000);
		driver.close();
		driver.quit();
	}

}
