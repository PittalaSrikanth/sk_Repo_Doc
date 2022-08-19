@EshopTestScripts @EShopFunctional
Feature: Select Shop Optional Add-Ons of Modem, Install and Ease

  #TC243851
  @shopOptional
  Scenario Outline: Select Shop Optional Add-Ons of Modem, Install and Ease
    Given I should be on Eshop login screen
    When I enter username and password
    And I enter the "<Env>" "<firstName>" "<lastName>" "<phoneNo>" and "<address>" in customer detail page
    Then I click let's go button
    Then I should be in Product offer page
    Then I select the best "<Installation_option>" installation option
    And I select Your "<Modem_Option>" Modem option
    And I select "<Ease_Option>" Ease Option
    Then I select the number of device needed "<Device Quantity>"
    Then I click on continue button
    Then I should be in customize service page

    Examples: 
      | Env | firstName | lastName | phoneNo    | address                              | Installation_option | Modem_Option | Ease_Option | Device Quantity |
      | E2E | Jones     | Smith    | 4899999343 | 3066 SHADY LN , LITTLETON, CO, 80126 | STANDARD            | LEASE        | STANDARD    | 2 devices       |
     #| ITV2|	Jones |	Smith	|	4899999343  |	3066 SHADY LN , LITTLETON, CO, 80126|STANDARD			 | LEASE 		| STANDARD	  |2 devices      |