package Basics;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.MobileCapabilityType;

public class AndroidExistingApp 
{
	public static void main(String[] args) throws MalformedURLException 
	{
		UiAutomator2Options ops = new UiAutomator2Options();
		ops.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.0");
		ops.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		
		URL url = new URL("http://localhost:4723/wd/hub");
		AndroidDriver driver = new AndroidDriver(url,ops);
		Activity act = new Activity("io.appium.android.apis", "io.appium.android.apis.view.DragAndDropDemo");
		driver.startActivity(act);
		driver.quit();
		
	}
}
