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
import com.silvercar.dealerwareandroid.base.Base;
import com.silvercar.dealerwareandroid.screen.ChooseCompanyScreen;
import com.silvercar.dealerwareandroid.screen.CustomerScreen;
import com.silvercar.dealerwareandroid.screen.DropOffDateScreen;
import com.silvercar.dealerwareandroid.screen.LoginScreen;
import com.silvercar.dealerwareandroid.screen.NewReservationScreen;
import com.silvercar.dealerwareandroid.screen.PickupDateScreen;
import com.silvercar.dealerwareandroid.screen.VehiclesScreen;
import com.silvercar.dealerwareandroid.utilities.ApiUtility;
import com.silvercar.dealerwareandroid.utilities.Utility;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC009ContractFuturePickUpDropOffDates extends Base {
    @Test(enabled = true, priority = 0)
    public void contractFuturePickUpDropOffDatesStartReservation() throws 
                ConfigurationException, IOException, ParseException, APIException {
         test = extent.createTest("Availability vechicleGroup Validations");
            ApiUtility apiUtil = new ApiUtility();
            SoftAssert softAssert = new SoftAssert();
            LoginScreen loginScreen = new LoginScreen();
            CustomerScreen customerScreen = new CustomerScreen();
            ChooseCompanyScreen chooseCompany = new ChooseCompanyScreen();
            NewReservationScreen newReservationScreen = new NewReservationScreen();
            PickupDateScreen pickupDateScreen = new PickupDateScreen();
            DropOffDateScreen dropOffDateScreen = new DropOffDateScreen();
            VehiclesScreen vehiclesScreen = new VehiclesScreen();
            Utility utility = new Utility();
            loginScreen.enterEmailField(utility.getFromBaseProperties("validEmail"));
            loginScreen.enterPasswordField(utility.getFromBaseProperties("validPassword"));
            loginScreen.clickLoginButton();
            chooseCompany.selectLocation(utility.getFromBaseProperties("availabiltyCompany"));
            try {
                 RequestSpecification req = RestAssured.given();
                 Response response = req.get(utility.getFromBaseProperties("vinGeneratorUrl"));
                 String vin = response.getBody().asString();
                   String authCode = apiUtil.signIn(utility.getFromBaseProperties("apiSigninUser"),
                           utility.getFromBaseProperties("apiUserPassword"));
                   HashMap<String, String> compDetails = apiUtil
                           .getCompanyDetails(utility.getFromBaseProperties("availabiltyCompany"), authCode);
                   HashMap<String, String> locDetails = apiUtil.getLocationDetails(authCode, compDetails,
                           utility.getFromBaseProperties("availabiltyLocation"));
                   response = null;
                    response = apiUtil.createCustomer(authCode, locDetails.get("id"));
                   test.info("User Created Through API");
                   HashMap<String, String> customerDetails = new HashMap<String, String>();
                   JSONParser jsonParser = new JSONParser();
                   JSONObject jsonObject = (JSONObject) jsonParser.parse(response.body().asString());
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
                   selectPickupDropoffDate(newReservationScreen, pickupDateScreen, dropOffDateScreen);
                   newReservationScreen.selectServiceAdvisor();
                   newReservationScreen.clickVehicleGroupLabel();
                   newReservationScreen.serviceAdvisorCell.get(0).click();
                   pickupDateScreen.clickSaveSelectionButton();
                   newReservationScreen.clickAssignVehicleButton();
                   vehiclesScreen.searchVehicle(carDeatils.get("VIN"));
                   utility.scrollElementToView(carDeatils.get("License"));
                   utility.getDynamicElement(getDriver(), carDeatils.get("License")).click();
                   softAssert.assertEquals(utility.getToastMessgaes(), 
                          "This reservation is not scheduled to begin today.",
                              "Testing Location name  is match after login");
                   test.log(Status.PASS, "Location name are matching after login");
                   softAssert.assertAll();
            } catch (Exception e) {
                   test.log(Status.FAIL, e.getMessage(),
                           MediaEntityBuilder.createScreenCaptureFromPath(screenShot(getDriver())).build());
                   Assert.assertTrue(false, e.getMessage());
             }
    }

    
     public void selectPickupDropoffDate(NewReservationScreen newReservationScreen,
             PickupDateScreen pickupDateScreen, DropOffDateScreen dropOffDateScreen) {
   newReservationScreen.clickPickupLabel();
   pickupDateScreen.selectPickupDate2();
   pickupDateScreen.clickLabel12am();
   pickupDateScreen.clickSaveSelectionButton();
   newReservationScreen.clickDropOffLabel();
   dropOffDateScreen.selectPickupDate2();
   dropOffDateScreen.clickLabel12am();
   dropOffDateScreen.clickSaveSelectionButton();
}

}
