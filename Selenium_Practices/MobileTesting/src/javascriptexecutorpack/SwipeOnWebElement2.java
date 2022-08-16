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

public class SwipeOnWebElement2 {

	public static void main(String[] args) throws MalformedURLException, InterruptedException 
	{
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	    desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
	    desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
	    desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.0");
	    desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
	    desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".sample.activities.SwipeListViewExampleActivity");
	    desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.fortysevendeg.android.swipelistview");

	    URL remoteUrl = new URL("http://localhost:4723/wd/hub");
	    AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(remoteUrl, desiredCapabilities);
	    
	    driver.findElementByXPath("//*[contains(@text,'show this message again')]").click();
	    driver.findElementByXPath("//*[@text='Ok']").click();
	    
	    
	    
	
	    WebElement as = driver.findElementByXPath("//*[@text='Android System']");
	    WebElement ast = driver.findElementByXPath("//*[@text='Appium Settings']");
	    JavascriptExecutor js = (JavascriptExecutor)driver;
	    
	    js.executeScript("mobile: swipeGesture", ImmutableMap.of(
	    	    "elementId", ((RemoteWebElement) as).getId(),"direction", "left","percent", 0.75));

	    js.executeScript("mobile: swipeGesture", ImmutableMap.of(
	    		"elementId", ((RemoteWebElement) ast).getId(),"direction", "left","percent", 0.75));
	    
	   
	    
	    Thread.sleep(3000);
	    driver.quit();
	}

}
