package com.ctl.it.qa.eshop.steps;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ctl.it.qa.eshop.common.utils.GlobalVariables;
import com.ctl.it.qa.eshop.pages.CustomerDetailsPage;
import com.ctl.it.qa.staf.Steps;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

@SuppressWarnings("unused")
public class CustomerDetailsSteps extends Steps {

	private final Logger slf4jLogger = LoggerFactory.getLogger(CustomerDetailsSteps.class);

	CustomerDetailsPage customerDetailsPage;


	@Step
	public void searchAccount(String env, String first, String last, String phone, String address) {
		customerDetailsPage.shouldExist(customerDetailsPage,60);
		customerDetailsPage.firstNam.type(first);
		customerDetailsPage.lastNam.sendKeys(last);
		customerDetailsPage.phoneNum.sendKeys(phone);
		customerDetailsPage.showAddress.sendKeys(address);
		slf4jLogger.info("Entered the following Customer details for Env=" + env + ": firstName=" + first + ", lastName=" + last + " ,PhoneNumber=" + phone + " and address=" + address);

	}

	@Step
	public void letsGoButton() {
		waitABit(2000);
		customerDetailsPage.LetsGoButton.click();
		slf4jLogger.info("clicked on to 'Let's Go' button");

	}

	@Step
	public void noMatchFoundText() {
		customerDetailsPage.noMatchFoudText.waitUntilVisible();
		WaitForPageToLoad(10);
		slf4jLogger.info("address no match text validation");
		waitABit(5000);
		boolean flag = customerDetailsPage.noMatchFoudText.getText().contains("No Results Found");
		Assert.assertTrue(flag);
	}

	@Step
	public void checkNumOfAddress() {
		List<WebElement> ele = getDriver()
				.findElements(By.xpath("//input[@id='optionsRadiosAll']/following-sibling::span[1]"));
		slf4jLogger.info("num of address =" + ele.size());
		for (int i = 0; i < ele.size(); i++) {

			slf4jLogger.info(ele.get(i).getText());
		}
	}


	@Step
	public void enterAddressdetails(String street, String unit, String city, String state, String zip) {

		customerDetailsPage.shouldExist(customerDetailsPage, 60);
		customerDetailsPage.showalladdress.click();
		customerDetailsPage.street.type(street);
		customerDetailsPage.unit.type(unit);
		customerDetailsPage.city.type(city);
		customerDetailsPage.zipcode.type(zip);
		customerDetailsPage.state.selectByValue(state);
		slf4jLogger.info("Entered the following Address details for Street=" + street + ", Unit=" + unit + ", City="
				+ city + " ,State=" + state + " ,Zipcode=" + zip);
		waitABit(5000);
	}

	@Step
	public void searchAccoundetails(String env, String first, String last, String phone) {
		customerDetailsPage.shouldExist(customerDetailsPage, 60);
		customerDetailsPage.firstNam.type(first);
		customerDetailsPage.lastNam.type(last);
		customerDetailsPage.phoneNum.type(phone);
		slf4jLogger.info("Entered the following Customer details for Env=" + env + ": firstName=" + first
				+ ", lastName=" + last + " ,PhoneNumber=" + phone);

	}

	@Step
	public void selectMatchAddress() {
		customerDetailsPage.selectradiobtn.click();
		slf4jLogger.info("clicked on radio button and select addresss");
		customerDetailsPage.continuebtn.click();
		slf4jLogger.info("clicked on continue button");

	}

	//Nitish 

	@Step
	public void i_click_on_Account_or_Order_already_exists_link() {
		customerDetailsPage.shouldExist(customerDetailsPage,60);
		customerDetailsPage.orderexists.click();
		slf4jLogger.info("clicked on Account or Order already exists link");
		customerDetailsPage.shouldBeVisible(customerDetailsPage.newcustomer);
		slf4jLogger.info("Start New Customer Order is visible");

	}

	//Nitish MACD Completed Account Number as Input
	@Step
	public void enter_completed_account_number(String completed_accountnum) {

		customerDetailsPage.accnumrbn.click();
		customerDetailsPage.existsaaccnumr.sendKeys(completed_accountnum);
		slf4jLogger.info("Entered completed account number");

	}

	// Prem SFC Starts
	@Step
	public void click_create_new_account() {
		customerDetailsPage.shouldExist(customerDetailsPage,60);
		//pop_out_primary_tabs();
		//waitABit(10000);
		customerDetailsPage.btn_account.click();
		getDriver().switchTo().frame("ext-comp-1005");
		//waitABit(5000);
		int iframes_Count = getDriver().findElements(By.tagName("iframe")).size();
		System.out.println("Frames Count for create new button  " + iframes_Count);
		customerDetailsPage.btn_createnew.click();
		/*
		 * WebDriverWait wait = new WebDriverWait(getDriver(), 60);
		 * wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.
		 * xpath("//iframe[@name='ext-comp-1005']")));
		 */
		//waitABit(10000);
		// customerDetailsPage.link_account.click();
		slf4jLogger.info("Clicked create new account");
		getDriver().switchTo().defaultContent();
	}

	@Step
	public void create_new_account(String firstName, String lastName, String contactNum,String email, String address)
	{
		int iframes_Count =getDriver().findElements(By.tagName("iframe")).size();
		System.out.println("Frames Count for Account creation  "+iframes_Count);
		WebElement frameElement=getDriver().findElement(By.xpath("//iframe[contains(@src,'ServiceAddressCreation')]"));
		//iframe[@id='ext-comp-1050']
		if(frameElement.isDisplayed()){
			String frameName=frameElement.getAttribute("name");
			System.out.println("Account creation Frame name is  "  +frameName);
			getDriver().switchTo().frame(frameName);
			WebDriverWait wait = new WebDriverWait(getDriver(),30);
			wait.until(ExpectedConditions.visibilityOf(customerDetailsPage.address_avail_flag));
			customerDetailsPage.tbx_account_first_name.sendKeys(firstName);
			System.out.println("Entered First Name and ALL Looks Good");
			customerDetailsPage.tbx_account_last_name.sendKeys(lastName);
			customerDetailsPage.tbx_phone_number.sendKeys(contactNum);
			customerDetailsPage.tbx_Email.sendKeys(email);
			customerDetailsPage.tbx_address_field.type(address);
			waitABit(1000);

		}else{
			System.out.println("Frame is Not Available");
		}
		//********* Auto suggestion Handler Premkumara
		String expected_address=address.trim();
		List<WebElement> ss = getDriver().findElements(By.xpath("//*[@id='suggestions']/option"));
		WebElement input_address = getDriver().findElement(By.xpath("//input[@id='oneLineAddressField']"));
		if (ss.size() > 0) {
			try {
				//input_address.clear();
				List<WebElement> address_collections = getDriver().findElements(By.xpath("//*[@data-geoaddressid]"));
				for(int i=0;i<address_collections.size();i++) {
					String actualTxt =address_collections.get(i).getAttribute("value");
					System.out.println("Actual address "+ actualTxt);
					if(actualTxt.contains(expected_address)) {
						waitABit(1000);
						Actions action = new Actions(getDriver());
						action.moveToElement(address_collections.get(1)).click().build().perform();
						input_address.sendKeys(actualTxt);
						waitABit(1000);
						input_address.sendKeys(Keys.ENTER);
						waitABit(1000);
					}else {
						//slf4jLogger.info("Invalid Address");
					}
				}
			} catch (Exception e) {

			}

		} else {

			System.out.println("Address is Empty");
		}

		slf4jLogger.info("Entered the following Customer details for firstName=" + firstName + ", lastName=" + lastName + " ,PhoneNumber=" + contactNum + " and address=" + address);

	}




	@Step
	public void create_new_account(String firstName, String lastName, String contactNum, String address)
	{
		int iframes_Count =getDriver().findElements(By.tagName("iframe")).size();
		System.out.println("Frames Count for Account creation  "+iframes_Count);
		WebElement frameElement=getDriver().findElement(By.xpath("//iframe[contains(@src,'ServiceAddressCreation')]"));
		//iframe[@id='ext-comp-1050']
		if(frameElement.isDisplayed()){
			String frameName=frameElement.getAttribute("name");
			System.out.println("Account creation Frame name is  "  +frameName);
			getDriver().switchTo().frame(frameName);
			WebDriverWait wait = new WebDriverWait(getDriver(),30);
			wait.until(ExpectedConditions.visibilityOf(customerDetailsPage.address_avail_flag));
			customerDetailsPage.tbx_account_first_name.sendKeys(firstName);
			System.out.println("Entered First Name and ALL Looks Good");
			customerDetailsPage.tbx_account_last_name.sendKeys(lastName);
			customerDetailsPage.tbx_phone_number.sendKeys(contactNum);
			customerDetailsPage.tbx_address_field.type(address);
		}

		else {

			System.out.println("Address is Empty");
		}

		slf4jLogger.info("Entered the following Customer details for firstName=" + firstName + ", lastName=" + lastName + " ,PhoneNumber=" + contactNum + " and address=" + address);

	}


	@Step
	public void validate_address() {
		waitABit(3000);
		customerDetailsPage.select_own_house.selectByIndex(1);
		slf4jLogger.info("selected own Option ");	
		waitABit(1000);
		customerDetailsPage.btn_validate_address.click();
		WebElement loading_img = getDriver().findElement(By.xpath("//img[@src='/img/loading.gif']"));
		WebDriverWait wait = new WebDriverWait(getDriver(), 60);
		wait.until(ExpectedConditions.invisibilityOf(loading_img));
		WebElement input_radio_matchaddress = getDriver().findElement(By.xpath("//input[@data-exactmatch='Yes']"));
		input_radio_matchaddress.click();
		wait.until(ExpectedConditions.invisibilityOf(loading_img));                    
		customerDetailsPage.btn_save.click();
		if(customerDetailsPage.btn_close.isCurrentlyEnabled()){
			customerDetailsPage.btn_close.click();
		}

		wait.until(ExpectedConditions.invisibilityOf(loading_img));
		getDriver().switchTo().defaultContent();
	}      

	//click_order_eshop
	@Step
	public void click_order_eshop() {

		waitABit(1000);
		//pop_out_primary_tabs();
		//getDriver().switchTo().frame("ext-comp-1060");
		//WebElement frameElement_eshop=getDriver().findElement(By.xpath("//iframe[contains(@src,'a081K00000YW')]")); PROD	
		//WebElement frameElement_eshop=getDriver().findElement(By.xpath("//iframe[contains(@src,'a08m0000005')]")); //----PP1
		//WebElement frameElement_eshop=getDriver().findElement(By.xpath("//iframe[contains(@src,'a085600000')]")); //----PP2
		WebElement frameElement_eshop=getDriver().findElement(By.xpath("//iframe[contains(@src,'a082f00000')]")); //----PP4
		if(frameElement_eshop.isDisplayed()){
			String frameName=frameElement_eshop.getAttribute("name");
			System.out.println("Account creation Frame name is  "  +frameName);
			getDriver().switchTo().frame(frameName);
			//waitABit(000);
			System.out.println("Frame is Available in SFC Account Page");
			//waitABit(2000);
			customerDetailsPage.btn_order_eshop.click();
			slf4jLogger.info("Clicked Order Eshop Button");	
			//System.out.println("Reached Frame >>>> ");
			//waitABit(2000);
		}

		Set<String> allWindows=getDriver().getWindowHandles();
		//			System.out.println("Window size "+allWindows.size());
		Iterator<String> windowIterator=allWindows.iterator();
		String parentWindow=windowIterator.next();
		String childWindow=windowIterator.next();
		getDriver().switchTo().window(childWindow);
		getDriver().manage().window().maximize();		
		slf4jLogger.info("Launched Eshop Application and New URL is  "+getDriver().getCurrentUrl());	
	}

	// Prem SFC Ends


	//Prem handle Frames 
	public void switchtoFrame(String frame) {
		try{
			getDriver().switchTo().window(getDriver().getWindowHandle());
			getDriver().switchTo().frame(frame);
		}catch(Exception e){

		}
	}

	public WebElement switch_To_Frame(WebElement element, String... attributeName) {
		String frame="";
		getDriver().switchTo().defaultContent();
		List<WebElement> lstFrames = 	getDriver().findElements(By.tagName("iframe"));
		for (WebElement we : lstFrames) {
			if(attributeName.length==0){
				frame = we.getAttribute("id");
			}else{
				frame = we.getAttribute("name");
			}
			switchtoFrame(frame);
			if (element.isDisplayed()) {

				System.out.println(" Expected Element is available .......");
				break;

			}
			getDriver().switchTo().defaultContent();

		}
		return element;
	}

	public void close_all_primary_tab() {
		try{
			//waitABit(20000);
			customerDetailsPage.btn_right_tab_menu.click();
			customerDetailsPage.withTimeoutOf(20, TimeUnit.SECONDS).waitFor(customerDetailsPage.lnk_close_all_primary_tabs).click();
		}catch(Exception e){
			System.out.println("No Tab is opened when user is logged in");
		}
	}

	/**
	 * Method to pop out promary tabs and then close them
	 */
	public void pop_out_primary_tabs() {
		try {
			customerDetailsPage.btn_right_tab_menu.click();
			String parentHandle = getDriver().getWindowHandle();
			System.out.println("parent window id is  " + parentHandle);
			waitABit(1000);		
			if(customerDetailsPage.lnk_pop_out_primary_tabs.isCurrentlyEnabled()){
				customerDetailsPage.lnk_pop_out_primary_tabs.click();	
				Set<String> allWindows = getDriver().getWindowHandles();
				System.out.println("Window size >>>>>>>>>> " + allWindows.size());
				if (allWindows.size() > 1) {
					Iterator<String> windowIterator = allWindows.iterator();
					String parentWindow = windowIterator.next();
					String childWindow = windowIterator.next();
					getDriver().switchTo().window(childWindow);
					System.out.println("Child window is >>> "+childWindow);
					waitABit(7000);
					getDriver().switchTo().window(childWindow).close();
					System.out.println("child window is closed..... ");
					getDriver().switchTo().window(parentWindow);
					System.out.println("Switch to Parent window ........ ");
				} else {
					System.out.println("Single window   ");
				}				
			}
			// customerDetailsPage.withTimeoutOf(20,
			// TimeUnit.SECONDS).waitFor(customerDetailsPage.lbl_drag_footer_component_here);
			// Set<String>windowHandles= getDriver().getWindowHandles();
			// Iterator<String>iterator=windowHandles.iterator();
			// code to close child window ///
			customerDetailsPage.withTimeoutOf(20, TimeUnit.SECONDS)
			.waitFor(customerDetailsPage.lnk_pop_out_primary_tabs).click();
			// customerDetailsPage.withTimeoutOf(20,
			// TimeUnit.SECONDS).waitFor(customerDetailsPage.lbl_drag_footer_component_here);
			// Set<String>windowHandles= getDriver().getWindowHandles();
			// Iterator<String>iterator=windowHandles.iterator();

			// code to close child window ///
			Set<String> allWindows = getDriver().getWindowHandles();
			System.out.println("Window size " + allWindows.size());
			if (allWindows.size() > 1) {

				Iterator<String> windowIterator = allWindows.iterator();
				String parentWindow = windowIterator.next();
				String childWindow = windowIterator.next();
				// getDriver().switchTo().window(childWindow);
				getDriver().switchTo().window(childWindow);
				getDriver().close();
				System.out.println("child window is closed..... ");
			} else {

				System.out.println("Single window   ");
			}
			/*
			 * while(iterator.hasNext()){ String handle=iterator.next();
			 * if(!(handle.equals(parentHandle))){
			 * getDriver().switchTo().window(handle).close();
			 * System.out.println("Closed child window ..... "); //
			 * getDriver().findElement(By.cssSelector("body")).sendKeys(Keys.
			 * CONTROL +"w"); waitABit(3000);
			 * iterator=getDriver().getWindowHandles().iterator(); int
			 * size=Iterators.size(iterator); if(size==1){ break; }else{
			 * getDriver().close(); break; } } }
			 */
			// getDriver().switchTo().window(parentHandle);
			//waitABit(5000);

		}catch(Exception e){
			System.out.println("driver instance is not moved back to parent window");
		}
	}

	/**
	 * Method to enter ORN which was captured after the order is put on hold
	 */
	public void  enter_ORN_For_Order_On_Hold(){
		try {
			customerDetailsPage.txt_Existing_Information_Order_Number.sendKeys(AccountInformationSteps.ORN);
			slf4jLogger.info("ORN for order in hold is entered, which is  --------" + AccountInformationSteps.ORN);
		} catch (Exception e) {
			Assert.fail("ORN for order in hold could not be entered. Please check if UI is changed or applicaion is down");
			e.printStackTrace();
		}
	}

	/**
	 * Step to enter ORN which was captured after the order is put on hold
	 */
	@Step
	public void enters_ORN_On_Hold() {
		enter_ORN_For_Order_On_Hold();
		slf4jLogger.info("ORN for order in hold step is completed");
	}

	/**
	 * Step to click on the Acount/order already exists link
	 */
	@Step
	public void i_click_on_Account_or_Order_already_exists() {
		customerDetailsPage.orderexists.click();
		slf4jLogger.info("clicked on Account or Order already exists link");
	}

	/**
	 * Method to click on Lets go button
	 */
	public void click_On_Lets_Go_Button(){
		try {
			customerDetailsPage.btn_Lets_Go.click();
			slf4jLogger.info("Lets Go button Clicked after entering details");
		} catch (Exception e) {
			Assert.fail("Lets Go button is not Clicked after entering details. Please check if UI is changed or applicaion is down");
			e.printStackTrace();
		}
	}

	/**
	 * Method to enter first name in ESHOP screen
	 */
	public void enter_First_Name_ESHOP(String firstName){
		try {
			customerDetailsPage.txt_First_Name_ESHOP.sendKeys(firstName);
			slf4jLogger.info("First name entered in EHOP screen, which is ------" + firstName);
		} catch (Exception e) {
			Assert.fail("First name is not entered in EHOP screen. Please check if UI is changed or applicaion is down");
			e.printStackTrace();
		}
	}

	/**
	 * Method to enter last name in ESHOP screen
	 */
	public void enter_Last_Name_ESHOP(String lastName){
		try {
			customerDetailsPage.txt_Last_Name_ESHOP.sendKeys(lastName);
			slf4jLogger.info("Last name entered in EHOP screen, which is ------" + lastName);
		} catch (Exception e) {
			Assert.fail("Last name is not entered in EHOP screen. Please check if UI is changed or applicaion is down");
			e.printStackTrace();
		}
	}

	/**
	 * Method to enter Contact Number in ESHOP screen
	 */
	public void enter_Contact_Number_ESHOP(String contactNumber){
		try {
			customerDetailsPage.txt_Contact_Number_ESHOP.sendKeys(contactNumber);
			slf4jLogger.info("Contact Number is entered in EHOP screen, which is ------" + contactNumber);
		} catch (Exception e) {
			Assert.fail("Contact Number is not entered in EHOP screen. Please check if UI is changed or applicaion is down");
			e.printStackTrace();
		}
	}

	/**
	 * Step to enter Customer Information in ESHOP Screen
	 */
	@Step
	public void enters_Customer_Information(String firstName, String lastName, String contactNumber) {
		enter_First_Name_ESHOP(firstName);
		enter_Last_Name_ESHOP(lastName);
		enter_Contact_Number_ESHOP(contactNumber);
	}

	/**
	 * Step to click on Lets Go button in ESHOP Customer information screen
	 */
	@Step
	public void clicks_On_Lets_Go_Button() {
		click_On_Lets_Go_Button();
	}

	/**
	 * Step to create a New account with email address from SFC application
	 * @param firstName
	 * @param lastName
	 * @param contactNum
	 * @param address
	 */
	@Step
	public void create_New_Account_With_Email_From_SFC(String firstName, String lastName, String contactNum, String address, String email)
	{
		int iframes_Count =getDriver().findElements(By.tagName("iframe")).size();
		System.out.println("Frames Count for Account creation  "+iframes_Count);
		WebElement frameElement=getDriver().findElement(By.xpath("//iframe[contains(@src,'ServiceAddressCreation')]"));
		//iframe[@id='ext-comp-1050']
		if(frameElement.isDisplayed()){
			String frameName=frameElement.getAttribute("name");
			System.out.println("Account creation Frame name is  "  +frameName);
			getDriver().switchTo().frame(frameName);
			WebDriverWait wait = new WebDriverWait(getDriver(),30);
			wait.until(ExpectedConditions.visibilityOf(customerDetailsPage.address_avail_flag));
			customerDetailsPage.tbx_account_first_name.sendKeys(firstName);
			System.out.println("Entered First Name and ALL Looks Good");
			slf4jLogger.info("FirstName added ------" + firstName);
			customerDetailsPage.tbx_account_last_name.sendKeys(lastName);
			slf4jLogger.info("LastName added ------" + lastName);
			customerDetailsPage.tbx_phone_number.sendKeys(contactNum);
			slf4jLogger.info("Phone Number added ------" + contactNum);
			customerDetailsPage.txt_Email.sendKeys(email);
			slf4jLogger.info("Email added ------" + email);
			customerDetailsPage.tbx_address_field.type(address);
			slf4jLogger.info("Address added ------" + address);
			waitABit(1000);

		}else{
			System.out.println("Frame is Not Available");
			slf4jLogger.info("Frame is Not Available");
		}

		String expected_address=address.trim();
		List<WebElement> ss = getDriver().findElements(By.xpath("//*[@id='suggestions']/option"));
		WebElement input_address = getDriver().findElement(By.xpath("//input[@id='oneLineAddressField']"));
		if (ss.size() > 0) {
			try {
				//input_address.clear();
				List<WebElement> address_collections = getDriver().findElements(By.xpath("//*[@data-geoaddressid]"));
				for(int i=0;i<address_collections.size();i++) {
					String actualTxt =address_collections.get(i).getAttribute("value");
					System.out.println("Actual address "+ actualTxt);
					if(actualTxt.contains(expected_address)) {
						waitABit(1000);
						Actions action = new Actions(getDriver());
						action.moveToElement(address_collections.get(1)).click().build().perform();
						input_address.sendKeys(actualTxt);
						waitABit(1000);
						input_address.sendKeys(Keys.ENTER);
						waitABit(1000);
					}else {
						slf4jLogger.info("Invalid Address");
					}
				}
			}catch (Exception e) {
			}

		} 
		else {

			System.out.println("Address is Empty");
		}
		slf4jLogger.info("Entered the following Customer details for firstName=" + firstName + ", lastName=" + lastName + " ,PhoneNumber=" + contactNum + " address=" + address + "and email=" + email );
	}
	/////////// show Addresss Functionality 03/01   ///////////

	@Step
	public void create_new_account_showAddress(String firstName, String lastName, String contactNum, String Address)
	{
		int iframes_Count =getDriver().findElements(By.tagName("iframe")).size();
		System.out.println("Frames Count for Account creation  "+iframes_Count);
		WebElement frameElement=getDriver().findElement(By.xpath("//iframe[contains(@src,'ServiceAddressCreation')]"));
		//iframe[@id='ext-comp-1050']
		if(frameElement.isDisplayed()){
			String frameName=frameElement.getAttribute("name");
			System.out.println("Account creation Frame name is  "  +frameName);
			getDriver().switchTo().frame(frameName);
			WebDriverWait wait = new WebDriverWait(getDriver(),30);
			wait.until(ExpectedConditions.visibilityOf(customerDetailsPage.address_avail_flag));
			customerDetailsPage.tbx_account_first_name.sendKeys(firstName);
			System.out.println("Entered First Name and ALL Looks Good");
			customerDetailsPage.tbx_account_last_name.sendKeys(lastName);
			customerDetailsPage.tbx_phone_number.sendKeys(contactNum);
			waitABit(1000);
			customerDetailsPage.show_address.click();
			waitABit(1000);
			// click on Show address fields
			if(Address.contains("~"))
			{
				String splitAddress[]= Address.split("~");
				String street= splitAddress[0];
				String city= splitAddress[1];
				String state= splitAddress[2];
				String postalCode= splitAddress[3];
				customerDetailsPage.input_serviceStreet.sendKeys(street);
				customerDetailsPage.input_serviceCity.sendKeys(city);
				customerDetailsPage.input_serviceState.sendKeys(state);
				//customerDetailsPage.input_serviceStreet2.sendKeys(contactNum);
				customerDetailsPage.input_servicezipCode.sendKeys(postalCode);
			}
		}else{
			System.out.println("Frame is Not Available");
		}
	}

	//anuradha: code to select residence option
	@Step
	public void  i_select_own_or_rent(String Residence){
		waitABit(1000);
		customerDetailsPage.ownorrent.selectByVisibleText("Own");	


	}

}
