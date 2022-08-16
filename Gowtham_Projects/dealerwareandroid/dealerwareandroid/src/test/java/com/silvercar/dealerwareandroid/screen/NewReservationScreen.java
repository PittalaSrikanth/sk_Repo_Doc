package com.silvercar.dealerwareandroid.screen;

import java.util.ArrayList;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.silvercar.dealerwareandroid.base.Base;
import com.silvercar.dealerwareandroid.utilities.Utility;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class NewReservationScreen extends Base {

    public NewReservationScreen() {
        PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
    }

    @FindBy(xpath = "//*[@text='Service Advisor']")
    public MobileElement serviceAdvisor;

    @FindBy (xpath = "//*[@text='Additional Driver']")
    public MobileElement additionalDriver;

    @FindBy(xpath = "//*[@resource-id='com.silvercar.dealerware:id/service_advisor_cell']")
    public ArrayList<MobileElement> serviceAdvisorCell;

    @FindBy(id = "com.silvercar.dealerware:id/save_button")
    public MobileElement saveSelectionButton;

    @FindBy(id = "com.silvercar.dealerware:id/progress_bar")
    public MobileElement progressBar;

    @FindBy(id = "com.silvercar.dealerware:id/btn_assign_vehicle")
    public MobileElement assignVehicleButton;

    @FindBy(xpath = "//*[@resource-id='com.silvercar.dealerware:id/driver_one']"
            + "//*[@resource-id='com.silvercar.dealerware:id/subtitle']")
    public MobileElement additionalDriverOne;
    
    @FindBy(id = "com.silvercar.dealerware:id/btn_save")
    public MobileElement saveButton;
    
    @FindBy(id = "com.silvercar.dealerware:id/customer_name")
    public MobileElement customerNameLable;
    
    @FindBy(xpath = "//*[@text='Pickup *']")
    public MobileElement pickupLabel;
    
    @FindBy (xpath = "//*[@text='Dropoff *']")
    public MobileElement dropoffLabel;
    
    @FindBy (xpath = "//*[@text='Vehicle Group *']")
    public MobileElement vehicleGroupLabel;
    
    @FindBy (xpath = "//*[@text='Service Advisor']")
    public MobileElement serviceAdvisorLabel;
    
    @FindBy (xpath = "//*[@text='Additional Driver']")
    public MobileElement additionalDriverLabel;
    
    @FindBy (id = "com.silvercar.dealerware:id/repair_order")
    public MobileElement repairOrder;
    
    @FindBy (id = "com.silvercar.dealerware:id/service_vehicle_id")
    public MobileElement serviceVehicleId;
    
    @FindBy(xpath = "//*[@text='This reservation is not scheduled to begin today.']")
    public MobileElement reservationStartErrorMessages;
    
    public void selectServiceAdvisor() {
        this.serviceAdvisor.click();
        new Utility().waitForElementToDisplay(getDriver(), this.serviceAdvisorCell.get(0));
        this.serviceAdvisorCell.get(0).click();
        this.saveSelectionButton.click();
    }

    public void clickAssignVehicleButton() {
        new Utility().waitForElementToDisplay(getDriver(), this.assignVehicleButton);
        this.assignVehicleButton.click();
    }
    
    public String getAdditionalDriverOne() {
        return this.additionalDriverOne.getAttribute("text");
    }
    
    public void clickAdditionalDriver() {
        this.additionalDriver.click();
    }
    
    public void clickSaveButton() {
        this.saveButton.click();
    }
    
    public String getCustomerNameLable() {
        return this.customerNameLable.getAttribute("text");
    }
    
    public void clickPickupLabel() {
        this.pickupLabel.click();
    }
    
    public void clickDropOffLabel() {
       this.dropoffLabel.click();
    }
    
    public void clickVehicleGroupLabel() {
       this.vehicleGroupLabel.click();
    }
}
