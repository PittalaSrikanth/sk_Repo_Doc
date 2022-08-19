@EshopTestScripts @EShopFunctional
Feature: HSI Order Scenarios

  #TC
  @EShopSanity
  Scenario Outline: Create a HSI new install Order
    Given I should be on SFC login screen
    When I enter username and password
    Then I click on create new account
    #   Then I enter the "<firstName>" "<lastName>" "<phoneNo>" and "<address>" in new acquisition page
    Then I enter the "<firstName>" "<lastName>" "<phoneNo>" and "<ShowaddressFields>" in show address fields in new acquisition page
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
    And I enter "<email>" and "<SMSNo>"
    And I enter date "<Date>" month "<Month>" and year "<Year>" of birth
    And I enter SSN number "<SSN>"
    And I select credit as "Yes"
    And I click on account Continue button
    And I click on payNow
    And I should be at make payment page
    And I fill all card details as "<card>" and "<zip code>"
    And I click submit button on verify InformationPage
    And I click again click Continue button on account
    And I selected Yes for the review in order summary page
    Then I enter the special remark in Additional Order Remarks field "<Additional Order Remarks>"
    Then I clicked submit order button
    Then I get account number from application

    Examples: 
      | firstName | lastName | phoneNo    | address                              | Installation_option | Modem_Option | Ease_Option | email       | SMSNo      | Date | Month | Year | SSN       | card             | zip code | Device Quantity | Additional Order Remarks       | ShowaddressFields                  |
      | Jones     | Smith    | 4899999343 | 3066 SHADY LN,LITTLETON,CO 80126,USA | STANDARD            | LEASE        | BASIC       | Ctl@Ctl.com | 4029986730 |   02 |    02 | 1987 | 345038058 | 4485389438108352 |    37638 | 2 devices       | ESHOP ORDER TEST BY AUTOMATION | 3066 SHADY LN LITTLETON   CO~80126 |
