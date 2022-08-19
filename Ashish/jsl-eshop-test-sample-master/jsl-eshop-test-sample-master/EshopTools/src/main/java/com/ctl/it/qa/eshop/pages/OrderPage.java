package com.ctl.it.qa.eshop.pages;

import org.openqa.selenium.support.FindBy;

import com.ctl.it.qa.staf.Page;

import net.serenitybdd.core.pages.WebElementFacade;

public class OrderPage extends Page {

	@FindBy(xpath = "//button[@class='btn btn-primary']")
	public WebElementFacade continueButton;

	@FindBy(xpath = "//h2[contains(text(),'Build your Offer')]")
	public WebElementFacade buildYourOffer;
	
	@FindBy(xpath = "//button[contains(text(),'OK, Got it')]")
    public WebElementFacade btn_Ok_Got_It;

	/*	@FindBy(xpath = "//label[text()='TECH INSTALL']/following-sibling::select")
	public WebElementFacade bestInstallationOptionDrpdwn;*/

	/*@FindBy(xpath = ".//label[text()='TECH INSTALL']/following-sibling::div/div/select")
	public WebElementFacade bestInstallationOptionDrpdwn; 

	@FindBy(xpath = "(//label[text()='Your best installation option']/following-sibling::div/div/select)[1]")
	public WebElementFacade bestInstallationOptionDrpdwn; */
	
	@FindBy(xpath = "//input[@id='bypassModemRulesid']")
	public WebElementFacade byPassModem;

	@FindBy(xpath = "(//label[text()='Your best installation option']/following-sibling::div/div/select)[2]")
	public WebElementFacade selectDeviceQuantity; 

	/*@FindBy(xpath = "//label[text()='MODEM']/following-sibling::select")
	public WebElementFacade yourModemDrpdwn;*/

	/*@FindBy(xpath = "//label[text()='MODEM']/following-sibling::div/div/select")
	public WebElementFacade yourModemDrpdwn;*/

	/*@FindBy(xpath = "//label[text()='Your modem']/following-sibling::div/div/select")
	public WebElementFacade yourModemDrpdwn;*/
	
//	@FindBy(xpath = "//label[text()='Your Modem']/following-sibling::select")
//	public WebElementFacade yourModemDrpdwn;
	
//	@FindBy(xpath = "//label[contains(text(),'CENTURYLINK @ EASE')]/following-sibling::select")
//	public WebElementFacade easeDrpdwn;
	
	@FindBy(xpath = "//label[text()='Your Modem']/following-sibling::div/div/select")
	public WebElementFacade yourModemDrpdwn;
	
	@FindBy(xpath = "//label[text()='@ Ease']/following-sibling::div/div/select")
	public WebElementFacade easeDrpdwn;

	/*@FindBy(xpath = "//label[contains(text(),'CENTURYLINK @ EASE')]/following-sibling::select")
	public WebElementFacade easeDrpdwn;

	@FindBy(xpath = "//label[text()='CENTURYLINK @ EASE']/following-sibling::select")
	public WebElementFacade easeDrpdwn;*/

	/*@FindBy(xpath = "//label[text()='CENTURYLINK @ EASE']/following-sibling::div/div/select")
	public WebElementFacade easeDrpdwn;*/

	/*@FindBy(xpath = "//label[text()='@ Ease']/following-sibling::div/div/select")
	public WebElementFacade easeDrpdwn;*/

	@FindBy(xpath = "//label[text()='Need new jacks or wiring?']/following-sibling::div/div/select")
	public WebElementFacade jacksorWiring;

	@FindBy(xpath = "//span[text()='Add Phone']")
	public WebElementFacade addPhoneDHP;

	@FindBy(xpath = "//a[text()='Digital(DHP)']")
	public WebElementFacade digitalDHP;

	@FindBy(xpath = "//h3[contains(text(),'Retrieve')]")
	public WebElementFacade retriveoption;

	@FindBy(xpath = "//input[@id='acceptCondition']") 
	public WebElementFacade custacceptcondtn;

	@FindBy(id="interstitial-image")
	public WebElementFacade scrolling;

	//Nitish Starts
	@FindBy(xpath = "//*[contains(text(),'product options')]")
	public WebElementFacade Seeprodoptions;

	@FindBy(xpath = "//input[@id='acceptCondition']")
	public WebElementFacade acceptcondition;

	@FindBy(xpath = "//a[text()='Home Phone']")
	public WebElementFacade HomePhone;

	@FindBy(xpath = "//label[contains(text(),'Voice Mail')]/following-sibling::select")
	public WebElementFacade voicemail;

	@FindBy(xpath = "//label[contains(text(),'Wire Maintenance Plan')]/following-sibling::select")
	public WebElementFacade wireplanmaintenace;

	@FindBy(xpath = "//label[contains(text(),'Port in a phone number?')]/following-sibling::select")
	public WebElementFacade portphonenumber;

	@FindBy(xpath = "(//div[contains(text(),'Price for Life Internet and Home Phone with Unlimited LD')])[3]")
	public WebElementFacade HomePhoneUnlimited;

	@FindBy(xpath = "//div[contains(text(),'Price for Life Internet and Essential Home Phone')]")
	public WebElementFacade EssentialHomePhone;

	/*@FindBy(xpath = " //label[contains(text(),'Need new jacks or wiring?')]/following-sibling::*[div/select]")
	public WebElementFacade jacksandwiring;
	 */
	//Nitish Ends

	// ac1339 code starts

	@FindBy(xpath = "//span[text()=' Internet']//span")
	public WebElementFacade internetIcon;

	@FindBy(xpath = "//div[contains(text(),'1 Pty Residence Line')]")
	public WebElementFacade onePtyresidenseLine;

	@FindBy(xpath = "(//div[contains(text(),'Price for Life Unlimited Home Phone Unlimited Calling')])[2]")
	public WebElementFacade unlimitedHomePhoneCaling;

	@FindBy(xpath = "//div[text()='Internet' or text()=' Internet']")
	public WebElementFacade cutomize_service_interneticon;

	@FindBy(css = "#interstitial-image")
	public WebElementFacade lbl_Loading;

	// ac31339 code Ends    

	@FindBy(xpath = "//*[contains(text(),'Order Disclosures')]")
	public WebElementFacade lbl_Order_Disclosures_NI_HSI;

	@FindBy(xpath = "//*[contains(text(),'OK, Got it')]")
	public WebElementFacade btn_Order_Disclosures_NI_HSI_OK_Got_It;

	@FindBy(xpath = "//*[contains(text(),'Back to Shopping')]")
	public WebElementFacade btn_Order_Disclosures_NI_HSI_Back_To_Shopping;

	@FindBy(xpath = "//span[text()='Add TV']")
	public WebElementFacade addTV;

	@FindBy(xpath = "//a[text()='DIRECTV']")
	public WebElementFacade directTV;

	@FindBy(xpath = "//li[@class='radio hoverlight']//span[contains(@class,'internet-speed')]")
	public WebElementFacade availableSpeed;

	//ac31339
	@FindBy(xpath = "//button[contains(text(),'OK, Got it')]")
	public WebElementFacade OrderdisclosuresAccept;

	@FindBy(xpath = "//*[contains(text(),'Order Disclosures')]")
	public WebElementFacade lbl_Order_Disclosures_Move_HSI;

	@FindBy(xpath = "//*[contains(text(),'OK, Got it')]")
	public WebElementFacade btn_Order_Disclosures_Move_HSI_OK_Got_It;

	//ac42889
	@FindBy(xpath="//button[@id='contBtnDiv']")
	public WebElementFacade btn_continue;

	@FindBy(xpath = "//label[text()='CENTURYLINK @ EASE']/following-sibling::select")
	public WebElementFacade MACDeaseDrpdwn; 
    
    @FindBy(xpath = "//label[text()='Your Modem']/following-sibling::select")
    public WebElementFacade MACDyourModemDrpdwn;
    
	@FindBy(xpath = "//label[text()='TECH INSTALL']/following-sibling::div/div/select")
	public WebElementFacade bestInstallationOptionDrpdwn; 
	
	@FindBy(xpath = "(//div[@class='internet-options-content']/div/select[1])[1]")
	public WebElementFacade yourModemDrpdwnForChange;

	@Override
	public WebElementFacade getUniqueElementInPage() {
		return continueButton;
	}


}
