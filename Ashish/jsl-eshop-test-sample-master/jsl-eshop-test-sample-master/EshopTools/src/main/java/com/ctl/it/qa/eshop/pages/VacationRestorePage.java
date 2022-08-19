package com.ctl.it.qa.eshop.pages;

import org.openqa.selenium.support.FindBy;

import com.ctl.it.qa.staf.Page;

import net.serenitybdd.core.pages.WebElementFacade;

public class VacationRestorePage extends Page {

	// *****************************************************Web
	// Elements***********************************************

	@FindBy(xpath = "//h2[contains(text(),'Vacation Service')]")
	public WebElementFacade lbl_Vacation_Service;

	@FindBy(xpath = "//div[contains(text(),'Other Order activities')]")
	public WebElementFacade ddl_Other_Order_Activities;

	@FindBy(xpath = "//a[contains(text(),'Vacation Service')]")
	public WebElementFacade link_Vacation_Service;

	@FindBy(xpath = "//table//span[contains(text(),'Internet')]//parent::div//parent::td//parent::tr//td//select")
	public WebElementFacade ddl_Vacation_Service_Selection_HSI;

	/*@FindBy(xpath = "//button[contains(text(),'Continue')]")
	public WebElementFacade btn_Vacation_Service_Continue;*/

	//ac50097
	@FindBy(xpath = "//button[contains(text(),'Continue')]")
	public WebElementFacade btn_Vacation_Service_Continue;
	
	//ac50097
	@FindBy(xpath = "//option[contains(text(),'Vacation Restore')]/..")
	public WebElementFacade selects_Vacation_Restore;

	//ac50097
	@FindBy(xpath = "//button[contains(text(),'Continue')]")
	public WebElementFacade i_click_continue_on_vacation_Product_offer_Page;
	
	//ac50097
	@FindBy(xpath = "//button[contains(text(),'OK, Got it')]")
	public WebElementFacade ok_button;

	// *****************************************************Overridden
	// Methods*****************************************
	@Override
	public WebElementFacade getUniqueElementInPage() {
		// TODO Auto-generated method stub
		return lbl_Vacation_Service;
	}
}
