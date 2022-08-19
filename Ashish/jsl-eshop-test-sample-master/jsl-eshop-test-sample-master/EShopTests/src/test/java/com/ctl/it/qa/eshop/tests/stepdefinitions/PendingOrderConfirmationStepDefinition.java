package com.ctl.it.qa.eshop.tests.stepdefinitions;

import com.ctl.it.qa.eshop.steps.PendingOrderConfirmationSteps;

import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;

public class PendingOrderConfirmationStepDefinition {

	
	
	@Steps
	PendingOrderConfirmationSteps pendingorderconfirmationsteps;
	
	
	@Then("^I should able see the order confirmation on Pending order Confirmation page$")
	public void i_should_able_see_the_order_confirmation_on_Pending_order_Confirmation_page() throws Exception {
	    
		pendingorderconfirmationsteps.i_got_confirmation_of_the_order_revisons();
	}
	
	
}
