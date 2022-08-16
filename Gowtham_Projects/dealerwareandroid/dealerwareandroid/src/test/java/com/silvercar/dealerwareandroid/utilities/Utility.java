package com.silvercar.dealerwareandroid.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.silvercar.dealerwareandroid.base.Base;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class Utility extends Base {
    
    public String getFromBaseProperties(String key) throws IOException, ConfigurationException {
        String propertyFileName = "/src/main/java/com/silvercar/dealerwareandroid/propertyfiles/Base.properties";
        FileInputStream baseProperties = new FileInputStream(System.getProperty("user.dir") + propertyFileName);
        Properties basePropertiesValue = new Properties();
        basePropertiesValue.load(baseProperties);
        String value = (String) basePropertiesValue.get(key);
        return value;
        }
    
    public void setBaseProperties(String key, String value) throws ConfigurationException, IOException {
         String propertyFileName = "/src/main/java/com/silvercar/dealerwareandroid/propertyfiles/Base.properties";
         FileInputStream baseProperties = new FileInputStream(System.getProperty("user.dir") + propertyFileName);
         Properties basePropertiesValue = new Properties();
         basePropertiesValue.load(baseProperties);
         PropertiesConfiguration conf = new PropertiesConfiguration(System.getProperty("user.dir") 
         + "/src/main/java/com/silvercar/dealerwareandroid/propertyfiles/Base.properties");
         conf.setProperty(key, value);
         conf.save();
    }
    
    
    public boolean isDisplayed(WebElement element) {
        boolean flag = false;
        try {
            element.isDisplayed();
            flag = true;
        } catch (NoSuchElementException e) {
            flag = false;
        }
         return flag;
    }

    public String getFutureAndPastDate(String pastFuturelabel, int noOfDays) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String localDate;
        switch (pastFuturelabel) {
        case "future":
            localDate = dtf.format(LocalDate.now().plusDays(noOfDays)).toString();
            break;
        case "past":
            localDate = dtf.format(LocalDate.now().minusDays(noOfDays)).toString();
            break;
        default:
            localDate = dtf.format(LocalDate.now()).toString();
        }
        return localDate;

    }

    public void waitForElementToDisplay(WebDriver driver, WebElement elementToDisplay) {
        new WebDriverWait(driver, 50).until(ExpectedConditions.visibilityOf(elementToDisplay));
    }
    
    public void waitForElementToClickable(WebDriver driver, WebElement elementToClick) {
        new WebDriverWait(driver, 50).until(ExpectedConditions.elementToBeClickable(elementToClick));
    }

    public void scrollElementToView(String text) {
        String uiSelector = "new UiSelector().textContains(\"" + text + "\")";
        String command = "new UiScrollable(new UiSelector().scrollable(true).instance(0))"
                + ".scrollIntoView(" + uiSelector + ");";
        getDriver().findElement(MobileBy.AndroidUIAutomator(command));
    }
    
    public void waitForElementToDisappear(WebDriver driver, WebElement elementToDisappear) {
        new WebDriverWait(driver, 50).until(ExpectedConditions.invisibilityOf(elementToDisappear));
    }
    
    public MobileElement getDynamicElement(AndroidDriver driver, String text) {
        return (MobileElement) driver.findElement(By.xpath(
                "//android.widget.TextView[contains(@text,'" + text + "')]"));
    }
    
    public void staticWait(int waitTimeInSeconds) {
        
        try {
            Thread.sleep(waitTimeInSeconds);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public String getRandomName(String key) throws ConfigurationException, IOException {
        String value = new Utility().getFromBaseProperties(key).substring(0, 4);
        value = value + RandomStringUtils.randomNumeric(5);
        setBaseProperties(key, value);
        return value;
    }
    
    public String getRandomEmail(String key) throws ConfigurationException, IOException {
        String value = new Utility().getFromBaseProperties(key).substring(0, 9);
        value = value + RandomStringUtils.randomNumeric(5);
        String email = value + "@silvercar.com";
        setBaseProperties(key, email);
        return email;
    }

    
    public void scrollDown(Double startePosition, Double endPosition) {
        Dimension dimension = getDriver().manage().window().getSize();
        Double scrollHeightStart = dimension.getHeight() * startePosition; //0.5
        int scrollStart = scrollHeightStart.intValue();
        Double scrollHeightEnd = dimension.getHeight() * endPosition; //0.2
        int scrollEnd = scrollHeightEnd.intValue();
        new TouchAction((PerformsTouchActions) getDriver())
        .press(PointOption.point(0, scrollStart))
        .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
        .moveTo(PointOption.point(0, scrollEnd))
        .release().perform();
        }
    
    public Object waitForPresenceOfElement(String locatorText) {
        return  new WebDriverWait(getDriver(), 10).until(ExpectedConditions.presenceOfElementLocated(
               By.xpath("//*[contains(@text,'" + locatorText + "')]")));
    }
    
    public boolean isDisplayed(String locator) {
        MobileElement ele = null;
        boolean flag = false;
        try {
            ele = getDriver().findElement(By.xpath(
                    "//android.widget.TextView[contains(@text,'" + locator + "')]"));
            flag = ele.isDisplayed();
        } catch (NoSuchElementException e) {
            flag = false;
       }
        return flag;
    }

    public String getToastMessgaes() {
        return getDriver().findElement(By.xpath("/hierarchy/android.widget.Toast")).getText();
    }
    
}
