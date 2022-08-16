package com.silvercar.dealerwareandroid.screen;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.silvercar.dealerwareandroid.base.Base;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ContractDetailsScreen extends Base {

    public ContractDetailsScreen() {
        PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
    }

    @FindBy(id = "com.silvercar.dealerware:id/on_this_device_button")
    public MobileElement onThisDeviceButton;

    @FindBy(id = "com.silvercar.dealerware:id/primary_driver")
    public MobileElement primaryDriver;

    @FindBy(id = "com.silvercar.dealerware:id/contactless_button")
    public MobileElement contactlessButton;

    @FindBy(xpath = "//*[@text='SEND TEXT MESSAGE']")
    public MobileElement sendTextMessage;

    @FindBy(xpath = "//*[@text='CLOSE']")
    public MobileElement closeButton;

    @FindBy(id = "android:id/button1")
    public MobileElement sendEmailsButton;
    
    @FindBy (id = "com.silvercar.dealerware:id/alertTitle")
    public MobileElement alertTitleLabel;

    public void clickOnThisDeviceButton() {
        this.onThisDeviceButton.click();
    }

    public String getPrimaryDriver() {
        return this.primaryDriver.getAttribute("text");
    }

    public void clickContactlessButton() {
        this.contactlessButton.click();
    }

    public void clickSendTextMessage() {
        this.sendTextMessage.click();
    }

    public void clickCloseButton() {
        this.closeButton.click();
    }
    
    public void clickSendEmailsButton() {
        this.sendEmailsButton.click();
    }
    
    public String getAlertTitleLabel() {
        return this.alertTitleLabel.getAttribute("text");
    }
}
