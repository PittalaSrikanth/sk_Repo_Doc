package com.silvercar.dealerwareandroid.screen;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.silvercar.dealerwareandroid.base.Base;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class VehicleDetailsScreen extends Base {

    public VehicleDetailsScreen() {
        PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
    }

    @FindBy(xpath = "//*[@text='CONTINUE']")
    public MobileElement continueButton;
    

    public void clickContinue() {
        this.continueButton.click();
    }
    
}
