@EshopTestScripts @EShopFunctional
Feature: User should be able to create an Order by selecting all Equipments

  #ATC00009
  @HSIEquipments
  Scenario Outline: Create an HSI Order by selecting all Equipments.
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
    # Need to pass the values along with "~" character Please refer below step
    Then I select specific equipments "OPT-EQP" and "DSL Wall-Mount Filter~DSL In-Line Filter~HSI Wireless USB Adapter"
    And I click again on contine button
    And I click to reserve appointment
    And I click on continue button of scheduling page
    And I decline customer email
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
      | firstName | lastName | phoneNo    | address                               | Installation_option | Modem_Option | Ease_Option | Date | Month | Year | SSN       | card             | zip code | Device Quantity | Additional Order Remarks       |
      | Jones     | Smith    | 4029986730 | 611 FENWICK DR,PAPILLION,NE 68046,USA | STANDARD            | LEASE        | BASIC       |   02 |    02 | 1987 | 345038058 | 4485389438108352 |    37638 | 2 devices       | ESHOP ORDER TEST BY AUTOMATION |

  #ATC00011
  @HSIDHPwithEquipments
  Scenario Outline: Create a HSI + CVOIP order by selecting all Equipments
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
    # Then I select all the equipments "EQP"
    Then I select specific equipments "EQP" and "Digital Home Phone Battery Backup Unit"
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
      | firstName | lastName | phoneNo    | address                               | Installation_option | Modem_Option | Ease_Option | email       | SMSNo      | Date | Month | Year | SSN       | card             | zip code | Device Quantity | Additional Order Remarks       |
      | Jones     | Smith    | 4029986730 | 611 FENWICK DR,PAPILLION,NE 68046,USA | STANDARD            | LEASE        | BASIC       | Ctl@Ctl.com | 4029986730 |   02 |    02 | 1987 | 345038058 | 4485389438108352 |    37638 | 3 devices       | ESHOP ORDER TEST BY AUTOMATION |

  # ATC00010
  @HSIHomePhoneWithEquipments
  Scenario Outline: Create a POTS Order by selecting all Equipments
    Given I should be on SFC login screen
    When I enter username and password
    Then I click on create new account
    Then I enter the "<firstName>" "<lastName>" "<phoneNo>" and "<address>" in new acquisition page
    Then I validate the address and save it
    Then I click on order eshop button
    Then I should be in Eshop Product offer page
    And I select HomePhone
    Then I select the best "<Installation_option>" installation option
    And I select Your "<Modem_Option>" Modem option
    And I select "<Ease_Option>" Ease Option
    Then I select the number of device needed "<Device Quantity>"
    Then I select required option for voice mail "<Voice Mail>"
    Then I select required option for Wire Maintenance Plan "<Wire Maintenance Plan>"
    Then I select required option for Port in a phone number? "<Port in a phone number?>"
    Then I select required option for Need new jacks or wiring? "<Need new jacks or wiring?>"
    And I click on continue button
    Then I should be in customize service page
    # Then I select all the equipments "VAS-CF"
    Then I select specific equipments "VAS-CF" and "3 Way Calling~60 Select Call Reject~Busy Redial~Call Forwarding~Call Forwarding  - Remote Activation~Call Rejection   - Anonymous~Call Return~Call Waiting~Caller ID~Caller ID With Call Waiting~Long Distance Alert~No Solicitation~Security Screen~Selective Call Waiting ID~Voice Mail  - Indicator~Voice Mail  - Visual"
    # Call Forwarding  - Busy Fixed~Call Forwarding  - Busy~Call Forwarding  - No Answer~
    Then I select specific equipments "VAS" and "Caller ID Block No Pay~Caller ID Block Pay"
    Then I select specific equipments "VAS-TR" and "900/976 Block~Carrier Access Code Block~International Call Block~Restrict - 3rd Party Calls~Toll Restrict No Deposit~Toll Restrict Res"
    And I select customize services Internet
    Then I select specific equipments "OPT-EQP" and "DSL Wall-Mount Filter~DSL In-Line Filter~HSI Wireless USB Adapter"
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
      | firstName | lastName | phoneNo    | address                               | Installation_option | Modem_Option | Ease_Option | email       | SMSNo      | Date | Month | Year | SSN       | card             | zip code | Device Quantity | Voice Mail | Wire Maintenance Plan | Port in a phone number? | Need new jacks or wiring? | Additional Order Remarks       |
      | Jones     | Smith    | 4029986730 | 611 FENWICK DR,PAPILLION,NE 68046,USA | STANDARD            | LEASE        | BASIC       | Ctl@Ctl.com | 4029986730 |   02 |    02 | 1987 | 345038058 | 4485389438108352 |    37638 | 2 devices       | No         | No                    | No                      | No Work Is Needed ($0)    | ESHOP ORDER TEST BY AUTOMATION |

  #ATC00012
  @HomePhoneOnlyAccountsWithAllEquipments
  Scenario Outline: POTS with all equipment’s
    Given I should be on SFC login screen
    When I enter username and password
    Then I click on create new account
    Then I enter the "<firstName>" "<lastName>" "<phoneNo>" and "<address>" in new acquisition page
    Then I validate the address and save it
    Then I click on order eshop button
    Then I should be in Eshop Product offer page
    And I select HomePhone only by deselecting Internet
    #And I select One Pty Residence Line
    Then I select required option for voice mail "<Voice Mail>"
    Then I select required option for Wire Maintenance Plan "<Wire Maintenance Plan>"
    Then I select required option for Port in a phone number? "<Port in a phone number?>"
    Then I select required option for Need new jacks or wiring? "<Need new jacks or wiring?>"
    And I click on continue button
    Then I should be in customize service page
    Then I select specific equipments "VAS-CF" and "3 Way Calling~60 Select Call Reject~Busy Redial~Call Forwarding~Call Forwarding  - Remote Activation~Call Rejection   - Anonymous~Call Return~Call Waiting~Caller ID~Caller ID With Call Waiting~Long Distance Alert~No Solicitation~Security Screen~Selective Call Waiting ID~Voice Mail  - Indicator~Voice Mail  - Visual"
    # Call Forwarding  - Busy Fixed~Call Forwarding  - Busy~Call Forwarding  - No Answer~
    Then I select specific equipments "VAS" and "Caller ID Block No Pay~Caller ID Block Pay"
    Then I select specific equipments "VAS-TR" and "900/976 Block~Carrier Access Code Block~International Call Block~Restrict - 3rd Party Calls~Toll Restrict No Deposit~Toll Restrict Res"
    #Then I add the equipments in customize service page
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
      | firstName | lastName | phoneNo    | address                               | email       | SMSNo      | Date | Month | Year | SSN       | card             | zip code | Voice Mail | Wire Maintenance Plan | Port in a phone number? | Need new jacks or wiring? | Additional Order Remarks       |
      | Jones     | Smith    | 4029986730 | 611 FENWICK DR,PAPILLION,NE 68046,USA | Ctl@Ctl.com | 4029986730 |   02 |    02 | 1987 | 345038058 | 4485389438108352 |    37638 | No         | No                    | No                      | No Work Is Needed ($0)    | ESHOP ORDER TEST BY AUTOMATION |
