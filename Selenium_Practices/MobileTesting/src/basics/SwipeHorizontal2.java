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
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class SwipeHorizontal2 {

	public static void main(String[] args) throws MalformedURLException, InterruptedException 
	{
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	    desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
	    desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
	    desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.0");
	    desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
	    desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.google.android.dialer.extensions.GoogleDialtactsActivity");
	    desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.google.android.dialer");

	    URL remoteUrl = new URL("http://localhost:4723/wd/hub");

	    AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(remoteUrl, desiredCapabilities);
	    
	    Dimension size = driver.manage().window().getSize();
	    
	    WebElement Panel = driver.findElement(By.id("lists_pager"));
		
		int Anchor = Panel.getSize().getHeight()/2; 
		
		// swipe right
		int startY = (int) (size.height / 2);
        int startX = (int) (size.width * 0.90);
        int endX = (int) (size.width * 0.05);
        new TouchAction(driver)
	        .longPress(PointOption.point(startX, startY))
	        .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
	        .moveTo(PointOption.point(endX, startY))
	        .release()
	        .perform();
		
        // swipe left
        startY = (int) (size.height / 2);
        startX = (int) (size.width * 0.05);
        endX = (int) (size.width * 0.90);
        new TouchAction(driver)
                .longPress(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(endX, startY))
                .release()
                .perform();
        
		Thread.sleep(3000);
	    
	    
	    

	    
	  
	    driver.quit();
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    


	}

}
