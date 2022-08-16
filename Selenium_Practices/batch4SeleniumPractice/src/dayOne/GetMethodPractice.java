package dayOne;

import java.util.Set;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;



public class GetMethodPractice 
{
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		String pageTitle = 	driver.getTitle();
		System.out.println(pageTitle);
		System.out.println("*********************************************");
		
		
		String mycurrnetUrl =	driver.getCurrentUrl();
		System.out.println(mycurrnetUrl);
		System.out.println("*********************************************");
		
		String mypagesource =	driver.getPageSource();
		System.out.println(mypagesource);
		System.out.println("*********************************************");
		
		
		SessionId  ssid = 	((RemoteWebDriver)driver).getSessionId();
		System.out.println(ssid);
		System.out.println("*********************************************");
		
		
		String mybrowsername =	((RemoteWebDriver)driver).getCapabilities().getBrowserName();
		System.out.println(mybrowsername);
		System.out.println("*********************************************");
		
		Platform myplatformname =  ((RemoteWebDriver)driver).getCapabilities().getPlatform();
		System.out.println(myplatformname);
		System.out.println("*********************************************");
		
		String mybrowserversion = 	((RemoteWebDriver)driver).getCapabilities().getVersion();
		System.out.println(mybrowserversion);
		System.out.println("*********************************************");
		
		Object mycapvalue =	((RemoteWebDriver)driver).getCapabilities().getCapability("timeouts");
		System.out.println(mycapvalue);
		System.out.println("*********************************************");
		Set<String> mycapnames =	((RemoteWebDriver)driver).getCapabilities().getCapabilityNames();
		for(String capname : mycapnames )
		{
			System.out.println(capname);
		}
		System.out.println("*********************************************");
		
		
		
		driver.close();
		driver.quit();
		
		
	}
}
