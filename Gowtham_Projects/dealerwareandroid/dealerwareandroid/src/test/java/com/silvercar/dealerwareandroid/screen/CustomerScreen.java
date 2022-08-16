package com.silvercar.dealerwareandroid.screen;

import java.util.ArrayList;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.silvercar.dealerwareandroid.base.Base;
import com.silvercar.dealerwareandroid.utilities.Utility;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CustomerScreen extends Base {
    public CustomerScreen() {
        PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
    }

    @FindBy(id = "com.silvercar.dealerware:id/create_customer")
    public MobileElement createCustomer;

    @FindBy(id = "com.silvercar.dealerware:id/action_skip")
    public MobileElement skipButton;

    @FindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
    MobileElement allowButton;

    @FindBy(id = "com.android.permissioncontroller:id/permission_deny_button")
    MobileElement denyButton;

    @FindBy(id = "com.silvercar.dealerware:id/personalInfo")
    public MobileElement personalInfoLabel;

    @FindBy(id = "com.silvercar.dealerware:id/driversLicense")
    public MobileElement driverLicenseLabel;

    @FindBy(id = "com.silvercar.dealerware:id/insurance")
    public MobileElement insurenceLabel;

    @FindBy(id = "com.silvercar.dealerware:id/action_search")
    public MobileElement searchIcon;

    @FindBy(id = "com.silvercar.dealerware:id/search_src_text")
    public MobileElement searchBox;

    @FindBy(xpath = "//*[@resource-id='com.silvercar.dealerware:id/swipe_container']/android.widget.ImageView")
    public MobileElement loaderIcon;

    @FindBy(id = "com.silvercar.dealerware:id/search_close_btn")
    public MobileElement searchCloseButton;

    @FindBy(id = "com.silvercar.dealerware:id/name")
    public ArrayList<MobileElement> customerNameList;

    @FindBy(id = "com.silvercar.dealerware:id/createContract")
    public MobileElement createContract;

    public void clickCreateCustomer() {
        this.createCustomer.click();
    }

    public void clickSkipButton() {
        this.skipButton.click();
    }

    public void clickAllowButton() {
        if (new Utility().isDisplayed(this.allowButton)) {
            this.allowButton.click();
        }
    }

    public void enterSearchKey(String key) {
        this.searchIcon.click();
        this.searchBox.clear();
        this.searchBox.sendKeys(key);
    }

    public ArrayList<MobileElement> getCustomerNames() {
        return this.customerNameList;
    }

    public void clickCreateContract() {
        this.createContract.click();
    }

}
