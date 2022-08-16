package com.silvercar.dealerwareandroid.screen;

import java.io.IOException;
import java.util.List;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.silvercar.dealerwareandroid.base.Base;
import com.silvercar.dealerwareandroid.utilities.Utility;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ChooseCompanyScreen extends Base {
    public ChooseCompanyScreen() {
        PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
    }

    @FindBy(id = "com.silvercar.dealerware:id/companies")
    List<MobileElement> companies;

    public void selectLocation(String location) throws ConfigurationException, IOException {
       Utility utility = new Utility();
       utility.scrollElementToView(location);
        new WebDriverWait(getDriver(), 50).until(ExpectedConditions.visibilityOf(
                getDriver().findElement(By.xpath("//android.widget.TextView[@text='" + location + "']"))));
        
        MobileElement locationName = getDriver()
                .findElement(By.xpath("//android.widget.TextView[@text='" + location + "']"));
        locationName.click();
        test.info("Select's a Company Location" + location);
    }

}