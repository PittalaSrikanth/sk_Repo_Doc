package com.silvercar.dealerwareandroid.screen;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.silvercar.dealerwareandroid.base.Base;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SettingsScreen extends Base {
    public SettingsScreen() {
        PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
    }

    @FindBy(xpath = "//*/android.widget.ScrollView/android.widget.LinearLayout/"
            + "android.widget.LinearLayout/android.widget.TextView[2]")
    MobileElement locationNameText;

    @FindBy(id = "com.silvercar.dealerware:id/logout")
    public MobileElement logoutButton;

    public String getLocationName() {
        return this.locationNameText.getText();
    }

    public void clickLogout() {
        this.logoutButton.click();
    }
}
