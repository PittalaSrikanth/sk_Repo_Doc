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
	public static void main(String[] args) throws MalformedURLException, InterruptedException 
	{
		UiAutomator2Options ops = new UiAutomator2Options();
		ops.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.0");
		ops.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		ops.setCapability(MobileCapabilityType.APP, "C:\\Users\\spittala\\Downloads\\ApiDemos-debug.apk");
		
		URL url = new URL("http://localhost:4723/wd/hub");
		AndroidDriver driver = new AndroidDriver(url,ops);
		
		Thread.sleep(5000);
		
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Views']")).click();
		driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='1. Photos']")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.ImageView[1]")).click();
		
		driver.quit();
		
		
		
	}
}
