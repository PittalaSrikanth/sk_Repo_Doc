package com.ctl.it.qa.eshop.pages;

import org.openqa.selenium.support.FindBy;

import com.ctl.it.qa.staf.Page;
import com.ctl.it.qa.staf.xml.reader.IntDataContainer;

import net.serenitybdd.core.pages.WebElementFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginPage extends Page {
	
	@FindBy(xpath = "//input[@name='username']")
	public WebElementFacade userName;

	@FindBy(xpath = "//input[@name='password' and @type='password']")
	public WebElementFacade password;

	//@FindBy(xpath = "//input[@name='submit' and @title='Login']")
	@FindBy(xpath = "//input[@type='submit']")
	public WebElementFacade loginBtn;

	
	@Override
	public WebElementFacade getUniqueElementInPage() {
		return userName;
	}

	public static String getEnvironment() {
		String url = envData.getFieldValue("url");
		String env = null;

		if (url.contains("consultingplusa1")) {
			env = "TEST1";
		} else if (url.contains("eshop-e2e.test.intranet")) {
			env = "E2E";
		} else if (url.contains("consultingplusa5")) {
			env = "TEST2";
		}
		return env;
	}

	public void enterCredentials(String userType) {
		IntDataContainer dataContainer = envData.getContainer("EshopLoginPage").getContainer(userType);
		userName.sendKeys(dataContainer.getFieldValue("tbx_username"));		
		password.sendKeys(dataContainer.getFieldValue("tbx_password"));
		loginBtn.click();

	}

}
