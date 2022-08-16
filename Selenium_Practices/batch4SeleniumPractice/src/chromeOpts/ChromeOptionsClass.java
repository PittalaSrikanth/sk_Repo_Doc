package chromeOpts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class ChromeOptionsClass {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--start-maximized");
		
		
		
		
		WebDriver driver = new  ChromeDriver(ops);
	
		driver.get("https://demoqa.com/automation-practice-form");
		
		System.out.println(driver.getTitle());
		
		driver.close();
		driver.quit();

	}

}
