@EshopTestScripts @EShop_Insprint_Automation
Feature: Insprint Automation Sample Feature

  #TC366257
  @HSIModifyCBR
  Scenario Outline: Modify contact number in scheduling page
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
    And I modify phone number"<Contact Number>"
    And I click to reserve appointment

    Examples: 
      | firstName | lastName | phoneNo    | address                                | Installation_option | Modem_Option | Ease_Option | Device Quantity | Contact Number |
      | Jones     | Smith    | 4899999343 | 1693 Garfield Ave,Dubuque,IA 52001,USA | STANDARD            | LEASE        | BASIC       | 2 devices       |     7265452345 |

  #TC366281
  @HSIMandatoryCBR
  Scenario Outline: Validate contact number field is mandatory in scheduling page
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
    And I check phone number mandatory in scheduling page

    Examples: 
      | firstName | lastName | phoneNo    | address                                | Installation_option | Modem_Option | Ease_Option | Device Quantity | Contact Number |
      | Jones     | Smith    | 4899999343 | 1693 Garfield Ave,Dubuque,IA 52001,USA | STANDARD            | LEASE        | BASIC       | 2 devices       |     7265452345 |

  #TC366311
  @HSICBROrderSummary1
  Scenario Outline: Validate modified contact number in scheduling page is saved and displayed in Order summary page
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
    And I modify phone number"<Contact Number>"
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
    Then I validate phone number entered in scheduling page"<Contact Number>"

    Examples: 
      | firstName | lastName | phoneNo    | address                              | Installation_option | Modem_Option | Ease_Option | email       | SMSNo      | Date | Month | Year | SSN       | card             | zip code | Device Quantity | Additional Order Remarks       | Contact Number |
      #| Jones     | Smith    | 4899999343 | 1693 Garfield Ave,Dubuque,IA 52001,USA| STANDARD            | LEASE        | BASIC       | Ctl@Ctl.com | 4029986730 |   02 |    02 | 1987 | 345038058 | 4485389438108352 |    37638 | 2 devices       | ESHOP ORDER TEST BY AUTOMATION | 7265452345     |
      | Jones     | Smith    | 4899999343 | 3066 SHADY LN,LITTLETON,CO 80126,USA | STANDARD            | LEASE        | BASIC       | Ctl@Ctl.com | 4029986730 |   02 |    02 | 1987 | 345038058 | 4485389438108352 |    37638 | 2 devices       | ESHOP ORDER TEST BY AUTOMATION |     7265452345 |

  #TC366268
  @HSICBRNoValidationAgainstSFC
  Scenario Outline: Validate primary phone number entered in SFC is pre-populated in scheduling page
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
    Then I check phone number in scheduling page"<phoneNo>"

    Examples: 
      | firstName | lastName | phoneNo    | address                              | Installation_option | Modem_Option | Ease_Option | Device Quantity |
      | THOMAS    | HILLA    | 4899999343 | 3066 SHADY LN,LITTLETON,CO 80126,USA | STANDARD            | LEASE        | BASIC       | 2 devices       |

  #TC366295 - 1
  @HSIPendingOrderSchedulingContactNumberMatch
  Scenario Outline: Create a HSI new install Order and validate pending order scheduling page pre-populate contact number
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
    And I enter "<email>" and "<SMSNo>"
    And I enter date "<Date>" month "<Month>" and year "<Year>" of birth
    And I enter SSN number "<SSN>"
    And I select credit as "Yes"
    And I click on account Continue button
    And I click again click Continue button on account
    And I selected Yes for the review in order summary page
    Then I clicked submit order button
    Then I get account number from application
    Then I move back to existing SFC page
    Then I search order in SFC page with account number
    Then I click on order eshop button in SFC page to proceed to Eshop Page
    Then I click on scheduling button on pending order page
    Then I check phone number in scheduling page"<phoneNo>"

    Examples: 
      | firstName | lastName | phoneNo    | address                              | email       | SMSNo      | Installation_option | Date | Month | Year | SSN       | Device Quantity | Modem_Option | Ease_Option |
      | Thomas    | Hilla    | 4029986730 | 3066 SHADY LN,LITTLETON,CO 80126,USA | Ctl@Ctl.com | 4029986730 | STANDARD            |   02 |    02 | 1987 | 666446831 | 2 devices       | LEASE        | BASIC       |

  #TC366295 - 2
  @HSIPendingOrderSchedulingContactNumberMatch1
  Scenario Outline: Validate pending order scheduling page pre-populate contact number
    Given I should be on SFC login screen
    When I enter username and password
    Then I search order in SFC page with account number "<account number>"
    Then I click on order eshop button in SFC page to proceed to Eshop Page
    Then I click on scheduling button on pending order page
    Then I check phone number in scheduling page"<phoneNo>"

    Examples: 
      | account number | phoneNo    |
      |      578380206 | 4899999343 |

  #TC366326
  @HSIOrderLevelTNMatchWithSchedulingContactNumber11
  Scenario Outline: Create a HSI new install Order and validate pending order scheduling page pre-populate contact number
    Given I should be on SFC login screen
    When I enter username and password
    Then I search order in SFC page with account number "<account number>"
    #Then I click on create new account
    #Then I enter the "<firstName>" "<lastName>" "<phoneNo>" and "<address>" in new acquisition page
    #Then I validate the address and save it
    #Then I click on order eshop button
    #Then I should be in Eshop Product offer page
    #Then I select the best "<Installation_option>" installation option
    #And I select Your "<Modem_Option>" Modem option
    #And I select "<Ease_Option>" Ease Option
    #Then I select the number of device needed "<Device Quantity>"
    #And I click on continue button
    #Then I should be in customize service page
    #And I click again on contine button
    #And I modify phone number"<Contact Number>"
    #And I click to reserve appointment
    #And I click on continue button of scheduling page
    #And I enter "<email>" and "<SMSNo>"
    #And I enter date "<Date>" month "<Month>" and year "<Year>" of birth
    #And I enter SSN number "<SSN>"
    #And I select credit as "Yes"
    #And I click on account Continue button
    #And I click again click Continue button on account
    #And I selected Yes for the review in order summary page
    #Then I clicked submit order button
    #Then I get account number from application
    #Then I move back to existing SFC page
    #Then I search order in SFC page with account number
    #Then I click on order eshop button in SFC page to proceed to Eshop Page
    #Then I click on order link in SFC to proceed to order details page
    #Then I validate phone number in order details page in SFC"<Contact Number>"

    #Then I validate phone number in SFC page"<Contact Number>"
    #Then I click on scheduling button on pending order page
    #Then I check phone number in scheduling page"<Contact Number>"
    Examples: 
      | firstName | lastName | phoneNo    | address                              | email       | SMSNo      | Installation_option | Date | Month | Year | SSN       | Device Quantity | Modem_Option | Ease_Option | Contact Number | account number |
      | Thomas    | Hilla    | 4043454343 | 3066 SHADY LN,LITTLETON,CO 80126,USA | Ctl@Ctl.com | 4043454343 | STANDARD            |   02 |    02 | 1987 | 666446831 | 2 devices       | LEASE        | BASIC       |     4575412589 |      578394848 |

  #TC366301
  @NonDispatchOrder1
  Scenario Outline: Validate modify/edit contact number in scheduling page for non dispatch orders
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
    #And I modify phone number"<Contact Number>"
    #And I click to reserve appointment
    And I modify phone number"<Contact Number>"
    And I click on continue button of scheduling page

    Examples: 
      | firstName | lastName | phoneNo    | address                              | email       | SMSNo      | Date | Month | Year | SSN       | Voice Mail | Wire Maintenance Plan | Port in a phone number? | Need new jacks or wiring? | Additional Order Remarks       | Contact Number |
      | Thomas    | Hilla    | 4029986730 | 3066 SHADY LN,LITTLETON,CO 80126,USA | Ctl@Ctl.com | 4029986730 |   02 |    02 | 1987 | 666446831 | No         | No                    | No                      | No Work Is Needed ($0)    | ESHOP ORDER TEST BY AUTOMATION |     7587458745 |
