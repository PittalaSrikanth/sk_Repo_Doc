package com.ctl.it.qa.eshop.steps;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ctl.it.qa.eshop.pages.MakePaymentPage;
import com.ctl.it.qa.staf.Steps;

import net.thucydides.core.annotations.Step;

public class MakePaymentSteps extends Steps {

	private final Logger slf4jLogger = LoggerFactory.getLogger(MakePaymentSteps.class);
	MakePaymentPage makePaymentPage;

	@Step
	public void verifyMakePaymentPage() {
		makePaymentPage.shouldExist(makePaymentPage,60);
		boolean flag = makePaymentPage.makePaymentPageText.isDisplayed();
		slf4jLogger.info("flag value =" + flag);
		Assert.assertTrue(flag);
		slf4jLogger.info("Verified payment page");
	}

	@Step
	public void fillCardDetails(String card, String zipcode) {
		getDriver().switchTo().frame(0);
		slf4jLogger.info("frame switched");
		makePaymentPage.cardNumBox.sendKeys(card);
		makePaymentPage.expiryMonthdrpDwn.selectByIndex(4);
		makePaymentPage.expiryYearDrpdwn.selectByIndex(4);
		makePaymentPage.zipCodeBox.clear();
		makePaymentPage.zipCodeBox.sendKeys(zipcode);
		makePaymentPage.tncCheckBox.click();
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView();", makePaymentPage.nextButton);		
		makePaymentPage.nextButton.click();
		slf4jLogger.info("Filled all the card details");
	}

	@Step
	public void submitVerfiyInfo() {
		makePaymentPage.submitBtn.click();
		slf4jLogger.info("Clicked on to submit button");
		getDriver().switchTo().defaultContent();
		slf4jLogger.info("Out of Frame : Moved default");
	}

}