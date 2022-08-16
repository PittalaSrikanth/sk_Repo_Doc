package com.silvercar.dealerwareandroid.testcases;

import java.io.IOException;
import java.util.ArrayList;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.silvercar.dealerwareandroid.base.Base;
import com.silvercar.dealerwareandroid.screen.BottomMenuScreen;
import com.silvercar.dealerwareandroid.screen.ChooseCompanyScreen;
import com.silvercar.dealerwareandroid.screen.CustomerProfileScreen;
import com.silvercar.dealerwareandroid.screen.DriverLicenseScreen;
import com.silvercar.dealerwareandroid.screen.InsuranceScreen;
import com.silvercar.dealerwareandroid.screen.LoginScreen;
import com.silvercar.dealerwareandroid.screen.PersonalInfoScreen;
import com.silvercar.dealerwareandroid.screen.SettingsScreen;
import com.silvercar.dealerwareandroid.utilities.Utility;
import io.appium.java_client.MobileElement;

public class TC002CustomerValidationTest extends Base {

    @Test(enabled = true, priority = 0)
    public void validateCustomerCreation() throws IOException {
        SoftAssert softAssert = new SoftAssert();
        test = extent.createTest("Customer Creation");
        LoginScreen loginScreen = new LoginScreen();
        ChooseCompanyScreen chooseCompany = new ChooseCompanyScreen();
        Utility utility = new Utility();
        CustomerProfileScreen customerScreen = new CustomerProfileScreen();
        PersonalInfoScreen personlaInfoScreen = new PersonalInfoScreen();
        DriverLicenseScreen dlScreen = new DriverLicenseScreen();
        InsuranceScreen insurenceScreen = new InsuranceScreen();
        try {
            loginScreen.enterEmailField(utility.getFromBaseProperties("validEmail"));
            loginScreen.enterPasswordField(utility.getFromBaseProperties("validPassword"));
            loginScreen.clickLoginButton();
            chooseCompany.selectLocation(utility.getFromBaseProperties("USLocation1"));
            customerScreen.clickCreateCustomer();
            customerScreen.clickAllowButton();
            customerScreen.clickSkipButton();
            personlaInfoScreen.enterFirstName(utility.getRandomName("randomFirstName"));
            personlaInfoScreen.enterLastName(utility.getRandomName("randomLastName"));
            personlaInfoScreen.enterEmail(utility.getRandomEmail("randomEmail"));
            personlaInfoScreen.enterPhoneNumber(utility.getFromBaseProperties("randomPhone"));
            personlaInfoScreen.clickNextButton();
            dlScreen.enterDriverLicenseNumber(utility.getRandomName("driverLicenseNumber"));
            dlScreen.enterDateOfBirth(utility.getFutureAndPastDate("past", 22 * 360));
            dlScreen.enterExpireDate(utility.getFutureAndPastDate("future", 2));
            dlScreen.enterAddress1(utility.getFromBaseProperties("address1"));
            dlScreen.enterCity(utility.getFromBaseProperties("city"));
            utility.scrollElementToView("NEXT");
            dlScreen.enterZipCode(utility.getFromBaseProperties("postalCode"));
            dlScreen.clickNextButton();
            Thread.sleep(10000);
            for (int i = 0; i < 5; i++) {
                System.out.println(dlScreen.getToolBarLabel());
                if (dlScreen.getToolBarLabel().equals("Payment Method"))
                    break;
                Thread.sleep(3000);
            }

            customerScreen.clickSkipButton();
            insurenceScreen.clickCameraButton();
            insurenceScreen.clickShutterButton();
            insurenceScreen.clickDoneButton();
            insurenceScreen.enterInsuranceExpiration(utility.getFutureAndPastDate("future", 2));
            Thread.sleep(5000);
            insurenceScreen.clickFinishButton();
            customerScreen.clickPersonalInfo();
            softAssert.assertEquals(personlaInfoScreen.getFirstNmae(), utility.
                    getFromBaseProperties("randomFirstName"), "Given first name not matched");
            softAssert.assertEquals(personlaInfoScreen.getLastName(), utility.
                    getFromBaseProperties("randomLastName"), "Given last name not matched");
            softAssert.assertEquals(personlaInfoScreen.getPhoneNumber(), utility.
                    getFromBaseProperties("randomPhone"), "Given phone number not matched");
            softAssert.assertEquals(personlaInfoScreen.getEmail(), utility.
                    getFromBaseProperties("randomEmail"), "Given email not matched");
            test.log(Status.PASS, "Validated customer Profile Info Details");

            personlaInfoScreen.clickNavigateUp();
            customerScreen.clickDrivenLicense();
            softAssert.assertEquals(dlScreen.getDriverLicenseNumber(), utility.
                    getFromBaseProperties("driverLicenseNumber"), "Given DL Number not matched");
            softAssert.assertEquals(dlScreen.getDateOfBirth(), utility.
                    getFutureAndPastDate("past", 22 * 360), "Given DOB not matched");
            softAssert.assertEquals(dlScreen.getExpirationDate(), utility.
                    getFutureAndPastDate("future", 2), "Given Expiration Date not matched");
            softAssert.assertEquals(dlScreen.getAddress1(), utility.
                    getFromBaseProperties("address1"), "Given address not matched");
            softAssert.assertEquals(dlScreen.getCity(), utility.
                    getFromBaseProperties("city"), "Given city not matched");
            utility.scrollElementToView("SAVE");
            softAssert.assertEquals(dlScreen.getZipCode(), utility.
                    getFromBaseProperties("postalCode"), "given postal Code not matched");
            personlaInfoScreen.clickNavigateUp();
            test.log(Status.PASS, "Validated Driver License Details");

            customerScreen.clickInsurance();
            softAssert.assertEquals(insurenceScreen.getInsuranceExpireation(),
                    utility.getFutureAndPastDate("future", 2), "Given insurence Expiration Date not matched");
            test.log(Status.PASS, "Validated Insurence deatils");
            try {
                softAssert.assertAll();
                test.log(Status.PASS, "Test Pass");
            } catch (AssertionError e) {
                test.log(Status.FAIL, e.getMessage());
                Assert.assertTrue(false, e.getMessage());
            }

        } catch (Exception e) {
            test.log(Status.FAIL, e.getMessage(),
                    MediaEntityBuilder.createScreenCaptureFromPath(screenShot(getDriver())).build());
            Assert.assertTrue(false, e.getMessage());
        }
    }

    @Test(enabled = true, priority = 1)
    public void customerSearchFunctionality() throws IOException {
        test = extent.createTest("Customer Search Functionality");
        SoftAssert softAssert = new SoftAssert();
        LoginScreen loginScreen = new LoginScreen();
        ChooseCompanyScreen chooseCompany = new ChooseCompanyScreen();
        Utility utility = new Utility();
        CustomerProfileScreen customerScreen = new CustomerProfileScreen();
        PersonalInfoScreen personalInfoScreen = new PersonalInfoScreen();
        BottomMenuScreen bottomMenuScreen = new BottomMenuScreen();
        SettingsScreen settingScreen = new SettingsScreen();
        try {
            loginScreen.enterEmailField(utility.getFromBaseProperties("validEmail"));
            loginScreen.enterPasswordField(utility.getFromBaseProperties("validPassword"));
            loginScreen.clickLoginButton();
            chooseCompany.selectLocation(utility.getFromBaseProperties("USLocation1"));

            customerScreen.enterSearchKey(utility.getFromBaseProperties("randomFirstName"));
            ArrayList<MobileElement> customerNameList = new ArrayList<MobileElement>();
            customerNameList = customerScreen.getCustomerNames();
            softAssert.assertEquals(true,
                    customerNameList.get(0).getAttribute("text")
                            .contains(utility.getFromBaseProperties("randomFirstName")),
                    "customer Search functionality not working with First Name");
            test.log(Status.PASS, "customer Search functionality with First Name is pass");
            customerNameList.get(0).click();
            customerScreen.clickPersonalInfo();
            softAssert.assertEquals(personalInfoScreen.getFirstNmae(), utility.getFromBaseProperties("randomFirstName"),
                    "customer Search functionality not working with First Name");

            personalInfoScreen.clickNavigateUp();
            utility.waitForElementToClickable(getDriver(), customerScreen.createContract);
            personalInfoScreen.clickNavigateUp();
            personalInfoScreen.clickCollapseButton();
            bottomMenuScreen.clickSettings();
            utility.waitForElementToDisplay(getDriver(), settingScreen.logoutButton);
            bottomMenuScreen.clickCustomers();

            customerScreen.enterSearchKey(utility.getFromBaseProperties("randomLastName"));
            customerNameList = null;
            customerNameList = new ArrayList<MobileElement>();
            customerNameList = customerScreen.getCustomerNames();
            softAssert.assertEquals(true,
                    customerNameList.get(0).getAttribute("text")
                            .contains(utility.getFromBaseProperties("randomLastName")),
                    "customer Search functionality not working with Last Name");
            customerNameList.get(0).click();
            customerScreen.clickPersonalInfo();
            softAssert.assertEquals(personalInfoScreen.getLastName(), utility.getFromBaseProperties("randomLastName"),
                    "customer Search functionality not working with Last Name");
            personalInfoScreen.clickNavigateUp();
            utility.waitForElementToClickable(getDriver(), customerScreen.createContract);
            personalInfoScreen.clickNavigateUp();
            personalInfoScreen.clickCollapseButton();
            bottomMenuScreen.clickSettings();
            utility.waitForElementToDisplay(getDriver(), settingScreen.logoutButton);
            bottomMenuScreen.clickCustomers();
            test.log(Status.PASS, "customer Search functionality with Last Name is pass");

            customerScreen.enterSearchKey(utility.getFromBaseProperties("randomEmail"));
            customerNameList = null;
            customerNameList = new ArrayList<MobileElement>();
            customerNameList = customerScreen.getCustomerNames();
            customerNameList.get(0).click();
            customerScreen.clickPersonalInfo();
            softAssert.assertEquals(personalInfoScreen.getEmail(), utility.getFromBaseProperties("randomEmail"),
                    "customer Search functionality not working with email");
            try {
                softAssert.assertAll();
                test.log(Status.PASS, "Test Pass");
            } catch (AssertionError e) {
                test.log(Status.FAIL, e.getMessage());
                Assert.assertTrue(false, e.getMessage());
            }
        } catch (Exception e) {
            test.log(Status.FAIL, e.getMessage(),
                    MediaEntityBuilder.createScreenCaptureFromPath(screenShot(getDriver())).build());
            Assert.assertTrue(false, e.getMessage());
        }
    }
}