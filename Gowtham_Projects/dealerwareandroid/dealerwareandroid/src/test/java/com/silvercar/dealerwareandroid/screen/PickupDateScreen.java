package com.silvercar.dealerwareandroid.screen;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.silvercar.dealerwareandroid.base.Base;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PickupDateScreen extends Base {

    public PickupDateScreen() {
        PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
    }
    
    @FindBy (xpath = "//*[@text='SAVE SELECTION']")
    public MobileElement saveSelectionButton;
    
    @FindBy (xpath = "//*[@resource-id='com.silvercar.dealerware:id/toolbar']/android.widget.TextView")
    public MobileElement toolbarLabel;
    
    @FindBy (xpath = "//*[contains(@text,'Select a date to see available time')]")
    public MobileElement selectDateLabel;
    
    @FindBy (id = "com.silvercar.dealerware:id/date_2")
    public MobileElement pickupDate2;
    
    @FindBy (xpath = "//*[@text='06:00am']")
    public MobileElement label6am;
    
    
    public String getToolbarLabel() {
        return this.toolbarLabel.getAttribute("text");
    }
    
    public void selectPickupDate2() {
        this.pickupDate2.click();
    }
    
    public void clickLabel12am() {
        this.label6am.click();
    }
    
    public void clickSaveSelectionButton() {
        this.saveSelectionButton.click();
    }
    
}

