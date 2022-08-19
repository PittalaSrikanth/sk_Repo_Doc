package com.ctl.it.qa.eshop.steps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ctl.it.qa.eshop.pages.PendingOrderConfirmationPage;
import com.ctl.it.qa.staf.Steps;

import net.thucydides.core.annotations.Step;

@SuppressWarnings("serial")
public class PendingOrderConfirmationSteps extends Steps {
	
	
	PendingOrderConfirmationPage pendingorderconfirmationpage;

	private final Logger slf4jLogger = LoggerFactory.getLogger(PendingOrderConfirmationSteps.class);
	
	@Step
	public void i_got_confirmation_of_the_order_revisons() {
		pendingorderconfirmationpage.shouldExist(pendingorderconfirmationpage,60);
		slf4jLogger.info("The review order confirmation successful");
	}
	
	
}
