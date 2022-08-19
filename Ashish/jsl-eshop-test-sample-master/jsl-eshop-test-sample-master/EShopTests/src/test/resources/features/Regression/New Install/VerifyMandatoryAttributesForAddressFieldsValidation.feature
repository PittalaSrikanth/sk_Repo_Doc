@EshopTestScripts @EShopFunctional
Feature: Verify the system prompts the user to enter mandatory attributes for Address Validation

  #TC255742
  @AddressValidationonfields
  Scenario Outline: Enter Address on show all address field
    Given I should be on Eshop login screen
    When I enter username and password
    And I enter the "<Env>" "<firstName>" "<lastName>" "<phoneNo>" in customer detail page
    And I enter the "<Street>" "<Unit>" "<City>" "<State>" "<Zip>" in address page
    Then I click let's go button
    #  Then I select Matched Address
    Then I should be in Product offer page

    Examples: 
      | Env | firstName | lastName | phoneNo    | Street        | Unit | City      | State | Zip   |
      | E2E | Jones     | Smith    | 4899999343 | 3066 SHADY LN |      | LITTLETON | CO    | 80126 |
