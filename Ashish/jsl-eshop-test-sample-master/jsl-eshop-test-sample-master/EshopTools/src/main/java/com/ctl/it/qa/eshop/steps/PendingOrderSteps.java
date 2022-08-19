package com.ctl.it.qa.eshop.steps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ctl.it.qa.eshop.pages.PendingOrderPage;
import com.ctl.it.qa.staf.Steps;

import net.thucydides.core.annotations.Step;

@SuppressWarnings("serial")
public class PendingOrderSteps extends Steps{

	private final Logger slf4jLogger = LoggerFactory.getLogger(PendingOrderSteps.class);
	PendingOrderPage pendingorderpage;
	
	@Step
	public void i_click_on_scheduling_button() {
		
		pendingorderpage.shouldExist(pendingorderpage, 60);
		pendingorderpage.scheduling.click();
		slf4jLogger.info("Clicked Scheduling Button on Pending Order Page");
	}

	
	@Step
	public void i_click_on_otheractions_button() {
		pendingorderpage.shouldExist(pendingorderpage, 60);
		pendingorderpage.other_actions.click();
		slf4jLogger.info("Clicked other actions on Pending Order Page");
	}


	@Step
	public void i_click_on_cancel_button() {
		pendingorderpage.cancel_order.click();
		slf4jLogger.info("Clicked cancel order on Pending Order Page");	
	}


	@Step
	public void confirm_cancel() {
		waitABit(15000);
		pendingorderpage.cancel_reason.selectByIndex(10);
		slf4jLogger.info("Selected the reason for cancel order");	
		waitABit(5000);
		pendingorderpage.continue_cancel_order.click();
		waitABit(5000);
		pendingorderpage.cancel_order_button.click();
		slf4jLogger.info("cancelation of order confirmed");	
		
	}
	

	
}