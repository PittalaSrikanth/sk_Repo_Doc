@EshopTestScripts @MACDScripts @EshopRegression @MACD_Change
Feature: MACD Scenarios on Change Add

  # Feature file for PAYMENT MACD SCENARIOS STARTS>>>>>>>>>>>>>>
  #ATC_MACD_11
  @ATC_MACD_11
  Scenario Outline: MACD Scenario on H S I during  CH  add POTS
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
    Then I should be in customize service page
    And I click again on contine button
    And I click on continue button of scheduling page
    And I click on payNow
    And I should be at make payment page
    And I fill all card details as "<card>" and "<zip code>"
    And I click submit button on verify InformationPage
    And I click Continue button on account information page
    And I selected Yes for the review in order summary page

    # Then I clicked submit order button
    # Then I should able to submit order successfully
    # Then I get account number from application
    Examples: 
      | Env | firstName | lastName | phoneNo    | account number | Date | Month | Year | SSN       | card             | zip code | Voice Mail | Wire Maintenance Plan | Port in a phone number? | Need new jacks or wiring? |
      | E2E | Jones     | Smith    | 4029986730 |      480074742 |   02 |    02 | 1987 | 666601283 | 4485389438108352 |    37638 | No         | No                    | No                      | No Work Is Needed ($0)    |

  #ATC_MACD_12
  @ATC_MACD_12
  Scenario Outline: MACD Scenario on H S I  during  CH add CVOIP
    Given I should be on SFC login screen
    When I enter username and password
    #Below two commented steps are Future Ready steps for MACD Scenarios
    #Then I move back to existing SFC page
    #Then I search order in SFC page with account number
    Then I search order in SFC page with account number "<account number>"
    Then I click on order eshop button in SFC page to proceed to Eshop Page
    Then I should be in existing products page
    Then I click on Make changes button
    Then I Add the new products CVOIP
    And I click on continue button
    Then I should be in customize service page
    And I click again on contine button
    And I click on continue button of scheduling page
    And I click on payNow
    And I should be at make payment page
    And I fill all card details as "<card>" and "<zip code>"
    And I click submit button on verify InformationPage
    And I click Continue button on account information page
    And I selected Yes for the review in order summary page

    # Then I clicked submit order button
    # Then I should able to submit order successfully
    # Then I get account number from application
    Examples: 
      | Env | firstName | lastName | phoneNo    | account number | Date | Month | Year | SSN       | card             | zip code |
      | E2E | Jones     | Smith    | 4029986730 |      480075209 |   02 |    02 | 1987 | 666601283 | 4485389438108352 |    37638 |

  #ATC_MACD_13
  @ATC_MACD_13
  Scenario Outline: MACD Scenario on POTS during  CH  Add H S I
    Given I should be on SFC login screen
    When I enter username and password
    #Below two commented steps are Future Ready steps for MACD Scenarios
    #Then I move back to existing SFC page
    #Then I search order in SFC page with account number
    Then I search order in SFC page with account number "<account number>"
    Then I click on order eshop button in SFC page to proceed to Eshop Page
    Then I should be in existing products page
    Then I click on Make changes button
    Then I Add the new products HSI
    And I click on continue button
    Then I should be in customize service page
    And I click again on contine button
    And I click on continue button of scheduling page
    And I click on payNow
    And I should be at make payment page
    And I fill all card details as "<card>" and "<zip code>"
    And I click submit button on verify InformationPage
    And I click Continue button on account information page
    And I selected Yes for the review in order summary page

    # Then I clicked submit order button
    # Then I should able to submit order successfully
    # Then I get account number from application
    Examples: 
      | Env | firstName | lastName | phoneNo    | account number | Date | Month | Year | SSN       | card             | zip code |
      | E2E | Jones     | Smith    | 4029986730 |      480076368 |   02 |    02 | 1987 | 666601283 | 4485389438108352 |    37638 |

  # Feature file for PAYMENT MACD SCENARIOS ENDS<<<<<<<<<<<<<<<<<<<<<<<<
  # Feature file for NON PAYMENT MACD SCENARIOS STARTS>>>>>>>>>>>>>>>>>>>>>>
  #ATC_MACD_11
  @ATC_MACD_11NOPAY0605
  Scenario Outline: MACD Scenario on H S I during  CH  add POTS
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
    Then I should be in customize service page
    And I click again on contine button
    And I click on continue button of scheduling page
    And I click Continue button on account information page
    And I selected Yes for the review in order summary page

    # Then I clicked submit order button
    # Then I should able to submit order successfully
    # Then I get account number from application
    Examples: 
      | Env | firstName | lastName | phoneNo    | account number | Date | Month | Year | SSN       | card             | zip code | Voice Mail | Wire Maintenance Plan | Port in a phone number? | Need new jacks or wiring? |
      | E2E | Jones     | Smith    | 4029986730 |      578397443 |   02 |    02 | 1987 | 666601283 | 4485389438108352 |    37638 | No         | No                    | No                      | No Work Is Needed ($0)    |


  #ATC_MACD_12
  @ATC_MACD_12NOPAY06
 Scenario Outline: MACD Scenario on H S I  during  CH add CVOIP
    Given I should be on Eshop login screen
    When I enter username and password
    Then I search order in SFC page with account number "<account number>"
    Then I click on order eshop button in SFC page to proceed to Eshop Page
    Then I should be in existing products page
    Then I click on Make changes button
    Then I Add the new products CVOIP
    And I select address info popup
    And I click on continue button
    Then I should be in customize service page
    And I click again on contine button
    And I click on continue button of scheduling page
    And I click Continue button on account information page
    And I selected Yes for the review in order summary page

    # Then I clicked submit order button
    # Then I should able to submit order successfully
    # Then I get account number from application
    Examples: 
      | Env | firstName | lastName | phoneNo    | account number | Date | Month | Year | SSN       | card             | zip code |
      | E2E | Jones     | Smith    | 4029986730 |      578397443 |   02 |    02 | 1987 | 666601283 | 4485389438108352 |    37638 |

  #ATC_MACD_13
  @ATC_MACD_13NOPAY
  Scenario Outline: MACD Scenario on POTS during  CH  Add H S I
    Given I should be on SFC login screen
    When I enter username and password
    #Below two commented steps are Future Ready steps for MACD Scenarios
    #Then I move back to existing SFC page
    #Then I search order in SFC page with account number
    Then I search order in SFC page with account number "<account number>"
    Then I click on order eshop button in SFC page to proceed to Eshop Page
    Then I should be in existing products page
    Then I click on Make changes button
    Then I Add the new products HSI
    And I click on continue button
    Then I should be in customize service page
    And I click again on contine button
    And I click to reserve appointment
    And I click on continue button of scheduling page
    And I click Continue button on account information page
    And I selected Yes for the review in order summary page

    # Then I clicked submit order button
    # Then I should able to submit order successfully
    # Then I get account number from application
    Examples: 
      | Env | firstName | lastName | phoneNo    | account number | Date | Month | Year | SSN       | card             | zip code |
      | E2E | Jones     | Smith    | 4029986730 |      480028031 |   02 |    02 | 1987 | 666601283 | 4485389438108352 |    37638 |
  # Feature file for NON PAYMENT MACD SCENARIOS ENDS<<<<<<<<<<<<<<<<<<<<<<<<   
