package com.ctl.it.qa.eshop.pages;

import org.openqa.selenium.support.FindBy;

import com.ctl.it.qa.staf.Page;

import net.serenitybdd.core.pages.WebElementFacade;

public class OrderSummaryPage extends Page{

	@FindBy(id = "selectYes")
	public WebElementFacade selectYes;

	@FindBy(xpath = "//button[contains(text(),'Submit Order')]")
	public WebElementFacade submitOrder;

	/*@FindBy(xpath = "//h2[contains(text(),'Order Submitted')]")
	public WebElementFacade orderSubmittedverification;*/

	@FindBy(xpath = "(//h2)[1]")
	public WebElementFacade orderSubmittedverification;

	@FindBy(xpath = "//textarea[@title='Remarks']")
	public WebElementFacade remarks;

	@FindBy(xpath = "//span[@class='notes-received']")
	public WebElementFacade notes;

	@FindBy(xpath="//p[strong[text()='Order Number']]")
	public WebElementFacade orderNumberText;

	@FindBy(xpath="//p[strong[text()='Account Number']]")
	public WebElementFacade accountNumberText;

	@FindBy(xpath="//p[contains(text(),'Activation date & appointment ')]")
	public WebElementFacade activationDate;

	@FindBy(xpath="//p[contains(text(),'Service Address ')]")
	public WebElementFacade serviceAddress;

	//Nitish
	@FindBy(xpath="//button[contains(text(),'Start New Order')]")
	public WebElementFacade neworder;

	@FindBy(xpath = "(//input[@name='number'])[1]")
	public WebElementFacade accnumrbn;

	@FindBy(xpath = "//input[@id='accountNumber']")
	public WebElementFacade existsaaccnumr;

	@FindBy(xpath = "//strong[contains(text(),'Additional Order Remarks')]/following::textarea")
	public WebElementFacade Additional_Order_Remarks;




	/// ac31339

	@FindBy(xpath = "//button[contains(text(),'View RCCs >')]")
	public WebElementFacade btn_View_RCCs;

	@FindBy(xpath = "//button[contains(text(),'Acknowledge RCCs')]")
	public WebElementFacade btn_Acknowledge;

	/*@FindBy(xpath = "//button[contains(text(),'Acknowledge')]")
	public WebElementFacade btn_Acknowledge; */

	@FindBy(xpath = "//h2[contains(text(),'Order Summary')]")
	public WebElementFacade lbl_Order_Summary; 

	@FindBy(xpath = "//button[text()='Acknowledge RCCs']")
	public WebElementFacade btn_Acknowledge_RCCs; 

	@FindBy(xpath = "//span[text()='Still must Acknowledge RCCs']")
	public WebElementFacade lbl_Still_Acknowledge_RCCs; 

	@FindBy(xpath = "//span[text()='Close']")
	public WebElementFacade btn_RCCs_Close; 

	@FindBy(xpath = "//span[text()='Acknowledged']")
	public WebElementFacade lbl_Still_Acknowledged_RCCs;

	@FindBy(xpath = "//td[text()='Confirmation Letter']")
	public WebElementFacade lbl_Review_RCCs;

	//Shilpa - F33405
	@FindBy(xpath="//p[contains(text(),'Order Level CBR')]")
	public WebElementFacade orderLevelCRB;

	// Anuradha
	@FindBy(xpath = "//div[@class = 'hdr-back back-active']")
	public WebElementFacade back_btn;

	@FindBy (xpath = "//a[contains(text() , 'Update application')]")
	public WebElementFacade updateaccnt;

	@FindBy (xpath = "//input[@id = 'mailmybill']")
	public WebElementFacade mailmybill;

	@FindBy (xpath = "//a[text()='Change Billing Address']")
	public WebElementFacade updateBllngaddrs;

	@FindBy (xpath = "//input[@type = 'text' and @placeholder = 'Street Address']")
	public WebElementFacade streetadrsbox;


	@FindBy (xpath = "//input[@type = 'text' and @placeholder ='City']")
	public WebElementFacade txtbx_city;
	@FindBy (xpath = "//div[@class ='col-sm-12 inner-pad-bt']/div/select")
	public WebElementFacade selectstate;
	@FindBy (xpath = "//input[@id ='zipCode']")
	public WebElementFacade txtbx_zipcd;
	@FindBy (xpath = "//a[text() = 'Validate']")
	public WebElementFacade validatebtn;
	@FindBy (xpath = "//button[text() = 'Save Billing Address']")
	public WebElementFacade addrs_billing;

	@FindBy (xpath = "//input[@name = 'firstName']")
	public WebElementFacade txtbx_FN;

	@FindBy (xpath = "//input[@name = 'lastName']")
	public WebElementFacade txtbx_LN;

	@FindBy (xpath = "//input[@name = 'smsNumber']")
	public WebElementFacade txtbx_SMS;



	@FindBy (xpath = "//label[text()='No Direct Mail' ]")
	public WebElementFacade nodirectmail;
	@FindBy (xpath = "//label[text() ='No Email']")
	public WebElementFacade noemail;
	@FindBy (xpath = "//label[@for = 'no-telemarketing']")
	public WebElementFacade notelemrktng;
	
	@FindBy(xpath = "//label[contains(text(),'Authorized Parties')]/following-sibling::p")
	public WebElementFacade authorizedParty;




	@FindBy (xpath = "//label[contains(text(),'Authorized Parties')]//parent::div/child::p[contains(text(),'Peter Test')]")
	public WebElementFacade authName;

	@Override
	public WebElementFacade getUniqueElementInPage() {
		return btn_Acknowledge_RCCs;
	}


}
