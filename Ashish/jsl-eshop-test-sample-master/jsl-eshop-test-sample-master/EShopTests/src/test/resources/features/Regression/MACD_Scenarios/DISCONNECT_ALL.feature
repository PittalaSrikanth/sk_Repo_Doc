@EshopTestScripts @MACDScripts @EshopRegression @MACD_Disconnect @Disconnect_Regression
Feature: MACD Scenarios on Disconnect All

  @HSIDISCONNECTREG
  Scenario Outline: Verify user is able to submit Disconnect All on HSI orders
    Given I should be on SFC login screen
    When I enter username and password
    Then I search order in SFC page with account number "<account number>"
    Then I click on order eshop button in SFC page to proceed to Eshop Page
    Then I should be in existing products page
    And I click on DisconnectAll
    Then I enter Internet Disconnect Reason
    And I click on continue button on DIS Page
    And I click on continue button of scheduling page
    And I select current Billing Address option
    And I click on continue button on Account Information
    And I selected Yes for the review in order summary page
    # Then I clicked submit order button
    #Then I get account number from application
    Examples: 
      | Env | firstName | lastName | phoneNo    | account number |
      | E2E | Jones     | Smith    | 4029986730 |      686356396 |

  @POTSDISCONNECTREG
  Scenario Outline: Verify user is able to submit Disconnect All on POTS orders
    Given I should be on SFC login screen
    When I enter username and password
    Then I search order in SFC page with account number "<account number>"
    Then I click on order eshop button in SFC page to proceed to Eshop Page
    Then I should be in existing products page
    And I click on DisconnectAll
    Then I enter Internet Disconnect Reason
    And I click on continue button on DIS Page
    And I click on continue button of scheduling page
    And I select current Billing Address option
    And I click on continue button on Account Information
    And I selected Yes for the review in order summary page
    #Then I clicked submit order button
    #Then I get account number from application
    Examples: 
      | Env | firstName | lastName | phoneNo    | account number |
      | E2E | Jones     | Smith    | 4029986730 |      686356409 |

  @HSIPOTSDISCONNECTREG
  Scenario Outline: Verify user is able to submit Disconnect All on HSI+POTS orders
    Given I should be on SFC login screen
    When I enter username and password
    Then I search order in SFC page with account number "<account number>"
    Then I click on order eshop button in SFC page to proceed to Eshop Page
    Then I should be in existing products page
    And I click on DisconnectAll
    Then I enter Internet Disconnect Reason
    Then I enter POTS Disconnect Reason
    And I click on continue button on DIS Page
    And I click on continue button of scheduling page
    And I select current Billing Address option
    And I click on continue button on Account Information
    And I selected Yes for the review in order summary page
    #Then I clicked submit order button
    #Then I get account number from application
    Examples: 
      | Env | firstName | lastName | phoneNo    | account number |
      | E2E | Jones     | Smith    | 4029986730 |      686525313 |

  @HSICVOIPDISCONNECTREG
  Scenario Outline: Verify user is able to submit Disconnect All on HSI+CVOIP orders
    Given I should be on SFC login screen
    When I enter username and password
    Then I search order in SFC page with account number "<account number>"
    Then I click on order eshop button in SFC page to proceed to Eshop Page
    Then I should be in existing products page
    And I click on DisconnectAll
    Then I enter Internet Disconnect Reason
    Then I enter CVOIP Disconnect Reason
    And I click on continue button on DIS Page
    And I click on continue button of scheduling page
    And I select current Billing Address option
    And I click on continue button on Account Information
    And I selected Yes for the review in order summary page
    #Then I clicked submit order button
    #Then I get account number from application
    Examples: 
      | Env | firstName | lastName | phoneNo    | account number |
      | E2E | Jones     | Smith    | 4029986730 |      686526858 |
