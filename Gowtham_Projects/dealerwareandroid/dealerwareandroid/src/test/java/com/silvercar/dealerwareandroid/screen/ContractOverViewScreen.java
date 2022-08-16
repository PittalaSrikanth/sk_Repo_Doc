package com.silvercar.dealerwareandroid.screen;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.silvercar.dealerwareandroid.base.Base;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ContractOverViewScreen extends Base {
    public ContractOverViewScreen() {
        PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
    }

    @FindBy(id = "com.silvercar.dealerware:id/user_name")
    public MobileElement additionalDriverLabel;

    @FindBy(id = "com.silvercar.dealerware:id/action_delete")
    public MobileElement deleteButton;

    @FindBy(id = "android:id/button1")
    public MobileElement yesButton;

    @FindBy(id = "com.silvercar.dealerware:id/assign_vehicle_button")
    public MobileElement assignVehicleButton;
    
    @FindBy (id = "com.silvercar.dealerware:id/start_contract_button")
    public MobileElement startContractButton;

    public void clickAdditionalDriverLabel() {
        this.additionalDriverLabel.click();
    }

    public void clickDeleteButton() {
        this.deleteButton.click();
    }

    public void clickYesButton() {
        this.yesButton.click();
    }

    public void clickAssignVehicleButton() {
        this.assignVehicleButton.click();
    }
    
    public void clickStartContractButton() {
        this.startContractButton.click();
    }

}
