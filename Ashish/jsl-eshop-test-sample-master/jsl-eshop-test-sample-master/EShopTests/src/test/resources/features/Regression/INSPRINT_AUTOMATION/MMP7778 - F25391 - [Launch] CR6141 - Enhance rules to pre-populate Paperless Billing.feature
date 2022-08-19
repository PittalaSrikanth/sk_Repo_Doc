@EshopTestScripts @EShop_Insprint_Automation
Feature: MMP7778 - F25391 - [Launch] CR6141 - Enhance rules to pre-populate Paperless Billing

  @EShop_Insprint_Automation @Regression
  Scenario Outline: TC365302 Enhance rules to pre-populate Paperless Billing - NI Order - when the email address is entered
    Given I should be on SFC login screen
    When I enter username and password
    Then I click on create new account
    Then I enter the "<firstName>" "<lastName>" "<phoneNo>"  "<address>" and "<email>" in new acquisition page with a valid email
    Then I validate the address and save it
    Then I click on order eshop button
    Then I should be in Eshop Product offer page
    Then I select the best "<Installation_option>" installation option
    And I select Your "<Modem_Option>" Modem option
    And I select "<Ease_Option>" Ease Option
    Then I select the number of device needed "<Device Quantity>"
    And I click on continue button
    And I click on OK Got it button on Order Disclosures dialog box for NI Order for HSI
    Then I should be in customize service page
    And I click again on contine button
    And I click to reserve appointment
    And I click on continue button of scheduling page
    And I click on OK Got it button on Order Disclosures dialog box for NI Order for HSI
    And I validate if "<email>" is same as entered in SFC
    And I validate if paperless billing is selected by default
    And I enter date "<Date>" month "<Month>" and year "<Year>" of birth
    And I enter SSN number "<SSN>"
    And I select credit as "Yes"
    And I click on account Continue button
    #And I click on payNow
    #And I should be at make payment page
    #And I fill all card details as "<card>" and "<zip code>"
    #And I click submit button on verify InformationPage
    And I click again click Continue button on account
    And I selected Yes for the review in order summary page
    Then I enter the special remark in Additional Order Remarks field "<Additional Order Remarks>"
    Then I clicked submit order button
    Then I get account number from application
    Then I validate the ensemble table is storing details "<Is paperless Billing>" for "<BP SEQ NO>" for paperless billing in "<Database>"
    And I validate the ensemble table is email "<email>" details for paperless billing in "<Database>"

    Examples: 
      | firstName | lastName | phoneNo    | address                              | Installation_option | Modem_Option | Ease_Option | email             | SMSNo      | Date | Month | Year | SSN       | card             | zip code | Device Quantity | Additional Order Remarks       | Is paperless Billing | BP SEQ NO | Database       |
      | Thomas    | Hilla    | 3182648522 | 3066 SHADY LN,LITTLETON,CO 80126,USA | Standard            | LEASE        | BASIC       | testmail@ctli.com | 4029986730 |   02 |    02 | 1987 | 666446831 | 4485389438108352 |    37638 | 2 devices       | ESHOP ORDER TEST BY AUTOMATION |                    0 |         1 | Database_Test2 |

  @EShop_Insprint_Automation
  Scenario Outline: TC365305 Enhance rules to pre-populate Paperless Billing - NI Order - when the email address is entered
    Given I should be on SFC login screen
    When I enter username and password
    Then I click on create new account
    Then I enter the "<firstName>" "<lastName>" "<phoneNo>"  "<address>" and "<email>" in new acquisition page with a valid email
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
    And I validate if "<email>" is same as entered in SFC
    And I validate if paperless billing is selected by default
    And I Validate if Mail my Bill is deselected
    And I select the Mail my Bill option
    When I change the "<email>" ID and change the focus from email id field
    Then I validate if paperless billing is selected by default
    And I enter date "<Date>" month "<Month>" and year "<Year>" of birth
    And I enter SSN number "<SSN>"
    And I select credit as "Yes"
    And I click on account Continue button
    #And I click on payNow
    #And I should be at make payment page
    #And I fill all card details as "<card>" and "<zip code>"
    #And I click submit button on verify InformationPage
    And I click again click Continue button on account
    And I selected Yes for the review in order summary page
    Then I enter the special remark in Additional Order Remarks field "<Additional Order Remarks>"
    Then I clicked submit order button
    Then I get account number from application
    Then I validate the ensemble table is storing details "<Is paperless Billing>" for "<BP SEQ NO>" for paperless billing in "<Database>"
    And I validate the ensemble table is email "<email>" details for paperless billing in "<Database>"

    Examples: 
      | firstName | lastName | phoneNo    | address                             | Installation_option | Modem_Option | Ease_Option | email             | SMSNo      | Date | Month | Year | SSN       | card             | zip code | Device Quantity | Additional Order Remarks       | Is paperless Billing | BP SEQ NO | Database       |
      | Thomas    | Hilla    | 3182648522 | 14602 Curtis Ave,Omaha,NE 68116,USA | Standard            | LEASE        | BASIC       | testmail@ctli.com | 4029986730 |   02 |    02 | 1987 | 666446831 | 4485389438108352 |    37638 | 2 devices       | ESHOP ORDER TEST BY AUTOMATION |                    0 |         1 | Database_Test1 |

  @EShop_Insprint_Automation
  Scenario Outline: TC365307 Enhance rules to pre-populate Paperless Billing - NI Order - when the customer doesnot want the paperless bill
    Given I should be on SFC login screen
    When I enter username and password
    Then I click on create new account
    Then I enter the "<firstName>" "<lastName>" "<phoneNo>"  "<address>" and "<email>" in new acquisition page with a valid email
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
    And I validate if "<email>" is same as entered in SFC
    And I validate if paperless billing is selected by default
    When I select the Mail my Bill option
    Then I validate if "None" is selected as default special format
    And I validate if Special format contains "None" ,"Braille delivery", "Large print" and "Spanish print"
    And I select special format as "<Special Format>"
    And I enter date "<Date>" month "<Month>" and year "<Year>" of birth
    And I enter SSN number "<SSN>"
    And I select credit as "Yes"
    And I click on account Continue button
    #And I click on payNow
    #And I should be at make payment page
    #And I fill all card details as "<card>" and "<zip code>"
    #And I click submit button on verify InformationPage
    And I click again click Continue button on account
    And I selected Yes for the review in order summary page
    Then I enter the special remark in Additional Order Remarks field "<Additional Order Remarks>"
    Then I clicked submit order button
    Then I get account number from application
    Then I validate the ensemble table is storing details "<Is paperless Billing>" for "<BP SEQ NO>" for paperless billing in "<Database>"
    And I validate the ensemble table is email "<email>" details for paperless billing in "<Database>"

    Examples: 
      | firstName | lastName | phoneNo    | address                                       | Installation_option | Modem_Option | Ease_Option | email             | SMSNo      | Date | Month | Year | SSN       | card             | zip code | Device Quantity | Additional Order Remarks       | Is paperless Billing | BP SEQ NO | Database       | Special Format |
      | Thomas    | Hilla    | 3182648522 | 1902 INDEPENDENCE AVE N, MINNEAPOLIS, MN 5542 | Standard            | LEASE        | BASIC       | testmail@ctli.com | 4029986730 |   02 |    02 | 1987 | 666446831 | 4485389438108352 |    37638 | 2 devices       | ESHOP ORDER TEST BY AUTOMATION |                    1 |         1 | Database_Test1 | None           |

  @EShop_Insprint_Automation
  Scenario Outline: TC365310 Enhance rules to pre-populate Paperless Billing - NI Order - when the user selects Mail radio button option
    Given I should be on SFC login screen
    When I enter username and password
    Then I click on create new account
    Then I enter the "<firstName>" "<lastName>" "<phoneNo>"  "<address>" and "<email>" in new acquisition page with a valid email
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
    And I validate if "<email>" is same as entered in SFC
    And I validate if paperless billing is selected by default
    When I select the Mail my Bill option
    Then I validate if "None" is selected as default special format
    And I validate if Special format contains "None" ,"Braille delivery", "Large print" and "Spanish print"
    And I select special format as "<Special Format>"
    And I enter date "<Date>" month "<Month>" and year "<Year>" of birth
    And I enter SSN number "<SSN>"
    And I select credit as "Yes"
    And I click on account Continue button
    #And I click on payNow
    #And I should be at make payment page
    #And I fill all card details as "<card>" and "<zip code>"
    #And I click submit button on verify InformationPage
    And I click again click Continue button on account
    And I selected Yes for the review in order summary page
    Then I enter the special remark in Additional Order Remarks field "<Additional Order Remarks>"
    Then I clicked submit order button
    Then I get account number from application
    Then I validate the ensemble table is storing details "<Is paperless Billing>" for "<BP SEQ NO>" for paperless billing in "<Database>"
    And I validate the ensemble table is email "<email>" details for paperless billing in "<Database>"

    Examples: 
      | firstName | lastName | phoneNo    | address                                       | Installation_option | Modem_Option | Ease_Option | email             | SMSNo      | Date | Month | Year | SSN       | card             | zip code | Device Quantity | Additional Order Remarks       | Is paperless Billing | BP SEQ NO | Database       | Special Format |
      | Thomas    | Hilla    | 3182648522 | 1902 INDEPENDENCE AVE N, MINNEAPOLIS, MN 5542 | Standard            | LEASE        | BASIC       | testmail@ctli.com | 4029986730 |   02 |    02 | 1987 | 666446831 | 4485389438108352 |    37638 | 2 devices       | ESHOP ORDER TEST BY AUTOMATION |                    1 |         1 | Database_Test1 | None           |

  @EShop_Insprint_Automation
  Scenario Outline: TC365311 Enhance rules to pre-populate Paperless Billing - NI Order - when the user unselects Mail radio button option
    Given I should be on SFC login screen
    When I enter username and password
    Then I click on create new account
    Then I enter the "<firstName>" "<lastName>" "<phoneNo>"  "<address>" and "<email>" in new acquisition page with a valid email
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
    And I validate if "<email>" is same as entered in SFC
    And I validate if paperless billing is selected by default
    When I select the Mail my Bill option
    Then I validate if "None" is selected as default special format
    When I select Paperless billing option
    Then I validate if special format dropdown is disabled
    And I enter date "<Date>" month "<Month>" and year "<Year>" of birth
    And I enter SSN number "<SSN>"
    And I select credit as "Yes"
    And I click on account Continue button
    #And I click on payNow
    #And I should be at make payment page
    #And I fill all card details as "<card>" and "<zip code>"
    #And I click submit button on verify InformationPage
    And I click again click Continue button on account
    And I selected Yes for the review in order summary page
    Then I enter the special remark in Additional Order Remarks field "<Additional Order Remarks>"
    Then I clicked submit order button
    Then I get account number from application
    Then I validate the ensemble table is storing details "<Is paperless Billing>" for "<BP SEQ NO>" for paperless billing in "<Database>"
    And I validate the ensemble table is email "<email>" details for paperless billing in "<Database>"

    Examples: 
      | firstName | lastName | phoneNo    | address                                       | Installation_option | Modem_Option | Ease_Option | email             | SMSNo      | Date | Month | Year | SSN       | card             | zip code | Device Quantity | Additional Order Remarks       | Is paperless Billing | BP SEQ NO | Database       | Special Format |
      | Thomas    | Hilla    | 3182648522 | 1902 INDEPENDENCE AVE N, MINNEAPOLIS, MN 5542 | Standard            | LEASE        | BASIC       | testmail@ctli.com | 4029986730 |   02 |    02 | 1987 | 666446831 | 4485389438108352 |    37638 | 2 devices       | ESHOP ORDER TEST BY AUTOMATION |                    0 |         1 | Database_Test1 | None           |

  @EShop_Insprint_Automation
  Scenario Outline: TC365308 Enhance rules to pre-populate Paperless Billing - NI Order - when Invalid email address or Invalid address is provided by the agent and passed in salesforce
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
    And I select the provided due date for installation "<Due Date>"
    #And I click to reserve appointment
    And I click on continue button of scheduling page
    And I validate if Mail my Bill is selected by default
    And I validate if paperless billing is disabled
    Then I validate if "None" is selected as default special format
    And I enter "<email>" and "<SMSNo>"
    When I select the Mail my Bill option
    And I enter date "<Date>" month "<Month>" and year "<Year>" of birth
    And I enter SSN number "<SSN>"
    And I select credit as "Yes"
    And I click on account Continue button
    #And I click on payNow
    #And I should be at make payment page
    #And I fill all card details as "<card>" and "<zip code>"
    #And I click submit button on verify InformationPage
    And I click again click Continue button on account
    And I selected Yes for the review in order summary page
    Then I enter the special remark in Additional Order Remarks field "<Additional Order Remarks>"
    Then I clicked submit order button
    Then I get account number from application
    Then I validate the ensemble table is storing details "<Is paperless Billing>" for "<BP SEQ NO>" for paperless billing in "<Database>"
    And I validate the ensemble table is email "<email>" details for paperless billing in "<Database>"

    Examples: 
      | firstName | lastName | phoneNo    | address                                      | Installation_option | Modem_Option | Ease_Option | email             | SMSNo      | Date | Month | Year | SSN       | card             | zip code | Device Quantity | Additional Order Remarks       | Is paperless Billing | BP SEQ NO | Database       | Special Format | Due Date |
      | Thomas    | Hilla    | 3182648522 | 1902 INDEPENDENCE AVE N, MINNEAPOLIS, MN 554 | Standard            | LEASE        | BASIC       | testmail@ctli.com | 4029986730 |   02 |    02 | 1987 | 666446831 | 4485389438108352 |    37638 | 2 devices       | ESHOP ORDER TEST BY AUTOMATION |                    1 |         1 | Database_Test1 | None           | Jun4     |

  @EShop_Insprint_Automation
  Scenario Outline: TC365309 Enhance rules to pre-populate Paperless Billing - NI Order - when the user selects Customer declines email checkbox option
    Given I should be on SFC login screen
    When I enter username and password
    Then I click on create new account
    Then I enter the "<firstName>" "<lastName>" "<phoneNo>"  "<address>" and "<email>" in new acquisition page with a valid email
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
    When I click on Customer denies email checkbox
    Then I validate if Mail my Bill is selected by default
    And I Validate if email field is disabled
    And I validate if paperless billing is disabled
    Then I validate if "None" is selected as default special format

    Examples: 
      | firstName | lastName | phoneNo    | address                                       | Installation_option | Modem_Option | Ease_Option | email             | SMSNo      | Date | Month | Year | SSN       | card             | zip code | Device Quantity | Additional Order Remarks       | Is paperless Billing | BP SEQ NO | Database       | Special Format |
      | Thomas    | Hilla    | 3182648522 | 1902 INDEPENDENCE AVE N, MINNEAPOLIS, MN 5542 | Standard            | LEASE        | BASIC       | testmail@ctli.com | 4029986730 |   02 |    02 | 1987 | 666446831 | 4485389438108352 |    37638 | 2 devices       | ESHOP ORDER TEST BY AUTOMATION |                    1 |         1 | Database_Test1 | None           |

  #TC365302 is prerequisite for this TC. Execute it first.
  @EShop_Insprint_Automation @Regression @MACDFlow
  Scenario Outline: TC365342 Verify that Account Information page should be displayed to update or review billing address when an agent presses the continue button on Scheduling page for vacation suspend orders
    Given I should be on SFC login screen
    When I enter username and password
    #Below two commented steps are Future Ready steps for MACD Scenarios
    #Then I move back to existing SFC page
    #Then I search order in SFC page with account number
    Then I search order in SFC page with account number "<account number>"
    Then I click on order eshop button in SFC page to proceed to Eshop Page
    Then I click on Vacation Service
    And I select Vacation Suspend from the dialog box
    And I click on Continue button on vacation service dialog box
    And I click on Continue button on vacation service dialog box again
    And I click on OK Got it button on Order Disclosures dialog box for Vacation Suspend for HSI
    When I click on continue button on vacation order scheduling page
    Then I validate if "<email>" is present for Vacation Suspend order in Account Information page
    And I validate if email field is editable "<changed email>" for Vacation Suspend order in Account Information page
    And I validate if Update or Review Billing address is present for Vacation Suspend order in Account Information page
    And I select current billing address
    And I click on continue button for Vacation Suspend order in Account Information page
    And I selected Yes for the review in order summary page
    Then I clicked submit order button
    Then I get account number from application
    Then I validate the ensemble table is storing details "<Is paperless Billing>" for "<BP SEQ NO>" for paperless billing in "<Database>"
    And I validate the ensemble table is email "<changed email>" details for paperless billing in "<Database>"

    Examples: 
      | Env  | firstName | lastName | phoneNo    | account number | email             | changed email     | Is paperless Billing | BP SEQ NO | Database       |
      | ITV2 | Jones     | Smith    | 4029986730 |      578415208 | testmail@ctli.com | testmail@ctli.com | 0null                |         2 | Database_Test2 |

  #TC365302 is prerequisite for this TC. Execute it first.
  @EShop_Insprint_Automation
  Scenario Outline: TC365354 Verify that ESHOP should display an editable email address field with the current email address populated when account currently has paperless billing for VAC_SUS order.
    Given I should be on SFC login screen
    When I enter username and password
    #Below two commented steps are Future Ready steps for MACD Scenarios
    #Then I move back to existing SFC page
    #Then I search order in SFC page with account number
    Then I search order in SFC page with account number "<account number>"
    Then I click on order eshop button in SFC page to proceed to Eshop Page
    Then I click on Vacation Service
    And I select Vacation Suspend from the dialog box
    And I click on Continue button on vacation service dialog box
    And I click on Continue button on vacation service dialog box again
    #And I click on OK Got it button on Order Disclosures dialog box for Vacation Suspend
    When I click on continue button on vacation order scheduling page
    Then I validate if "<email>" is present for Vacation Suspend order in Account Information page
    And I validate if email field is editable "<changed email>" for Vacation Suspend order in Account Information page
    And I validate if Update or Review Billing address is present for Vacation Suspend order in Account Information page
    And I select current billing address
    And I click on continue button for Vacation Suspend order in Account Information page
    And I selected Yes for the review in order summary page
    Then I clicked submit order button
    Then I get account number from application
    Then I validate the ensemble table is storing details "<Is paperless Billing>" for "<BP SEQ NO>" for paperless billing in "<Database>"
    And I validate the ensemble table is email "<changed email>" details for paperless billing in "<Database>"

    Examples: 
      | Env  | firstName | lastName | phoneNo    | account number | email             | changed email         | Is paperless Billing | BP SEQ NO | Database       |
      | ITV1 | Jones     | Smith    | 4029986730 |      578233560 | testmail@ctli.com | changedemail@ctli.com | 0null                |         2 | Database_Test1 |

  #TC365302 is prerequisite for this TC. Execute it first.
  @EShop_Insprint_Automation
  Scenario Outline: TC365349 Verify that a paperless billing section should now be displayed at the top of the page above the billing address section for VAC_SUS/VAC_REST.
    Given I should be on SFC login screen
    When I enter username and password
    #Below two commented steps are Future Ready steps for MACD Scenarios
    #Then I move back to existing SFC page
    #Then I search order in SFC page with account number
    Then I search order in SFC page with account number "<account number>"
    Then I click on order eshop button in SFC page to proceed to Eshop Page
    Then I click on Vacation Service
    And I select Vacation Suspend from the dialog box
    And I click on Continue button on vacation service dialog box
    And I click on Continue button on vacation service dialog box again
    #And I click on OK Got it button on Order Disclosures dialog box for Vacation Suspend
    When I click on continue button on vacation order scheduling page
    Then I validate if "<email>" is present for Vacation Suspend order in Account Information page
    And I validate if email field is editable "<changed email>" for Vacation Suspend order in Account Information page
    And I validate if Update or Review Billing address is present for Vacation Suspend order in Account Information page
    And I select current billing address
    And I click on continue button for Vacation Suspend order in Account Information page
    And I selected Yes for the review in order summary page
    Then I clicked submit order button
    Then I get account number from application
    Then I validate the ensemble table is storing details "<Is paperless Billing>" for "<BP SEQ NO>" for paperless billing in "<Database>"
    And I validate the ensemble table is email "<changed email>" details for paperless billing in "<Database>"

    Examples: 
      | Env  | firstName | lastName | phoneNo    | account number | email             | changed email         | Is paperless Billing | BP SEQ NO | Database       |
      | ITV1 | Jones     | Smith    | 4029986730 |      578233560 | testmail@ctli.com | changedemail@ctli.com | 0null                |         2 | Database_Test1 |

  #TC365308 is prerequisite for this TC. Execute it first.
  @EShop_Insprint_Automation
  Scenario Outline: TC365360 Verify that ESHOP should provide option to change to paperless billing, If account is not on paperless billing and does not currently have Braille delivery, Large Print bill, or Spanish Bill for VAC_SUS orders.
    Given I should be on SFC login screen
    When I enter username and password
    #Below two commented steps are Future Ready steps for MACD Scenarios
    #Then I move back to existing SFC page
    #Then I search order in SFC page with account number
    Then I search order in SFC page with account number "<account number>"
    Then I click on order eshop button in SFC page to proceed to Eshop Page
    Then I click on Vacation Service
    And I select Vacation Suspend from the dialog box
    And I click on Continue button on vacation service dialog box
    And I click on Continue button on vacation service dialog box again
    #And I click on OK Got it button on Order Disclosures dialog box for Vacation Suspend
    And I select the provided due date for installation in Due Date format "<Due Date>"
    When I click on continue button on vacation order scheduling page
    Then I validate if "<email>" is present for Vacation Suspend order in Account Information page
    And I validate if user is getting option to switch to paperless billing
    And I validate if Yes setup - paperless billing is selected by default
    And I validate if email field is editable "<email>" for Vacation Suspend order in Account Information page without paperless billing
    #Below step is only required for TC365364, for other test cases please comment this step
    And I select No, mail my bill option
    And I validate if Update or Review Billing address is present for Vacation Suspend order in Account Information page
    And I select current billing address
    And I click on continue button for Vacation Suspend order in Account Information page
    And I selected Yes for the review in order summary page
    Then I clicked submit order button
    Then I get account number from application
    Then I validate the ensemble table is storing details "<Is paperless Billing>" for "<BP SEQ NO>" for paperless billing in "<Database>"
    And I validate the ensemble table is email "<email>" details for paperless billing in "<Database>"

    Examples: 
      | Env  | firstName | lastName | phoneNo    | account number | email             | changed email         | Is paperless Billing | BP SEQ NO | Database       | Due Date |
      #| ITV1 | Jones     | Smith    | 4029986730 |      578253473 | testmail@ctli.com | changedemail@ctli.com | 0null                |         2 | Database_Test1 | Jul24    |
      | ITV1 | Jones     | Smith    | 4029986730 |      578253473 | testmail@ctli.com | changedemail@ctli.com |                    1 |         1 | Database_Test1 | Jul24    |

  #TC365360 is prerequisite for this TC. Execute it first.
  @EShop_Insprint_Automation
  Scenario Outline: TC365346 Verify that Account Information page should be displayed to update or review billing address when an agent presses the continue button on Scheduling page for vacation restore orders.
    Given I should be on SFC login screen
    When I enter username and password
    #Below two commented steps are Future Ready steps for MACD Scenarios
    #Then I move back to existing SFC page
    #Then I search order in SFC page with account number
    Then I search order in SFC page with account number "<account number>"
    Then I click on order eshop button in SFC page to proceed to Eshop Page
    Then I click on Vacation Service
    And I select Vacation Restore from the dialog box
    And I click on Continue button on vacation service dialog box
    And I click on continue button
    Then I should be in customize service page
    And I click again on contine button
    And I select the provided due date for installation in Due Date format "<Due Date>"
    When I click on continue button on vacation order scheduling page
    Then I validate if "<email>" is present for Vacation Restore order in Account Information page
    And I validate if email field is editable "<email>" for Vacation Restore order in Account Information page
    And I validate if Update or Review Billing address is present for Vacation Restore order in Account Information page
    And I select current billing address
    And I click on continue button for Vacation Restore order in Account Information page
    And I selected Yes for the review in order summary page
    Then I clicked submit order button
    Then I get account number from application
    Then I validate the ensemble table is storing details "<Is paperless Billing>" for "<BP SEQ NO>" for paperless billing in "<Database>"
    And I validate the ensemble table is email "<email>" details for paperless billing in "<Database>"

    Examples: 
      | Env  | firstName | lastName | phoneNo    | account number | email             | changed email         | Is paperless Billing | BP SEQ NO | Database       | Due Date |
      | ITV1 | Jones     | Smith    | 4029986730 |      578249353 | testmail@ctli.com | changedemail@ctli.com | 0null                |         2 | Database_Test1 | Jun14    |

  #TC365360 is prerequisite for this TC. Execute it first.
  @EShop_Insprint_Automation
  Scenario Outline: TC365357 Verify that ESHOP should display an editable email address field with the current email address populated when account currently has paperless billing for VAC_REST order.
    Given I should be on SFC login screen
    When I enter username and password
    #Below two commented steps are Future Ready steps for MACD Scenarios
    #Then I move back to existing SFC page
    #Then I search order in SFC page with account number
    Then I search order in SFC page with account number "<account number>"
    Then I click on order eshop button in SFC page to proceed to Eshop Page
    Then I click on Vacation Service
    And I select Vacation Restore from the dialog box
    And I click on Continue button on vacation service dialog box
    And I click on continue button
    Then I should be in customize service page
    And I click again on contine button
    And I select the provided due date for installation in Due Date format "<Due Date>"
    When I click on continue button on vacation order scheduling page
    Then I validate if "<email>" is present for Vacation Restore order in Account Information page
    And I validate if email field is editable "<email>" for Vacation Restore order in Account Information page
    And I validate if Update or Review Billing address is present for Vacation Restore order in Account Information page
    And I select current billing address
    And I click on continue button for Vacation Restore order in Account Information page
    And I selected Yes for the review in order summary page
    Then I clicked submit order button
    Then I get account number from application
    Then I validate the ensemble table is storing details "<Is paperless Billing>" for "<BP SEQ NO>" for paperless billing in "<Database>"
    And I validate the ensemble table is email "<email>" details for paperless billing in "<Database>"

    Examples: 
      | Env  | firstName | lastName | phoneNo    | account number | email             | changed email         | Is paperless Billing | BP SEQ NO | Database       | Due Date |
      | ITV1 | Jones     | Smith    | 4029986730 |      578249353 | testmail@ctli.com | changedemail@ctli.com | 0null                |         2 | Database_Test1 | Jun14    |

  #TC365360 is prerequisite for this TC. Execute it first.
  @EShop_Insprint_Automation
  Scenario Outline: TC365367 Verify that If agent edits the field, the address should be validated with the email validation rules in place for VAC_REST orders.
    Given I should be on SFC login screen
    When I enter username and password
    #Below two commented steps are Future Ready steps for MACD Scenarios
    #Then I move back to existing SFC page
    #Then I search order in SFC page with account number
    Then I search order in SFC page with account number "<account number>"
    Then I click on order eshop button in SFC page to proceed to Eshop Page
    Then I click on Vacation Service
    And I select Vacation Restore from the dialog box
    And I click on Continue button on vacation service dialog box
    And I click on continue button
    Then I should be in customize service page
    And I click again on contine button
    And I select the provided due date for installation in Due Date format "<Due Date>"
    When I click on continue button on vacation order scheduling page
    Then I validate if "<email>" is present for Vacation Restore order in Account Information page
    And I validate if email field is editable "<changed email>" for Vacation Restore order in Account Information page
    And I validate if Update or Review Billing address is present for Vacation Restore order in Account Information page
    And I select current billing address
    And I click on continue button for Vacation Restore order in Account Information page
    And I selected Yes for the review in order summary page
    Then I clicked submit order button
    Then I get account number from application
    Then I validate the ensemble table is storing details "<Is paperless Billing>" for "<BP SEQ NO>" for paperless billing in "<Database>"
    And I validate the ensemble table is email "<changed email>" details for paperless billing in "<Database>"

    Examples: 
      | Env  | firstName | lastName | phoneNo    | account number | email             | changed email         | Is paperless Billing | BP SEQ NO | Database       | Due Date |
      | ITV1 | Jones     | Smith    | 4029986730 |      578249353 | testmail@ctli.com | changedemail@ctli.com | 0null                |         2 | Database_Test1 | Jun14    |

  #TC365360 is prerequisite for this TC. Execute it first.Make sure to uncomment the Mail my bill Step.
  @EShop_Insprint_Automation
  Scenario Outline: TC365364 Verify that ESHOP should provide option to change to paperless billing, If account is not on paperless billing and does not currently have Braille delivery, Large Print bill, or Spanish Bill for VAC_RES orders.
    Given I should be on SFC login screen
    When I enter username and password
    #Below two commented steps are Future Ready steps for MACD Scenarios
    #Then I move back to existing SFC page
    #Then I search order in SFC page with account number
    Then I search order in SFC page with account number "<account number>"
    Then I click on order eshop button in SFC page to proceed to Eshop Page
    Then I click on Vacation Service
    And I select Vacation Restore from the dialog box
    And I click on Continue button on vacation service dialog box
    And I click on continue button
    Then I should be in customize service page
    And I click again on contine button
    And I select the provided due date for installation in Due Date format "<Due Date>"
    When I click on continue button on vacation order scheduling page
    Then I validate if "<email>" is present for Vacation Restore order in Account Information page
    And I validate if user is getting option to switch to paperless billing
    And I validate if Yes setup - paperless billing is selected by default
    And I validate if email field is editable "<email>" for Vacation Restore order in Account Information page without paperless billing
    And I validate if Update or Review Billing address is present for Vacation Restore order in Account Information page
    And I select current billing address
    And I click on continue button for Vacation Restore order in Account Information page
    And I selected Yes for the review in order summary page
    Then I clicked submit order button
    Then I get account number from application
    Then I validate the ensemble table is storing details "<Is paperless Billing>" for "<BP SEQ NO>" for paperless billing in "<Database>"
    And I validate the ensemble table is email "<email>" details for paperless billing in "<Database>"

    Examples: 
      | Env  | firstName | lastName | phoneNo    | account number | email             | changed email         | Is paperless Billing | BP SEQ NO | Database       | Due Date |
      | ITV1 | Jones     | Smith    | 4029986730 |      578253473 | testmail@ctli.com | changedemail@ctli.com | 0null                |         2 | Database_Test1 | Jul25    |
