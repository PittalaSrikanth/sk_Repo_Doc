package com.ctl.it.qa.eshop.pages;

import com.ctl.it.qa.staf.Page;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class ESHOPSFCPage extends Page {

	@FindBy(xpath = "//input[@id='phSearchInput']")
	public WebElementFacade search_salesforce;

	@FindBy(xpath = "//td[contains(text(),'676152480')]/preceding-sibling::th")
	public WebElementFacade click_search_order;

	@FindBy(xpath = "(//input[@value='Research Account'])[1]")
	public WebElementFacade research_account;

	@FindBy(xpath = "(//input[@value='Order (ESHOP)'])[1]")
	public WebElementFacade order_eshop;

	@FindBy(xpath = "//span[text()='Close all primary tabs']")
	public WebElementFacade lnk_close_all_primary_tabs;

	@FindBy(xpath = "//span[text()='Pop out primary tabs']")
	public WebElementFacade lnk_pop_out_primary_tabs;

	@FindBy(xpath = "(//div[@class='x-tab-tabmenu-right'])[1]")
	public WebElementFacade btn_right_tab_menu;

	@Override
	public WebElementFacade getUniqueElementInPage() {

		return search_salesforce;
	}

}