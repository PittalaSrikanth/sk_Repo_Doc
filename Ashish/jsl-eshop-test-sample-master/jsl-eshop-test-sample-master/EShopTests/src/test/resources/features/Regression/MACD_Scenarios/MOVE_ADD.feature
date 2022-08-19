@EshopTestScripts @MACDScripts @EshopRegression @MACD_Move
Feature: MACD Scenarios for Move Add

  #ATC_MACD_14
  @MACD_HSI_MOVE_ADD_POTS_NOPAY186
  Scenario Outline: "ATC_MACD_14" HSI  during  Move add POTS
    Given I should be on SFC login screen
    When I enter username and password
    #Below two commented steps are Future Ready steps for MACD Scenarios
    #Then I move back to existing SFC page
    #Then I search order in SFC page with account number
    Then I search order in SFC page with account number "<account number>"
    Then I click on order eshop button in SFC page to proceed to Eshop Page
    Then I should be in existing products page
    Then I select move service from other order activities
    And I enter new address and click validate "<new_address>"
    And I select HomePhone
    Then I select the best "<Installation_option>" installation option
    Then I select the number of device needed "<Device Quantity>"
    Then I select Your "<Modem option>" Modem option
    And I select "<Ease option>" Ease Option
    Then I select required option for voice mail "<Voice Mail>"
    #Then I select required option for Wire Maintenance Plan "<Wire Maintenance Plan>"
    Then I select required option for Port in a phone number? "<Port in a phone number?>"
    Then I select required option for Need new jacks or wiring? "<Need new jacks or wiring?>"
    And I click continue button from existing products and move service page
    And I click on continue button
    And I click again continue button in Customer Service Page
    And I click to reserve appointment
    And I click continue button in scheduling Move Order page
    Then I click on continue button on move Account page
    And I selected Yes for the review in order summary page
    Then I clicked submit order button
    Then I get account number from application
    #And I click Continue button on account information page
    

    #Then I clicked submit order button
    #Then I should able to submit order successfully
    #Then I get account number from application
    # with deposit 473708391
    Examples: 
      | Env | firstName | lastName | phoneNo    | new_address                           | account number | Installation_option | Device Quantity | Modem Option           | Ease Option |Voice Mail | Wire Maintenance Plan | Port in a phone number? | Need new jacks or wiring? |
      | E2E | Jones     | Smith    | 4029986730 | 1693 GARFIELD AVE, DUBUQUE,IA 52001,USA  |      686596103 | STANDARD         | 2 devices    | New Leased Modem ($10/mo) | BASIC        |No        | No                    | No                      | No Work Is Needed ($0)    |

  #ATC_MACD_15   account number = 473708391
  @MACD_HSI_MOVE_ADD_CVOIP_NOPAY17
  Scenario Outline: "ATC_MACD_15" HSI  during  MV add CVOIP
    Given I should be on SFC login screen
    When I enter username and password
    Then I search order in SFC page with account number "<account number>"
    Then I click on order eshop button in SFC page to proceed to Eshop Page
    Then I should be in existing products page
    Then I select move service from other order activities
    And I enter new address and click validate "<new_address>"
    And I select CVoip DHP phone
    And I select address info popup
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
    #And I click continue button in scheduling Move Order page
    #And I click Continue button on account information page
    Then I click on continue button on move Account page
    And I selected Yes for the review in order summary page
    Then I clicked submit order button
    ####  Then I clicked submit order button
    #Then I should able to submit order successfully
    #Then I get account number from application

    Examples: 
      | Env | firstName | lastName | phoneNo    | new_address                          | account number | Installation_option | Device Quantity |Modem Option|Ease Option|Need new jacks or wiring?|removal_reason|Additional Order Remarks|
      | E2E | Jones     | Smith    | 4029986730 | 3066 SHADY LN , LITTLETON, CO, 80126 |     686613445 | STANDARD            | 2 devices       |New Leased Modem ($10/mo) |BASIC |No Work Is Needed ($0) |MOVED |ESHOP ORDER TEST BY AUTOMATION |

  #Reference OrderNumber :1000034086  Account Number:
  #ATC_MACD_16  with deposit 473678838
  @MACD_POT_MOVE_ADD_HSI_NOPAY
  Scenario Outline: "ATC_MACD_16" POTS during  MV  Add H S I
    Given I should be on SFC login screen
    When I enter username and password
    #Below two commented steps are Future Ready steps for MACD Scenarios
    #Then I move back to existing SFC page
    #Then I search order in SFC page with account number
    Then I search order in SFC page with account number "<account number>"
    Then I click on order eshop button in SFC page to proceed to Eshop Page
    Then I should be in existing products page
    Then I select move service from other order activities
    And I enter new address and click validate "<new_address>"
    And I select Internet
    Then I select the best "<Installation_option>" installation option
    Then I select the number of device needed "<Device Quantity>"
    And I click continue button from existing products and move service page
    And I click again continue button in Customer Service Page
    And I click to reserve appointment
    And I click continue button in scheduling Move Order page
    And I click Continue button on account information page
    And I selected Yes for the review in order summary page

    #Then I clicked submit order button
    #Then I should able to submit order successfully
    # Then I get account number from application
    Examples: 
      | Env | firstName | lastName | phoneNo    | new_address                          | account number | Installation_option | Device Quantity |
      | E2E | Jones     | Smith    | 4029986730 | 3066 SHADY LN , LITTLETON, CO, 80126 |      480076368 | STANDARD            | 2 devices       |

  # Payment >>>>>>>>>>>>>>>>>>>>>>>
  #ATC_MACD_14
  @MACD_HSI_MOVE_ADD_POTS_WITHPAY_14
  Scenario Outline: "ATC_MACD_14" HSI  during  Move add POTS
    Given I should be on SFC login screen
    When I enter username and password
    #Below two commented steps are Future Ready steps for MACD Scenarios
    #Then I move back to existing SFC page
    #Then I search order in SFC page with account number
    Then I search order in SFC page with account number "<account number>"
    Then I click on order eshop button in SFC page to proceed to Eshop Page
    Then I should be in existing products page
    Then I select move service from other order activities
    And I enter new address and click validate "<new_address>"
    And I select HomePhone
    Then I select the best "<Installation_option>" installation option
    Then I select the number of device needed "<Device Quantity>"
    And I click continue button from existing products and move service page
    And I click again continue button in Customer Service Page
    And I click to reserve appointment
    And I click continue button in scheduling Move Order page
    And I click on payNow
    And I should be at make payment page
    And I fill all card details as "<card>" and "<zip code>"
    And I click submit button on verify InformationPage
    And I click Continue button on account information page
    And I selected Yes for the review in order summary page

    #Then I clicked submit order button
    #Then I should able to submit order successfully
    #Then I get account number from application
    # with deposit 473708391
    Examples: 
      | Env | firstName | lastName | phoneNo    | new_address                           | account number | Installation_option | Device Quantity | card             | zip code |
      | E2E | Jones     | Smith    | 4029986730 | 611 FENWICK DR,PAPILLION,NE 68046,USA |      480075505 | STANDARD            | 2 devices       | 4485389438108352 |    37638 |

  #ATC_MACD_15   account number = 473708391
  @MACD_HSI_MOVE_ADD_CVOIP_WITHPAY
  Scenario Outline: "ATC_MACD_15" HSI  during  MV add CVOIP
    Given I should be on SFC login screen
    When I enter username and password
    #Below two commented steps are Future Ready steps for MACD Scenarios
    #Then I move back to existing SFC page
    #Then I search order in SFC page with account number
    Then I search order in SFC page with account number "<account number>"
    Then I click on order eshop button in SFC page to proceed to Eshop Page
    Then I should be in existing products page
    Then I select move service from other order activities
    And I enter new address and click validate "<new_address>"
    And I select CVoip DHP phone
    And I select address info popup
    Then I select the best "<Installation_option>" installation option
    Then I select the number of device needed "<Device Quantity>"
    And I click continue button from existing products and move service page
    And I click again continue button in Customer Service Page
    And I click to reserve appointment
    And I click continue button in scheduling Move Order page
    And I click on payNow
    And I should be at make payment page
    And I fill all card details as "<card>" and "<zip code>"
    And I click submit button on verify InformationPage
    And I click Continue button on account information page
    And I selected Yes for the review in order summary page

    #Then I clicked submit order button
    #Then I should able to submit order successfully
    #Then I get account number from application
    Examples: 
      | Env | firstName | lastName | phoneNo    | new_address                           | account number | Installation_option | Device Quantity | card             | zip code |
      | E2E | Jones     | Smith    | 4029986730 | 611 FENWICK DR,PAPILLION,NE 68046,USA |      480075505 | STANDARD            | 2 devices       | 4485389438108352 |    37638 |

  #ATC_MACD_16  with deposit 473678838
  @MACD_POT_MOVE_ADD_HSI_WITHPAY
  Scenario Outline: "ATC_MACD_16" POTS during  MV  Add H S I
    Given I should be on SFC login screen
    When I enter username and password
    #Below two commented steps are Future Ready steps for MACD Scenarios
    #Then I move back to existing SFC page
    #Then I search order in SFC page with account number
    Then I search order in SFC page with account number "<account number>"
    Then I click on order eshop button in SFC page to proceed to Eshop Page
    Then I should be in existing products page
    Then I select move service from other order activities
    And I enter new address and click validate "<new_address>"
    And I select Internet
    Then I select the best "<Installation_option>" installation option
    Then I select the number of device needed "<Device Quantity>"
    And I click continue button from existing products and move service page
    And I click again continue button in Customer Service Page
    And I click to reserve appointment
    And I click continue button in scheduling Move Order page
    And I click on payNow
    And I should be at make payment page
    And I fill all card details as "<card>" and "<zip code>"
    And I click submit button on verify InformationPage
    And I click Continue button on account information page
    And I selected Yes for the review in order summary page

    #Then I clicked submit order button
    #Then I should able to submit order successfully
    #Then I get account number from application
    Examples: 
      | Env | firstName | lastName | phoneNo    | new_address                          | account number | Installation_option | Device Quantity | card             | zip code |
      | E2E | Jones     | Smith    | 4029986730 | 3066 SHADY LN , LITTLETON, CO, 80126 |      480076222 | STANDARD            | 2 devices       | 4485389438108352 |    37638 |
