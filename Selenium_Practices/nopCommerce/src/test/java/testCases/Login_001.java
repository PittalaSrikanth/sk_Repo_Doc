package testCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import utilities.TestListners;

@Listeners(TestListners.class)
public class Login_001 extends BaseObject
{
	
	@Test
	public void LoginTest()
	{
		LoginPage loginObj = new LoginPage(driver);
		loginObj.Login(pfr.getEmail(), pfr.getPassword());
	}
	
	
	
	
	
	
}
