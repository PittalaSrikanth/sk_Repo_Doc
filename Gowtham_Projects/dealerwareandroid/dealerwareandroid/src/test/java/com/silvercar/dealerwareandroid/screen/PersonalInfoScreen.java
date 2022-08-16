package com.silvercar.dealerwareandroid.screen;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.silvercar.dealerwareandroid.base.Base;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PersonalInfoScreen extends Base {
    public PersonalInfoScreen() {
        PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
    }

    @FindBy(id = "com.silvercar.dealerware:id/first_name")
    MobileElement firstNameField;

    @FindBy(id = "com.silvercar.dealerware:id/last_name")
    MobileElement lastNameField;

    @FindBy(id = "com.silvercar.dealerware:id/phone")
    MobileElement phoneField;

    @FindBy(id = "com.silvercar.dealerware:id/email")
    MobileElement emailField;

    @FindBy(id = "com.silvercar.dealerware:id/toolbar_button")
    MobileElement nextButton;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Collapse\"]")
    MobileElement buttonCollapse;

    @FindBy(xpath = "//*[@resource-id='com.silvercar.dealerware:id/toolbar']/android.widget.ImageButton")
    MobileElement navigateUp;

    public void enterFirstName(String firstName) {
        this.firstNameField.clear();
        this.firstNameField.sendKeys(firstName);
        test.info("entered Customer first name");
    }

    public String getFirstNmae() {
        return this.firstNameField.getAttribute("text");
    }

    public void enterLastName(String lastName) {
        this.lastNameField.clear();
        this.lastNameField.sendKeys(lastName);
        test.info("entered customer last name");
    }

    public String getLastName() {
        return this.lastNameField.getAttribute("text");
    }

    public void enterPhoneNumber(String phoneNo) {
        this.phoneField.clear();
        this.phoneField.sendKeys(phoneNo);
        test.info("entered customer mobile number");
    }

    public String getPhoneNumber() {
        return this.phoneField.getAttribute("text");
    }

    public void enterEmail(String email) {
        this.emailField.clear();
        this.emailField.sendKeys(email);
        test.info("entered customer Email");
    }

    public String getEmail() {
        return this.emailField.getAttribute("text");
    }

    public void clickNextButton() {
        this.nextButton.click();
        test.info("clicked on Next button on Customer profile screen");
    }

    public void clickNavigateUp() {
        this.navigateUp.click();
    }

    public void clickCollapseButton() {
        this.buttonCollapse.click();
    }
}
