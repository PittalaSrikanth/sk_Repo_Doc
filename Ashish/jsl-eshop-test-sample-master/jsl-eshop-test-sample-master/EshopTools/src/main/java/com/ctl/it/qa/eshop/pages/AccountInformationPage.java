package com.ctl.it.qa.eshop.pages;

import org.openqa.selenium.support.FindBy;

import com.ctl.it.qa.staf.Page;

import net.serenitybdd.core.pages.WebElementFacade;

public class AccountInformationPage extends Page {

	@FindBy(xpath = "//input[@id='decline-email' and @type='checkbox']/following-sibling::label")
	public WebElementFacade emailDeclines;

	@FindBy(xpath = "//input[@title='Yes' and @name='usercheck']")
	public WebElementFacade creditCheckYes;

	@FindBy(xpath = "//input[@title='Month']")
	public WebElementFacade monthDB;

	@FindBy(xpath = "//input[@title='Day']")
	public WebElementFacade dayDB;

	@FindBy(xpath = "//input[@title='Year']")
	public WebElementFacade yearDB;

	@FindBy(xpath = "//input[@title='SSN']")
	public WebElementFacade ssn;

	@FindBy(xpath = "//button[@class='btn btn-primary']")
	public WebElementFacade clickContinue;

	@FindBy(xpath="//button[contains(text(),'Pay Now')]")
	public WebElementFacade payNow;

	@FindBy(xpath="//input[@title='No']")
	public WebElementFacade creditCheckNo;

	@FindBy(xpath="//div[text()='Applicant less than 18 yrs old']")
	public WebElementFacade lessAgePopup;
	// Premkumar
	@FindBy(xpath = "//button[contains(text(),'Continue')]")
	public WebElementFacade clickContinueAccInfo; 

	// Nitish
	@FindBy(xpath="//input[@name='emailAddress']")
	public WebElementFacade emailAddress;

	@FindBy(xpath="//input[@name='smsNumber']")
	public WebElementFacade smsno;

	@FindBy(xpath="//button[contains(text(),'is correct')]")
	public WebElementFacade validate_customer_info;

	@FindBy(xpath="//strong[contains(text(),'No deposit required')]")
	public WebElementFacade info_nodeposit;

	@FindBy(xpath="//a[contains(text(),'Find payment location')]")
	public WebElementFacade payment_location;

	@FindBy(xpath="//*[contains(text(),'Update application')]")
	public WebElementFacade link_Update_Application;

	@FindBy(xpath="(//*[contains(text(),'Update')])[3]")
	public WebElementFacade link_Update_Application_Disabled;

	/*
	 * Abhinav
	 */
	@FindBy(xpath="//h2[contains(text(),'Validate Customer Credit Information')]")
	public WebElementFacade lbl_Validate_Credit_Information_Popup;

	@FindBy(xpath="//button[contains(text(),'Close X')]")
	public WebElementFacade btn_Close_Popup;

	@FindBy(xpath="//strong[contains(text(),'Credit Information')]")
	public WebElementFacade lbl_Credit_Information;

	@FindBy(css=".modalcontent span:nth-of-type(1)")
	public WebElementFacade lbl_Credit_Information_Name;

	@FindBy(css=".modalcontent span:nth-of-type(2)")
	public WebElementFacade lbl_Credit_Information_DOB;

	@FindBy(css=".modalcontent span:nth-of-type(3)")
	public WebElementFacade lbl_Credit_Information_SSN;

	@FindBy(xpath="//button[text()='No, needs correction']")
	public WebElementFacade btn_Credit_Information_No;

	@FindBy(xpath="//button[contains(text(),'Yes,')]")
	public WebElementFacade btn_Credit_Information_Yes;

	@FindBy(xpath="//div[@class='hdr-back back-active']")
	public WebElementFacade btn_Back;

	@FindBy(xpath="(//button[text()='Place on Hold'])[1]")
	public WebElementFacade btn_Place_On_Hold;

	@FindBy(xpath="(//button[contains(text(),'Place')])[2]")
	public WebElementFacade btn_Place_On_Hold_Confirm_Dialog_Box;

	@FindBy(xpath="//button[text()='Back to Summary']")
	public WebElementFacade btn_Back_to_Summary_Confirm_Dialog_Box;

	@FindBy(xpath="//textarea[@title='Remarks']")
	public WebElementFacade txt_Additional_Notes;

	@FindBy(xpath="//div[@class = 'question-block']//select")
	public WebElementFacade ddl_Place_On_Hold;

	@FindBy(xpath="//strong[text()='Transaction Number']//parent::p//parent::div")
	public WebElementFacade lbl_ORN_On_Hold_Order;

	@FindBy(xpath="//button[text()='Start New Order']")
	public WebElementFacade btn_Start_New_Order;

	@FindBy(xpath="//span[@id='orderRefNumber']")
	public WebElementFacade lbl_ORN_On_Hold_Order_1;

	@FindBy(id="paperless-billing")
	public WebElementFacade cbx_Paperless_Billing;

	@FindBy(id="mailmybill")
	public WebElementFacade cbx_Mail_My_Bill;

	@FindBy(id="smailmybill")
	public WebElementFacade ddl_Mail_My_Bill_Special_Format;

	@FindBy(id="finalEmail")
	public WebElementFacade txt_Vacation_Service_Email_Address;

	@FindBy(xpath="//*[contains(text(),'We will notify you when your next bill is available online')]")
	public WebElementFacade lbl_Vacation_Service_Paperless_Billing_Label;

	@FindBy(xpath="//*[contains(text(),'Update or Review Billing address')]")
	public WebElementFacade lbl_Vacation_Service_Update_Or_Review_Billing_Address_Label;

	@FindBy(id="differentAddress")
	public WebElementFacade radio_Vacation_Service_New_Address;

	@FindBy(id="currentBillingAddress")
	public WebElementFacade radio_Vacation_Service_Current_Billing_Address;

	@FindBy(id="yes-paperless")
	public WebElementFacade radio_Yes_Setup_Paperless_Billing;

	@FindBy(id="no-paperless")
	public WebElementFacade radio_No_Mail_My_Bill;

	@FindBy(xpath="//input[@name='firstName']")
	public WebElementFacade txt_FirstName;

	@FindBy(xpath="//input[@name='lastName']")
	public WebElementFacade txt_LastName;

	@FindBy(xpath="//*[@class='ng-untouched ng-pristine ng-valid']")
	public WebElementFacade cbx_By_Pass_Deposit_Requirement;

	//ac31339 code starts

	@FindBy(xpath="//input[@name='password']")
	public WebElementFacade input_password;		

	@FindBy(xpath="//input[contains(@class,'disablePassword')]")
	public WebElementFacade input_disabled_password;	

	@FindBy(xpath="//input[@formcontrolname='dtvAccNo']")
	public WebElementFacade input_dtv_accountid;		

	@FindBy(xpath="//div[contains(text(),'Enter a valid password')]")
	public WebElementFacade txt_invalid_pwd_message;		

	@FindBy(xpath="//div[@class='hdr-back back-active']")
	public WebElementFacade btn_move_back;	

	@FindBy(xpath = "(//button[@class='btn btn-primary'])[1]")
	public WebElementFacade clickContinue_acccInfo2;				

	//ac31339 code ends		

	@FindBy(xpath = "//button[@id ='contBtnDiv']")
	public WebElementFacade contmveaccnt;
		
	//AC42889 starts
	
	@FindBy(xpath = "//a[contains(text(),'Change Billing Address')]")
	public WebElementFacade changeBillingAddress;
	
	@FindBy(xpath = "//input[@id='differentAddress']")
	public WebElementFacade differentBillingAddress;
	
	@FindBy(xpath = "//input[@id='currentBillingAddress']")
	public WebElementFacade currentBillingAddress;
	
	@FindBy(xpath = "//input[@id='newServiceAddress']")
	public WebElementFacade newSeviceAddress;
		
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
	
	@FindBy(xpath = "//button[contains(text(),'Save Billing Address')]")
	public WebElementFacade btn_saveBillingAddress;
	
	@FindBy(xpath = "//*[contains(text(),'Bypass')]")
	public WebElementFacade rbtn_BypasValidation;
	
	@FindBy(xpath = "//strong[contains(text(),'Postal')]")
	public WebElementFacade postalAddressValidation;
	
	//AC42889 ends

	//AC43057 starts
	
	@FindBy(xpath = "//a[contains(text(),'add or change')]")
	public WebElementFacade click_add;
	
	@FindBy(xpath = "//input[@id='firstNameFirst']")
	public WebElementFacade box_fn;
	
	@FindBy(xpath = "//input[@id='lastNameFirst']")
	public WebElementFacade box_Ln;
	
	@FindBy(xpath = "//input[@id='contactFirst']")
	public WebElementFacade box_cntct;
	
	@FindBy(xpath = "//button[text()='Save updates']")
	public WebElementFacade btn_save;
	
	@FindBy(xpath="//button[@id='contBtnDiv']")
	public WebElementFacade ContinueAccountInfomation;	
	
	@FindBy(xpath="//input[@id='finalEmail']")
	public WebElementFacade email;
	
	@FindBy(xpath="//a[contains(text(),'add or change')]")
	public WebElementFacade addOrChange;
	
	@FindBy(xpath="//input[@id='firstNameFirst']")
	public WebElementFacade firstAuthFirstName;
	
	@FindBy(xpath="//input[@id='lastNameFirst']")
	public WebElementFacade firstAuthLastName;
	
	@FindBy(xpath="//input[@id='contactFirst']")
	public WebElementFacade firstAuthPhone;
	
	@FindBy(xpath="//input[@id='firstNameSecond']")
	public WebElementFacade secondAuthFirstName;
	
	@FindBy(xpath="//input[@id='lastNameSecond']")
	public WebElementFacade secondAuthLastName;
	
	@FindBy(xpath="//input[@id='contactSecond']")
	public WebElementFacade secondAuthPhone;
	
	@FindBy(xpath="//button[contains(text(),'Save updates')]")
	public WebElementFacade saveUpdates;
	
	//AC43057 ends
		


	/**
	 * Overridden method to get the unique element from a web page
	 */

	@Override
	public WebElementFacade getUniqueElementInPage() {
		return ssn;
	}	

}
