@EshopTestScripts @EShopFunctional
Feature: SUP2(Due Date Change) Scenarios

  #TC265338 : MMP_3879_F17300_Change_Due_Date_HSI_Order
  @HSIChangeOrderDueDate
  Scenario Outline: Create a HSI new install Order and change its due date
    Given I should be on SFC login screen
    When I enter username and password
    Then I click on create new account
    Then I enter the "<firstName>" "<lastName>" "<phoneNo>" and "<address>" in new acquisition page
    Then I validate the address and save it
    Then I click on order eshop button
    Then I should be in Eshop Product offer page
    Then I select the best "<Installation_option>" installation option
    Then I select the number of device needed "<Device Quantity>"
    And I click on continue button
    Then I should be in customize service page
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
    Then I clicked submit order button
    Then I get account number from application
    Then I move back to existing SFC page
    Then I search order in SFC page with account number
    Then I click on order eshop button in SFC page to proceed to Eshop Page
    Then I click on other actions button on pending order page
    Then I click on cancel order button on pending order page
    Then I confirm the cancelation of the order

    Examples: 
      | firstName | lastName | phoneNo    | address                               | email       | SMSNo      | Installation_option | Date | Month | Year | SSN        | card             | zip code | Device Quantity |
      | Jones     | Smith    | 4029986730 | 611 FENWICK DR,PAPILLION,NE 68046,USA | Ctl@Ctl.com | 4029986730 | STANDARD            |   02 |    02 | 1987 | 3450380580 | 4485389438108352 |    37638 | 2 devices       |

  #TC
  @HSICVOIPChangeOrderDueDate
  Scenario Outline: Create a HSI + CVOIP new install Order with Payment
    Given I should be on SFC login screen
    When I enter username and password
    Then I click on create new account
    Then I enter the "<firstName>" "<lastName>" "<phoneNo>" and "<address>" in new acquisition page
    Then I validate the address and save it
    Then I click on order eshop button
    Then I should be in Eshop Product offer page
    And I select CVoip DHP phone
    And I select address info popup
    Then I select the number of device needed "<Device Quantity>"
    And I click on continue button
    Then I should be in customize service page
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
    Then I clicked submit order button
    Then I get account number from application
    Then I move back to existing SFC page
    Then I search order in SFC page with account number
    Then I click on order eshop button in SFC page to proceed to Eshop Page
    Then I click on other actions button on pending order page
    Then I click on cancel order button on pending order page
    Then I confirm the cancelation of the order

    Examples: 
      | firstName | lastName | phoneNo    | address                               | email       | SMSNo      | Installation_option | Date | Month | Year | SSN       | card             | zip code | Device Quantity |
      | Jones     | Smith    | 4899999343 | 611 FENWICK DR,PAPILLION,NE 68046,USA | Ctl@Ctl.com | 4029986730 | STANDARD            |   02 |    02 | 1987 | 345038058 | 4485389438108352 |    37638 | 2 devices       |

  #TC265340
  @HSIPOTSChangeOrderDueDate
  Scenario Outline: Create a POTS Order and change its due date
    Given I should be on SFC login screen
    When I enter username and password
    Then I click on create new account
    Then I enter the "<firstName>" "<lastName>" "<phoneNo>" and "<address>" in new acquisition page
    Then I validate the address and save it
    Then I click on order eshop button
    Then I should be in Eshop Product offer page
    And I select HomePhone
    #And I select address info popup
    Then I select the number of device needed "<Device Quantity>"
    Then I select required option for voice mail "<Voice Mail>"
    Then I select required option for Wire Maintenance Plan "<Wire Maintenance Plan>"
    Then I select required option for Port in a phone number? "<Port in a phone number?>"
    Then I select required option for Need new jacks or wiring? "<Need new jacks or wiring?>"
    And I click on continue button
    Then I should be in customize service page
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
    Then I clicked submit order button
    Then I get account number from application
    Then I move back to existing SFC page
    Then I search order in SFC page with account number
    Then I click on order eshop button in SFC page to proceed to Eshop Page
    Then I click on other actions button on pending order page
    Then I click on cancel order button on pending order page
    Then I confirm the cancelation of the order

    Examples: 
      | firstName | lastName | phoneNo    | address                               | email       | SMSNo      | Installation_option | Date | Month | Year | SSN       | card             | zip code | Device Quantity | Voice Mail | Wire Maintenance Plan | Port in a phone number? | Need new jacks or wiring? |
      | MARIANNE  | HELTON   | 4029986730 | 611 FENWICK DR,PAPILLION,NE 68046,USA | Ctl@Ctl.com | 4029986730 | STANDARD            |   02 |    02 | 1987 | 666150907 | 4485389438108352 |    37638 | 2 devices       | No         | No                    | No                      | No Work Is Needed ($0)    |

  #TC
  @POTSChangeOrderDueDate
  Scenario Outline: Create a POTS Order and change its due date
    Given I should be on SFC login screen
    When I enter username and password
    Then I click on create new account
    Then I enter the "<firstName>" "<lastName>" "<phoneNo>" and "<address>" in new acquisition page
    Then I validate the address and save it
    Then I click on order eshop button
    Then I should be in Eshop Product offer page
    And I select HomePhone only by deselecting Internet
    #And I select address info popup
    Then I select required option for voice mail "<Voice Mail>"
    Then I select required option for Wire Maintenance Plan "<Wire Maintenance Plan>"
    Then I select required option for Port in a phone number? "<Port in a phone number?>"
    Then I select required option for Need new jacks or wiring? "<Need new jacks or wiring?>"
    And I click on continue button
    Then I should be in customize service page
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
    Then I clicked submit order button
    Then I get account number from application
    Then I move back to existing SFC page
    Then I search order in SFC page with account number
    Then I click on order eshop button in SFC page to proceed to Eshop Page
    Then I click on other actions button on pending order page
    Then I click on cancel order button on pending order page
    Then I confirm the cancelation of the order

    Examples: 
      | firstName | lastName | phoneNo    | address                               | email       | SMSNo      | Installation_option | Date | Month | Year | SSN       | card             | zip code | Voice Mail | Wire Maintenance Plan | Port in a phone number? | Need new jacks or wiring? |
      | MARIANNE  | HELTON   | 4029986730 | 611 FENWICK DR,PAPILLION,NE 68046,USA | Ctl@Ctl.com | 4029986730 | STANDARD            |   02 |    02 | 1987 | 666150907 | 4485389438108352 |    37638 | No         | No                    | No                      | No Work Is Needed ($0)    |
