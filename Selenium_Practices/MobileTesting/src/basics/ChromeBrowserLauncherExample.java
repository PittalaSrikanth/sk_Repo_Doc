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
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class ChromeBrowserLauncherExample {

	public static void main(String[] args) throws MalformedURLException, InterruptedException 
	{
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	    desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
	    desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
	    desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12");
//	    desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "RZ8R819BV7J");
//		OR
      desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android"); // for real devices only
	    desiredCapabilities.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE, "C:\\Users\\spittala\\Downloads\\chrome104\\chromedriver.exe");
	    desiredCapabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
	    
	    URL remoteUrl = new URL("http://localhost:4723/wd/hub");
	    AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(remoteUrl, desiredCapabilities);
	    
	    driver.get("https://www.google.co.in/");
	    
	    Thread.sleep(3000);
	    driver.quit();
	}

}
