package basics;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class SwipeVertical2 {

	public static void main(String[] args) throws MalformedURLException, InterruptedException 
	{
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	    desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
	    desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
	    desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.0");
	    desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5556");
	    desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.h6ah4i.android.example.advrecyclerview.launcher.MainActivity");
	    desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.h6ah4i.android.example.advrecyclerview");

	    URL remoteUrl = new URL("http://localhost:4723/wd/hub");

	    AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(remoteUrl, desiredCapabilities);
	    driver.findElement(By.id("com.h6ah4i.android.example.advrecyclerview:id/button")).click();
	    
	    

	    
	    
	    Dimension size = driver.manage().window().getSize();
	   
	    
	    
	    
	    WebElement Panel = driver.findElement(By.xpath("//*[@text='Item 0']"));
		
		int Anchor = Panel.getSize().getWidth()/2; 
		
		
		// swipe down
        int endY = (int) (size.height * 0.70);
        int startY = (int) (size.height * 0.30);
        int startX = (size.width / 2);
        System.out.println(endY +" : "+startY+" : "+startX);
        new TouchAction(driver)
                .longPress(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(startX, endY))
                .release()
                .perform();

        // swipe up
        startY = (int) (size.height * 0.70);
        endY = (int) (size.height * 0.30);
        startX = (size.width / 2);
        new TouchAction(driver)
		        .longPress(PointOption.point(startX, startY))
		        .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
		        .moveTo(PointOption.point(startX, endY))
		        .release()
		        .perform();
		Thread.sleep(3000);
	    
	    
	    

	    
	  
	    driver.quit();
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    


	}

}
