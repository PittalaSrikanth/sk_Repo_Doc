package dayOne;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CookiesPractices {

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		ChromeOptions ops = new ChromeOptions();
		ops.setHeadless(true);
		WebDriver driver = new ChromeDriver(ops);
		driver.get("https://www.zensar.com/");
		
		Thread.sleep(5000);
		
		// print all cookies present in a web site
		Set<Cookie> setofcookies =	driver.manage().getCookies();
		for(Cookie k : setofcookies) 
		{
			System.out.println("********************************************");
			System.out.println(k.getName());
			System.out.println(k.getDomain());
			System.out.println(k.getPath());
			System.out.println(k.getValue());
			System.out.println(k.getClass());
			System.out.println(k.getExpiry());
			System.out.println("********************************************");
			
		}
		Thread.sleep(5000);
		
		Cookie k =	driver.manage().getCookieNamed("cookiesession1");
		System.out.println(k);
		System.out.println("********************************************");
		
		Cookie mycookie = new Cookie("MobileNo", "8712282868");
		driver.manage().addCookie(mycookie);
		System.out.println("********************************************");
		
		Cookie mycookie2 = new Cookie("Name", "SK");
		driver.manage().addCookie(mycookie2);
		System.out.println("********************************************");
		
		Cookie myc =	driver.manage().getCookieNamed("MobileNo");
		System.out.println(myc);
		
		driver.manage().deleteCookieNamed("MobileNo");
		
		System.out.println("********************************************");
		Cookie mycc =	driver.manage().getCookieNamed("MobileNo");
		System.out.println(mycc);
		
		driver.manage().deleteCookie(mycookie2);
		
		System.out.println("********************************************");
		Cookie mycc2 =	driver.manage().getCookieNamed("Name");
		System.out.println(mycc2);
		
		driver.manage().deleteAllCookies();
		
		System.out.println("********************************************");
		Set<Cookie> setofcookies2 =	driver.manage().getCookies();
		System.out.println(setofcookies2);
		for(Cookie k1 : setofcookies2) 
		{
			System.out.println("********************************************");
			System.out.println(k1.getName());
			System.out.println(k1.getDomain());
			System.out.println(k1.getPath());
			System.out.println(k1.getValue());
			System.out.println(k1.getClass());
			System.out.println(k1.getExpiry());
			System.out.println("********************************************");
			
		}
		System.out.println("********************************************");
		driver.close();
		driver.quit();
	
	}

}
