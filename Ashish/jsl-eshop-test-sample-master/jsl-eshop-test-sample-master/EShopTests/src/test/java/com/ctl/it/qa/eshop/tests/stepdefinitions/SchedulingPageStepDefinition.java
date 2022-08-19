package com.ctl.it.qa.eshop.tests.stepdefinitions;

import com.ctl.it.qa.eshop.steps.SchedulingSteps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;

public class SchedulingPageStepDefinition {

	@Steps
	SchedulingSteps schedulingSteps;

	@Then("^I enter dueDate$")
	public void i_enter_dueDate() throws Throwable {

		schedulingSteps.dueDateSelection();

	}

	@Then("^I click on continue button of scheduling page$")
	public void i_click_on_continue_button_of_scheduling_page() throws Throwable {

		schedulingSteps.clickOnContinue();

	}

	@Then("^I should get earliest available appointment text$")
	public void i_should_get_earliest_appointment() {

		schedulingSteps.verifyEarliestAppoitmentText();

	}

	@And("^I click to reserve appointment$")
	public void i_click_to_reserve_appoitment() {

		schedulingSteps.reserveAppointment();

	}

	@Then("^I enter Driving Directions \"([^\"]*)\"comments$")
	public void i_enter_Driving_Directions_comments(String driverComment) throws Throwable {

		schedulingSteps.DriverComments(driverComment);

	}

	@Then("^I enter Additional \"([^\"]*)\" comments$")
	public void i_enter_Additional_comments(String AddComment) throws Throwable {

		schedulingSteps.AdditionalComments(AddComment);

	}

	@Then("^reserve date should display as due date$")
	public void reserve_due_date_display_as_due_date() {

		schedulingSteps.verifyDueDateUpdate();
	}
	
	@And("^I get the update dute date$")
	public void i_get_update_due_date() throws InterruptedException {
		schedulingSteps.getDueDate();
	}
	
	@Then("^I select the provided due date for installation \"([^\"]*)\"$")
	public void i_select_the_provided_due_date_for_installation(String passedDate) throws Exception {
	   
		System.out.println(passedDate);
		schedulingSteps.enterdate(passedDate);
	}
	
	//Shilpa 06/11  F33405
	@And("I modify phone number\"([^\"]*)\"$")
	public void i_modify_phone_number(String contactNumber)throws Throwable {
		schedulingSteps.modifyPhoneNumber(contactNumber);
	}
	@And("I check phone number mandatory in scheduling page$")
	public void i_check_contact_number_mandaory() {
		schedulingSteps.mandatoryPhoneNumber();
	}


		@Then("I check phone number in scheduling page\"([^\"]*)\"$")
		public void i_check_phone_number_in_scheduling_page(String phoneNumber) throws Exception {
			schedulingSteps.validatePhoneNumber(phoneNumber);
		}
		


	@Then("^I click on continue button on vacation order scheduling page$")
	public void i_click_on_continue_button_on_vacation_order_scheduling_page() throws Exception {
		schedulingSteps.clicks_On_Continue_Button_In_Vacation_Suspend_Scheduling_Page();
	}
	
	@Then("^I select the provided due date for installation in Due Date format \"([^\"]*)\"$")
	public void i_select_the_provided_due_date_for_installation_in_Due_Date_format(String passedDate) throws Exception {
		System.out.println(passedDate);
		schedulingSteps.enterDateInDueDateFormat(passedDate);
	}
	
	/*
	 * Shilpa MMP7824 - F36408 Verify the address in Scheduling page
	 */
	@Then("I validate address in scheduling page \"([^\"]*)\"$")
	public void i_check_address_in_scheduling_page(String address) throws Exception {
		System.out.println("Address is : " + address);
		schedulingSteps.validatePostalAddress(address);
	}
	
	/*
	 * Shilpa MMP7824 - F36408 Verify the address in Scheduling page
	 */
	@Then("I click on change billing address link$")
	public void i_click_on_change_billing_link() throws Exception {
		schedulingSteps.clickChangeBillingLink();
	}
	
	/*
	 * Shilpa MMP7824 - F36408 Enter Street address in Scheduling page
	 * 
	 */
	@Then("I enter street address \"([^\"]*)\"$")
	public void i_enter_street_address(String streetAddress) {
		schedulingSteps.enterStreetAddress(streetAddress);
	}

	/*
	 * Shilpa MMP7824 - F36408 Enter city in Scheduling page
	 * 
	 */
	@Then("I enter city \"([^\"]*)\"$")
	public void i_enter_city(String city) {
		schedulingSteps.enterCity(city);
	}

	/*
	 * Shilpa MMP7824 - F36408 Choose State in Scheduling page
	 * 
	 */
	@Then("I choose state \"([^\"]*)\"$")
	public void i_choose_state(String state) {
		schedulingSteps.chooseState(state);
	}

	/*
	 * Shilpa MMP7824 - F36408 Choose State in Scheduling page
	 * 
	 */
	@Then("I enter zipcode \"([^\"]*)\"$")
	public void i_enter_zipcode(String zipcode) {
		schedulingSteps.enterZipCode(zipcode);
	}

	/*
	 * Shilpa MMP7824 - F36408 Click Validate button for change billing address
	 * 
	 */
	@Then("I click validate button$")
	public void i_click_validate_button() {
		schedulingSteps.clickValidateButton();
	}

	/*
	 * Shilpa MMP7824 - F36408 Click Validate button for change billing address
	 * 
	 */
	@Then("I click on Ship to this address button$")
	public void i_click_on_ship_to_this_address_button() {
		schedulingSteps.clickShipToThisAddressButton();
	}


}
