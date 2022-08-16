package com.silvercar.dealerwareandroid.screen;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.silvercar.dealerwareandroid.base.Base;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class VehiclesScreen extends Base {

    public VehiclesScreen() {
        PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
    }

    @FindBy(id = "com.silvercar.dealerware:id/action_search")
    public MobileElement vehicleSearchIcon;

    @FindBy(id = "com.silvercar.dealerware:id/search_src_text")
    public MobileElement vechicleSearchBox;

    @FindBy(id = "com.silvercar.dealerware:id/finish_contract")
    public MobileElement finishContract;
    
    @FindBy(xpath = "//*[@text='Vehicle Group - Courtesy']")
    public MobileElement courtesyVehicleGroup;
    
    @FindBy(xpath = "//*[@text='Vehicle Group - Test location']")
    public MobileElement testLocationVehicleGroup;
    
    @FindBy(xpath = "//*[@content-desc='Navigate up']")
    public MobileElement navigateUp;
    
    
    public void searchVehicle(String key) {
        this.vehicleSearchIcon.click();
        this.vechicleSearchBox.click();
        this.vechicleSearchBox.sendKeys(key);
    }

    public void clickFinishContract() {
        this.finishContract.click();
    }
    
    public void clickNavigateUp() {
        getDriver().navigate().back();
    }
   

}
