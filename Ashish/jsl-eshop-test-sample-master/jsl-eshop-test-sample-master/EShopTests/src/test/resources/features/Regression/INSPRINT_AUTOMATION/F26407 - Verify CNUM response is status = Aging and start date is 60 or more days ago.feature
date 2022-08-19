@EshopTestScripts @TC379449
Feature: Verify CNUM response is status = Aging and start date is 60 or more days ago

  @F26407_Aging_and_start_date_is_60_or_more_days_ago
  Scenario Outline: Verify CNUM response is status = Aging and start date is 60 or more days ago
    Given I should be on SFC login screen
    When I enter username and password
    Then I search order in SFC page with account number "<account number>"
    Then I click on order eshop button in SFC page to proceed to Eshop Page
    Then I should be in existing products page
    Then I select move service from other order activities
    And I enter new address and click validate "<new_address>"
    And I click continue button from existing products and move service page
    And I click on OK, Got it button in Order Disclosures dialog box
    Then I Expand the Telephone Number under Phone Configuration
    And I Click on More TNs
    Then I Click on More Options
    Then I Click on "Manual Request" Radio button
    Then I Select "218" from NPA "262" from NXX dropdown and "3492" as line
    Then I Click on CheckTN button
    Then I Validated the CNUM confirmation message that says "Aging more than 60 days"

    Examples: 
      | Env   | firstName | lastName | phoneNo    | new_address                      | account number | Installation_option | Device Quantity | Voice Mail | Wire Maintenance Plan | Port in a phone number? | Need new jacks or wiring? |
      | Test1 | Jones     | Smith    | 4029986730 | 4010 3RD AVE E HIBBING, MN 55746 |      578633473 | STANDARD            | 2 devices       | No         | No                    | No                      | No Work Is Needed ($0)    |
