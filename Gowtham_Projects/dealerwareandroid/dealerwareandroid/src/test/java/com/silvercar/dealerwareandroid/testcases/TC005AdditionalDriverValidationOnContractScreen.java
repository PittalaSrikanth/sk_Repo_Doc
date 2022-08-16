package com.silvercar.dealerwareandroid.testcases;

import java.io.IOException;
import java.util.HashMap;

import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.silvercar.dealerwareandroid.base.Base;
import com.silvercar.dealerwareandroid.screen.AdditionalDriverScreen;
import com.silvercar.dealerwareandroid.screen.ChooseCompanyScreen;
import com.silvercar.dealerwareandroid.screen.ContractOverViewScreen;
import com.silvercar.dealerwareandroid.screen.CreateContractScreen;
import com.silvercar.dealerwareandroid.screen.CustomerScreen;
import com.silvercar.dealerwareandroid.screen.LoginScreen;
import com.silvercar.dealerwareandroid.screen.NewReservationScreen;
import com.silvercar.dealerwareandroid.utilities.ApiUtility;
import com.silvercar.dealerwareandroid.utilities.Utility;

import io.restassured.response.Response;

public class TC005AdditionalDriverValidationOnContractScreen  extends Base {
    
     @Test(enabled = true, priority = 0)
        public void additionalDriverValidationOnContractScreen() throws ConfigurationException, IOException {
            
             test = extent.createTest("Additional Driver Validation On Contract Screen");
             ApiUtility apiUtil = new ApiUtility();
                Utility utilities = new Utility();
                SoftAssert softAssert = new SoftAssert();
                LoginScreen loginScreen = new LoginScreen();
                CustomerScreen customerScreen = new CustomerScreen();
                ChooseCompanyScreen chooseCompany = new ChooseCompanyScreen();
                ContractOverViewScreen contractOverViewScreen = new ContractOverViewScreen();
                CreateContractScreen createContractScreen = new CreateContractScreen();
                NewReservationScreen newReservationScreen = new NewReservationScreen();
                AdditionalDriverScreen additionalDriverScreen = new AdditionalDriverScreen();
                Utility utility = new Utility();
                loginScreen.enterEmailField(utility.getFromBaseProperties("validEmail"));
                loginScreen.enterPasswordField(utility.getFromBaseProperties("validPassword"));
                loginScreen.clickLoginButton();
                chooseCompany.selectLocation(utility.getFromBaseProperties("USLocation1"));
                try {
                    String authCOde = apiUtil.signIn(utilities.getFromBaseProperties("apiSigninUser"),
                            utilities.getFromBaseProperties("apiUserPassword"));
                    HashMap<String, String> compDetails = apiUtil
                            .getCompanyDetails(utilities.getFromBaseProperties("USLocation1"), authCOde);
                    HashMap<String, String> locDetails = apiUtil.getLocationDetails(authCOde, compDetails,
                            utilities.getFromBaseProperties("USLocation1"));
                    Response res = apiUtil.createCustomer(authCOde, locDetails.get("id"));
                    test.info("User Created Through API");
                    HashMap<String, String> customerDetails = new HashMap<String, String>();
                    JSONParser jsonParser = new JSONParser();
                    JSONObject jsonObject = (JSONObject) jsonParser.parse(res.body().asString());
                    customerDetails.put("full_name", (String) jsonObject.get("full_name"));
                    customerDetails.put("email", (String) jsonObject.get("email"));
                    customerDetails.put("id", String.valueOf(jsonObject.get("id")));
                    apiUtil.addDriverLicense(authCOde, locDetails.get("id"), customerDetails.get("id"));
                    test.info("Added Driver License to Created User ");
                    apiUtil.addCreditCard(authCOde, locDetails.get("id"), customerDetails.get("id"));
                    test.info("Added Credit Card to Created User ");
                    apiUtil.addInsurence(authCOde, locDetails.get("id"), customerDetails.get("id"));
                    test.info("Added Insurence to Created User ");
                    customerScreen.enterSearchKey(customerDetails.get("email"));
                    customerScreen.getCustomerNames().get(0).click();
                    utilities.waitForElementToDisplay(getDriver(), customerScreen.personalInfoLabel);
                    utilities.waitForElementToClickable(getDriver(), customerScreen.createContract);
                    customerScreen.clickCreateContract();
                    utilities.waitForElementToDisplay(getDriver(), newReservationScreen.assignVehicleButton);
                    String customerName = newReservationScreen.getCustomerNameLable();
                    newReservationScreen.selectServiceAdvisor();
                    newReservationScreen.clickAdditionalDriver();
                    additionalDriverScreen.enterDriverFirstName(utility.getRandomName("randomFirstName"));
                    additionalDriverScreen.enterDriverLastName(utility.getRandomName("randomLastName"));
                    additionalDriverScreen.enterDateOfBirth(utility.getFutureAndPastDate("past", 23 * 360));
                    additionalDriverScreen.enterDriverLicenseNumber(utility.getRandomName("driverLicenseNumber"));
                    additionalDriverScreen.enterExpirationDate(utility.getFutureAndPastDate("future", 15));
                    additionalDriverScreen.selectState(utilities.getFromBaseProperties("state"));
                    additionalDriverScreen.enterPhoneNumber(utility.getFromBaseProperties("randomPhone"));
                    additionalDriverScreen.enterEmailAddress(utility.getRandomEmail("randomEmail"));
                    utility.scrollElementToView("ADD DRIVER TO CONTRACT");
                    additionalDriverScreen.clickAddDriverToContractButton();
                    String additionalDriverDeatils = newReservationScreen.getAdditionalDriverOne();
                    softAssert.assertEquals(utility.getFromBaseProperties("randomFirstName") + " "
                          + utility.getFromBaseProperties("randomLastName"), additionalDriverDeatils, 
                              "additional driver deatils is not added to reservation Screen");
                    newReservationScreen.clickSaveButton();
                    utilities.waitForElementToDisplay(getDriver(), createContractScreen.contractHeader);
                    utilities.getDynamicElement(getDriver(), customerName).click();
                    contractOverViewScreen.clickAdditionalDriverLabel();
                    softAssert.assertEquals(utility.getFromBaseProperties("randomFirstName"),
                        additionalDriverScreen.getDriverFirstName(), "Additional Driver First name not Matched");
                    softAssert.assertEquals(utility.getFromBaseProperties("randomLastName"),
                        additionalDriverScreen.getDriverLastName(), "Additional Driver Last name not Matched");
                    softAssert.assertEquals(utility.getFutureAndPastDate("past", 23 * 360),
                        additionalDriverScreen.getDateOfBirth(), "Additional Driver Date of birth not Matched");
                    softAssert.assertEquals(utility.getFromBaseProperties("driverLicenseNumber"),
                       additionalDriverScreen.getDriverLicenseNumber(), "Additional Driver license number not Matched");
                    softAssert.assertEquals(utility.getFutureAndPastDate("future", 15),
                        additionalDriverScreen.getExpirationDate(), "Additional Driver expiration date not Matched");
                    softAssert.assertEquals(utility.getFromBaseProperties("randomEmail"),
                        additionalDriverScreen.getEmail(), "Additional Driver email is not Matched");
                    softAssert.assertEquals(utility.getFromBaseProperties("randomPhone"),
                        additionalDriverScreen.getPhoneNumber(), "Additional Driver Phone Number not Matched");
                    softAssert.assertEquals(utility.getFromBaseProperties("state"),
                         additionalDriverScreen.getSelectedState(), "Additional Driver selected State not Matched");
                    additionalDriverScreen.clickNavigateUp();
                    contractOverViewScreen.clickDeleteButton();
                    contractOverViewScreen.clickYesButton();
                    utilities.waitForElementToDisplay(getDriver(), createContractScreen.contractHeader);
                    softAssert.assertEquals(false, utilities.isDisplayed(customerName));
                    try {
                         softAssert.assertAll();
                         test.log(Status.PASS, "Test Pass");
                     } catch (AssertionError e) {
                         test.log(Status.FAIL, e.getMessage());
                         Assert.assertTrue(false, e.getMessage());
                     }
                    
                } catch (Exception e) {
                    softAssert.assertAll();
                    test.log(Status.FAIL, e.getMessage(),
                            MediaEntityBuilder.createScreenCaptureFromPath(screenShot(getDriver())).build());
                    Assert.assertTrue(false, e.getMessage());
                }
     }
}
