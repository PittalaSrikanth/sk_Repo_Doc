package dayOne;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IsDisplayedMethod {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		Thread.sleep(2000);
		
		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		driver.findElement(By.name("txtPassword")).submit();
		Thread.sleep(5000);
		
		Boolean display =	driver.findElement(By.xpath("//a[text()='Logout']")).isDisplayed();
		System.out.println(display);		
		
		driver.findElement(By.linkText("Welcome Paul")).click();
		Thread.sleep(5000);
		Boolean display1 =	driver.findElement(By.xpath("//a[text()='Logout']")).isDisplayed();
		System.out.println(display1);
		
		driver.close();
		driver.quit();
	}

}
