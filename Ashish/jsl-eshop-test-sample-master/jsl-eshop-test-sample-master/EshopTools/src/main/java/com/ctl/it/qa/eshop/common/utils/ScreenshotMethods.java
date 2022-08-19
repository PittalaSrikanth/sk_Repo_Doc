package com.ctl.it.qa.eshop.common.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

import cucumber.api.Scenario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ScreenshotMethods extends GlobalVariables {

	private final static Logger slf4jLogger = LoggerFactory.getLogger(ScreenshotMethods.class);

	public void screenCapture(Scenario scenario) {


		String actualTest = this.getClass().getName() + "." + scenario.getName();
		try {

			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			FileUtils.copyFile(scrFile, new File("./ScreenShots/" + actualTest + ".jpg"));

			try {
				byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				scenario.embed(screenshot, "image/png");

			} catch (WebDriverException wde) {
				slf4jLogger.info(wde.getMessage());
			} catch (ClassCastException cce) {
				cce.printStackTrace();
			}

			slf4jLogger.info("Screenshot Taken");

		} catch (IOException e) {
			slf4jLogger.info("Failed to capture screenshot: " + e.getMessage());
		}
	}
}
