@EshopTestScripts @MACDScripts @EshopRegression @MACD_Change
Feature: MACD Scenarios on Change Remove

  #ATC_MACD_04
  @ATC_MACD_04
  Scenario Outline: MACD Scenario on HSI + POTS  during CH remove HSI
    Given I should be on SFC login screen
    When I enter username and password
    #Below two commented steps are Future Ready steps for MACD Scenarios
    #Then I move back to existing SFC page
    #Then I search order in SFC page with account number
    Then I search order in SFC page with account number "<account number>"
    Then I click on order eshop button in SFC page to proceed to Eshop Page
    Then I should be in existing products page
    Then I click on Make changes button
    Then I Remove the existing product HSI
    And I click on continue button
    Then I should be in customize service page
    And I click again on contine button
    And I click on Duedate calender to change DD
    And I click on continue button of scheduling page
    And I click on continue button of scheduling page
    And I selected Yes for the review in order summary page
    Then I clicked submit order button
    Then I should able to submit order successfully
    Then I get account number from application
    Examples: 
      | Env | firstName | lastName | phoneNo    | account number |
      | E2E | Jones     | Smith    | 4029986730 |      578418450 |

  #ATC_MACD_03
  @ATC_MACD_03
    Scenario Outline: MACD Scenario on HSI + POTS  during CH remove POTS
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
  #  Then I check for return deposit amount for removed product if any available
    And I click on continue button
    Then I should be in customize service page
    And I click again on contine button
    And I click on Duedate calender to change DD
    Then I add a call referral for POTS product removal
    And I click on continue button of scheduling page
    And I selected Yes for the review in order summary page
    Then I clicked submit order button
    Then I should able to submit order successfully
    Then I get account number from application
    Examples: 
      | Env | firstName | lastName | phoneNo    | account number |
      | E2E | Jones     | Smith    | 4029986730 |      578418632 |

  #ATC_MACD_05
  @ATC_MACD_05
  Scenario Outline: MACD Scenario on HSI + CVOIP  during CH remove CVOIP
    Given I should be on SFC login screen
    When I enter username and password
    #Below two commented steps are Future Ready steps for MACD Scenarios
    #Then I move back to existing SFC page
    #Then I search order in SFC page with account number
    Then I search order in SFC page with account number "<account number>"
    Then I click on order eshop button in SFC page to proceed to Eshop Page
    Then I should be in existing products page
    Then I click on Make changes button
    Then I Remove the existing product CVOIP
    And I click on continue button
    Then I should be in customize service page
    And I click again on contine button
    And I click to reserve appointment
    And I click on continue button of scheduling page
    And I click again click Continue button on change account page
    And I selected Yes for the review in order summary page

    # Then I clicked submit order button
    #  Then I should able to submit order successfully
    #  Then I get account number from application
    Examples: 
      | Env | firstName | lastName | phoneNo    | account number |
      | E2E | Jones     | Smith    | 4029986730 |      480076119 |

  #ATC_MACD_02
  @ATC_MACD_02
  Scenario Outline: MACD Scenario on HSI + POTS(Essential Home phone Bundle)  during  CH remove HSI
    Given I should be on SFC login screen
    When I enter username and password
    #Below two commented steps are Future Ready steps for MACD Scenarios
    #Then I move back to existing SFC page
    #Then I search order in SFC page with account number
    Then I search order in SFC page with account number "<account number>"
    Then I click on order eshop button in SFC page to proceed to Eshop Page
    Then I should be in existing products page
    Then I click on Make changes button
    Then I Remove the existing product HSI
    And I click on continue button
    Then I should be in customize service page
    And I click again on contine button
    And I click to reserve appointment
    And I click on continue button of scheduling page
    And I click again click Continue button on change account page
    And I selected Yes for the review in order summary page

    # Then I clicked submit order button
    # Then I should able to submit order successfully
    #Then I get account number from application
    Examples: 
      | Env | firstName | lastName | phoneNo    | account number |
      | E2E | Jones     | Smith    | 4029986730 |      480075527 |

  #ATC_MACD_01
  @ATC_MACD_01
  Scenario Outline: MACD Scenario on HSI + POTS(Essential Home phone Bundle)  during  CH remove POTS
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
    Then I add a call referral for POTS product removal
    And I click to reserve appointment
    And I click on continue button of scheduling page
    And I click again click Continue button on change account page
    And I selected Yes for the review in order summary page

    # Then I clicked submit order button
    # Then I should able to submit order successfully
    # Then I get account number from application
    Examples: 
      | Env | firstName | lastName | phoneNo    | account number |
      | E2E | Jones     | Smith    | 4029986730 |      480075527 |
