package com.ctl.it.qa.eshop.pages;

import org.openqa.selenium.support.FindBy;

import com.ctl.it.qa.staf.Page;

import net.serenitybdd.core.pages.WebElementFacade;

public class ExistingProductsPage extends Page {

	@FindBy(xpath = "//button[contains(text(),'Make Changes')]")
	public WebElementFacade makechanges;
	
	
	@FindBy(xpath = "//div[contains(text(),'Other Order activities')]")
	public WebElementFacade other_order_activies;
	
	
	@FindBy(xpath = "//li//a[text()='Move Service']")
	public WebElementFacade li_move_service;
	
	
	// ******* Move Service Sub window *********//
	
	@FindBy(xpath = "//input[@id='address']")
	public WebElementFacade txt_new_addresss;
	
	@FindBy(xpath = "//input[@id='singleUnitNumber']")
	public WebElementFacade txt_unit_number;
	
	
	@FindBy(xpath ="//button[text()='Validate']")
	public WebElementFacade btn_validate;
	
	// 
	
	@FindBy(xpath ="//button[contains(text(),'Continue')]")
	public WebElementFacade btn_continue_with_order;
	
	//Shaik Changes
	
	@FindBy(xpath = "//div[contains(text(),'Other Order')]/i")
    public WebElementFacade otherAct;

    @FindBy(xpath = "//a[text()='Disconnect All']")
    public WebElementFacade DISAll;
	@Override
	public WebElementFacade getUniqueElementInPage() {
		return makechanges;
	}

	//MAHESH
	@FindBy(xpath ="//p[text()='Available']/following::td[2]")
	public WebElementFacade moveservicesspeed;
		
	@FindBy(xpath ="//div[@class='internet-availability']/strong")
	public WebElementFacade offerpagespeed;

	@FindBy(xpath ="//div[@class='available-speeds']/div/ul/li/label/span[2]")
	public WebElementFacade availableHighspeed;
	
	//Anuradha
	@FindBy(xpath ="//li/a[text()='Billing & Records Correction']")
    public WebElementFacade BnR;
    
    @FindBy(xpath = "//button[text()='Continue']")
    public WebElementFacade Cnt_BnR;
		
   

}

