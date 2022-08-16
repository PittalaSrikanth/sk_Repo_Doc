package com.silvercar.dealerwareandroid.testcases;

import java.io.IOException;
import java.util.HashMap;

import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.silvercar.dealerwareandroid.base.Base;
import com.silvercar.dealerwareandroid.screen.AdditionalDriverScreen;
import com.silvercar.dealerwareandroid.screen.BottomMenuScreen;
import com.silvercar.dealerwareandroid.screen.ChooseCompanyScreen;
import com.silvercar.dealerwareandroid.screen.ContractDetailsScreen;
import com.silvercar.dealerwareandroid.screen.ContractOverViewScreen;
import com.silvercar.dealerwareandroid.screen.CreateContractScreen;
import com.silvercar.dealerwareandroid.screen.CustomerScreen;
import com.silvercar.dealerwareandroid.screen.EditVehicleDetailsScreen;
import com.silvercar.dealerwareandroid.screen.LoginScreen;
import com.silvercar.dealerwareandroid.screen.NewReservationScreen;
import com.silvercar.dealerwareandroid.screen.PaymentScreen;
import com.silvercar.dealerwareandroid.screen.ReviewScreen;
import com.silvercar.dealerwareandroid.screen.VehicleDetailsScreen;
import com.silvercar.dealerwareandroid.screen.VehiclesScreen;
import com.silvercar.dealerwareandroid.utilities.ApiUtility;
import com.silvercar.dealerwareandroid.utilities.Utility;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC006AdditionalDriverWithContactlessContract extends Base {

    @Test(enabled = true, priority = 0)
    public void additionalDriverWithContactlessContract() throws 
                  ConfigurationException, IOException, ParseException {

        test = extent.createTest("Additional Driver With Contactless Contract ");
        ApiUtility apiUtil = new ApiUtility();
        SoftAssert softAssert = new SoftAssert();
        LoginScreen loginScreen = new LoginScreen();
        CustomerScreen customerScreen = new CustomerScreen();
        ChooseCompanyScreen chooseCompany = new ChooseCompanyScreen();
        ContractOverViewScreen contractOverViewScreen = new ContractOverViewScreen();
        CreateContractScreen createContractScreen = new CreateContractScreen();
        NewReservationScreen newReservationScreen = new NewReservationScreen();
        AdditionalDriverScreen additionalDriverScreen = new AdditionalDriverScreen();
        EditVehicleDetailsScreen editVehicleDetailsScreen = new EditVehicleDetailsScreen();
        VehicleDetailsScreen vehicleDetailsScreen = new VehicleDetailsScreen();
        ContractDetailsScreen contractDetailsScreen = new ContractDetailsScreen();
        VehiclesScreen vehiclesScreen = new VehiclesScreen();
        BottomMenuScreen bottomMenuScreen = new BottomMenuScreen();
        ReviewScreen reviewScreen = new ReviewScreen();
        PaymentScreen paymentScreen = new PaymentScreen();
        Utility utility = new Utility();
        loginScreen.enterEmailField(utility.getFromBaseProperties("validEmail"));
        loginScreen.enterPasswordField(utility.getFromBaseProperties("validPassword"));
        loginScreen.clickLoginButton();
        chooseCompany.selectLocation(utility.getFromBaseProperties("USLocation1"));
        try {
            RequestSpecification req = RestAssured.given();
            Response response = req.get(utility.getFromBaseProperties("vinGeneratorUrl"));
            String vin = response.getBody().asString();
            String authCode = apiUtil.signIn(utility.getFromBaseProperties("apiSigninUser"),
                    utility.getFromBaseProperties("apiUserPassword"));
            HashMap<String, String> compDetails = apiUtil
                    .getCompanyDetails(utility.getFromBaseProperties("USLocation1"), authCode);
            HashMap<String, String> locDetails = apiUtil.getLocationDetails(authCode, compDetails,
                    utility.getFromBaseProperties("USLocation1"));
            Response res = apiUtil.createCustomer(authCode, locDetails.get("id"));
            test.info("User Created Through API");
            HashMap<String, String> customerDetails = new HashMap<String, String>();
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(res.body().asString());
            customerDetails.put("full_name", (String) jsonObject.get("full_name"));
            customerDetails.put("email", (String) jsonObject.get("email"));
            customerDetails.put("id", String.valueOf(jsonObject.get("id")));
            apiUtil.addDriverLicense(authCode, locDetails.get("id"), customerDetails.get("id"));
            test.info("Added Driver License to Created User ");
            apiUtil.addCreditCard(authCode, locDetails.get("id"), customerDetails.get("id"));
            test.info("Added Credit Card to Created User ");
            apiUtil.addInsurence(authCode, locDetails.get("id"), customerDetails.get("id"));
            test.info("Added Insurence to Created User ");
            response = null;
            response = apiUtil.createCar(authCode, locDetails.get("id"), vin);
            test.info("Created new Car Through API");
            HashMap<String, String> carDeatils = new HashMap<String, String>();
            JSONObject car = (JSONObject) jsonParser.parse(response.body().asString());
            carDeatils.put("VIN", (String) car.get("vin"));
            carDeatils.put("License", (String) car.get("license"));
            customerScreen.enterSearchKey(customerDetails.get("email"));
            customerScreen.getCustomerNames().get(0).click();
            utility.waitForElementToDisplay(getDriver(), customerScreen.personalInfoLabel);
            utility.waitForElementToClickable(getDriver(), customerScreen.createContract);
            customerScreen.clickCreateContract();
            utility.waitForElementToDisplay(getDriver(), newReservationScreen.assignVehicleButton);
            String customerName = newReservationScreen.getCustomerNameLable();
            newReservationScreen.selectServiceAdvisor();
            newReservationScreen.clickAdditionalDriver();
            additionalDriverScreen.enterDriverFirstName(utility.getRandomName("randomFirstName"));
            additionalDriverScreen.enterDriverLastName(utility.getRandomName("randomLastName"));
            additionalDriverScreen.enterDateOfBirth(utility.getFutureAndPastDate("past", 23 * 360));
            additionalDriverScreen.enterDriverLicenseNumber(utility.getRandomName("driverLicenseNumber"));
            additionalDriverScreen.enterExpirationDate(utility.getFutureAndPastDate("future", 15));
            additionalDriverScreen.selectCountry(utility.getFromBaseProperties("country"));
            additionalDriverScreen.selectState(utility.getFromBaseProperties("state"));
            additionalDriverScreen.enterPhoneNumber(utility.getFromBaseProperties("randomPhone"));
            additionalDriverScreen.enterEmailAddress(utility.getRandomEmail("randomEmail"));
            utility.scrollElementToView("ADD DRIVER TO CONTRACT");
            additionalDriverScreen.clickAddDriverToContractButton();
            String additionalDriverDeatils = newReservationScreen.getAdditionalDriverOne();
            softAssert.assertEquals(
                    utility.getFromBaseProperties("randomFirstName") + " "
                            + utility.getFromBaseProperties("randomLastName"),
                    additionalDriverDeatils, "additional driver"
                            + " deatils is not added to reservation Screen");
            newReservationScreen.clickSaveButton();
            utility.waitForElementToDisplay(getDriver(), createContractScreen.contractHeader);
            utility.getDynamicElement(getDriver(), customerName).click();
            contractOverViewScreen.clickAssignVehicleButton();
            vehiclesScreen.searchVehicle(carDeatils.get("VIN"));
            utility.getDynamicElement(getDriver(), carDeatils.get("License")).click();
            editVehicleDetailsScreen.setFuelLevel(0.5f);
            editVehicleDetailsScreen.setOdometerReading("230");
            editVehicleDetailsScreen.clickSaveButton();
            editVehicleDetailsScreen.clickSaveButton1();
            vehicleDetailsScreen.clickContinue();
            contractDetailsScreen.clickContactlessButton();
            contractDetailsScreen.clickSendEmailsButton();
            contractDetailsScreen.clickCloseButton();
            utility.waitForElementToDisplay(getDriver(), createContractScreen.contractHeader);
            String contractID = getDriver().findElementByXPath("//*[@text='"
                    + customerDetails.get("full_name") + "']/..//*[contains(@text,'Contract id:')]")
                        .getAttribute("text").split(":")[1];
            String contractStatus = getDriver().findElementByXPath("//*[contains(@text,'"
                    + customerDetails.get("full_name") + "')]/..//*[@resource-id="
                            + "\"com.silvercar.dealerware:id/contract_status\"]")
                        .getAttribute("text");
            softAssert.assertEquals("Signature Pending", contractStatus.trim(), 
                    "Contract Status is not Signature Pending");
            apiUtil.contactlessContract(authCode, compDetails.get("token"), "1.9.2", contractID);
            
            Response res1 = apiUtil.getAdditionalDrivers(contractID, authCode, locDetails.get("id"));
             jsonParser = new JSONParser();
             jsonObject = (JSONObject) ((JSONArray) jsonParser.parse(res1.asString())).get(0);
            String additionalDriverId = jsonObject.get("id").toString();
            apiUtil.additionalDriverSignature(additionalDriverId, authCode);
            bottomMenuScreen.clickSettings();
            bottomMenuScreen.clickContracts();
            String contractStatusAfterSignature = getDriver().findElementByXPath("//*[contains(@text,'"
                    + customerDetails.get("full_name") + "')]/..//*[@resource-id="
                            + "\"com.silvercar.dealerware:id/contract_status\"]")
                        .getAttribute("text");
            softAssert.assertEquals("Signature Submitted", contractStatusAfterSignature.trim(),
                    "Contract Status is not Signature Submitted");
            utility.getDynamicElement(getDriver(), customerName).click();
            utility.waitForElementToDisplay(getDriver(), contractOverViewScreen.startContractButton);
            contractOverViewScreen.clickStartContractButton();
            bottomMenuScreen.clickVehicles();
            vehiclesScreen.searchVehicle(carDeatils.get("VIN"));
            utility.getDynamicElement(getDriver(), carDeatils.get("License")).click();
            vehiclesScreen.clickFinishContract();
            editVehicleDetailsScreen.setFuelLevel(0.4f);
            editVehicleDetailsScreen.setOdometerReading("350");
            editVehicleDetailsScreen.clickSaveButton();
            reviewScreen.clickFinishContract();
            reviewScreen.clickFinishButton();
            paymentScreen.clickDoneButton();
            utility.waitForElementToDisplay(getDriver(), createContractScreen.contractHeader);
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
