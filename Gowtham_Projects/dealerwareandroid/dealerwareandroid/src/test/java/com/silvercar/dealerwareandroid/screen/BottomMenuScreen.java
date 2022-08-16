package com.silvercar.dealerwareandroid.screen;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.silvercar.dealerwareandroid.base.Base;
import com.silvercar.dealerwareandroid.utilities.Utility;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class BottomMenuScreen extends Base {
    public BottomMenuScreen() {
        PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
    }

    @FindBy(id = "com.silvercar.dealerware:id/settings")
    MobileElement settingsButton;

    @FindBy(id = "com.silvercar.dealerware:id/customers")
    public MobileElement customersButton;

    
    @FindBy(id = "com.silvercar.dealerware:id/vehicles")
    public MobileElement vehicles;
    
    @FindBy(id = "com.silvercar.dealerware:id/contracts")
    public MobileElement contracts;


    public void clickSettings() {
        this.settingsButton.click();
        test.info("Tap's on Settings");
    }

    public void clickCustomers() {
        new Utility().waitForElementToClickable(getDriver(), this.customersButton);
        this.customersButton.click();
        test.info("Tap on customers button");
    }
    
    public void clickVehicles() {
        new Utility().waitForElementToClickable(getDriver(), this.vehicles);
        this.vehicles.click();
        test.info("Tap on Vehicles button");
    }
    
    public void clickContracts() {
        new Utility().waitForElementToClickable(getDriver(), this.contracts);
        this.contracts.click();
        test.info("Tap on Contracts button");
    }
}
