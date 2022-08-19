@CalculateEarliestDueDate @EshopTestScripts @EShopFunctional
Feature: Calculate Earliest Due date and Appointment for HSI with Tech Install

  #TC242492
  Scenario Outline: Calculate earliest Due date
    Given I should be on Eshop login screen
    When I enter username and password
    And I enter the "<Env>" "<firstName>" "<lastName>" "<phoneNo>" and "<address>" in customer detail page
    Then I click let's go button
    Then I should be in Product offer page
    Then I select the best "<Installation_option>" installation option
    Then I select the number of device needed "<Device Quantity>"
    When I click on continue button
    Then I should be in customize service page
    And I click again on contine button
    Then I should get earliest available appointment text
    And I click to reserve appointment
    Then reserve date should display as due date

    Examples: 
      | Env | firstName | lastName | phoneNo    | address                              | Installation_option | Date | Month | Year | SSN        | Device Quantity |
      | E2E | Jones     | Smith    | 4899999343 | 3066 SHADY LN , LITTLETON, CO, 80126 | STANDARD            |   02 |    02 | 1987 | 3450380580 | 2 devices       |
    # | ITV2|	Jones		|	Smith		|	4899999343	|	3066 SHADY LN , LITTLETON, CO, 80126  |STANDARD|02		|	02		|	1987	|3450380580|2 devices    |
