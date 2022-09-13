package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dashboard 
{
	WebDriver driver;
	
	public Dashboard(WebDriver cdriver) 
	{
		driver = cdriver;
		PageFactory.initElements(driver, this);
	}		
	
	@FindBy(xpath = "//p[.=' Dashboard']")
	public WebElement DashboardLink;
	
	@FindBy(xpath = "//p[text()=' Dashboard']/../../../li[4]/a")
	public WebElement cutomersMenu;

	
	@FindBy(xpath = "//p[.=' Customers']")
	public WebElement addCutomers;


	@FindBy(linkText =  "Logout")
	public WebElement Logout;

	public String getDashBoardTitle() 
	{
		return driver.getTitle();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
