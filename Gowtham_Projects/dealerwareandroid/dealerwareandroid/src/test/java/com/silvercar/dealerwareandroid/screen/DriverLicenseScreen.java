package com.silvercar.dealerwareandroid.screen;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.silvercar.dealerwareandroid.base.Base;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class DriverLicenseScreen extends Base {

    public DriverLicenseScreen() {
        PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
    }

    @FindBy(id = "com.silvercar.dealerware:id/drivers_license_number")
    MobileElement driverLicenseNumberField;

    @FindBy(xpath = "//*[@resource-id='com.silvercar.dealerware:id/date_of_birth']//android.widget.EditText")
    MobileElement dateOfBirthField;

    @FindBy(xpath = "//*[@resource-id='com.silvercar.dealerware:id/expiration']//android.widget.EditText")
    MobileElement expirationField;

    @FindBy(id = "com.silvercar.dealerware:id/address_line_1")
    MobileElement addressLine1Field;

    @FindBy(id = "com.silvercar.dealerware:id/address_line_2_optional")
    MobileElement addressLine2Field;

    @FindBy(id = "com.silvercar.dealerware:id/city")
    MobileElement cityField;

    @FindBy(id = "com.silvercar.dealerware:id/postal_code")
    MobileElement postalCodeField;

    @FindBy(xpath = "//*[@text='NEXT']")
    public MobileElement nextButton;

    @FindBy(xpath = "//*[@resource-id='com.silvercar.dealerware:id/toolbar']/android.widget.TextView")
    MobileElement toolBarLabel;

    public void enterDriverLicenseNumber(String driverLicenseNumber) {
        this.driverLicenseNumberField.clear();
        this.driverLicenseNumberField.sendKeys(driverLicenseNumber);
        test.info("entered customer Driver license");
    }

    public String getDriverLicenseNumber() {
        return this.driverLicenseNumberField.getAttribute("text");
    }

    public void enterDateOfBirth(String dob) {
        this.dateOfBirthField.clear();
        this.dateOfBirthField.sendKeys(dob);
        test.info("entered customer Date Of Birth");
    }

    public String getDateOfBirth() {
        return this.dateOfBirthField.getAttribute("text");
    }

    public void enterExpireDate(String expireDate) {
        this.expirationField.clear();
        this.expirationField.sendKeys(expireDate);
        test.info("entered customer Expiration Date");
    }

    public String getExpirationDate() {
        return this.expirationField.getAttribute("text");
    }

    public void enterAddress1(String address1) {
        this.addressLine1Field.clear();
        this.addressLine1Field.sendKeys(address1);
        test.info("entered customer address line 1");
    }

    public String getAddress1() {
        return this.addressLine1Field.getAttribute("text");
    }

    public void enterCity(String city) {
        this.cityField.clear();
        this.cityField.sendKeys(city);
        test.info("entered Customer City in DL Screen");
    }

    public String getCity() {
        return this.cityField.getAttribute("text");
    }

    public void enterZipCode(String zipCode) {
        this.postalCodeField.clear();
        this.postalCodeField.sendKeys(zipCode);
        test.info("entered Customer Postal Code");
    }

    public String getZipCode() {
        return this.postalCodeField.getAttribute("text");
    }

    public void clickNextButton() {
        this.nextButton.click();
        test.info("clicked on Next button in DL Screen");
    }

    public String getToolBarLabel() {
        return this.toolBarLabel.getAttribute("text");
    }
}
