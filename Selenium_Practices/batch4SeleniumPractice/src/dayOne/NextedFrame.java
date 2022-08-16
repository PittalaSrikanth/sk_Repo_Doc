package dayOne;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NextedFrame {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new  ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demoqa.com/nestedframes");
		
		driver.switchTo().frame(driver.findElement(By.id("frame1")));
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@srcdoc='<p>Child Iframe</p>']")));
		System.out.println(driver.findElement(By.xpath("//p[.='Child Iframe']")).getText());
		
		
		driver.switchTo().parentFrame();
		System.out.println(driver.findElement(By.xpath("//*[.='Parent frame']")).getText());
		
		driver.switchTo().defaultContent();
		
		driver.close();
		driver.quit();
	}

}
