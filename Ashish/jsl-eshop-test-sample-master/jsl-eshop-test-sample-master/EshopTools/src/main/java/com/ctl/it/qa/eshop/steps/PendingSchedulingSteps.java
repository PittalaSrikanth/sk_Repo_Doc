package com.ctl.it.qa.eshop.steps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ctl.it.qa.eshop.pages.PendingSchedulingPage;
import com.ctl.it.qa.staf.Steps;

import net.thucydides.core.annotations.Step;

@SuppressWarnings("serial")
public class PendingSchedulingSteps extends Steps {

	private final Logger slf4jLogger = LoggerFactory.getLogger(PendingSchedulingSteps.class);
    PendingSchedulingPage pendingschedulingpage;
	
    @Step
	public void i_change_the_date() {
		pendingschedulingpage.shouldExist(pendingschedulingpage, 60);
		pendingschedulingpage.reserveBtn.click();
		slf4jLogger.info("Clicked on reserve Date button on Pending Scheduling Page");
		waitABit(4000);
		pendingschedulingpage.selectoption.selectByIndex(2);
		slf4jLogger.info("Selected the options from dropdown on Pending Scheduling Page");
		
	}
	@Step
	public void i_click_the_continue_button() {
		
		pendingschedulingpage.continueInCalendar.click();
		slf4jLogger.info("Clicked on Continue Button on Pending Scheduling Page");
	}

}
