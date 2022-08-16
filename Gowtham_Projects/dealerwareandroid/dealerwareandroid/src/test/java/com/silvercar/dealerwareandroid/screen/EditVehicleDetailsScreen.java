package com.silvercar.dealerwareandroid.screen;

import static io.appium.java_client.touch.offset.PointOption.point;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.silvercar.dealerwareandroid.base.Base;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class EditVehicleDetailsScreen extends Base {

    public EditVehicleDetailsScreen() {
        PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
    }

    @FindBy(id = "com.silvercar.dealerware:id/fuel_gauge")
    public MobileElement fuelSlider;

    @FindBy(id = "com.silvercar.dealerware:id/odometer")
    public MobileElement odometer;

    @FindBy(xpath = "//*[@text='SAVE']")
    public MobileElement saveButton;

    @FindBy(id = "android:id/message")
    public MobileElement odometerMessgae;

    @FindBy(id = "android:id/button1")
    public MobileElement saveButton1;
    
    @FindBy (id = "com.silvercar.dealerware:id/vehicle_status_parent")
    public MobileElement vehicleStatusDropDown;
    
    @FindBy (xpath = "//*[@text='Maintenance']")
    public MobileElement maintenanceLabel;
    
    @FindBy (xpath = "//*[@text='Staged']")
    public MobileElement stagedLabel;
    
    @FindBy (id = "com.silvercar.dealerware:id/location_status")
    public MobileElement locationStatusInput;
    
    @FindBy (id = "com.silvercar.dealerware:id/ok")
    public MobileElement okButton;
    
    @FindBy (id = "com.silvercar.dealerware:id/parentPanel")
    public MobileElement vehicleStatusPanel;
    
    @FindBy(xpath = "//*[@content-desc='Navigate up']")
    public MobileElement navigateUp;
    
    @FindBy (id = "com.silvercar.dealerware:id/vehicle_status")
    public MobileElement vehicleStatus;
    

    public void setFuelLevel(float arg) {
        int start = this.fuelSlider.getLocation().getX();
        int end = this.fuelSlider.getSize().getWidth();
        int y = this.fuelSlider.getLocation().getY();
        int moveTo = (int) (end * arg);
        TouchAction action = new TouchAction(getDriver());
        action.press(point(start, y)).moveTo(point(moveTo, y)).release().perform();
    }

    public void setOdometerReading(String reading) {
        this.odometer.clear();
        this.odometer.sendKeys(reading);
    }

    public void clickSaveButton() {
        this.saveButton.click();
    }

    public void clickSaveButton1() {
        this.saveButton1.click();
    }

    public String getOdometerMessage() {
        return this.odometerMessgae.getAttribute("text");
    }

 public void setStatus(MobileElement groupVehicle, String stausToSet) throws InterruptedException {
       
       groupVehicle.click();
       if (!this.vehicleStatus.getAttribute("text").equalsIgnoreCase(stausToSet)) {
           this.vehicleStatusDropDown.click();
           new WebDriverWait(getDriver(), 50).until(ExpectedConditions.visibilityOf(this.vehicleStatusPanel));
           if ("Maintenance".equalsIgnoreCase(stausToSet)) {
              this.maintenanceLabel.click();
              this.locationStatusInput.sendKeys(stausToSet);
              this.okButton.click();
           } else {
              this.stagedLabel.click();
              setFuelLevel(0.5f);
              clickSaveButton();
           }
       }
       
    }
}
