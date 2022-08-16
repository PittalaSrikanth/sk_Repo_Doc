package com.silvercar.dealerwareandroid.testcases;

import java.io.IOException;
import java.util.List;
import org.apache.commons.configuration.ConfigurationException;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.silvercar.dealerwareandroid.TestRail.APIException;
import com.silvercar.dealerwareandroid.TestRail.TestRailManager;
import com.silvercar.dealerwareandroid.base.Base;
import com.silvercar.dealerwareandroid.screen.BottomMenuScreen;
import com.silvercar.dealerwareandroid.screen.ChooseCompanyScreen;
import com.silvercar.dealerwareandroid.screen.CustomerScreen;
import com.silvercar.dealerwareandroid.screen.DropOffDateScreen;
import com.silvercar.dealerwareandroid.screen.EditVehicleDetailsScreen;
import com.silvercar.dealerwareandroid.screen.LoginScreen;
import com.silvercar.dealerwareandroid.screen.NewReservationScreen;
import com.silvercar.dealerwareandroid.screen.PersonalInfoScreen;
import com.silvercar.dealerwareandroid.screen.PickupDateScreen;
import com.silvercar.dealerwareandroid.screen.VehicleGroupScreen;
import com.silvercar.dealerwareandroid.screen.VehiclesScreen;
import com.silvercar.dealerwareandroid.utilities.Utility;

public class TC008VehicleGroupTestValidations extends Base {
     @Test(enabled = true, priority = 0)
        public void vechicleGroupPageValidations() throws 
                    ConfigurationException, IOException, ParseException, APIException {
         String customerName = "Narasimha";
         test = extent.createTest("Availability vechicleGroup Validations");
         String testCaseID = "932";
         SoftAssert softAssert = new SoftAssert();
         LoginScreen loginScreen = new LoginScreen();
         CustomerScreen customerScreen = new CustomerScreen();
         ChooseCompanyScreen chooseCompany = new ChooseCompanyScreen();
         NewReservationScreen newReservationScreen = new NewReservationScreen();
         PickupDateScreen pickupDateScreen = new PickupDateScreen();
         DropOffDateScreen dropOffDateScreen = new DropOffDateScreen();
         BottomMenuScreen bottonMenuScreen = new BottomMenuScreen();
         EditVehicleDetailsScreen editVehicleDetailsScreen = new EditVehicleDetailsScreen();
         VehiclesScreen vehiclesScreen = new VehiclesScreen(); 
         VehicleGroupScreen vehicleGroupScreen = new VehicleGroupScreen();
         PersonalInfoScreen personalInfoScreen = new PersonalInfoScreen();
         Utility utility = new Utility();
         loginScreen.enterEmailField(utility.getFromBaseProperties("validEmail"));
         loginScreen.enterPasswordField(utility.getFromBaseProperties("validPassword"));
         loginScreen.clickLoginButton();
         chooseCompany.selectLocation(utility.getFromBaseProperties("vechicleGroupLocation"));    
         try {
              bottonMenuScreen.clickVehicles();
              editVehicleDetailsScreen.setStatus(vehiclesScreen.courtesyVehicleGroup, "Maintenance");
              vehiclesScreen.clickNavigateUp();
              editVehicleDetailsScreen.setStatus(vehiclesScreen.testLocationVehicleGroup, "Maintenance");
              vehiclesScreen.clickNavigateUp();
              bottonMenuScreen.clickCustomers();
              searchCustomer(customerScreen, customerName);
              selectPickupDropoffDate(newReservationScreen, pickupDateScreen, dropOffDateScreen);
              newReservationScreen.clickVehicleGroupLabel();
              softAssert.assertEquals(utility.isDisplayed(vehicleGroupScreen.availableFleetsEmpty), true,
                       "Vehicle group is displaying available section eventhough no vehicle ready for booking");
              List<String> overBookedFleet = vehicleGroupScreen.getoverBookedFleetList();
              softAssert.assertEquals(overBookedFleet.size(), 2, "Over booked fleet vehicle group count not matched ");
              softAssert.assertEquals(overBookedFleet.contains("Courtesy") && overBookedFleet.contains("Test location"),
                       true, "Over booked fleet vehicle group values not matched");
              vehicleGroupScreen.overBookedFleetList.get(0).click();
              softAssert.assertEquals(utility.isDisplayed(vehicleGroupScreen.saveOverbookedSelectionButton), true,
                       "Save overbooked selection button is not displyed");
              vehiclesScreen.navigateUp.click();
              utility.waitForElementToDisplay(getDriver(), newReservationScreen.pickupLabel);
              vehiclesScreen.clickNavigateUp();
              utility.waitForElementToDisplay(getDriver(), customerScreen.personalInfoLabel);
              vehiclesScreen.clickNavigateUp();
              personalInfoScreen.clickCollapseButton();
              bottonMenuScreen.clickVehicles();
              editVehicleDetailsScreen.setStatus(vehiclesScreen.courtesyVehicleGroup, "Staged");
              vehiclesScreen.clickNavigateUp();
              editVehicleDetailsScreen.setStatus(vehiclesScreen.testLocationVehicleGroup, "Maintenance");
              vehiclesScreen.clickNavigateUp();
              bottonMenuScreen.clickCustomers();
              searchCustomer(customerScreen, customerName);
              selectPickupDropoffDate(newReservationScreen, pickupDateScreen, dropOffDateScreen);
              newReservationScreen.clickVehicleGroupLabel();
              overBookedFleet = null;
              overBookedFleet = vehicleGroupScreen.getoverBookedFleetList();
              List<String> availableFleet = vehicleGroupScreen.getAvailableFleetList();
              softAssert.assertEquals(utility.isDisplayed(vehicleGroupScreen.availableFleetsEmpty), false,
                        "Available fleets empty should not display on screen");
              softAssert.assertEquals(availableFleet.get(0), "Courtesy", "Courtesy vehicle group not"
                        + " dispalyed under available section");
              vehicleGroupScreen.availableFleetList.get(0).click();
              softAssert.assertEquals(utility.isDisplayed(vehicleGroupScreen.saveSelectionButton), true,
                         "Save selection button is not displyed");
              softAssert.assertEquals(utility.isDisplayed(vehicleGroupScreen.overBookedFleetsEmpty), false,
                         "over Booked fleet empty isn't displayed on screen");
              softAssert.assertEquals(overBookedFleet.get(0), "Test location", "Test location vehicle group"
                         + " not dispalyed under overBooked section");
              vehicleGroupScreen.overBookedFleetList.get(0).click();
              softAssert.assertEquals(utility.isDisplayed(vehicleGroupScreen.saveOverbookedSelectionButton),
                         true, "Save overbooked selection button is not displyed");
              vehiclesScreen.clickNavigateUp();
              utility.waitForElementToDisplay(getDriver(), newReservationScreen.pickupLabel);
              vehiclesScreen.clickNavigateUp();
              utility.waitForElementToDisplay(getDriver(), customerScreen.personalInfoLabel);
              vehiclesScreen.clickNavigateUp();
              personalInfoScreen.clickCollapseButton();
              bottonMenuScreen.clickVehicles();
              editVehicleDetailsScreen.setStatus(vehiclesScreen.courtesyVehicleGroup, "Staged");
              vehiclesScreen.clickNavigateUp();
              editVehicleDetailsScreen.setStatus(vehiclesScreen.testLocationVehicleGroup, "Staged");
              vehiclesScreen.clickNavigateUp();
              bottonMenuScreen.clickCustomers();
              searchCustomer(customerScreen, customerName);
              selectPickupDropoffDate(newReservationScreen, pickupDateScreen, dropOffDateScreen);
              newReservationScreen.clickVehicleGroupLabel();
              availableFleet = null;
              availableFleet = vehicleGroupScreen.getAvailableFleetList();
              
              softAssert.assertEquals(availableFleet.size(), 2, "available fleet vehicle group count not matched ");
              softAssert.assertEquals((availableFleet.contains("Courtesy") && availableFleet.contains("Test location")),
                       true, "available fleet vehicle group values not matched");
              softAssert.assertEquals(utility.isDisplayed(vehicleGroupScreen.overBookedFleetsEmpty), true,
                       "over Booked fleet empty isn't displayed on screen");
              softAssert.assertAll();
              TestRailManager.addResultForTestCase(testCaseID, TestRailManager.TEST_CASE_PASSED_STATUS, "");
         } catch (Exception e) {
               test.log(Status.FAIL, e.getMessage(),
                       MediaEntityBuilder.createScreenCaptureFromPath(screenShot(getDriver())).build());
               TestRailManager.addResultForTestCase(testCaseID, TestRailManager.TEST_CASE_FAILED_STATUS, "");
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
     
     public void searchCustomer(CustomerScreen customerScreen, String customerName) {
         Utility  utility = new Utility();
         utility.waitForElementToClickable(getDriver(), customerScreen.createCustomer);
         utility.waitForElementToClickable(getDriver(), customerScreen.searchIcon);
         customerScreen.enterSearchKey(customerName);
         customerScreen.getCustomerNames().get(0).click();
         utility.waitForElementToDisplay(getDriver(), customerScreen.personalInfoLabel);
         utility.waitForElementToClickable(getDriver(), customerScreen.createContract);
         customerScreen.clickCreateContract();
     }
}
