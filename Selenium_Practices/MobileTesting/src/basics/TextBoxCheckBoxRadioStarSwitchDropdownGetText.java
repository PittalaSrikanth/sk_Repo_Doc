package basics;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class TextBoxCheckBoxRadioStarSwitchDropdownGetText {

	public static void main(String[] args) throws MalformedURLException, InterruptedException 
	{
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	    desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
	    desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
	    desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.0");
	    desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
	    desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "io.appium.android.apis.ApiDemos");
	    desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "io.appium.android.apis");

	    URL remoteUrl = new URL("http://localhost:4723/wd/hub");

	    AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(remoteUrl, desiredCapabilities);
	    
	    driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Views\")").click();

	    driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Controls\"))").click();
	    		
	    driver.findElementByAccessibilityId("1. Light Theme").click();
	    
	    driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Save\").index(0)").click();
	    
	    driver.findElementById("io.appium.android.apis:id/edit").sendKeys("srikanth");
	    
	    driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Checkbox 1\")").click();
	    driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Checkbox 2\")").click();
	    driver.findElementByAndroidUIAutomator("new UiSelector().text(\"RadioButton 1\")").click();
	    driver.findElementByAndroidUIAutomator("new UiSelector().text(\"RadioButton 2\")").click();
	    driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Star\")").click();
	    
	    driver.findElementByAndroidUIAutomator("new UiSelector().text(\"OFF\").index(6)").click();
	    driver.findElementByAndroidUIAutomator("new UiSelector().text(\"OFF\").index(7)").click();
	    driver.hideKeyboard();
	    
	    driver.findElementById("spinner1").click();
	    
	    driver.findElementByXPath("//*[@text='Uranus']").click();
	    
	    System.out.println(driver.findElementByAccessibilityId("textColorPrimary").getText());
	    
	    
	   
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    Thread.sleep(3000);
	    
	    
	    

	    
	  
	    driver.quit();
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    


	}

}
