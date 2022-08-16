package basics;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class AppInstallation {

	public static void main(String[] args) throws MalformedURLException 
	{
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
//	    desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
//	    desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
//	    desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13");
//	    desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
//	    desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\spittala\\Downloads\\ApiDemos-debug.apk");


	    desiredCapabilities.setCapability("automationName", "Appium");
	    desiredCapabilities.setCapability("platformName", "Android");
	    desiredCapabilities.setCapability("platformVersion", "8.0");
	    desiredCapabilities.setCapability("deviceName", "emulator-5554");
	    desiredCapabilities.setCapability("app", "C:\\Users\\spittala\\Downloads\\ApiDemos-debug.apk");
		
		
		
		URL remoteUrl = new URL("http://localhost:4723/wd/hub");

	    AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(remoteUrl, desiredCapabilities);
	    
	    Dimension dimension = driver.manage().window().getSize();
	    int deviceHeight = dimension.getHeight();
	    int deviceWidth = dimension.getWidth();
	    System.out.println("Height x Width of device is: " + deviceHeight + " x " + deviceWidth);
	    int elementX= driver.findElementByXPath("//*[@text='Animation']").getLocation().getX();
	    int elementY= driver.findElementByXPath("//*[@text='Animation']").getLocation().getY();
	    System.out.println(elementX +" : "+ elementY);
	    
	  
	    driver.quit();
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    


	}

}
