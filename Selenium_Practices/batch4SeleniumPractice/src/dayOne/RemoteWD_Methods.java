package dayOne;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RemoteWD_Methods 
{
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.instagram.com/");
		Thread.sleep(10000);
		Boolean result =	driver.findElement(By.xpath("(//div[.='Log In'])[2]/..")).isEnabled();
		System.out.println(result);
		driver.findElement(By.name("username")).sendKeys("srikanth.p4991@gmail.com");
		driver.findElement(By.name("password")).sendKeys("1234567894564");
		Boolean result2 =	driver.findElement(By.xpath("(//div[.='Log In'])[2]/..")).isEnabled();
		System.out.println(result2);
		driver.close();
		driver.quit();
	}
}
