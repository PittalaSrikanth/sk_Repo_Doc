@EshopTestScripts @EShopUAT_Automation
Feature: CR6141 - Display Disclosures throughout EShop ordering experience

  #TC379322
  @TC379322_UAT
  Scenario Outline: eShop F32417: Verify that when HIS NI product is selected on ESHOP Product-offer Page applicable disclosure is selected
    Given I should be on SFC login screen
    When I enter username and password
    Then I click on create new account
    Then I enter the "<firstName>" "<lastName>" "<Email>" "<phoneNo>" and "<address>" in new acquisition page
    Then I selected "<Residence>" option
    Then I validate the address and save it
    Then I click on order eshop button
    Then I should be in Eshop Product offer page
    Then I select the best "<Installation_option>" installation option
    Then I select the number of device needed "<Device Quantity>"
    And I select Your "<Modem_Option>" Modem option
    And I select "<Ease_Option>" Ease Option
    Then I select required option for Need new jacks or wiring? "<Need new jacks or wiring?>"
    And I click on continue button
    Then I should be in customize service page
    And I click again on contine button
    And I click to reserve appointment
    And I click on continue button of scheduling page
    And I enter date "<Date>" month "<Month>" and year "<Year>" of birth
    And I enter SSN number "<SSN>"
    And I select credit as "Yes"
    And I click on account Continue button
    And I click again click Continue button on account
    And I selected Yes for the review in order summary page
    Then I enter the special remark in Additional Order Remarks field "<Additional Order Remarks>"
    Then I clicked submit order button

    Examples: 
      | firstName | lastName | phoneNo    | Email                 | address                                    | Residence | Installation_option | Modem_Option | Ease_Option | Device Quantity | Date | Month | Year | SSN       | card             | zip code | Additional Order Remarks           | Need new jacks or wiring? |
      | THOMAS    | HILLA    | 4032774343 | thr12@centurylink.com | 11965 TIFFANY LN,EDEN PRAIRIE,MN 55344,USA | Own       | STANDARD            | LEASE        | BASIC       | 2 devices       |   01 |    02 | 1987 | 666446831 | 4485389438108352 |    37638 | ESHOP UAT ORDER TEST BY AUTOMATION | No Work Is Needed ($0)    |

  @TC379324
  Scenario Outline: F32814: Verify that Price for Life Disclosure is displayed for HIS + CVOIP  on ESHOP Product-offer Page
    Given I should be on SFC login screen
    When I enter username and password
    Then I click on create new account
    Then I enter the "<firstName>" "<lastName>" "<Email>" "<phoneNo>" and "<address>" in new acquisition page
    Then I selected "<Residence>" option
    Then I validate the address and save it
    Then I click on order eshop button
    Then I should be in Eshop Product offer page
    And I select CVoip DHP phone
    And I select address info popup
    Then I select the best "<Installation_option>" installation option
    Then I select the number of device needed "<Device Quantity>"
    And I select Your "<Modem_Option>" Modem option
    And I select "<Ease_Option>" Ease Option
    And I click on continue button

    Examples: 
      | firstName | lastName | phoneNo    | Email                 | address                                 | Residence | Installation_option | Modem_Option | Ease_Option | Device Quantity | Date | Month | Year | SSN       | card             | zip code | Additional Order Remarks           | Need new jacks or wiring? |
      | THOMAS    | HILLA    | 4032774343 | thr12@centurylink.com | 1693 GARFIELD AVE, DUBUQUE,IA 52001,USA | Own       | STANDARD            | LEASE        | BASIC       | 2 devices       |   01 |    02 | 1987 | 666446831 | 4485389438108352 |    37638 | ESHOP UAT ORDER TEST BY AUTOMATION | No Work Is Needed ($0)    |

  @TC379332_POTS
  Scenario Outline: F32814 -Verify that special Disclosure displayed on Scheduling page for POTS
    Given I should be on SFC login screen
    When I enter username and password
    Then I click on create new account
    Then I enter the "<firstName>" "<lastName>" "<Email>" "<phoneNo>" and "<address>" in new acquisition page
    Then I selected "<Residence>" option
    Then I validate the address and save it
    Then I click on order eshop button
    Then I should be in Eshop Product offer page
    And I select HomePhone only by deselecting Internet
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

    Examples: 
      | firstName | lastName | phoneNo    | address                                 | Email       | SMSNo      | Date | Month | Year | SSN       | card             | zip code | Voice Mail | Wire Maintenance Plan | Port in a phone number? | Need new jacks or wiring? | Additional Order Remarks       |
      | MARIANNE  | HELTON   | 4029986730 | 1693 GARFIELD AVE, DUBUQUE,IA 52001,USA | Ctl@Ctl.com | 4029986730 |   02 |    02 | 1987 | 666150907 | 4485389438108352 |    37638 | No         | No                    | No                      | No Work Is Needed ($0)    | ESHOP ORDER TEST BY AUTOMATION |

  @TC379340_chPOTS
  Scenario Outline: F32814- Verify that disclosures is applicable to new products added on the Change order and not for an existing product on account-Change Order
    Given I should be on SFC login screen
    When I enter username and password
    #Below two commented steps are Future Ready steps for MACD Scenarios
    #Then I move back to existing SFC page
    #Then I search order in SFC page with account number
    Then I search order in SFC page with account number "<account number>"
    Then I click on order eshop button in SFC page to proceed to Eshop Page
    Then I should be in existing products page
    Then I click on Make changes button
    Then I Add the new products POTS
    Then I select required option for voice mail "<Voice Mail>"
    Then I select required option for Wire Maintenance Plan "<Wire Maintenance Plan>"
    Then I select required option for Port in a phone number? "<Port in a phone number?>"
    Then I select required option for Need new jacks or wiring? "<Need new jacks or wiring?>"
    And I click on continue button

    Examples: 
      | firstName | lastName | phoneNo    | address                               | account number | email       | SMSNo      | Date | Month | Year | SSN       | card             | zip code | Voice Mail | Wire Maintenance Plan | Port in a phone number? | Need new jacks or wiring? | Additional Order Remarks       |
      | MARIANNE  | HELTON   | 4029986730 | 611 FENWICK DR,PAPILLION,NE 68046,USA |      578641882 | Ctl@Ctl.com | 4029986730 |   02 |    02 | 1987 | 666150907 | 4485389438108352 |    37638 | No         | No                    | No                      | No Work Is Needed ($0)    | ESHOP ORDER TEST BY AUTOMATION |

  @TC379336_MOVE
  Scenario Outline: F32814-Verify that disclosure is applicable to the Products ordered at the new address and that must not at the old address-Move
    Given I should be on SFC login screen
    When I enter username and password
    Then I search order in SFC page with account number "<account number>"
    Then I click on order eshop button in SFC page to proceed to Eshop Page
    Then I should be in existing products page
    Then I select move service from other order activities
    And I enter new address and click validate "<new_address>"
    Then I select the best "<Installation_option>" installation option
    Then I select the number of device needed "<Device Quantity>"
    Then I select Your "<Modem option>" Modem option
    And I select "<Ease option>" Ease Option
    Then I select required option for Need new jacks or wiring? "<Need new jacks or wiring?>"
    And I click continue button from existing products and move service page
    And I click on continue button
    And I click again continue button in Customer Service Page
    And I click to reserve appointment
    And I click on continue button of scheduling page
    Then I click on continue button on move Account page
    And I selected Yes for the review in order summary page
    Then I clicked submit order button
    Then I get account number from application

    Examples: 
      | Env | firstName | lastName | phoneNo    | new_address                                | account number | Installation_option | Modem Option              | Ease Option | Device Quantity | Need new jacks or wiring? | removal_reason | Additional Order Remarks       |
      | E2E | Jones     | Smith    | 4029484721 | 11965 TIFFANY LN,EDEN PRAIRIE,MN 55344,USA |      686596523 | STANDARD            | New Leased Modem ($10/mo) | BASIC       | 2 devices       | No Work Is Needed ($0)    | MOVED          | ESHOP ORDER TEST BY AUTOMATION |

  @TC379335
  Scenario Outline: F32814-Validate that disclosure is set only only if changes are made
    Given I should be on SFC login screen
    When I enter username and password
    Then I click on create new account
    Then I enter the "<firstName>" "<lastName>" "<Email>" "<phoneNo>" and "<address>" in new acquisition page
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

  @TC379380
  Scenario Outline: F32814- Verify that disclosures is applicable to new products added on the B&R Order  and not for an existing product on account-Billing & Record Order
    Given I should be on SFC login screen
    When I enter username and password
    Then I search order in SFC page with account number "<account number>"
    Then I click on order eshop button in SFC page to proceed to Eshop Page
    Then I should be in existing products page
    Then I select move service from other order activities
    Then I select Billing and Response from other order activities
    And I select CVoip DHP phone
    And I select address info popup
    Then I select the best "<Installation_option>" installation option
    Then I select the number of device needed "<Device Quantity>"
    Then I select Your "<Modem option>" Modem option
    And I select "<Ease option>" Ease Option
    Then I select required option for Need new jacks or wiring? "<Need new jacks or wiring?>"
    And I click continue button from existing products and move service page
    And I click on continue button

    Examples: 
      | Env | firstName | lastName | phoneNo    | new_address                          | account number | Installation_option | Device Quantity | Modem Option              | Ease Option | Need new jacks or wiring? | removal_reason | Additional Order Remarks       |
      | E2E | Jones     | Smith    | 4029986730 | 3066 SHADY LN , LITTLETON, CO, 80126 |      686613445 | STANDARD            | 2 devices       | New Leased Modem ($10/mo) | BASIC       | No Work Is Needed ($0)    | MOVED          | ESHOP ORDER TEST BY AUTOMATION |
