@EshopTestScripts @MACDScripts @EshopRegression @MACD_Move
Feature: add authorized parties with multiple changes to a customer's account in the new acquisition flow for HSI Product

@Verify_the_re-entrant_of_Marketing_Preferences_HSI_TC390276
  Scenario Outline:Verify user able to add authorized parties with multiple changes to a customer's account in the new acquisition flow for HSI Product "TC390276"
    Given I should be on SFC login screen
    When I enter username and password
    Then I click on create new account
    Then I enter the "<firstName>" "<lastName>" "<phoneNo>" "<Email>" and "<address>" in new acquisition page
    Then I validate the address and save it
    Then I click on order eshop button
    Then I should be in Eshop Product offer page
    Then I select the best "<Installation_option>" installation option
    Then I select the number of device needed "<Device Quantity>"
    Then I select Your "<Modem option>" Modem option
    And I select "<Ease option>" Ease Option
    Then I select required option for Need new jacks or wiring? "<Need new jacks or wiring?>"    
    And I click on continue button
    Then I should be in customize service page
    And I click again on contine button
    And I click to reserve appointment
    And I click on continue button of scheduling page
    #And I enter "<email>" and "<SMSNo>"
    Then I clicked on add change button
    Then I added Authorized Parties "<Authfn>" "<Authln>" "<Authcntct>"
    And I enter date "<Date>" month "<Month>" and year "<Year>" of birth
    And I enter SSN number "<SSN>"
    And I select credit as "Yes"
    And I click on account Continue button
    And I click again click Continue button on account
    And I selected Yes for the review in order summary page
    And I clicked on back button in review Order page
    And I click on Update Application
    Then I selected Marketing Preferences
    And I enter date "<Date>" month "<Month>" and year "<Year>" of birth
    And I enter SSN number "<SSN>"
    And I click on account Continue button
    And I click again click Continue button on account
    And I selected Yes for the review in order summary page
    And I click again click Continue button on account
    Then I clicked submit order button
    Then I should able to submit order successfully
    Then I get account number from application
    
    Examples: 
      | Env | firstName | lastName | phoneNo    | address                              |Select_speed |          Email                     | SMSNo      |Modem option |Installation_option | Date | Month | Year | SSN |Authfn|Authln |Authcntct|zip code | Device Quantity |Ease option|Need new jacks or wiring? |email address | billing address|
      | E2E | THOMAS    | HILLA    | 4529885743 |3066 SHADY LN LITTLETON, CO 80126,USA | HSI Up to 1.5 Mbps/896 Kbps|Ctlq464@Ctl.com | 4029786730 |Leased Modem ($10/mo) |STANDARD |   02 |    02 | 1987 | 666446831  | Peter| Test| 543-765-8900 |37638 | 3 devices       |Basic ($0) |No Work Is Needed ($0) |anu22@centurylink.com|334 W HATCHER RD,PHOENIX,AZ 85021,USA|
   
  
 @Verify_Billing_Options29_TC390278
  Scenario Outline: Verify user able to add authorized parties with multiple changes to a customer's account in the new acquisition flow for POTS Product "TC390278"
    Given I should be on SFC login screen
    When I enter username and password
    Then I click on create new account
    Then I enter the "<firstName>" "<lastName>" "<phoneNo>" "<Email>" and "<address>" in new acquisition page
    Then I selected "<Residence>" option
    Then I validate the address and save it
    Then I click on order eshop button
    Then I should be in Eshop Product offer page
    Then I select the best "<Installation_option>" installation option
    Then I select the number of device needed "<Device Quantity>"
    Then I select Your "<Modem option>" Modem option
    And I select "<Ease option>" Ease Option
    Then I select required option for Need new jacks or wiring? "<Need new jacks or wiring?>"    
    And I click on continue button
    Then I should be in customize service page
    And I click again on contine button
    And I click to reserve appointment
    And I click on continue button of scheduling page
    #And I enter "<email>" and "<SMSNo>"
    Then I clicked on add change button
    Then I added Authorized Parties "<Authfn>" "<Authln>" "<Authcntct>"
    And I enter date "<Date>" month "<Month>" and year "<Year>" of birth
    And I enter SSN number "<SSN>"
    And I select credit as "Yes"
    And I click on account Continue button
    #And I click on payNow
    #And I should be at make payment page
    #And I fill all card details as "<card>" and "<zip code>"
    #And I click submit button on verify InformationPage
    And I click again click Continue button on account
    And I selected Yes for the review in order summary page
    And I clicked on back button in review Order page
    And I click on Update Application
    And I select Mail my bill
    And I click on account Continue button 
    And I click again click Continue button on account
    And I selected Yes for the review in order summary page
    And I click again click Continue button on account
    Then I validated Auth User "<Authfn>" on Order Summary Page
    Then I clicked submit order button
    Then I should able to submit order successfully
    Then I get account number from application
     Examples: 
      | Env | firstName | lastName | phoneNo    | address                              |Select_speed |          Email                     | SMSNo      |Modem option |Installation_option | Date | Month | Year | SSN |Authfn|Authln |Authcntct| zip code | Device Quantity |Ease option|Need new jacks or wiring? |email address | billing address| authName|
      | E2E | THOMAS    | HILLA    | 4526358943 |3066 SHADY LN LITTLETON, CO 80126,USA | HSI Up to 1.5 Mbps/896 Kbps|Ctl5464@Ctl.com | 4029786730 |Leased Modem ($10/mo) |STANDARD |   02 |    02 | 1987 | 666446831  | Peter |Test |546-789-9876|37638 | 3 devices       |Basic ($0) |No Work Is Needed ($0) |anu22@centurylink.com|334 W HATCHER RD,PHOENIX,AZ 85021,USA|Peter|
      
   @Verify_re-entrant_of_FN_LN58_POTS_TC390278
  Scenario Outline: Verify user able to add authorized parties with multiple changes to a customer's account in the new acquisition flow for POTS Product "TC390278"
    Given I should be on SFC login screen
    When I enter username and password
    Then I click on create new account
    Then I enter the "<firstName>" "<lastName>" "<phoneNo>" "<Email>" and "<address>" in new acquisition page
    Then I validate the address and save it
    Then I click on order eshop button
    Then I should be in Eshop Product offer page
    And I select HomePhone only by deselecting Internet
    Then I select required option for voice mail "<Voice Mail>"
    Then I select required option for Wire Maintenance Plan "<Wire Maintenance Plan>"
    Then I select required option for Port in a phone number? "<Port in a phone number?>"
    Then I select required option for Need new jacks or wiring? "<Need new jacks or wiring?>"      
    And I click on continue button
    Then I should be in customize service page
    And I click again on contine button
    And I click to reserve appointment
    And I click on continue button of scheduling page
    #And I enter "<email>" and "<SMSNo>"
    Then I clicked on add change button
    Then I added Authorized Parties "<Authfn>" "<Authln>" "<Authcntct>"
    And I enter date "<Date>" month "<Month>" and year "<Year>" of birth
    And I enter SSN number "<SSN>"
    And I select credit as "Yes"
    And I click on account Continue button
    And I click again click Continue button on account
    And I selected Yes for the review in order summary page
    And I clicked on back button in review Order page
    And I click on Update Application
    Then I re-entered FirstName "<changedFN>" LastName "<changedLN>" SMS "<changedSMS>"
    And I enter date " <changeddate >" month "<changedmonth >" and year "<changedyear >" of birth
    And I enter SSN number "<changedssn >"
    And I click on account Continue button
   #And I click on account Continue button
    And I click again click Continue button on account
    And I selected Yes for the review in order summary page
    And I click again click Continue button on account
    Then I validated Auth User "<Authfn>" on Order Summary Page
    Then I clicked submit order button
    Then I should able to submit order successfully
    Then I get account number from application 
     
     Examples: 
      | Env | firstName | lastName | phoneNo    | address                              |Select_speed |                 Email       | SMSNo      |Modem option |Installation_option | Date | Month | Year | SSN  |Authfn | Authln|Authcntct |zip code | Device Quantity |Ease option|Need new jacks or wiring? |email address | billing address|                         changedFN | changedLN |changedSMS |    changedssn |       changeddate |changedmonth|changedyear|
       |E2E | THOMAS     | HILLA   | 4529986756 | 1815 6TH AVE SE,ABERDEEN,SD 57401,USA | HSI Up to 1.5 Mbps/896 Kbps|Ctl@Ctl.com | 4029986730 |Leased Modem ($10/mo) |STANDARD |   02 |    02 | 1987 | 666446831 | Tom|Test|532-890-7654 |37638 | 3 devices       |Basic ($0) |No Work Is Needed ($0) |anu22@centurylink.com|334 W HATCHER RD,PHOENIX,AZ 85021,USA| DEBORAH  | BARKER   |4568969800|     666205849   |                   22       |08          |1985 |
    
    @TC390283_Verify_Billing_Address_AccntInfo264_CVOIP
  Scenario Outline: Verify user able to add authorized parties with multiple changes to a customer's account in the new acquisition flow for HSI + CVOIP Product "TC390283"
    Given I should be on SFC login screen
    When I enter username and password
    Then I click on create new account
     Then I enter the "<firstName>" "<lastName>" "<phoneNo>" "<Email>" and "<address>" in new acquisition page
    Then I validate the address and save it
    Then I click on order eshop button
    Then I should be in Eshop Product offer page
    And I select CVoip DHP phone
    And I select address info popup
    Then I select the best "<Installation_option>" installation option
    Then I select the number of device needed "<Device Quantity>"
    Then I select Your "<Modem option>" Modem option
    And I select "<Ease option>" Ease Option
    Then I select required option for Need new jacks or wiring? "<Need new jacks or wiring?>"    
    And I click on continue button
    Then I should be in customize service page
    And I click again on contine button
    And I click to reserve appointment
    And I click on continue button of scheduling page
    #And I enter "<email>" and "<SMSNo>"
    Then I clicked on add change button
    Then I added Authorized Parties "<Authfn>" "<Authln>" "<Authcntct>"
    And I enter date "<Date>" month "<Month>" and year "<Year>" of birth
    And I enter SSN number "<SSN>"
    And I select credit as "Yes"
    And I click on account Continue button
    #And I click on payNow
    #And I should be at make payment page
    #And I fill all card details as "<card>" and "<zip code>"
    #And I click submit button on verify InformationPage
    And I click again click Continue button on account
    And I selected Yes for the review in order summary page
    And I clicked on back button in review Order page
    And I click on Update Application
    #Then I reenter email "<email address>" in Account information page
    Then I click on change billing address
    Then I click on update billing address "<street address>" "<city>" "<zip code>"
    And I click on account Continue button 
    And I click again click Continue button on account
    And I selected Yes for the review in order summary page
   # And I click on account Continue button
    And I click again click Continue button on account
    #Then I verified billing address in Order Summary Page with "<street address>" and "<zip code>"
    Then I validated Auth User "<Authfn>" on Order Summary Page
    Then I clicked submit order button
    Then I should able to submit order successfully
    Then I get account number from application
    
     Examples: 
    | Env | firstName | lastName | phoneNo    | address                              |Select_speed |          Email                     | SMSNo      |Modem option |Installation_option | Date | Month | Year | SSN |Authfn |Authln |Authcntct |zip code | Device Quantity |Ease option|Need new jacks or wiring? |email address | billing address|
      | E2E | THOMAS    | HILLA    | 4529985243 |3066 SHADY LN LITTLETON, CO 80126,USA | HSI Up to 1.5 Mbps/896 Kbps|Ctl5464@Ctl.com | 4029786730 |Leased Modem ($10/mo) |STANDARD |   02 |    02 | 1987 | 666446831  | Tom |Test |567-765-6789 |37638 | 3 devices       |Basic ($0) |No Work Is Needed ($0) |anu22@centurylink.com|334 W HATCHER RD,PHOENIX,AZ 85021,USA|
   