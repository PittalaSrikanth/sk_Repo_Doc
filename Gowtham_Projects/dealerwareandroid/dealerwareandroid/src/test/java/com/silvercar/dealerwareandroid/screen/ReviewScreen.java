package com.silvercar.dealerwareandroid.screen;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.silvercar.dealerwareandroid.base.Base;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ReviewScreen extends Base {

    public ReviewScreen() {
        PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
    }

    @FindBy(id = "com.silvercar.dealerware:id/starting_fuel_level")
    public MobileElement startingFuelLevel;

    @FindBy(id = "com.silvercar.dealerware:id/ending_fuel_level")
    public MobileElement endingFuelLevel;

    @FindBy(id = "com.silvercar.dealerware:id/fuel_used")
    public MobileElement fuelUsed;

    @FindBy(id = "com.silvercar.dealerware:id/starting_mileage")
    public MobileElement startingMileage;

    @FindBy(id = "com.silvercar.dealerware:id/ending_mileage")
    public MobileElement endingMileage;

    @FindBy(id = "com.silvercar.dealerware:id/total_distance_traveled")
    public MobileElement totalDistanceTraveled;

    @FindBy(xpath = "//*[@text='FINISH CONTRACT']")
    public MobileElement finishContract;

    @FindBy(xpath = "//*[@text='FINISH']")
    public MobileElement finishButton;

    public void clickFinishContract() {
        this.finishContract.click();
    }

    public void clickFinishButton() {
        this.finishButton.click();
    }

    public String getStartFuelLevel() {
        return this.startingFuelLevel.getAttribute("text");
    }

    public String getEndingFuelLevel() {
        return this.endingFuelLevel.getAttribute("text");
    }

    public String getFuelUsed() {
        return this.fuelUsed.getAttribute("text");
    }

    public String getStartingMileage() {
        return this.startingMileage.getAttribute("text");
    }

    public String getEndingMileage() {
        return this.endingMileage.getAttribute("text");
    }

    public String getTotalDistanceTraveled() {
        return this.totalDistanceTraveled.getAttribute("text");
    }
}
