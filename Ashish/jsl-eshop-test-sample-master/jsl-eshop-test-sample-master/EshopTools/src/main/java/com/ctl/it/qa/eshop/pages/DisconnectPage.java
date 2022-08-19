package com.ctl.it.qa.eshop.pages;

import com.ctl.it.qa.staf.Page;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class DisconnectPage extends Page{
    
    @FindBy(xpath = "//select[contains(@class,'form-control')]")
    public WebElementFacade DISReason;
    
    @FindBy(xpath = "//option[contains(text(),'Business Closed')]")
    public WebElementFacade DISHSIReasonBS;
    
    @FindBy(xpath = "(//option[contains(text(),'Business Closed')])[2]")
    public WebElementFacade DISPhReasonBS;
    
    @FindBy(xpath="(//button[@class='btn btn-primary'])[1]")
    public WebElementFacade DISContinue;
    
     
    @FindBy(xpath = "//button[@id='contBtnDiv']")
    public WebElementFacade DISContinue01;
    
    @FindBy(xpath = "//button[@class='btn btn-continue']")
    public WebElementFacade DISContinue02;
    
    @FindBy(id ="currentBillingAddress")
    public WebElementFacade DISCurrentBilling;
    
    @FindBy(id = "finalEmail")
    public WebElementFacade DISEmail;
    
           
    @Override
    public WebElementFacade getUniqueElementInPage() {
           return null;
    }

}

