package com.silvercar.dealerwareandroid.screen;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.silvercar.dealerwareandroid.base.Base;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PaymentScreen extends Base {

    public PaymentScreen() {
        PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
    }

    @FindBy(xpath = "//*[@text='CHARGE CUSTOMER']")
    public MobileElement chargeCustomer;

    @FindBy(xpath = "//*[@text='Rental']/following::android.widget.TextView[1]")
    public MobileElement rentalAmount;

    @FindBy(xpath = "//*[@text='Fuel']/following::android.widget.TextView[1]")
    public MobileElement fuelAmount;

    @FindBy(xpath = "//*[@text='Fuel Service']/following::android.widget.TextView[1]")
    public MobileElement fuelServiceAmount;

    @FindBy(xpath = "//*[@text='Taxes']/following::android.widget.TextView[1]")
    public MobileElement taxesAmount;

    @FindBy(xpath = "//*[@text='Total charge']/following::android.widget.TextView[1]")
    public MobileElement totalChargeAmount;

    @FindBy(xpath = "//*[@text='Total Excess Mileage Charges']/following::android.widget.TextView[1]")
    public MobileElement totalExcessMileageCharges;
    
    @FindBy (xpath = "//*[@text='DONE']")
    public MobileElement doneButton;

    public void clickChargeCustomer() {
        this.chargeCustomer.click();
    }

    public String getRentalAmount() {
        return this.rentalAmount.getAttribute("text");
    }

    public String getFuelAmount() {
        return this.fuelAmount.getAttribute("text");
    }

    public String getFuelService() {
        return this.fuelServiceAmount.getAttribute("text");
    }

    public String getTaxesAmount() {
        return this.taxesAmount.getAttribute("text");
    }

    public String getTotalAmount() {
        return this.totalChargeAmount.getAttribute("text");
    }

    public String getTotalExcessMileageCharges() {
        return this.totalExcessMileageCharges.getAttribute("text");
    }

    public void clickDoneButton() {
        this.doneButton.click();
    }
}
