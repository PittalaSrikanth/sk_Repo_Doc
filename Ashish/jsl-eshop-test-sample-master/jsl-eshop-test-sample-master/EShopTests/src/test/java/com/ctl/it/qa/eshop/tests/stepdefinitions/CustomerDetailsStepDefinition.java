package com.ctl.it.qa.eshop.tests.stepdefinitions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ctl.it.qa.eshop.pages.CustomerDetailsPage;
import com.ctl.it.qa.eshop.steps.CustomerDetailsSteps;
import com.ctl.it.qa.eshop.tests.RunCukesTest;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class CustomerDetailsStepDefinition {

	@Steps
	CustomerDetailsSteps customerDetailsSteps;

	@When("^I enter the \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" and \"([^\"]*)\" in customer detail page$")
	public void i_enter_the_and_in_customer_detail_page(String env, String first, String last, String phone,
			String address) throws Throwable {

		/*if (env.equals(RunCukesTest.passedInEnv)) {
			customerDetailsSteps.searchAccount(env, first, last, phone, address);
			slf4jLogger.info(">>>>>>>>  Processing data row: Env=" + env + "; FName=" + first + "; LName=" + last
					+ "; Phone=" + phone + "; Address=" + address + " <<<<<<<<");
		} else { // Env value passed in is DIFFERENT FROM THE ONE ON THE DATA
					// ROW, HENCE SKIP THIS DATA ROW (e.g., E2E PASSED IN, BUT
					// DATA ROW HAS ITV2 IN IT)
			// AK..NOTE: DO NOT EXECUTE IF ENV PASSED IN DIFFERENT FROM THE ONE
			// IN THE DATA TABLE - hence commenting the line below to skio these
			// data-rows
			// customerDetailsSteps.searchAccount(env, first, last, phone,
			// address);
			slf4jLogger.info("<<<<<<<<  Skipping data row: Entered Customer Details for: Env=" + env + "; FName="
					+ first + "; LName=" + last + "; Phone=" + phone + "; Address=" + address + " >>>>>>>>");
		}*/

	}

	@Then("^I click let's go button$")
	public void i_click_let_s_go_button() throws Throwable {

		customerDetailsSteps.letsGoButton();

	}

	@Then("^I should get no match found text$")
	public void i_get_no_match_found() throws Throwable {

		customerDetailsSteps.noMatchFoundText();

	}

	@Then("^I should get more than one address field$")
	public void i_should_get_more_match_found() throws Throwable {

		customerDetailsSteps.checkNumOfAddress();

	}

	@When("^I enter the \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" in customer detail page$")
	public void i_enter_the_in_customer_detail_page_a(String env1, String first1, String last1, String phone1)
			throws Throwable {

		/*if (env1.equals(RunCukesTest.passedInEnv)) {
			customerDetailsSteps.searchAccoundetails(env1, first1, last1, phone1);
			slf4jLogger.info(">>>>>>>>  Processing data row: Env=" + env1 + "; FName=" + first1 + "; LName=" + last1
					+ "; Phone=" + phone1);
		} else {
			slf4jLogger.info("<<<<<<<<  Skipping data row: Entered Customer Details for: Env=" + env1 + "; FName="
					+ first1 + "; LName=" + last1 + "; Phone=" + phone1);

		}
		 */
	}

	@When("^I enter the \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" in address page$")
	public void i_enter_the_in_address_page(String street, String unit, String city, String state, String zip)
			throws Throwable {

		customerDetailsSteps.enterAddressdetails(street, unit, city, state, zip);

	}

	@Then("^I select Matched Address$")
	public void i_select_Matched_Address() throws Throwable {

		customerDetailsSteps.selectMatchAddress();

	}

	//Nitish


	@When("^I click on Account or Order already exists link$")
	public void i_click_on_Account_or_Order_already_exists_link() throws Throwable {

		customerDetailsSteps.i_click_on_Account_or_Order_already_exists_link();
	}


	@Then("^I enter the \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" in existing order view page$")
	public void i_enter_the_and_in_existing_order_view_page(String env, String first, String last, String phone) throws Throwable {
		customerDetailsSteps.searchAccoundetails(env, first, last, phone);


	}

	//Nitish MACD Scenarios

	@When("^I enter only the completed account \"([^\"]*)\"$")
	public void i_enter_only_the_completed_account(String completed_accountnum)  {
		customerDetailsSteps.enter_completed_account_number(completed_accountnum);
	}

	//Prem SFC Starts 

	@Then("^I click on create new account$")
	public void i_click_on_create_new_account() {
		customerDetailsSteps.click_create_new_account();
	}

	@Then("^I enter the \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" and \"([^\"]*)\" in new acquisition page$")
	public void i_cretae_new_account(String first, String last,String email, String phone,
			String address)  {
		customerDetailsSteps.create_new_account(first,last,email,phone,address);
	}
	
	@Then("^I enter the \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" and \"([^\"]*)\" in new acquisition page$")
	public void i_cretae_new_account(String first, String last, String phone,
			String address)  {
		customerDetailsSteps.create_new_account(first,last,phone,address);
	}
	
	@Then("^I validate the address and save it$")
	public void i_validate_the_address_and_save_it()  {
		customerDetailsSteps.validate_address();
	}

	@Then("^I click on order eshop button$")
	public void i_click_on_order_eshop_button() {
		customerDetailsSteps.click_order_eshop();
	}

	//Prem SFC Ends

	/*
	 * Abhinav
	 */

	@When("^I enter the ORN for Order on Hold$")
	public void i_enter_the_ORN_for_Order_on_Hold() throws Exception {
		customerDetailsSteps.enters_ORN_On_Hold();
	}

	@Then("^I click on Account or Order already exists$")
	public void i_click_on_Account_or_Order_already_exists() throws Exception {
		customerDetailsSteps.i_click_on_Account_or_Order_already_exists();
	}

	@When("^I enter the \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" in ESHOP customer information screen$")
	public void i_enter_the_in_ESHOP_customer_information_screen(String firstName, String lastName, String contactNumber) throws Exception {
		customerDetailsSteps.enters_Customer_Information(firstName, lastName, contactNumber);
	}

	@When("^I Click on Lets go Button$")
	public void i_Click_on_Lets_go_Button() throws Exception {
		customerDetailsSteps.clicks_On_Lets_Go_Button();
	}

	@Then("^I enter the \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"  \"([^\"]*)\" and \"([^\"]*)\" in new acquisition page with a valid email$")
	public void i_enter_the_and_in_new_acquisition_page_with_a_valid_email(String firstName, String lastName, String phoneNo, String address, String email) throws Exception {
		customerDetailsSteps.create_New_Account_With_Email_From_SFC(firstName,lastName,phoneNo,address,email);
	}

	// ac31339 Prem 03/01 //
	@Then("^I enter the \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" and \"([^\"]*)\" in show address fields in new acquisition page$")
	public void i_cretae_new_account_showaddress(String first, String last, String phone,
			String address)  {
		customerDetailsSteps.create_new_account_showAddress(first,last,phone,address);
	}
	//Anuradha: Select residence option
	
	@Then("^I selected \"([^\"]*)\" option$")
	public void i_selected_option (String residence){
		customerDetailsSteps.i_select_own_or_rent(residence);
	}
	

}
