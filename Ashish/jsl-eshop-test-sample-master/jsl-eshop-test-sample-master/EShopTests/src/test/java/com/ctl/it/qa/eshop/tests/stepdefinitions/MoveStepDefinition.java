package com.ctl.it.qa.eshop.tests.stepdefinitions;

import com.ctl.it.qa.eshop.steps.ExistingProductsSteps;
import com.ctl.it.qa.eshop.steps.MoveSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class MoveStepDefinition {

	@Steps
	ExistingProductsSteps existingProductsSteps;

	@Steps
	MoveSteps moveSteps;

	// Existing products & Move Services &&& Pick your Offer Page

	@When("^I click continue button from existing products and move service page$")
	public void i_click_on_continue_button1() throws Throwable {

		moveSteps.clickOnContinue();

	}

	@Given("^I click again continue button in Customer Service Page$")
	public void i_click_again_on_continue_button1() throws Throwable {

		moveSteps.clickOnAgainContiune();
	}

	@Then("^I click continue button in scheduling Move Order page$")
	public void i_click_on_continue_button_of_scheduling_page() throws Throwable {

		moveSteps.clickOnContinueOnMoveOrderPage();

	}

	@When("^I click Continue button on account information page$")
	public void i_click_on_account_Continue_button() throws Throwable {

		moveSteps.clickAccountInfoContinue();

	}

	@When("^I select the device \"([^\"]*)\" \"([^\"]*)\"$")
	public void i_select_the_device(String deviceName,String removalReason) throws Throwable {

		moveSteps.removeHomePhone(deviceName,removalReason);

	}

	@When("^I Add call Referal scheduling Move Order page$")
	public void i_add_call_referal() throws Throwable {

		moveSteps.addCallReferal();

	}
	@Then("^I Expand the Telephone Number under Phone Configuration$")
	public void i_Expand_the_Telephone_Number_under_Phone_Configuration() {
		moveSteps.ExpandTN();
	}


	@Then("^I Click on More TNs$")
	public void i_Click_on_More_TNs() {
		moveSteps.ClickMoreTN();
	}

	@Then("^I Click on More Options$")
	public void i_Click_on_More_Options() {
		moveSteps.ClickMoreOption_TN();
		
	}
	@Then("^I Click on \"([^\"]*)\" Radio button$")
	public void i_Click_on_Radio_button(String arg1) {
		moveSteps.ManualRequestRadioBtn(arg1);
	}


	@Then("^I Select \"([^\"]*)\" from NPA \"([^\"]*)\" from NXX dropdown and \"([^\"]*)\" as line$")
	public void i_Select_from_NPA_from_NXX_dropdown_and_as_line(String arg1, String arg2, String arg3) {
		moveSteps.Select_NPA_NXX_Line(arg1,arg2,arg3);
	}
	
	@Then("^I Click on CheckTN button$")
	public void i_Click_on_CheckTN_button() {
		moveSteps.Click_Check_TN();
	}

	@Then("^I Click on Chat with TN assignment Link$")
	public void i_Click_on_Chat_with_TN_assignment_Link() {
		moveSteps.Click_Chat_with_TN_assignment();
	}

	
	@Then("^I validate a new window will be created with different chat links$")
	public void i_validate_a_new_window_will_be_created_with_different_chat_links() {
		moveSteps.Chat_link_Page();
	}


	@Then("^I click on Chat Now Link$")
	public void i_click_on_Chat_Now_Link() {
		moveSteps.Click_Chat_Now();
	}

	@Then("^I Validated the confirmation message that says \"([^\"]*)\"$")
	public void i_Validated_the_confirmation_message_that_says(String arg1) {
		moveSteps.Validate_TN_Confirmation_msg(arg1);
	}


	@Then("^I Click on select TN Button$")
	public void i_Click_on_select_TN_Button() {
		moveSteps.Click_Select_TN();
	}

	@Then("^I validated \"([^\"]*)\" is assigned$")
	public void i_validated_is_assigned(String arg1) {
		moveSteps.TN_validation(arg1);
	}
	@Then("^I Validated the CNUM response message that says \"([^\"]*)\"$")
	public void i_Validated_the_CNUM_response_message_that_says(String arg1) {
		moveSteps.CNUM_Response(arg1);
	}
	@Then("^I Validated the CNUM confirmation message that says \"([^\"]*)\"$")
	public void i_Validated_the_CNUM_confirmation_message_that_says(String arg1) {
		moveSteps.CNUM_AgeTN_Response(arg1);
	}
	
	@Then("^I select \"([^\"]*)\" option from Assess Charge$")
	public void i_select_No_waive_the_charge_option_from_Assess_Charge(String arg1){
			moveSteps.selectAssessCharge(arg1);
		}

}
