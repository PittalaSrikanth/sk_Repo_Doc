package com.ctl.it.qa.eshop.pages;

import org.openqa.selenium.support.FindBy;

import com.ctl.it.qa.staf.Page;

import net.serenitybdd.core.pages.WebElementFacade;

public class ChangePage extends Page {

	//offer-change Page POM Starts...
	@FindBy(xpath = "//button[contains(text(),'Make Changes')]")
	public WebElementFacade makechanges;
	
	@FindBy(xpath = "//span[text()='Add Phone']")
    public WebElementFacade addPhoneDHP;
	
	@FindBy(xpath = "//a[text()='Home Phone']")
    public WebElementFacade HomePhone;
	
    @FindBy(xpath = "(//button[contains(text(),'See product options')])[1]")
	public WebElementFacade Seeprodoptions;
	    
	@FindBy(xpath = "(//input[@id='acceptCondition'])[1]")
	public WebElementFacade acceptcondition;
    
 	@FindBy(xpath = "//div[contains(text(),'1 Pty Residence Line')]")
 	public WebElementFacade onePtyresidenseLine;

 	@FindBy(xpath = "(//div[contains(text(),'Price for Life Unlimited Home Phone Unlimited Calling')])[2]")
 	public WebElementFacade unlimitedHomePhoneCaling;
 	//offer-change Page POM Ends...

 	
 		@FindBy(xpath = "//div[a[text()='No Phone']]")
 		public WebElementFacade menu_nophone;

 	   @FindBy(xpath = "//div[a[text()='Digital(DHP)']]")
 	   public WebElementFacade menu_dhp;

 	   @FindBy(xpath = "//div[a[text()='Home Phone']]")
 	   public WebElementFacade menu_homephone; 
 	  
 		@FindBy(xpath = "//h3[span[contains(@class,'internet-selected checkMark')]]")
 		public WebElementFacade icon_internet; 
 		 
 		@FindBy(xpath = "//span[contains(@class,'add-phone')]//span")
 		public WebElementFacade icon_addphone; 
 		
 		@FindBy(xpath = "//div[@class='modalcontent']//button[contains(text(),'Continue')]")
 		public WebElementFacade btn_continue_removal_product; 
 		
 		@FindBy(xpath = "//select[contains(@class,'rop-down-arrangement')]")
 		public WebElementFacade dd_removal_reason; 
 		
 		
 		@FindBy(xpath = "//button[contains(text(),'Add Call Referral')]")
 		public WebElementFacade add_referal_pots;
 		

 		@FindBy(xpath = "//span[contains(text(),'No referral needed')]")
 		public WebElementFacade no_referral_needed;
 		
 		@FindBy(xpath = "(//button[contains(text(),'Continue')])[2]")
 		public WebElementFacade removed_back_deposits_continue;

 		@FindBy(xpath = "//button[contains(text(),'Save Referral')]")
 		public WebElementFacade save_referral;
 		
 		@FindBy(xpath = "//button[contains(text(),'Continue')]")
 		public WebElementFacade continue_again;
 		
 		
 		@FindBy(xpath = "(//button[@class='btn btn-primary activeBtn'])[1]")
 		public WebElementFacade change_account_continue;
 		
 		//ac41685
 		@FindBy(xpath = "//img[@alt='schedule image']")
 		public WebElementFacade Calendar_img;
 		
 		@FindBy(xpath = "//i[@class='glyphicon glyphicon-chevron-right']")
 		public WebElementFacade forward_button;
 		
 		// need to verify - Prem
 		@FindBy(xpath = "//button[@type='button']/span[text()='12']")
 		public WebElementFacade select_date;
 		
 		@FindBy(xpath = "//button[text()='Assign Date']")
 		public WebElementFacade assigne_date;
 		
 		//ab18364
 				@FindBy(xpath = "//span[text()='Telephone Number:']")
 				public WebElementFacade btn_TelephoneNumber;
 				
 				@FindBy(xpath = "//button[contains(text(),'More options')]")
 				public WebElementFacade btn_Moreoptions;
 				
 				@FindBy(xpath = "//button[contains(text(),'More TN')]")
 				public WebElementFacade btn_MoreTN;
 				
 				@FindBy(xpath = "//select[@formcontrolname='SelectedPhoneNumber']")
 				public WebElementFacade select_Phone_Number;
 		
	@Override
	public WebElementFacade getUniqueElementInPage() {
		return null;
	}

}
