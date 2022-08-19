@EshopTestScripts @MACDScripts @EshopRegression @MACD_Move
Feature: MACD Scenarios for Move Remove

  #ATC_MACD_06
  @MACD_HSI_POTS_ESSENTIAL_REMOVE_POTS
  Scenario Outline: "ATC_MACD_06" HSI+POTS(Essential Home phone Bundle) during  MV remove POTS
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
    Then I select the device "Home Phone" "<removal_reason>"
    Then I select the best "<Installation_option>" installation option
    Then I select the number of device needed "<Device Quantity>"
    And I click continue button from existing products and move service page
    And I click again continue button in Customer Service Page
    Then I Add call Referal scheduling Move Order page
    And I click to reserve appointment
    And I click continue button in scheduling Move Order page
    And I click Continue button on account information page
    And I selected Yes for the review in order summary page

    #Then I clicked submit order button
    #Then I should able to submit order successfully
    #Then I get account number from application
    Examples: 
      | Env | firstName | lastName | phoneNo    | new_address                           | account number | Installation_option | Device Quantity |
      | E2E | Jones     | Smith    | 4029986730 | 611 FENWICK DR,PAPILLION,NE 68046,USA |      480075527 | STANDARD            | 2 devices       |

  #ATC_MACD_07
  @MACD_HSI_POT_ESSENTIAL_REMOVE_HSI
  Scenario Outline: "ATC_MACD_07" HSI+POTS( Essential Home phone Bundle) during  MV remove  HSI
    Given I should be on Eshop login screen
    When I enter username and password
    And I click on Account or Order already exists link
    And I enter the "<Env>" "<firstName>" "<lastName>" "<phoneNo>" in existing order view page
    And I enter only the completed account "<account number>"
    Then I click let's go button
    Then I should be in existing products page
    Then I select move service from other order activities
    And I enter new address and click validate "<new_address>"
    Then I select the device "HSI" "<removal_reason>"
    And I click continue button from existing products and move service page
    And I click again continue button in Customer Service Page
    And I click to reserve appointment
    And I click continue button in scheduling Move Order page
    And I click Continue button on account information page
    And I selected Yes for the review in order summary page
    ####  Then I clicked submit order button
    Then I should able to submit order successfully
    Then I get account number from application

    Examples: 
      | Env | firstName | lastName | phoneNo    | new_address                           | account number | Installation_option | Device Quantity |
      | E2E | Jones     | Smith    | 4029986730 | 611 FENWICK DR,PAPILLION,NE 68046,USA |      480075527 | STANDARD            | 2 devices       |

  #ATC_MACD_08
  @MACD_HSI_POTS_REMOVE_POTS
  Scenario Outline: "ATC_MACD_08" HSI +POTS  during MV remove POTS
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
    Then I select the device "Home Phone" "<removal_reason>"
    Then I select the best "<Installation_option>" installation option
    Then I select the number of device needed "<Device Quantity>"
    And I click continue button from existing products and move service page
    And I click again continue button in Customer Service Page
    Then I Add call Referal scheduling Move Order page
    And I click to reserve appointment
    And I click continue button in scheduling Move Order page
    And I click Continue button on account information page
    And I selected Yes for the review in order summary page

    # Then I clicked submit order button
    # Then I should able to submit order successfully
    # Then I get account number from application
    Examples: 
      | Env | firstName | lastName | phoneNo    | new_address                           | account number | Installation_option | Device Quantity |
      | E2E | Jones     | Smith    | 4029986730 | 611 FENWICK DR,PAPILLION,NE 68046,USA |      480075527 | STANDARD            | 2 devices       |

  #ATC_MACD_09
  @MACD_HSI_POT_REMOVE_HSI
  Scenario Outline: "ATC_MACD_09" HSI +POTS  during MV remove HSI
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
    Then I select the device "HSI" "<removal_reason>"
    And I click continue button from existing products and move service page
    And I click again continue button in Customer Service Page
    #Then I Add call Referal scheduling Move Order page
    And I click to reserve appointment
    And I click continue button in scheduling Move Order page
    And I click Continue button on account information page
    And I selected Yes for the review in order summary page

    #  Then I clicked submit order button
    #  Then I should able to submit order successfully
    #  Then I get account number from application
    Examples: 
      | Env | firstName | lastName | phoneNo    | new_address                           | account number | Installation_option | Device Quantity |
      | E2E | Jones     | Smith    | 4029986730 | 611 FENWICK DR,PAPILLION,NE 68046,USA |      480075527 | STANDARD            | 2 devices       |

  #ATC_MACD_10
  @MACD_HSI_CVOIP_MOVE_REMOVE_CVIOP_10
  Scenario Outline: "ATC_MACD_10" HSI +CVIOP  during MV remove CVIOP
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
    Then I select the device "DHP" "<removal_reason>"
    Then I select the best "<Installation_option>" installation option
    Then I select the number of device needed "<Device Quantity>"
    And I click continue button from existing products and move service page
    And I click again continue button in Customer Service Page
    #Then I Add call Referal scheduling Move Order page
    And I click to reserve appointment
    And I click continue button in scheduling Move Order page
    And I click Continue button on account information page
    And I selected Yes for the review in order summary page

    #Then I clicked submit order button
    #Then I should able to submit order successfully
    #Then I get account number from application
    Examples: 
      | Env | firstName | lastName | phoneNo    | new_address                          | account number | Installation_option | Device Quantity |
      | E2E | Jones     | Smith    | 4029986730 | 3066 SHADY LN , LITTLETON, CO, 80126 |      480076119 | STANDARD            | 2 devices       |
