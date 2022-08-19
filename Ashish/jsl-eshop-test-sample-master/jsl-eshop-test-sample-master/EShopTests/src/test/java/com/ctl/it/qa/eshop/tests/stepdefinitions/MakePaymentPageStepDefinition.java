package com.ctl.it.qa.eshop.tests.stepdefinitions;

import com.ctl.it.qa.eshop.steps.MakePaymentSteps;

import cucumber.api.java.en.And;
import net.thucydides.core.annotations.Steps;

public class MakePaymentPageStepDefinition {
	
	@Steps
	MakePaymentSteps makePaymentSteps;

	
	@And("^I should be at make payment page$")
	public void i_should_at_makePaymentPage() {
		
		makePaymentSteps.verifyMakePaymentPage();
	}
	
	@And("^I fill all card details as \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_fill_card_details(String card, String zipcode) {
		makePaymentSteps.fillCardDetails(card, zipcode);
	}

	@And("^I click submit button on verify InformationPage$")
	public void i_submit_verify_information() {
		makePaymentSteps.submitVerfiyInfo();
	}
}
