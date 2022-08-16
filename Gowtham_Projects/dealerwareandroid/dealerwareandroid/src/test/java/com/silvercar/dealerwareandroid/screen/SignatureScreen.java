package com.silvercar.dealerwareandroid.screen;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.silvercar.dealerwareandroid.base.Base;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;

public class SignatureScreen extends Base {

    public SignatureScreen() {
       PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
    }

    @FindBy(id = "com.silvercar.dealerware:id/signature")
    public MobileElement signatureArea;

    @FindBy(xpath = "//*[@text='SIGN & START CONTRACT']")
    public MobileElement signAndStartContract;
    
    @FindBy(xpath = "//*[@text='SIGN CONTRACT']")
    public MobileElement signContarctButton;
    
    @FindBy(xpath = "//*[@text='CONTINUE TO NEXT DRIVER']")
    public MobileElement continueToNextDriver;

    public void addSignature() {
        Dimension dimension = getDriver().manage().window().getSize();
        int height = dimension.getHeight();
        int width = dimension.getWidth();
        int y = height / 2;
        int topx = (int) (width * .80);
        int bottomx = (int) (width * .20);
        TouchAction ta = new TouchAction(getDriver());
        ta.press(PointOption.point(topx, y)).moveTo(PointOption.point(bottomx, y)).release().perform();
    }

    public void clickSignAndStartContract() {
        this.signAndStartContract.click();
    }
   
    public void clickSignContarctButton() {
        this.signContarctButton.click();
    }
    
    public void clickContinueToNextDriver() {
        this.continueToNextDriver.click();
    }
}
