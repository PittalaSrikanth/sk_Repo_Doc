package com.ctl.it.qa.eshop.pages;

import org.openqa.selenium.support.FindBy;

import com.ctl.it.qa.staf.Page;

import net.serenitybdd.core.pages.WebElementFacade;

public class CustomizeServicePage extends Page {

	@FindBy(xpath = "//button[@class='btn btn-continue']")
	public WebElementFacade continueAgainButton;

	@FindBy(xpath = "//span[contains(text(),'Customize Services')]")
	public WebElementFacade customizeServicePage;
	
	//Nitish Pots
		@FindBy(xpath = "//a[@class='nav-link']")
		public WebElementFacade Homephoneeuipaddon;
		
		@FindBy(xpath = "//tab[@class='tab-pane active']//input[@id='0_0_items']")
		public WebElementFacade screenprotect;
		
		@FindBy(xpath = "//input[@id='0_0_items']")
		public WebElementFacade euip_1;
		
		@FindBy(xpath = "//input[@id='0_1_items']")
		public WebElementFacade euip_2;
		
		@FindBy(xpath = "//input[@id='0_2_items']")
		public WebElementFacade euip_3;
		
		@FindBy(xpath = "//div[@class='accordion-toggle']//span[contains(text(),'Listing')]")
		public WebElementFacade listingToggle;
		
		@FindBy(xpath = "//select[@formcontrolname='selectedOption']")
		public WebElementFacade listingOptionsdrpDown;
		
		@FindBy(xpath = "//span[text()='Telephone Number:']")
		public WebElementFacade btn_TelephoneNumber;
		
		@FindBy(xpath = "//button[contains(text(),'More TN')]")
		public WebElementFacade btn_MoreTN;
		
		@FindBy(xpath = "//button[text()='Select TN']")
		public WebElementFacade btn_SelectTN;
		
		@FindBy(xpath = "//select[@formcontrolname='SelectedPhoneNumber']")
		public WebElementFacade select_Phone_Number;
		
				
		
	@Override
	public WebElementFacade getUniqueElementInPage() {
		return customizeServicePage;
	}
}
