package basics;

import java.lang.reflect.Executable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

import javax.lang.model.type.ExecutableType;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverInfo;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class SrikanthAppTest {

	public static void main(String[] args) throws MalformedURLException, InterruptedException 
	{
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	    desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
	    desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
	    desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.0");
//	    					OR
	    desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
	    desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".MainActivity");
	    desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.bikewale.app");
	    desiredCapabilities.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE, "C:\\Users\\spittala\\Downloads\\chrome104vys\\chromedriver.exe");
	    
	    URL remoteUrl = new URL("http://localhost:4723/wd/hub");
	    AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(remoteUrl, desiredCapabilities);
//	    IOSDriver<WebElement> driver = new IOSDriver<WebElement>(remoteUrl, desiredCapabilities);
	    
	    
	    
	    Thread.sleep(3000);
	    driver.quit();
	}

}
