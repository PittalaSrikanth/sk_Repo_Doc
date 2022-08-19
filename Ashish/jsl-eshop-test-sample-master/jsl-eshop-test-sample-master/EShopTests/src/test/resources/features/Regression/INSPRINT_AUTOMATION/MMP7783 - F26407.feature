@EshopTestScripts @EShopFunctional @Insprint
Feature: Verify CNUM response is status = Available
 @TC379464-Verify_CNUM_response_is_status=Available
 Scenario Outline: Verify CNUM response is status = Available
 
   Given I should be on SFC login screen
    When I enter username and password
    Then I search order in SFC page with account number "<account number>"
    Then I click on order eshop button in SFC page to proceed to Eshop Page
    Then I should be in existing products page
    Then I click on Make changes button
#    Then I select required option for voice mail "<Voice Mail>"
#    Then I select required option for Wire Maintenance Plan "<Wire Maintenance Plan>"
#    Then I select required option for Port in a phone number? "<Port in a phone number?>"
#    Then I select required option for Need new jacks or wiring? "<Need new jacks or wiring?>"
#     And I click on continue button 

    And I click continue button from Changes page 
    Then I should be in customize service page
    And I click on Telephone Number and then click on More options 
    Then I Click on "Manual Request" Radio button
    Then I Select "402" from NPA "289" from NXX dropdown and "9976" as line
    Then I Click on CheckTN button
    Then I Validated the confirmation message that says "TN is available"  
    Then I Click on select TN Button
    And I click again click Continue button on change account page
    And I click continue button in scheduling Move Order page
    And I click Continue button on account information page
    And I selected Yes for the review in order summary page
    Then I clicked submit order button

    Examples:  
      | Env   | firstName | lastName | phoneNo    | account number | Date | Month | Year | SSN       | zip code | Voice Mail | Wire Maintenance Plan | Port in a phone number? | Need new jacks or wiring? |
      | Test1 | Jones     | Smith    | 4029986730 | 578658494 	   |   02 |    02 | 1987 | 666548774 | 37638 	| No         | No                    | No                      | No Work Is Needed ($0)    |
      
      

@TC379465-Verify_CNUM_response_is_status=Agingandstartdateis61ormoredaysago
  Scenario Outline: Verify CNUM response is status is equal to Aging and start date is 61 or more days ago
  
   Given I should be on SFC login screen
    When I enter username and password
    Then I search order in SFC page with account number "<account number>"
    Then I click on order eshop button in SFC page to proceed to Eshop Page
    Then I should be in existing products page
    Then I click on Make changes button
#    Then I select required option for voice mail "<Voice Mail>"
#    Then I select required option for Wire Maintenance Plan "<Wire Maintenance Plan>"
#    Then I select required option for Port in a phone number? "<Port in a phone number?>"
#    Then I select required option for Need new jacks or wiring? "<Need new jacks or wiring?>"

    And I click continue button from Changes page
    Then I should be in customize service page
    And I click on Telephone Number and then click on More options 
    Then I Click on "Manual Request" Radio button
    Then I Select "218" from NPA "262" from NXX dropdown and "0879" as line
    Then I Click on CheckTN button
    Then I Validated the CNUM confirmation message that says "Aging more than 60 days"
 
      Examples:  
      | Env   | firstName | lastName | phoneNo    | account number | Date | Month | Year | SSN       | zip code | Voice Mail | Wire Maintenance Plan | Port in a phone number? | Need new jacks or wiring? |
      | Test1 | Jones     | Smith    | 4029986730 | 578661886 	   |   02 |    02 | 1987 | 666548774 | 37638 	| No         | No                    | No                      | No Work Is Needed ($0)    |
 
 
 @TC379466-Verify_CNUM_response_is_status=Agingandstartdateis60orlessdaysago
  Scenario Outline: Verify  CNUM response is status is equal to Aging and start date is 60 or less days ago
  
   Given I should be on SFC login screen
    When I enter username and password
    Then I search order in SFC page with account number "<account number>"
    Then I click on order eshop button in SFC page to proceed to Eshop Page
    Then I should be in existing products page
    Then I click on Make changes button
#    Then I select required option for voice mail "<Voice Mail>"
#    Then I select required option for Wire Maintenance Plan "<Wire Maintenance Plan>"
#    Then I select required option for Port in a phone number? "<Port in a phone number?>"
#    Then I select required option for Need new jacks or wiring? "<Need new jacks or wiring?>"

    And I click continue button from Changes page
    Then I should be in customize service page
    And I click on Telephone Number and then click on More options 
    Then I Click on "Manual Request" Radio button
    Then I Select "218" from NPA "262" from NXX dropdown and "2548" as line
    Then I Click on CheckTN button
    Then I Validated the CNUM confirmation message that says "Aging less than 60 days"
    Then I select "No, waive the charge" option from Assess Charge
 	Then I Click on select TN Button
    And I click again click Continue button on change account page
    And I click continue button in scheduling Move Order page
    And I click Continue button on account information page
    And I selected Yes for the review in order summary page
	Then I clicked submit order button
	
    Examples:  
      | Env   | firstName | lastName | phoneNo    | account number | Date | Month | Year | SSN       | zip code | Voice Mail | Wire Maintenance Plan | Port in a phone number? | Need new jacks or wiring? |
      | Test1 | Jones     | Smith    | 4029986730 | 578661886 	   |   02 |    02 | 1987 | 666548774 | 37638 	  | No       | No                    | No                      | No Work Is Needed ($0)    |