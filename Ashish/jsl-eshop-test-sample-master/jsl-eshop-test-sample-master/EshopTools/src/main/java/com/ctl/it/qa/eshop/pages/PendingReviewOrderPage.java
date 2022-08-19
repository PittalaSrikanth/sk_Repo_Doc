package com.ctl.it.qa.eshop.pages;

import org.openqa.selenium.support.FindBy;

import com.ctl.it.qa.staf.Page;

import net.serenitybdd.core.pages.WebElementFacade;

public class PendingReviewOrderPage extends Page{

	@FindBy(xpath = "//button[contains(text(),'Submit Revisions')]")
	public WebElementFacade submitRevisions;
	
	@FindBy(id = "selectYes")
	public WebElementFacade selectYes;
	
	@FindBy(id = "selectNo")
	public WebElementFacade selectNo;
	
	@Override
	public WebElementFacade getUniqueElementInPage() {
		
		return submitRevisions;
	}

}
