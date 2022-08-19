package com.ctl.it.qa.eshop.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.Assert;
import com.ctl.it.qa.eshop.pages.CustomerDetailsPage;
import com.ctl.it.qa.eshop.pages.VacationSuspendPage;
import com.ctl.it.qa.staf.Steps;

import net.thucydides.core.annotations.Step;

@SuppressWarnings("serial")
public class VacationSuspendSteps extends Steps {

	private final Logger slf4jLogger = LoggerFactory.getLogger(VacationSuspendSteps.class);
	VacationSuspendPage vacationSuspendPage;

	/**
	 * Step to select Vacation Service option
	 */
	@Step
	public void selects_Vacation_Service() {
		select_Vacation_Service();
	}

	/**
	 * Method to select Vacation Service option
	 */
	public void select_Vacation_Service() {
		WebDriverWait wait = new WebDriverWait(getDriver(), 100);
		wait.until(ExpectedConditions.visibilityOf(vacationSuspendPage.ddl_Other_Order_Activities));
		vacationSuspendPage.ddl_Other_Order_Activities.click();
		vacationSuspendPage.link_Vacation_Service.click();
		slf4jLogger.info("-----------Vacation Service Selcted--------------------");
	}

	/**
	 * Step to select Vacation Suspend option from Vacation Service dialog box
	 * for HSI
	 */
	@Step
	public void selects_Vacation_Suspend_For_HSI() {
		select_Vacation_Suspend_For_HSI();
	}

	/**
	 * Method to select Vacation Suspend option from Vacation Service dialog box
	 * for HSI
	 */
	public void select_Vacation_Suspend_For_HSI() {
		WebDriverWait wait = new WebDriverWait(getDriver(), 60);
		wait.until(ExpectedConditions.visibilityOf(vacationSuspendPage.ddl_Vacation_Service_Selection_HSI));
		Select select = new Select(vacationSuspendPage.ddl_Vacation_Service_Selection_HSI);
		select.selectByVisibleText("Vacation Suspend");
		slf4jLogger.info("-----------Vacation Suspend Selected for HSI--------------------");
	}

	/**
	 * Method to click on Continue button in vacation service dialog box
	 */
	public void click_On_Continue_Button_In_Vacation_Service_Dialog_Box() {
		WebDriverWait wait = new WebDriverWait(getDriver(), 60);
		wait.until(ExpectedConditions.visibilityOf(vacationSuspendPage.btn_Vacation_Service_Continue));
		vacationSuspendPage.btn_Vacation_Service_Continue.click();
		slf4jLogger.info("-----------Continue button on Vacation Service dialog box clicked--------------------");
	}

	/**
	 * Step to click on Continue button in vacation service dialog box
	 */
	@Step
	public void clicks_On_Continue_Button_In_Vacation_Service_Dialog_Box() {
		click_On_Continue_Button_In_Vacation_Service_Dialog_Box();
	}

	/**
	 * Step to handle the Order Disclosures pop up whenever they pop up for HSI
	 */
	@Step
	public void handles_Order_Disclosures_For_Vacation_Suspend_For_HSI() {
		handle_Order_Disclosures_For_Vacation_Suspend_For_HSI();
	}

	/**
	 * Method to handle the Order Disclosures pop up whenever they pop up for
	 * HSI
	 */
	public void handle_Order_Disclosures_For_Vacation_Suspend_For_HSI() {

		if (vacationSuspendPage.lbl_Order_Disclosures_Vacation_Suspend.isPresent()) {
			vacationSuspendPage.btn_Order_Disclosures_Vacation_Suspend_OK_Got_It.click();
			slf4jLogger.info(
					"-----------OK Got it button clicked in Order Disclosures Tab for Vacation Suspend--------------------");
		} else {
			slf4jLogger
					.info("-----------Order Disclosures Tab is not present for Vacation Suspend--------------------");
		}

	}

	/**
	 * Step to select Vacation Suspend option from Vacation Service dialog box
	 * for HSI
	 */
	@Step
	public void selects_Vacation_Suspend_For_POTS() {
		select_Vacation_Suspend_For_POTS();
	}

	/**
	 * Method to select Vacation Suspend option from Vacation Service dialog box
	 * for HSI
	 */
	public void select_Vacation_Suspend_For_POTS() {
		WebDriverWait wait = new WebDriverWait(getDriver(), 60);
		wait.until(ExpectedConditions.visibilityOf(vacationSuspendPage.ddl_Vacation_Service_Selection_POTS));
		Select select = new Select(vacationSuspendPage.ddl_Vacation_Service_Selection_POTS);
		select.selectByVisibleText("Vacation Suspend");
		slf4jLogger.info("-----------Vacation Suspend Selected for POTS--------------------");
	}

	/**
	 * Step to validate the default value of product dropdown in Vacation
	 * Service dialog box
	 * 
	 * @param service
	 */
	@Step
	public void validates_Default_Value_Of_Product_Dropdown(String service) {
		boolean b = validate_Default_Value_Of_Product_Dropdown(service);
		Assert.assertTrue("Default value is incorrect!!!!!!!!", b);
	}

	/**
	 * Method to validate the default value of product drop down in Vacation
	 * Service dialog box
	 * 
	 * @param service
	 */
	public boolean validate_Default_Value_Of_Product_Dropdown(String service) {
		WebDriverWait wait = new WebDriverWait(getDriver(), 60);
		wait.until(ExpectedConditions.visibilityOf(vacationSuspendPage.ddl_Vacation_Service_Selection_POTS));
		Select select = new Select(vacationSuspendPage.ddl_Vacation_Service_Selection_POTS);
		String actualDefaultValue = select.getFirstSelectedOption().getText();
		boolean b = actualDefaultValue.equalsIgnoreCase(service);
		slf4jLogger.info("-----------Default Value for POTS is " + actualDefaultValue + "-------------------- " + b);
		return b;
	}

	/**
	 * Step to validate if continue button is disabled
	 */
	@Step
	public void validates_If_Continue_Button_Is_Disabled() {
		boolean b = validate_If_Continue_Button_Is_Disabled();
		Assert.assertTrue("Continue button is enabled!!!!!!", b);
	}

	/**
	 * Method to validate if continue button is disabled
	 */
	public boolean validate_If_Continue_Button_Is_Disabled() {
		boolean b = vacationSuspendPage.btn_Vacation_Service_Continue.isEnabled();
		slf4jLogger.info("-----------Continue button is disabled --------------------  " + !b);
		return !b;
	}

	/**
	 * Step to validate the default value of Vacation options tab > referral
	 * message
	 * 
	 * @param value
	 */
	@Step
	public void validates_Default_Value_Of_Referal_Message_Dropdown(String value) {
		boolean b = validate_Default_Value_Of_Referal_Message_Dropdown(value);
		Assert.assertTrue("Default value of Referal Message is incorrect!!!!!!", b);
	}

	/**
	 * Method to validate the default value of Vacation options tab > referral
	 * message
	 * 
	 * @param value
	 */
	public boolean validate_Default_Value_Of_Referal_Message_Dropdown(String value) {
		WebDriverWait wait = new WebDriverWait(getDriver(), 60);
		wait.until(ExpectedConditions.visibilityOf(vacationSuspendPage.ddl_Vacation_Options_POTS_Callers_Will_Hear));
		waitABit(5000);
		Select select = new Select(vacationSuspendPage.ddl_Vacation_Options_POTS_Callers_Will_Hear);
		String actualDefaultValue = select.getFirstSelectedOption().getText();
		boolean b = actualDefaultValue.trim().equalsIgnoreCase(value);
		slf4jLogger.info(
				"-----------Default Value for Referal Message is " + actualDefaultValue + "-------------------- " + b);
		return b;
	}

	/**
	 * Step to expand the shopping cart for Vacation Service
	 */
	@Step
	public void expands_The_Shopping_Cart_For_Vacation_Service() {
		expand_The_Shopping_Cart_For_Vacation_Service();
	}

	/**
	 * Method to expand the shopping cart for Vacation Service
	 */
	public void expand_The_Shopping_Cart_For_Vacation_Service() {
		vacationSuspendPage.btn_Vacation_Service_Shopping_Cart.click();
		slf4jLogger.info("---------------Shopping Cart expanded for Vacation Service---------------- ");
	}

	/**
	 * Step to validate the vacation discount in shopping cart for Vacation
	 * Service for POTS order
	 * 
	 * @param vacationDiscount
	 */
	@Step
	public void validates_Vacation_Discount_For_POTS(String vacationDiscount) {
		boolean b = validate_Vacation_Discount_For_POTS(vacationDiscount);
		Assert.assertTrue("Vacation Discount is not correct for POTS!!!!!!!!!!!", b);
	}

	/**
	 * Method to validate the vacation discount in shopping cart for Vacation
	 * Service for POTS order
	 * 
	 * @param vacationDiscount
	 */
	public boolean validate_Vacation_Discount_For_POTS(String vacationDiscount) {
		String s1 = "//*[contains(text(),'Home Phone Details')]//parent::div//*[contains(text(),'";
		String s2 = "')]";
		WebElement ele = getDriver().findElement(By.xpath(s1 + vacationDiscount + s2));
		WebDriverWait wait = new WebDriverWait(getDriver(), 60);
		wait.until(ExpectedConditions.visibilityOf(ele));
		String actualVacationDiscount = ele.getText();
		boolean b = actualVacationDiscount.equalsIgnoreCase(vacationDiscount);
		slf4jLogger.info(
				"-----------Vacation Discount for POTS is " + actualVacationDiscount + "-------------------- " + b);
		return b;
	}

	/**
	 * Step to select vacation suspend for all services
	 */
	@Step
	public void selects_Vacation_Suspend_For_All_Services() {
		select_Vacation_Suspend_For_All_Services();
	}

	/**
	 * Method to select vacation suspend for all services
	 */
	@Step
	public void select_Vacation_Suspend_For_All_Services() {
		WebDriverWait wait = new WebDriverWait(getDriver(), 60);
		wait.until(ExpectedConditions.visibilityOf(vacationSuspendPage.btn_Vacation_Service_Add_To_All));
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].click();", vacationSuspendPage.btn_Vacation_Service_Add_To_All);
		// vacationSuspendPage.btn_Vacation_Service_Add_To_All.click();
		slf4jLogger.info("-----------Vacation Suspend selected for all services");
	}

	/**
	 * Step to validate the vacation discount in shopping cart for Vacation
	 * Service for HSI order
	 * 
	 * @param vacationDiscount
	 */
	@Step
	public void validates_Vacation_Discount_For_HSI(String vacationDiscount) {
		boolean b = validate_Vacation_Discount_For_HSI(vacationDiscount);
		Assert.assertTrue("Vacation Discount is not correct for HSI!!!!!!!!!!!", b);
	}

	/**
	 * Method to validate the vacation discount in shopping cart for Vacation
	 * Service for HSI order
	 * 
	 * @param vacationDiscount
	 */
	public boolean validate_Vacation_Discount_For_HSI(String vacationDiscount) {
		String s1 = "//*[contains(text(),'Internet Details')]//parent::div//*[contains(text(),'";
		String s2 = "')]";
		WebElement ele = getDriver().findElement(By.xpath(s1 + vacationDiscount + s2));
		WebDriverWait wait = new WebDriverWait(getDriver(), 60);
		wait.until(ExpectedConditions.visibilityOf(ele));
		String actualVacationDiscount = ele.getText();
		boolean b = actualVacationDiscount.equalsIgnoreCase(vacationDiscount);
		slf4jLogger.info(
				"-----------Vacation Discount for HSI is " + actualVacationDiscount + "-------------------- " + b);
		return b;
	}

	/**
	 * Step to validate the default value of product dropdown in Vacation
	 * Service dialog box
	 * 
	 * @param service
	 */
	@Step
	public void validates_Default_Value_Of_Product_Dropdown_HSI(String service) {
		boolean b = validate_Default_Value_Of_Product_Dropdown_HSI(service);
		Assert.assertTrue("Default value is incorrect!!!!!!!!", b);
	}

	/**
	 * Method to validate the default value of product drop down in Vacation
	 * Service dialog box
	 * 
	 * @param service
	 */
	public boolean validate_Default_Value_Of_Product_Dropdown_HSI(String service) {
		WebDriverWait wait = new WebDriverWait(getDriver(), 60);
		wait.until(ExpectedConditions.visibilityOf(vacationSuspendPage.ddl_Vacation_Service_Selection_HSI));
		Select select = new Select(vacationSuspendPage.ddl_Vacation_Service_Selection_HSI);
		String actualDefaultValue = select.getFirstSelectedOption().getText();
		boolean b = actualDefaultValue.equalsIgnoreCase(service);
		slf4jLogger.info("-----------Default Value for HSI is " + actualDefaultValue + "-------------------- " + b);
		return b;
	}

	/**
	 * Step to validate the dialog box and message for unavailability of
	 * Vacation Service due to location
	 */
	@Step
	public void validates_The_Message_For_Vacation_Service_Unavailability_For_A_Location() {
		boolean b = validate_The_Message_For_Vacation_Service_Unavailability_For_A_Location();
		Assert.assertTrue("Vacation Service unavailability for location is NOT correct!!!!!!", b);
	}

	/**
	 * Method to validate the dialog box and message for unavailability of
	 * Vacation Service due to location
	 */
	public boolean validate_The_Message_For_Vacation_Service_Unavailability_For_A_Location() {
		String expectedHeaderMessage = "Vacation Service cannot be provided";
		String expectedVacationServiceUnavailabeMessage = "Vacation Services not available in this location";
		WebDriverWait wait = new WebDriverWait(getDriver(), 60);
		wait.until(ExpectedConditions.visibilityOf(vacationSuspendPage.lbl_Vacation_Service_Unavailable_Header));
		String actualHeaderMessage = vacationSuspendPage.lbl_Vacation_Service_Unavailable_Header.getText();
		slf4jLogger.info("-----------Actual message for Vacation Service unavailable message header is  "
				+ actualHeaderMessage + "-------------------- ");
		String actualVacationServiceUnavailabeMessage = vacationSuspendPage.lbl_Vacation_Service_Unavailable_Due_To_Location
				.getText();
		slf4jLogger.info("-----------Actual message for Vacation Service unavailability for location is  "
				+ actualVacationServiceUnavailabeMessage + "-------------------- ");
		boolean b = (actualHeaderMessage.contains(expectedHeaderMessage))
				& (actualVacationServiceUnavailabeMessage.contains(expectedVacationServiceUnavailabeMessage));
		return b;
	}

	/**
	 * Step to validate the dialog box and message for unavailability of
	 * Vacation Service due to Account prerequistes
	 */
	@Step
	public void validates_The_Message_For_Vacation_Service_Unavailability_For_An_Account() {
		boolean b = validate_The_Message_For_Vacation_Service_Unavailability_For_An_Account();
		Assert.assertTrue("Vacation Service unavailability for Account is NOT correct!!!!!!", b);
	}

	/**
	 * Method to validate the dialog box and message for unavailability of
	 * Vacation Service due to Account prerequisites
	 */
	public boolean validate_The_Message_For_Vacation_Service_Unavailability_For_An_Account() {
		String expectedHeaderMessage = "Vacation Service cannot be provided";
		String expectedVacationServiceUnavailabeMessageForAccount = "";
		WebDriverWait wait = new WebDriverWait(getDriver(), 60);
		wait.until(ExpectedConditions.visibilityOf(vacationSuspendPage.lbl_Vacation_Service_Unavailable_Header));
		String actualHeaderMessage = vacationSuspendPage.lbl_Vacation_Service_Unavailable_Header.getText();
		slf4jLogger.info("-----------Actual message for Vacation Service unavailable message header is  "
				+ actualHeaderMessage + "-------------------- ");
		String actualVacationServiceUnavailabeMessage = vacationSuspendPage.lbl_Vacation_Service_Unavailable_Due_To_Account
				.getText();
		slf4jLogger.info("-----------Actual message for Vacation Service unavailability for Account is  "
				+ actualVacationServiceUnavailabeMessage + "-------------------- ");
		boolean b = (actualHeaderMessage.contains(expectedHeaderMessage))
				& (actualVacationServiceUnavailabeMessage.contains(expectedVacationServiceUnavailabeMessageForAccount));
		return b;
	}

	/*
	 * ac43057 Method to click on "Ok,got it button"
	 */

	/*
	 * / Step to click on ok on Order Disclosure page
	 */

	@Step
	public void click_on_order_disclosure_page() {
		click_ok_on_Order_Disclosure_pop_up();
	}

	/*
	 * / Method to click on Ok button for order disclosure page
	 */

	public void click_ok_on_Order_Disclosure_pop_up() {
		WebDriverWait wait = new WebDriverWait(getDriver(), 60);
		wait.until(ExpectedConditions.visibilityOf(vacationSuspendPage.ok_button));
		waitABit(2000);
		vacationSuspendPage.ok_button.click();
		slf4jLogger.info("---Continue button on Order Disclosure page------");

	}
	/*
	 * / Step to click on continue button on product and services page
	 */

	@Step
	public void click_continue_on_productservices() {
		click_continue_product_and_services();
	}

	public void click_continue_product_and_services() {
		WebDriverWait wait = new WebDriverWait(getDriver(), 60);
		wait.until(ExpectedConditions.visibilityOf(vacationSuspendPage.btn_vacation_productservice_continue));
		waitABit(2000);
		vacationSuspendPage.btn_vacation_productservice_continue.click();
		slf4jLogger.info("-----------Continue button on product and Service dialog box clicked--------------------");
	}

	/*
	 * /
	 * 
	 * Method to click close for performing Move on vacation suspend
	 * order----Anuradha
	 * 
	 * Method to click close for performing Move on vacation suspend order
	 * 
	 */

	@Step
	public void click_close_on_cannot_perform_move() {
		click_close_on_cannot_performMove();

	}

	public void click_close_on_cannot_performMove() {
		WebDriverWait wait = new WebDriverWait(getDriver(), 60);
		wait.until(ExpectedConditions.visibilityOf(vacationSuspendPage.btn_close_move_vactnsuspnd));
		vacationSuspendPage.btn_close_move_vactnsuspnd.click();
		slf4jLogger.info("-----------Error pop-up for move performance on vacation suspend order is--------");
		waitABit(2000);
		String actualMsg = vacationSuspendPage.btn_close_move_vactnsuspnd.getText();
		waitABit(2000);
		slf4jLogger.info("---Close button on Move------" + actualMsg + "---------");

	}

	@Step
	public void validate_error_message_for_chg() {
		validate_error_message_for_chg_on_vacsus();

	}

	public void validate_error_message_for_chg_on_vacsus() {
		waitABit(30000);
		/*
		 * WebElement loading_img =
		 * getDriver().findElement(By.xpath("//img[@src='/img/loading.gif']"));
		 * WebDriverWait wait = new WebDriverWait(getDriver(), 60);
		 * wait.until(ExpectedConditions.invisibilityOf(loading_img));
		 */
		waitABit(30000);
		String actualMsg = vacationSuspendPage.err_msg_vacsus_on_chg.getText();
		slf4jLogger.info(
				"---Error message on performing chg on vacation suspend order is------" + actualMsg + "----------");

	}

	/*
	 * private void click_close_on_cannot_performMove() { WebDriverWait wait =
	 * new WebDriverWait(getDriver(), 60);
	 * wait.until(ExpectedConditions.visibilityOf(vacationSuspendPage.
	 * btn_close_move_vactnsuspnd));
	 * vacationSuspendPage.btn_close_move_vactnsuspnd.click(); slf4jLogger.
	 * info("-----------Error pop-up for move performance on vacation suspend order--------------------"
	 * );
	 * 
	 * 
	 * }
	 */

	// ac42889
	@Step
	public void i_validate_warning_message() {
		validate_warning_message();
	}

	public void validate_warning_message() {

		String ActualMsg = vacationSuspendPage.msg_warningDailogbox.getText();
		String ExpectedMsg = "When Internet line is not active, it will affect all devices & services in the residence that use that Wired or WiFi connection.";
		Assert.assertEquals(ActualMsg, ExpectedMsg);
		slf4jLogger.info("-----------Validated warning message----------");

	}

	public void enter_new_address(String street, String state, String City, String zip) {
		waitABit(5000);
		vacationSuspendPage.txt_street.sendKeys(street);
		vacationSuspendPage.ddl_state.selectByVisibleText(state);
		vacationSuspendPage.txt_city.sendKeys(City);
		vacationSuspendPage.txt_zipCode.sendKeys(zip);
		slf4jLogger.info("Entered address");
		waitABit(3000);
		vacationSuspendPage.btn_validate.click();
		slf4jLogger.info("validated address");

	}

	// ac42889

	// ac41685
	public void click_on_Current_Billing_address_radio_button() {

		vacationSuspendPage.Billing_address_rButton.click();
	}

	public void enter_mail_id(String email) {
		vacationSuspendPage.email_address.type(email);
	}

	public void verify_mail_id(String mailId) {

		// String s=vacationSuspendPage.email_address.type(mailId);

		waitABit(5000);
		String actuallemail = vacationSuspendPage.verifyMailId.getText();

		if (actuallemail.contains(mailId)) {

			slf4jLogger.info("-----------Mail id verified AND SUCCESS-------------------");

		}

		else {
			slf4jLogger.info("-----------Mail id Not matching --------------------");

		}

	}

	////ac50097
	public void selects_Vacation_Suspend() {

		WebDriverWait wait = new WebDriverWait(getDriver(), 60);
		wait.until(ExpectedConditions.visibilityOf(vacationSuspendPage.selects_Vacation_Suspend));
		vacationSuspendPage.selects_Vacation_Suspend.click();
		vacationSuspendPage.selects_Vacation_Suspend.selectByVisibleText("Vacation Suspend");

	}

	// ac41685

}
