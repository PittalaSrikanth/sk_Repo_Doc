package dayOne;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RemoteWE_GetLocation {

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		Thread.sleep(7000);
		Point p =	driver.findElement(By.id("txtUsername")).getLocation();
		System.out.println(p.x);
		System.out.println(p.getX());
		
		System.out.println(p.y);
		System.out.println(p.getY());
		
		driver.close();
		driver.quit();
	}

}
