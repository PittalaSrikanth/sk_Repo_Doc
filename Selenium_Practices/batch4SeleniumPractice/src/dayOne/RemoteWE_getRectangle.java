package dayOne;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RemoteWE_getRectangle 
{
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		Rectangle r = 	driver.findElement(By.id("txtUsername")).getRect();
		System.out.println(r.getX());
		System.out.println(r.getHeight());
		
		System.out.println(r.getY());
		System.out.println(r.getWidth());
		
		driver.close();
		driver.quit();
	}
}
