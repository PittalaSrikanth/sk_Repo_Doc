package com.ctl.it.qa.eshop.tests.stepdefinitions;

import com.ctl.it.qa.eshop.steps.CustomizeServiceSteps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;

public class CustomizeServicePageStepDefinition {

	@Steps
	CustomizeServiceSteps customizeServiceSteps;

	@Then("^I should be in customize service page$")
	public void i_should_be_in_customize_service_page() throws Throwable {

		customizeServiceSteps.isCustomizePage();

	}

	@Given("^I click again on contine button$")
	public void i_click_again_on_contine_button1() throws Throwable {

		customizeServiceSteps.clickOnAgainContiune();
	}
	
	
	@Then("^I add the equipments in customize service page$")
	public void i_add_the_equipments_in_customize_service_page() throws Exception {
		customizeServiceSteps.i_added_euipment();
	   
	}
	
//Nitish Pots
	
	@Then("^I should add the equipments in customize service page$")
	public void i_should_add_the_equipments_in_customize_service_page() throws Throwable {
		customizeServiceSteps.i_add_euipments();
	}
	
	// ************ ac31339 code starts from here

	@Then("^I select all the equipments \"([^\"]*)\"$")
	public void i_select_all_the_equipments(String toggleTxt) throws Throwable {

		customizeServiceSteps.selectAllEquipments(toggleTxt);

	}

	// I select specific equipments
	@Then("^I select specific equipments \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_select_specific_equipments(String toggleTxt, String equipments) throws Throwable {

		customizeServiceSteps.selectSpecificEquipments(toggleTxt, equipments);

	}


	@Then("^I click List Toggle$")
	public void i_click_list_toggle() throws Exception {
		customizeServiceSteps.i_click_listToggle();
	}

	@Then("^I select Listing options \"([^\"]*)\"$")
	public void i_select_listing_options(String listOption) throws Exception {
		customizeServiceSteps.i_select_listing_options(listOption);
	}

	// ************ ac31339 code Ends	
	
	//ab18364
//	@Then("^I click on Telephone Number and then click on More TNs$")
//	public void i_click_on_Telephone_Number_and_then_click_on_More_TNs(){
//		customizeServiceSteps.click_Telephone_Number();
//	}
}
