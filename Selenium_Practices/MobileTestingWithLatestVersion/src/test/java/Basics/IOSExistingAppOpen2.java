package Basics;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.JavascriptExecutor;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class IOSExistingAppOpen2 
{
	public static void main(String[] args) throws MalformedURLException 
	{
		XCUITestOptions ops = new XCUITestOptions();
		ops.setCapability(MobileCapabilityType.PLATFORM_VERSION, "15");
		ops.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 13 Pro");
		ops.setWdaLaunchTimeout(Duration.ofSeconds(10));
		URL url = new URL("http://localhost:4723/wd/hub");
		IOSDriver driver = new IOSDriver(url,ops);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("bundleId ", "com.apple.calculator");
		js.executeScript("mobile:launchApp", params);

		
	}
}
