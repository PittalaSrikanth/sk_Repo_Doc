@EshopTestScripts
Feature: F26407 Verify CNUM response is status = Working or Unavailable

  @TC379447
  Scenario Outline: Verify CNUM response is status = Working or Unavailable
    Given I should be on SFC login screen
    When I enter username and password
    Then I click on create new account
    Then I enter the "<firstName>" "<lastName>" "<phoneNo>" and "<address>" in new acquisition page
    Then I validate the address and save it
    Then I click on order eshop button
    Then I should be in Eshop Product offer page
    And I select HomePhone only by deselecting Internet
    And I select One Pty Residence Line
    Then I select required option for voice mail "<Voice Mail>"
    Then I select required option for Wire Maintenance Plan "<Wire Maintenance Plan>"
    Then I select required option for Port in a phone number? "<Port in a phone number?>"
    Then I select required option for Need new jacks or wiring? "<Need new jacks or wiring?>"
    And I click on continue button
    Then I should be in customize service page
    Then I Expand the Telephone Number under Phone Configuration
    And I Click on More TNs
    Then I Click on More Options
    Then I Click on "Manual Request" Radio button
    Then I Select "218" from NPA "262" from NXX dropdown and "0879" as line
    Then I Click on CheckTN button
    Then I Validated the CNUM response message that says "TN is not available"

    Examples: 
      | firstName | lastName | phoneNo    | new_address                              | Voice Mail | Wire Maintenance Plan | Port in a phone number? | Need new jacks or wiring? |
      | Jones     | Smith    | 4029986730 | 1072 E BURNSIDE ST,PORTLAND,OR 97214,USA | No         | No                    | No                      | No Work Is Needed ($0)    |
