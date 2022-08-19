package com.ctl.it.qa.eshop.tests;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.ctl.it.qa.eshop.steps.OrderSteps;
import com.ctl.it.qa.staf.Page;
import com.ctl.it.qa.staf.xml.reader.XMLDataWriter;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class StepDefinition {


	@Steps
	OrderSteps orderSteps;

	@Before
	public void beforeEveryScenario(Scenario scenario) {	
		
	}

	@After
	public void afterEveryScenario(Scenario scenario) {
		com.ctl.it.qa.staf.Steps.isInitialized = false;
		Page.isInitialized = false;
		scenario.write("Data used for this test case:" + "\r\n");
		printData(scenario);
		if (scenario.isFailed()) {
			byte[] screenshot = ((TakesScreenshot) orderSteps.getDriver()).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png");
		}
		orderSteps.captureTestResult(scenario);
		orderSteps.getDriver().quit();
	}

	@Then("^I save \"([^\"]*)\" as \"([^\"]*)\" in data xml$")
	public void i_should_save_as_in_data_xml(String variableName, String tagName) throws Throwable {
		Page.envData.getContainer("RefreshData").setFieldValue(tagName,
				Serenity.sessionVariableCalled(variableName).toString());
		new XMLDataWriter().writeXML(Page.data,
				"C:\\OSSPROV\\EShop\\EShop_FrameWork\\EShopTests\\reports\\EShopdata.xml");
	}


	public String timestampcount(long Ftime, long Ttime) {

		long milliseconds = Ttime - Ftime;
		long diffSeconds = milliseconds / 1000 % 60;
		long diffMinutes = milliseconds / (60 * 1000) % 60;
		long diffHours = milliseconds / (60 * 60 * 1000) % 24;

		return diffHours + "Hrs:" + diffMinutes + "Mins:" + diffSeconds + "Sec";

	}


	private void printData(Scenario scenario) {
		if (Serenity.sessionVariableCalled("account_name") != null) {
			scenario.write("Account Name : " + Serenity.sessionVariableCalled("account_name").toString());
		}
		if (Serenity.sessionVariableCalled("opty_name") != null) {
			scenario.write("Opty Name : " + Serenity.sessionVariableCalled("opty_name").toString());
		}
		if (Serenity.sessionVariableCalled("order_request_id") != null) {
			scenario.write("Order Request ID : " + Serenity.sessionVariableCalled("order_request_id").toString());
		}
	}


}