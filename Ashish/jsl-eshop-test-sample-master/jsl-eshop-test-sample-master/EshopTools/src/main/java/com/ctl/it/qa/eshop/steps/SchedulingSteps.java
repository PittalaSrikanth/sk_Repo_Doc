package com.ctl.it.qa.eshop.steps;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ctl.it.qa.eshop.pages.SchedulingPage;
import com.ctl.it.qa.staf.Steps;

import net.serenitybdd.core.annotations.findby.By;
import net.thucydides.core.annotations.Step;

public class SchedulingSteps extends Steps {

	private final Logger slf4jLogger = LoggerFactory.getLogger(SchedulingSteps.class);

	SchedulingPage schedulingPage;
	public static String actualDueDate;

	public void dueDateSelection() {

		schedulingPage.datePickerD.click();

		schedulingPage.assignToDate.click();
		slf4jLogger.info("Clicked on assign date");

	}

	/*
	 * 
	 * Shilpa Order disclosure for disconnect added
	 */
	public void clickOnContinue() {		
		schedulingPage.shouldExist(schedulingPage, 80);
		schedulingPage.continueInCalendar.click();
		slf4jLogger.info("Clicked on continue calendar button");
		waitABit(10000);
		if(schedulingPage.OrderdisclosuresAccept.isCurrentlyVisible()) {
			schedulingPage.OrderdisclosuresAccept.click();
			slf4jLogger.info("Clicked on OK, Got it on Order Discolosures pop up");
		}
	}

	public void verifyEarliestAppoitmentText() {
		schedulingPage.shouldExist(schedulingPage, 90);
		boolean flag = schedulingPage.earliestAppointmentText.getText().contains("Earliest available appointment");
		Assert.assertTrue(flag);
		slf4jLogger.info("Verified earliest appointment date");
	}

	public void reserveAppointment() {
		schedulingPage.shouldExist(schedulingPage, 60);
		((JavascriptExecutor) getDriver()).executeScript("scroll(0,250);");
		slf4jLogger.info("Reserve button click1");
		schedulingPage.reserveBtn.click();
		slf4jLogger.info("Clicked on reserve button");
	} 


	public void verifyDueDateUpdate() {
		String[] reservableDueDate = schedulingPage.reservableAppoitmentDate.getText().split(" ");
		String updatedDueDateText = schedulingPage.updatedDueDate.getText();
		boolean flag = updatedDueDateText.contains(reservableDueDate[1].substring(0, 3))
				&& updatedDueDateText.contains(reservableDueDate[2].substring(0, 1));
		Assert.assertTrue(flag);
		slf4jLogger.info("Verified due date updated or not");
	}

	public void DriverComments(String driverComment) {

		schedulingPage.driverComment.sendKeys(driverComment);

	}

	public void AdditionalComments(String addComment) {

		schedulingPage.additionalComment.sendKeys(addComment);

	}

	public void getDueDate() throws InterruptedException {
		actualDueDate = schedulingPage.duteDateTxt.getText();
	}

	public void enterdate(String passedDate) {

		String month=passedDate.substring(0, 3);
		char[] ch = passedDate.toCharArray();
		StringBuilder stbuilder = new StringBuilder();
		for(char c : ch){
			if(Character.isDigit(c)){
				System.out.println(c);
				stbuilder=stbuilder.append(c);
			}
		}
		String date=stbuilder.toString();
		((JavascriptExecutor) getDriver()).executeScript("scroll(0,250);");
		waitABit(2000);
		//		schedulingPage.appointment.click();
		JavascriptExecutor js = (JavascriptExecutor)getDriver();
		js.executeScript("arguments[0].click();",schedulingPage.appointment);
		waitABit(2000);
		select_date(month,date);   // Oct or Nov
		slf4jLogger.info("Appointment is selected successfully");
	}

	public void select_date(String mnt, String date){
		String UI_Date = schedulingPage.txt_appointdate.getText();

		if(UI_Date.contains(mnt)){
			select_date(date);   
		}else{
			while(!UI_Date.contains(mnt)){
				//				schedulingPage.btn_rightArrow_WeeklyCal.click();
				JavascriptExecutor js = (JavascriptExecutor)getDriver();
				js.executeScript("arguments[0].click();",schedulingPage.btn_rightArrow_WeeklyCal);
				waitABit(50);
				UI_Date = schedulingPage.txt_appointdate.getText();
			}
			select_date(date);
		} 
	}

	public void select_date(String date){
		String CellDate= null;
		do{
			for(int i=1; i<=7;i++){
				CellDate = getDriver().findElement(By.xpath("//table/thead/tr/th["+i+"]/div[2]")).getText();
				// System.out.println(CellDate+"  "+date);
				if(CellDate.equals(date)){ 
					getDriver().findElement(By.xpath("//table/tbody/tr[1]/td["+i+"]")).click();
					schedulingPage.btn_ReserveIt_WeeklyCal.click();
					//					if(getDriver().findElement(By.xpath("//div[contains(text(),'Please select timeslot!!!')]")).isDisplayed()){
					//						getDriver().findElement(By.xpath("//table/tbody/tr[1]/td["+i+"]")).click();
					//						schedulingPage.btn_ReserveIt_WeeklyCal.click();
					//					}
					break;
				}else if(i==7)
				{
					//					schedulingPage.btn_rightArrow_WeeklyCal.click();
					JavascriptExecutor js = (JavascriptExecutor)getDriver();
					js.executeScript("arguments[0].click();",schedulingPage.btn_rightArrow_WeeklyCal);
					waitABit(5000);
				}
			}
		}while(!CellDate.equals(date));
	}

	/**
	 * Step to click on Continue button in vacation suspend scheduling page
	 */
	@Step
	public void clicks_On_Continue_Button_In_Vacation_Suspend_Scheduling_Page() {
		click_On_Continue_Button_In_Vacation_Suspend_Scheduling_Page();
	}

	/**
	 * Method to click on Continue button in vacation suspend scheduling page
	 */
	public void click_On_Continue_Button_In_Vacation_Suspend_Scheduling_Page() {
		WebDriverWait wait  = new WebDriverWait(getDriver(), 60);
		wait.until(ExpectedConditions.elementToBeClickable(schedulingPage.btn_Vacation_Suspend_Scheduling_Continue));
		schedulingPage.btn_Vacation_Suspend_Scheduling_Continue.click();
		slf4jLogger.info("-----------Continue button on Vacation Suspend scheduling page clicked--------------------");
	}

	/**
	 * Step to Enter date when it is in Due date format
	 * @param passedDate
	 */
	@Step
	public void enterDateInDueDateFormat(String passedDate) {
		String month=passedDate.substring(0, 3);
		char[] ch = passedDate.toCharArray();
		StringBuilder stbuilder = new StringBuilder();
		for(char c : ch){
			if(Character.isDigit(c)){
				System.out.println(c);
				stbuilder=stbuilder.append(c);
			}
		}
		String date=stbuilder.toString();

		((JavascriptExecutor) getDriver()).executeScript("scroll(0,250);");
		waitABit(10000);
		JavascriptExecutor js = (JavascriptExecutor)getDriver();
		js.executeScript("arguments[0].click();",schedulingPage.btn_Due_Date_POTS);
		//		schedulingPage.btn_Due_Date_POTS.click();
		waitABit(2000);
		select_date_In_Due_Date_Format(month,date); 
		slf4jLogger.info("Appointment is selected successfully");
	}

	/**
	 * Method to Enter date when it is in Due date format
	 */
	public void select_date_In_Due_Date_Format(String mnt, String date){

		String UI_Date = schedulingPage.txt_Appointment_Date.getText();

		if(UI_Date.contains(mnt)){
			select_date_In_Due_Date_Format(date);   
		}else{
			while(!UI_Date.contains(mnt)){
				schedulingPage.btn_Right_Arrow_POTS_Only.click();
				waitABit(50);
				UI_Date = schedulingPage.txt_Appointment_Date.getText();
			}
			select_date_In_Due_Date_Format(date);
		} 
	}

	/**
	 * Method to select date when it is in Due date format
	 */
	public void select_date_In_Due_Date_Format(String date){
		String CellDate= null;
		do{
			List<WebElement> list = getDriver().findElements(By.xpath("//table/tbody/tr/td")); 
			for(WebElement ele :list){
				CellDate = ele.getText();
				System.out.println(CellDate+"  "+date);
				if(CellDate.equals(date)){ 
					ele.click();
					schedulingPage.btn_Assign_Date_POTS_Only.click();
					break;
				}
			}
		}while(!CellDate.equals(date));

	}

	//shilpa F33405

	public void modifyPhoneNumber(String contactNumber){
		schedulingPage.shouldExist(schedulingPage, 60);
		waitABit(1000);
		slf4jLogger.info("Scheduling page......");
		slf4jLogger.info("Clear text from textbox");
		waitABit(1000);                 
		schedulingPage.contactNumber.clear();   
		slf4jLogger.info("Enter new contact number");
		schedulingPage.contactNumber.sendKeys(contactNumber);
		waitABit(10000);
		slf4jLogger.info("New Contact Number entered");		
	}

	public void mandatoryPhoneNumber(){
		schedulingPage.shouldExist(schedulingPage, 60);
		waitABit(1000);
		slf4jLogger.info("Clear text from textbox");
		schedulingPage.contactNumber.clear();
		waitABit(1000);
		schedulingPage.phoneNumberMandatory.click();
		boolean flag = schedulingPage.phoneMandatory.getText().contains("Required");
		//Assert.assertTrue(flag);
		if(flag)
			slf4jLogger.info("Contact Number filed is mandatory");
		else
			slf4jLogger.info("Contact Number filed is not Mandatory");
	}

	public void validatePhoneNumber(String phoneNumber){
		schedulingPage.shouldExist(schedulingPage, 60);
		waitABit(1000);
		slf4jLogger.info("Contact Number ="+ schedulingPage.contactNumber.getValue().replaceAll("[\\s\\-()]",""));
		boolean flag =schedulingPage.contactNumber.getValue().replaceAll("[\\s\\-()]","").contains(phoneNumber);
		//Assert.assertTrue(flag);
		if(flag)
			slf4jLogger.info("Phone Number is matched with phone number entered in SFC");
		else
			slf4jLogger.info("Phone number is not matched.....");

	}
	
	/*
	 * Shilpa - MMP7824 - F36408 Verify the address in Scheduling page
	 */
	public void validatePostalAddress(String address) {
		System.out.println("Address value in Validate Postal Address Method:" + address);
		WebDriverWait wait = new WebDriverWait(getDriver(), 60);
		String newAddress = schedulingPage.postalAddress.getTextValue();
		slf4jLogger.info("String Value:" + newAddress);
		StringBuffer trimAddress = new StringBuffer();
		for (int i = 0; i < newAddress.length(); i++) {
			if ((newAddress.charAt(i) != '\n') && (newAddress.charAt(i) != '\r')) {
				trimAddress.append(newAddress.charAt(i));
			}
		}
		String s = trimAddress.toString();
		slf4jLogger.info("Trimed Address: " + trimAddress);
		String seq = address;
		slf4jLogger.info("S value:" + s);
		slf4jLogger.info("Seq value:" + seq);
		boolean bool = s.contains(seq);
		if (bool) {
			slf4jLogger.info("Address validated successfully");
		} else {
			slf4jLogger.info("Address not validated successfully");
		}

	}
	
	/*
	 * Shilpa MMP7824 - F36408 Verify the address in Scheduling page
	 */
	public void clickChangeBillingLink(){
		schedulingPage.shouldExist(schedulingPage, 60);
		schedulingPage.changeBillingAddressLink.click();
		slf4jLogger.info("Clicked Change link sucessfully");
		waitABit(2000);
	}
	
	/*
	 * Shilpa MMP7824 - F36408 Enter Street address in Scheduling page
	 * 
	 */
	public void enterStreetAddress(String streetAddress){
		schedulingPage.shouldExist(schedulingPage, 60);
		schedulingPage.tbx_street_name.clear();
		schedulingPage.tbx_street_name.sendKeys(streetAddress);
		slf4jLogger.info("Entered Street Address Successfully: " +streetAddress);
		waitABit(2000);
	}
	
	/*
	 * Shilpa MMP7824 - F36408 Enter Street address in Scheduling page
	 * 
	 */
	public void enterCity(String city){
		schedulingPage.shouldExist(schedulingPage, 60);
		schedulingPage.tbx_city_name.clear();
		schedulingPage.tbx_city_name.sendKeys(city);
		slf4jLogger.info("Entered City Successfully: " +city);
		waitABit(2000);
	}
	
	/*
	 * Shilpa MMP7824 - F36408 Enter Street address in Scheduling page
	 * 
	 */
	public void chooseState(String state){
		schedulingPage.shouldExist(schedulingPage, 60);
		schedulingPage.state_name.waitUntilClickable();
		schedulingPage.state_name.selectByVisibleText(state);
		slf4jLogger.info("Selected state is: "+state);
		waitABit(2000);
	}
	
	/*
	 * Shilpa MMP7824 - F36408 Enter Street address in Scheduling page
	 * 
	 */
	public void enterZipCode(String zipcode){
		schedulingPage.shouldExist(schedulingPage, 60);
		schedulingPage.tbx_zipcode.clear();
		schedulingPage.tbx_zipcode.sendKeys(zipcode);
		slf4jLogger.info("Entered zipcode Successfully:  " +zipcode);
		waitABit(2000);
	}
	
	/*
	 * Shilpa MMP7824 - F36408 Enter Street address in Scheduling page
	 * 
	 */
	public void clickValidateButton(){
		schedulingPage.shouldExist(schedulingPage, 120);
		waitABit(4000);
		schedulingPage.validateButton.click();
		slf4jLogger.info("Clicked Validate button");
		waitABit(2000);
	}
	
	/*
	 * Shilpa MMP7824 - F36408 Enter Street address in Scheduling page
	 * 
	 */
	public void clickShipToThisAddressButton(){
		schedulingPage.shouldExist(schedulingPage, 120);
		waitABit(4000);
		schedulingPage.shipToThisAddress.click();
		slf4jLogger.info("Clicked Ship To This Address Button");
		waitABit(2000);
	}

}
