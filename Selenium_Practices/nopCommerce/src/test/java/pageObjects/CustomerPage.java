package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utilities.PerformAction;
import utilities.PropertyFileReader;

public class CustomerPage 
{
	WebDriver driver;
	PerformAction perform;
	PropertyFileReader pfr;
	Dashboard db;
	
	public CustomerPage(WebDriver cdriver) 
	{
		driver = cdriver;
		PageFactory.initElements(driver, this);
		perform =  new PerformAction(driver);
		pfr = new PropertyFileReader();
		db = new Dashboard(driver);
	}		
	
	@FindBy(xpath = "//*[contains(@href,'Create')]")
	public WebElement AddNewCustomerBtn;	
	
	@FindBy(id = "Email")
	public WebElement Email;

	@FindBy(id = "Password")
	public WebElement Password;

	@FindBy(id = "FirstName")
	public WebElement FirstName;

	@FindBy(id = "LastName")
	public WebElement LastName;

	@FindBy(id = "Gender_Male")
	public WebElement GenderMale;

	@FindBy(id = "DateOfBirth")
	public WebElement DateOfBirth;

	@FindBy(id = "Company")
	public WebElement Company;

	@FindBy(id = "VendorId")
	public WebElement VendorId;

	@FindBy(id = "AdminComment")
	public WebElement AdminComment;

	@FindBy(name = "save")
	public WebElement save;
	
	public String getDashBoardTitle() 
	{
		return driver.getTitle();
	}
	
	public void AddNewCustomer(String cemail,String cpassword,String fn,String ln,String dob,String cname,String comment) 
	{
		Assert.assertEquals(db.getDashBoardTitle(), pfr.getDashBoardPageTitle(),"Dashboard page title not matched");
		perform.click(db.cutomersMenu);
		perform.click(db.addCutomers);
		perform.click(this.AddNewCustomerBtn);		
		perform.enterText(this.Email, pfr.cemail());
		perform.enterText(this.Password, pfr.cpassword());
		perform.enterText(this.FirstName, pfr.firstname());
		perform.enterText(this.LastName, pfr.lastname());
		perform.click(this.GenderMale);		
		perform.enterText(this.DateOfBirth, pfr.dob());
		perform.enterText(this.Company, pfr.companyname());
		perform.enterText(this.AdminComment, pfr.comment());	
		perform.click(this.save);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
