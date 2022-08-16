package basics;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class AlertsExample {

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
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    
	    driver.findElementByXPath("//*[@text='App']").click();
		driver.findElementByXPath("//*[@text='Alert Dialogs']").click();
		
		driver.findElementByAccessibilityId("OK Cancel dialog with a message").click();	
		driver.findElementByXPath("//*[@text='CANCEL']").click();
		Thread.sleep(2000);
		
		driver.findElementByAccessibilityId("OK Cancel dialog with a message").click();	
		String text1 =	driver.findElementById("android:id/alertTitle").getText();
		System.out.println(text1);
		driver.findElementByXPath("//*[@text='OK']").click();
		Thread.sleep(2000);
		
		driver.findElementByXPath("//*[@text='OK CANCEL DIALOG WITH ULTRA LONG MESSAGE']").click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).flingToEnd(10)");
		String text2 =	driver.findElementById("android:id/message").getText();
		System.out.println(text2);
		driver.findElementByXPath("//*[@text='OK']").click();
		
		
		driver.findElementByAccessibilityId("List dialog").click();	
		String text3 =	driver.findElementById("android:id/alertTitle").getText();
		System.out.println(text3);
		driver.findElementByXPath("//*[@text='Command three']").click();
		String text4 =	driver.findElementById("android:id/message").getText();
		System.out.println(text4);
		driver.navigate().back();
		
		
		driver.findElementById("io.appium.android.apis:id/progress_button").click();
//		driver.findElementByXPath("//*[@text='HIDE']").click();
		
		Thread.sleep(5000);
		driver.findElementById("io.appium.android.apis:id/radio_button").click();
		driver.findElementByXPath("//*[@text='Traffic']").click();
		driver.findElementByXPath("//*[@text='OK']").click();
		
		
		driver.findElementById("io.appium.android.apis:id/checkbox_button").click();
		List<WebElement> days = driver.findElementsByXPath("//*[contains(@text,'Every Monday')]");
		
		for(WebElement day : days) {
			day.click();
		}
		driver.findElementByXPath("//*[@text='OK']").click();
		
		driver.findElementById("io.appium.android.apis:id/text_entry_button").click();
		driver.findElementById("io.appium.android.apis:id/username_edit").sendKeys("sk");
		driver.findElementById("io.appium.android.apis:id/password_edit").sendKeys("pass");
		driver.findElementByXPath("//*[@text='OK']").click();
		Thread.sleep(5000);
		
		driver.findElementById("io.appium.android.apis:id/two_buttons_old_school").click();
		driver.findElementById("android:id/button2").click();
		Thread.sleep(8000);
		
		driver.findElementById("io.appium.android.apis:id/two_buttons_holo_light").click();
		String text5 =	driver.findElementById("android:id/alertTitle").getText();
		System.out.println(text5);
		driver.findElementByXPath("//*[@text='OK']").click();
		
		
		
		
	    Thread.sleep(3000);
	    driver.quit();
	}

}
