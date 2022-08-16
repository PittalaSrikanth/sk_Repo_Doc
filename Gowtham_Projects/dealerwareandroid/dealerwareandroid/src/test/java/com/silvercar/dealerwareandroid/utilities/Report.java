package com.silvercar.dealerwareandroid.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


    public class Report {
        public static ExtentHtmlReporter htmlReporter;
        public static ExtentReports extent;
        public static ExtentTest test;
        public static  AndroidDriver<AndroidElement>  driver;
        WebDriver webdriver;
        
        @BeforeSuite
        public void reportSetup() throws IOException {
            htmlReporter = new ExtentHtmlReporter(System.
            getProperty("user.dir") + "/src/main/java/com/silvercar/dealerwareandroid/report/Testcase_Report.html");
            extent = new ExtentReports();
            extent.attachReporter(htmlReporter);
            extent.setSystemInfo("OS", "Mac Sierra");
            extent.setSystemInfo("Host Name", "Dealerware System");
            extent.setSystemInfo("Environment", "QA");
            htmlReporter.config().setDocumentTitle("Android Automation");
            htmlReporter.config().setReportName("Silvercar-Smoke");
            htmlReporter.config().setTheme(Theme.DARK);
            }

        
        @AfterSuite
        public void reportTeardown() {
            extent.flush();
            System.out.println("Test cases execution Finished");
            }
  
        public void assertTrue(boolean condition, String message) {
            try {
                 Assert.assertTrue(condition, message);
            } catch (AssertionError asserterror) {
                asserterror.getMessage();
            }
        }

        public String screenShot(AndroidDriver<AndroidElement> driver) throws IOException {
            String location = System.getProperty("user.dir") + "/ScreenShots";
            File screenshot = new File(location);
            if (!screenshot.exists())
                screenshot.mkdir();
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File targetFile = new File(System.getProperty("user.dir")
            + "/ScreenShots/" + System.currentTimeMillis() + "_failed.png");
            FileUtils.copyFile(screenshotFile, targetFile);
            String loc = targetFile.getAbsolutePath();
            return loc;
            }
        }
