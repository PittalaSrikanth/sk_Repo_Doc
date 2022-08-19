package com.ctl.it.qa.eshop.steps;

import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ctl.it.qa.eshop.pages.AccountInformationPage;
import com.ctl.it.qa.staf.Steps;

import net.serenitybdd.core.annotations.findby.By;
import net.thucydides.core.annotations.Step;

public class AccountInformationSteps extends Steps{

	private final Logger slf4jLogger = LoggerFactory.getLogger(AccountInformationSteps.class);

	AccountInformationPage accountInformationPage;
	public static String ORN;

	@Step
	public void emailDeclineClick() throws InterruptedException {
		accountInformationPage.shouldExist(accountInformationPage,60);
		accountInformationPage.emailDeclines.click();
		slf4jLogger.info("Email check decline");
	}

	@Step
	public void dateOfBirth(String date,String month,String Year) throws InterruptedException {
		accountInformationPage.monthDB.sendKeys(date);
		accountInformationPage.dayDB.sendKeys(date);
		accountInformationPage.yearDB.sendKeys(Year);
		slf4jLogger.info("Entered date,month and year in DOB");
	}

	@Step
	public void creditCheck(String args) {
		if(args.equalsIgnoreCase("Yes")) {
			accountInformationPage.creditCheckYes.click();
			slf4jLogger.info("selected credit check as Yes");
		}else if(args.equalsIgnoreCase("No")) {
			accountInformationPage.creditCheckNo.click();
			slf4jLogger.info("selected credit check as NO");
		}

	}


	@Step
	public void clickAccountInfoContinue() throws InterruptedException {
		WaitForPageToLoad(60);
		accountInformationPage.clickContinue.click();
		slf4jLogger.info("clicked on continue button in account information page");
		if(accountInformationPage.validate_customer_info.isCurrentlyEnabled()) {
			accountInformationPage.validate_customer_info.waitUntilClickable();
			accountInformationPage.validate_customer_info.click();
			slf4jLogger.info("Validated Customer Credit Information");
		}
	}

	@Step
	public void ssnDetails(String ssn) throws InterruptedException {
		WaitForPageToLoad(60);
		accountInformationPage.ssn.sendKeys(ssn);
		slf4jLogger.info("Entered SSN number");
	}

	@Step
	public void payNowCredit() throws InterruptedException{
		accountInformationPage.payNow.waitUntilClickable();
		accountInformationPage.payNow.click();
		slf4jLogger.info("clicked PayNow button");
	}

	@Step
	public void verifyage() throws InterruptedException{
		String ageMessage = accountInformationPage.lessAgePopup.getText();
		boolean flag = ageMessage.contains("Applicant less than 18 yrs old");
		Assert.assertTrue(flag);
		slf4jLogger.info("clicked PayNow button");
	}

	public void clickAgainAfterPaymentAccountInfoContinue() {
		try {
			waitABit(15000);
			boolean Paymentflag = accountInformationPage.payment_location.isCurrentlyVisible();
			slf4jLogger.info("value Paymentflag    "+Paymentflag);
			if (Paymentflag) {	
				JavascriptExecutor js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].click();", accountInformationPage.clickContinue);
				slf4jLogger.info("clicked on continue button in account information page on try block for Payment Deposits");
			}
			else {	
				boolean nodepositflag = accountInformationPage.info_nodeposit.isDisplayed();
				slf4jLogger.info("value no deposits    "+nodepositflag);
				if (nodepositflag) {
					JavascriptExecutor js = (JavascriptExecutor) getDriver();
					js.executeScript("arguments[0].click();", accountInformationPage.clickContinue);
					slf4jLogger.info("clicked on continue button in account information page on try block for Non Payment Deposit");
				}			
			}
		} catch (Exception e) {
			/*waitABit(5000);
			Actions actions = new Actions(getDriver());
			actions.moveToElement(accountInformationPage.clickContinue).click();
			actions.build().perform();*/
			JavascriptExecutor js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].click();", accountInformationPage.clickContinue);
			slf4jLogger.info("clicked on continue button in account information page on catch block");
		}
	}
	@Step
	public void i_enter_email_and_sms_contacts(String email, String sms) {
		accountInformationPage.emailAddress.type(email);
		accountInformationPage.smsno.type(sms);
		slf4jLogger.info("Entered emailid and sms no.");
	}

	//ac31339 code starts

	@Step
	public void enterPassword(String pwd) throws InterruptedException {
		WaitForPageToLoad(120);
		accountInformationPage.input_password.sendKeys(pwd);
		slf4jLogger.info("Entered Password");
	}

	@Step
	public void verifyPassword(String pwd) throws InterruptedException {
		WaitForPageToLoad(120);
		//accountInformationPage.input_password.sendKeys(pwd);

		if (!accountInformationPage.input_disabled_password.isCurrentlyVisible()) {

			slf4jLogger.info("Password field is verified ans it is Disabled >>> Password is "+pwd);
			waitABit(2000);
		} else {
			slf4jLogger.info("Password field is Enabled");
		}

	}

	@Step
	public void enter_AccountId(String accId) throws InterruptedException {
		WaitForPageToLoad(120);
		accountInformationPage.input_dtv_accountid.sendKeys(accId);

		slf4jLogger.info("Entered DTV Account ID ");

	}


	@Step
	public void enter_Empty_Password(String pwd) throws InterruptedException {
		WaitForPageToLoad(120);
		for(int i=0;i<6;i++){
			accountInformationPage.input_password.sendKeys(Keys.SPACE);
		}
		slf4jLogger.info("Entered Empty Password");
	}
	//validateEmptyPassword

	@Step
	public void validateEmptyPassword(String pwd) throws InterruptedException {
		WaitForPageToLoad(120);
		// accountInformationPage.input_password.sendKeys(pwd);

		if (accountInformationPage.txt_invalid_pwd_message.isCurrentlyVisible()) {

			String actualErrMessage = accountInformationPage.txt_invalid_pwd_message.getText();
			String expectedErrMessage = "Enter a valid password";

			if (actualErrMessage.contains(expectedErrMessage)) {
				slf4jLogger.info("Invalid Password is validated Successfully >> " + actualErrMessage);
			}

			waitABit(10000);
		} else {
			slf4jLogger.info("Error message is not visible");


		}

	}

	//ac31339 code ends
	//ac31339 code starts

	@Step
	public void clickBackButton() throws InterruptedException {

		//WaitForPageToLoad(120);
		waitABit(10000);
		// accountInformationPage.input_password.sendKeys(pwd);

		if (accountInformationPage.btn_move_back.isCurrentlyVisible()) {

			for(int i=0;i<4;i++){
				accountInformationPage.btn_move_back.click();
				waitABit(3000);
			}

			waitABit(10000);
			/*	        WebElement loading_img = getDriver().findElement(By.xpath("//img[@src='/img/loading_large.gif']"));

	        //src="./assets/img/loading_large.gif"

	        WebDriverWait wait = new WebDriverWait(getDriver(), 120);
	        wait.until(ExpectedConditions.invisibilityOf(loading_img));*/

		} else {

			slf4jLogger.info("Back Button is not visible");

		}

	}

	@Step
	public void clickAccountInfoContinue2() throws InterruptedException {

		//	WaitForPageToLoad(120);
		//waitABit(20000);
		WebDriverWait wait = new WebDriverWait(getDriver(), 200);
		//WebElement loading_img = getDriver().findElement(By.xpath("//img[@src='/img/loading_large.gif']"));
		WebElement txt_accountinfo = getDriver().findElement(By.xpath("//div[text()='Account Information']"));
		wait.until(ExpectedConditions.visibilityOf(txt_accountinfo));
		accountInformationPage.clickContinue_acccInfo2.click();
		slf4jLogger.info("clicked on continue button in account information page again");
		/*accountInformationPage.validate_customer_info.waitUntilClickable();
		accountInformationPage.validate_customer_info.click();
		slf4jLogger.info("Validated Customer Credit Information");*/
	} 	

	//ac31339 code ends

	/*      AC43057
	 * ----- method to click on continue button for move order on accnt info
	 */

	@Step
	public void clickContonAccntMove() {
		waitABit(40000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView();",accountInformationPage.contmveaccnt);
		accountInformationPage.contmveaccnt.click();
		slf4jLogger.info("clicked on continue button in move account information page");

	}

	/**
	 * Method to validate the Name inside Credit Information pop up during Credit Check
	 */
	public boolean validate_Name_Inside_Credit_Information_Popup(String expectedName){
		String actualName = accountInformationPage.lbl_Credit_Information_Name.getText();
		boolean b = actualName.equalsIgnoreCase(expectedName);
		slf4jLogger.info("Actual Name is "+ actualName);
		return b;
	}

	/**
	 * Method to validate the DOB inside Credit Information pop up during Credit Check
	 */
	public boolean validate_DOB_Inside_Credit_Information_Popup(String expectedDOB){
		String actualDOB = accountInformationPage.lbl_Credit_Information_DOB.getText();
		boolean b = actualDOB.contains(expectedDOB);
		return b;
	}

	/**
	 * Method to validate the SSN inside Credit Information pop up during Credit Check
	 */
	public boolean validate_SSN_Inside_Credit_Information_Popup(String expectedSSN){
		String lastFourDigitsSSN;
		String actualSSN = accountInformationPage.lbl_Credit_Information_SSN.getText();
		if (expectedSSN.length() > 4)
		{
			lastFourDigitsSSN = expectedSSN.substring(expectedSSN.length() - 4);
			System.out.println(lastFourDigitsSSN);
		}
		else
		{
			lastFourDigitsSSN = expectedSSN;
		}
		boolean b = actualSSN.contains(lastFourDigitsSSN);
		slf4jLogger.info("Actual SSN is "+ actualSSN);
		slf4jLogger.info("ExpectedLast 4 digits of SSN is "+ lastFourDigitsSSN);
		Assert.assertTrue("SSN is incorrect in the Credit information popup ", b);
		return b;
	}

	/**
	 * Step to validate the details inside Credit Information pop up during Credit Check
	 */
	@Step
	public void vaidates_Credit_Information_Popup(String firstName, String lastName, String date, String month,
			String year, String sSN) {
		accountInformationPage.lbl_Validate_Credit_Information_Popup.shouldBeVisible();
		accountInformationPage.btn_Credit_Information_Yes.shouldBeVisible();
		accountInformationPage.btn_Credit_Information_No.shouldBeVisible();
		Assert.assertTrue("Name is not correct inside Credit Information popup", 
				validate_Name_Inside_Credit_Information_Popup(firstName+" "+lastName));
		slf4jLogger.info("Name validated inside Credit Information popup");

		Assert.assertTrue("SSN is not correct inside Credit Information popup", 
				validate_SSN_Inside_Credit_Information_Popup(sSN));
		slf4jLogger.info("SSN validated inside Credit Information popup");

		Assert.assertTrue("DOB is not correct inside Credit Information popup", 
				validate_DOB_Inside_Credit_Information_Popup(month+"/"+date+"/"+year));
		slf4jLogger.info("DOB validated inside Credit Information popup");

	}

	/**
	 * Step to click on continue button and wait for the Credit Information pop up
	 */
	@Step
	public void click_Account_Info_Continue_And_Wait_For_Popup() throws InterruptedException {
		WaitForPageToLoad(60);
		accountInformationPage.clickContinue.waitUntilVisible();
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].click();", accountInformationPage.clickContinue);
		//		accountInformationPage.clickContinue.click();
		slf4jLogger.info("clicked on continue button in account information page");
	}

	/**
	 * Step to click on Yes, it is correct
	 */
	@Step
	public void clicks_On_Yes_It_Is_Correct() {
		accountInformationPage.btn_Credit_Information_Yes.click();
		slf4jLogger.info("clicked on Yes, it is correct button inside Credit Information pop up");
	}

	/**
	 * Step to click on No, needs correction
	 */
	@Step
	public void clicks_On_No_Needs_Correction() {
		accountInformationPage.btn_Credit_Information_No.click();
		slf4jLogger.info("clicked on No, needs correction button inside Credit Information pop up");
	}

	/**
	 * Step to validate if the Update Application link is enabled
	 */
	public void validates_if_the_Update_Application_link_is_enabled() {
		Assert.assertTrue("Update Application link is not enabled", validate_if_the_Update_Application_link_is_enabled());
		slf4jLogger.info("Update Application link is enabled and validated");
	}

	/**
	 * Method to validate if the Update Application link is enabled
	 */
	public boolean validate_if_the_Update_Application_link_is_enabled() {
		boolean b = accountInformationPage.link_Update_Application.isEnabled();
		slf4jLogger.info("Update Application link validated");
		return b;
	}

	/**
	 * Method to validate if the Update Application link is disabled
	 */
	public boolean validate_if_the_Update_Application_link_is_disabled() {
		boolean b = accountInformationPage.link_Update_Application_Disabled.isVisible();
		slf4jLogger.info("Update Application link validated");
		return b;
	}

	/**
	 * Method to repeat the credit check process
	 */
	public void repeat_Credit_Checks(){
		//		Random random = new Random(); 
		accountInformationPage.link_Update_Application.click();
		//		System.out.println(String.format("%09d", random.nextInt(100000000)));
		//		accountInformationPage.ssn.clear();
		//		accountInformationPage.ssn.sendKeys(String.format("%09d", random.nextInt(100000000)));
		accountInformationPage.txt_FirstName.clear();
		accountInformationPage.txt_FirstName.sendKeys("Allex");
		accountInformationPage.txt_LastName.clear();
		accountInformationPage.txt_LastName.sendKeys("Moses");
		accountInformationPage.ssn.clear();
		accountInformationPage.ssn.sendKeys("666548774");
		accountInformationPage.clickContinueAccInfo.click();
		accountInformationPage.btn_Credit_Information_Yes.click();
		slf4jLogger.info("Credit check process repeated");
		if(accountInformationPage.cbx_By_Pass_Deposit_Requirement.isPresent()){
			accountInformationPage.cbx_By_Pass_Deposit_Requirement.click();
		}
	}

	/**
	 * Method to repeat the credit check process n number of times
	 */
	@Step
	public void performs_Credit_Checks(int creditCheckTimes) {
		for(int i=1;i<=creditCheckTimes;i++){
			repeat_Credit_Checks();
		}

	}

	/**
	 * Step to validate if the Update Application link is disabled
	 */
	@Step
	public void validates_if_the_Update_Application_link_is_Disabled() {
		Assert.assertTrue("Update Application link is enabled", validate_if_the_Update_Application_link_is_disabled());
		slf4jLogger.info("Update Application link is diabled and validated as maximum number of credit checks is 2");
	}

	/**
	 * Step to click on back button
	 */
	public void clicks_On_Back_Button() {
		accountInformationPage.btn_Back.click();
		slf4jLogger.info("Back button clicked");
	}

	/**
	 * Method to select the On Hold reason while putting the order hold 
	 */
	public void select_On_Hold_Reason(String reason){
		accountInformationPage.ddl_Place_On_Hold.selectByValue(reason);
		slf4jLogger.info("On Hold Reason selected which is "+ reason);
	}

	/**
	 * Method to select the add Additional Notes while putting the order hold 
	 */
	public void enter_Additional_Notes(String additionalNotes){
		accountInformationPage.txt_Additional_Notes.sendKeys(additionalNotes);
		slf4jLogger.info("Additional Notes entered which is "+ additionalNotes);
	}

	/**
	 * Step to click on Place On Hold button
	 */
	@Step
	public void clicks_On_Place_On_Hold_Button() {
		accountInformationPage.btn_Place_On_Hold.click();
		slf4jLogger.info("Place On Hold button clicked");
	}

	/**
	 * Step to enter Place on Hold order details and Place on Hold
	 */
	@Step
	public void selects_And_Give_Place_On_Hold_details(String onHoldReason, String additionalNotes) {
		select_On_Hold_Reason(onHoldReason);
		enter_Additional_Notes(additionalNotes);
		slf4jLogger.info("On Hold Reason and Additional Notes entered..");
		accountInformationPage.btn_Place_On_Hold_Confirm_Dialog_Box.click();
	}

	/**
	 * Step to take the URN from order which is on Hold
	 */
	@Step
	public void gets_ORN_From_On_Hold_Order() {

		try {
			waitABit(10000);
			accountInformationPage.lbl_ORN_On_Hold_Order.waitUntilVisible();
			String orn = accountInformationPage.lbl_ORN_On_Hold_Order.getText();
			System.out.println(orn);
			ORN = orn.substring(19);
			System.out.println(ORN);
			slf4jLogger.info("ORN for On Hold order taken which is" + ORN );
		} catch (Exception e) {
			slf4jLogger.info(e.getMessage());
			Assert.fail("ORN not captured.");
		}	
	}

	/**
	 * Step to click on Start new Order after order has been puit on hold
	 */
	@Step
	public void starts_New_Order_After_Hold() {
		accountInformationPage.btn_Start_New_Order.click();
		slf4jLogger.info("Start new Order after order has been puit on hold is clicked" );
	}

	/**
	 * Method to validate the email address which is coming from SFC to ESHOP
	 * @param emailAddress
	 * @return
	 */
	public boolean validate_The_Email_From_SFC(String emailAddress){
		WaitForPageToLoad(60);
		String actualEmailAddress = accountInformationPage.emailAddress.getAttribute("value");
		slf4jLogger.info("-----------------Actual Email address--------------" + actualEmailAddress);
		String expectedEmailAddress = emailAddress;
		boolean b = actualEmailAddress.equalsIgnoreCase(expectedEmailAddress);
		slf4jLogger.info("-----------------Email address validated--------------");
		return b;
	}

	/**
	 * Method to validate the email address which is coming from SFC to ESHOP
	 * @param emailAddress
	 */
	@Step
	public void validates_The_Email_From_SFC(String emailAddress){
		boolean b = validate_The_Email_From_SFC(emailAddress);
		Assert.assertTrue("Email address is not correct!!!!!", b);
		slf4jLogger.info("-----------------Email address validated--------------  " + b);
	}

	/**
	 * Step to validate if Paperless billing checkbox is selected by default when a valid email is entered
	 */
	@Step
	public void validates_If_Paperless_Billing_Is_Selected_By_Default() {
		boolean b = validate_If_Paperless_Billing_Is_Selected_By_Default();
		Assert.assertTrue("Paperless billing is not selected by default!!!!!", b);
		slf4jLogger.info("-----------------Paperless billing validated--------------  " + b);

	}

	/**
	 * Method to validate if Paperless billing checkbox is selected by default when a valid email is entered
	 */
	public boolean validate_If_Paperless_Billing_Is_Selected_By_Default() {
		waitABit(2000);
		boolean b = accountInformationPage.cbx_Paperless_Billing.isSelected();
		slf4jLogger.info("-----------------Paperless billing validated--------------");
		return b;
	}

	/**
	 * Step to validate if the Mail my Bill option is deselected when a valid email is passed through Salesforce
	 */
	@Step
	public void validates_If_Mail_My_Bill_Is_Deselected() {
		boolean b = validate_If_Mail_My_Bill_Is_Deselected();
		Assert.assertTrue("Mail my bill is selected for a valid email from SFC!!!", b);
	}

	/**
	 * Method to validate if the Mail my Bill option is deselected when a valid email is passed through Salesforce
	 */
	public boolean validate_If_Mail_My_Bill_Is_Deselected() {
		boolean b = accountInformationPage.cbx_Mail_My_Bill.isSelected();
		slf4jLogger.info("-----------------Mail My bill is deselected--------------");
		return !b;
	}

	/**
	 * Step to select the Mail my Bill option in Account Information page
	 */
	@Step
	public void selects_Mail_My_Bill_Option() {
		select_Mail_My_Bill_Option();
	}

	/**
	 * Method to select the Mail my Bill option in Account Information page
	 */
	public void select_Mail_My_Bill_Option() {
		accountInformationPage.cbx_Mail_My_Bill.click();
		slf4jLogger.info("-----------------Mail My bill is selected--------------");
	}

	/**
	 * Step to change the email id in Account Information page
	 */
	@Step
	public void changes_Email_Id(String emailAddress) {
		change_Email_Id(emailAddress);
	}

	/**
	 * Step to change the email id in Account Information page
	 */
	public void change_Email_Id(String emailAddress) {
		accountInformationPage.emailAddress.type(emailAddress);
		slf4jLogger.info("-----------------Email ID changed--------------");
	}

	/**
	 * Step to change the focus from email id field in Account Information page
	 */
	@Step
	public void changes_Focus_From_Email_Field() {
		change_Focus_From_Email_Field();	
	}

	/**
	 * Step to change the focus from email id field in Account Information page
	 */
	public void change_Focus_From_Email_Field() {
		accountInformationPage.smsno.click();
		slf4jLogger.info("-----------------Focus from email Id field changed--------------");
	}

	/**
	 * Step to validate the default value of Special Format when Mail my Bill option is selected
	 * @param specialFormat
	 */
	@Step
	public void validates_Default_Special_Format(String specialFormat) {
		boolean b = validate_Default_Special_Format(specialFormat);
		Assert.assertTrue("Special Format is wrong!!!!!", b);
	}

	/**
	 * Method to validate the default value of Special Format when Mail my Bill option is selected
	 * @param specialFormat
	 */
	public boolean validate_Default_Special_Format(String specialFormat) {
		Select select = new Select(accountInformationPage.ddl_Mail_My_Bill_Special_Format);
		String defaultSpecialFormat = select.getFirstSelectedOption().getText();
		boolean b = defaultSpecialFormat.equalsIgnoreCase(specialFormat);
		slf4jLogger.info("-----------------Default Special Format is "+ defaultSpecialFormat +"  --------------");
		return b;
	}

	/**
	 * Step to validate the values of Special Format when Mail my Bill option is selected in Account Information Page
	 * @param none
	 * @param braille
	 * @param large
	 * @param spanish
	 */
	@Step
	public void validates_Special_Format_Values(String none, String braille, String large, String spanish) {
		boolean b1 = validate_Special_Format_Value(none);
		Assert.assertTrue("Special Format value None is NOT present!!!!!!!", b1);
		boolean b2 = validate_Special_Format_Value(braille);
		Assert.assertTrue("Special Format value Braille delivery is NOT present!!!!!!!", b2);
		boolean b3 = validate_Special_Format_Value(large);
		Assert.assertTrue("Special Format value Large print is NOT present!!!!!!!", b3);
		boolean b4 = validate_Special_Format_Value(spanish);
		Assert.assertTrue("Special Format value Spanish print is NOT present!!!!!!!", b4);
	}

	/**
	 * Method to validate the values of Special Format when Mail my Bill option is selected in Account Information Page
	 * @param specialFormatValue
	 * @return
	 */
	public boolean validate_Special_Format_Value(String specialFormatValue){
		Select select = new Select(accountInformationPage.ddl_Mail_My_Bill_Special_Format);
		List<WebElement> list = select.getOptions();
		boolean b = false;
		a:
			for(WebElement ele: list){
				if(ele.getText().equalsIgnoreCase(specialFormatValue)){
					b=true;
					slf4jLogger.info("-----------------Special Format is "+ ele.getText() +"  --------------");
					break a;
				}
			}
		return b;
	}

	/**
	 * Step to select the Special Format when Mail my Bill option is selected in Account Information Page
	 * @param specialFormat
	 */
	@Step
	public void selects_Special_Format(String specialFormat) {
		select_Special_Format(specialFormat);
	}

	/**
	 * Method to select the Special Format when Mail my Bill option is selected in Account Information Page
	 * @param specialFormat
	 */
	public void select_Special_Format(String specialFormat) {
		Select select = new Select(accountInformationPage.ddl_Mail_My_Bill_Special_Format);
		select.selectByVisibleText(specialFormat);
		slf4jLogger.info("-----------------Special Format selectedis "+ specialFormat +"  --------------");
	}

	/**
	 * Step to select Paperless billing option in Account Information page
	 */
	@Step
	public void selects_Paperless_Billing_Option() {
		select_Paperless_Billing_Option();
	}

	/**
	 * Method to select Paperless billing option in Account Information page
	 */
	public void select_Paperless_Billing_Option() {
		waitABit(2000);
		accountInformationPage.cbx_Paperless_Billing.click();
		slf4jLogger.info("-----------------Paperless Billing Option selected--------------");
	}

	/**
	 * Step to validate if Special Format section is disabled when Paperless billing option is selected
	 */
	@Step
	public void validates_If_Special_Format_Section_Is_Disabled() {
		boolean b = validate_If_Special_Format_Section_Is_Disabled();
		Assert.assertTrue("Special Format is NOT disabled!!!!!!!", b);
	}

	/**
	 * Method to validate if Special Format section is disabled when Paperless billing option is selected
	 */
	public boolean validate_If_Special_Format_Section_Is_Disabled() {
		boolean b = accountInformationPage.ddl_Mail_My_Bill_Special_Format.isEnabled();
		slf4jLogger.info("-----------------Special format section is disabled--------------" + !b);
		return !b;
	}

	/**
	 * Step to check if Mail my Bill is selected by default
	 */
	@Step
	public void validates_If_Mail_my_Bill_is_selected_by_default() {
		boolean b = validate_If_Mail_my_Bill_is_selected_by_default();
		Assert.assertTrue("Mail by Bill is NOT selected by default!!!!!!!", b);
	}

	/**
	 * Method to check if Mail my Bill is selected by default
	 */
	public boolean validate_If_Mail_my_Bill_is_selected_by_default() {
		WaitForPageToLoad(60);
		boolean b = accountInformationPage.cbx_Mail_My_Bill.isSelected();
		slf4jLogger.info("-----------------Mail by bill is selected by default--------------" + b);
		return b;
	}

	/**
	 * Step to check if Paperless Billing is Disabled in Account Information Page
	 */
	@Step
	public void validates_If_Paperless_Billing_Option_Is_Disabled() {
		validate_If_Paperless_Billing_Option_Is_Disabled();
	}

	/**
	 * Method to check if Paperless Billing is Disabled in Account Information Page
	 */
	public boolean validate_If_Paperless_Billing_Option_Is_Disabled() {
		boolean b = accountInformationPage.cbx_Paperless_Billing.isEnabled();
		slf4jLogger.info("-----------------Paperless Billing option is disabled--------------" + !b);
		return !b;
	}

	/**
	 * Step to select Customer Declines Email in Account Information page
	 */
	@Step
	public void clicks_On_Customer_Declines_Email() {
		click_On_Customer_Declines_Email();
	}

	/**
	 * Method to select Customer Declines Email in Account Information page
	 */
	public void click_On_Customer_Declines_Email() {
		WaitForPageToLoad(60);
		accountInformationPage.emailDeclines.click();
		slf4jLogger.info("-----------------User clicks on Customer Declines Email--------------");
	}

	/**
	 * Step to validate if email field is disabled in Account Information page
	 */
	@Step
	public void validates_If_Email_Field_Is_Disabled() {
		boolean b = validate_If_Email_Field_Is_Disabled();
		Assert.assertTrue("Email field is enabled!!!!!!!", b);
	}

	/**
	 * Method to validate if email field is disabled in Account Information page
	 */
	public boolean validate_If_Email_Field_Is_Disabled() {
		boolean b = accountInformationPage.emailAddress.isEnabled();
		slf4jLogger.info("-----------------Email field is disabled-------------- "+ !b);
		return !b;
	}

	/**
	 * Step to validate if same email is present for vacation Suspend order in Account Information page 
	 * @param emailAddress
	 */
	@Step
	public void validates_If_Email_Present_For_Vacation_Service_Order_With_Paperless_Billing(String emailAddress) {
		boolean b = validate_If_Email_Present_For_Vacation_Service_Order_With_Paperless_Billing(emailAddress);
		Assert.assertTrue("Email address is different than NI order's email!!!!!!!!!!", b);
	}

	/**
	 * Method to validate if same email is present for vacation Suspend order in Account Information page 
	 * @param emailAddress
	 */
	public boolean validate_If_Email_Present_For_Vacation_Service_Order_With_Paperless_Billing(String emailAddress) {
		WebDriverWait wait  = new WebDriverWait(getDriver(), 60);
		wait.until(ExpectedConditions.visibilityOf(accountInformationPage.txt_Vacation_Service_Email_Address));
		String actualEmailAddress = accountInformationPage.txt_Vacation_Service_Email_Address.getAttribute("value");
		boolean b = actualEmailAddress.equalsIgnoreCase(emailAddress);
		slf4jLogger.info("-----------------Email address is present-------------- "+ b+ "  "+actualEmailAddress);
		return b;
	}

	/**
	 * Step to check if email field for vacation suspend with paperless billing is editable 
	 */
	@Step
	public void validates_If_Email_Field_Is_Editable_For_Vacation_Service_Order_With_Paperless_Billing() {
		boolean b =validate_If_Email_Field_Is_Editable_For_Vacation_Service_Order_With_Paperless_Billing(); 
		Assert.assertTrue("Email address is NOT Editable!!!!!!!!!!", b);
	}

	/**
	 * Method to check if email field for vacation suspend with paperless billing is editable 
	 */
	public boolean validate_If_Email_Field_Is_Editable_For_Vacation_Service_Order_With_Paperless_Billing() {
		accountInformationPage.lbl_Vacation_Service_Paperless_Billing_Label.isEnabled();
		boolean b = accountInformationPage.txt_Vacation_Service_Email_Address.isEnabled();
		slf4jLogger.info("-----------------Email address is Editable-------------- "+ b);
		return b;
	}

	/**
	 * Step to Change email field for vacation suspend with paperless billing is editable 
	 */
	@Step
	public void changes_The_Email_Address_For_Vacation_Service_Order_With_Paperless_Billing(
			String changedEmailAddress) {

		change_The_Email_Address_For_Vacation_Service_Order_With_Paperless_Billing(changedEmailAddress);

	}

	/**
	 * Method to Change email field for vacation suspend with paperless billing is editable 
	 */
	public void change_The_Email_Address_For_Vacation_Service_Order_With_Paperless_Billing(
			String changedEmailAddress) {
		waitABit(1000);
		accountInformationPage.txt_Vacation_Service_Email_Address.type(changedEmailAddress);
		waitABit(1000);
		slf4jLogger.info("-----------------Email ID changed for Vacation Service order with paperless billing--------------");
	}

	/**
	 * Step to validate if Update or Review section is present in Account Information page
	 */
	@Step
	public void validates_If_Update_Or_Review_Billing_Address_Section_Is_Present() {
		validate_If_Update_Or_Review_Billing_Address_Section_Is_Present();
	}

	/**
	 * Method to validate if Update or Review section is present in Account Information page
	 */
	public void validate_If_Update_Or_Review_Billing_Address_Section_Is_Present() {
		accountInformationPage.lbl_Vacation_Service_Update_Or_Review_Billing_Address_Label.shouldBePresent();
		accountInformationPage.radio_Vacation_Service_New_Address.shouldBePresent();
		accountInformationPage.radio_Vacation_Service_Current_Billing_Address.shouldBePresent();
		slf4jLogger.info("-----------------Update or Review section is validated in Account Information page--------------");
	}

	/**
	 * Step to click on Continue button on vacation suspend order in Account Information Page
	 */
	@Step
	public void clicks_On_Continue_Button_For_Vacation_Service_Order_In_Account_Information_Page() {
		click_On_Continue_Button_For_Vacation_Service_Order_In_Account_Information_Page();
	}

	/**
	 * Method to click on Continue button on vacation Service order in Account Information Page
	 */
	public void click_On_Continue_Button_For_Vacation_Service_Order_In_Account_Information_Page() {
		accountInformationPage.clickContinueAccInfo.click();
		slf4jLogger.info("----------------Continue button clicked on vacation suspend order in Account Information Page---------------");
	}

	/**
	 * Step to select Current Billing Address in Account Information page
	 */
	@Step
	public void selects_Current_Billing_Address() {
		select_Current_Billing_Address();
	}

	/**
	 * Method to select Current Billing Address in Account Information page
	 */
	public void select_Current_Billing_Address() {
		accountInformationPage.radio_Vacation_Service_Current_Billing_Address.click();
		slf4jLogger.info("----------------Current Billing Address in Account Information page selected---------------");
	}

	/**
	 * Step to validate if user gets an option of paperless billing when no mail is provided during NI order
	 */
	@Step
	public void validates_Options_To_Switch_To_Paperless_Billing() {
		validate_Options_To_Switch_To_Paperless_Billing();
	}

	/**
	 * Method to validate if user gets an option of paperless billing when no mail is provided during NI order
	 */
	public void validate_Options_To_Switch_To_Paperless_Billing() {
		accountInformationPage.radio_No_Mail_My_Bill.shouldBePresent();
		accountInformationPage.radio_Yes_Setup_Paperless_Billing.shouldBePresent();
		accountInformationPage.txt_Vacation_Service_Email_Address.shouldBePresent();
		slf4jLogger.info("----------------Paperless billing option validated for No mail---------------");
	}

	/**
	 * Step to validate is Yes Setup paperless billing is selected by default
	 */
	@Step
	public void validates_If_Yes_Setup_Paperless_Billing_Is_Selected_By_Default() {
		boolean b = validate_If_Yes_Setup_Paperless_Billing_Is_Selected_By_Default();
		Assert.assertTrue("Yes, Setup paperless billing is NOT selected by default!!!!!!", b);
	}

	/**
	 * Method to validate is Yes Setup paperless billing is selected by default
	 */
	public boolean validate_If_Yes_Setup_Paperless_Billing_Is_Selected_By_Default() {
		boolean b = accountInformationPage.radio_Yes_Setup_Paperless_Billing.isSelected();
		slf4jLogger.info("----------------Yes Steup Paperless billing option is selected by default---------------  "+ b);
		return b;
	}

	/**
	 * Method to check if email field for vacation suspend with paperless billing is editable 
	 */
	public boolean validate_If_Email_Field_Is_Editable_For_Vacation_Service_Order_Without_Paperless_Billing() {
		boolean b = accountInformationPage.txt_Vacation_Service_Email_Address.isEnabled();
		slf4jLogger.info("-----------------Email address is Editable-------------- "+ b);
		return b;
	}

	/**
	 * Step to check if email field for vacation suspend with paperless billing is editable 
	 */
	@Step
	public void validates_If_Email_Field_Is_Editable_For_Vacation_Service_Order_Without_Paperless_Billing() {
		boolean b = validate_If_Email_Field_Is_Editable_For_Vacation_Service_Order_Without_Paperless_Billing();
		Assert.assertTrue("Email address is NOT Editable without paperless billing!!!!!!!!!!", b);
	}

	/**
	 * Step to Change email field for vacation suspend without paperless billing is editable 
	 */
	@Step
	public void changes_The_Email_Address_For_Vacation_Service_Order_Without_Paperless_Billing(
			String changedEmailAddress) {

		change_The_Email_Address_For_Vacation_Service_Order_With_Paperless_Billing(changedEmailAddress);

	}

	/**
	 * Method to Change email field for vacation suspend without paperless billing is editable 
	 */
	public void change_The_Email_Address_For_Vacation_Suspend_Order_Without_Paperless_Billing(
			String changedEmailAddress) {
		waitABit(1000);
		accountInformationPage.txt_Vacation_Service_Email_Address.type(changedEmailAddress);
		waitABit(1000);
		slf4jLogger.info("-----------------Email ID changed for Vacation suspend order without paperless billing--------------");
	}

	/**
	 * Step to select No, Mail my bill option in account information page
	 */
	@Step
	public void selects_No_Mail_My_Bill_Option() {
		select_No_Mail_My_Bill_Option();
	}

	/**
	 * Method to select No, Mail my bill option in account information page
	 */
	public void select_No_Mail_My_Bill_Option() {
		accountInformationPage.radio_No_Mail_My_Bill.click();
		slf4jLogger.info("-----------------NO, Mail my bill optio is selected--------------");
	}

	// AC42889 starts
	@Step
	public void clickonChangeBillingAddress() {
		accountInformationPage.changeBillingAddress.click();
		slf4jLogger.info("clicked on Chnage Billing Address link in account information page");
	}
	@Step
	public void clickonDifferentBillingAddress() {
		accountInformationPage.differentBillingAddress.click();
		slf4jLogger.info("clicked on Different Billing Address radio button in account information page");
		waitABit(40000);
	}
	@Step
	public void clickonCurrentBillingAddress() {
		accountInformationPage.currentBillingAddress.click();
		slf4jLogger.info("clicked on current Billing Address radio button in account information page");
		waitABit(20000);
	}
	@Step
	public void clickonNewServiceAddress() {
		accountInformationPage.newSeviceAddress.click();
		slf4jLogger.info("clicked on new Service Address radio button in account information page");
	}
	@Step
	public void enter_new_address(String street, String state, String City, String zip){
		waitABit(3000);
		accountInformationPage.txt_street.clear();
		accountInformationPage.txt_street.sendKeys(street);
		accountInformationPage.ddl_state.selectByVisibleText(state);
		accountInformationPage.txt_city.clear();
		accountInformationPage.txt_city.sendKeys(City);
		accountInformationPage.txt_zipCode.clear();
		accountInformationPage.txt_zipCode.sendKeys(zip);
		slf4jLogger.info("Entered address");
		waitABit(2000);
		accountInformationPage.btn_validate.click();
		slf4jLogger.info("validated address");    
	} 
	@Step
	public void validatePostalAddress(){
		waitABit(10000);
		if(accountInformationPage.postalAddressValidation.isCurrentlyVisible()){
			slf4jLogger.info("postal address validation is successful");
		}
	}	
	@Step
	public void clickOnSaveBillingAddress(){
		waitABit(10000);
		accountInformationPage.btn_saveBillingAddress.click();
		slf4jLogger.info("cliked on save billing address");
	}

	@Step
	public void selectBypassvalidation() {
		waitABit(10000);
		if (accountInformationPage.rbtn_BypasValidation.isCurrentlyVisible()) {
			accountInformationPage.rbtn_BypasValidation.click();
		}else if (!accountInformationPage.rbtn_BypasValidation.isCurrentlyVisible()){
			slf4jLogger.info("Bypass validation is not available for this address");
		}
		waitABit(20000);
	}


	// AC42889 ends

	/*      AC43057
	 * ----- method to Authorized User on accnt info page
	 */



	/*public void addorchangeAuthorizedUser(){
		addAuthorizedUser(null, null, null);
	}*/

	@Step

	public void clickOnAddChangebtn(){
		waitABit(2000);
		accountInformationPage.click_add.click();
		slf4jLogger.info("cliked on add Auth User");
	}

	@Step

	public void addAuthorizedUser(String firstname, String lastname , String contact){
		waitABit(5000);
		accountInformationPage.box_fn.clear();
		accountInformationPage.box_fn.sendKeys(firstname);
		accountInformationPage.box_Ln.clear();
		accountInformationPage.box_Ln.sendKeys(lastname);
		accountInformationPage.box_cntct.clear();
		accountInformationPage.box_cntct.sendKeys(contact);
		accountInformationPage.btn_save.click();

		slf4jLogger.info("Authorized User is added");	
	}
	
	@Step
	public void clickContinueAccountInforMACDOrders(){
		waitABit(30000);
		accountInformationPage.ContinueAccountInfomation.click();
        slf4jLogger.info("Clicked on Continue on Account Information in Pending Orders");
	}
	
	@Step
	public void enter_email(String email)
	{
		accountInformationPage.email.clear();
		accountInformationPage.email.sendKeys(email);
	}
	
	@Step
	public void add_first_authorized_parties(String firstname,String lastname,String phone)
	{
		accountInformationPage.addOrChange.click();
		accountInformationPage.firstAuthFirstName.sendKeys(firstname);
		waitABit(1000);
		accountInformationPage.firstAuthLastName.sendKeys(lastname);
		waitABit(1000);
		accountInformationPage.firstAuthPhone.sendKeys(phone);
		waitABit(1000);
		slf4jLogger.info("Entered First Name: " +firstname+ " First Last Name: " +lastname+ " and First Phone Number: " +phone);
	}
	
	@Step
	public void add_second_authorized_parties(String firstname,String lastname,String phone)
	{
		waitABit(5000);
		accountInformationPage.secondAuthFirstName.sendKeys(firstname);
		waitABit(1000);
		accountInformationPage.secondAuthLastName.sendKeys(lastname);
		waitABit(1000);
		accountInformationPage.secondAuthPhone.sendKeys(phone);
		waitABit(1000);
		slf4jLogger.info("Entered Second Name: " +firstname+ " Second Last Name: " +lastname+ " and Second Phone Number" +phone);
	}
	
	
	@Step
	public void clickSaveUpdates()
	{
		waitABit(2000);
		accountInformationPage.saveUpdates.waitUntilClickable();
		accountInformationPage.saveUpdates.click();
		waitABit(1000);
		slf4jLogger.info("Clicked on Save Updated button");
		
	}
	

}
