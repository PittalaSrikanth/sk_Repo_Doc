package com.ctl.it.qa.eshop.tests.stepdefinitions;

import com.ctl.it.qa.eshop.steps.PendingOrderSteps;

import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;

public class PendingOrderStepDefinition {

	@Steps
	PendingOrderSteps pendingordersteps;
	// private final Logger slf4jLogger =
	// LoggerFactory.getLogger(CustomerDetailsPage.class);

	@Then("^I click on scheduling button on pending order page$")
	public void i_click_on_scheduling_button_on_pending_order_page() {
		pendingordersteps.i_click_on_scheduling_button();
	}

	@Then("^I change the due date of the order$")
	public void i_change_the_due_date_of_the_order() throws Throwable {
		System.out.println("clicked on change due date");
	}

	@Then("^I click on other actions button on pending order page$")
	public void i_click_on_other_actions_button_on_pending_order_page() {
		pendingordersteps.i_click_on_otheractions_button();
	}

	@Then("^I click on cancel order button on pending order page$")
	public void i_click_on_cancel_order_button_on_pending_order_page() {
		pendingordersteps.i_click_on_cancel_button();
	}

	@Then("^I confirm the cancelation of the order$")
	public void i_confirm_the_cancelation_of_the_order() {
		pendingordersteps.confirm_cancel();
	}
	
	
}
