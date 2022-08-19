package com.ctl.it.qa.eshop.tests.stepdefinitions;

import com.ctl.it.qa.eshop.steps.ChangeSteps;
import com.ctl.it.qa.eshop.steps.OrderSteps;

import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;

public class ChangeStepDefinition {

	@Steps
	ChangeSteps changesteps;
	@Steps
		OrderSteps ordersteps;
	
	@Then("^I click on Make changes button$")
	public void i_click_on_Make_changes_button(){
	  
		changesteps.i_clicked_on_make_changes_button();
	}

	@Then("^I Add the new products HSI$")
	public void i_Add_the_new_products_HSI(){
		changesteps.i_added_new_product_HSI();
	}

	@Then("^I Add the new products POTS$")
	public void i_Add_the_new_products_POTS(){
		ordersteps.homePhone();
	}

	@Then("^I Add the new products CVOIP$")
	public void i_Add_the_new_products_CVOIP() {
		ordersteps.CVoipDHPhone();
	}

	@Then("^I Remove the existing product HSI$")
	public void i_Remove_the_existing_product_HSI() {
		changesteps.i_removed_existing_product_HSI();
	}

	@Then("^I Remove the existing product POTS$")
	public void i_Remove_the_existing_product_POTS() {
		changesteps.i_removed_existing_product_POTS();
	}

	@Then("^I Remove the existing product CVOIP$")
	public void i_Remove_the_existing_product_CVOIP(){
		changesteps.i_removed_existing_product_CVOIP();
	}
	
	@Then("^I add a call referral for POTS product removal$")
	public void i_add_a_call_referral_for_POTS_product_removal()  {
		changesteps.i_add_a_referral();
	}

	@Then("^I select the Available speed on change order \"([^\"]*)\"$")
	public void i_select_the_Available_speed_on_change_order(String Selectspeed) {
	   
		changesteps.selectAvailableSpeed_change_order(Selectspeed);

	}
	
	@Then("^I check for return deposit amount for removed product if any available$")
	public void i_check_for_return_deposit_amount_for_removed_product_if_any_available() throws Exception {
	   
		changesteps.return_amount_removed_product();
	}
	
	@Then("^I clicked continue button again$")
	public void i_clicked_continue_button_again()  {
		changesteps.continue_again();
	   
	}

	@Then("^I click again click Continue button on change account page$")
	public void i_click_again_click_Continue_button_on_change_account_page()  {
		changesteps.change_account_continue_page();
	}

//ac41685
	@Then("^I click on Duedate calender to change DD$")
	public void i_click_on_Duedate_calender_to_change_DD() {
		changesteps.Change_DueDate();
	}

	//ab18364
			@Then("^I click on Telephone Number and then click on More options$")
			public void i_click_on_Telephone_Number_and_then_click_on_More_TNs(){
				changesteps.click_Telephone_Number();
			}
			
			@Then("^I click continue button from Changes page$")
			public void i_click_on_continue_button1() throws Throwable {

				changesteps.clickOnContinue();

			}
	
}
