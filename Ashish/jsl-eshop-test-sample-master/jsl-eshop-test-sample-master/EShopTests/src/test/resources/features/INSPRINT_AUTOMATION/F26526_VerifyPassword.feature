@EshopTestScripts @EShopFunctional
Feature: HSI Order Scenarios

  #TC324938
  @HSI_VerifyPassword
  Scenario Outline: Create a HSI new install Order "TC324938"
    Given I should be on SFC login screen
    When I enter username and password
    Then I click on create new account
    Then I enter the "<firstName>" "<lastName>" "<phoneNo>" and "<address>" in new acquisition page
    Then I validate the address and save it
    Then I click on order eshop button
    Then I should be in Eshop Product offer page
    Then I select the best "<Installation_option>" installation option
    Then I select the number of device needed "<Device Quantity>"
    And I select "<easeOption>" Ease Option
    And I click on continue button
    Then I should be in customize service page
    And I click again on contine button
    And I click to reserve appointment
    And I click on continue button of scheduling page
    And I enter "<email>" and "<SMSNo>"
    And I enter password "<password>"
    And I enter date "<Date>" month "<Month>" and year "<Year>" of birth
    And I enter SSN number "<SSN>"
    And I select credit as "Yes"
    And I click on account Continue button
    And I verify Password "<password>"
    And I click on payNow
    And I should be at make payment page
    And I fill all card details as "<card>" and "<zip code>"
    And I click submit button on verify InformationPage
    And I click again click Continue button on account
    And I selected Yes for the review in order summary page
    Then I clicked submit order button
    Then I should able to submit order successfully
    Then I get account number from application

    Examples: 
      | Env | firstName | lastName | phoneNo    | address                              | email       |password| SMSNo      | Installation_option | Date | Month | Year | SSN       | card             | zip code | Device Quantity |easeOption|
     | E2E | Jones     | Smith    | 4029986730 | 3066 SHADY LN , LITTLETON, CO, 80126 | Ctl@Ctl.com |Automation123 |4029986730 | STANDARD            |   02 |    02 | 1987 | 345038058 | 6011329842589845 |    37638 | 3 devices       |Basic ($0)|
 	 #| E2E | Jones     | Smith    | 4029986730 | 611 FENWICK DR,PAPILLION,NE 68046,USA | Ctl@Ctl.com |   Automation123    |4029986730 | STANDARD            |   02 |    02 | 1987 | 345038058 | 6011329842589845 |    37638 | 3 devices       |Basic ($0)|
 
 
 #TC324940     
 @POTSOnly_VerifyPassword
  Scenario Outline: Create a POTS Only Order "TC324940"
    Given I should be on SFC login screen
    When I enter username and password
    Then I click on create new account
    Then I enter the "<firstName>" "<lastName>" "<phoneNo>" and "<address>" in new acquisition page
    Then I validate the address and save it
    Then I click on order eshop button
    Then I should be in Eshop Product offer page
    And I select HomePhone
    And I select Internet
    #And I select address info popup
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
    And I enter password "<password>"
    And I enter date "<Date>" month "<Month>" and year "<Year>" of birth
    And I enter SSN number "<SSN>"
    And I select credit as "Yes"
    And I click on account Continue button
    And I verify Password "<password>"
    And I click on payNow
    And I should be at make payment page
    And I fill all card details as "<card>" and "<zip code>"
    And I click submit button on verify InformationPage
    And I click again click Continue button on account
    And I selected Yes for the review in order summary page
    Then I clicked submit order button
    Then I should able to submit order successfully
    Then I get account number from application

    Examples: 
      | Env | firstName | lastName | phoneNo    | address                            | email       | SMSNo      | Installation_option | Date | Month | Year | SSN       | card             | zip code | Voice Mail | Wire Maintenance Plan | Port in a phone number? | Need new jacks or wiring? |password|
      | E2E | MARIANNE  | HELTON   | 4029986730 | 611 FENWICK DR,PAPILLION,NE 68046,USA | Ctl@Ctl.com | 4029986730 | STANDARD            |   02 |    02 | 1987 | 666150907 | 4485389438108352 |    37638 | No         | No                    | No                      | No Work Is Needed ($0)    |Automation123|
      #| E2E | MARIANNE  | HELTON   | 4029986730 | 11017 V ST,OMAHA,NE 68137,USA | Ctl@Ctl.com | 4029986730 | STANDARD            |   02 |    02 | 1987 | 666150907 | 4485389438108352 |    37638 | No         | No                    | No                      | No Work Is Needed ($0)    |Automation123|

#TC324942
 @HSI+POTS_VerifyPassword
  Scenario Outline: Create a HSI + POTS Order "TC324942"
    Given I should be on SFC login screen
    When I enter username and password
    Then I click on create new account
    Then I enter the "<firstName>" "<lastName>" "<phoneNo>" and "<address>" in new acquisition page
    Then I validate the address and save it
    Then I click on order eshop button
    Then I should be in Eshop Product offer page
    And I select HomePhone
    And I select the suitable matching offer "<Matching Offers>"
    Then I select the number of device needed "<Device Quantity>"
    And I select "<easeOption>" Ease Option
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
    And I enter password "<password>"
    And I enter date "<Date>" month "<Month>" and year "<Year>" of birth
    And I enter SSN number "<SSN>"
    And I select credit as "Yes"
    And I click on account Continue button
    And I verify Password "<password>"
    And I click on payNow
    And I should be at make payment page
    And I fill all card details as "<card>" and "<zip code>"
    And I click submit button on verify InformationPage
    And I click again click Continue button on account
    And I selected Yes for the review in order summary page
    Then I clicked submit order button
    Then I should able to submit order successfully
    Then I get account number from application

    Examples: 
      | Env | firstName | lastName | phoneNo    | Matching Offers              | address                            | email       | SMSNo      | Installation_option | Date | Month | Year | SSN       | card             | zip code | Device Quantity | Voice Mail | Wire Maintenance Plan | Port in a phone number? | Need new jacks or wiring? |password|easeOption|
      #| E2E | Jones  | Smith   | 4029986730 | Home Phone with Unlimited LD |3066 SHADY LN,LITTLETON,CO 80126| Ctl@Ctl.com | 4029986730 | STANDARD            |   02 |    02 | 1987 | 666150907 | 4485389438108352 |    37638 | 2 devices       | No         | No                    | No                      | No Work Is Needed ($0)    |Automation123|Basic ($0)|
      | E2E | Jones  | Smith   | 4029986730 | Home Phone with Unlimited LD |611 FENWICK DR,PAPILLION,NE 68046,USA| Ctl@Ctl.com | 4029986730 | STANDARD            |   02 |    02 | 1987 | 666150907 | 4485389438108352 |    37638 | 2 devices       | No         | No                    | No                      | No Work Is Needed ($0)    |Automation123|Basic ($0)|
      
  #TC324945    
  @HSICVOIP_VerifyPassword
  Scenario Outline: Create a HSI + CVOIP new install Order with Payment "TC324945"
    Given I should be on SFC login screen
    When I enter username and password
    Then I click on create new account
    Then I enter the "<firstName>" "<lastName>" "<phoneNo>" and "<address>" in new acquisition page
    Then I validate the address and save it
    Then I click on order eshop button
    Then I should be in Eshop Product offer page
    And I select CVoip DHP phone
    And I select address info popup
    Then I select the number of device needed "<Device Quantity>"
    And I select "<easeOption>" Ease Option
    And I click on continue button
    Then I should be in customize service page
    And I click again on contine button
    And I click to reserve appointment
    And I click on continue button of scheduling page
    And I enter "<email>" and "<SMSNo>"
    And I enter password "<password>"    
    And I enter date "<Date>" month "<Month>" and year "<Year>" of birth
    And I enter SSN number "<SSN>"
    And I select credit as "Yes"
    And I click on account Continue button
    And I verify Password "<password>"
    And I click on payNow
    And I should be at make payment page
    And I fill all card details as "<card>" and "<zip code>"
    And I click submit button on verify InformationPage
    And I click again click Continue button on account
    And I selected Yes for the review in order summary page
    Then I clicked submit order button
    Then I should able to submit order successfully
    Then I get account number from application

    Examples: 
      | Env | firstName | lastName | phoneNo    | address                            | email       | SMSNo      | Installation_option | Date | Month | Year | SSN       | card             | zip code | Device Quantity |password|easeOption|
      | E2E | Jones     | Smith    | 4899999343 | 3066 SHADY LN,LITTLETON,CO 80126 | Ctl@Ctl.com | 4029986730 | STANDARD            |   02 |    02 | 1987 | 345038058 | 4485389438108352 |    37638 | 2 devices       |Automation123|Basic ($0)|

 
 #TC324948    
  @HSIDTV_VerifyPassword
  Scenario Outline: Create a HSI + CVOIP new install Order with Payment "TC324948"
    Given I should be on SFC login screen
    When I enter username and password
    Then I click on create new account
    Then I enter the "<firstName>" "<lastName>" "<phoneNo>" and "<address>" in new acquisition page
    Then I validate the address and save it
    Then I click on order eshop button
    Then I should be in Eshop Product offer page
    And I select DTV
    #And I select address info popup
    Then I select the number of device needed "<Device Quantity>"
    And I select "<easeOption>" Ease Option
    And I click on continue button
    Then I should be in customize service page
    And I click again on contine button
    And I click to reserve appointment
    And I click on continue button of scheduling page
    And I enter "<email>" and "<SMSNo>"
    And I enter password "<password>"    
    And I enter date "<Date>" month "<Month>" and year "<Year>" of birth
    And I enter SSN number "<SSN>"
    And I select credit as "Yes"
    And I click on account Continue button
    And I verify Password "<password>"
    And I enter dtv account id "<dtv_accountid>"
    And I click on payNow
    And I should be at make payment page
    And I fill all card details as "<card>" and "<zip code>"
    And I click submit button on verify InformationPage
    And I click again click Continue button on account
    And I selected Yes for the review in order summary page
    Then I clicked submit order button
    Then I should able to submit order successfully
    Then I get account number from application

    Examples: 
      | Env | firstName | lastName | phoneNo    | address                            | email       | SMSNo      | Installation_option | Date | Month | Year | SSN       | card             | zip code | Device Quantity |password|easeOption|dtv_accountid|
      | E2E | Jones     | Smith    | 4899999343 | 3066 SHADY LN,LITTLETON,CO 80126 | Ctl@Ctl.com | 4029986730 | STANDARD            |   02 |    02 | 1987 | 345038058 | 4485389438108352 |    37638 | 2 devices       |Automation123|Basic ($0)|12345|
      
      
       #TC324938
  @HSI_Verify_InvalidPassword
  Scenario Outline: Create a HSI new install Order "TC324938"
    Given I should be on SFC login screen
    When I enter username and password
    Then I click on create new account
    Then I enter the "<firstName>" "<lastName>" "<phoneNo>" and "<address>" in new acquisition page
    Then I validate the address and save it
    Then I click on order eshop button
    Then I should be in Eshop Product offer page
    Then I select the best "<Installation_option>" installation option
    Then I select the number of device needed "<Device Quantity>"
    And I select "<easeOption>" Ease Option
    And I click on continue button
    Then I should be in customize service page
    And I click again on contine button
    And I click to reserve appointment
    And I click on continue button of scheduling page
    And I enter "<email>" and "<SMSNo>"
    And I enter invalid password "<password>"
    And I enter date "<Date>" month "<Month>" and year "<Year>" of birth
    And I enter SSN number "<SSN>"
    And I select credit as "Yes"
    And I click on account Continue button
    And I validate invalid Password "<password>"
    And I enter password "<password>" 
    And I click on account Continue button
    And I click on payNow
    And I should be at make payment page
    And I fill all card details as "<card>" and "<zip code>"
    And I click submit button on verify InformationPage
    And I click again click Continue button on account
    And I selected Yes for the review in order summary page
    Then I clicked submit order button
    Then I should able to submit order successfully
    Then I get account number from application

    Examples: 
      | Env | firstName | lastName | phoneNo    | address                              | email       |password| SMSNo      | Installation_option | Date | Month | Year | SSN       | card             | zip code | Device Quantity |easeOption|
      | E2E | Jones     | Smith    | 4029986730 | 3066 SHADY LN , LITTLETON, CO, 80126 | Ctl@Ctl.com | Auomation123 |4029986730 | STANDARD            |   02 |    02 | 1987 | 345038058 | 6011329842589845 |    37638 | 3 devices       |Basic ($0)|

