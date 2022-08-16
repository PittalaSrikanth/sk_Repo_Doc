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

public class WebViewExample {

	public static void main(String[] args) throws MalformedURLException, InterruptedException 
	{
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	    desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
	    desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
	    desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13");
	    desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
	    desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "io.appium.android.apis.ApiDemos");
	    desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "io.appium.android.apis");
	    desiredCapabilities.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE, "C:\\Users\\spittala\\Downloads\\chrome101\\chromedriver.exe");
	    
	    URL remoteUrl = new URL("http://localhost:4723/wd/hub");
	    AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(remoteUrl, desiredCapabilities);
	    
	    driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Views\")").click();
	    
	    String parentContext =   driver.getContext();
	    System.out.println("parentContext : "+ parentContext);
	    driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"))").click();
	    Thread.sleep(4000);
	    Set<String> allcontexts = driver.getContextHandles();
	    for(String context : allcontexts)
	    {
	    	System.out.println(context);
	    	if(context!=parentContext)
	    	{
	    		driver.context(context);
	    	}
	    }

	    String switchedcontext =   driver.getContext();
	    System.out.println("switched Context : "+ switchedcontext);
	    driver.findElement(By.xpath("//*[text()='i am a link']")).click();
	    
	    driver.context(parentContext);
	    System.out.println(driver.findElement(By.xpath("//*[@text='I am some other page content']")).isDisplayed());
	    
	    driver.navigate().back();
	    driver.context(parentContext);
	    driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Visibility\")").click();
	    
	    Thread.sleep(3000);
	    driver.quit();
	}

}
