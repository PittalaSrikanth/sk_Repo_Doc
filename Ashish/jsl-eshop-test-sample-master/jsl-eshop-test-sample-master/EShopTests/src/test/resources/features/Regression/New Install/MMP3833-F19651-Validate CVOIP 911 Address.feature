@EshopTestScripts @EShopFunctional
Feature: Verify the system prompts the user to enter mandatory attributes for Address Validation

  #TC260986
  @addressValidationMandatoryAtt
  Scenario Outline: Perform Address Validation to enter mandatory attributes
    Given I should be on SFC login screen
    When I enter username and password
    Then I click on create new account
    Then I enter the "<firstName>" "<lastName>" "<phoneNo>" and "<address>" in new acquisition page
    Then I validate the address and save it
    Then I click on order eshop button
    Then I should be in Eshop Product offer page
    And I select CVoip DHP phone
    And I select address info popup
    Then I select the best "<Installation_option>" installation option
    And I select Your "<Modem_Option>" Modem option
    And I select "<Ease_Option>" Ease Option
    Then I select the number of device needed "<Device Quantity>"
    And I click on continue button
    Then I should be in customize service page
   

    Examples: 
      | firstName | lastName | phoneNo    | address                               |  Installation_option | Modem_Option | Ease_Option |  Device Quantity | 
      | Jones     | Smith    | 4029986730 | 611 FENWICK DR,PAPILLION,NE 68046,USA |  STANDARD            | LEASE        | BASIC       |  3 devices       | 
