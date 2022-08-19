@creditCheck @EshopTestScripts @EShopFunctional
Feature: As a Ordering User, a Customers Level of Credit must be evaluated before an Order can be submitted.

  #TC242505
  @creditCheckforbelow18 @EshopTestScripts
  Scenario Outline: Credit Check New Connect High Speed Internet for age below 18
    Given I should be on SFC login screen
    When I enter username and password
    Then I click on create new account
    Then I enter the "<firstName>" "<lastName>" "<phoneNo>" and "<address>" in new acquisition page
    Then I validate the address and save it
    Then I click on order eshop button
    Then I should be in Eshop Product offer page
    Then I select the best "<Installation_option>" installation option
    And I select Your "<Modem_Option>" Modem option
    And I select "<Ease_Option>" Ease Option
    Then I select the number of device needed "<Device Quantity>"
    And I click on continue button
    Then I should be in customize service page
    Then I add the equipments in customize service page
    And I click again on contine button
    And I click to reserve appointment
    And I click on continue button of scheduling page
    And I decline customer email
    And I enter date "<Date>" month "<Month>" and year "<Year>" of birth
    And I verify age is less than 18

    Examples: 
      | firstName | lastName | phoneNo    | address                               | Installation_option | Modem_Option | Ease_Option | Device Quantity |
      | Jones     | Smith    | 4029986730 | 611 FENWICK DR,PAPILLION,NE 68046,USA | STANDARD            | LEASE        | BASIC       | 2 devices       |

  @creditCheckforYes @EshopTestScripts
  Scenario Outline: Credit Check New Connect High Speed Internet for Age more than 18 Credit Check yes
    Given I should be on SFC login screen
    When I enter username and password
    Then I click on create new account
    Then I enter the "<firstName>" "<lastName>" "<phoneNo>" and "<address>" in new acquisition page
    Then I validate the address and save it
    Then I click on order eshop button
    Then I should be in Eshop Product offer page
    Then I select the best "<Installation_option>" installation option
    And I select Your "<Modem_Option>" Modem option
    And I select "<Ease_Option>" Ease Option
    Then I select the number of device needed "<Device Quantity>"
    And I click on continue button
    Then I should be in customize service page
    And I click again on contine button
    And I click to reserve appointment
    And I click on continue button of scheduling page
    And I decline customer email
    And I enter date "<Date>" month "<Month>" and year "<Year>" of birth
    And I enter SSN number "<SSN>"
    And I select credit as "Yes"
    And I click on account Continue button

    Examples: 
      | firstName | lastName | phoneNo    | address                               | Installation_option | Modem_Option | Ease_Option | Date | Month | Year | SSN       | Device Quantity |
      | Jones     | Smith    | 4899999343 | 611 FENWICK DR,PAPILLION,NE 68046,USA | STANDARD            | LEASE        | BASIC       |   02 |    02 | 1987 | 345038058 | 2 devices       |

  @creditCheckforNo @EshopTestScripts
  Scenario Outline: Credit Check New Connect High Speed Internet for Age more than 18 Credit Check no
    Given I should be on SFC login screen
    When I enter username and password
    Then I click on create new account
    Then I enter the "<firstName>" "<lastName>" "<phoneNo>" and "<address>" in new acquisition page
    Then I validate the address and save it
    Then I click on order eshop button
    Then I should be in Eshop Product offer page
    Then I select the best "<Installation_option>" installation option
    And I select Your "<Modem_Option>" Modem option
    And I select "<Ease_Option>" Ease Option
    Then I select the number of device needed "<Device Quantity>"
    And I click on continue button
    Then I should be in customize service page
    And I click again on contine button
    And I click to reserve appointment
    And I click on continue button of scheduling page
    And I decline customer email
    And I enter date "<Date>" month "<Month>" and year "<Year>" of birth
    And I enter SSN number "<SSN>"
    And I select credit as "No"
    And I click on account Continue button

    Examples: 
      | firstName | lastName | phoneNo    | address                               | Installation_option | Modem_Option | Ease_Option | Date | Month | Year | SSN       | Device Quantity |
      | Jones     | Smith    | 4899999343 | 611 FENWICK DR,PAPILLION,NE 68046,USA | STANDARD            | LEASE        | BASIC       |   02 |    02 | 1987 | 345038058 | 2 devices       |
