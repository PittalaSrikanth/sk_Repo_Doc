package com.silvercar.dealerwareandroid.screen;

import java.util.ArrayList;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.silvercar.dealerwareandroid.base.Base;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CreateContractScreen extends Base {

    public CreateContractScreen() {
        PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
    }

    @FindBy(id = "android:id/text1")
    public ArrayList<MobileElement> selectServiceAdvisor;

    @FindBy(id = "com.silvercar.dealerware:id/save_assign")
    public MobileElement assignvehicleButton;

    @FindBy(xpath = "//*[@resource-id='com.silvercar.dealerware:id/toolbar']/android.widget.TextView[@text='Contracts'"
              + "]")
    public MobileElement contractHeader;


    public void clickOnAssignVehicle() {
        this.assignvehicleButton.click();
    }

}
