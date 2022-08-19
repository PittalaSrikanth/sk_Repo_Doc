package com.ctl.it.qa.eshop.tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.ctl.it.qa.staf.Environment;
import com.ctl.it.qa.staf.HtmlReport;
import com.ctl.it.qa.staf.STAFEnvironment;
import com.ctl.it.qa.staf.Steps;
import com.ctl.it.qa.staf.TestEnvironment;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

//E2E//ITV1
@TestEnvironment(Environment.TEST1)
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features", plugin = { "pretty", "json:target/Reports/EShopCucumberReport.json" ,"html:target/Reports/EShopHTMLReport" },

dryRun= false , tags = { "@EShopSanity" }) 

// A few other tags: @EshopTestScripts @EShopSanity @EShopFunctional @eshopcentral

public class RunCukesTest {

	@BeforeClass
	public static void setEnvironment() {
		STAFEnvironment.registerEnvironment(RunCukesTest.class);
		Steps.initialize("EShopLogin.xml");
	}

	@AfterClass
	public static void test() throws Exception {
		HtmlReport.generate();

	}

}
