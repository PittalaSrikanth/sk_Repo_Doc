package com.ctl.it.qa.eshop.steps;

import org.openqa.selenium.JavascriptExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ctl.it.qa.eshop.pages.PendingReviewOrderPage;
import com.ctl.it.qa.staf.Steps;

import net.thucydides.core.annotations.Step;

@SuppressWarnings("serial")
public class PendingReviewOrderSteps extends Steps{

	private final Logger slf4jLogger = LoggerFactory.getLogger(PendingReviewOrderSteps.class);
	
	PendingReviewOrderPage pendingrevieworderpage;
	
	
	@Step
	public void i_clicked_yes_on_review_order() {
		
		pendingrevieworderpage.shouldExist(pendingrevieworderpage,60);
		
		try {
			
			pendingrevieworderpage.selectYes.click();
			slf4jLogger.info("Clicked on to Yes");
		} catch (Exception e) {
			pendingrevieworderpage.selectYes.waitUntilVisible();
			JavascriptExecutor js = (JavascriptExecutor)getDriver();
			js.executeScript("arguments[0].scrollIntoView();", pendingrevieworderpage.selectYes);
			js.executeScript("arguments[0].click();", pendingrevieworderpage.selectYes);
		}
		slf4jLogger.info("Clicked on Yes Button on Pending Review Order Page");
		
	}

	@Step
	public void I_clicked_on_submit_revisions() {
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].click();", pendingrevieworderpage.submitRevisions);
		slf4jLogger.info("Clicked on Submit Revisions Button on Pending Review Order Page");
	}

}
