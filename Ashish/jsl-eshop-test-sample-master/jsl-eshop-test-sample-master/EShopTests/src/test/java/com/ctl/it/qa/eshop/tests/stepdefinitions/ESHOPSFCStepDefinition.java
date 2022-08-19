package com.ctl.it.qa.eshop.tests.stepdefinitions;

import com.ctl.it.qa.eshop.steps.ESHOPSFCSteps;

import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;

public class ESHOPSFCStepDefinition {

	@Steps
	ESHOPSFCSteps eshopsfcsteps;
	
	
	@Then("^I move back to existing SFC page$")
	public void i_move_back_to_existing_SFC_page()  {
		eshopsfcsteps.move_back_to_existing_SFC_page();
	}
	
	@Then("^I search order in SFC page with account number$")
	public void i_search_order_in_SFC_page_with_account_number()  {
		eshopsfcsteps.search_order_in_SFC_page_with_account_number();
	}

	@Then("^I click on order eshop button in SFC page to proceed to Eshop Page$")
	public void i_click_on_order_eshop_button_in_SFC_page_to_proceed_to_Eshop_Page()  {
		eshopsfcsteps.click_on_order_eshop_button_in_SFC_page_to_proceed_to_Eshop_Page();
	}
	
	@Then("^I search order in SFC page with account number \"([^\"]*)\"$")
	public void i_search_order_in_SFC_page_with_account_number(String ban) {
		eshopsfcsteps.search_order_in_SFC_page_with_account_number(ban);
	}

}
