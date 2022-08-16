package dayOne;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RemoteWE_getSize 
{
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		Thread.sleep(7000);
		Dimension d =	driver.findElement(By.id("txtUsername")).getSize();
		System.out.println(d.height);
		System.out.println(d.getHeight());
		
		System.out.println(d.width);
		System.out.println(d.getWidth());
		
		driver.close();
		driver.quit();
	}
}
