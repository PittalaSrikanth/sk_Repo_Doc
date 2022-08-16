package com.silvercar.dealerwareandroid.screen;

import java.util.ArrayList;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.silvercar.dealerwareandroid.base.Base;
import com.silvercar.dealerwareandroid.utilities.Utility;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CustomerProfileScreen extends Base {
    public CustomerProfileScreen() {
        PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
    }

    @FindBy(id = "com.silvercar.dealerware:id/create_customer")
    MobileElement createCustomerButton;

    @FindBy(id = "com.silvercar.dealerware:id/action_skip")
    MobileElement skipButton;

    @FindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
    MobileElement allowButton;

    @FindBy(id = "com.android.permissioncontroller:id/permission_deny_button")
    MobileElement denyButton;

    @FindBy(id = "com.silvercar.dealerware:id/personalInfo")
    public MobileElement personalInfoLabel;

    @FindBy(id = "com.silvercar.dealerware:id/driversLicense")
    MobileElement driverLicenseLabel;

    @FindBy(id = "com.silvercar.dealerware:id/insurance")
    MobileElement insuranceLabel;

    @FindBy(id = "com.silvercar.dealerware:id/action_search")
    MobileElement searchIcon;

    @FindBy(id = "com.silvercar.dealerware:id/search_src_text")
    MobileElement searchBox;

    @FindBy(xpath = "//*[@resource-id='com.silvercar.dealerware:id/swipe_container']/android.widget.ImageView")
    MobileElement loaderIcon;

    @FindBy(id = "com.silvercar.dealerware:id/search_close_btn")
    MobileElement searchCloseButton;

    @FindBy(id = "com.silvercar.dealerware:id/name")
    ArrayList<MobileElement> customerNameList;

    @FindBy(id = "com.silvercar.dealerware:id/createContract")
    public MobileElement createContract;

    public void clickCreateCustomer() {
        this.createCustomerButton.click();
    }

    public void clickSkipButton() {
        this.skipButton.click();
        test.info("Clicked on Skip button in Insurance Screen");
    }

    public void clickAllowButton() {
        if (new Utility().isDisplayed(this.allowButton))
            this.allowButton.click();
        test.info("Clicked on Create new Customer ");
    }

    public void enterSearchKey(String key) {
        this.searchIcon.click();
        this.searchBox.sendKeys(key);
        test.info("Entered the Search term");
    }

    public ArrayList<MobileElement> getCustomerNames() {
        return this.customerNameList;
    }

    public void clickCreateContract() {
        this.createContract.click();
    }

    public void clickPersonalInfo() {
        this.personalInfoLabel.click();
    }

    public void clickDrivenLicense() {
        this.driverLicenseLabel.click();
    }

    public void clickInsurance() {
        this.insuranceLabel.click();
    }

}
