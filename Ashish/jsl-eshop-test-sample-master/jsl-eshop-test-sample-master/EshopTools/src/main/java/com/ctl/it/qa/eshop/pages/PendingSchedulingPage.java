package com.ctl.it.qa.eshop.pages;

import com.ctl.it.qa.staf.Page;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class PendingSchedulingPage extends Page{


	@FindBy(xpath="//select[@class='ng-untouched ng-pristine ng-valid']")
	public WebElementFacade selectoption;
	
	@FindBy(xpath = "//*[@id='calImg']")
	public WebElementFacade datePickerD;

	@FindBy(xpath = "//datepicker[@class='ng-untouched ng-valid ng-dirty']")
	public WebElementFacade datePickerCalendar;

	@FindBy(xpath = "//*[@id='datepicker--281-11']/button/span")
	public WebElementFacade dateToPick;

	@FindBy(xpath = "//button[contains(text(),'Assign Date')]")
	public WebElementFacade assignToDate;
	
	@FindBy(id = "contBtnDiv")
	public WebElementFacade continueInCalendar;
	
	@FindBy(xpath="//h3[text()='Earliest available appointment']")
	public WebElementFacade earliestAppointmentText;
	
	@FindBy(id="contBtnDiv1")
	public WebElementFacade reserveBtn;
	
	@FindBy(id="weekCalText")
	public WebElementFacade reservableAppoitmentDate;
	
	@FindBy(xpath="//label[contains(text(),'Due Date')]/following-sibling::div[1]/label")
	public WebElementFacade updatedDueDate;
	
	@FindBy(xpath="//*[@title='Driving Directions']")
	public WebElementFacade driverComment;
	
	@FindBy(xpath="//*[@title='Additional Comments']")
	public WebElementFacade additionalComment;
	
	@FindBy(xpath="//div[label[contains(text(),'Due Date')]]/div[1]/label")
	public WebElementFacade duteDateTxt;
	
	
	@Override
	public WebElementFacade getUniqueElementInPage() {
		
		return reserveBtn;
	}

}
