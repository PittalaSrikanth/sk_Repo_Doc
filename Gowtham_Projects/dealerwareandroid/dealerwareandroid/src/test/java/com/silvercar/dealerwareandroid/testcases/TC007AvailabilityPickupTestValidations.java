package com.silvercar.dealerwareandroid.testcases;

import java.io.IOException;
import java.util.HashMap;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.silvercar.dealerwareandroid.TestRail.APIException;
import com.silvercar.dealerwareandroid.TestRail.TestRailManager;
import com.silvercar.dealerwareandroid.base.Base;
import com.silvercar.dealerwareandroid.screen.ChooseCompanyScreen;
import com.silvercar.dealerwareandroid.screen.CustomerScreen;
import com.silvercar.dealerwareandroid.screen.LoginScreen;
import com.silvercar.dealerwareandroid.screen.NewReservationScreen;
import com.silvercar.dealerwareandroid.screen.PickupDateScreen;
import com.silvercar.dealerwareandroid.utilities.ApiUtility;
import com.silvercar.dealerwareandroid.utilities.Utility;
import io.restassured.response.Response;

public class TC007AvailabilityPickupTestValidations  extends Base {
    @Test(enabled = true, priority = 0)
    public void availabityPickupTestValidations() throws 
                  ConfigurationException, IOException, ParseException, APIException {
        
        String[] testCaseIDs = {"944", "943"};
         test = extent.createTest(" Availability Pickup Test Validations");
        ApiUtility apiUtil = new ApiUtility();
        SoftAssert softAssert = new SoftAssert();
        LoginScreen loginScreen = new LoginScreen();
        CustomerScreen customerScreen = new CustomerScreen();
        ChooseCompanyScreen chooseCompany = new ChooseCompanyScreen();
        NewReservationScreen newReservationScreen = new NewReservationScreen();
        PickupDateScreen pickupDateScreen = new PickupDateScreen();
        Utility utility = new Utility();
        loginScreen.enterEmailField(utility.getFromBaseProperties("validEmail"));
        loginScreen.enterPasswordField(utility.getFromBaseProperties("validPassword"));
        loginScreen.clickLoginButton();
        chooseCompany.selectLocation(utility.getFromBaseProperties("availabiltyCompany"));
        try {
               String authCode = apiUtil.signIn(utility.getFromBaseProperties("apiSigninUser"),
                       utility.getFromBaseProperties("apiUserPassword"));
               HashMap<String, String> compDetails = apiUtil
                       .getCompanyDetails(utility.getFromBaseProperties("availabiltyCompany"), authCode);
               HashMap<String, String> locDetails = apiUtil.getLocationDetails(authCode, compDetails,
                       utility.getFromBaseProperties("availabiltyLocation"));
               Response res = apiUtil.createCustomer(authCode, locDetails.get("id"));
               test.info("User Created Through API");
               HashMap<String, String> customerDetails = new HashMap<String, String>();
               JSONParser jsonParser = new JSONParser();
               System.out.println(res.body().asString());
               JSONObject jsonObject = (JSONObject) jsonParser.parse(res.body().asString());
               customerDetails.put("full_name", (String) jsonObject.get("full_name"));
               customerDetails.put("email", (String) jsonObject.get("email"));
               customerDetails.put("id", String.valueOf(jsonObject.get("id")));
               for (int i = 0; i < 5; i++) {
               customerScreen.enterSearchKey(customerDetails.get("email"));
               if (utility.isDisplayed(customerScreen.getCustomerNames().get(0)))
                   customerScreen.getCustomerNames().get(0).click();
               break;
               }
               utility.waitForElementToDisplay(getDriver(), customerScreen.personalInfoLabel);
               utility.waitForElementToClickable(getDriver(), customerScreen.createContract);
               customerScreen.clickCreateContract();
               softAssert.assertEquals(newReservationScreen.getCustomerNameLable(), customerDetails.get("full_name"),
                        "Customer name is not displayed on new Reservation Screen");
               softAssert.assertEquals(utility.isDisplayed(newReservationScreen.pickupLabel), true,
                        "pickup label is not displayed on new Reservation Screen");
               softAssert.assertEquals(utility.isDisplayed(newReservationScreen.dropoffLabel), true,
                        "dropoff label is not displayed on new Reservation Screen");
               softAssert.assertEquals(utility.isDisplayed(newReservationScreen.vehicleGroupLabel), true, 
                        "vehicleGroup label is not displayed on new Reservation Screen");
               softAssert.assertEquals(utility.isDisplayed(newReservationScreen.serviceAdvisorLabel), true, 
                        "serviceAdvisor label is not displayed on new Reservation Screen");
               softAssert.assertEquals(utility.isDisplayed(newReservationScreen.additionalDriverLabel), true, 
                        "additionalDriver label is not displayed on new Reservation Screen");
               softAssert.assertEquals(utility.isDisplayed(newReservationScreen.repairOrder), true, 
                        "repairOrder is not displayed on new Reservation Screen");
               softAssert.assertEquals(utility.isDisplayed(newReservationScreen.serviceVehicleId), true, 
                        "serviceVehicle is not displayed on new Reservation Screen");
               softAssert.assertEquals(utility.isDisplayed(newReservationScreen.saveButton), true, 
                        "saveButton is not displayed on new Reservation Screen");
               softAssert.assertEquals(utility.isDisplayed(newReservationScreen.assignVehicleButton), true, 
                        "assignVehicleButton is not displayed on new Reservation Screen");
               try {
                   softAssert.assertAll();
                   test.log(Status.PASS, "Test Pass");
                   TestRailManager.addResultForTestCase(testCaseIDs[0], TestRailManager.TEST_CASE_PASSED_STATUS, "");
               } catch (AssertionError e) {
                   test.log(Status.FAIL, e.getMessage());
                   TestRailManager.addResultForTestCase(testCaseIDs[0], TestRailManager.TEST_CASE_FAILED_STATUS, "");
               }
               softAssert = new SoftAssert();
               newReservationScreen.clickPickupLabel();
               utility.waitForElementToDisplay(getDriver(), pickupDateScreen.saveSelectionButton);
               softAssert.assertEquals(pickupDateScreen.getToolbarLabel(), "Pickup Date & Time", 
                        "Pickup Date & Time label is not displayed in header section");
               softAssert.assertEquals(utility.isDisplayed(pickupDateScreen.selectDateLabel), true, 
                        "Select a date to see available times label is not displayed ");
               pickupDateScreen.selectPickupDate2();
               pickupDateScreen.clickLabel12am();
               softAssert.assertEquals(pickupDateScreen.saveSelectionButton.isEnabled(), true, 
                        "save button is not enabled after date and time selection");
               pickupDateScreen.clickSaveSelectionButton();
               softAssert.assertEquals(utility.isDisplayed(newReservationScreen.pickupLabel), true, 
                        "screen is not navigated to New reservation screen after clicking save button ");
               try {
                   softAssert.assertAll();
                   test.log(Status.PASS, "Test Pass");
                   TestRailManager.addResultForTestCase(testCaseIDs[1], TestRailManager.TEST_CASE_PASSED_STATUS, "");
               } catch (AssertionError e) {
                   test.log(Status.FAIL, e.getMessage());
                   TestRailManager.addResultForTestCase(testCaseIDs[1], TestRailManager.TEST_CASE_FAILED_STATUS, "");
               }
        } catch (Exception e) {
             test.log(Status.FAIL, e.getMessage(),
                     MediaEntityBuilder.createScreenCaptureFromPath(screenShot(getDriver())).build());
             TestRailManager.addResultForTestCase(testCaseIDs[0], TestRailManager.TEST_CASE_FAILED_STATUS, "");
             TestRailManager.addResultForTestCase(testCaseIDs[1], TestRailManager.TEST_CASE_FAILED_STATUS, "");
             Assert.assertTrue(false, e.getMessage());
        }
        
    }

}
