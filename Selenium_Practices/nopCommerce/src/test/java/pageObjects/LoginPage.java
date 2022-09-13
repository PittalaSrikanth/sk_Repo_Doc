package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utilities.PerformAction;
import utilities.PropertyFileReader;

public class LoginPage 
{
	WebDriver driver;
	PerformAction perform;
	PropertyFileReader pfr;
	Dashboard db;
	
	public LoginPage(WebDriver cdriver) 
	{
		driver = cdriver;
		PageFactory.initElements(driver, this);
		perform =  new PerformAction(driver);
		pfr = new PropertyFileReader();
		db = new Dashboard(driver);
	}	
	
	@FindBy(xpath = "//strong[contains(.,'Welcome')]")
	public WebElement welcomeNote;
	
	@FindBy(id = "Email")
	public WebElement Email;
	
	@FindBy(id = "Password")
	public WebElement Password;
	
	
	@FindBy(xpath = "//button[.='Log in']")
	public WebElement LogIn;	
	
	
	public String getLoginTitle() 
	{
		return welcomeNote.getText();
	}	
	
	public void Login(String email, String password) {
		Assert.assertEquals(this.getLoginTitle(), pfr.getloginPageTitle(),"Login page title not matched");
		perform.clearInput(this.Email);
		perform.enterText(this.Email, email);
		perform.clearInput(this.Password);
		perform.enterText(this.Password, password);
		perform.click(this.LogIn);
		perform.waitForWebElement(db.DashboardLink, 20);
		Assert.assertEquals(db.getDashBoardTitle(), pfr.getDashBoardPageTitle(),"Dashboard page title not matched");
	}
}
