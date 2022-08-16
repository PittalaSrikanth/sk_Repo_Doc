package packageOne;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;


public class ApkInstallation2 {

	public static void main(String[] args) throws MalformedURLException 
	{
		DesiredCapabilities ds = new DesiredCapabilities();
		ds.setCapability("automationName", "Appium");
		ds.setCapability("platformName", "Android");
		ds.setCapability("deviceName", "emulator-5554");
		ds.setCapability("platformVersion", "8.0");
		
		ds.setCapability("app", "D:\\MyAppiumFiles\\ApiDemos.apk");
		
		
		URL url = new URL("http://localhost:4723/wd/hub");
		
		
		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(url,ds);
		
		
		
		driver.quit();

	}

}
