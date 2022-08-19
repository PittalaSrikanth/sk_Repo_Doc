package com.ctl.it.qa.eshop.tests.stepdefinitions;

import com.ctl.it.qa.eshop.steps.DisconnectSteps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;

public class DisconnectStepDefinition {

    @Steps
    DisconnectSteps  disconnectsteps;
    
    @Then("^I enter Internet Disconnect Reason$")
    public void i_enter_internet_Disconnect_Reason() throws Throwable {

           disconnectsteps.enterInternetdisconnectreason();
           
    }
    
           
    @Then("^I enter POTS Disconnect Reason$")
    public void i_enter_POTS_Disconnect_Reason() throws Throwable {

           disconnectsteps.enterPotsdisconnectreason();
           
    }
    @Then("^I enter CVOIP Disconnect Reason$")
    public void i_enter_CVOIP_Disconnect_Reason() throws Throwable {

           disconnectsteps.enterPotsdisconnectreason();
           
    }
                      
       
    @And("^I click again on continue button on DIS Page$")
    public void i_click_again_on_continue_button_on_DIS_Page() throws Throwable {

           disconnectsteps.clickoncontinue();
           
    }
    
    @And("^I click on continue button on Product and Service$")
    public void i_click_on_continue_button_on_product_and_service() throws Throwable {

           disconnectsteps.clickoncontinue02();
           
    }
    
           
    
    @And("^I click on continue button on Account Information$")
    public void i_click_on_continue_button_on_Account_Information() throws Throwable {

           disconnectsteps.clickoncontinueonacountinformation();
           
    }
    @And("^I select current Billing Address option$")
    public void i_select_current_billing_address_option() throws Throwable {

           disconnectsteps.selectcurrentbillingaddress();
           
    }      
}
