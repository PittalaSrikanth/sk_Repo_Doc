package dayOne;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WIndowHandlingClass {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new  ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/browser-windows");
		// geting parent window handle
		String parentWindowHandle =	driver.getWindowHandle();
		System.out.println(parentWindowHandle);
		
		
		WebElement newTab =	 driver.findElement(By.id("tabButton"));
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(newTab));
		newTab.click();
		
		
		// getting all tabs or window handles
		Set<String> allTabsHandles =	driver.getWindowHandles();
		for(String handle : allTabsHandles)
		{
			if(handle.equals(parentWindowHandle))
			{
				
			}
			else
			{
				// switching to child tan
				driver.switchTo().window(handle);
				
				// print text from child tab
				String text =	driver.findElement(By.id("sampleHeading")).getText();
				System.out.println(text);
				
				// close the tab
				driver.close();
				
				// switch to parent window
				driver.switchTo().window(parentWindowHandle);	
				
				// Vaidating parant window
				if(driver.getTitle().equals("ToolsQA"))
				{
					System.out.println("This is parent window");
				}
				else 
				{
					System.out.println("This is not parent window");
				}
				
				driver.findElement(By.id("windowButton")).click();
				Set<String> allWIndows = driver.getWindowHandles();
				for(String window :allWIndows)
				{
					if(window.equals(parentWindowHandle))
					{
						
					}
					else {
						driver.switchTo().window(window);
						System.out.println(driver.findElement(By.id("sampleHeading")).getText());
						driver.close();
						driver.switchTo().window(parentWindowHandle);
						// Vaidating parant window
						if(driver.getTitle().equals("ToolsQA"))
						{
							System.out.println("This is parent window");
						}
						else 
						{
							System.out.println("This is not parent window");
						}
					}
				}
				
				
				
			}
			
		}
		driver.close();
		driver.quit();
	}
	

}
