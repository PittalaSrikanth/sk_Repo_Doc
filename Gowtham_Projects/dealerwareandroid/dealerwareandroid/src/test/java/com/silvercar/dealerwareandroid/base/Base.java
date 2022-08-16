package com.silvercar.dealerwareandroid.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;

import com.silvercar.dealerwareandroid.utilities.Report;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AutomationName;

import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;
import io.appium.java_client.service.local.AppiumServiceBuilder;

    public class Base extends Report {
        public static ThreadLocal<AndroidDriver<AndroidElement>> driver = 
                new ThreadLocal<AndroidDriver<AndroidElement>>();
        public static   ThreadLocal<AppiumDriverLocalService> service = 
                new ThreadLocal<AppiumDriverLocalService>();
    
    public void setDriver(AndroidDriver<AndroidElement> settingdriver) {
        driver.set(settingdriver);
        }

    public AndroidDriver<AndroidElement>  getDriver() {
        return driver.get();
        }
    
    public void setService(AppiumDriverLocalService settingService) {
        service.set(settingService);
        }
    
    public static AppiumDriverLocalService getService() {
        return service.get();
        }
    
   
    @BeforeMethod
    public void setUp(@Optional("emulator-5554")String deviceName) throws IOException {
        AndroidDriver<AndroidElement> localdriver;
        startServer();
        if (getService() == null || !getService().isRunning()) {
            throw new AppiumServerHasNotBeenStartedLocallyException("Appium Server Not started");
            }
        String basePath = "/src/main/java/com/silvercar/dealerwareandroid/propertyfiles/Base.properties";
        FileInputStream file = new FileInputStream(System.getProperty("user.dir") + basePath);
        Properties appProperty = new Properties();
        appProperty.load(file);
        String appPath = "src/main/java/com/silvercar/dealerwareandroid/propertyfiles";
        File appLocation = new File(appPath);
        File app = new File(appLocation, (String) appProperty.get("appname"));
        
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
        cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
        cap.setCapability("newCommandTimeout", 0);
        localdriver = new AndroidDriver<AndroidElement>(getService().getUrl(), cap);
        localdriver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        setDriver(localdriver);
        }
    
    @AfterTest
    public void afterTest() {
        if (getDriver() != null) {
            getDriver().quit();
            }
        if (service != null) {
            getService().stop();
            }
        }
    
    public  void startServer() {
        AppiumDriverLocalService service;
        AppiumServiceBuilder  serviceBuilder = new AppiumServiceBuilder();
        serviceBuilder.usingAnyFreePort();
        serviceBuilder.usingDriverExecutable(new File("/usr/local/bin/node"));
        serviceBuilder.withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"));
        HashMap<String, String> environment = new HashMap<String, String>();
        environment.put("PATH", "/usr/local/bin:" + System.getenv("PATH"));
        serviceBuilder.withEnvironment(environment);
        service = AppiumDriverLocalService.buildService(serviceBuilder);
        setService(service);
        getService().start();
        }
    }
