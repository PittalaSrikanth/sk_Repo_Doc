@tag
Feature: F36408 _TC378966_TC378969_TC378973

  @TC378966
  Scenario Outline: F36408 - SFC to Eshop - Account Information Page - Shipping Address and Billing Addresses are being validated against postal address validation is being skipped  - New Order
    Given I should be on SFC login screen
    When I enter username and password
    Then I click on create new account
    Then I enter the "<firstName>" "<lastName>" "<phoneNo>" and "<address>" in new acquisition page
    Then I validate the address and save it
    Then I click on order eshop button
    Then I should be in Eshop Product offer page
    Then I select the best "<Installation_option>" installation option
    And I select Your "<Modem_Option>" Modem option
    And I select "<Ease_Option>" Ease Option
    Then I select the number of device needed "<Device Quantity>"
    And I click on continue button
    Then I should be in customize service page
    And I click again on contine button
    And I click to reserve appointment
    And I click on continue button of scheduling page
    And I decline customer email
    Then I validate postal address
    Then I click on Change Billing address
    Then I Enter new Billing Address and validate Billing address "<Street>","<State>","<City>","<Zip>"
    And I select Bypass validation incase multiple options returned
    And I click on save billing address
    And I enter date "<Date>" month "<Month>" and year "<Year>" of birth
    And I enter SSN number "<SSN>"
    And I select credit as "Yes"
    And I click on account Continue button
    And I click again click Continue button on account
    And I selected Yes for the review in order summary page
    Then I enter the special remark in Additional Order Remarks field "<Additional Order Remarks>"
    Then I clicked submit order button
    Then I get account number from application
   
    Examples: 
      | firstName | lastName | phoneNo    | address                               | Installation_option | Modem_Option | Ease_Option | Date | Month | Year | SSN       | card             | zip code | Device Quantity | Additional Order Remarks       | Street            | State   | City   | Zip   |
      | Brent     | Mayes    | 4029986730 | 3066 SHADY LN , LITTLETON, CO, 80126  | STANDARD            | LEASE        | BASIC       |   02 |    02 | 1987 | 666601283 | 4485389438108352 |    37638 | 2 devices       | ESHOP ORDER TEST BY AUTOMATION | 3066 S GRANBY ST  | Colorado| AURORA | 80014 |
      # 11965 TIFFANY LN ,EDEN PRAIRIE,55344
  
  @TC378969  
  Scenario Outline: F36408 - SFC to Eshop - Account Information Page - Shipping Address and Billing Addresses are being validated against postal address validation is being skipped  - Move Order
    Given I should be on SFC login screen
    When I enter username and password
    Then I search order in SFC page with account number "<account number>"
    Then I click on order eshop button in SFC page to proceed to Eshop Page
    Then I should be in existing products page
    Then I select move service from other order activities
    And I enter new address and click validate "<new_address>"
    Then I select the best "<Installation_option>" installation option
    Then I select the number of device needed "<Device Quantity>"
    And I select Macd Your "<Modem_Option>" Modem option
    And I click continue button from existing products and move service page
    And I click again continue button in Customer Service Page
    And I click to reserve appointment
    And I click continue button in scheduling Move Order page
    Then I validate postal address
    Then I click on Current Billing Address
    Then I click on different address
    Then I Enter Different Billing Address and validate Billing address "<Street>","<State>","<City>","<Zip>"
    Then I click on New Service Address
    And I click Continue button on account information page
    And I selected Yes for the review in order summary page

    #Then I clicked submit order button
    # Then I should able to submit order successfully
    # Then I get account number from application
    # 473708391
    Examples: 
      | Env | firstName | lastName | phoneNo    | new_address                      | account number | Installation_option | Device Quantity | removal_reason | Modem_Option | Street            | State   | City   | Zip   |
      | E2E | Brent     | Mayes    | 4029986730 | 14602 CURTIS AVE, OMAHA, NE 68116|      578620832 | STANDARD            | 2 devices       | MOVED          | Lease        | 3066 S GRANBY ST  | Colorado| AURORA | 80014 |
      
    @TC378973
  Scenario Outline: TC361224 eShop F25918 Inititating Vacation Suspend in eShop on qualified customer
    Given I should be on SFC login screen
    When I enter username and password
    Then I search order in SFC page with account number "<account number>"
    Then I click on order eshop button in SFC page to proceed to Eshop Page
    Then I click on Vacation Service
    Then I select Vacation Suspend from the dialog box
    Then I click on Continue button on vacation service dialog box
    Then I click on Continue button on vacation service dialog box
    Then I click ok on Order Disclosure pop-up 
    And I click again continue button in Customer Service Page
    And I click on continue button of scheduling page
    Then I Entered new Billing Address "<Street>","<State>","<City>","<Zip>"
    And I select Bypass validation incase multiple options returned
    Then I click on Current Billing Address
    And I click Continue button on account information page
    And I selected Yes for the review in order summary page
   #Then I clicked submit order button

    Examples: 
      | account number | Street              | State   | City  | Zip   |
      |      578620832 | 555 LAKE BORDER DR1 | Florida | AOPKA | 32703 |  
 
      
      
      
      
      
           