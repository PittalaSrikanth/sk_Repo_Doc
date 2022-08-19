@EshopTestScripts @EShopFunctional
Feature: POTS Order Scenarios

  #TC260986
  @HSI+POTS @EShopSanity
  Scenario Outline: Create a HSI + POTS Order
    Given I should be on SFC login screen
    When I enter username and password
    Then I click on create new account
    Then I enter the "<firstName>" "<lastName>" "<phoneNo>" and "<address>" in new acquisition page
    Then I validate the address and save it
    Then I click on order eshop button
    Then I should be in Eshop Product offer page
    And I select HomePhone
    And I select the suitable matching offer "<Matching Offers>"
    Then I select the best "<Installation_option>" installation option
    And I select Your "<Modem_Option>" Modem option
    And I select "<Ease_Option>" Ease Option
    Then I select the number of device needed "<Device Quantity>"
    # Matching Offers : Home Phone with Unlimited LD/Essential Home Phone
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
    Then I enter the special remark in Additional Order Remarks field "<Additional Order Remarks>"
    Then I clicked submit order button
    Then I get account number from application

    Examples: 
      | firstName | lastName | phoneNo    | Matching Offers              | address                               | Installation_option | Modem_Option | Ease_Option | email       | SMSNo      | Date | Month | Year | SSN       | card             | zip code | Device Quantity | Voice Mail | Wire Maintenance Plan | Port in a phone number? | Need new jacks or wiring? | Additional Order Remarks       |
      | MARIANNE  | HELTON   | 4029986730 | Home Phone with Unlimited LD | 611 FENWICK DR,PAPILLION,NE 68046,USA | STANDARD            | LEASE        | BASIC       | Ctl@Ctl.com | 4029986730 |   02 |    02 | 1987 | 666150907 | 4485389438108352 |    37638 | 2 devices       | No         | No                    | No                      | No Work Is Needed ($0)    | ESHOP ORDER TEST BY AUTOMATION |

  #TC260986
  @POTSOnly @EShopSanity
  Scenario Outline: Create a POTS Only Order
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
    Then I enter the special remark in Additional Order Remarks field "<Additional Order Remarks>"
    Then I clicked submit order button
    Then I get account number from application

    Examples: 
      | firstName | lastName | phoneNo    | address                               | email       | SMSNo      | Date | Month | Year | SSN       | card             | zip code | Voice Mail | Wire Maintenance Plan | Port in a phone number? | Need new jacks or wiring? | Additional Order Remarks       |
      | MARIANNE  | HELTON   | 4029986730 | 611 FENWICK DR,PAPILLION,NE 68046,USA | Ctl@Ctl.com | 4029986730 |   02 |    02 | 1987 | 666150907 | 4485389438108352 |    37638 | No         | No                    | No                      | No Work Is Needed ($0)    | ESHOP ORDER TEST BY AUTOMATION |

  #ATC00004
  @HomePhoneOnlyAccountsWithbasicline
  Scenario Outline: POTS ONLY accounts with Basic Line ONLY (1PTY Residential Line)
    Given I should be on SFC login screen
    When I enter username and password
    Then I click on create new account
    Then I enter the "<firstName>" "<lastName>" "<phoneNo>" and "<address>" in new acquisition page
    Then I validate the address and save it
    Then I click on order eshop button
    Then I should be in Eshop Product offer page
    And I select HomePhone only by deselecting Internet
    And I select One Pty Residence Line
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
    Then I enter the special remark in Additional Order Remarks field "<Additional Order Remarks>"
    Then I clicked submit order button
    Then I get account number from application

    Examples: 
      | firstName | lastName | phoneNo    | address                               | email       | SMSNo      | Date | Month | Year | SSN       | card             | zip code | Voice Mail | Wire Maintenance Plan | Port in a phone number? | Need new jacks or wiring? | Additional Order Remarks       |
      | MARIANNE  | HELTON   | 4029986730 | 611 FENWICK DR,PAPILLION,NE 68046,USA | Ctl@Ctl.com | 4029986730 |   02 |    02 | 1987 | 666150907 | 4485389438108352 |    37638 | No         | No                    | No                      | No Work Is Needed ($0)    | ESHOP ORDER TEST BY AUTOMATION |

  #ATC00005
  @HomePhoneLifeUnlimitedPhoneUnlimitedCalling
  Scenario Outline: POTS ONLY accounts with Price for Life with Unlimited Phone Calling
    Given I should be on SFC login screen
    When I enter username and password
    Then I click on create new account
    Then I enter the "<firstName>" "<lastName>" "<phoneNo>" and "<address>" in new acquisition page
    Then I validate the address and save it
    Then I click on order eshop button
    Then I should be in Eshop Product offer page
    And I select HomePhone only by deselecting Internet
    And I select Price for Life Unlimited Phone unlimited Calling
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
    Then I enter the special remark in Additional Order Remarks field "<Additional Order Remarks>"
    Then I clicked submit order button
    Then I get account number from application

    Examples: 
      | firstName | lastName | phoneNo    | address                               | email       | SMSNo      | Date | Month | Year | SSN       | card             | zip code | Voice Mail | Wire Maintenance Plan | Port in a phone number? | Need new jacks or wiring? | Additional Order Remarks       |
      | MARIANNE  | HELTON   | 4029986730 | 611 FENWICK DR,PAPILLION,NE 68046,USA | Ctl@Ctl.com | 4029986730 |   02 |    02 | 1987 | 666150907 | 4485389438108352 |    37638 | No         | No                    | No                      | No Work Is Needed ($0)    | ESHOP ORDER TEST BY AUTOMATION |

  #ATC00006, ATC00007, ATC00008
  @HomePhoneListingOptions
  Scenario Outline: POTS order - with Listed, Non Listed and Non Published
    Given I should be on SFC login screen
    When I enter username and password
    Then I click on create new account
    Then I enter the "<firstName>" "<lastName>" "<phoneNo>" and "<address>" in new acquisition page
    Then I validate the address and save it
    Then I click on order eshop button
    Then I should be in Eshop Product offer page
    And I select HomePhone only by deselecting Internet
    # Then I select One Pty Residence Line
    Then I select required option for voice mail "<Voice Mail>"
    Then I select required option for Wire Maintenance Plan "<Wire Maintenance Plan>"
    Then I select required option for Port in a phone number? "<Port in a phone number?>"
    Then I select required option for Need new jacks or wiring? "<Need new jacks or wiring?>"
    And I click on continue button
    Then I should be in customize service page
    Then I click List Toggle
    Then I select Listing options "<Listing_Options>"
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
      | firstName | lastName | phoneNo    | address                               | Listing_Options | email       | SMSNo      | Date | Month | Year | SSN       | card             | zip code | Voice Mail | Wire Maintenance Plan | Port in a phone number? | Need new jacks or wiring? | Additional Order Remarks       |
      | MARIANNE  | HELTON   | 4029986730 | 611 FENWICK DR,PAPILLION,NE 68046,USA | Listed          | Ctl@Ctl.com | 4029986730 |   02 |    02 | 1987 | 666150907 | 4485389438108352 |    37638 | No         | No                    | No                      | No Work Is Needed ($0)    | ESHOP ORDER TEST BY AUTOMATION |
