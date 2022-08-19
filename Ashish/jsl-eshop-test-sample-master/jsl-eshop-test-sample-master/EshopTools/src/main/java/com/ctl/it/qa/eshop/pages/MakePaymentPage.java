package com.ctl.it.qa.eshop.pages;

import org.openqa.selenium.support.FindBy;

import com.ctl.it.qa.staf.Page;

import net.serenitybdd.core.pages.WebElementFacade;

public class MakePaymentPage extends Page{
	
	@FindBy(xpath="//*[contains(text(),'Make a Payment')]")
	public WebElementFacade makePaymentPageText;
	
	@FindBy(name="cardNum")
	public WebElementFacade cardNumBox;
	
	@FindBy(id="expiryMonth")
	public WebElementFacade expiryMonthdrpDwn;
	
	@FindBy(id="expiryYear")
	public WebElementFacade expiryYearDrpdwn;
	
	@FindBy(name="cardZip")
	public WebElementFacade zipCodeBox;
	
	/*@FindBy(xpath="//div[@id='TermsAndConDiv']/a/span")
	public WebElementFacade tncCheckBox;*/
	
	@FindBy(id="TermsAndCon")
	public WebElementFacade tncCheckBox;
	
	@FindBy(id="ValidatePaymentInfo")
	public WebElementFacade nextButton;
	
	@FindBy(id="submitPayment")
	public WebElementFacade submitBtn;

	@Override
	public WebElementFacade getUniqueElementInPage() {
		// TODO Auto-generated method stub
		return (WebElementFacade) makePaymentPageText;
	}

	

}