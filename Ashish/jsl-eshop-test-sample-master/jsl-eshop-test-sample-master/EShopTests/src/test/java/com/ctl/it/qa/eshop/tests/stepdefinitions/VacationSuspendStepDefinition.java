package com.ctl.it.qa.eshop.tests.stepdefinitions;

import com.ctl.it.qa.eshop.steps.VacationSuspendSteps;

import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;

public class VacationSuspendStepDefinition {

	@Steps
	VacationSuspendSteps vacationSuspendUser;

	@Then("^I click on Vacation Service$")
	public void i_click_on_Vacation_Service() throws Exception {
		vacationSuspendUser.selects_Vacation_Service();
	}

	@Then("^I select Vacation Suspend from the dialog box$")
	public void i_select_Vacation_Suspend_from_the_dialog_box() throws Exception {
		vacationSuspendUser.selects_Vacation_Suspend_For_HSI();
	}

	@Then("^I click on Continue button on vacation service dialog box$")
	public void i_click_on_Continue_button_on_vacation_service_dialog_box() throws Exception {
		vacationSuspendUser.clicks_On_Continue_Button_In_Vacation_Service_Dialog_Box();
	}

	@Then("^I click on Continue button on vacation service dialog box again$")
	public void i_click_on_Continue_button_on_vacation_service_dialog_box_again() throws Exception {
		vacationSuspendUser.clicks_On_Continue_Button_In_Vacation_Service_Dialog_Box();
	}
	
	@Then("^I click on OK Got it button on Order Disclosures dialog box for Vacation Suspend for HSI$")
	public void i_click_on_OK_Got_it_button_on_Order_Disclosures_dialog_box_for_Vacation_Suspend_for_HSI() {
		vacationSuspendUser.handles_Order_Disclosures_For_Vacation_Suspend_For_HSI();
	}
	
	@Then("^I select Vacation Suspend from the dialog box for POTS$")
	public void i_select_Vacation_Suspend_from_the_dialog_box_for_POTS() throws Exception {
		vacationSuspendUser.selects_Vacation_Suspend_For_POTS();
	}
	
	@Then("^I Validate if product dropdown for POTS is defaulted to \"([^\"]*)\"$")
	public void i_Validate_if_product_dropdown_for_POTS_is_defaulted_to(String service) {
		vacationSuspendUser.validates_Default_Value_Of_Product_Dropdown(service);
	}

	@Then("^I validate if Continue button is disabled in Vacation Service dialog box$")
	public void i_validate_if_Continue_button_is_disabled_in_Vacation_Service_dialog_box() {
		vacationSuspendUser.validates_If_Continue_Button_Is_Disabled();
	}

	@Then("^I validate if Vacation options tab is displayed with referral message options with \"([^\"]*)\" defaulted in drop down$")
	public void i_validate_if_Vacation_options_tab_is_displayed_with_referral_message_options_with_defaulted_in_drop_down(String value) {
		vacationSuspendUser.validates_Default_Value_Of_Referal_Message_Dropdown(value);
	}

	@Then("^I expand the shopping cart$")
	public void i_expand_the_shopping_cart() {
		vacationSuspendUser.expands_The_Shopping_Cart_For_Vacation_Service();
	}

	@Then("^I validate if shopping cart dispays \"([^\"]*)\" for POTS$")
	public void i_validate_if_shopping_cart_dispays_for_POTS(String vacationDiscount) {
		vacationSuspendUser.validates_Vacation_Discount_For_POTS(vacationDiscount);
	}
	
	@Then("^I select Vacation Suspend for all services$")
	public void i_select_Vacation_Suspend_for_all_services() {
		vacationSuspendUser.selects_Vacation_Suspend_For_All_Services();
	}
	
	@Then("^I validate if shopping cart dispays \"([^\"]*)\" for HSI$")
	public void i_validate_if_shopping_cart_dispays_for_HSI(String vacationDiscount) {
		vacationSuspendUser.validates_Vacation_Discount_For_HSI(vacationDiscount);
	}
	
	@Then("^I Validate if product dropdown for HSI is defaulted to \"([^\"]*)\"$")
	public void i_Validate_if_product_dropdown_for_HSI_is_defaulted_to(String service) {
		vacationSuspendUser.validates_Default_Value_Of_Product_Dropdown_HSI(service);
	}
	
	@Then("^I validate the message for Vacation Service unavailabitity for a location$")
	public void i_validate_the_message_for_Vacation_Service_unavailabitity_for_a_location() {
		vacationSuspendUser.validates_The_Message_For_Vacation_Service_Unavailability_For_A_Location();
	}
	
	@Then("^I validate the message for Vacation Service unavailabitity for an account$")
	public void i_validate_the_message_for_Vacation_Service_unavailabitity_for_an_account() {
		vacationSuspendUser.validates_The_Message_For_Vacation_Service_Unavailability_For_An_Account();
	}

	//ac43057
	@Then("^I click ok on Order Disclosure pop-up$")
	public void i_click_ok_on_Order_disclosure_pop_up() {
	vacationSuspendUser.click_ok_on_Order_Disclosure_pop_up();
			
	}
		
	@Then("^I click continue on Product and Services page$")
	public void i_click_continue_on_Product_and_Services_page () {
	vacationSuspendUser.click_continue_product_and_services();
	}
	@Then("^I click close on cannot start move order pop-up$")
	public void i_click_close_on_cannot_start_move_order_popup (){
		vacationSuspendUser.click_close_on_cannot_perform_move();
		
	}
	@Then("^vacation product offer page displayed with error message$")
	public void vacation_product_offer_page_displayed_with_error_message (){
		vacationSuspendUser.validate_error_message_for_chg_on_vacsus();

	}
		
	
	/// ac42889
    @Then("^I validate the warning message in the dialog box$")
    public void i_validate_warning_message() throws Exception {
    
           vacationSuspendUser.i_validate_warning_message();
    }
    
    @Then("^I Entered new Billing Address \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
    public void I_enter_new_address(String street, String state, String City, String zip){
           vacationSuspendUser.enter_new_address(street,state,City,zip);
    }

    //ac42889
    
    //ac41685
    @Then("^I click on Current Billing address radio button$")
    public void i_click_on_Current_Billing_address_radio_button() {
       
           vacationSuspendUser.click_on_Current_Billing_address_radio_button();
    }
    
    @Then("^I send valid mail id \"([^\"]*)\"$")
	public void i_send_valid_mail_id(String email) {
		vacationSuspendUser.enter_mail_id(email);
	}

	@Then("^I Verify the mail id\"([^\"]*)\"$")
	public void i_Verify_the_mail_1id(String mailid) {
		vacationSuspendUser.verify_mail_id(mailid);

	}
	
	////ac50097
	@Then("^select Vacation Suspend$")
	public void select_Vacation_Suspend() {
		vacationSuspendUser.selects_Vacation_Suspend();
	}

}
