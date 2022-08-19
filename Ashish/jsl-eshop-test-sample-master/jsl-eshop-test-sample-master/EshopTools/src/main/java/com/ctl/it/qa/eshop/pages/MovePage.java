package com.ctl.it.qa.eshop.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ctl.it.qa.staf.Page;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.WebElementFacade;

public class MovePage extends Page {

	@FindBy(xpath = "//h3[span[contains(@class,'internet-selected checkMark')]]")
	public WebElementFacade icon_internet;

	@FindBy(xpath = "//select[contains(@class,'rop-down-arrangement')]")
	public WebElementFacade dd_removal_reason;

	@FindBy(xpath = "//div[a[text()='No Phone']]")
	public WebElementFacade menu_nophone;

	@FindBy(xpath = "//div[a[text()='Digital(DHP)']]")
	public WebElementFacade menu_dhp;

	@FindBy(xpath = "//div[a[text()='Home Phone']]")
	public WebElementFacade menu_homephone;

	// select[contains(@class,'rop-down-arrangement')]//option[text()='MOVED']

	@FindBy(xpath = "//span[contains(@class,'add-phone')]//span")
	public WebElementFacade icon_addphone;

	// Popup continue button
	@FindBy(xpath = "//div[@class='modalcontent']//button[contains(text(),'Continue')]")
	public WebElementFacade btn_continue_removal_product;

	@FindBy(xpath = "//button[text()='Add Call Referral']")
	public WebElementFacade btn_add_call_referal;

	@FindBy(xpath = "//span[text()='No referral needed']/preceding::input")
	public WebElementFacade radio_call_referal;

	// //button[text()='Save Referral']
	@FindBy(xpath = "//button[text()='Save Referral']")
	public WebElementFacade btn_save_referal;
	
	@FindBy(xpath = "//span[contains(.,'Telephone Number:')]/../i")
	public WebElementFacade ExpanTN;
	
	@FindBy(xpath = "(//button[contains(@class,'tn-btn')])[1]")
	public WebElementFacade btn_MoreTN;
	
	@FindBy(xpath = "//button[contains(.,'More options')]")
	public WebElementFacade btn_MoreOption;
	
	@FindBy(xpath = "//input[contains(@name,'Manual Request')]")
	public WebElementFacade radio_ManualRequest;
	
	@FindBy(xpath = "//select[@formcontrolname='npa']")
	public WebElementFacade dd_NPA;
	
	@FindBy(xpath = "//select[@formcontrolname='nxx']")
	public WebElementFacade dd_NXX;
	
	@FindBy(xpath = "//input[@formcontrolname='line']")
	public WebElementFacade Tbx_line;
	
	@FindBy(xpath = "//button[contains(@class,'btn btn-default btn-TNs')]")
	public WebElementFacade btn_CheckTN;
	
	@FindBy(xpath = "//a[contains(.,'Chat with TN assignment')]")
	public WebElementFacade lnk_chat;
	
	@FindBy(xpath = "//a[@href='#'][contains(.,'Chat Now')]")
	public WebElementFacade lnk_chat_NOW;
	
	@FindBy(xpath = "//div[contains(@class,'lp_header_text lp_text')]")
	public WebElementFacade Contact_Us;
	
	@FindBy(xpath = "//button[contains(.,'Close')]")
	public WebElementFacade close_chat;
	
	@FindBy(xpath = "//div[contains(@class,'statuspc')]/div")
	public WebElementFacade TN_MSG;
	
	@FindBy(xpath = "//button[@class='btn btn-primary'][contains(.,'Select TN')]")
	public WebElementFacade btn_SelectTN;
	
	@FindBy(xpath = "//span[contains(.,'assigned')]/..")
	public WebElementFacade lbl_TN;

	@FindBy(xpath = "//div[contains(@class,'strong')]")
	public WebElementFacade lbl_CNUM_Response;
	
	@FindBy(xpath = "//div[contains(@class,'mL35 m-T10')]")
	public WebElementFacade lbl_CNUM_ageTN_Response;
	
	@FindBy(xpath = "//div[p[text()='Assess charge']]/div/div/select")
	public WebElementFacade option_NoWaiveCharge;
	
	@FindBy(xpath = "//input[contains(@name,'TNoption')]")
	public WebElementFacade TNqueryOption;
	
		
	@Override
	public WebElementFacade getUniqueElementInPage() {
		return null;
	}

}
