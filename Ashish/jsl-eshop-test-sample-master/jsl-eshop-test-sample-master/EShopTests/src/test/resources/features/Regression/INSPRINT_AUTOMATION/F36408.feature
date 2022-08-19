@EshopTestScripts @F36408
Feature: Scenarios for F36408 

   @HSI_F36408_TC378947
   Scenario Outline: Create a HSI new install Order with No deposit required
    Given I should be on SFC login screen
    When I enter username and password
    Then I click on create new account
    Then I enter the "<firstName>" "<lastName>" "<phoneNo>" and "<address>" in new acquisition page
    Then I validate the address and save it
    Then I click on order eshop button
    Then I should be in Eshop Product offer page
    And I choose last speed option
    Then I select the self install option
    And I select Your "<Modem_Option>" Modem option
    And I select "<Ease_Option>" Ease Option
    And I click on continue button
    And I click again on contine button
    And I click to reserve appointment
    And I validate address in scheduling page "<address>"
    And I click on change billing address link
    And I enter street address "<street address>"
    And I enter city "<city>"
    And I choose state "<state>"
    And I enter zipcode "<zip code>"
    And I click validate button
    And I click on Ship to this address button
    And I click on continue button of scheduling page
    And I enter "<email>" and "<SMSNo>"
    And I enter date "<Date>" month "<Month>" and year "<Year>" of birth
    And I enter SSN number "<SSN>"
    And I select credit as "Yes"
    And I click on account Continue button
    And I click again click Continue button on account
    And I selected Yes for the review in order summary page
    Then I enter the special remark in Additional Order Remarks field "<Additional Order Remarks>"    
    #Then I clicked submit order button
    #Then I get account number from application

    Examples: 
      | firstName | lastName | phoneNo    | address                               | Modem_Option | Ease_Option | street address   |city    |state  |zip code |email       | SMSNo      | Date | Month | Year | SSN       |Additional Order Remarks       |            
      | THOMAS    | HILLA    | 4029986730 | 3066 SHADY LN,LITTLETON,CO 80126,USA  | LEASE        | BASIC       | 1693 Garfield Ave|Dubuque |Idaho  |52001    |Ctl@Ctl.com | 4029986730 |   02 |    02 | 1987 | 666446831 |ESHOP ORDER TEST BY AUTOMATION |


 
   @MACD_HSI_TC378948
   Scenario Outline: MACD on HSI Speed Change
    Given I should be on SFC login screen
    When I enter username and password
    Then I search order in SFC page with account number "<account number>"
    Then I click on order eshop button in SFC page to proceed to Eshop Page
    Then I should be in existing products page
    Then I click on Make changes button
    And I choose last speed option
    And I select Your "<Modem_Option>" Modem option for Change 
    And I click on continue button
    And I add the equipments in customize service page
    And I click again on contine button   
    And I validate address in scheduling page "<address>"
    And I click on change billing address link
    And I enter street address "<street address>"
    And I enter city "<city>"
    And I choose state "<state>"
    And I enter zipcode "<zip code>"
    And I click validate button
    And I click on Ship to this address button
    And I click on continue button of scheduling page
    And I click on continue button on Account Information page for MACD orders
    And I selected Yes for the review in order summary page
    Then I clicked submit order button
    Then I get account number from application    
    
         
       Examples: 
    | account number | address                                   | Modem_Option |street address   |city    |state  |zip code |        
    | 578549083      | 3066 SHADY LN,LITTLETON,CO 80126,USA      | LEASE        |1693 Garfield Ave|Dubuque |Idaho  |52001    |
    
    
    
   @MACD_HSI_TC378950
   Scenario Outline: MACD on HSI Move
    Given I should be on SFC login screen
    When I enter username and password
    Then I search order in SFC page with account number "<account number>"
    Then I click on order eshop button in SFC page to proceed to Eshop Page
    Then I should be in existing products page
    Then I select move service from other order activities
    And I enter new address and click validate "<new_address>"
    And I choose last speed option
    Then I select the self install option
    And I select Your "<Modem_Option>" Modem option for Change 
    And I click on continue button   
    And I add the equipments in customize service page
    And I click again on contine button
    And I click to reserve appointment
    And I validate address in scheduling page "<address>"
    And I click on change billing address link
    And I enter street address "<street address>"
    And I enter city "<city>"
    And I choose state "<state>"
    And I enter zipcode "<zip code>"
    And I click validate button
    And I click on Ship to this address button
    And I click on continue button of scheduling page
    And I enter email in account information page"<email>"
    And I click on continue button on Account Information page for MACD orders
    And I selected Yes for the review in order summary page      
    Then I clicked submit order button
    Then I get account number from application    
        
       Examples: 
    | account number |address                                   | Modem_Option | Ease_Option | street address   |city    |state  |zip code |new_address                            | email       |       
    | 578549276      |3066 SHADY LN,LITTLETON,CO 80126,USA      | LEASE        | BASIC       | 334 W HATCHER RD |PHOENIX |Alaska |85021    |1693 Garfield Ave,Dubuque,IA 52001,USA | Ctl@Ctl.com | 
   #| 578639855      |1693 Garfield Ave,Dubuque,IA 52001,USA    | LEASE        | BASIC       | 1693 Garfield Ave|Dubuque |Idaho  |52001    |3066 SHADY LN,LITTLETON,CO 80126,USA   | Ctl@Ctl.com |
    

 
  @TC378955
  Scenario Outline:TC378955 Vacation Suspend Order
  Given I should be on SFC login screen
  When I enter username and password
  Then I search order in SFC page with account number "<account number>"
  Then I click on order eshop button in SFC page to proceed to Eshop Page
  Then I should be in existing products page
  Then I click on Vacation Service
  And select Vacation Suspend 
  And I select Vacation Suspend for all services
  And I click on Continue button on vacation service dialog box
  Then I click continue on Product and Services page
  Then I click ok on Order Disclosure pop-up 
  And I click again on contine button
  And I click on continue button of scheduling page
  Then I Entered new Billing Address "<Street>","<State>","<City>","<Zip>"
  Then I click on continue button for Vacation Restore order in Account Information page
  And I selected Yes for the review in order summary page
  Then I clicked submit order button
  Then I get account number from application
      
    
    Examples: 
      | Env  | firstName | lastName | phoneNo     | account number | email             | Street				 |City		|State	  |	Zip	| email address         | Is paperless Billing | BP SEQ NO | Database       | Discount              | On Hold Reason | Additional Notes |
      | ITV1 | Thomas    | Hilla    | 4029986730  | 578632892      | testmail@ctli.com | 3066 SHADY LN       |LITTLETON	|Colorado |80126| changedemail@ctli.com | 0null                |         2 | Database_Test1 | Vacation Discount 50% | 1: HFCIB       | Test Automation  |
    
  
	@TC378956
 	Scenario Outline:TC378956 Vacation Restore Order
    Given I should be on SFC login screen
    When I enter username and password
    Then I search order in SFC page with account number "<account number>"
    Then I click on order eshop button in SFC page to proceed to Eshop Page
    Then I should be in existing products page
    Then I click on Vacation Service
    And select Vacation Restore
  	And I click continue on vacation Product offer Page
    And I click on Continue button on vacation service dialog box
    And I click again on contine button
    And I click on continue button of scheduling page
    Then I Entered new Billing Address "<Street>","<State>","<City>","<Zip>"
  	Then I click on continue button for Vacation Restore order in Account Information page
    And I selected Yes for the review in order summary page
   	Then I clicked submit order button
    Then I get account number from application
   
    
    
    Examples: 
      | Env  | firstName | lastName | phoneNo     | account number | email             | Street			| City		| State	   |Zip	 |	email address         | Is paperless Billing | BP SEQ NO | Database       | Discount              | On Hold Reason | Additional Notes |
      | ITV1 | Thomas    | Hilla    | 4029986730  | 578641871      | testmail@ctli.com | 3066 SHADY LN  | LITTLETON	| Colorado |80126|	changedemail@ctli.com | 0null                |        2  | Database_Test1 | Vacation Discount 50% | 1: HFCIB       | Test Automation  |


      
    