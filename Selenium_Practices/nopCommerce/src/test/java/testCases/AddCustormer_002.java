package testCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.CustomerPage;
import pageObjects.LoginPage;
import utilities.TestListners;

@Listeners(TestListners.class)
public class AddCustormer_002 extends BaseObject
{
	
	
	
	@Test
	public void AddCustormer() throws InterruptedException 
	{
		CustomerPage customerPage = new CustomerPage(driver);
		LoginPage loginObj = new LoginPage(driver);
		
		loginObj.Login(pfr.getEmail(), pfr.getPassword());	
		customerPage.AddNewCustomer(pfr.cemail(), pfr.cpassword(), pfr.firstname(), 
				pfr.lastname(), pfr.dob(), pfr.companyname(), pfr.comment());
		
	}	
}
