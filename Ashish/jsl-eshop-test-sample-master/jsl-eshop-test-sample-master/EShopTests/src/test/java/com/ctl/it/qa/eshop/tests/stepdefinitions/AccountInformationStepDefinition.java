package com.ctl.it.qa.eshop.tests.stepdefinitions;

import com.ctl.it.qa.eshop.steps.AccountInformationSteps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class AccountInformationStepDefinition {

	@Steps
	AccountInformationSteps accountInformationSteps;

	@Given("^I decline customer email$")
	public void i_decline_customer_email() throws Throwable {
		accountInformationSteps.emailDeclineClick();
	}

	@Then("^I enter date \"([^\"]*)\" month \"([^\"]*)\" and year \"([^\"]*)\" of birth$")
	public void i_enter_date_month_and_year_of_birth(String date, String month, String year) throws Throwable {
		accountInformationSteps.dateOfBirth(date, month, year);
	}

	@Then("^I enter SSN number \"([^\"]*)\"$")
	public void i_enter_SSN_number(String ssn) throws Throwable {
		accountInformationSteps.ssnDetails(ssn);
	}

	@When("^I select credit as \"([^\\\"]*)\"$")
	public void i_select_credit_as(String args) throws Throwable {
		accountInformationSteps.creditCheck(args);
	}

	@When("^I click on account Continue button$")
	public void i_click_on_account_Continue_button() throws Throwable {
		accountInformationSteps.clickAccountInfoContinue();
	}

	@When("^I click again click Continue button on account$")
	public void i_click_again_click_Continue_button_on_account() throws Throwable {
		accountInformationSteps.clickAgainAfterPaymentAccountInfoContinue();
	}

	@And("^I click on payNow$")
	public void i_click_on_payNow1() throws Throwable {
		accountInformationSteps.payNowCredit();
	}

	@And("^I verify age is less than 18$")
	public void i_verify_age_less() throws Throwable {
		accountInformationSteps.verifyage();
	}
	//Nitish Pots
	@Then("^I enter \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_enter_and(String smsno, String emailid) throws Throwable {
		accountInformationSteps.i_enter_email_and_sms_contacts(smsno,emailid);
	}

	/*
	 * Abhinav
	 */

	@When("^I click on account Continue button and wait for the popup$")
	public void i_click_on_account_Continue_button_and_wait_for_the_popup() throws Exception {
		accountInformationSteps.click_Account_Info_Continue_And_Wait_For_Popup();
	}

	@Then("^I validate the Credit Information popup for \"([^\"]*)\", \"([^\"]*)\",\"([^\"]*)\" month \"([^\"]*)\" and year \"([^\"]*)\" of birth and \"([^\"]*)\"$")
	public void i_validate_the_Credit_Information_popup_for_month_and_year_of_birth_and(String firstName, String lastName, String Date, String Month, String Year, String SSN) throws Exception {
		accountInformationSteps.vaidates_Credit_Information_Popup( firstName, lastName, Date, Month, Year, SSN);
	}

	@Then("^I click on Yes, it is correct$")
	public void i_click_on_Yes_it_is_correct() throws Exception {
		accountInformationSteps.clicks_On_Yes_It_Is_Correct();
	}

	@Then("^I validate if the Update Application link is enabled$")
	public void i_validate_if_the_Update_Application_link_is_enabled() throws Exception {
		accountInformationSteps.validates_if_the_Update_Application_link_is_enabled();
	}

	@When("^I perform the credit check (\\d+) times$")
	public void i_perform_the_credit_check_times(int creditCheckTimes) throws Exception {
		accountInformationSteps.performs_Credit_Checks(creditCheckTimes);
	}

	@Then("^I validate the Update Application to be disabled$")
	public void i_validate_the_Update_Application_to_be_disabled() throws Exception {
		accountInformationSteps.validates_if_the_Update_Application_link_is_Disabled();
	}


	@When("^I click on Back Button and again go back to the same Page to check the Update Application link$")
	public void i_click_on_Back_Button_and_again_go_back_to_the_same_Page_to_check_the_Update_Application_link() throws Exception {
		accountInformationSteps.clicks_On_Back_Button();
	}

	@When("^I click on Place on Hold button to put the order on Hold$")
	public void i_click_on_Place_on_Hold_button_to_put_the_order_on_Hold() throws Exception {
		accountInformationSteps.clicks_On_Place_On_Hold_Button();
	}

	@Then("^I should be able to select \"([^\"]*)\" and give \"([^\"]*)\"$")
	public void i_should_be_able_to_select_and_give(String onHoldReason, String additionalNotes) throws Exception {
		accountInformationSteps.selects_And_Give_Place_On_Hold_details(onHoldReason, additionalNotes);
	}

	@Then("^I take the ORN for On Hold order$")
	public void i_take_the_ORN_for_On_Hold_order() throws Exception {
		accountInformationSteps.gets_ORN_From_On_Hold_Order();
	}

	@Then("^I click on Start new Order$")
	public void i_click_on_Start_new_Order() throws Exception {
		accountInformationSteps.starts_New_Order_After_Hold();
	}

	@Then("^I validate if \"([^\"]*)\" is same as entered in SFC$")
	public void i_validate_if_is_same_as_entered_in_SFC(String emailAddress) throws Exception {
		accountInformationSteps.validates_The_Email_From_SFC(emailAddress);
	}

	@Then("^I validate if paperless billing is selected by default$")
	public void i_validate_if_paperless_billing_is_selected_by_default() throws Exception {
		accountInformationSteps.validates_If_Paperless_Billing_Is_Selected_By_Default();
	}

	@Then("^I Validate if Mail my Bill is deselected$")
	public void i_Validate_if_Mail_my_Bill_is_deselected() throws Exception {
		accountInformationSteps.validates_If_Mail_My_Bill_Is_Deselected();
	}

	@Then("^I select the Mail my Bill option$")
	public void i_select_the_Mail_my_Bill_option() throws Exception {
		accountInformationSteps.selects_Mail_My_Bill_Option();
	}


	@When("^I change the \"([^\"]*)\" ID and change the focus from email id field$")
	public void i_change_the_ID_and_change_the_focus_from_email_id_field(String emailAddress) throws Exception {
		accountInformationSteps.changes_Email_Id(emailAddress);
		accountInformationSteps.changes_Focus_From_Email_Field();
	}

	@Then("^I validate if \"([^\"]*)\" is selected as default special format$")
	public void i_validate_if_is_selected_as_default_special_format(String specialFormat) throws Exception {
		accountInformationSteps.validates_Default_Special_Format(specialFormat);
	}

	@Then("^I validate if Special format contains \"([^\"]*)\" ,\"([^\"]*)\", \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_validate_if_Special_format_contains_and(String none, String braille, String large, String spanish) throws Exception {
		accountInformationSteps.validates_Special_Format_Values(none,braille,large,spanish);
	}

	@Then("^I select special format as \"([^\"]*)\"$")
	public void i_select_special_format_as(String specialFormat) throws Exception {
		accountInformationSteps.selects_Special_Format(specialFormat);
	}

	@When("^I select Paperless billing option$")
	public void i_select_Paperless_billing_option() throws Exception {
		accountInformationSteps.selects_Paperless_Billing_Option();
	}

	@Then("^I validate if special format dropdown is disabled$")
	public void i_validate_if_special_format_dropdown_is_disabled() throws Exception {
		accountInformationSteps.validates_If_Special_Format_Section_Is_Disabled();
	}

	@Then("^I validate if Mail my Bill is selected by default$")
	public void i_validate_if_Mail_my_Bill_is_selected_by_default() throws Exception {
		accountInformationSteps.validates_If_Mail_my_Bill_is_selected_by_default();
	}

	@Then("^I validate if paperless billing is disabled$")
	public void i_validate_if_paperless_billing_is_disabled() throws Exception {
		accountInformationSteps.validates_If_Paperless_Billing_Option_Is_Disabled();
	}

	@When("^I click on Customer denies email checkbox$")
	public void i_click_on_Customer_denies_email_checkbox() throws Exception {
		accountInformationSteps.clicks_On_Customer_Declines_Email();
	}

	@Then("^I Validate if email field is disabled$")
	public void i_Validate_if_email_field_is_disabled() throws Exception {
		accountInformationSteps.validates_If_Email_Field_Is_Disabled();
	}

	@Then("^I validate if \"([^\"]*)\" is present for Vacation Suspend order in Account Information page$")
	public void i_validate_if_is_present_for_Vacation_Suspend_order_in_Account_Information_page(String emailAddress) throws Exception {
		accountInformationSteps.validates_If_Email_Present_For_Vacation_Service_Order_With_Paperless_Billing(emailAddress);
	}

	@Then("^I validate if email field is editable \"([^\"]*)\" for Vacation Suspend order in Account Information page$")
	public void i_validate_if_email_field_is_editable_for_Vacation_Suspend_order_in_Account_Information_page(String changedEmailAddress) throws Exception {
		accountInformationSteps.validates_If_Email_Field_Is_Editable_For_Vacation_Service_Order_With_Paperless_Billing();
		accountInformationSteps.changes_The_Email_Address_For_Vacation_Service_Order_With_Paperless_Billing(changedEmailAddress);
	}

	@Then("^I validate if Update or Review Billing address is present for Vacation Suspend order in Account Information page$")
	public void i_validate_if_Update_or_Review_Billing_address_is_present_for_Vacation_Suspend_order_in_Account_Information_page() throws Exception {
		accountInformationSteps.validates_If_Update_Or_Review_Billing_Address_Section_Is_Present();
	}

	@Then("^I click on continue button for Vacation Suspend order in Account Information page$")
	public void i_click_on_continue_button_for_Vacation_Suspend_order_in_Account_Information_page() throws Exception {
		accountInformationSteps.clicks_On_Continue_Button_For_Vacation_Service_Order_In_Account_Information_Page();
	}

	@Then("^I select current billing address$")
	public void i_select_current_billing_address() throws Exception {
		accountInformationSteps.selects_Current_Billing_Address();
	}

	@Then("^I validate if user is getting option to switch to paperless billing$")
	public void i_validate_if_user_is_getting_option_to_switch_to_paperless_billing() throws Exception {
		accountInformationSteps.validates_Options_To_Switch_To_Paperless_Billing();
	}

	@Then("^I validate if Yes setup - paperless billing is selected by default$")
	public void i_validate_if_Yes_setup_paperless_billing_is_selected_by_default() throws Exception {
		accountInformationSteps.validates_If_Yes_Setup_Paperless_Billing_Is_Selected_By_Default();
	}

	@Then("^I validate if email field is editable \"([^\"]*)\" for Vacation Suspend order in Account Information page without paperless billing$")
	public void i_validate_if_email_field_is_editable_for_Vacation_Suspend_order_in_Account_Information_page_without_paperless_billing(String changedEmailAddress) throws Exception {
		accountInformationSteps.validates_If_Email_Field_Is_Editable_For_Vacation_Service_Order_Without_Paperless_Billing();
		accountInformationSteps.changes_The_Email_Address_For_Vacation_Service_Order_Without_Paperless_Billing(changedEmailAddress);
	}

	@Then("^I validate if \"([^\"]*)\" is present for Vacation Restore order in Account Information page$")
	public void i_validate_if_is_present_for_Vacation_Restore_order_in_Account_Information_page(String emailAddress) throws Exception {
		accountInformationSteps.validates_If_Email_Present_For_Vacation_Service_Order_With_Paperless_Billing(emailAddress);
	}

	@Then("^I validate if email field is editable \"([^\"]*)\" for Vacation Restore order in Account Information page$")
	public void i_validate_if_email_field_is_editable_for_Vacation_Restore_order_in_Account_Information_page(String changedEmailAddress) throws Exception {
		accountInformationSteps.validates_If_Email_Field_Is_Editable_For_Vacation_Service_Order_With_Paperless_Billing();
		accountInformationSteps.changes_The_Email_Address_For_Vacation_Service_Order_With_Paperless_Billing(changedEmailAddress);
	}

	@Then("^I validate if Update or Review Billing address is present for Vacation Restore order in Account Information page$")
	public void i_validate_if_Update_or_Review_Billing_address_is_present_for_Vacation_Restore_order_in_Account_Information_page() throws Exception {
		accountInformationSteps.validates_If_Update_Or_Review_Billing_Address_Section_Is_Present();
	}

	@Then("^I click on continue button for Vacation Restore order in Account Information page$")
	public void i_click_on_continue_button_for_Vacation_Restore_order_in_Account_Information_page() throws Exception {
		accountInformationSteps.clicks_On_Continue_Button_For_Vacation_Service_Order_In_Account_Information_Page();
	}

	@Then("^I select No, mail my bill option$")
	public void i_select_No_mail_my_bill_option() {
		accountInformationSteps.selects_No_Mail_My_Bill_Option();
	}

	@Then("^I validate if email field is editable \"([^\"]*)\" for Vacation Restore order in Account Information page without paperless billing$")
	public void i_validate_if_email_field_is_editable_for_Vacation_Restore_order_in_Account_Information_page_without_paperless_billing(String changedEmailAddress) throws Exception {
		accountInformationSteps.validates_If_Email_Field_Is_Editable_For_Vacation_Service_Order_Without_Paperless_Billing();
		accountInformationSteps.changes_The_Email_Address_For_Vacation_Service_Order_Without_Paperless_Billing(changedEmailAddress);
	}

	//ac31339 code starts
	@Then("^I enter password \"([^\"]*)\"$")
	public void i_enter_password(String pwd) throws Throwable {
		accountInformationSteps.enterPassword(pwd);
	}

	@Then("^I enter invalid password \"([^\"]*)\"$")
	public void i_enter_empty_password(String pwd) throws Throwable {
		accountInformationSteps.enter_Empty_Password(pwd);
	}


	@Then("^I verify Password \"([^\"]*)\"$")
	public void i_verify_password(String pwd) throws Throwable {
		accountInformationSteps.verifyPassword(pwd);
	}

	@Then("^I enter dtv account id \"([^\"]*)\"$")
	public void i_enter_dtv_accountid(String accId) throws Throwable {
		accountInformationSteps.enter_AccountId(accId);
	}	

	@Then("^I validate invalid Password \"([^\"]*)\"$")
	public void i_validate_empty_password(String pwd) throws Throwable {
		accountInformationSteps.validateEmptyPassword(pwd);
	}

	// Ac31339 code starts
	@Then("^I move to product offer page$")
	public void i_move_product_offer_page() throws Throwable {
		accountInformationSteps.clickBackButton();
	}

	@When("^I click on account info Continue button$")
	public void i_click_on_account_info_Continue_button() throws Throwable {
		accountInformationSteps.clickAccountInfoContinue2();
	}	
	//ac31339 code Ends

	//AC43057
	@Then("^I click on continue button on move Account page$")
	public void i_click_on_continue_button_on_move_Account_page(){
		accountInformationSteps.clickContonAccntMove();
	}

	//AC42889 starts
	@Then("^I click on Change Billing address$")
	public void i_click_on_change_billing_address_link(){
		accountInformationSteps.clickonChangeBillingAddress(); 
	}
	@Then("^I click on different address$")
	public void i_click_on_different_billing_address(){
		accountInformationSteps.clickonDifferentBillingAddress(); 
	}
	@Then("^I click on Current Billing Address$")
	public void i_click_on_current_billing_address(){
		accountInformationSteps.clickonCurrentBillingAddress(); 
	}
	@Then("^I click on New Service Address$")
	public void i_click_on_new_service_address(){
		accountInformationSteps.clickonNewServiceAddress(); 
	}	
	@Then("^I Enter new Billing Address and validate Billing address \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void I_enter_new_address(String street, String state, String City, String zip){
		accountInformationSteps.enter_new_address(street,state,City,zip);
	}
	@Then("^I validate postal address$")
	public void validate_postal_address(){
		accountInformationSteps.validatePostalAddress();
	}	
	@Then("^I Enter Different Billing Address and validate Billing address \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void I_enter_different_address(String street, String state, String City, String zip){
		accountInformationSteps.enter_new_address(street,state,City,zip);
	}

	@Then("^I click on save billing address$")
	public void i_click_on_save_billing_address(){
		accountInformationSteps.clickOnSaveBillingAddress();
	}
	@And("^I select Bypass validation incase multiple options returned$")
	public void i_select_Bypass_validation_incase_multiple_options_returned(){
		accountInformationSteps.selectBypassvalidation();
	} 
	//AC42889 ends

	
	//AC43057 starts
    @Then ("^I clicked on add change button$")
	public void i_clicked_on_add_change_button(){
		accountInformationSteps.clickOnAddChangebtn();
	}
	
	@Then ("^I added Authorized Parties \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void i_added_Authorized_Parties(String authfn,String authln,String authcntat){
		accountInformationSteps.addAuthorizedUser(authfn, authln , authcntat);
	}
	
	/*
	 * Shilpa - F36408 Click on Continue button on Account Infomration page 
	 * 
	 */
	@When("^I click on continue button on Account Information page for MACD orders$")
	public void i_click__button_on_account_infomration_page_for_MACD_orders() throws Throwable {

		accountInformationSteps.clickContinueAccountInforMACDOrders();
	}
	
	/*
	 * Shilpa - F36408
	 */
	@Then("^I enter email in account information page\"([^\"]*)\"$")
	public void i_enter_email_in_account_information_page(String email) throws Throwable {
		accountInformationSteps.enter_email(email);

	}
	
	/*
	 * Shilpa - F37432
	 * 
	 */	
	@Then("^I add first authorized parties \"([^\"]*)\" \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_add_first_authorized_parties(String firstname,String lastname,String phone) {
		accountInformationSteps.add_first_authorized_parties(firstname,lastname,phone);
	}
	
	/*
	 * Shilpa - F37432
	 * 
	 */
	@Then("^I add second authorized parties \"([^\"]*)\" \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_add_second_authorized_parties(String firstname,String lastname,String phone) {
		accountInformationSteps.add_second_authorized_parties(firstname,lastname,phone);
	}
	
	/*
	 * Shilpa - F37432
	 * 
	 */
	@When("^I click on Save Updates button$")
	public void i_click_on_save_updates_button() throws Throwable {

		accountInformationSteps.clickSaveUpdates();
	}
	

}
