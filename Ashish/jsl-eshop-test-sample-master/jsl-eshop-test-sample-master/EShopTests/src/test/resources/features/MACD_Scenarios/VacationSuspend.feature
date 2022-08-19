@EshopTestScripts @Regression @MACDFlow
Feature: Vacation Suspend feature

  #Create a HSI NI order and complete it.
  #Make sure that the due date of below test case is greater than NI order.
  @VacationSuspendHSI @MACDFlow @Regression
  Scenario Outline: Vacation Suspend for HSI only.
    Given I should be on SFC login screen
    When I enter username and password
    Then I search order in SFC page with account number "<account number>"
    Then I click on order eshop button in SFC page to proceed to Eshop Page
    Then I click on Vacation Service
    And I select Vacation Suspend from the dialog box
    And I click on Continue button on vacation service dialog box
    And I click on Continue button on vacation service dialog box again
    And I click on OK Got it button on Order Disclosures dialog box for Vacation Suspend for HSI
    Then I select the provided due date for installation in Due Date format "<Due Date>"
    When I click on continue button on vacation order scheduling page
    And I validate if Update or Review Billing address is present for Vacation Suspend order in Account Information page
    And I select current billing address
    And I click on continue button for Vacation Suspend order in Account Information page
    And I selected Yes for the review in order summary page
    Then I clicked submit order button
    Then I get account number from application

    Examples: 
      | Env  | firstName | lastName | phoneNo    | account number | Due Date |
      | ITV1 | Jones     | Smith    | 4029986730 |      578402918 | Jul23    |
