package javascriptexecutorpack;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.bys.builder.AppiumByBuilder;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class SwipeOnWebElement {

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
	    driver.findElementByAccessibilityId("Gallery").click();
	    driver.findElementByAccessibilityId("1. Photos").click();
	    WebElement pn = driver.findElementsByClassName("android.widget.ImageView").get(1);
	    
	    JavascriptExecutor js = (JavascriptExecutor)driver;
	    js.executeScript("mobile: swipeGesture", ImmutableMap.of(
	    	    "elementId", ((RemoteWebElement) pn).getId(),"direction", "left","percent", 0.75));

	   
	    
	    Thread.sleep(3000);
	    driver.quit();
	}

}
