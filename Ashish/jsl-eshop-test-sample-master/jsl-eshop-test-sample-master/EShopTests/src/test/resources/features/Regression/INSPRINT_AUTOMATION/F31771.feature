@EshopTestScripts @MACDScripts @EshopRegression @MACD_Move
Feature: MACD Scenarios for Move

  #TC365248
  @MACD_HSI_F31771
  Scenario Outline: HSI validate speed during Move
    Given I should be on SFC login screen
    When I enter username and password
    Then I search order in SFC page with account number "<account number>"
    Then I click on order eshop button in SFC page to proceed to Eshop Page
    Then I should be in existing products page
    Then I select move service from other order activities
    And I enter new address and click validate "<new_address>"
    Then Validate speed

    #And I click continue button from existing products and move service page
    #And I click again continue button in Customer Service Page
    #And I click continue button in scheduling Move Order page
    #And I click Continue button on account information page
    #And I selected Yes for the review in order summary page
    #Then I clicked submit order button
    # Then I should able to submit order successfully
    # Then I get account number from application
    Examples: 
      | Env | firstName | lastName | phoneNo    | new_address                          | account number | Installation_option | Device Quantity | Voice Mail | Wire Maintenance Plan | Port in a phone number? | Need new jacks or wiring? |
      | E2E | Jones     | Smith    | 4029986730 | 1119 N 90TH ST FLR 1 OMAHA, NE 68114 |      578275300 | STANDARD            | 2 devices       | No         | No                    | No                      | No Work Is Needed ($0)    |

  #TC365430
  @MACD_HSI+POTS_F31771
  Scenario Outline: HSI+POTS validate speed during Move
    Given I should be on SFC login screen
    When I enter username and password
    Then I search order in SFC page with account number "<account number>"
    Then I click on order eshop button in SFC page to proceed to Eshop Page
    Then I should be in existing products page
    Then I select move service from other order activities
    And I enter new address and click validate "<new_address>"
    Then Validate speed

    #And I click continue button from existing products and move service page
    #And I click again continue button in Customer Service Page
    #And I click continue button in scheduling Move Order page
    #And I click Continue button on account information page
    #And I selected Yes for the review in order summary page
    #Then I clicked submit order button
    # Then I should able to submit order successfully
    # Then I get account number from application
    Examples: 
      | Env | firstName | lastName | phoneNo    | new_address                             | account number | Installation_option | Device Quantity | Voice Mail | Wire Maintenance Plan | Port in a phone number? | Need new jacks or wiring? |
      | E2E | Jones     | Smith    | 4029986730 | 726 N FRONTIER DR, PAPILLION, NE, 68046 |      578275899 | STANDARD            | 2 devices       | No         | No                    | No                      | No Work Is Needed ($0)    |
