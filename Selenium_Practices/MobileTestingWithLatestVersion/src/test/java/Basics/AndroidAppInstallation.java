package Basics;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.MobileCapabilityType;

public class AndroidAppInstallation 
{
	public static void main(String[] args) throws MalformedURLException 
	{
		UiAutomator2Options ops = new UiAutomator2Options();
		ops.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12");
		ops.setCapability(MobileCapabilityType.DEVICE_NAME, "10.51.33.117:5555");
		ops.setCapability(MobileCapabilityType.APP, "C:\\Users\\spittala\\Downloads\\ApiDemos-debug.apk");
		
		URL url = new URL("http://localhost:4723/wd/hub");
		AndroidDriver driver = new AndroidDriver(url,ops);
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Views\")")).click();
		
	}
}
