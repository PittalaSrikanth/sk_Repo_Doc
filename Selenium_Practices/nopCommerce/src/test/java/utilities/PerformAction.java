package utilities;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PerformAction 
{
	WebDriver driver;
	
	public PerformAction(WebDriver cdriver)
	{
		driver = cdriver;
	}	

	public void enterText(WebElement ele ,String text) 
	{
		try 
		{
			Wait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(ele));
			ele.sendKeys(text);
			System.out.println("Enter "+text+" in webelement "+ ele);
		} 
		catch (Exception e) 
		{			
			System.out.println("Failed to enter "+text+" in webelement "+ ele);
		}		
	}
	
	
	public void click(WebElement ele) 
	{
		try 
		{
			Wait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(ele));
			ele.click();
			System.out.println("Clicked on webelement "+ ele);
		} 
		catch (Exception e) 
		{			
			System.out.println("Failed to clicked on webelement "+ ele);
			Assert.fail();
		}
		
		
	}
	
	
	public void actionClick(WebElement ele) 
	{
		try 
		{
			Wait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(ele));
			Actions action =new Actions(driver);
			action.click(ele).build().perform();
			System.out.println("action click on webelement "+ ele);
		} 
		catch (Exception e) 
		{			
			System.out.println("Failed to action click on webelement "+ ele);
			Assert.fail();
		}
		
		
	}

	
	public void clearInput(WebElement ele) 
	{
		try 
		{
			Wait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(ele));
			ele.clear();
			System.out.println("cleared  webelement "+ ele);
		} 
		catch (Exception e) 
		{			
			System.out.println("Failed to cleared webelement "+ ele);
			Assert.fail();
		}
		
		
	}
	
	
	public void actionClearInput(WebElement ele) 
	{
		try 
		{
			Wait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(ele));
			Actions action = new Actions(driver);
			action.sendKeys(Keys.SHIFT , Keys.HOME,Keys.BACK_SPACE).build().perform();			
			System.out.println("action clear  webelement "+ ele);
		} 
		catch (Exception e) 
		{			
			System.out.println("Failed to action  cleared webelement "+ ele);
			Assert.fail();
		}
		
		
	}

	
	public void waitForWebElement(WebElement ele ,int timeInSec) 
	{
		try 
		{
			Wait wait = new WebDriverWait(driver, timeInSec);
			wait.until(ExpectedConditions.visibilityOf(ele));
			System.out.println("Waited for webelement "+ ele);
		} 
		catch (Exception e) 
		{			
			System.out.println("Failed to Wait for webelement "+ ele);
			Assert.fail();
		}
		
		
	}
	
	
	
}
