@EshopTestScripts @TC379475
Feature: F26407-TC379475-Verify CNUM response is status=Aging and start date is 60 or less days ago

	@TC379457
  	Scenario Outline: F26407-TC379475-Verify CNUM response is status=Aging and start date is 60 or less days ago
    Given I should be on SFC login screen
    When I enter username and password
    Then I search order in SFC page with account number "<account number>"
    Then I click on order eshop button in SFC page to proceed to Eshop Page
    Then I should be in existing products page
    Then I select move service from other order activities
    And I enter new address and click validate "<new_address>"
    And I click continue button from existing products and move service page
    And I click on OK, Got it button in Order Disclosures dialog box
    Then I Expand the Telephone Number under Phone Configuration
    And I Click on More TNs
    Then I Click on More Options
    Then I Click on "Manual Request" Radio button
    Then I Select "308" from NPA "284" from NXX dropdown and "3794" as line
    Then I Click on CheckTN button
    #Then I Validated the CNUM response message that says "TN may be available"
    Then I Validated the CNUM confirmation message that says "Aging less than 60 days"
    Then I select "No, waive the charge" option from Assess Charge
    Then I Click on select TN Button
    And I click again continue button in Customer Service Page
    And I click continue button in scheduling Move Order page
    And I click Continue button on account information page
    And I selected Yes for the review in order summary page

    Examples: 
      | Env   | firstName | lastName | phoneNo   | new_address                       | account number | Installation_option | Device Quantity | Voice Mail | Wire Maintenance Plan | Port in a phone number? | Need new jacks or wiring? | Assess Charge        |
      | Test1 | Jones     | Smith    | 578634076 | 413 W H St Ogallala, NE 69153 USA |      578618452 | STANDARD            | 2 devices       | No         | No                    | No                      | No Work Is Needed ($0)    | No, waive the charge |

      
    @TC379462
	Scenario Outline:F26407 - Verify CNUM response is status = Working or Unavailable

    Given I should be on SFC login screen
    When I enter username and password
    #Below two commented steps are Future Ready steps for MACD Scenarios
    #Then I move back to existing SFC page
    #Then I search order in SFC page with account number
    Then I search order in SFC page with account number "<account number>"
    Then I click on order eshop button in SFC page to proceed to Eshop Page
    Then I should be in existing products page
    Then I click on Make changes button
    Then I Remove the existing product HSI
    And I click on continue button
    Then I should be in customize service page
    Then I Expand the Telephone Number under Phone Configuration
    And I Click on More TNs
    Then I Click on More Options
    Then I Click on "Manual Request" Radio button
    Then I Select "720" from NPA "536" from NXX dropdown and "8890" as line
    Then I Click on CheckTN button
    Then I Validated the CNUM response message that says "TN is not available"
    Then I Select "303" from NPA "488" from NXX dropdown and "8890" as line
    Then I Click on CheckTN button
    Then I Validated the confirmation message that says "TN is available"
     
     Examples: 
    | Env   | firstName  | lastName | phoneNo     | account number |
    | Test1 | THOMAS     | HILLA    | 44043454343 |      578619646 |
    
    
    @TC379458    
	Scenario Outline:Verify When an ESHOP user is using the Manual Request option in the TN negotiation configuration
    Given I should be on SFC login screen
    When I enter username and password
    #Below two commented steps are Future Ready steps for MACD Scenarios
    #Then I move back to existing SFC page
    #Then I search order in SFC page with account number
    Then I search order in SFC page with account number "<account number>"
    Then I click on order eshop button in SFC page to proceed to Eshop Page
    Then I should be in existing products page
    Then I click on Make changes button
    Then I Remove the existing product HSI
    And I click on continue button
    Then I should be in customize service page
    Then I Expand the Telephone Number under Phone Configuration
    And I Click on More TNs
    Then I Click on More Options
    Then I Click on "Manual Request" Radio button
    Then I Select "303" from NPA "488" from NXX dropdown and "8899" as line
    Then I Click on CheckTN button
    Then I Validated the confirmation message that says "TN is available"
    Then I Click on select TN Button
    Then I validated "303-488-8890" is assigned
     
      Examples: 
      | Env   | firstName  | lastName | phoneNo     | account number |
      | Test1 | THOMAS     | HILLA    | 44043454343 |      578619646 |   

    
    
    
    
      