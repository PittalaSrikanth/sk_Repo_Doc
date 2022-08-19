package com.ctl.it.qa.eshop.tests.stepdefinitions;

import org.junit.Assert;

import com.ctl.it.qa.eshop.steps.OrderSteps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class OrderPageStepDefinition {

	@Steps
	OrderSteps orderSteps;

	@When("^I click on continue button$")
	public void i_click_on_continue_button1() throws Throwable {
		orderSteps.clickOnContinue();
	}
	@Then("^I click on OK, Got it button in Order Disclosures dialog box$")
	public void i_click_on_OK_Got_it_button_in_Order_Disclosures_dialog_box() {
		orderSteps.clicks_On_OK_Got_It_Button();
	}


	@Then("^I should be in Product offer page$")
	public void i_should_be_in_Product_offer_page() {
		try {
			orderSteps.verfyBuildYourOffer();
		} catch (Exception ex) {
			Assert.fail();
		}

	}

	@Then("^I should get build your offer tab on product page$")
	public void i_should_get_build_offer() throws Throwable {
		orderSteps.buildOfferPage();
	}

	@Then("^I select the best \"([^\"]*)\" installation option$")
	public void i_select_the_best_installation_option_Self_Install(String installOpt) throws Throwable {
		orderSteps.selectBestinstallation(installOpt);
	}
	
	/*
	 * Shilpa 
	 * F32417
	 * Click Bypass modem check box as per the feature
	 * 
	 */
	@Then("^I click on Bypass modem rule option$")
	public void i_click_on_Bypass_modem_option() throws Throwable {

		orderSteps.clickBypassModemOption();

	}
	

	@Then("^I select Your \"([^\"]*)\" Modem option$")
	public void i_select_Your_Modem_option(String modemOpt) throws Throwable {
		orderSteps.selectModemOption(modemOpt);
	}

	@Then("^I select \"([^\"]*)\" Ease Option$")
	public void i_select_Ease_Option_Standard(String easeOpt) throws Throwable {
		orderSteps.selectEaseOption(easeOpt);
	}

	@And("^I select CVoip DHP phone$")
	public void i_select_CVoip_DHP_phone() throws Throwable {
		orderSteps.CVoipDHPhone();
	}

	@And("^I select address info popup$")
	public void i_select_address_info_popup() {
		orderSteps.important911AdderessInfoPopUp();
	}

	//Nitish Pots
	@Then("^I select HomePhone$")
	public void i_select_HomePhone() throws Throwable {

		orderSteps.homePhone();

	} 
	//Nitish for Quantity Selection
	@Then("^I select the number of device needed \"([^\"]*)\"$")
	public void i_select_the_number_of_device_needed(String quantity) {

		orderSteps.quatity_selection(quantity);
	}
	//Nitish Pots Mandatory order fix

	@Then("^I select required option for voice mail \"([^\"]*)\"$")
	public void i_select_required_option_for_voice_mail(String passedvalue) throws Exception {

		orderSteps.voice_mail_selection(passedvalue);
	}

	@Then("^I select required option for Wire Maintenance Plan \"([^\"]*)\"$")
	public void i_select_required_option_for_Wire_Maintenance_Plan(String passedvalue) throws Exception {

		orderSteps.Wire_Maintenance_Plan_selection(passedvalue);
	}

	@Then("^I select required option for Port in a phone number\\? \"([^\"]*)\"$")
	public void i_select_required_option_for_Port_in_a_phone_number(String passedvalue) throws Exception {

		orderSteps.Port_in_a_phone_number(passedvalue);
	}

	@Then("^I select required option for Need new jacks or wiring\\? \"([^\"]*)\"$")
	public void i_select_required_option_for_Need_new_jacks_or_wiring(String passedvalue) throws Exception {

		orderSteps.Need_new_jacks_or_wiring(passedvalue);
	}

	//******* ac31339 code starts
	@Then("^I select Internet$")
	public void i_select_Internet() {
		orderSteps.interNet();
	}

	@Then("^I select the Available speed \"([^\"]*)\"$")
	public void i_select_the_available_speed(String Selectspeed) throws Throwable {

		orderSteps.selectAvailableSpeed(Selectspeed);

	}

	@Then("^I select One Pty Residence Line$")
	public void i_select_OnePty_Residence_Line() {
		orderSteps.onePtyResidenceLine();
	}

	@Then("^I select Price for Life Unlimited Phone unlimited Calling$")
	public void i_select_Life_Unlimited_Phone_Unlimited_Calling() {
		orderSteps.lifeUnlimitedPhoneCalling();
	}

	@Then("^I select customize services Internet$")
	public void i_select_Customize_Sevices_Internet() {
		orderSteps.customizeServiceInterNet();
	}
	// ac31339 code Ends
	
	//Nitish code for matching offers for HSI + POTS
	@Then("^I select the suitable matching offer \"([^\"]*)\"$")
	public void i_select_the_suitable_matching_offer(String passedvalue) throws Exception {
		orderSteps.matchingOffersSelected(passedvalue);
	}

	@Then("^I should be in Eshop Product offer page$")
	public void i_should_be_in_Eshop_Product_offer_page() {
		try {
			orderSteps.verfyBuildYourOffer();
		} catch (Exception ex) {
			Assert.fail();
		}
	}

	@Then("^I select the best \"([^\"]*)\" installation option by value$")
	public void i_select_the_best_installation_option_by_value(String installationOption) throws Exception {
		orderSteps.selectBestinstallationByValue(installationOption);
	}

	@When("^I click on continue button after clicking lets Go$")
	public void i_click_on_continue_button_after_clicking_lets_Go() throws Exception {
		orderSteps.clickOnContinueAfterClickingLetsGo();
	}

	@Then("^I click on OK Got it button on Order Disclosures dialog box for NI Order for HSI$")
	public void i_click_on_OK_Got_it_button_on_Order_Disclosures_dialog_box_for_NI_Order_for_HSI() {
		orderSteps.handles_Order_Disclosures_For_NI_Order_For_HSI();
	}

    @Then("^I select HomePhone only by deselecting Internet$")
    public void i_select_HomePhone_only() throws Throwable {  
    	orderSteps.homePhoneonly();
    } 
   
    @Then("^I select DTV$")
    public void i_select_DTV() throws Throwable {
    	orderSteps.directTV();
    }
    
	@Then("^I validate installation option in Product offer Page \"([^\"]*)\"$")
	public void i_validate_installation_option_product_offer_page(String install_option) throws Throwable {
		orderSteps.validateInstallOption(install_option);
	}
	
	@Then("^I validate Product offer Page speed \"([^\"]*)\" device \"([^\"]*)\" easeoption \"([^\"]*)\" modem \"([^\"]*)\" and jack \"([^\"]*)\"$")
	public void i_validate_product_offer_page(String speed,String device,String easeOption,String modem,String jack) throws Throwable {
		orderSteps.validateProductOffer(speed,device,easeOption,modem,jack);
	}
	
	@Then("^I validate Product offer Page speed voicemail \"([^\"]*)\" wire maintenance plan \"([^\"]*)\" port \"([^\"]*)\" and jack \"([^\"]*)\"$")
	public void i_validate_product_offer_page(String voiceMail,String wirePlan,String port,String jack) throws Throwable {
		orderSteps.validateProductOfferPot(voiceMail,wirePlan,port,jack);
	}
	
	/*
	 * Shilpa
	 * Move discoluser pop up handler
	 * 
	 */
	@Then("^I click on OK Got it button on Order Disclosures dialog box for Move Order for HSI$")
    public void i_click_on_OK_Got_it_button_on_Order_Disclosures_dialog_box_for_Move_Order_for_HSI() {
           orderSteps.handles_Order_Disclosures_For_Move_Order_For_HSI();
    }
	
	//ac42889
	@And("^I click on continue button change account page$")
    public void i_click_on_continue_button_change_account_page() throws Throwable {
           orderSteps.clickOnContinuebutton();
    }
	@And("^I select Macd Your \"([^\"]*)\" Modem option$")
	public void i_select_MacdModem_DropDown(String Macdmodem) throws Throwable {
        orderSteps.clickOnMacdDropDown(Macdmodem);
	
	}
	
	/*
	 * Shilpa - F36408 choose last speed option in the product list HSI
	 */
	@Then("I choose last speed option$")
	public void i_choose_last_speed_option() {
		orderSteps.chooseLastHSISpeedFromList();
	}
	
	/*
	 * Shilpa - F36408
	 * Choose Self Intall
	 * 
	 */
	@Then("I select the self install option$")
	public void i_select_the_self_install_otpion() throws Throwable {
		orderSteps.selectSelfInstall();
	}
	
	/*
	 * Shilpa 
	 * F32417
	 * Click Bypass modem check box as per the feature
	 * 
	 */
	@Then("^I select Your \"([^\"]*)\" Modem option for Change$")
	public void i_select_Your_Modem_option_for_change(String modemOpt) throws Throwable {

		orderSteps.selectModemOptionForChange(modemOpt);

	}

}
