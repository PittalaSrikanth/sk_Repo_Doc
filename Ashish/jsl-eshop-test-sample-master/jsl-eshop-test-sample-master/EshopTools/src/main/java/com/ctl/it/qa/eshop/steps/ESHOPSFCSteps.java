package com.ctl.it.qa.eshop.steps;

import com.ctl.it.qa.eshop.pages.ESHOPSFCPage;
import com.ctl.it.qa.staf.Steps;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.serenitybdd.core.annotations.findby.By;
import net.thucydides.core.annotations.Step;

@SuppressWarnings("serial")
public class ESHOPSFCSteps extends Steps {

	static String ban=OrderSummarySteps.accountnum;
	ESHOPSFCPage eshopsfcpage;
	private final Logger slf4jLogger = LoggerFactory.getLogger(ESHOPSFCSteps.class);

	@Step
	public void move_back_to_existing_SFC_page() {

		String EshopUrl=getDriver().getCurrentUrl();
		getDriver().close();
		slf4jLogger.info(EshopUrl+ " - Following Eshop URL has been Closed to Proceed with MACD or SUP Operations");
		Set<String> allWindows=getDriver().getWindowHandles();
		Iterator<String> windowIterator=allWindows.iterator();
		String parentWindow=windowIterator.next();
		getDriver().switchTo().window(parentWindow);
		slf4jLogger.info("Moved Back to SFC and URL is -"+getDriver().getCurrentUrl());
	}

	@Step
	public void search_order_in_SFC_page_with_account_number() {

		eshopsfcpage.shouldExist(eshopsfcpage,60);
		eshopsfcpage.search_salesforce.click();
		eshopsfcpage.search_salesforce.sendKeys(ban);
		eshopsfcpage.search_salesforce.sendKeys(Keys.ENTER);
		waitABit(2000);
		WebElement frameElement_eshop=getDriver().findElement(By.xpath("//iframe[contains(@src,'UnifiedSearch')]"));
		String frameName=frameElement_eshop.getAttribute("name");
		getDriver().switchTo().frame(frameName);
		WebElement search_by_account_name=getDriver().findElement(By.xpath("//td[contains(text(),'"+ban+"')]/preceding-sibling::th"));
		String account_name=search_by_account_name.getText();
		search_by_account_name.click();
		slf4jLogger.info("Clicked on Account name - "+account_name);
		getDriver().switchTo().defaultContent();
		waitABit(10000);
	}

	@Step
	public void click_on_order_eshop_button_in_SFC_page_to_proceed_to_Eshop_Page() {


		//WebElement frameElement_eshop=getDriver().findElement(By.xpath("//iframe[contains(@src,'/0011900000')]")); //MACD PP1
		WebElement frameElement_eshop=getDriver().findElement(By.xpath("//iframe[contains(@src,'/0018A00000')]")); //MACD PP2 frame
		//WebElement frameElement_eshop=getDriver().findElement(By.xpath("//iframe[starts-with(@src,'/00123000')]")); //MACD PP4 frame

		//WebElement frameElement_eshop=getDriver().findElement(By.xpath("//iframe[starts-with(@src,'/0011900000kYqJM?')]")); //MACD PP4 frame

		String frameName=frameElement_eshop.getAttribute("name");
		getDriver().switchTo().frame(frameName);
		eshopsfcpage.research_account.click();
		slf4jLogger.info("Clicked on Research Account button");
		waitABit(5000);
		eshopsfcpage.order_eshop.click();
		slf4jLogger.info("Clicked on order Eshop button");
		waitABit(50000);
		Set<String> allWindows=getDriver().getWindowHandles();
		Iterator<String> windowIterator=allWindows.iterator();
		String parentWindow=windowIterator.next();
		String childWindow=windowIterator.next();
		System.out.println(allWindows);
		getDriver().switchTo().window(childWindow);
		getDriver().manage().window().maximize();		
		slf4jLogger.info("Launched Eshop Application for MACD or SUP Operations and New URL is  "+getDriver().getCurrentUrl());	
	}


	@Step
	public void search_order_in_SFC_page_with_account_number(String ban) {

		eshopsfcpage.shouldExist(eshopsfcpage,60);
		pop_out_primary_tabs();
		eshopsfcpage.search_salesforce.click();
		eshopsfcpage.search_salesforce.sendKeys(ban);
		eshopsfcpage.search_salesforce.sendKeys(Keys.ENTER);
		waitABit(2000);
		WebElement frameElement_eshop=getDriver().findElement(By.xpath("//iframe[contains(@src,'UnifiedSearch')]"));
		String frameName=frameElement_eshop.getAttribute("name");
		getDriver().switchTo().frame(frameName);
		WebElement search_by_account_name=getDriver().findElement(By.xpath("//td[contains(text(),'"+ban+"')]/preceding-sibling::th"));
		String account_name=search_by_account_name.getText();
		search_by_account_name.click();
		slf4jLogger.info("Clicked on Account name - "+account_name);
		getDriver().switchTo().defaultContent();
		waitABit(15000);

	}

	/**
	 * Method to pop out primary tabs and close it
	 */
	public void pop_out_primary_tabs() {
		try {
			WebDriverWait wait = new WebDriverWait (getDriver(), 60);
			wait.until(ExpectedConditions.visibilityOf(eshopsfcpage.btn_right_tab_menu));
			waitABit(10000);		
			eshopsfcpage.btn_right_tab_menu.click();
			String parentHandle = getDriver().getWindowHandle();
			System.out.println("parent window id is  " + parentHandle);
			waitABit(1000);		
			if(eshopsfcpage.lnk_pop_out_primary_tabs.isCurrentlyEnabled()){
				eshopsfcpage.lnk_pop_out_primary_tabs.click();	
				Set<String> allWindows = getDriver().getWindowHandles();
				System.out.println("Window size >>>>>>>>>> " + allWindows.size());
				if (allWindows.size() > 1) {
					Iterator<String> windowIterator = allWindows.iterator();
					String parentWindow = windowIterator.next();
					String childWindow = windowIterator.next();
					getDriver().switchTo().window(childWindow);
					System.out.println("Child window is >>> "+childWindow);
					waitABit(7000);
					getDriver().switchTo().window(childWindow).close();
					System.out.println("child window is closed..... ");
					getDriver().switchTo().window(parentWindow);
					System.out.println("Switch to Parent window ........ ");
				} else {
					System.out.println("Single window   ");
				}				
			}
		}catch(Exception e){
			System.out.println("driver instance is not moved back to parent window");
		}
	}

}
