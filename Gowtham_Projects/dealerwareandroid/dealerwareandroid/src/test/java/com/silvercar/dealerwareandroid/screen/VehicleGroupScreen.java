package com.silvercar.dealerwareandroid.screen;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.silvercar.dealerwareandroid.base.Base;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class VehicleGroupScreen extends Base {

    public VehicleGroupScreen() {
        PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
    }

    @FindBy(xpath = "//*[@resource-id='com.silvercar.dealerware:id/unavailable_fleet_list']//android.widget.TextView")
    public List<MobileElement> overBookedFleetList;
    
    @FindBy(xpath = "//*[@resource-id='com.silvercar.dealerware:id/available_fleet_list']//android.widget.TextView")
    public List<MobileElement> availableFleetList;
    
    @FindBy (id = "com.silvercar.dealerware:id/available_fleets_empty")
    public MobileElement availableFleetsEmpty;
    
    @FindBy (xpath = "//*[@text='SAVE OVERBOOKED SELECTION']")
    public MobileElement saveOverbookedSelectionButton;
    
    @FindBy (xpath = "//*[@text='SAVE SELECTION']")
    public MobileElement saveSelectionButton;
    
    @FindBy (xpath = "//*[@text='There are no overbooked Vehicle Groups.']")
    public MobileElement overBookedFleetsEmpty;
    
    
    public List<String> getoverBookedFleetList() {
       List<String> overBookedFleet = new ArrayList<String>();
       List<MobileElement> list = this.overBookedFleetList;
       for (MobileElement ele : list) {
          overBookedFleet.add(ele.getAttribute("text"));
       }
       return overBookedFleet;
    }
    
    public List<String> getAvailableFleetList() {
       List<String> availableFleet = new ArrayList<String>();
       List<MobileElement> list = this.availableFleetList;
       for (MobileElement ele : list) {
          availableFleet.add(ele.getAttribute("text"));
       }
       return availableFleet;
    }
    
    
}
