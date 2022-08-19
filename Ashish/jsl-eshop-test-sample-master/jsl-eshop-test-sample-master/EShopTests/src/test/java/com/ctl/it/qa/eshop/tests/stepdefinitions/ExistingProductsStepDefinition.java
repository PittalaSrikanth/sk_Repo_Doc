package com.ctl.it.qa.eshop.tests.stepdefinitions;

import com.ctl.it.qa.eshop.steps.ExistingProductsSteps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;

public class ExistingProductsStepDefinition {

    @Steps
    ExistingProductsSteps existingproductssteps;
    
    
    @Then("^I should be in existing products page$")
    public void i_should_be_in_existing_products_page() {
           existingproductssteps.i_see_existind_products();
    }
    
    @And("^I click on DisconnectAll$")
    public void i_click_on_DisconnectAll() throws Throwable {
            existingproductssteps.ClickonDisconnectAll();
    }

	@Then("^I select move service from other order activities$")
	public void i_select_move_service() {
		existingproductssteps.i_select_move_service();
	}
	
	@Then("^I click make changes button$")
	public void i_click_make_changes_button() {
		existingproductssteps.i_click_make_changes_button();
	}

    // I enter new address and click validate
	@Then("^I enter new address and click validate \"([^\"]*)\"$")
	public void i_enter_newaddress_click_validate(String new_address) {
		existingproductssteps.i_enter_newaddress_click_validate(new_address);
	}

	//MAHESH
	@Then("^Validate speed$")
	public void validate_speed() {
		existingproductssteps.validate_speed();
	}
	
	//Anuradha: Select BnR from other activities
		@Then("^I select Billing and Response from other order activities$")
		public void i_select_Billing_and_Response_from_other_order_activities(){
			existingproductssteps.i_select_Billing_and_Response_from_other_order_activities();
			
		}
	
	
}

