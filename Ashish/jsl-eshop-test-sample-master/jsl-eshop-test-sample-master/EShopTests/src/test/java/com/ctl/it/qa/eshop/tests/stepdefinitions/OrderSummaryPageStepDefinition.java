package com.ctl.it.qa.eshop.tests.stepdefinitions;

import com.ctl.it.qa.eshop.steps.OrderSummarySteps;

import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;

public class OrderSummaryPageStepDefinition {

	@Steps
	OrderSummarySteps orderSummarySteps;

	@Then("^I selected Yes for the review in order summary page$")
	public void i_selected_Yes_for_the_review_in_order_summary_page() throws Throwable {

		orderSummarySteps.clickYes();

	}

	@Then("^I clicked submit order button$")
	public void i_clicked_submit_order_button() throws Throwable {

		orderSummarySteps.clickSubmitOrder();

	}

	@Then("^I should able to submit order successfully$")
	public void i_should_able_to_submit_order_successfully() throws Throwable {
		//commented below line since there is issue with the order confirmation page
		//orderSummarySteps.orderSummaryPageVerification();

	}

	@Then("^I will add technician \"([^\"]*)\" remarks$")
	public void i_will_add_technician_remarks(String techRemark) throws Throwable {

		orderSummarySteps.enterTechnicianRemarks(techRemark);

	}

	@Then("^I verfy the technical notes$")
	public void i_verfy_the_technical_notes() throws Throwable {

		orderSummarySteps.checkRemarks();

	}

	@Then("^I get account number from application$")
	public void i_get_account_num() {

		orderSummarySteps.getAccountNumber();

	}

	@Then("^I validate address and dueDate with \"([^\"]*)\"$")
	public void i_validate_address(String address) {
		//commented below line as the application design got changed
		//orderSummarySteps.validateDueDate(address);
	}

	// Nitish 
	@Then("^I Click on start new order button$")
	public void i_Click_on_start_new_order_button() throws Throwable {
		orderSummarySteps.i_clicked_on_new_order();
	}

		
		@Then("^I enter the special remark in Additional Order Remarks field \"([^\"]*)\"$")
		public void i_enter_the_special_remark_in_Additional_Order_Remarks_field(String datapassed) {
			orderSummarySteps.enter_the_special_remark_in_Additional_Order_Remarks_field(datapassed);
		}

		//Anuradha   

		@Then("^I clicked on back button in review Order page$")
		public void i_clicked_on_back_button_in_review_Order_page() {
			orderSummarySteps.i_clicked_on_back_button();

		}
		@Then("^I click on Update Application$")
		public void i_click_on_Update_Application() {
			orderSummarySteps.i_clicked_on_update_Account_button();

		}
		
		@Then("^I select Mail my bill$")
		public void i_select_mail_my_bill() {
			orderSummarySteps.i_select_mail_my_bill();

		}
		
		@Then("^I click on change billing address$")
		public void i_click_on_change_billing_address(){
			orderSummarySteps.i_click_on_change_billing_address();
			
		}

		@Then("^I click on update billing address \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
		public void i_click_on_update_billing_address(String streetaddress,  String city ,  String zipcode){
			orderSummarySteps.i_click_on_update_billing_address(streetaddress , city , zipcode);
			
		}
		
		@Then("^I re-entered FirstName \"([^\"]*)\" LastName \"([^\"]*)\" SMS \"([^\"]*)\"$")
		public void i_reentered_firstname_lastname_sms(String firstname, String lastname, String SMS){
			orderSummarySteps.verified_reentrant_of_FN_LN_SMS(firstname,  lastname,  SMS);
			
		}
		
		@Then ("^I selected Marketing Preferences$")
		public void i_selected_Marketing_Preferences(){
			orderSummarySteps.verified_marketing_preferences();	
			
		}

	@Then("^I enter the existing captured account number$")
	public void i_enter_the_existing_captured_account_number() throws Throwable {
		orderSummarySteps.i_enter_existing_account_number(OrderSummarySteps.accountnum);
	}




		//Anuradha  
		
		/*
		 * Shilpa
		 * MMP7824 - F33405 
		 * Verify the display of both Primary contact number and order level CBR number in Account information page
		 */
		@Then("I validate phone number entered in scheduling page\"([^\"]*)\"$")
		public void i_validate_phone_number_in_scheduling_page(String contactNumber)throws Throwable{
			orderSummarySteps.validatePhoneNumber(contactNumber);
		}
		
		//AC43057
		
		@Then("I validated Auth User \"([^\"]*)\" on Order Summary Page")
		public void i_validated_Auth_User_on_Order_Summary_Page (String authname){
			orderSummarySteps.validationForAuthUSer(authname);
		}

	
	@Then("^I validate the ensemble table is storing details \"([^\"]*)\" for \"([^\"]*)\" for paperless billing in \"([^\"]*)\"$")
	public void i_validate_the_ensemble_table_is_storing_details_for_for_paperless_billing_in(String bpNoOfCopies, String bpSeqNo, String databaseName) throws Exception {
		orderSummarySteps.validates_Ensemble_Details_For_Paperless_Billing(bpNoOfCopies, bpSeqNo, databaseName);
	}
	 
	/*
	 * Shilpa
	 * MMP7824 - F33405 
	 * Verify the display of both Primary contact number and order level CBR number in Account information page
	 */
	
	@Then("^I validate the ensemble table is email \"([^\"]*)\" details for paperless billing in \"([^\"]*)\"$")
	public void i_validate_the_ensemble_table_is_email_details_for_paperless_billing_in(String emailAddress, String databaseName) throws Exception {
		orderSummarySteps.validates_Ensemble_Email_Details_For_Paperless_Billing(emailAddress, databaseName);
	}
	
	@Then("^I validate authorized party in order summary page \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void i_validate_authorized_party_in_order_summary_page(String firstname1, String lastname1,
			String firstname2, String lastname2) {
		orderSummarySteps.validateAuthorizedPartyInOrderSummary(firstname1, lastname1, firstname2, lastname1);

	}


}
