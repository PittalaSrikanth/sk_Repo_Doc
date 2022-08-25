package basics;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class IOSAppInstallation {

	public static void main(String[] args) throws MalformedURLException 
	{
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
//	    desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
//	    desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
//	    desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "15");
//	    desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 13 Pro");
//	    desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\spittala\\Downloads\\ApiDemos-debug.app");


	    desiredCapabilities.setCapability("automationName", "XCUITest");
	    desiredCapabilities.setCapability("platformName", "iOS");
	    desiredCapabilities.setCapability("platformVersion", "15");
	    desiredCapabilities.setCapability("deviceName", "iPhone 13 Pro");
	    desiredCapabilities.setCapability("app", "C:\\Users\\spittala\\Downloads\\ApiDemos-debug.app");
		
		
		
		URL remoteUrl = new URL("http://localhost:4723/wd/hub");

	    IOSDriver<WebElement> driver = new IOSDriver<WebElement>(remoteUrl, desiredCapabilities);
	    
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
