package com.silvercar.dealerwareandroid.screen;

import java.util.List;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.silvercar.dealerwareandroid.base.Base;
import com.silvercar.dealerwareandroid.utilities.Utility;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AcknowledgementScreen extends Base {
    
    public AcknowledgementScreen() {
        PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
    }
    
    @FindBy(xpath = "//android.widget.Switch")
    public List<MobileElement> sliders;
    
    @FindBy(xpath = "//*[@text='AGREE & CONTINUE']")
    public MobileElement agreeAndContinueButton;
    
    
    public void clickAgreeAndContinueButton() {
        this.agreeAndContinueButton.click();
    }
    
    public void selectSliders() {
        List<MobileElement> slidersElements = this.sliders;
        for (int i = 0; i < slidersElements.size(); i++) {
            sliders.get(i).click();
            if (i == slidersElements.size() / 2) {
                new Utility().scrollDown(0.5, 0.1);
                slidersElements = null;
                slidersElements = this.sliders;
                break;
          }
        }
        for (int i = sliders.size() - 1; i > 0; i--) {
            if (sliders.get(i).getAttribute("checked").equalsIgnoreCase("false")) {
                sliders.get(i).click();
            } else {
                break;
            }
        }
    }
}
