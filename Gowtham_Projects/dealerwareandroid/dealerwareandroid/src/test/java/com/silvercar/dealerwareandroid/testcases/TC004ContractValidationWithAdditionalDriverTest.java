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
import com.silvercar.dealerwareandroid.screen.AcknowledgementScreen;
import com.silvercar.dealerwareandroid.screen.AdditionalDriverScreen;
import com.silvercar.dealerwareandroid.screen.AgreementScreen;
import com.silvercar.dealerwareandroid.screen.BottomMenuScreen;
import com.silvercar.dealerwareandroid.screen.ChooseCompanyScreen;
import com.silvercar.dealerwareandroid.screen.ContractDetailsScreen;
import com.silvercar.dealerwareandroid.screen.CreateContractScreen;
import com.silvercar.dealerwareandroid.screen.CustomerScreen;
import com.silvercar.dealerwareandroid.screen.EditVehicleDetailsScreen;
import com.silvercar.dealerwareandroid.screen.LoginScreen;
import com.silvercar.dealerwareandroid.screen.NewReservationScreen;
import com.silvercar.dealerwareandroid.screen.PaymentScreen;
import com.silvercar.dealerwareandroid.screen.ReviewScreen;
import com.silvercar.dealerwareandroid.screen.SignatureScreen;
import com.silvercar.dealerwareandroid.screen.VehicleDetailsScreen;
import com.silvercar.dealerwareandroid.screen.VehiclesScreen;
import com.silvercar.dealerwareandroid.utilities.ApiUtility;
import com.silvercar.dealerwareandroid.utilities.Utility;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC004ContractValidationWithAdditionalDriverTest extends Base {
    @Test(enabled = true, priority = 0)
    public void contractValidationWithAdditionalDriver() throws ConfigurationException, IOException {
        
         test = extent.createTest("Contract Validation With Additional Driver Test");

            ApiUtility apiUtil = new ApiUtility();
            Utility utilities = new Utility();
            SoftAssert softAssert = new SoftAssert();
            LoginScreen loginScreen = new LoginScreen();
            CustomerScreen customerScreen = new CustomerScreen();
            ChooseCompanyScreen chooseCompany = new ChooseCompanyScreen();
            EditVehicleDetailsScreen editVehicleDetailsScreen = new EditVehicleDetailsScreen();
            VehicleDetailsScreen vehicleDetailsScreen = new VehicleDetailsScreen();
            AgreementScreen agreementScreen = new AgreementScreen();
            AcknowledgementScreen acknowledgementScreen = new AcknowledgementScreen();
            ContractDetailsScreen contractDetailsScreen = new ContractDetailsScreen();
            BottomMenuScreen bottomMenuScreen = new BottomMenuScreen();
            VehiclesScreen vehiclesScreen = new VehiclesScreen();
            CreateContractScreen createContractScreen = new CreateContractScreen();
            ReviewScreen reviewScreen = new ReviewScreen();
            PaymentScreen paymentScreen = new PaymentScreen();
            SignatureScreen signatureScreen = new SignatureScreen();
            NewReservationScreen newReservationScreen = new NewReservationScreen();
            AdditionalDriverScreen additionalDriverScreen = new AdditionalDriverScreen();
            Utility utility = new Utility();
            loginScreen.enterEmailField(utility.getFromBaseProperties("validEmail"));
            loginScreen.enterPasswordField(utility.getFromBaseProperties("validPassword"));
            loginScreen.clickLoginButton();
            chooseCompany.selectLocation(utility.getFromBaseProperties("USLocation1"));
            try {
                RequestSpecification req = RestAssured.given();
                Response response = req.get(utilities.getFromBaseProperties("vinGeneratorUrl"));
                String vin = response.getBody().asString();
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
                response = null;
                response = apiUtil.createCar(authCOde, locDetails.get("id"), vin);
                test.info("Created new Car Through API");
                HashMap<String, String> carDeatils = new HashMap<String, String>();
                JSONObject car = (JSONObject) jsonParser.parse(response.body().asString());
                carDeatils.put("VIN", (String) car.get("vin"));
                carDeatils.put("License", (String) car.get("license"));
                customerScreen.enterSearchKey(customerDetails.get("email"));
                customerScreen.getCustomerNames().get(0).click();
                utilities.waitForElementToDisplay(getDriver(), customerScreen.personalInfoLabel);
                utilities.waitForElementToClickable(getDriver(), customerScreen.createContract);
                customerScreen.clickCreateContract();
                utilities.waitForElementToDisplay(getDriver(), newReservationScreen.assignVehicleButton);
                newReservationScreen.selectServiceAdvisor();
                newReservationScreen.clickAdditionalDriver();
                additionalDriverScreen.enterDriverFirstName(utility.getRandomName("randomFirstName"));
                additionalDriverScreen.enterDriverLastName(utility.getRandomName("randomLastName"));
                additionalDriverScreen.enterDateOfBirth(utility.getFutureAndPastDate("past", 23 * 360));
                additionalDriverScreen.enterDriverLicenseNumber(utility.getRandomName("driverLicenseNumber"));
                additionalDriverScreen.enterExpirationDate(utility.getFutureAndPastDate("future", 15));
                additionalDriverScreen.enterPhoneNumber(utility.getFromBaseProperties("randomPhone"));
                additionalDriverScreen.enterEmailAddress(utility.getRandomEmail("randomEmail"));
                utility.scrollElementToView("ADD DRIVER TO CONTRACT");
                additionalDriverScreen.clickAddDriverToContractButton();
                String additionalDriverDeatils = newReservationScreen.getAdditionalDriverOne();
                softAssert.assertEquals(utility.getFromBaseProperties("randomFirstName") + " "
                      + utility.getFromBaseProperties("randomLastName"), additionalDriverDeatils, "additional driver "
                          + "deatils is not added to reservation Screen");
                newReservationScreen.clickAssignVehicleButton();
                vehiclesScreen.searchVehicle(carDeatils.get("VIN"));
                utilities.getDynamicElement(getDriver(), carDeatils.get("License")).click();
                editVehicleDetailsScreen.setFuelLevel(0.8f);
                editVehicleDetailsScreen.setOdometerReading("170");
                editVehicleDetailsScreen.clickSaveButton();
                softAssert.assertEquals("Odometer reading is 70 miles higher than last reported",
                        editVehicleDetailsScreen.getOdometerMessage());
                editVehicleDetailsScreen.clickSaveButton1();
                vehicleDetailsScreen.clickContinue();
                utilities.waitForElementToDisplay(getDriver(), contractDetailsScreen.primaryDriver);
                softAssert.assertEquals(contractDetailsScreen.getPrimaryDriver(), customerDetails.get("full_name"),
                        "Primary Driver Details not matched in Contract Details screen");
                contractDetailsScreen.clickOnThisDeviceButton();
                utilities.waitForElementToDisplay(getDriver(), vehicleDetailsScreen.continueButton);
                vehicleDetailsScreen.clickContinue();
                utility.waitForElementToDisplay(getDriver(), agreementScreen.checkboxAgreement);
                agreementScreen.clickCheckboxAgreement();
                agreementScreen.clickDismissButton();
                acknowledgementScreen.selectSliders();            
                acknowledgementScreen.clickAgreeAndContinueButton();
                Thread.sleep(5000);
                signatureScreen.addSignature();
                signatureScreen.clickSignContarctButton();
                utility.waitForElementToDisplay(getDriver(), signatureScreen.continueToNextDriver);
                signatureScreen.clickContinueToNextDriver();
                utility.waitForElementToDisplay(getDriver(), agreementScreen.checkboxAgreement);
                agreementScreen.clickCheckboxAgreement();
                agreementScreen.clickDismissButton();
                Thread.sleep(5000);
                signatureScreen.addSignature();
                signatureScreen.clickSignAndStartContract();
                utilities.waitForElementToDisplay(getDriver(), createContractScreen.contractHeader);
                bottomMenuScreen.clickVehicles();
                vehiclesScreen.searchVehicle(carDeatils.get("VIN"));
                utilities.getDynamicElement(getDriver(), carDeatils.get("License")).click();
                vehiclesScreen.clickFinishContract();
                editVehicleDetailsScreen.setFuelLevel(0.4f);
                editVehicleDetailsScreen.setOdometerReading("250");
                editVehicleDetailsScreen.clickSaveButton();
                softAssert.assertEquals(reviewScreen.getStartingMileage(),
                        "170", "Starting mileage is not matched in Review screen");
                softAssert.assertEquals(reviewScreen.getEndingMileage(),
                        "250", "ending mileage is not matched in Review screen");
                softAssert.assertEquals(reviewScreen.getTotalDistanceTraveled(), "80",
                        "Total distance traveled is not matched in Review screen");
                reviewScreen.clickFinishContract();
                reviewScreen.clickFinishButton();
                paymentScreen.clickChargeCustomer();
                utilities.waitForElementToDisplay(getDriver(), createContractScreen.contractHeader);
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
