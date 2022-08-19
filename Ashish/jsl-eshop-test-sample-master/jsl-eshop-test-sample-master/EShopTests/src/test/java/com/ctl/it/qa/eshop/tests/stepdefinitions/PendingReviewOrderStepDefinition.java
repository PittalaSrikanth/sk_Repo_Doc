package com.ctl.it.qa.eshop.tests.stepdefinitions;

import com.ctl.it.qa.eshop.steps.PendingReviewOrderSteps;

import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;

public class PendingReviewOrderStepDefinition {

	@Steps
	PendingReviewOrderSteps pendingreviewordersteps;

@Then("^I selected Yes for the review on pending review order page$")
public void i_selected_Yes_for_the_review_on_pending_review_order_page() {
    
	pendingreviewordersteps.i_clicked_yes_on_review_order();
}


@Then("^I clicked on submit revisions button on pending review order page$")
public void i_clicked_on_submit_revisions_button_on_pending_review_order_page() {
    
	pendingreviewordersteps.I_clicked_on_submit_revisions();
}
	
	
}
