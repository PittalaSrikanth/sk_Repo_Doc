package com.ctl.it.qa.eshop.steps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ctl.it.qa.eshop.pages.LoginPage;
import com.ctl.it.qa.staf.Steps;

import net.thucydides.core.annotations.Step;

public class LoginSteps extends Steps {

	private final Logger slf4jLogger = LoggerFactory.getLogger(LoginSteps.class);
	LoginPage loginPage;

	@Step
	public void Eshop_url_OpenPage() {

		try {
			loginPage.openAt(envData.getFieldValue("url"));
			loginPage.maximize();
			slf4jLogger.info("Open Eshop application URL: " + envData.getFieldValue("url") + " successfully");
		} catch (Exception e) {
			slf4jLogger.error("Error opening Eshop application URL: " + envData.getFieldValue("url") + ": Error: "
					+ e.getMessage());
		}
	}

	@Step
	public void loginToEshop() {

		loginPage.enterCredentials("Valid");
		slf4jLogger.info("Entered credentials successfully");
	}

	@Step
	public void Sfc_url_OpenPage() {

		try {
			loginPage.openAt(envData.getFieldValue("url"));
			loginPage.maximize();
			slf4jLogger.info("Open SFC application URL: " + envData.getFieldValue("url") + " successfully");
		} catch (Exception e) {
			slf4jLogger.error("Error opening SFC application URL: " + envData.getFieldValue("url") + ": Error: "
					+ e.getMessage());
		}
	}
	

}
