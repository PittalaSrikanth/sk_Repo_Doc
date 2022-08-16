package basics;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;


public class WebViewExample {

	public static void main(String[] args) throws MalformedURLException 
	{
//	    desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "io.appium.android.apis.ApiDemos");
//	    desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "io.appium.android.apis");
	    
	    UiAutomator2Options options = new UiAutomator2Options();
//	    options.setAutomationName("Appium");
//	    options.setPlatformName("Android");
//	    options.setPlatformVersion("13");
	    options.setDeviceName("emulator-5554");
	    options.setApp("");
	    options.setChromedriverExecutable("C:/Users/spittala/Downloads/chrome101/chromedriver.exe");
	    
	    
	    
	    
	    URL remoteUrl = new URL("http://localhost:4723/wd/hub");
	    AndroidDriver driver = new AndroidDriver(remoteUrl, options);
	    


	}

}
