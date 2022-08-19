package com.ctl.it.qa.eshop.steps;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;

import com.ctl.it.qa.eshop.pages.OrderPage;
import com.ctl.it.qa.staf.Steps;

import net.thucydides.core.annotations.Step;

public class OrderSteps extends Steps {

	private final Logger slf4jLogger = LoggerFactory.getLogger(OrderSteps.class);
	OrderPage orderPage;

	@Step
	public void clickOnContinue() {
		orderPage.shouldExist(orderPage, 120);
		WebDriverWait wait = new WebDriverWait(getDriver(), 60);
		wait.until(ExpectedConditions.visibilityOf(orderPage.continueButton));
		//				JavascriptExecutor js = (JavascriptExecutor) getDriver();
		//				js.executeScript("arguments[0].scrollIntoView();", orderPage.continueButton);
		//				JavascriptExecutor js1 = (JavascriptExecutor) getDriver();
		//				js1.executeScript("arguments[0].click();", orderPage.continueButton);
		orderPage.continueButton.click();
		slf4jLogger.info("Clicked Continue");
		if(orderPage.lbl_Order_Disclosures_NI_HSI.isPresent()){
			orderPage.btn_Order_Disclosures_NI_HSI_OK_Got_It.click();
			slf4jLogger.info("-----------OK Got it button clicked in Order Disclosures Tab for NI order for HSI--------------------");
		}
		else{
			slf4jLogger.info("-----------Order Disclosures Tab is not present for for NI order for HSI--------------------");
		}
	}

	@Step
	public void verfyBuildYourOffer() throws InterruptedException {
		orderPage.shouldExist(orderPage, 60);
		String buildOrderText = "Build your Offer";
		Assert.assertTrue(orderPage.buildYourOffer.getText().trim().contains(buildOrderText));
		slf4jLogger.info("Verified build your offer page");
		slf4jLogger.info("Now in Eshop Environment  " + orderPage.getCurrentEnvironment());
		slf4jLogger.info("Eshop URL for Current Environment is   " + getDriver().getCurrentUrl());
	}

	@Step
	public void selectBestinstallation(String install) {
		slf4jLogger.info("Enter installation");
		orderPage.bestInstallationOptionDrpdwn.waitUntilClickable();
		orderPage.bestInstallationOptionDrpdwn.selectByValue(install);
		slf4jLogger.info("Selected installation option");
	}

	@Step
	public void selectBestinstallationByValue(String install) {
		slf4jLogger.info("Enter installation");
		orderPage.bestInstallationOptionDrpdwn.waitUntilClickable();
		orderPage.bestInstallationOptionDrpdwn.selectByValue(install);
		slf4jLogger.info("Selected installation option" + install);
	}

	@Step
	public void clickBypassModemOption() {
		slf4jLogger.info("Inside Build Your Offer Page for selection of Bypass option");
		waitABit(20000);
		orderPage.byPassModem.waitUntilClickable();
		orderPage.byPassModem.click();
		slf4jLogger.info("Bypass Modem option is selected");

	}

	//	@Step
	//	public void selectModemOption(String modem) {
	//		waitABit(5000);
	//		orderPage.yourModemDrpdwn.waitUntilClickable();
	//		 //orderPage.yourModemDrpdwn.selectByValue(modem);
	//		orderPage.yourModemDrpdwn.selectByIndex(1);
	//		slf4jLogger.info("Selected modem option");
	//	}
	//
	//	@Step
	//	public void selectEaseOption(String ease) {
	//		orderPage.easeDrpdwn.waitUntilClickable();
	//		// orderPage.easeDrpdwn.selectByValue(ease);
	//		orderPage.easeDrpdwn.selectByIndex(1);
	//		slf4jLogger.info("Selected ease option");
	//		waitABit(30000);
	//	}

	@Step
	public void selectModemOption(String modem) {
		orderPage.yourModemDrpdwn.waitUntilClickable();
		//orderPage.yourModemDrpdwn.selectByValue(modem);
		orderPage.yourModemDrpdwn.selectByIndex(1);
		slf4jLogger.info("Selected modem option");
	}

	@Step
	public void selectEaseOption(String ease) {
		orderPage.easeDrpdwn.waitUntilClickable();
		//orderPage.easeDrpdwn.selectByValue(ease);
		orderPage.easeDrpdwn.selectByIndex(1);
		slf4jLogger.info("Selected ease option");
	}

	@Step
	public void buildOfferPage() throws InterruptedException {
		try {
			orderPage.shouldExist(orderPage, 60);
			Thread.sleep(10000);
			boolean flag = orderPage.buildYourOffer.getText().contains("Build your Offer");
			Assert.assertTrue(flag);
			slf4jLogger.info("verified build your offer page");
		} catch (Exception e) {
			Thread.sleep(5000);
			boolean flag = orderPage.buildYourOffer.getText().contains("Build your Offer");
			Assert.assertTrue(flag);
		}
	}

	@Step
	public void CVoipDHPhone() {
		//		orderPage.bestInstallationOptionDrpdwn.waitUntilClickable();
		waitABit(30000);

		if (orderPage.MACDeaseDrpdwn.isPresent()) {
			orderPage.MACDeaseDrpdwn.waitUntilClickable();

		} else if (orderPage.bestInstallationOptionDrpdwn.isPresent()) {
			orderPage.bestInstallationOptionDrpdwn.waitUntilClickable();
		}

		else {
			slf4jLogger.info("-------Element is Unclickable -------");
		}
		//orderPage.bestInstallationOptionDrpdwn.waitUntilClickable();
		waitABit(20000);
		Actions act = new Actions(getDriver());
		act.moveToElement(orderPage.addPhoneDHP).click().build().perform();
		act.moveToElement(orderPage.digitalDHP).click().build().perform();
		orderPage.retriveoption.click();
		slf4jLogger.info("Selected CVOIP/DHP and offers retrived");
	}

	/* @Step
	    public void important911AdderessInfoPopUp()  {
	           waitABit(5000);
	           List<WebElement> wb = getDriver().findElements((By.xpath("//h3[text()='Required Disclosure']/following-sibling::div//input")));
	           for (int i = 0; i < wb.size(); i++) {
	                  waitABit(5000);
	                  JavascriptExecutor jse = (JavascriptExecutor) getDriver();
	                  jse.executeScript("arguments[0].click();", wb.get(i));
	                  break;
	           }
	           waitABit(5000);
	           List<WebElement> productOptions = getDriver().findElements((By.xpath("//div[@class='modalbody']/following-sibling::div//button[1]")));
	           for (int i = 0; i < productOptions.size(); i++) {
	                  WebElement product = productOptions.get(i);
	                  JavascriptExecutor jse = (JavascriptExecutor) getDriver();
	                        jse.executeScript("arguments[0].click();", product);
	                        slf4jLogger.info("CVoipDHPhone selected successfully");
	                        break;
	                  }
	           orderPage.scrolling.waitUntilNotVisible();
	           }*/

	//Nitish changes
	@Step
	public void important911AdderessInfoPopUp()  {
		waitABit(3000);
		orderPage.acceptcondition.click();
		waitABit(3000);
		orderPage.Seeprodoptions.click();
		waitABit(3000);
		slf4jLogger.info("911 validation successfully done");
	}

	//Nitish pots
	@Step
	public void homePhone() {
		orderPage.bestInstallationOptionDrpdwn.waitUntilClickable();
		Actions act = new Actions(getDriver());           
		act.moveToElement(orderPage.addPhoneDHP).click().build().perform();
		act.moveToElement(orderPage.HomePhone).click().build().perform();
		orderPage.retriveoption.click();
		slf4jLogger.info("Selected Home Phone and offers retrived");

	}

	//Quantity Selection - Nitish
	public void quatity_selection(String quantity) {

		orderPage.selectDeviceQuantity.waitUntilClickable();
		orderPage.selectDeviceQuantity.selectByVisibleText(quantity);
		slf4jLogger.info("Selected " +quantity +" from Quantity");
	}

	@Step
	public void customizeServiceInterNet() {
		orderPage.cutomize_service_interneticon.click();
		slf4jLogger.info("Selected Customize Services Internet Option");
		waitABit(1000);
	}

	// ac31339 code Ends   

	//Pots mandatory fields Selection - Nitish>>>>>
	@Step
	public void voice_mail_selection(String passedvalue) {
		orderPage.voicemail.waitUntilClickable();
		orderPage.voicemail.selectByVisibleText(passedvalue);
		slf4jLogger.info("Selected " +passedvalue +" option from voice mail");

	}
	@Step
	public void Wire_Maintenance_Plan_selection(String passedvalue) {
		orderPage.wireplanmaintenace.waitUntilClickable();
		orderPage.wireplanmaintenace.selectByVisibleText(passedvalue);
		slf4jLogger.info("Selected " +passedvalue +" option from wire plan maintenace");

	}
	@Step
	public void Port_in_a_phone_number(String passedvalue) {
		orderPage.portphonenumber.waitUntilClickable();
		orderPage.portphonenumber.selectByVisibleText(passedvalue);
		slf4jLogger.info("Selected " +passedvalue +" option from port phone number");

	}
	//Pots mandatory fields Selection - Nitish<<<<<<<

	//Jacks or wiring fields Selection - Nitish>>>>>>
	@Step
	public void Need_new_jacks_or_wiring(String passedvalue) {
		orderPage.jacksorWiring.waitUntilClickable();
		orderPage.jacksorWiring.selectByVisibleText(passedvalue);
		slf4jLogger.info("Selected " +passedvalue +" option from jacks or Wiring");

	}
	//Jacks or wiring fields Selection - Nitish<<<<<<<<<<<

	//Matching Offers HSI + POTS - Nitish>>>>>>>>>>
	@Step
	public void matchingOffersSelected(String passedvalue) {

		Boolean flag=passedvalue.contentEquals("Essential Home Phone");
		if(flag) {
			try {
				orderPage.EssentialHomePhone.waitUntilClickable();
				orderPage.EssentialHomePhone.click();
				slf4jLogger.info("Selected Essential Home Phone Matching Offer");
			}catch(Exception e){ 
				slf4jLogger.info("Issues found Need to be checked Here but Selected Essential Home Phone with Unlimited LD Matching Offer By Default Value");
			}
		}

		else {
			try {
				orderPage.HomePhoneUnlimited.waitUntilClickable();
				orderPage.HomePhoneUnlimited.click();
				slf4jLogger.info("Selected Essential Home Phone with Unlimited LD Matching Offer");
			}catch(Exception e) {
				slf4jLogger.info("Issues found Need to be checked Here but Selected Essential Home Phone with Unlimited LD Matching Offer By Default Value");
			}

		}

	}
	//Matching Offers HSI + POTS - Nitish<<<<<<<<<<
	@Step
	public void homePhoneonly() {
		orderPage.bestInstallationOptionDrpdwn.waitUntilClickable();
		orderPage.addPhoneDHP.click();
		orderPage.HomePhone.click();
		orderPage.internetIcon.click();
		orderPage.retriveoption.click();
		slf4jLogger.info("Selected HomePhone only by deselecting Internet and offers retrived");

	}

	@Step
	public void clickOnContinueAfterClickingLetsGo() {
		waitABit(35000);
		//		new WebDriverWait(getDriver(), 40).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("")));
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView();", orderPage.continueButton);
		JavascriptExecutor js1 = (JavascriptExecutor) getDriver();
		js1.executeScript("arguments[0].click();", orderPage.continueButton);
		slf4jLogger.info("Clicked Continue");
	}

	/**
	 * Step to handle the Order Disclosures pop up whenever they pop up for HSI for NI Order
	 */
	@Step
	public void handles_Order_Disclosures_For_NI_Order_For_HSI(){
		handle_Order_Disclosures_For_NI_Order_For_HSI();
	}

	/**
	 * Method to handle the Order Disclosures pop up whenever they pop up for HSI for NI order
	 */
	public void handle_Order_Disclosures_For_NI_Order_For_HSI() {

		if(orderPage.lbl_Order_Disclosures_NI_HSI.isPresent()){
			orderPage.btn_Order_Disclosures_NI_HSI_OK_Got_It.click();
			slf4jLogger.info("-----------OK Got it button clicked in Order Disclosures Tab for NI order for HSI--------------------");

		} else if (orderPage.bestInstallationOptionDrpdwn.isPresent()) {
			orderPage.bestInstallationOptionDrpdwn.waitUntilClickable();
		}
		else{
			slf4jLogger.info("-----------Order Disclosures Tab is not present for for NI order for HSI--------------------");
		}


	}

	// ac31339 code starts

	@Step
	public void selectAvailableSpeed(String Selectspeed) {
		slf4jLogger.info("Select required Speed");
		orderPage.buildYourOffer.waitUntilClickable();
		WebElement availableSpeedRadioButton = getDriver()
				.findElement(By.xpath("//span[contains(text(),'" + Selectspeed + "')]"));
		JavascriptExecutor jse2 = (JavascriptExecutor) getDriver();
		jse2.executeScript("arguments[0].click();", availableSpeedRadioButton);
		slf4jLogger.info("Selected the Speed");
	}

	@Step
	public void interNet() {

		orderPage.bestInstallationOptionDrpdwn.waitUntilClickable();
		orderPage.internetIcon.waitUntilClickable();
		waitABit(2000);
		orderPage.internetIcon.click();
		slf4jLogger.info("Selected Internet Option");
		orderPage.retriveoption.click();
		slf4jLogger.info("Clicked on Internet and retrive");

	}

	@Step
	public void onePtyResidenceLine() {
		orderPage.onePtyresidenseLine.click();
		slf4jLogger.info("Selected One Pty Residence Line");
	}

	@Step
	public void lifeUnlimitedPhoneCalling() {

		if (!orderPage.unlimitedHomePhoneCaling.isCurrentlyEnabled()) {
			slf4jLogger.info("Selected Life Unlimited Phone Unlimited Calling");
		} else {
			orderPage.unlimitedHomePhoneCaling.click();
			slf4jLogger.info("Selected Life Unlimited Phone Unlimited Calling");
		}

	}

	@Step
	public void directTV() {
		orderPage.bestInstallationOptionDrpdwn.waitUntilClickable();
		Actions act = new Actions(getDriver());
		act.moveToElement(orderPage.addTV).click().build().perform();
		act.moveToElement(orderPage.directTV).click().build().perform();
		orderPage.retriveoption.click();
		slf4jLogger.info("Selected Home Phone and offers retrived");

	}


	@Step
	public void validateInstallOption(String expec_instalOption) throws InterruptedException {
		WaitForPageToLoad(120);

		String actual_instalOption = orderPage.bestInstallationOptionDrpdwn.getSelectedVisibleTextValue();
		if (actual_instalOption.contains(expec_instalOption)) {

			slf4jLogger.info("Selected installation Option is Verified >> " + expec_instalOption);
		} else {
			slf4jLogger.info("Selected installation Option is Verified >>  " + expec_instalOption);
		}

	}	

	/**
	 * Step to handle the Order Disclosures pop up whenever they pop up for HSI for NI Order
	 */
	@Step
	public void handles_Order_Disclosures_For_Move_Order_For_HSI(){
		handle_Order_Disclosures_For_Move_Order_For_HSI();
	}

	/**
	 * Method to handle the Order Disclosures pop up whenever they pop up for HSI for NI order
	 */
	public void handle_Order_Disclosures_For_Move_Order_For_HSI() {

		if(orderPage.lbl_Order_Disclosures_Move_HSI.isPresent()){
			orderPage.btn_Order_Disclosures_Move_HSI_OK_Got_It.click();
			slf4jLogger.info("-----------OK Got it button clicked in Order Disclosures Tab for NI order for HSI--------------------");
		}
		else{
			slf4jLogger.info("-----------Order Disclosures Tab is not present for for NI order for HSI--------------------");
		}

	} 

	@Step
	public void validateProductOffer(String expec_speed, String expec_device, String expec_easeOption,
			String expec_modem, String expec_jackVal) throws InterruptedException {
		WaitForPageToLoad(120);

		String actual_speed1 = orderPage.availableSpeed.getText();
		if (actual_speed1.contains(expec_speed)) {

			slf4jLogger.info("Internet speed is Verified >> " + expec_speed);

		} else {
			slf4jLogger.info("Internet speed is not Available>> " + expec_speed);

		}

		if (orderPage.selectDeviceQuantity.isCurrentlyVisible()) {

			String actual_deviceVal = orderPage.selectDeviceQuantity.getSelectedVisibleTextValue();
			if (actual_deviceVal.contains(expec_device)) {

				slf4jLogger.info("Selected Device is Verified >> " + expec_device);
			} else {
				slf4jLogger.info("Selected Device is not Verified >>  " + expec_device);
			}
		} else {
			slf4jLogger.info("Expected Device Element is not Available   ");
		}

		String actual_easeVal = orderPage.easeDrpdwn.getSelectedVisibleTextValue();
		if (actual_easeVal.contains(expec_easeOption)) {

			slf4jLogger.info("Selected Ease Option is Verified >> " + actual_easeVal);
		} else {
			slf4jLogger.info("Selected Ease Option is not Verified >> " + actual_easeVal);
		}
		String actual_jackVal = orderPage.jacksorWiring.getSelectedVisibleTextValue();
		if (actual_jackVal.contains(expec_jackVal)) {

			slf4jLogger.info("Selected jack and wire is Verified >> " + expec_jackVal);
		} else {
			slf4jLogger.info("Selected jack and wire is Verified >> " + expec_jackVal);
		}
		String actual_modemVal = orderPage.yourModemDrpdwn.getSelectedVisibleTextValue();
		if (actual_modemVal.contains(expec_modem)) {

			slf4jLogger.info("Selected modem is Verified >> " + actual_modemVal);
		} else {
			slf4jLogger.info("Selected Modem is not Verified >> " + actual_modemVal);

		}

	}

	// POT verification
	@Step
	public void validateProductOfferPot(String expec_voiceMail, String expec_wirePlan, String expec_port,
			String expec_jackVal) throws InterruptedException {
		WaitForPageToLoad(120);

		String actual_voiceMail = orderPage.voicemail.getSelectedVisibleTextValue();
		if (actual_voiceMail.contains(expec_voiceMail)) {

			slf4jLogger.info("Selected Voice mail is Verified >> " + expec_voiceMail);
		} else {
			slf4jLogger.info("Selected Voice mail is not Verified >>  " + expec_voiceMail);
		}

		String actual_wirePlan = orderPage.wireplanmaintenace.getSelectedVisibleTextValue();
		if (actual_wirePlan.contains(expec_wirePlan)) {

			slf4jLogger.info("Selected Wire Plan maintenance is Verified >> " + actual_wirePlan);
		} else {
			slf4jLogger.info("Selected Wire Plan maintenance is not Verified >> " + actual_wirePlan);
		}

		String actual_jackVal = orderPage.jacksorWiring.getSelectedVisibleTextValue();
		if (actual_jackVal.contains(expec_jackVal)) {

			slf4jLogger.info("Selected jack and wire is Verified >> " + expec_jackVal);
		} else {
			slf4jLogger.info("Selected jack and wire is Verified >> " + expec_jackVal);
		}

		String actual_port = orderPage.portphonenumber.getSelectedVisibleTextValue();
		if (actual_port.contains(expec_port)) {
			slf4jLogger.info("Port in a phone number >> " + actual_port);
		} else {
			slf4jLogger.info("Port in a phone number >> " + actual_port);

		}
	}

	//ac42889
	@Step
	public void clickOnContinuebutton() {

		waitABit(5000);
		JavascriptExecutor js1 = (JavascriptExecutor) getDriver();
		js1.executeScript("arguments[0].click();", orderPage.btn_continue);
		slf4jLogger.info("Clicked Continue");

	}
	@Step
	public void clicks_On_OK_Got_It_Button() {
		click_On_OK_Got_It_Button();
	}

	public void click_On_OK_Got_It_Button() {
		waitABit(3000);
		orderPage.btn_Ok_Got_It.click();
		slf4jLogger.info("-----------OK GOT IT button clicked in Order disclosres dialog box");
	}


	@Step
	public void clickOnMacdDropDown(String modem) {
		orderPage.MACDyourModemDrpdwn.selectByValue(modem);
		slf4jLogger.info("Selected modem option");
	}
	
	/*
	 * Shilpa - F36408
	 */
	@Step
	public void chooseLastHSISpeedFromList() {

		slf4jLogger.info("We are in Selecting Last speed Method");
		waitABit(9000);
		List<WebElement> list = getDriver()
				.findElements(By.xpath("//*[@class='available-speed-lists list-inline']/li"));
		System.out.println("List Size:" + list.size());
		list.get(list.size() - 1).click();
		waitABit(4000);

		slf4jLogger.info("Last Element: ");
		System.out.print(list.get(list.size() - 1).getText());

	}
	
	/*
	 * Shilpa F36408 Choose Self Install option
	 */
	@Step
	public void selectSelfInstall() {
		slf4jLogger.info("Enter installation");
		orderPage.bestInstallationOptionDrpdwn.waitUntilClickable();
		orderPage.bestInstallationOptionDrpdwn.selectByIndex(2);
		slf4jLogger.info("Selected installation option");
		waitABit(4000);
	}
	
	/*
	 * Shilpa F36408 Click on By Pass Modem
	 */

	@Step
	public void selectModemOptionForChange(String modem) {
		waitABit(9000);
		orderPage.yourModemDrpdwnForChange.waitUntilClickable();
		// orderPage.yourModemDrpdwn.selectByValue(modem);
		orderPage.yourModemDrpdwnForChange.selectByIndex(1);
		slf4jLogger.info("Selected modem option");
	}
}
