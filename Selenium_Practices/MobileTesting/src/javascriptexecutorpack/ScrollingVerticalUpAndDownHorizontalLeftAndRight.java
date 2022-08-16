package javascriptexecutorpack;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class ScrollingVerticalUpAndDownHorizontalLeftAndRight {

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

	    		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Tabs\"))");
	    		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Gallery\"))");
	    		
	    	    driver.findElementByAccessibilityId("Gallery").click();
	    	    driver.findElementByAccessibilityId("1. Photos").click();
	    	    WebElement pn = driver.findElementsByClassName("android.widget.ImageView").get(1);

	    		Thread.sleep(1000);

	    		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"io.appium.android.apis:id/gallery\").scrollable(true)).setAsHorizontalList().scrollIntoView(new UiSelector().text(\"android.widget.ImageView[8]\"))").click();
	    		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"io.appium.android.apis:id/gallery\").scrollable(true)).setAsHorizontalList().scrollIntoView(new UiSelector().text(\"android.widget.ImageView[1]\"))").click();
	    		
	    
	    
	    Thread.sleep(3000);
	    
	    
	    

	    
	  
	    driver.quit();
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    


	}

}
