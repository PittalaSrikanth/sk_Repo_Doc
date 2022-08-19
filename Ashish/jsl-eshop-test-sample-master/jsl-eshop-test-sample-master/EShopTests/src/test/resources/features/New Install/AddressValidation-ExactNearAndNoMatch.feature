@EshopTestScripts @EShopFunctional
Feature: User should be able to perform Address Validation for Eastern, Western and Central Addresses.

  #TC243842
  @exactMatch
  Scenario Outline: Perform Address Validation as Exact Match
    Given I should be on Eshop login screen
    When I enter username and password
    And I enter the "<Env>" "<firstName>" "<lastName>" "<phoneNo>" and "<addresses>" in customer detail page
    Then I click let's go button
    Then I should be in Product offer page
    Then I should get build your offer tab on product page

    Examples: 
      | Env  | firstName | lastName | phoneNo    | addresses                                  |
      | E2E  | Jones     | Smith    | 4899999343 | 3565 E ARAPAHOE PL,CENTENNIAL,CO 80122,USA |
    # | ITV2 | Jones     | Smith    | 4899999343 | 3575 E ARAPAHOE PL,CENTENNIAL,CO 80122,USA |

  @noMatch
  Scenario Outline: Perform Address Validation as No Match
    Given I should be on Eshop login screen
    When I enter username and password
    And I enter the "<Env>" "<firstName>" "<lastName>" "<phoneNo>" and "<addresses>" in customer detail page
    Then I should get no match found text

    Examples: 
      | Env  | firstName | lastName | phoneNo    | addresses                                |
      | E2E  | Jones     | Smith    | 4899999343 | 3565 E SHADY LN ,CENTENNIAL,CO 80132,USA |
    # | ITV2 | Jones     | Smith    | 4899999343 | 3565 E SHADY LN ,CENTENNIAL,CO 80132,USA |

  @nearMatch
  Scenario Outline: Perform Address Validation as Near Match
    Given I should be on Eshop login screen
    When I enter username and password
    And I enter the "<Env>" "<firstName>" "<lastName>" "<phoneNo>" and "<addresses>" in customer detail page
    Then I click let's go button
    Then I should get more than one address field

    Examples: 
      | Env  | firstName | lastName | phoneNo    | addresses                                  |
      | E2E  | Jones     | Smith    | 4899999343 | 3170 E ARAPAHOE RD,CENTENNIAL,CO 80122,USA |
    # | ITV2 | Jones     | Smith    | 4899999343 | 3170 E ARAPAHOE RD,CENTENNIAL,CO 80122,USA |
    # | E2E  | Jones     | Smith    | 4899999343 | 8090 EDEN RD,EDN PRAIRIE,MN 55344,USA      |
