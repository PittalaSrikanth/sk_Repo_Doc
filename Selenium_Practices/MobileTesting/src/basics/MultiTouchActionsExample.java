package basics;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class MultiTouchActionsExample {

	public static void main(String[] args) throws MalformedURLException 
	{
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

	    desiredCapabilities.setCapability("automationName", "Appium");
	    desiredCapabilities.setCapability("platformName", "Android");
	    desiredCapabilities.setCapability("platformVersion", "8.0");
	    desiredCapabilities.setCapability("deviceName", "emulator-5554");
	    desiredCapabilities.setCapability("app", "D:\\Automation_\\Siddhi_Notes_Repo\\apps\\com.the511plus.MultiTouchTester.apk");
		
		
		
		URL remoteUrl = new URL("http://localhost:4723/wd/hub");

	    AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(remoteUrl, desiredCapabilities);
	    
	    Dimension dim=driver.manage().window().getSize();     
	    int width=dim.width;
	    int height =dim.height;

	    int firstTouchXcoordinate_Start =(int)(width*.5);
	    int firstTouchYcoordinate_Start =(int)(height*.4);

	    int firstTouchXcoordinate_End =(int)(width*.1);
	     int firstTouchYcoordinate_End =(int)(height*.1);

	     int secondTouchXcoordinate_Start =(int)(width*.5);
	     int secondTouchYcoordinate_Start =(int)(height*.6);

	     int secondTouchXcoordinate_End =(int)(width*.9);
	     int secondTouchYcoordinate_End =(int)(height*.9);

	     TouchAction touch1=new TouchAction(driver);
	     TouchAction touch2=new TouchAction(driver);

	     touch1.longPress(PointOption.point(firstTouchXcoordinate_Start, firstTouchYcoordinate_Start))
	     .waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
	     .moveTo(PointOption.point(firstTouchXcoordinate_End, firstTouchYcoordinate_End));

	     touch2.longPress(PointOption.point(secondTouchXcoordinate_Start, secondTouchYcoordinate_Start))
	     .waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
	     .moveTo(PointOption.point(secondTouchXcoordinate_End, secondTouchYcoordinate_End));

	     MultiTouchAction multi=new MultiTouchAction(driver);
	     multi.add(touch1).add(touch2).perform();

	  
	    driver.quit();
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    


	}

}
