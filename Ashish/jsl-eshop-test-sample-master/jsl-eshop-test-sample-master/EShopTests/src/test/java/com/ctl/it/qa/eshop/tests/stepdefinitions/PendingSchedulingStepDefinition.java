package com.ctl.it.qa.eshop.tests.stepdefinitions;

import com.ctl.it.qa.eshop.steps.PendingSchedulingSteps;

import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;

public class PendingSchedulingStepDefinition {

	@Steps
	PendingSchedulingSteps PendingSchedulingSteps;
	@Then("^I click to reserve appointment on pending scheduling page$")
	public void i_click_to_reserve_appointment_on_pending_scheduling_page() throws Exception {
		PendingSchedulingSteps.i_change_the_date();
		
	}


	@Then("^I click on continue button on pending scheduling page$")
	public void i_click_on_continue_button_on_pending_scheduling_page() throws Exception {
		PendingSchedulingSteps.i_click_the_continue_button();
	}

	
	
	
}
