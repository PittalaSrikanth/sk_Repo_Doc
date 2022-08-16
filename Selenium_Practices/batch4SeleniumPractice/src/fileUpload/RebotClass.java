package fileUpload;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RebotClass {
public static void main(String[] args) throws InterruptedException, AWTException {
	System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
	WebDriver driver = new  ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get("https://demoqa.com/automation-practice-form");
	Thread.sleep(5000);
	Actions action = new Actions(driver);
	action.click(driver.findElement(By.xpath("//input[@id='uploadPicture']"))).build().perform();
	Thread.sleep(5000);
	StringSelection path = new StringSelection("D:\\Automation_\\Siddhi_Notes_Repo\\Selenium_Practices\\batch4SeleniumPractice\\Screenshot\\test1.png");
	Toolkit.getDefaultToolkit().getSystemClipboard().setContents(path, null);
	
	Robot r = new Robot();
	r.keyPress(KeyEvent.VK_CONTROL);
	r.keyPress(KeyEvent.VK_V);
	r.keyRelease(KeyEvent.VK_V);
	r.keyRelease(KeyEvent.VK_CONTROL);
	Thread.sleep(5000);
	r.keyPress(KeyEvent.VK_ENTER);
	r.keyRelease(KeyEvent.VK_ENTER);
	Thread.sleep(5000);
	
	driver.close();
	driver.quit();
}
}
