@EshopTestScripts @MACDScripts @EshopRegression @MACD_Move
Feature: MACD Scenarios for Move 

 #TC366362
  @Verify_Billing_Options23
  Scenario Outline: verify reentrant of billing options "TC366362"
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
    Then I clicked submit order button
    Then I should able to submit order successfully
    Then I get account number from application

    Examples: 
  | Env | firstName | lastName | phoneNo  | Email |  address |Select_speed |  intallation_option  | SMSNo      |Modem option |Installation_option | Date | Month | Year | SSN    | zip code | Device Quantity |Ease option|Need new jacks or wiring? |
      | E2E | THOMAS     | HILLA   | 4529986578 | thm05@centurylink.com|3066 SHADY LN LITTLETON, CO 80126 | HSI Up to 100|Tech Install ($60)| 4029986730 |Leased Modem ($10/mo) |STANDARD      |   09 |    02 | 1987 | 666446831 | 37638 | 3 devices|Basic ($0) |No Work Is Needed ($0) |
      
#TC366362
  @Verify_Billing_Options23
  Scenario Outline: verify reentrant of billing options "TC366362"
    Given I should be on SFC login screen
    When I enter username and password
    Then I click on create new account
    Then I enter the "<firstName>" "<lastName>" "<phoneNo>" and "<address>" in new acquisition page
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
    Then I clicked submit order button
    Then I should able to submit order successfully
    Then I get account number from application

    Examples: 
      | Env | firstName | lastName | phoneNo    | Email                 | address                               | Select_speed  | intallation_option | SMSNo      | Modem option          | Installation_option | Date | Month | Year | SSN       | zip code | Device Quantity | Ease option | Need new jacks or wiring? |
      | E2E | THOMAS    | HILLA    | 4529986578 | thm05@centurylink.com | 334 W HATCHER RD,PHOENIX,AZ 85021,USA | HSI Up to 100 | Tech Install ($60) | 4029986730 | Leased Modem ($10/mo) | STANDARD            |   09 |    02 | 1987 | 666446831 |    37638 | 3 devices       | Basic ($0)  | No Work Is Needed ($0)    |

  #TC370700
  @Verify_Billing_Address_AccntInfo264
  Scenario Outline: MMP7778 - F26564- Verify re-entrant of billing address on Account Information page "TC370700"
    Given I should be on SFC login screen
    When I enter username and password
    Then I click on create new account
    Then I enter the "<firstName>" "<lastName>" "<phoneNo>" and "<address>" in new acquisition page
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
    Then I click on update billing address "<street address>" "<city>" "<zipcode>"
    And I click on account Continue button
    And I click again click Continue button on account
    And I selected Yes for the review in order summary page
    # And I click on account Continue button
    And I click again click Continue button on account
    #Then I verified billing address in Order Summary Page with "<street address>" and "<zipcode>"
    Then I clicked submit order button
    Then I should able to submit order successfully
    Then I get account number from application

    Examples: 
      | Env | firstName | lastName | phoneNo    | address                               | Select_speed          | Email      | SMSNo                 | Modem option | Installation_option | Date | Month | Year      | SSN   | zip code  | Device Quantity | Ease option            | Need new jacks or wiring? |
      | E2E | THOMAS    | HILLA    | 4529986578 | 334 W HATCHER RD,PHOENIX,AZ 85021,USA | thm05@centurylink.com | 4529986578 | Leased Modem ($10/mo) | STANDARD     |                  09 |   02 |  1987 | 666446831 | 37638 | 2 devices | Basic ($0)      | No Work Is Needed ($0) | No                        |

  # TC370724
  @Verify_re-entrant_of_FN_LN58
  Scenario Outline: Verify re-entrant of FN LN "TC370724"
    Given I should be on SFC login screen
    When I enter username and password
    Then I click on create new account
    Then I enter the "<firstName>" "<lastName>" "<phoneNo>" and "<address>" in new acquisition page
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
    And I enter date "<Date>" month "<Month>" and year "<Year>" of birth
    And I enter SSN number "<SSN>"
    And I select credit as "Yes"
    And I click on account Continue button
    And I click again click Continue button on account
    And I selected Yes for the review in order summary page
    And I clicked on back button in review Order page
    And I click on Update Application
    Then I re-entered FirstName "<changedFN>" LastName "<changedLN>" SMS "<changedSMS>"
    And I enter date "<changeddate>" month "<changedmonth>" and year "<changedyear>" of birth
    And I enter SSN number "<changedssn>"
    And I click on account Continue button
    #And I click on account Continue button
    And I click again click Continue button on account
    And I selected Yes for the review in order summary page
    And I click again click Continue button on account
    Then I clicked submit order button
    Then I should able to submit order successfully
    Then I get account number from application

    Examples: 
      | Env | firstName | lastName | phoneNo    | address                               | Select_speed                | Email       | SMSNo      | Modem option          | Installation_option | Date | Month | Year | SSN       | zip code | Device Quantity | Ease option | Need new jacks or wiring? | email address         | billing address                       | changedFN | changedLN | changedSMS | changedssn | changeddate | changedmonth | changedyear |
      | E2E | THOMAS    | HILLA    | 4529986756 | 1815 6TH AVE SE,ABERDEEN,SD 57401,USA | HSI Up to 1.5 Mbps/896 Kbps | Ctl@Ctl.com | 4029986730 | Leased Modem ($10/mo) | STANDARD            |   02 |    02 | 1987 | 666446831 |    37638 | 3 devices       | Basic ($0)  | No Work Is Needed ($0)    | anu22@centurylink.com | 334 W HATCHER RD,PHOENIX,AZ 85021,USA | DEBORAH   | BARKER    | 4568969800 |  666205849 |          22 |           08 |        1985 |

  # TC370703
  @Verify_the_re-entrant_of_Marketing_Preferences2/5
  Scenario Outline: Verify the re-entrant of Marketing Preferences "TC370703"
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
      | Env | firstName | lastName | phoneNo    | address                               | Select_speed                | Email       | SMSNo      | Modem option          | Installation_option | Date | Month | Year | SSN       | zip code | Device Quantity | Ease option | Need new jacks or wiring? | email address         | billing address                       |
      | E2E | THOMAS    | HILLA    | 4529986231 | 1815 6TH AVE SE,ABERDEEN,SD 57401,USA | HSI Up to 1.5 Mbps/896 Kbps | Ctl@Ctl.com | 4029986730 | Leased Modem ($10/mo) | STANDARD            |   02 |    02 | 1987 | 666446831 |    37638 | 3 devices       | Basic ($0)  | No Work Is Needed ($0)    | anu22@centurylink.com | 334 W HATCHER RD,PHOENIX,AZ 85021,USA |

