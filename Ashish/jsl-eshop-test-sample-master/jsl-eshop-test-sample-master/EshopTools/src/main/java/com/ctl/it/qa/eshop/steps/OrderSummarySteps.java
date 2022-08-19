package com.ctl.it.qa.eshop.steps;

import java.sql.SQLException;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ctl.it.qa.eshop.common.utils.DatabaseUtils;
import com.ctl.it.qa.eshop.pages.OrderSummaryPage;
import com.ctl.it.qa.staf.Steps;

import net.thucydides.core.annotations.Step;

import net.serenitybdd.core.annotations.findby.By;

public class OrderSummarySteps extends Steps {

	private final Logger slf4jLogger = LoggerFactory.getLogger(OrderSummarySteps.class);
	OrderSummaryPage orderSummaryPage;

	public static String accountnum;
	public static String ordernum;

	public void clickYes() throws InterruptedException {
		try {
			slf4jLogger.info("Inside Order Summary Page method");
			orderSummaryPage.shouldExist(orderSummaryPage, 100);
			// orderSummaryPage.btn_View_RCCs.click();
			waitABit(20000);
			orderSummaryPage.btn_Acknowledge.click();
			slf4jLogger.info("Clicked Acknowledge button");

			// orderSummaryPage.selectYes.waitUntilVisible();
			// JavascriptExecutor js = (JavascriptExecutor) getDriver();
			/*
			 * js.executeScript("arguments[0].scrollIntoView();",
			 * orderSummaryPage.selectYes);
			 * js.executeScript("arguments[0].click();",
			 * orderSummaryPage.selectYes); waitABit(1500);
			 */
			// js.executeScript("arguments[0].click();",
			// orderSummaryPage.btn_Acknowledge);
		} catch (Exception e) {
			orderSummaryPage.btn_Acknowledge.waitUntilVisible();
			JavascriptExecutor js = (JavascriptExecutor) getDriver();
			/*
			 * js.executeScript("arguments[0].scrollIntoView();",
			 * orderSummaryPage.btn_View_RCCs);
			 * js.executeScript("arguments[0].click();",
			 * orderSummaryPage.btn_View_RCCs);
			 * orderSummaryPage.selectYes.waitUntilVisible();
			 * js.executeScript("arguments[0].scrollIntoView();",
			 * orderSummaryPage.selectYes);
			 * js.executeScript("arguments[0].click();",
			 * orderSummaryPage.selectYes); waitABit(1000);
			 */js.executeScript("arguments[0].click();", orderSummaryPage.btn_Acknowledge);
		}

		// try {
		/*
		 * orderSummaryPage.shouldExist(orderSummaryPage,60);
		 * 
		 * System.out.println("Reachedd Hereeeeeeeeeeeeeee >>>>>>>>>>>>>>>>>>>"
		 * ); orderSummaryPage.btn_View_RCCs.click();
		 * 
		 * orderSummaryPage.btn_View_RCCs.waitUntilVisible(); JavascriptExecutor
		 * js = (JavascriptExecutor) getDriver();
		 * js.executeScript("arguments[0].scrollIntoView();",
		 * orderSummaryPage.btn_View_RCCs);
		 * js.executeScript("arguments[0].click();",
		 * orderSummaryPage.btn_View_RCCs); //waitABit(10000);
		 * orderSummaryPage.selectYes.waitUntilVisible();
		 * js.executeScript("arguments[0].scrollIntoView();",
		 * orderSummaryPage.selectYes);
		 * js.executeScript("arguments[0].click();",
		 * orderSummaryPage.selectYes); waitABit(1500);
		 * js.executeScript("arguments[0].click();",
		 * orderSummaryPage.btn_Acknowledge);
		 * slf4jLogger.info("Clicked on Yes and Acknowledge Button");
		 */

		// orderSummaryPage.selectYes.click();
		// orderSummaryPage.btn_Acknowledge.click();
		// slf4jLogger.info("Clicked on Yes and Acknowledge Button");
		// } catch (Exception e) {
		/*
		 * orderSummaryPage.btn_View_RCCs.waitUntilVisible(); JavascriptExecutor
		 * js = (JavascriptExecutor) getDriver();
		 * js.executeScript("arguments[0].scrollIntoView();",
		 * orderSummaryPage.btn_View_RCCs);
		 * js.executeScript("arguments[0].click();",
		 * orderSummaryPage.btn_View_RCCs); //waitABit(10000);
		 * orderSummaryPage.selectYes.waitUntilVisible();
		 * js.executeScript("arguments[0].scrollIntoView();",
		 * orderSummaryPage.selectYes);
		 * js.executeScript("arguments[0].click();",
		 * orderSummaryPage.selectYes);
		 * js.executeScript("arguments[0].click();",
		 * orderSummaryPage.btn_Acknowledge);
		 * slf4jLogger.info("Clicked on Yes and Acknowledge Button");
		 */
		// }

	}

	public void clickSubmitOrder() throws InterruptedException {

		orderSummaryPage.shouldExist(orderSummaryPage, 60);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].click();", orderSummaryPage.submitOrder);
		slf4jLogger.info("clicked on to submit order");
		/*
		 * try { orderSummaryPage.shouldExist(orderSummaryPage, 60);
		 * slf4jLogger.info("last yes button click1");
		 * orderSummaryPage.submitOrder.click();
		 * slf4jLogger.info("clicked on to submit order"); }catch (Exception e)
		 * { orderSummaryPage.shouldExist(orderSummaryPage, 60);
		 * Thread.sleep(2000); orderSummaryPage.submitOrder.click(); }
		 */
	}

	public void orderSummaryPageVerification() {
		orderSummaryPage.shouldExist(orderSummaryPage, 60);
		orderSummaryPage.shouldBeVisible(orderSummaryPage.orderSubmittedverification);
		String orderSubmitted = "Order Submitted Successfully";
		Assert.assertTrue(orderSubmitted.contains(orderSummaryPage.orderSubmittedverification.getText().trim()));
		slf4jLogger.info("Verified the order submitted successfully or not");
	}

	public void enterTechnicianRemarks(String techRemarks) {
		orderSummaryPage.remarks.sendKeys(techRemarks);
		slf4jLogger.info("Entered techincal remarks");
	}

	public void checkRemarks() {
		String remark = "Technical remarks added";
		String remarksCheck = orderSummaryPage.notes.getText();
		slf4jLogger.info("remarks " + remarksCheck);

		if (remark.equals(remarksCheck)) {

			Assert.assertTrue(remark.equals(remarksCheck));
		}
		slf4jLogger.info("verified techinican remarks is dipslayed correctly or not");
	}

	public void getAccountNumber() {
		orderSummaryPage.shouldBeVisible(orderSummaryPage.orderNumberText);
		// Nitish
		String fullOrdernum = orderSummaryPage.orderNumberText.getText();
		int lastindexor = fullOrdernum.toCharArray().length;
		ordernum = fullOrdernum.substring(13, lastindexor);
		String fullAccountnum = orderSummaryPage.accountNumberText.getText();
		int lastindexac = fullAccountnum.toCharArray().length;
		accountnum = fullAccountnum.substring(15, lastindexac);
		slf4jLogger.info("order number = " + fullOrdernum);
		slf4jLogger.info("account number = " + fullAccountnum);
		slf4jLogger.info("Cleaned order number = " + ordernum);
		slf4jLogger.info("Cleaned account number = " + accountnum);
	}

	public void validateDueDate(String address) {
		boolean flag = orderSummaryPage.serviceAddress.getText().contains(address.split(",")[0].trim());
		Assert.assertTrue(flag);
		slf4jLogger.info("service address validation =" + orderSummaryPage.serviceAddress.getText());
		flag = orderSummaryPage.activationDate.getText().contains(SchedulingSteps.actualDueDate.split(",")[0].trim());
		Assert.assertTrue(flag);
		slf4jLogger.info("due date validation =" + orderSummaryPage.activationDate.getText());
	}

	// Nitish
	public void i_clicked_on_new_order() {

		orderSummaryPage.neworder.waitUntilClickable();
		waitABit(30000);
		orderSummaryPage.neworder.click();
		slf4jLogger.info("Clicked on Start New Order button");
		waitABit(7000);

	}

	public void i_enter_existing_account_number(String accountnum) {

		orderSummaryPage.accnumrbn.waitUntilClickable();
		waitABit(3000);
		orderSummaryPage.accnumrbn.click();
		orderSummaryPage.existsaaccnumr.sendKeys(accountnum);
		slf4jLogger.info("Entered existing account number:-  " + accountnum);

	}

	public void enter_the_special_remark_in_Additional_Order_Remarks_field(String datapassed) {

		orderSummaryPage.Additional_Order_Remarks.waitUntilClickable();
		orderSummaryPage.Additional_Order_Remarks.sendKeys(datapassed);
		slf4jLogger.info("Entered special remark in Additional Order Remarks field:-  " + datapassed);
	}

	/**
	 * Step to validate the ensemble details for paperless biling order
	 * 
	 * @param bpNoOfCopies
	 * @param bpSeqNo
	 * @param databaseName
	 * @throws SQLException
	 */
	@Step
	public void validates_Ensemble_Details_For_Paperless_Billing(String bpNoOfCopies, String bpSeqNo,
			String databaseName) throws SQLException {
		boolean b = validate_Ensemble_Details_For_Paperless_Billing(bpNoOfCopies, bpSeqNo, databaseName);
		Assert.assertTrue("Ensemble details incorrect for paperless Billing!!!", b);
	}

	/**
	 * Method to validate the ensemble details for paperless biling order
	 * 
	 * @param bpNoOfCopies
	 * @param bpSeqNo
	 * @param databaseName
	 * @throws SQLException
	 */
	public boolean validate_Ensemble_Details_For_Paperless_Billing(String bpNoOfCopies, String bpSeqNo,
			String databaseName) throws SQLException {
		DatabaseUtils dbUtils = new DatabaseUtils();
		int actualbpNoOfCopies = dbUtils.fetch_Paperless_Billing_Details(databaseName, bpNoOfCopies, bpSeqNo);
		String zero = bpNoOfCopies.substring(0, 1);
		String nullValue = bpNoOfCopies.substring(1, bpNoOfCopies.length());
		boolean b = actualbpNoOfCopies == Integer.parseInt(zero) || actualbpNoOfCopies == Integer.parseInt(nullValue);
		return b;
	}

	/**
	 * Step to validate the ensemble email details for paperless billing order
	 * for a particular account number
	 * 
	 * @param emailAddress
	 * @param databaseName
	 * @throws SQLException
	 */
	@Step
	public void validates_Ensemble_Email_Details_For_Paperless_Billing(String emailAddress, String databaseName)
			throws SQLException {
		boolean b = validate_Ensemble_Email_Details_For_Paperless_Billing(emailAddress, databaseName);
		Assert.assertTrue("Ensemble EMAIL details incorrect for paperless Billing!!!", b);
	}

	/**
	 * Method to validate the ensemble email details for paperless billing order
	 * for a particular account number
	 * 
	 * @param emailAddress
	 * @param databaseName
	 * @throws SQLException
	 */
	public boolean validate_Ensemble_Email_Details_For_Paperless_Billing(String emailAddress, String databaseName)
			throws SQLException {
		DatabaseUtils dbUtils = new DatabaseUtils();
		String actualEmailAddressFromEnsemble = dbUtils.fetch_Paperless_Billing_Email_Details(databaseName);
		boolean b = actualEmailAddressFromEnsemble.equalsIgnoreCase(emailAddress);
		return b;
	}

	// Anuradha
	public void i_clicked_on_back_button() {
		waitABit(1000);

		if (orderSummaryPage.back_btn.isCurrentlyVisible()) {

			orderSummaryPage.back_btn.click();

			waitABit(3000);
		} else {

			slf4jLogger.info("Back button is not visible");
		}

	}

	public void i_clicked_on_update_Account_button() {

		orderSummaryPage.updateaccnt.click();
		slf4jLogger.info("Clicked on update account button in Account info page");

	}

	public void i_select_mail_my_bill() {
		orderSummaryPage.mailmybill.click();
		slf4jLogger.info("Clicked on update account button in Account info page");
	}

	public void i_click_on_change_billing_address() {
		orderSummaryPage.updateBllngaddrs.click();

	}

	public void i_click_on_update_billing_address(String streetaddress, String city, String zipcode) {
		// orderSummaryPage.billingadrs.sendKeys();
		// orderSummaryPage.billingadrs.selectByValue("Street Address");
		orderSummaryPage.streetadrsbox.clear();
		waitABit(3000);
		orderSummaryPage.streetadrsbox.sendKeys(streetaddress);
		orderSummaryPage.txtbx_city.clear();
		orderSummaryPage.txtbx_city.sendKeys(city);
		orderSummaryPage.selectstate.selectByVisibleText("Arizona");
		orderSummaryPage.txtbx_zipcd.clear();
		orderSummaryPage.txtbx_zipcd.sendKeys(zipcode);
		orderSummaryPage.validatebtn.click();
		orderSummaryPage.addrs_billing.click();
	}

	public void verified_reentrant_of_FN_LN_SMS(String firstname, String lastname, String SMS) {
		orderSummaryPage.txtbx_FN.clear();
		orderSummaryPage.txtbx_FN.sendKeys(firstname);
		orderSummaryPage.txtbx_LN.clear();
		orderSummaryPage.txtbx_LN.sendKeys(lastname);
		orderSummaryPage.txtbx_SMS.clear();
		orderSummaryPage.txtbx_SMS.sendKeys(SMS);

	}

	public void verified_marketing_preferences() {

		orderSummaryPage.nodirectmail.click();
		orderSummaryPage.noemail.click();
		orderSummaryPage.notelemrktng.click();
	}

	// Anuradha

	/*
	 * Shilpa MMP7824 - F33405 Verify the display of both Primary contact number
	 * and order level CBR number in Account information page
	 */
	public void validatePhoneNumber(String contactNumber) {
		orderSummaryPage.shouldExist(orderSummaryPage, 60);
		orderSummaryPage.shouldBeVisible(orderSummaryPage.orderSubmittedverification);
		slf4jLogger.info("Order Level CBR =" + orderSummaryPage.orderLevelCRB.getText().replaceAll("[\\s\\-()]", ""));
		boolean flag = orderSummaryPage.orderLevelCRB.getText().replaceAll("[\\s\\-()]", "").contains(contactNumber);
		// Assert.assertTrue(flag);
		if (flag)
			slf4jLogger.info("Phone Number Matched with Contact Number edited in scheduling page");
		else
			slf4jLogger.info("Phone Number is not same as edited number in scheduling page");
	}

	/*
	 * Ac43057- Validation for Auth user
	 * 
	 */

	public boolean validationForAuthUSer(String authname) {
		orderSummaryPage.shouldExist(orderSummaryPage, 60);
		// String authName = orderSummaryPage.authName.getText();

		String S1 = "//label[contains(text(),'Authorized Parties')]//parent::div/child::p[contains(text(),'";
		String S2 = "')]";
		boolean b = false;
		if (getDriver().findElements(By.xpath(S1 + authname + S2)).size() == 0) {
			b = true;
		}
		slf4jLogger.info("Authorized User name added ---------   " + b);
		return b;
	}
	
	/*
	 * Shilpa - F37432
	 */
	public void validateAuthorizedPartyInOrderSummary(String firstName1, String lastName1, String firstName2, String lastName2 ){
		boolean flag=false;
		orderSummaryPage.shouldExist(orderSummaryPage,60);
		//orderSummaryPage.shouldBeVisible(orderSummaryPage.orderSubmittedverification);
		slf4jLogger.info("Authorized Party Details  ="+ orderSummaryPage.authorizedParty.getText().replaceAll("[\\s\\-()]",""));
		String OrderSummaryPageValue =orderSummaryPage.authorizedParty.getText().replaceAll("[\\s\\-()]","");
		if(OrderSummaryPageValue.contains(firstName1)&&OrderSummaryPageValue.contains(firstName2)&&OrderSummaryPageValue.contains(lastName1)&&OrderSummaryPageValue.contains(lastName2))
			flag=true;
		//Assert.assertTrue(flag);		
		if(flag)
			slf4jLogger.info("Authorised Party Data Match");
		else
			slf4jLogger.info("Authorized Party Data Not Matched");
	}
}
