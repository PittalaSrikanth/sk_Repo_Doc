package com.ctl.it.qa.eshop.steps;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ctl.it.qa.eshop.pages.VacationRestorePage;
import com.ctl.it.qa.eshop.pages.VacationSuspendPage;
import com.ctl.it.qa.staf.Steps;

import net.thucydides.core.annotations.Step;

@SuppressWarnings("serial")
public class VacationRestoreSteps extends Steps {

	private final Logger slf4jLogger = LoggerFactory.getLogger(VacationRestoreSteps.class);
	VacationRestorePage vacationRestorePage;

	/**
	 * Step to select Vacation Service option
	 */
	@Step
	public void selects_Vacation_Service() {
		select_Vacation_Service();
	}

	/**
	 * Method to select Vacation Service option
	 */
	public void select_Vacation_Service() {
		WebDriverWait wait = new WebDriverWait(getDriver(), 60);
		wait.until(ExpectedConditions.visibilityOf(vacationRestorePage.ddl_Other_Order_Activities));
		vacationRestorePage.ddl_Other_Order_Activities.click();
		vacationRestorePage.link_Vacation_Service.click();
		slf4jLogger.info("-----------Vacation Service Selcted--------------------");
	}

	/**
	 * Step to select Vacation Restore option from Vacation Service dialog box
	 * for HSI
	 */
	@Step
	public void selects_Vacation_Restore_For_HSI() {
		select_Vacation_Restore_For_HSI();
	}

	/**
	 * Method to select Vacation Restore option from Vacation Service dialog box
	 * for HSI
	 */
	public void select_Vacation_Restore_For_HSI() {
		WebDriverWait wait = new WebDriverWait(getDriver(), 60);
		wait.until(ExpectedConditions.visibilityOf(vacationRestorePage.ddl_Vacation_Service_Selection_HSI));
		Select select = new Select(vacationRestorePage.ddl_Vacation_Service_Selection_HSI);
		select.selectByVisibleText("Vacation Restore");
		slf4jLogger.info("-----------Vacation Restore Selected for HSI--------------------");
	}

	/**
	 * Method to click on Continue button in vacation service dialog box
	 */
	public void click_On_Continue_Button_In_Vacation_Service_Dialog_Box() {
		WebDriverWait wait = new WebDriverWait(getDriver(), 60);
		wait.until(ExpectedConditions.visibilityOf(vacationRestorePage.btn_Vacation_Service_Continue));
		vacationRestorePage.btn_Vacation_Service_Continue.click();
		slf4jLogger.info("-----------Continue button on Vacation Service dialog box clicked--------------------");
	}

	/**
	 * Step to click on Continue button in vacation service dialog box
	 */
	@Step
	public void clicks_On_Continue_Button_In_Vacation_Service_Dialog_Box() {
		click_On_Continue_Button_In_Vacation_Service_Dialog_Box();
	}

	
	//ac50097
	public void selects_Vacation_Restore() {

		WebDriverWait wait = new WebDriverWait(getDriver(), 60);
		wait.until(ExpectedConditions.visibilityOf(vacationRestorePage.selects_Vacation_Restore));
		vacationRestorePage.selects_Vacation_Restore.click();
		vacationRestorePage.selects_Vacation_Restore.selectByVisibleText("Vacation Restore");

	}

	
	//ac50097
	public void i_click_continue_on_vacation_Product_offer_Page(){
	WebDriverWait wait  = new WebDriverWait(getDriver(), 60000);
	wait.until(ExpectedConditions.visibilityOf(vacationRestorePage.btn_Vacation_Service_Continue));
	waitABit(2000);
	vacationRestorePage.btn_Vacation_Service_Continue.click();
	}

}
