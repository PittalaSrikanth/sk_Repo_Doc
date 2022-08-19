package com.ctl.it.qa.eshop.tests.stepdefinitions;

import com.ctl.it.qa.eshop.steps.LoginSteps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class LoginPageStepDefinition {

	@Steps
	LoginSteps loginSteps;

	@Given("^I should be on Eshop login screen$")
	public void i_should_be_on_Eshop_login_screen() {

		loginSteps.Eshop_url_OpenPage();

	}

	@When("^I enter username and password$")
	public void i_enter_username_and_password1() throws Throwable {

		loginSteps.loginToEshop();

	}
	//ac31339 Code starts
	
	@Given("^I should be on SFC login screen$")
	public void i_should_be_on_SFC_login_screen() {
		 loginSteps.Sfc_url_OpenPage();
	}

	//ac31339 code ends

}
