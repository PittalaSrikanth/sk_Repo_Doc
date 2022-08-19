@EshopTestScripts @EShop_Insprint_Automation
Feature: Insprint Automation MMP6794_F25900_[PILOT] CR6141 - Limit number of Credit Checks per EShop order

  @eshopInsprint_Automation @limitCreditCheck
  Scenario Outline: TC339800 MMP6794 - F25900 Validate and Check the Editability Credit Information pop up screen for - Customer Name, Date of Birth and Social Security Number
    Given I should be on SFC login screen
    When I enter username and password
    Then I click on create new account
    When I enter the "<firstName>" "<lastName>" "<phoneNo>" and "<address>" in new acquisition page
    Then I validate the address and save it
    When I click on order eshop button
    Then I should be in Eshop Product offer page
    Then I select the best "<Installation_option>" installation option
    And I select Your "<Modem_Option>" Modem option
    And I select "<Ease_Option>" Ease Option
    Then I select the number of device needed "<Device Quantity>"
    And I click on continue button
    And I click again on contine button
    And I click to reserve appointment
    And I click on continue button of scheduling page
    And I enter "<email>" and "<SMSNo>"
    And I enter date "<Date>" month "<Month>" and year "<Year>" of birth
    And I enter SSN number "<SSN>"
    And I select credit as "Yes"
    When I click on account Continue button and wait for the popup
    Then I validate the Credit Information popup for "<firstName>", "<lastName>","<Date>" month "<Month>" and year "<Year>" of birth and "<SSN>"
    And I click on Yes, it is correct

    Examples: 
      | firstName | lastName | phoneNo    | address                               | Installation_option | Modem_Option | Ease_Option | email       | SMSNo      | Date | Month | Year | SSN       | card             | zip code | Device Quantity | Additional Order Remarks       |
      # | Thomas    | Hilla    | 3182648522 | 3150 E COUNTY LINE RD, LITTLETON,CO,80126 | Standard            | LEASE        | BASIC       | Ctl@Ctl.com | 4029986730 |   02 |    02 | 1987 | 666446831 | 4485389438108352 |    37638 | 2 devices       | ESHOP ORDER TEST BY AUTOMATION |
      | Thomas    | Hilla    | 3182648522 | 334 W HATCHER RD,PHOENIX,AZ 85021,USA | Standard            | LEASE        | BASIC       | Ctl@Ctl.com | 4029986730 |   02 |    02 | 1987 | 666446831 | 4485389438108352 |    37638 | 2 devices       | ESHOP ORDER TEST BY AUTOMATION |

  @eshopInsprint_Automation @limitCreditCheck
  Scenario Outline: TC339814 	MMP6794 - F25900 Check for the counter for each credit check for a particular Eshop Order.
    Given I should be on SFC login screen
    When I enter username and password
    Then I click on create new account
    When I enter the "<firstName>" "<lastName>" "<phoneNo>" and "<address>" in new acquisition page
    Then I validate the address and save it
    When I click on order eshop button
    Then I should be in Eshop Product offer page
    Then I select the best "<Installation_option>" installation option
    And I select Your "<Modem_Option>" Modem option
    And I select "<Ease_Option>" Ease Option
    Then I select the number of device needed "<Device Quantity>"
    And I click on continue button
    And I click again on contine button
    And I click to reserve appointment
    And I click on continue button of scheduling page
    And I enter "<email>" and "<SMSNo>"
    And I enter date "<Date>" month "<Month>" and year "<Year>" of birth
    And I enter SSN number "<SSN>"
    And I select credit as "Yes"
    When I click on account Continue button and wait for the popup
    Then I validate the Credit Information popup for "<firstName>", "<lastName>","<Date>" month "<Month>" and year "<Year>" of birth and "<SSN>"
    And I click on Yes, it is correct
    And I validate if the Update Application link is enabled
    When I perform the credit check 1 times
    Then I validate the Update Application to be disabled

    Examples: 
      | firstName | lastName | phoneNo    | address                               | Installation_option | Modem_Option | Ease_Option | email       | SMSNo      | Date | Month | Year | SSN       | card             | zip code | Device Quantity | Additional Order Remarks       |
      # | Thomas    | Hilla    | 3182648522 | 3150 E COUNTY LINE RD, LITTLETON,CO,80126 | Standard            | LEASE        | BASIC       | Ctl@Ctl.com | 4029986730 |   02 |    02 | 1987 | 666446831 | 4485389438108352 |    37638 | 2 devices       | ESHOP ORDER TEST BY AUTOMATION |
      | Thomas    | Hilla    | 3182648522 | 334 W HATCHER RD,PHOENIX,AZ 85021,USA | Standard            | LEASE        | BASIC       | Ctl@Ctl.com | 4029986730 |   02 |    02 | 1987 | 666446831 | 4485389438108352 |    37638 | 2 devices       | ESHOP ORDER TEST BY AUTOMATION |

  @eshopInsprint_Automation @limitCreditCheck  @Regression
  Scenario Outline: TC339817 	MMP6794 - F25900 Check for the counter for each credit check for a particular Eshop NI Order for HSI Products
    Given I should be on SFC login screen
    When I enter username and password
    Then I click on create new account
    When I enter the "<firstName>" "<lastName>" "<phoneNo>" and "<address>" in new acquisition page
    Then I validate the address and save it
    When I click on order eshop button
    Then I should be in Eshop Product offer page
    Then I select the best "<Installation_option>" installation option
    And I select Your "<Modem_Option>" Modem option
    And I select "<Ease_Option>" Ease Option
    Then I select the number of device needed "<Device Quantity>"
    And I click on continue button
    And I click on OK Got it button on Order Disclosures dialog box for NI Order for HSI
    And I click again on contine button
    And I click to reserve appointment
    And I click on continue button of scheduling page
    And I click on OK Got it button on Order Disclosures dialog box for NI Order for HSI
    And I enter "<email>" and "<SMSNo>"
    And I enter date "<Date>" month "<Month>" and year "<Year>" of birth
    And I enter SSN number "<SSN>"
    And I select credit as "Yes"
    When I click on account Continue button and wait for the popup
    Then I validate the Credit Information popup for "<firstName>", "<lastName>","<Date>" month "<Month>" and year "<Year>" of birth and "<SSN>"
    And I click on Yes, it is correct
    And I validate if the Update Application link is enabled
    When I perform the credit check 1 times
    Then I validate the Update Application to be disabled
    And I click again click Continue button on account
    And I selected Yes for the review in order summary page
    Then I enter the special remark in Additional Order Remarks field "<Additional Order Remarks>"
    Then I clicked submit order button
    Then I get account number from application

    Examples: 
      | firstName | lastName | phoneNo    | address                               | Installation_option | Modem_Option | Ease_Option | email       | SMSNo      | Date | Month | Year | SSN       | card             | zip code | Device Quantity | Additional Order Remarks       |
      # | Thomas    | Hilla    | 3182648522 | 3150 E COUNTY LINE RD, LITTLETON,CO,80126 | Standard            | LEASE        | BASIC       | Ctl@Ctl.com | 4029986730 |   02 |    02 | 1987 | 666446831 | 4485389438108352 |    37638 | 2 devices       | ESHOP ORDER TEST BY AUTOMATION |
      | Thomas    | Hilla    | 3182648522 | 334 W HATCHER RD,PHOENIX,AZ 85021,USA | Standard            | LEASE        | BASIC       | Ctl@Ctl.com | 4029986730 |   02 |    02 | 1987 | 666446831 | 4485389438108352 |    37638 | 2 devices       | ESHOP ORDER TEST BY AUTOMATION |

  @eshopInsprint_Automation @limitCreditCheck
  Scenario Outline: TC339839 	MMP6794 - F25900 Validate if the Update Application option is enabled when the maximum value of credit checks is not reached even if User updates the details or not
    Given I should be on SFC login screen
    When I enter username and password
    Then I click on create new account
    When I enter the "<firstName>" "<lastName>" "<phoneNo>" and "<address>" in new acquisition page
    Then I validate the address and save it
    When I click on order eshop button
    Then I should be in Eshop Product offer page
    Then I select the best "<Installation_option>" installation option
    And I select Your "<Modem_Option>" Modem option
    And I select "<Ease_Option>" Ease Option
    Then I select the number of device needed "<Device Quantity>"
    And I click on continue button
    And I click again on contine button
    And I click to reserve appointment
    And I click on continue button of scheduling page
    And I enter "<email>" and "<SMSNo>"
    And I enter date "<Date>" month "<Month>" and year "<Year>" of birth
    And I enter SSN number "<SSN>"
    And I select credit as "Yes"
    When I click on account Continue button and wait for the popup
    Then I validate the Credit Information popup for "<firstName>", "<lastName>","<Date>" month "<Month>" and year "<Year>" of birth and "<SSN>"
    And I click on Yes, it is correct
    And I validate if the Update Application link is enabled
    When I perform the credit check 0 times
    Then I validate if the Update Application link is enabled

    Examples: 
      | firstName | lastName | phoneNo    | address                               | Installation_option | Modem_Option | Ease_Option | email       | SMSNo      | Date | Month | Year | SSN       | card             | zip code | Device Quantity | Additional Order Remarks       |
      #  | Thomas    | Hilla    | 3182648522 | 3150 E COUNTY LINE RD, LITTLETON,CO,80126 | Standard            | LEASE        | BASIC       | Ctl@Ctl.com | 4029986730 |   02 |    02 | 1987 | 666446831 | 4485389438108352 |    37638 | 2 devices       | ESHOP ORDER TEST BY AUTOMATION |
      | Thomas    | Hilla    | 3182648522 | 334 W HATCHER RD,PHOENIX,AZ 85021,USA | Standard            | LEASE        | BASIC       | Ctl@Ctl.com | 4029986730 |   02 |    02 | 1987 | 666446831 | 4485389438108352 |    37638 | 2 devices       | ESHOP ORDER TEST BY AUTOMATION |

  @eshopInsprint_Automation @limitCreditCheck
  Scenario Outline: TC339845 	MMP6794 - F25900 Validate if the Update Application option is disabled when the maximum value of credit checks is reached
    Given I should be on SFC login screen
    When I enter username and password
    Then I click on create new account
    When I enter the "<firstName>" "<lastName>" "<phoneNo>" and "<address>" in new acquisition page
    Then I validate the address and save it
    When I click on order eshop button
    Then I should be in Eshop Product offer page
    Then I select the best "<Installation_option>" installation option
    And I select Your "<Modem_Option>" Modem option
    And I select "<Ease_Option>" Ease Option
    Then I select the number of device needed "<Device Quantity>"
    And I click on continue button
    And I click again on contine button
    And I click to reserve appointment
    And I click on continue button of scheduling page
    And I enter "<email>" and "<SMSNo>"
    And I enter date "<Date>" month "<Month>" and year "<Year>" of birth
    And I enter SSN number "<SSN>"
    And I select credit as "Yes"
    When I click on account Continue button and wait for the popup
    Then I validate the Credit Information popup for "<firstName>", "<lastName>","<Date>" month "<Month>" and year "<Year>" of birth and "<SSN>"
    And I click on Yes, it is correct
    And I validate if the Update Application link is enabled
    When I perform the credit check 1 times
    Then I validate the Update Application to be disabled

    Examples: 
      | firstName | lastName | phoneNo    | address                               | Installation_option | Modem_Option | Ease_Option | email       | SMSNo      | Date | Month | Year | SSN       | card             | zip code | Device Quantity | Additional Order Remarks       |
      # | Thomas    | Hilla    | 3182648522 | 3150 E COUNTY LINE RD, LITTLETON,CO,80126 | Standard            | LEASE        | BASIC       | Ctl@Ctl.com | 4029986730 |   02 |    02 | 1987 | 666446831 | 4485389438108352 |    37638 | 2 devices       | ESHOP ORDER TEST BY AUTOMATION |
      | Thomas    | Hilla    | 3182648522 | 334 W HATCHER RD,PHOENIX,AZ 85021,USA | Standard            | LEASE        | BASIC       | Ctl@Ctl.com | 4029986730 |   02 |    02 | 1987 | 666446831 | 4485389438108352 |    37638 | 2 devices       | ESHOP ORDER TEST BY AUTOMATION |

  @eshopInsprint_Automation @limitCreditCheck
  Scenario Outline: TC339843 	MMP6794 - F25900 Validate if the counter can be reset or not when back button is clicked
    Given I should be on SFC login screen
    When I enter username and password
    Then I click on create new account
    When I enter the "<firstName>" "<lastName>" "<phoneNo>" and "<address>" in new acquisition page
    Then I validate the address and save it
    When I click on order eshop button
    Then I should be in Eshop Product offer page
    Then I select the best "<Installation_option>" installation option by value
    And I select Your "<Modem_Option>" Modem option
    And I select "<Ease_Option>" Ease Option
    Then I select the number of device needed "<Device Quantity>"
    And I click on continue button
    And I click again on contine button
    And I click to reserve appointment
    And I click on continue button of scheduling page
    And I enter "<email>" and "<SMSNo>"
    And I enter date "<Date>" month "<Month>" and year "<Year>" of birth
    And I enter SSN number "<SSN>"
    And I select credit as "Yes"
    When I click on account Continue button and wait for the popup
    Then I validate the Credit Information popup for "<firstName>", "<lastName>","<Date>" month "<Month>" and year "<Year>" of birth and "<SSN>"
    And I click on Yes, it is correct
    And I validate if the Update Application link is enabled
    When I perform the credit check 2 times
    Then I validate the Update Application to be disabled
    When I click on Back Button and again go back to the same Page to check the Update Application link
    And I click to reserve appointment
    And I click on continue button of scheduling page
    Then I validate the Update Application to be disabled

    Examples: 
      | firstName | lastName | phoneNo    | address                               | Installation_option | Modem_Option | Ease_Option | email       | SMSNo      | Date | Month | Year | SSN       | card             | zip code | Device Quantity | Additional Order Remarks       |
      # | Thomas    | Hilla    | 3182648522 | 6715 E UNION AVE,DENVER,CO 80237,USA  | Standard            | LEASE        | BASIC       | Ctl@Ctl.com | 4029986730 |   02 |    02 | 1987 | 666446831 | 4485389438108352 |    37638 | 2 devices       | ESHOP ORDER TEST BY AUTOMATION |
      | Thomas    | Hilla    | 3182648522 | 334 W HATCHER RD,PHOENIX,AZ 85021,USA | Standard            | LEASE        | BASIC       | Ctl@Ctl.com | 4029986730 |   02 |    02 | 1987 | 666446831 | 4485389438108352 |    37638 | 2 devices       | ESHOP ORDER TEST BY AUTOMATION |

  @eshopInsprint_Automation @limitCreditCheck
  Scenario Outline: TC339840 		MMP6794 - F25900 Validate if the counter can be reset or not when Order is put on Hold
    Given I should be on SFC login screen
    When I enter username and password
    Then I click on create new account
    When I enter the "<firstName>" "<lastName>" "<phoneNo>" and "<address>" in new acquisition page
    Then I validate the address and save it
    When I click on order eshop button
    Then I should be in Eshop Product offer page
    Then I select the best "<Installation_option>" installation option by value
    And I select Your "<Modem_Option>" Modem option
    And I select "<Ease_Option>" Ease Option
    Then I select the number of device needed "<Device Quantity>"
    And I click on continue button
    And I click again on contine button
    And I click to reserve appointment
    And I click on continue button of scheduling page
    And I enter "<email>" and "<SMSNo>"
    And I enter date "<Date>" month "<Month>" and year "<Year>" of birth
    And I enter SSN number "<SSN>"
    And I select credit as "Yes"
    When I click on account Continue button and wait for the popup
    Then I validate the Credit Information popup for "<firstName>", "<lastName>","<Date>" month "<Month>" and year "<Year>" of birth and "<SSN>"
    And I click on Yes, it is correct
    And I validate if the Update Application link is enabled
    When I perform the credit check 1 times
    Then I validate the Update Application to be disabled
    When I click on Place on Hold button to put the order on Hold
    Then I should be able to select "<On Hold Reason>" and give "<Additional Notes>"
    And I take the ORN for On Hold order
    And I click on Start new Order
    And I click on Account or Order already exists
    When I enter the "<firstName>" "<lastName>" "<phoneNo>" in ESHOP customer information screen
    And I enter the ORN for Order on Hold
    And I Click on Lets go Button
    And I click on continue button after clicking lets Go
    And I click again on contine button
    And I click to reserve appointment
    And I click on continue button of scheduling page
    Then I validate the Update Application to be disabled

    Examples: 
      | firstName | lastName | phoneNo    | address                               | Installation_option | Modem_Option | Ease_Option | email       | SMSNo      | Date | Month | Year | SSN       | card             | zip code | Device Quantity | Additional Order Remarks       | On Hold Reason | Additional Notes |
      #| Thomas    | Hilla    | 3182648522 | 311 S MAYNE ST,VALLEY,NE,68064,USA | Standard            | LEASE        | BASIC       | Ctl@Ctl.com | 4029986730 |   02 |    02 | 1987 | 666446831 | 4485389438108352 |    37638 | 2 devices       | ESHOP ORDER TEST BY AUTOMATION | 1: HFCIB       | Test             |
      | Thomas    | Hilla    | 3182648522 | 334 W HATCHER RD,PHOENIX,AZ 85021,USA | Standard            | LEASE        | BASIC       | Ctl@Ctl.com | 4029986730 |   02 |    02 | 1987 | 666446831 | 4485389438108352 |    37638 | 2 devices       | ESHOP ORDER TEST BY AUTOMATION | 1: HFCIB       | Test             |

  @eshopInsprint_Automation @limitCreditCheck
  Scenario Outline: TC339840 MMP6794 - F25900 Validate if the Credit Check Action is successful when unholded order is progressed And Credit check is performed
    Given I should be on SFC login screen
    When I enter username and password
    Then I click on create new account
    When I enter the "<firstName>" "<lastName>" "<phoneNo>" and "<address>" in new acquisition page
    Then I validate the address and save it
    When I click on order eshop button
    Then I should be in Eshop Product offer page
    Then I select the best "<Installation_option>" installation option by value
    And I select Your "<Modem_Option>" Modem option
    And I select "<Ease_Option>" Ease Option
    Then I select the number of device needed "<Device Quantity>"
    And I click on continue button
    And I click again on contine button
    And I click to reserve appointment
    And I click on continue button of scheduling page
    And I enter "<email>" and "<SMSNo>"
    And I enter date "<Date>" month "<Month>" and year "<Year>" of birth
    And I enter SSN number "<SSN>"
    And I select credit as "Yes"
    When I click on account Continue button and wait for the popup
    Then I validate the Credit Information popup for "<firstName>", "<lastName>","<Date>" month "<Month>" and year "<Year>" of birth and "<SSN>"
    And I click on Yes, it is correct
    And I validate if the Update Application link is enabled
    When I perform the credit check 0 times
    Then I validate if the Update Application link is enabled
    When I click on Place on Hold button to put the order on Hold
    Then I should be able to select "<On Hold Reason>" and give "<Additional Notes>"
    And I take the ORN for On Hold order
    And I click on Start new Order
    And I click on Account or Order already exists
    When I enter the "<firstName>" "<lastName>" "<phoneNo>" in ESHOP customer information screen
    And I enter the ORN for Order on Hold
    And I Click on Lets go Button
    And I click on continue button after clicking lets Go
    And I click again on contine button
    And I click to reserve appointment
    And I click on continue button of scheduling page
    When I click on account Continue button and wait for the popup
    Then I validate if the Update Application link is enabled
    And I click again click Continue button on account
    And I selected Yes for the review in order summary page
    Then I enter the special remark in Additional Order Remarks field "<Additional Order Remarks>"
    Then I clicked submit order button
    Then I get account number from application

    Examples: 
      | firstName | lastName | phoneNo    | address                               | Installation_option | Modem_Option | Ease_Option | email       | SMSNo      | Date | Month | Year | SSN       | card             | zip code | Device Quantity | Additional Order Remarks       | On Hold Reason | Additional Notes |
      | Thomas    | Hilla    | 3182648522 | 334 W HATCHER RD,PHOENIX,AZ 85021,USA | Standard            | LEASE        | BASIC       | Ctl@Ctl.com | 4029986730 |   02 |    02 | 1987 | 666446831 | 4485389438108352 |    37638 | 2 devices       | ESHOP ORDER TEST BY AUTOMATION | 1: HFCIB       | Test             |
