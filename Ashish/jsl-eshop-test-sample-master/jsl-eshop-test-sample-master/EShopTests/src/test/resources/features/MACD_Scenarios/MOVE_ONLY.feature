@EshopTestScripts @MACDScripts @EshopRegression @MACD_Move
Feature: MACD Scenarios for Move only

  ###  non payment ref : 473724062
  #ATC_MACD_20
  @MACD_POT_ONLY_MOVE
  Scenario Outline: "ATC_MACD_20" POTS move only
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
    And I click continue button from existing products and move service page
    And I click again continue button in Customer Service Page
    And I click continue button in scheduling Move Order page
    And I click Continue button on account information page
    And I selected Yes for the review in order summary page

    #Then I clicked submit order button
    # Then I should able to submit order successfully
    # Then I get account number from application
    Examples: 
      | Env | firstName | lastName | phoneNo    | account number | new_address                          |
      | E2E | Jones     | Smith    | 4029986730 |      480076368 | 3066 SHADY LN , LITTLETON, CO, 80126 |

  #ATC_MACD_19
  @MACD_HSI_ONLY_19
  Scenario Outline: "ATC_MACD_19" HSI  Move Only
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
    Then I select the best "<Installation_option>" installation option
    Then I select the number of device needed "<Device Quantity>"
    And I click continue button from existing products and move service page
    And I click again continue button in Customer Service Page
    And I click to reserve appointment
    And I click continue button in scheduling Move Order page
    And I click Continue button on account information page
    And I selected Yes for the review in order summary page

    #Then I clicked submit order button
    # Then I should able to submit order successfully
    # Then I get account number from application
    # 473708391
    Examples: 
      | Env | firstName | lastName | phoneNo    | new_address                           | account number | Installation_option | Device Quantity | removal_reason |
      | E2E | Jones     | Smith    | 4029986730 | 611 FENWICK DR,PAPILLION,NE 68046,USA |      480030739 | STANDARD            | 2 devices       | MOVED          |
