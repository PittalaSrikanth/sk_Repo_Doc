@EshopTestScripts @EShop_Insprint_Automation
Feature: Insprint Automation Sample Feature

  #TC
  @eshopInsprint_Automation_Sample_TC
  Scenario Outline: Insprint Automation Sample Scenario
    Given I should be on SFC login screen
    When I enter username and password
    Then I click on create new account
    Then I enter the "<firstName>" "<lastName>" "<phoneNo>" and "<address>" in new acquisition page
    Then I validate the address and save it
    Then I click on order eshop button
    Then I should be in Eshop Product offer page

    Examples: 
      | firstName | lastName | phoneNo    | address                              |
      | Jones     | Smith    | 4029986730 | 3066 SHADY LN,LITTLETON,CO 80126,USA |
