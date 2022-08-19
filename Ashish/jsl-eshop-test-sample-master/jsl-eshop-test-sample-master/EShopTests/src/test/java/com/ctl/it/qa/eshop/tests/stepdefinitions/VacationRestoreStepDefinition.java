package com.ctl.it.qa.eshop.tests.stepdefinitions;

import com.ctl.it.qa.eshop.steps.VacationRestoreSteps;

import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;

public class VacationRestoreStepDefinition {
	
	@Steps
	VacationRestoreSteps vacationRestoreUser;
	
	@Then("^I select Vacation Restore from the dialog box$")
	public void i_select_Vacation_Restore_from_the_dialog_box() throws Exception {
		vacationRestoreUser.selects_Vacation_Restore_For_HSI();
	}
	
	//ac50097
	@Then("^select Vacation Restore$")
	public void select_Vacation_Restore() {
		vacationRestoreUser.selects_Vacation_Restore();
	}
	
	//ac50097
	@Then("^I click continue on vacation Product offer Page$")
	public void i_click_continue_on_vacation_Product_offer_Page() {
		vacationRestoreUser.i_click_continue_on_vacation_Product_offer_Page();
	}


}
