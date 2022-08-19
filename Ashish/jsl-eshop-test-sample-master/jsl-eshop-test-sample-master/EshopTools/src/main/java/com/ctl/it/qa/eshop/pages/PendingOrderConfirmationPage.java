package com.ctl.it.qa.eshop.pages;

import org.openqa.selenium.support.FindBy;

import com.ctl.it.qa.staf.Page;

import net.serenitybdd.core.pages.WebElementFacade;

public class PendingOrderConfirmationPage extends Page{

	
	@FindBy(xpath = "//button[contains(text(),'Close Session')]")
	public WebElementFacade viewaccountdetails;
	
	@Override
	public WebElementFacade getUniqueElementInPage() {
		
		return viewaccountdetails;
	}

}
