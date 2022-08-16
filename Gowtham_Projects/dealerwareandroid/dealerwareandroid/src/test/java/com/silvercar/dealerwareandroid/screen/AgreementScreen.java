package com.silvercar.dealerwareandroid.screen;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.silvercar.dealerwareandroid.base.Base;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AgreementScreen extends Base {

    public AgreementScreen() {
        PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
    }

    @FindBy(id = "com.silvercar.dealerware:id/checkbox_agreement")
    public MobileElement checkboxAgreement;

    @FindBy(xpath = "//*[@text='DISMISS']")
    public MobileElement dismissButton;

    public void clickCheckboxAgreement() {
        this.checkboxAgreement.click();
    }

    public void clickDismissButton() {
        this.dismissButton.click();
    }
}
