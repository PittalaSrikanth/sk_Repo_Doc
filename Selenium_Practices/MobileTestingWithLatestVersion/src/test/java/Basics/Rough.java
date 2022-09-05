package Basics;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.MobileCapabilityType;

public class Rough 
{
	public static void main(String[] args) throws MalformedURLException 
	{
		UiAutomator2Options ops = new UiAutomator2Options();
		ops.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.0");
		ops.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		
		URL url = new URL("http://localhost:4723/wd/hub");
		AndroidDriver driver = new AndroidDriver(url,ops);
		Activity act = new Activity("io.appium.android.apis", "io.appium.android.apis.ApiDemos");
		driver.startActivity(act);
		
		
		driver.findElement(AppiumBy.accessibilityId("Access'ibility")).click();
		driver.navigate().back();
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Accessibility\"]")).click();
		driver.findElement(AppiumBy.accessibilityId("Accessibility Node Querying")).click();
		driver.findElement(AppiumBy.xpath("(//android.widget.CheckBox[@resource-id='io.appium.android.apis:id/tasklist_finished'])[4]")).click();
		driver.navigate().back();
		driver.findElement(AppiumBy.xpath("(//android.widget.TextView[@resource-id='android:id/text1'])[3]")).click();
		
		driver.quit();
		
	}
}
