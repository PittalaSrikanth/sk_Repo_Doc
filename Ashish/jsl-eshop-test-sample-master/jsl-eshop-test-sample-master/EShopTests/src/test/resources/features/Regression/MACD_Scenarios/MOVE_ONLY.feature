@EshopTestScripts @MACDScripts @EshopRegression @MACD_Move
Feature: MACD Scenarios for Move only

  ###  non payment ref : 473724062
  #ATC_MACD_20
  @MACD_POT_ONLY_MOVE23
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
    Then I select required option for voice mail "<Voice Mail>"
    Then I select required option for Wire Maintenance Plan "<Wire Maintenance Plan>"
    Then I select required option for Port in a phone number? "<Port in a phone number?>"
    Then I select required option for Need new jacks or wiring? "<Need new jacks or wiring?>"
    And I click continue button from existing products and move service page
    And I click on continue button
    And I click again continue button in Customer Service Page
    #And I click to reserve appointment
    And I click on continue button of scheduling page
    Then I click on continue button on move Account page
    And I selected Yes for the review in order summary page
    Then I clicked submit order button
    Then I get account number from application

    #Then I clicked submit order button
    # Then I should able to submit order successfully
    # Then I get account number from application
    Examples: 
      | Env | firstName | lastName | phoneNo    | account number | new_address                          |Voice Mail|Wire Maintenance Plan |Port in a phone number?   |     Need new jacks or wiring? | Additional Order Remarks|
      | E2E | Jones     | Smith    | 4029986730 |      686581800 | 3066 SHADY LN , LITTLETON, CO, 80126 | No       | No                   |      No    |                  No Work Is Needed ($0)|                     ESHOP ORDER TEST BY AUTOMATION |

  #ATC_MACD_19
  @MACD_HSI_ONLY_634
  Scenario Outline: "ATC_MACD_19" HSI  Move Only
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
    # 473708391 PP4: 686606253
    Examples: 
      | Env | firstName | lastName | phoneNo    | new_address                                | account number | Installation_option |Modem Option   |     Ease Option |Device Quantity |Need new jacks or wiring?| removal_reason |Additional Order Remarks |
      | E2E | Jones     | Smith    | 4029484735 | 11965 TIFFANY LN,EDEN PRAIRIE,MN 55344,USA |   686606253    | STANDARD            | New Leased Modem ($10/mo)|BASIC |   2 devices       |  No Work Is Needed ($0)| MOVED |ESHOP ORDER TEST BY AUTOMATION |

      
  @MACD_HSIANDCVOIP_Move618
  Scenario Outline: "ATC_MACD_19" HSI  Move Only
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
      | Env | firstName | lastName | phoneNo    | new_address                                | account number | Installation_option |Modem Option   |     Ease Option |Device Quantity |Need new jacks or wiring?| removal_reason |Additional Order Remarks |
      | E2E | Jones     | Smith    | 4029484721 | 11965 TIFFANY LN,EDEN PRAIRIE,MN 55344,USA |   686596523   | STANDARD            | New Leased Modem ($10/mo)|BASIC |   2 devices       |  No Work Is Needed ($0)| MOVED |ESHOP ORDER TEST BY AUTOMATION |