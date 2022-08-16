package dayOne;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectClassEx2 {

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new  ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.hyrtutorials.com/p/html-dropdown-elements-practice.html");
		WebElement ide = driver.findElement(By.id("ide"));
		
		Select select = new Select(ide);
		// get a dropdown is multi selected ro single selected
		boolean ismultiple =	select.isMultiple();
		System.out.println(ismultiple);
		
		
		// get first selected value from multi selected dropdown
		
		select.selectByVisibleText("NetBeans");
		select.selectByVisibleText("Visual Studio");
		select.selectByVisibleText("Eclipse");
		WebElement opt =	select.getFirstSelectedOption();
		System.out.println(opt.getText());
		Thread.sleep(5000);
		
		//get all selected value from multi selected dropdown
		List<WebElement> allselectedOptins = select.getAllSelectedOptions();
		for(WebElement seleopt : allselectedOptins)
		{
			System.out.println(seleopt.getText());
		}
		
		
		Thread.sleep(5000);
		// deselect by index
		select.deselectByIndex(0);
		Thread.sleep(5000);
		// de select by value
		select.deselectByValue("nb");
		Thread.sleep(5000);
		//deselect by visible text
		select.deselectByVisibleText("Visual Studio");
		Thread.sleep(5000);
		
		select.selectByVisibleText("NetBeans");
		select.selectByVisibleText("Visual Studio");
		Thread.sleep(5000);
		select.selectByVisibleText("Eclipse");
		// de select all options from dd
		select.deselectAll();
		
		Thread.sleep(5000);
		driver.close();
		driver.quit();
	}

}
