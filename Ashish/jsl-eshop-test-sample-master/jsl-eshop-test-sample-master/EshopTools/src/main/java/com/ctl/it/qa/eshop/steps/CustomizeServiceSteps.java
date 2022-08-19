package com.ctl.it.qa.eshop.steps;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ctl.it.qa.eshop.pages.CustomerDetailsPage;
import com.ctl.it.qa.eshop.pages.CustomizeServicePage;
import com.ctl.it.qa.staf.Steps;

import net.thucydides.core.annotations.Step;

public class CustomizeServiceSteps extends Steps {

	private final Logger slf4jLogger = LoggerFactory.getLogger(CustomerDetailsPage.class);
	
	CustomizeServicePage customizeServicePage;
	
	@Step
	public void clickOnAgainContiune() {
		customizeServicePage.shouldExist(customizeServicePage,60);
		customizeServicePage.shouldBeVisible(customizeServicePage.customizeServicePage);
		customizeServicePage.continueAgainButton.click();
		slf4jLogger.info("Clicked on Continue Button");
	}

	@Step
	public void isCustomizePage() {
		customizeServicePage.shouldExist(customizeServicePage,80);
		String coustomize = "Customize Services";
		Assert.assertTrue(customizeServicePage.customizeServicePage.getText().contains(coustomize));
		slf4jLogger.info("In Customize Service Page");
	}

	//Nitish Pots
	@Step
	public void i_add_euipments() {
			
			customizeServicePage.Homephoneeuipaddon.click();
			customizeServicePage.screenprotect.click();
			slf4jLogger.info("Selected the Equipments on Customize Service Page");
		}
	
	@Step
	public void i_added_euipment() {
		
		customizeServicePage.euip_1.click();
			
		}
	
	// ********* ac31339 code Starts from here
	@Step
	public void i_click_listToggle() {

		customizeServicePage.listingToggle.click();
		waitABit(2000);

	}

	@Step
	public void i_select_listing_options(String listOption) throws InterruptedException {

		try {
			if (listOption.equalsIgnoreCase("Listed")) {
				customizeServicePage.listingOptionsdrpDown.selectByValue("Listed");
				slf4jLogger.info("Selected Listing options is Listed");
			} else if (listOption.contains("Non-Listed")) {
				customizeServicePage.listingOptionsdrpDown.selectByValue("Non-Listed");
			} else if (listOption.contains("Non-Published")) {
				customizeServicePage.listingOptionsdrpDown.selectByValue("Non-Published");
			}
		} catch (Exception e) {
			slf4jLogger.info("No Listing options are Available" + e);
		}
	}

	@Step
	public void selectAllEquipments(String toggleTxt) throws InterruptedException {

		/// toggleTxt="OPT-EQP";

		String toggleTemplate = "((//div[text()='" + toggleTxt + "'])/parent::div)";
		WebElement first_Toggle = getDriver().findElement(By.xpath("(//div[@class='accordion-toggle'])[1]"));
		String attrVal = first_Toggle.getAttribute("aria-expanded");

		System.out.println("Attribute Value " + attrVal);

		WebElement toggleHeader = getDriver()
				.findElement(By.xpath("(//div[@class='accordion-toggle' and .//text()='" + toggleTxt + "'])"));
		if (!attrVal.equalsIgnoreCase("true")) {

			toggleHeader.click();
		}

		/*
		 * if(toggleHeader.isEnabled()) { toggleHeader.click(); }else {
		 * slf4jLogger.info("No such a toggle is available");}
		 */
		waitABit(5000);
		List<WebElement> equipmentCheckBox = getDriver().findElements(By.xpath(
				"(//div[contains(@class,'collapse in show')]//div[contains(@class,'divmarginsforitems')])//div[1]"));

		System.out.println("List Size is " + equipmentCheckBox.size());
		for (WebElement objCheckBox : equipmentCheckBox) {

			if (objCheckBox.isDisplayed() && objCheckBox.isEnabled()) {

				objCheckBox.click();
			}

			else {
				slf4jLogger.info("No such a Equipment is available");
			}

		}
		WebElement button_Close = getDriver()
				.findElement(By.xpath(toggleTemplate + "/following::div//span[text()='Close']"));
		if (button_Close.isEnabled()) {
			button_Close.click();
		} else {
			slf4jLogger.info("No such a Close button is available");
		}

	}

	@Step
	public void selectSpecificEquipments(String toggleTxt, String equip_Names) throws InterruptedException {

		WebElement toggleHeader = getDriver()
				.findElement(By.xpath("(//div[@class='accordion-toggle' and .//text()='" + toggleTxt + "'])"));
		String attrVal = toggleHeader.getAttribute("aria-expanded");

		if (!attrVal.equalsIgnoreCase("true")) {
			WebDriverWait wait = new WebDriverWait(getDriver(), 60);
			wait.until(ExpectedConditions.elementToBeClickable(toggleHeader));
			toggleHeader.click();
		} else {
			WebDriverWait wait = new WebDriverWait(getDriver(), 60);
			wait.until(ExpectedConditions.elementToBeClickable(toggleHeader));
		}

		if (equip_Names.contains("~")) {

			String equip_list[] = equip_Names.split("~");

			for (int i = 0; i < equip_list.length; i++) {

				WebElement equip_Element = getDriver()
						.findElement(By.xpath("//div[label[text()='" + equip_list[i] + "']]/preceding-sibling::div"));

				try {

					WebDriverWait wait = new WebDriverWait(getDriver(), 60);
					wait.until(ExpectedConditions.elementToBeClickable(equip_Element));

					equip_Element.click();
					waitABit(1000);
				} catch (Exception e) {
					slf4jLogger.info("No such a Equipment is available" + e);
				}
			}

		} else {

			WebElement equip_Element = getDriver()
					.findElement(By.xpath("//div[label[text()='" + equip_Names + "']]/preceding-sibling::div"));

			try {

				WebDriverWait wait = new WebDriverWait(getDriver(), 60);
				wait.until(ExpectedConditions.elementToBeClickable(equip_Element));

				equip_Element.click();
				waitABit(1000);
			} catch (Exception e) {
				slf4jLogger.info("No such a Equipment is available" + e);
			}

		}
		/*
		 * try { //WebElement btn_Close=getDriver().findElement(By.
		 * xpath("(//span[@class='accor-close pull-right'])[1]"));
		 * //(//span[@class='accor-close pull-right'])[1] JavascriptExecutor js =
		 * (JavascriptExecutor) getDriver();
		 * js.executeScript("arguments[0].scrollIntoView();",toggleHeader);
		 * WebDriverWait wait=new WebDriverWait(getDriver(),60);
		 * wait.until(ExpectedConditions.elementToBeClickable(toggleHeader));
		 * js.executeScript("arguments[0].click();",toggleHeader);
		 * System.out.println("Code is reached Here");
		 * 
		 * }catch(Exception e) {slf4jLogger.info("No such a Header is Invisible"+e);}
		 */
	}

	// ac31339 code ends here	
	
	//AB18364
	public void click_Telephone_Number()
	{
		customizeServicePage.btn_TelephoneNumber.click();
		waitABit(2000);
		customizeServicePage.btn_MoreTN.click();
		customizeServicePage.select_Phone_Number.selectByIndex(1);
		customizeServicePage.btn_SelectTN.click();	
	}
}
