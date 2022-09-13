package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileReader 
{
	Properties pro;
	public PropertyFileReader()
	{
		
		try {
			File pf = new File("./TestData/ConfigData.properties");		
			FileInputStream fis = new FileInputStream(pf);		
			pro = new Properties();
			pro.load(fis);
		} catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getAppURL() 
	{
		return pro.getProperty("url");
		
	}
	
	public String getChromeDriverpath() 
	{
		return pro.getProperty("chromedriverpath");
	}
	
	public String getEmail() 
	{
		return pro.getProperty("email");
	}
	
	public String getPassword() 
	{
		return pro.getProperty("password");
	}
	
	public String getloginPageTitle() 
	{
		return pro.getProperty("loginPageTitle");
	}
	
	public String getDashBoardPageTitle() 
	{
		return pro.getProperty("dashBoardPageTitle");
	}
	
	public String getFirefoxDriverpath() 
	{
		return pro.getProperty("firefoxdriverpath");
	}

	public String getiedriverpath() 
	{
		return pro.getProperty("iedriverpath");
	}

	
	public String cemail() 
	{
		return pro.getProperty("cemail");
	}
	
	public String cpassword() 
	{
		return pro.getProperty("cpassword");
	}
	
	public String firstname() 
	{
		return pro.getProperty("firstname");
	}
	
	public String lastname() 
	{
		return pro.getProperty("lastname");
	}
	
	public String comment() 
	{
		return pro.getProperty("comment");
	}
	
	public String companyname() 
	{
		return pro.getProperty("companyname");
	}
	
	public String dob() 
	{
		return pro.getProperty("dob");
	}
	
	


	
}
