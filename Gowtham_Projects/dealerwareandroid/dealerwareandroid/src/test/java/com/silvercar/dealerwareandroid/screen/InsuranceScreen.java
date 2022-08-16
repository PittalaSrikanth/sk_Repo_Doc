package com.silvercar.dealerwareandroid.screen;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.silvercar.dealerwareandroid.base.Base;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class InsuranceScreen extends Base {
    public InsuranceScreen() {
       PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
    }

    @FindBy(id = "com.silvercar.dealerware:id/camera")
    MobileElement cameraButton;

    @FindBy(id = "com.android.camera2:id/shutter_button")
    MobileElement shutterButton;

    @FindBy(id = "com.android.camera2:id/done_button")
    MobileElement doneButton;

    @FindBy(id = "com.silvercar.dealerware:id/expiration")
    MobileElement insuranceExpirationField;

    @FindBy(xpath = "//*[@text='FINISH']")
    MobileElement finishButton;

    public void clickCameraButton() {
        this.cameraButton.click();
    }

    public void clickShutterButton() {
        this.shutterButton.click();
    }

    public void clickDoneButton() {
        this.doneButton.click();
        test.info("added Insurance image");
    }

    public void enterInsuranceExpiration(String insuranceExpiration) {
        this.insuranceExpirationField.clear();
        this.insuranceExpirationField.sendKeys(insuranceExpiration);
        test.info("entered Expiration date for Insurance");
    }

    public void clickFinishButton() {
        this.finishButton.click();
        test.info("customer Creation Finished ");
    }

    public String getInsuranceExpireation() {
        return this.insuranceExpirationField.getAttribute("text");
    }
}
