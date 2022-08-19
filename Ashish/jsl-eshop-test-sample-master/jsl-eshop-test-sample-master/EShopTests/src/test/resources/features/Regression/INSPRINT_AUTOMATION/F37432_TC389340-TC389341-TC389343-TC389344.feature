@EshopTestScripts @F37432
Feature: Scenarios for F37432 

   #TC389340
   @NI_HSI_TC389340
   Scenario Outline: Create a HSI new install Order with No deposit required
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
    And I enter "<email>" and "<SMSNo>"
    And I add first authorized parties "<firstname1>" "<lastname1>" and "<contactnumber1>"    
    And I add second authorized parties "<firstname2>" "<lastname2>" and "<contactnumber2>" 
    And I click on Save Updates button
    And I enter date "<Date>" month "<Month>" and year "<Year>" of birth
    And I enter SSN number "<SSN>"
    And I select credit as "Yes"
    And I click on account Continue button
    And I click again click Continue button on account
    And I selected Yes for the review in order summary page
    And I validate authorized party in order summary page "<firstname1>" "<lastname1>" "<firstname2>" "<lastname2>" 
    Then I enter the special remark in Additional Order Remarks field "<Additional Order Remarks>"
    Then I clicked submit order button
    Then I get account number from application

    Examples: 
      | firstName | lastName | phoneNo    | address                               | Installation_option | Modem_Option | Ease_Option | email       | SMSNo      | Date | Month | Year | SSN       | Device Quantity | Additional Order Remarks       |firstname1 |lastname1  |contactnumber1|firstname2  |lastname2  |contactnumber2|
      | THOMAS    | HILLA    | 4029986730 | 3066 SHADY LN,LITTLETON,CO 80126,USA  | STANDARD            | LEASE        | BASIC       | Ctl@Ctl.com | 4029986730 |   02 |    02 | 1987 | 666446831 | 2 devices       | ESHOP ORDER TEST BY AUTOMATION |testOne    |dataOne    |4043454322    |testTwo     |dataTwo    |4043454311    |
      
      
  @NI_HSICVOIP_TC389341
  Scenario Outline: Create a HSI + CVOIP new install Order with No deposit required
    Given I should be on SFC login screen
    When I enter username and password
    Then I click on create new account
    Then I enter the "<firstName>" "<lastName>" "<phoneNo>" and "<address>" in new acquisition page
    Then I validate the address and save it
    Then I click on order eshop button
    Then I should be in Eshop Product offer page
    And I select CVoip DHP phone
    And I select address info popup
    Then I select the best "<Installation_option>" installation option
    And I select Your "<Modem_Option>" Modem option
    And I select "<Ease_Option>" Ease Option
    Then I select the number of device needed "<Device Quantity>"
    And I click on continue button
    Then I should be in customize service page
    And I click again on contine button
    And I click to reserve appointment
    And I click on continue button of scheduling page
    And I enter "<email>" and "<SMSNo>"
    And I add first authorized parties "<firstname1>" "<lastname1>" and "<contactnumber1>"    
    And I add second authorized parties "<firstname2>" "<lastname2>" and "<contactnumber2>" 
    And I click on Save Updates button
    And I enter date "<Date>" month "<Month>" and year "<Year>" of birth
    And I enter SSN number "<SSN>"
    And I select credit as "Yes"
    And I click on account Continue button
    And I click again click Continue button on account
    And I selected Yes for the review in order summary page
    And I validate authorized party in order summary page "<firstname1>" "<lastname1>" "<firstname2>" "<lastname2>" 
    Then I enter the special remark in Additional Order Remarks field "<Additional Order Remarks>"
    Then I clicked submit order button
    Then I get account number from application    

 Examples: 
      | firstName | lastName | phoneNo    | address                              | Installation_option | Modem_Option | Ease_Option | email       | SMSNo      | Date | Month | Year | SSN       | Device Quantity | Additional Order Remarks       |firstname1 |lastname1  |contactnumber1|firstname2  |lastname2  |contactnumber2|
      | THOMAS    | HILLA    | 4029986730 | 3066 SHADY LN,LITTLETON,CO 80126,USA | STANDARD            | LEASE        | BASIC       | Ctl@Ctl.com | 4029986730 |   02 |    02 | 1987 | 666446831 | 3 devices       | ESHOP ORDER TEST BY AUTOMATION |testOne    |dataOne    |4043454322    |testTwo     |dataTwo    |4043454311    |
      
      
  @NI_HSIPOTS_TC389343
  Scenario Outline: Create a HSI + POTS Order
    Given I should be on SFC login screen
    When I enter username and password
    Then I click on create new account
    Then I enter the "<firstName>" "<lastName>" "<phoneNo>" and "<address>" in new acquisition page
    Then I validate the address and save it
    Then I click on order eshop button
    Then I should be in Eshop Product offer page
    And I select HomePhone
    And I select the suitable matching offer "<Matching Offers>"
    Then I select the best "<Installation_option>" installation option
    And I select Your "<Modem_Option>" Modem option
    And I select "<Ease_Option>" Ease Option
    Then I select the number of device needed "<Device Quantity>"
    Then I select required option for voice mail "<Voice Mail>"
    Then I select required option for Wire Maintenance Plan "<Wire Maintenance Plan>"
    Then I select required option for Port in a phone number? "<Port in a phone number?>"
    Then I select required option for Need new jacks or wiring? "<Need new jacks or wiring?>"
    And I click on continue button
    Then I should be in customize service page
    And I click again on contine button
    And I click to reserve appointment
    And I click on continue button of scheduling page
    And I enter "<email>" and "<SMSNo>"
    And I add first authorized parties "<firstname1>" "<lastname1>" and "<contactnumber1>"    
    And I add second authorized parties "<firstname2>" "<lastname2>" and "<contactnumber2>" 
    And I click on Save Updates button
    And I enter date "<Date>" month "<Month>" and year "<Year>" of birth
    And I enter SSN number "<SSN>"
    And I select credit as "Yes"
    And I click on account Continue button
    And I click again click Continue button on account
    And I selected Yes for the review in order summary page
    And I validate authorized party in order summary page "<firstname1>" "<lastname1>" "<firstname2>" "<lastname2>"
    Then I enter the special remark in Additional Order Remarks field "<Additional Order Remarks>"
    #Then I clicked submit order button
    #Then I get account number from application
    
    Examples: 
      | firstName | lastName | phoneNo    | Matching Offers      | address                              | Installation_option | Modem_Option | Ease_Option | email       | SMSNo      | Date | Month | Year | SSN       | Device Quantity | Voice Mail | Wire Maintenance Plan | Port in a phone number? | Need new jacks or wiring? | Additional Order Remarks       |firstname1 |lastname1  |contactnumber1|firstname2  |lastname2  |contactnumber2|
      | THOMAS    | HILLA    | 4029986730 | Essential Home Phone | 3066 SHADY LN,LITTLETON,CO 80126,USA | STANDARD            | LEASE        | BASIC       | Ctl@Ctl.com | 4029986730 |   02 |    02 | 1987 | 666446831 | 2 devices       | No         | No                    | No                      | No Work Is Needed ($0)    | ESHOP ORDER TEST BY AUTOMATION |testOne    |dataOne    |4043454322    |testTwo     |dataTwo    |4043454311    |


  @NI_POTSOnly_TC389344
  Scenario Outline: Create a POTS only Order with No deposit required
    Given I should be on SFC login screen
    When I enter username and password
    Then I click on create new account
    Then I enter the "<firstName>" "<lastName>" "<phoneNo>" and "<address>" in new acquisition page
    Then I validate the address and save it
    Then I click on order eshop button
    Then I should be in Eshop Product offer page
    And I select HomePhone only by deselecting Internet
    And I select Price for Life Unlimited Phone unlimited Calling
    Then I select required option for voice mail "<Voice Mail>"
    Then I select required option for Wire Maintenance Plan "<Wire Maintenance Plan>"
    Then I select required option for Port in a phone number? "<Port in a phone number?>"
    Then I select required option for Need new jacks or wiring? "<Need new jacks or wiring?>"
    And I click on continue button
    Then I should be in customize service page
    And I click again on contine button
    #And I click to reserve appointment
    And I click on continue button of scheduling page
    And I enter "<email>" and "<SMSNo>"
    And I add first authorized parties "<firstname1>" "<lastname1>" and "<contactnumber1>"    
    And I add second authorized parties "<firstname2>" "<lastname2>" and "<contactnumber2>" 
    And I click on Save Updates button
    And I enter date "<Date>" month "<Month>" and year "<Year>" of birth
    And I enter SSN number "<SSN>"
    And I select credit as "Yes"
    And I click on account Continue button
    And I click again click Continue button on account
    And I selected Yes for the review in order summary page
    And I validate authorized party in order summary page "<firstname1>" "<lastname1>" "<firstname2>" "<lastname2>"
    Then I enter the special remark in Additional Order Remarks field "<Additional Order Remarks>"
   #Then I clicked submit order button
   #Then I get account number from application
    

    Examples: 
      | firstName | lastName | phoneNo    | address                              | email       | SMSNo      | Date | Month | Year | SSN       | Voice Mail | Wire Maintenance Plan | Port in a phone number? | Need new jacks or wiring? | Additional Order Remarks       |firstname1 |lastname1  |contactnumber1|firstname2  |lastname2  |contactnumber2|
      | THOMAS    | HILLA    | 4029986730 | 3066 SHADY LN,LITTLETON,CO 80126,USA | Ctl@Ctl.com | 4029986730 |   02 |    02 | 1987 | 666446831 | No         | No                    | No                      | No Work Is Needed ($0)    | ESHOP ORDER TEST BY AUTOMATION |testOne    |dataOne    |4043454322    |testTwo     |dataTwo    |4043454311    |
    