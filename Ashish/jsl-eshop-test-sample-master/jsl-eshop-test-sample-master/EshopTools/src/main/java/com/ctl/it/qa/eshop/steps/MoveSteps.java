package com.ctl.it.qa.eshop.steps;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.ctl.it.qa.eshop.pages.AccountInformationPage;
import com.ctl.it.qa.eshop.pages.CustomizeServicePage;
import com.ctl.it.qa.eshop.pages.MovePage;
import com.ctl.it.qa.eshop.pages.OrderPage;
import com.ctl.it.qa.eshop.pages.SchedulingPage;
import com.ctl.it.qa.staf.Steps;

import junit.framework.Assert;
import net.serenitybdd.core.annotations.findby.By;
import net.thucydides.core.annotations.Step;

public class MoveSteps extends Steps {

	private final Logger slf4jLogger = LoggerFactory.getLogger(MoveSteps.class);
	OrderPage orderPage;
	CustomizeServicePage customizeServicePage;
	SchedulingPage schedulingPage;
	AccountInformationPage accountInformationPage;
	MovePage movePage;

	@Step
	public void clickOnContinue() throws InterruptedException {
		waitABit(20000);
		try {
			orderPage.shouldExist(orderPage, 60);
			orderPage.continueButton.click();
			slf4jLogger.info("Clicked Continue");
			waitABit(5000);
			if(orderPage.OrderdisclosuresAccept.isCurrentlyVisible()) {
				orderPage.OrderdisclosuresAccept.click();
				slf4jLogger.info("Clicked on OK, Got it on Order Discolosures pop up");
			}
			
		} catch (Exception e) {
			slf4jLogger.info("Catch starts");
			JavascriptExecutor js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].scrollIntoView();", orderPage.continueButton);
			orderPage.continueButton.click();
			slf4jLogger.info("Clicked Continue");
			
		}
	}

	@Step
	public void clickOnAgainContiune() {
		customizeServicePage.shouldExist(customizeServicePage, 60);
		customizeServicePage.shouldBeVisible(customizeServicePage.customizeServicePage);
		customizeServicePage.continueAgainButton.click();
		slf4jLogger.info("Clicked on Continue Button in Customer Service Page");
		waitABit(20000);
	}

	public void clickOnContinueOnMoveOrderPage() {

		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].click();", schedulingPage.continueInCalendar);
		slf4jLogger.info("Clicked on continue calendar button");
		
		waitABit(5000);
		if(orderPage.OrderdisclosuresAccept.isCurrentlyVisible()) {
			orderPage.OrderdisclosuresAccept.click();
			slf4jLogger.info("Clicked on OK, Got it on Order Discolosures pop up");
		}
	}

	@Step
	public void clickAccountInfoContinue() throws InterruptedException {
	//Nitish added
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].click();", accountInformationPage.clickContinueAccInfo);
		slf4jLogger.info("clicked on continue button in account information page");
	}

	@Step
	public void removeHomePhone(String deviceName,String removalReason) throws InterruptedException {
		WaitForPageToLoad(60);
		movePage.icon_addphone.click();
		waitABit(1000); 
		if ((deviceName.contains("Digital"))|| (deviceName.contains("DHP")) ) {
			movePage.menu_dhp.click();
		} else if (deviceName.contains("Home")) {
			movePage.menu_homephone.click();
			// getting one continue button
		} else if (deviceName.contains("No")) {
			movePage.menu_nophone.click();
		}else if (deviceName.contains("HSI")) {
			movePage.icon_internet.click();
		}
		
		waitABit(2000);
		selectRemovalReason(removalReason);
		slf4jLogger.info("clicked on continue button in account information page");
	}

	public void selectRemovalReason(String option_Reason) {

		try {
			movePage.dd_removal_reason.selectByIndex(2);
			waitABit(1000);
			movePage.btn_continue_removal_product.click();
			waitABit(1000);
			if (orderPage.acceptcondition.isCurrentlyVisible()) {
				orderPage.acceptcondition.click();
				waitABit(1000);
				orderPage.Seeprodoptions.click();
				waitABit(3000);

			} else if (movePage.btn_continue_removal_product.isCurrentlyVisible()) {
				movePage.btn_continue_removal_product.click();

			} else {
				System.out.println("NO 2nd Continue Button is Available");
			}
			waitABit(2000);
			orderPage.retriveoption.click();
			waitABit(10000);
		} catch (Exception e) {
			slf4jLogger.info("Removal Reason dropdown error " + e);
		}

	}

	@Step
	public void addCallReferal() {
		movePage.btn_add_call_referal.click();
		waitABit(5000);
		movePage.radio_call_referal.click();
		//movePage.btn_continue_removal_product.click();
		movePage.btn_save_referal.click();
	}

	@Step
	public void ExpandTN() {
		movePage.ExpanTN.click();
		waitABit(5000);
		
	}
	@Step
	public void ClickMoreTN() {
		movePage.btn_MoreTN.click();
		waitABit(5000);
		slf4jLogger.info("clicked on More Tn Button");
		
	}
	@Step
	public void ClickMoreOption_TN() {
		movePage.btn_MoreOption.click();
		waitABit(5000);
		slf4jLogger.info("clicked on More Option Button");
		
	}
	@Step
	public void ManualRequestRadioBtn(String TNoption) {
		
		movePage.TNqueryOption.click();
		//movePage.radio_ManualRequest.click();
		waitABit(5000);
		slf4jLogger.info("clicked on "+TNoption+"Radio Button");
		
	}
	@Step
	public void Select_NPA_NXX_Line(String npa,String nxx,String line) {
		Select sel1=new Select(movePage.dd_NPA);
		sel1.selectByVisibleText(npa);
		waitABit(2000);
		Select sel2=new Select(movePage.dd_NXX);
		sel2.selectByVisibleText(nxx);
		movePage.Tbx_line.click();
		movePage.Tbx_line.sendKeys(line);
		
		slf4jLogger.info("inserted NPA NXX and line number");
		
	}
	@Step
	public void Click_Check_TN() {
		movePage.btn_CheckTN.click();
		waitABit(5000);
		slf4jLogger.info("clicked on Check Tn Button");
		
	}
	
	@Step
	public void Click_Chat_with_TN_assignment() {
		String winHandleBefore = getDriver().getWindowHandle();

		movePage.lnk_chat.click();

		// Switch to new window opened
		for(String winHandle : getDriver().getWindowHandles()){
			getDriver().switchTo().window(winHandle);
			System.out.println(getDriver().getCurrentUrl());
		}
		
		waitABit(5000);
		slf4jLogger.info("clicked on Chat with TN assignment link");
		
		
	}
	@Step
	public void Chat_link_Page() {
		waitABit(10000);
		List<WebElement> Links=getDriver().findElements(By.xpath("//tr[@style='background-color:#84BD00;']/td/div"));
		for(int i=1;i<Links.size();i++)
		{
			System.out.println(Links.get(i).getAttribute("innerText"));
		}
	}
		@Step
		public void Click_Chat_Now() {
			String winHandleBefore = getDriver().getWindowHandle();
			movePage.lnk_chat_NOW.click();
			for(String winHandle : getDriver().getWindowHandles()){
				getDriver().switchTo().window(winHandle);
				}
			waitABit(5000);
			System.out.println(movePage.Contact_Us.getAttribute("innerText"));
			movePage.close_chat.click();
			waitABit(5000);
			slf4jLogger.info("clicked on chat Now link");
				
		
	}
	
		@Step
		public void Validate_TN_Confirmation_msg(String Msg) {
			waitABit(5000);
			String Message=movePage.TN_MSG.getText();
			System.out.println(movePage.TN_MSG.getAttribute("innerText"));
			Assert.assertEquals(Msg, Message);
		}
		@Step
		public void Click_Select_TN() {
			waitABit(1000);
			movePage.btn_SelectTN.click();
		}
	
		@Step
		public void TN_validation(String TN) {
			String[] TN_Num=movePage.lbl_TN.getText().split(" ");
			String tn=TN_Num[0];
			System.out.println("TN: "+tn);
			Assert.assertEquals(TN, tn);
		}
		
		@Step
		public void CNUM_Response(String msg) {
			String Message=movePage.lbl_CNUM_Response.getText();
			System.out.println(Message);
			Assert.assertEquals(msg, Message);
		}
		@Step
		public void CNUM_AgeTN_Response(String msg) {
			String Message=movePage.lbl_CNUM_ageTN_Response.getText();
			System.out.println(Message);
			Assert.assertEquals(msg, Message);
		}
		
		@Step
		public void selectAssessCharge(String value){
			waitABit(1000);
			Select sc=new Select(movePage.option_NoWaiveCharge);
			sc.selectByValue(value);
		}
	
}
