@EshopTestScripts @TC379448
Feature: MMP7783 - F26407 - Verify CNUM response is status = Available

  @F26407_Verify_CNUM_response_Available
  Scenario Outline: MMP7783 - F26407 - Verify CNUM response is status = Available
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
    Then I Select "402" from NPA "359" from NXX dropdown and "8700" as line
    Then I Click on CheckTN button
    Then I Validated the confirmation message that says "TN is available"

    Examples: 
      | Env   | firstName | lastName | phoneNo    | new_address                        | account number | Installation_option | Device Quantity | Voice Mail | Wire Maintenance Plan | Port in a phone number? | Need new jacks or wiring? |
      | Test1 | Jones     | Smith    | 4029986730 | 311 S MAYNE ST,VALLEY,NE,68064,USA |      578618452 | STANDARD            | 2 devices       | No         | No                    | No                      | No Work Is Needed ($0)    |
