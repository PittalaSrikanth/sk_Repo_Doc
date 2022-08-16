package com.silvercar.dealerwareandroid.screen;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.silvercar.dealerwareandroid.base.Base;
import com.silvercar.dealerwareandroid.utilities.Utility;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AdditionalDriverScreen extends Base {
    public AdditionalDriverScreen() {
        PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
    }

    @FindBy(id = "com.silvercar.dealerware:id/lastNameInput")
    public MobileElement inputLastName;

    @FindBy(id = "com.silvercar.dealerware:id/firstNameInput")
    public MobileElement inputFirstName;
    
    @FindBy(xpath = "//*[@resource-id='com.silvercar.dealerware:id/dateOfBirthInput']//android.widget.EditText")
    public MobileElement inputDateOfBirth;

    @FindBy(id = "com.silvercar.dealerware:id/licenseNumberInput")
    public MobileElement inputDriverLicenseNumber;

    @FindBy(xpath = "//*[@resource-id='com.silvercar.dealerware:id/expirationInput']//android.widget.EditText")
    public MobileElement inputexpiration;

    @FindBy(id = "com.silvercar.dealerware:id/driverPhoneInput")
    public MobileElement inputPhoneNumber;

    @FindBy(id = "com.silvercar.dealerware:id/driverEmailInput")
    public MobileElement inputEmailAddress;

    @FindBy (xpath = "//*[@text='ADD DRIVER TO CONTRACT']")
    public MobileElement addDriverToContractButton;
    
    @FindBy (id = "com.silvercar.dealerware:id/state")
    public MobileElement stateDropDown;
    
    @FindBy (xpath = "//*[@resource-id='com.silvercar.dealerware:id/state']/android.widget.TextView")
    public MobileElement stateLabel;
    
   @FindBy(xpath = "//*[@content-desc='Navigate up']")
   public MobileElement navigateUp;
   
   @FindBy (id = "com.silvercar.dealerware:id/country")
   public MobileElement countryDropDown;
    
    public void enterDriverFirstName(String firstName) {
        this.inputFirstName.clear();
        this.inputFirstName.sendKeys(firstName);
        test.info("Entered additional driver first name");
    }

    public void enterDriverLastName(String lastName) {
        this.inputLastName.clear();
        this.inputLastName.sendKeys(lastName);
        test.info("entered additional driver last name");
    }

    public void enterDateOfBirth(String dateOfBirth) {
        this.inputDateOfBirth.clear();
        this.inputDateOfBirth.sendKeys(dateOfBirth);
        test.info("entered additional driver Date Of Birth");
    }

    public void enterDriverLicenseNumber(String licenseNumber) {
        this.inputDriverLicenseNumber.clear();
        this.inputDriverLicenseNumber.sendKeys(licenseNumber);
        test.info("entered additional driver license number ");
    }

    public void enterExpirationDate(String expirationDate) {
        this.inputexpiration.clear();
        this.inputexpiration.sendKeys(expirationDate);
        test.info("entered additional driver expiration Date");
    }

    public void enterPhoneNumber(String phoneNumber) {
        this.inputPhoneNumber.clear();
        this.inputPhoneNumber.sendKeys(phoneNumber);
        test.info("entered additional driver phone number");
    }

    public void enterEmailAddress(String emailAddress) {
        this.inputEmailAddress.clear();
        this.inputEmailAddress.sendKeys(emailAddress);
        test.info("entered additional driver email address");
    }

    public void clickAddDriverToContractButton() {
        this.addDriverToContractButton.click();
    }
    
    public String getDriverFirstName() {
        return this.inputFirstName.getAttribute("text");
    }
    
    public String getDriverLastName() {
        return this.inputLastName.getAttribute("text");
    }
    
    public String getDateOfBirth() {
        return this.inputDateOfBirth.getAttribute("text");
    }
    
    public String getDriverLicenseNumber() {
        return this.inputDriverLicenseNumber.getAttribute("text");
    }
    
    public String getExpirationDate() {
        return this.inputexpiration.getAttribute("text");
    }
    
    public String getPhoneNumber() {
        return this.inputPhoneNumber.getAttribute("text");
    }
    
    public String getEmail() {
        return this.inputEmailAddress.getAttribute("text");
    }
    
    public void selectState(String state) {
        this.stateDropDown.click();
        new Utility().scrollElementToView(state);
        getDriver().findElement(By.xpath("//*[@text = '" + state + "']")).click();
    }
    
    public String getSelectedState() {
        return this.stateLabel.getAttribute("text");
    }
    
    public void clickNavigateUp() {
        this.navigateUp.click();
    }

    public void selectCountry(String country) {
        this.countryDropDown.click();
        new Utility().scrollElementToView(country);
        getDriver().findElement(By.xpath("//*[@text = '" + country + "']")).click();
    }
}
