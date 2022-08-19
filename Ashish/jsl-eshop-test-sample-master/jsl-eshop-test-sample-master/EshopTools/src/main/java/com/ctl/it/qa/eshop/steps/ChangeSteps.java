package com.ctl.it.qa.eshop.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ctl.it.qa.eshop.pages.ChangePage;
import com.ctl.it.qa.eshop.pages.OrderPage;
import com.ctl.it.qa.staf.Steps;

import net.thucydides.core.annotations.Step;

public class ChangeSteps extends Steps {
	
	
	private final Logger slf4jLogger = LoggerFactory.getLogger(ChangeSteps.class);
	
	OrderSteps ordersteps;
	
	ChangePage changepage;
	OrderPage orderpage;
	
	
	@Step
	public void i_clicked_on_make_changes_button() {
		
		changepage.makechanges.click();
	}

	public void i_added_new_product_HSI() {
		
		//orderpage.
		
	}

	@Step
	public void i_added_new_product_POTS() {
		
		ordersteps.homePhone();
		
	}

	@Step
	public void i_added_new_product_CVOIP() {
		
			
		
	}
	
	@Step
	public void i_removed_existing_product_HSI() {
		
		WaitForPageToLoad(60);
		//changepage.icon_addphone.click();
		//waitABit(1000); 
		//changepage.icon_internet.click();
		//WaitForPageToLoad(60);
		JavascriptExecutor jse1 = (JavascriptExecutor) getDriver();
		jse1.executeScript("arguments[0].click();",changepage.icon_internet);
		//changepage.icon_addphone.click();
		/*JavascriptExecutor jse2 = (JavascriptExecutor) getDriver();
		jse2.executeScript("arguments[0].click();", changepage.menu_nophone);*/
		
      //  changepage.menu_nophone.click();
		waitABit(2000);
		removalreson();
	}

	@Step
	public void i_removed_existing_product_POTS() {
		
		WaitForPageToLoad(60);
		JavascriptExecutor jse1 = (JavascriptExecutor) getDriver();
		jse1.executeScript("arguments[0].click();",changepage.icon_addphone);
		//changepage.icon_addphone.click();
		JavascriptExecutor jse2 = (JavascriptExecutor) getDriver();
		jse2.executeScript("arguments[0].click();", changepage.menu_nophone);
		
      //  changepage.menu_nophone.click();
		waitABit(2000);
		removalreson();
	}
	@Step
	public void i_removed_existing_product_CVOIP() {
		
		WaitForPageToLoad(60);
		JavascriptExecutor jse1 = (JavascriptExecutor) getDriver();
		jse1.executeScript("arguments[0].click();",changepage.icon_addphone);
		JavascriptExecutor jse2 = (JavascriptExecutor) getDriver();
		jse2.executeScript("arguments[0].click();", changepage.menu_nophone);
		waitABit(2000);
		removalreson();
	}
	@Step
	public void removalreson() {
		waitABit(3000);
		changepage.dd_removal_reason.selectByIndex(15);
        waitABit(2000);
        changepage.btn_continue_removal_product.click();
        waitABit(5000);
	}
	@Step
	public void i_add_a_referral() {
		
		JavascriptExecutor jse1 = (JavascriptExecutor) getDriver();
		jse1.executeScript("arguments[0].click();",changepage.add_referal_pots);
		waitABit(2000);
		changepage.no_referral_needed.click();
		waitABit(2000);
		changepage.save_referral.click();
		waitABit(2000);
	}
	@Step
	public void selectAvailableSpeed_change_order(String selectspeed) {
		WebElement availableSpeedRadioButton = getDriver()
				.findElement(By.xpath("//span[contains(text(),'" + selectspeed + "')]"));
		JavascriptExecutor jse2 = (JavascriptExecutor) getDriver();
		jse2.executeScript("arguments[0].click();", availableSpeedRadioButton);
		slf4jLogger.info("Changed the Speed to "+selectspeed);
		
	}

	@Step
	public void return_amount_removed_product() {
		waitABit(2000);
		try {
			boolean flag=changepage.removed_back_deposits_continue.isPresent();
			if(flag) {
				waitABit(2000);
				changepage.removed_back_deposits_continue.click();
				slf4jLogger.info("amount will be returned");
				waitABit(5000);
			}
			else {
				slf4jLogger.info("No amount to be returned");
			}
		}catch(Exception e){
			slf4jLogger.info("No amount to be returned  : caught exception" +e);
		}
		
	}

	public void continue_again() {
		JavascriptExecutor jse2 = (JavascriptExecutor) getDriver();
		jse2.executeScript("arguments[0].click();", changepage.continue_again);
		slf4jLogger.info("clicked on continue button");
	}

	public void change_account_continue_page() {
		
		JavascriptExecutor jse2 = (JavascriptExecutor) getDriver();
		jse2.executeScript("arguments[0].click();", changepage.change_account_continue);
		slf4jLogger.info("clicked on change account continue button");
		
	}

	
	//ac41685  // need to verify
	@Step
	public void Change_DueDate(){
		changepage.Calendar_img.click();
		for(int i=0;i<2;i++){
		changepage.forward_button.click();
		}
		changepage.select_date.click();
		changepage.assigne_date.click();
		
		
		
	}
	
	
	//AB18364
			@Step
			public void click_Telephone_Number()
			{
				changepage.btn_TelephoneNumber.click();
				changepage.btn_MoreTN.click();
				waitABit(2000);
				changepage.btn_Moreoptions.click();	
			}
		
			@Step
			public void clickOnContinue() throws InterruptedException {
				waitABit(20000);
				try {
					orderpage.shouldExist(orderpage, 60);
					orderpage.continueButton.click();
					slf4jLogger.info("Clicked Continue");
					waitABit(5000);
			} catch (Exception e) {
				slf4jLogger.info("Catch starts");
				JavascriptExecutor js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView();", orderpage.continueButton);
				orderpage.continueButton.click();
				slf4jLogger.info("Clicked Continue");
				
			}
			}
}
