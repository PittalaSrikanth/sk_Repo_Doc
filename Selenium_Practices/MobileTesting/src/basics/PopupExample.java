package basics;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class PopupExample {

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
	    System.setProperty("webdriver.chrome.driver", "C:\\Users\\spittala\\Downloads\\chromedriver_win32 (6)\\chromedriver.exe");
	    AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(remoteUrl, desiredCapabilities);
	    
	    driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Preference\")").click();
	    driver.findElementByAccessibilityId("3. Preference dependencies").click();
	    driver.findElementByXPath("//*[@text='WiFi']").click();
	    driver.findElementByXPath("//*[@text='WiFi settings']").click();
	    String popuptitle = driver.findElementById("android:id/alertTitle").getText ();
	    System.out.println(popuptitle);
	    driver.findElementById("android:id/edit").sendKeys("popup");
	    driver.findElementsByClassName("android.widget.Button").get(1).click();
	    
	    Thread.sleep(3000);
	    driver.quit();
	}

}
