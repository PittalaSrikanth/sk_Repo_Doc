@EshopTestScripts @MACDScripts @EshopRegression @MACD_Change
Feature: MACD Scenarios on Change only

  # Feature file for NON PAYMENT MACD SCENARIOS STARTS>>>>>>>>>>>>>
  #ATC_MACD_01
  @ATC_MACD_1706
  Scenario Outline: MACD Scenario on H S I Speed Change
    Given I should be on SFC login screen
    When I enter username and password
    #Below two commented steps are Future Ready steps for MACD Scenarios
    #Then I move back to existing SFC page
    #Then I search order in SFC page with account number
    Then I search order in SFC page with account number "<account number>"
    Then I click on order eshop button in SFC page to proceed to Eshop Page
    Then I should be in existing products page
    Then I click on Make changes button
    Then I select the Available speed on change order "<Select_speed>"
    And I select Your "<Modem_Option>" Modem option
    And I click on continue button
    Then I should be in customize service page
    And I click again on contine button
    And I click on continue button of scheduling page
    And I click on continue button change account page
    And I selected Yes for the review in order summary page

    #Then I clicked submit order button
    #Then I should able to submit order successfully
    # Then I get account number from application
    Examples: 
      | Env | firstName | lastName | phoneNo    | account number | Select_speed              | Modem_Option |
      | E2E | Jones     | Smith    | 4029986730 |      578397443 | HSI Up to 80 Mbps/10 Mbps | Lease        | 

  #ATC_MACD_01
  @ATC_MACD_18
  Scenario Outline: MACD Scenario on POTS CH Order
    Given I should be on SFC login screen
    When I enter username and password
    #Below two commented steps are Future Ready steps for MACD Scenarios
    #Then I move back to existing SFC page
    #Then I search order in SFC page with account number
    Then I search order in SFC page with account number "<account number>"
    Then I click on order eshop button in SFC page to proceed to Eshop Page
    Then I should be in existing products page
    Then I click on Make changes button
    Then I Remove the existing product POTS
    And I click on continue button
    Then I should be in customize service page
    And I click again on contine button
    And I click on continue button of scheduling page
    And I selected Yes for the review in order summary page

    # Then I clicked submit order button
    # Then I should able to submit order successfully
    # Then I get account number from application
    Examples: 
      | Env | firstName | lastName | phoneNo    | account number |
      | E2E | Jones     | Smith    | 4029986730 |      480028031 |

  #ATC_MACD_01
  @ATC_MACD_25
  Scenario Outline: MACD Scenario on POTS CH order with directory
    Given I should be on SFC login screen
    When I enter username and password
    #Below two commented steps are Future Ready steps for MACD Scenarios
    #Then I move back to existing SFC page
    #Then I search order in SFC page with account number
    Then I search order in SFC page with account number "<account number>"
    Then I click on order eshop button in SFC page to proceed to Eshop Page
    Then I should be in existing products page
    Then I click on Make changes button
    And I click on continue button
    Then I should be in customize service page
    Then I click List Toggle
    Then I select Listing options "<Listing_Options>"
    And I click again on contine button
    And I click on continue button of scheduling page
    And I selected Yes for the review in order summary page

    # Then I clicked submit order button
    # Then I should able to submit order successfully
    # Then I get account number from application
    Examples: 
      | Env | firstName | lastName | phoneNo    | account number | Listing_Options |
      | E2E | Jones     | Smith    | 4029986730 |      480028031 | Listed          |
