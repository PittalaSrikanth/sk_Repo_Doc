package dayOne;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class RemoteWE_IsSelected {

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		Thread.sleep(7000);
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		
		driver.findElement(By.id("menu_admin_viewAdminModule")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("btnAdd")).click();
		Thread.sleep(2000);
		
		Boolean result =	driver.findElement(By.xpath("//option[.='ESS']")).isSelected();
		System.out.println(result);
		
		Select s = new Select(driver.findElement(By.name("systemUser[userType]")));
		s.selectByVisibleText("Admin");
		Thread.sleep(2000);
		

		Boolean result3 =	driver.findElement(By.xpath("//option[.='Admin']")).isSelected();
		System.out.println(result3);
		
		Boolean result2 =	driver.findElement(By.xpath("//option[.='ESS']")).isSelected();
		System.out.println(result2);
		
		
		driver.close();
		driver.quit();
	}

}
