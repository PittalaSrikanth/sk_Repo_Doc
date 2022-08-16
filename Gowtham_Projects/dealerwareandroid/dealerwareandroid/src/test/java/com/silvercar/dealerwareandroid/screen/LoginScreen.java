package com.silvercar.dealerwareandroid.screen;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.silvercar.dealerwareandroid.base.Base;
import com.silvercar.dealerwareandroid.utilities.Utility;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginScreen extends Base {
    public LoginScreen() {
        PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
    }

    @FindBy(id = "com.silvercar.dealerware:id/email")
    MobileElement emailField;

    @FindBy(id = "com.silvercar.dealerware:id/password")
    MobileElement passwordField;

    @FindBy(id = "com.silvercar.dealerware:id/toolbar_button")
    MobileElement loginButton;

    @FindBy(id = "com.silvercar.dealerware:id/text_input_end_icon")
    MobileElement showPasswordIcon;
    
    @FindBy(xpath = "//*[@resource-id='com.silvercar.dealerware:id/email_label']//android.widget.TextView")
    public MobileElement errorMsgEmailLabel;
    
    @FindBy(xpath = "//*[@resource-id='com.silvercar.dealerware:id/password_label']//android.widget.TextView")
    public MobileElement errorMsgPasswordLabel;
    
    @FindBy (id = "com.silvercar.dealerware:id/forgot_password")
    public MobileElement forgotPasswordButton;
    
    @FindBy (xpath = "//*[@text='RESET PASSWORD']")
    public MobileElement resetPasswordButton;
    
    

    public void enterEmailField(String email) {
        this.emailField.sendKeys(email);
        test.info("Enter's Email Address");
    }

    public void enterPasswordField(String password) {
        this.passwordField.sendKeys(password);
        test.info("Enter's Password");
    }

    public void clickLoginButton() {
        this.loginButton.click();
        test.info("Tap's on login Button");
    }

    public String getLoginText() {
        return this.loginButton.getText();
    }

    public void clickShowPasswordIcon() {
        this.showPasswordIcon.click();
    }
    
    public String getErrorMsgEmailLabel() {
        return this.errorMsgEmailLabel.getAttribute("text");
    }
    
    public String getErrorMsgPasswordLabel() {
        return this.errorMsgPasswordLabel.getAttribute("text");
    }
    
    public void clickForgotPasswordButton() {
        new Utility().waitForElementToDisplay(getDriver(), this.forgotPasswordButton);
        this.forgotPasswordButton.click();
     }
    
    public void clickResetPasswordButton() {
        this.resetPasswordButton.click();
    }
}
