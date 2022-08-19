package com.ctl.it.qa.eshop.pages;

import org.openqa.selenium.support.FindBy;

import com.ctl.it.qa.staf.Page;

import net.serenitybdd.core.pages.WebElementFacade;

public class VacationSuspendPage extends Page{
	//	*****************************************************Web Elements***********************************************

	@FindBy(xpath = "//h2[contains(text(),'Vacation Service')]")
	public WebElementFacade lbl_Vacation_Service;

	@FindBy(xpath = "//div[contains(text(),'Other Order activities')]")
	public WebElementFacade ddl_Other_Order_Activities;

	@FindBy(xpath = "//a[contains(text(),'Vacation Service')]")
	public WebElementFacade link_Vacation_Service;

	@FindBy(xpath = "//table//span[contains(text(),'Internet')]//parent::div//parent::td//parent::tr//td//select")
	public WebElementFacade ddl_Vacation_Service_Selection_HSI;

	@FindBy(xpath = "//*[contains(text(),'Order Disclosures')]")
	public WebElementFacade lbl_Order_Disclosures_Vacation_Suspend;

	@FindBy(xpath = "//*[contains(text(),'OK, Got it')]")
	public WebElementFacade btn_Order_Disclosures_Vacation_Suspend_OK_Got_It;

	@FindBy(xpath = "//*[contains(text(),'Back to Shopping')]")
	public WebElementFacade btn_Order_Disclosures_Vacation_Suspend_Back_To_Shopping;

	//	*****************************************************Overridden Methods*****************************************
	@Override
	public WebElementFacade getUniqueElementInPage() {
		return lbl_Vacation_Service;
	}

	@FindBy(xpath = "//button[contains(text(),'Continue')]")
	public WebElementFacade btn_Vacation_Service_Continue;

	@FindBy(xpath = "//table//span[contains(text(),'Home Phone')]//parent::div//parent::td//parent::tr//td//select")
	public WebElementFacade ddl_Vacation_Service_Selection_POTS;

	@FindBy(xpath = "//*[contains(text(),'Vacation Options')]")
	public WebElementFacade lbl_Vacation_Options;

	@FindBy(xpath = "//*[contains(text(),'Referral messages')]")
	public WebElementFacade lbl_Referal_Messages;

	@FindBy(xpath = "//table//tr//select")
	public WebElementFacade ddl_Vacation_Options_POTS_Callers_Will_Hear;

	@FindBy(id = "btn-pricing-summary")
	public WebElementFacade btn_Vacation_Service_Shopping_Cart;

	@FindBy(xpath = "//*[contains(text(),'(add to all)')]")
	public WebElementFacade btn_Vacation_Service_Add_To_All;

	@FindBy(xpath = "//*[contains(text(),'(restore all)')]")
	public WebElementFacade btn_Vacation_Service_Restore_All;

	@FindBy(xpath = "//*[contains(text(),'provided')]")
	public WebElementFacade lbl_Vacation_Service_Unavailable_Header;

	@FindBy(xpath = "//*[contains(text(),'this location')]")
	public WebElementFacade lbl_Vacation_Service_Unavailable_Due_To_Location;

	@FindBy(xpath = "")
	public WebElementFacade lbl_Vacation_Service_Unavailable_Due_To_Account;

	@FindBy (xpath = "//button[text ()= 'OK, Got it']")
	public WebElementFacade ok_button;

	@FindBy (xpath = "//button[text()='Continue']")
	public WebElementFacade btn_vacation_productservice_continue;

	@FindBy (xpath = "//p[contains(text(), 'Vacation service must be removed')]")
	public WebElementFacade btn_close_move_vactnsuspnd;


	@FindBy (xpath = "//*[contains(text(), 'No offer changes allowed if any products on')]")
	public WebElementFacade err_msg_vacsus_on_chg;

	//ac42889
	@FindBy(xpath = "//div[@class='modalcontent']//h4")
	public WebElementFacade msg_warningDailogbox;

	@FindBy(xpath = "//input[@placeholder='Street Address']")
	public WebElementFacade txt_street;

	@FindBy(xpath = "(//select[@name='address type'])[2]")
	public WebElementFacade ddl_state;

	@FindBy(xpath = "//input[@placeholder='City']")
	public WebElementFacade txt_city;

	@FindBy(xpath = "//input[@placeholder='Zip Code']")
	public WebElementFacade txt_zipCode;

	@FindBy(xpath = "//a[contains(text(),'Validate')]")
	public WebElementFacade btn_validate;

	//ac42889

	//ac41685
	@FindBy(xpath = "//input[@id='currentBillingAddress']")
	public WebElementFacade Billing_address_rButton;

	@FindBy(xpath = "//input[@title='Email Address']")
	public WebElementFacade email_address;

	@FindBy(xpath = "//div[@class='card-content account-details']//div[@class='detail-section']//p[1]")
	public WebElementFacade verifyMailId;
	
	
	//ac50097
	@FindBy(xpath = "//option[contains(text(),'Vacation Suspend')]/..")
	public WebElementFacade selects_Vacation_Suspend;


}

