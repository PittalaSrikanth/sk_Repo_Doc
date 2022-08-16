package com.silvercar.dealerwareandroid.testcases;

import java.io.IOException;
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
import com.silvercar.dealerwareandroid.screen.LoginScreen;
import com.silvercar.dealerwareandroid.screen.SettingsScreen;
import com.silvercar.dealerwareandroid.utilities.Utility;

public class TC001LoginTest extends Base {

    @Test(enabled = true, priority = 0)
    public void valid_Login_Test() throws IOException, InterruptedException, APIException {
        test = extent.createTest("Valid_Login_Test");
        SoftAssert softAssert = new SoftAssert();
        LoginScreen loginScreen = new LoginScreen();
        Utility utility = new Utility();
        ChooseCompanyScreen chooseCompany = new ChooseCompanyScreen();
        BottomMenuScreen bottomMenu = new BottomMenuScreen();
        SettingsScreen settings = new SettingsScreen();
        String testCaseID = "352";
        
        try {
            loginScreen.enterEmailField(utility.getFromBaseProperties("validEmail"));
            loginScreen.enterPasswordField(utility.getFromBaseProperties("validPassword"));
            loginScreen.clickLoginButton();
            chooseCompany.selectLocation(utility.getFromBaseProperties("USLocation1"));
            bottomMenu.clickSettings();
            softAssert.assertEquals(settings.getLocationName(), utility.
                    getFromBaseProperties("USLocation1"), "Testing Location name  is match after login");
            test.log(Status.PASS, "Location name are matching after login");
            settings.clickLogout();
            softAssert.assertAll();
            TestRailManager.addResultForTestCase(testCaseID, TestRailManager.TEST_CASE_PASSED_STATUS, "");
        } catch (Exception exception) {
            TestRailManager.addResultForTestCase(testCaseID, TestRailManager.TEST_CASE_FAILED_STATUS, "");
            test.log(Status.FAIL, exception.getMessage(),
                    MediaEntityBuilder.createScreenCaptureFromPath(screenShot(getDriver())).build());
            Assert.assertTrue(false, exception.getMessage());
        }
    }

    @Test(enabled = true, priority = 1)
    public void invalid_login_test() throws IOException {
        test = extent.createTest("Invalid_Login_Test");
        SoftAssert softAssert = new SoftAssert();
        LoginScreen loginScreen = new LoginScreen();
        Utility utility = new Utility();
        try {
            loginScreen.enterEmailField(utility.getFromBaseProperties("invalidEmail"));
            loginScreen.enterPasswordField(utility.getFromBaseProperties("invalidPassword"));
            loginScreen.clickShowPasswordIcon();
            loginScreen.clickLoginButton();
            softAssert.assertEquals(loginScreen.getLoginText(), utility.getFromBaseProperties("loginButtonTextValue"),
                    "User logged into app with invalid credentials");
            test.log(Status.PASS, "User is still in login screen");
            softAssert.assertAll();
        } catch (Exception exception) {
            test.log(Status.FAIL, exception.getMessage(),
                    MediaEntityBuilder.createScreenCaptureFromPath(screenShot(getDriver())).build());
            Assert.assertTrue(false, exception.getMessage());
        }
    }
}
