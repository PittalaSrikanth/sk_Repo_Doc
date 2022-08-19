package com.ctl.it.qa.eshop.pages;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ctl.it.qa.eshop.common.utils.GlobalVariables;
import com.ctl.it.qa.staf.Page;

import net.serenitybdd.core.pages.WebElementFacade;

import java.util.List;

@SuppressWarnings("unused")
public class CustomerDetailsPage extends Page {

	@FindBy(xpath = "//input[@id='firstName']")
	public WebElementFacade firstNam;

	@FindBy(xpath = "//input[@id='lastName']")
	public WebElementFacade lastNam;

	@FindBy(id = "phoneNumber")
	public WebElementFacade phoneNum;

	@FindBy(xpath = "//input[@id='address']")
	public WebElementFacade showAddress;

	@FindBy(xpath = "//button[@type='submit']")
	public WebElementFacade LetsGoButton;

	@FindBy(xpath = "//div[text()='No Results Found']")
	public WebElementFacade noMatchFoudText;

	@FindBy(xpath = ".//*[@id='addressLine']")
	public WebElementFacade street;

	@FindBy(xpath = ".//*[@id='floor']")
	public WebElementFacade unit;

	@FindBy(xpath = ".//*[@id='state']")
	public WebElementFacade state;

	@FindBy(xpath = ".//*[@id='city']")
	public WebElementFacade city;

	@FindBy(xpath = ".//*[@id='zipCode']")
	public WebElementFacade zipcode;

	@FindBy(xpath = "html/body/app/main/ctl-home/address/section/div/div[1]/div/form/div[2]/div/div/div[3]/div[1]/a")
	public WebElementFacade showalladdress;

	@FindBy(xpath = "html/body/app/main/multiplematchaddress/section/div/div/div/form/div[2]/div/div[3]/div[2]/div/ul/li[1]/label/input")
	public WebElementFacade selectradiobtn;

	@FindBy(xpath = "//button[@class='btn btn-primary activeBtn']")
	public WebElementFacade continuebtn;
	//Nitish

	@FindBy(xpath = "//a[contains(text(),'Account or Order already exists')]")
	public WebElementFacade orderexists;

	@FindBy(xpath = "//a[contains(text(),'Start New Customer Order')]")
	public WebElementFacade newcustomer;	

	@FindBy(xpath = "(//input[@name='number'])[1]")
	public WebElementFacade accnumrbn;

	@FindBy(xpath = "//input[@id='accountNumber']")
	public WebElementFacade existsaaccnumr;

	//Prem SFC Integeration Starts 

	@FindBy(xpath = "//input[@value='New Account']")
	public WebElementFacade btn_createnew;

	@FindBy(xpath = "//img[@title='Account']")
	public WebElementFacade link_account;

	@FindBy(xpath = "//input[contains(@id,'AccFirstName')]")
	public  WebElementFacade tbx_account_first_name;

	@FindBy(xpath = "//input[contains(@id,'AccLastName')]")
	public  WebElementFacade tbx_account_last_name;

	@FindBy(xpath = "//input[contains(@id,'AccPhone')]")
	public  WebElementFacade tbx_phone_number;

	@FindBy(xpath = "//input[contains(@autocomplete,'street-address')]")
	public  WebElementFacade tbx_address_field;

	@FindBy(xpath = "//input[@value='Validate Address']")
	public  WebElementFacade btn_validate_address;

	@FindBy(css = "input[value = 'Save']")
	public  WebElementFacade btn_save;

	@FindBy(xpath = "//span[@title='Close']")
	public WebElementFacade btn_close;

	@FindBy(xpath = "(//input[@value='Order (ESHOP)'])[1]")
	public WebElementFacade btn_order_eshop;

	@FindBy(xpath = "//div[text()='Drag Footer Components Here']")
	public WebElementFacade lbl_drag_footer_component_here;

	@FindBy(xpath = "//span[text()='Close all primary tabs']")
	public WebElementFacade lnk_close_all_primary_tabs;

	@FindBy(xpath = "//span[text()='Pop out primary tabs']")
	public WebElementFacade lnk_pop_out_primary_tabs;

	@FindBy(xpath = "(//div[@class='x-tab-tabmenu-right'])[1]")
	public WebElementFacade btn_right_tab_menu;

	@FindBy(xpath = "//span[contains(text(),'Accounts')]")
	public WebElementFacade btn_account;

	//Prem SFC Integeration Ends 

	@FindBy(xpath = "//div[contains(text(),'Address & TN Live Help')]")
	public WebElementFacade address_avail_flag;

	
	///////////////  Elements for Show address 03/01 ////////////

	@FindBy(xpath = "(//input[contains(@id,'AccSerStreet')])[1]")
	public WebElementFacade input_serviceStreet;

	@FindBy(xpath = "(//input[contains(@id,'AccSerCity')])[1]")
	public WebElementFacade input_serviceCity;

	@FindBy(xpath = "(//input[contains(@id,'AccSerState')])[1]")
	public WebElementFacade input_serviceState;

	@FindBy(xpath = "(//input[contains(@id,'AccSerZipCode')])[1]")
	public WebElementFacade input_servicezipCode;

	@FindBy(xpath = "(//input[contains(@id,'AccSerStreet2')])[1]")
	public WebElementFacade input_serviceStreet2;

	@FindBy(xpath = "//input[@value='Show Address Fields']")
	public WebElementFacade show_address;

	@FindBy(xpath = "//input[@value='Hide Address Fields']")
	public WebElementFacade hide_address;

	//Anuradha
	@FindBy( xpath = "//input[contains(@id ,'AccEmail')]")
	public WebElementFacade tbx_Email;

	@FindBy(xpath = "//div[@class='requiredInput']/select[contains(@id,'FullAddr:SrPR:primaryResidence')]")
	public WebElementFacade ownorrent;

	@FindBy(xpath = "//select[@id='pageId:formId:pblock:FullAddr:SrPR:primaryResidence']")
	public WebElementFacade select_own_house;		


	//Abhinav

	@FindBy(css = "#orderNumber")
	public WebElementFacade txt_Existing_Information_Order_Number;

	@FindBy(xpath = "//button[contains(text(),'Let')]")
	public WebElementFacade btn_Lets_Go;

	@FindBy(css = "#firstName")
	public WebElementFacade txt_First_Name_ESHOP;

	@FindBy(css = "#lastName")
	public WebElementFacade txt_Last_Name_ESHOP;

	@FindBy(css = "#phoneNumber")
	public WebElementFacade txt_Contact_Number_ESHOP;

	@FindBy(xpath = "(//input[@id='pageId:formId:pblock:mainRecord:AccEml:AccEmail'])[1]")
	public WebElementFacade txt_Email;

	///////////////  Elements for Show address 03/01 ////////////


	@Override
	public WebElementFacade getUniqueElementInPage() {
		return btn_account;
	}

}
