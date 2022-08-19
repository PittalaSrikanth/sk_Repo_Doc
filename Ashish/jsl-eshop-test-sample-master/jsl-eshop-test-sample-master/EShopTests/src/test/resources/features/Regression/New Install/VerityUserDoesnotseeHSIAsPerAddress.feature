@EshopTestScripts @EShopFunctional
Feature: Verify the User does not see any High Speed Internet offers if the Address does not qualify for it

  #TC242491
  @verifyUserDoesnotseeHSI
  Scenario Outline: Verify the user does not see any High Speed Internet offers
    Given I should be on Eshop login screen
    When I enter username and password
    And I enter the "<Env>" "<firstName>" "<lastName>" "<phoneNo>" and "<addresses>" in customer detail page
    Then I click let's go button
    Then I should get more than one address field

    Examples: 
      | Env | firstName | lastName | phoneNo    | addresses                              |
      | E2E | Jones     | Smith    | 4899999343 | 344430 HIGHWAY 26,SEASIDE,OR 97138 USA |
     #| ITV2|	Jones			|	Smith			|	4899999343|	344430 HIGHWAY 26,SEASIDE,OR 97138 USA		|