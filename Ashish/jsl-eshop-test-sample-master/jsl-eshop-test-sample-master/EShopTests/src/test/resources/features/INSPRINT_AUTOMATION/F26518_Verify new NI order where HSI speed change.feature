@EshopTestScripts @EShopFunctional
Feature: HSI Order Scenarios

  #TC322875 Verifying installation option 1
  @Verify_HSI_Speed
  Scenario Outline: Verify installation option "TC322875".
    Given I should be on SFC login screen
    When I enter username and password
    Then I click on create new account
    Then I enter the "<firstName>" "<lastName>" "<phoneNo>" and "<address>" in new acquisition page
    Then I validate the address and save it
    Then I click on order eshop button
    Then I should be in Eshop Product offer page
    Then I select the best "<Installation_option>" installation option
    Then I select the number of device needed "<Device Quantity>"
    Then I select Your "<Modem option>" Modem option
    And I select "<Ease option>" Ease Option
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
    And I move to product offer page
    And I validate installation option in Product offer Page "<intallation_option>"
    And I validate Product offer Page speed "<Select_speed>" device "<Device Quantity>" easeoption "<Ease option>" modem "<Modem option>" and jack "<Need new jacks or wiring?>"
    And I click on continue button
    Then I should be in customize service page
    And I click again on contine button
    And I click to reserve appointment
    And I click on continue button of scheduling page
    And I click on account info Continue button
    And I selected Yes for the review in order summary page
    Then I clicked submit order button
    Then I should able to submit order successfully
    Then I get account number from application

    Examples: 
      | Env | firstName | lastName | phoneNo    | address                              |Select_speed |intallation_option |email       | SMSNo      |Modem option |Installation_option | Date | Month | Year | SSN       | card             | zip code | Device Quantity |Ease option|Need new jacks or wiring? |
     # | E2E | Jones     | Smith    | 4029986730 | 611 FENWICK DR,PAPILLION,NE 68046,USA | HSI Up to 100|Tech Install ($60)|Ctl@Ctl.com | 4029986730 |Leased Modem ($10/mo) |STANDARD |   02 |    02 | 1987 | 345038058 | 6011329842589845 |    37638 | 3 devices       |Basic ($0) |No Work Is Needed ($0) |
      | E2E | Jones     | Smith    | 4029986730 | 334 W HATCHER RD,PHOENIX,AZ 85021,USA | HSI Up to 100|Tech Install ($60)|Ctl@Ctl.com | 4029986730 |Leased Modem ($10/mo) |STANDARD |   02 |    02 | 1987 | 345038058 | 6011329842589845 |    37638 | 3 devices       |Basic ($0) |No Work Is Needed ($0) |

  #TC323135 #TC323118
  @Verify_HSI_SELF
  Scenario Outline: Create a HSI new install Order "TC323135"
    Given I should be on SFC login screen
    When I enter username and password
    Then I click on create new account
    Then I enter the "<firstName>" "<lastName>" "<phoneNo>" and "<address>" in new acquisition page
    Then I validate the address and save it
    Then I click on order eshop button
    Then I should be in Eshop Product offer page
    Then I select the best "<Installation_option>" installation option
    #Then I select the number of device needed "<Device Quantity>"
    Then I select Your "<Modem option>" Modem option
    And I select "<Ease option>" Ease Option
    Then I select required option for Need new jacks or wiring? "<Need new jacks or wiring?>"    
    And I click on continue button
    Then I should be in customize service page
    And I click again on contine button
    #And I click to reserve appointment
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
    And I move to product offer page
    And I validate Product offer Page speed "<Select_speed>" device "<Device Quantity>" easeoption "<Ease option>" modem "<Modem option>" and jack "<Need new jacks or wiring?>"
    And I click on continue button
    Then I should be in customize service page
    And I click again on contine button
    #And I click to reserve appointment
    And I click on continue button of scheduling page
    And I click on account info Continue button
     And I selected Yes for the review in order summary page
    Then I clicked submit order button
    Then I should able to submit order successfully
    Then I get account number from application

    Examples: 
      | Env | firstName | lastName | phoneNo    | address                              |Select_speed | email       | SMSNo      |Modem option |Installation_option | Date | Month | Year | SSN       | card             | zip code | Device Quantity |Ease option|Need new jacks or wiring? |
     #| E2E | Jones     | Smith    | 4029986730 | 3066 SHADY LN , LITTLETON, CO, 80126 | HSI Up to 100|Ctl@Ctl.com | 4029986730 |Leased Modem ($10/mo) |STANDARD |   02 |    02 | 1987 | 345038058 | 6011329842589845 |    37638 | 3 devices       |Basic ($0) |No Work Is Needed ($0) |
	 #| E2E | Jones     | Smith    | 4029986730 | 7150 CAHILL RD,EDINA,MN 55439 USA | HSI Up to 100|Ctl@Ctl.com | 4029986730 |Leased Modem ($10/mo) |STANDARD |   02 |    02 | 1987 | 345038058 | 6011329842589845 |    37638 | 3 devices       |Basic ($0) |No Work Is Needed ($0) |
 	 #| E2E | Jones     | Smith    | 4029986730 | 4020 NE BUFFALO ST, PORTLAND, OR 97211, USA | HSI Up to 1.5 Mbps/896 Kbps|Ctl@Ctl.com | 4029986730 |Leased Modem ($10/mo) |STANDARD |   02 |    02 | 1987 | 345038058 | 6011329842589845 |    37638 | 3 devices       |Basic ($0) |No Work Is Needed ($0) |
 	 | E2E | Jones     | Smith    | 4029986730 | 1815 6TH AVE SE,ABERDEEN,SD 57401,USA | HSI Up to 1.5 Mbps/896 Kbps|Ctl@Ctl.com | 4029986730 |Leased Modem ($10/mo) |STANDARD |   02 |    02 | 1987 | 345038058 | 6011329842589845 |    37638 | 3 devices       |Basic ($0) |No Work Is Needed ($0) |
 
 
 #TC260986  ##   Need to verify 01/08
  @Verify_POTSOnly  
  Scenario Outline: Create a POTS Only Order
    Given I should be on SFC login screen
    When I enter username and password
    Then I click on create new account
    Then I enter the "<firstName>" "<lastName>" "<phoneNo>" and "<address>" in new acquisition page
    Then I validate the address and save it
    Then I click on order eshop button
    Then I should be in Eshop Product offer page
    And I select HomePhone
    And I select Internet
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
    And I move to product offer page
  	And I validate Product offer Page speed voicemail "<Voice Mail>" wire maintenance plan "<Wire Maintenance Plan>" port "<Port in a phone number?>" and jack "<Need new jacks or wiring?>"    
    And I click on continue button
    Then I should be in customize service page
    And I click again on contine button
    And I click to reserve appointment
    And I click on continue button of scheduling page
    And I click on account info Continue button
     And I selected Yes for the review in order summary page
    Then I clicked submit order button
    Then I should able to submit order successfully
    Then I get account number from application

    Examples: 
      | Env | firstName | lastName | phoneNo    | address                          | email       | SMSNo      | Installation_option | Date | Month | Year | SSN       | card             | zip code | Voice Mail | Wire Maintenance Plan | Port in a phone number? | Need new jacks or wiring? |
     #| E2E | MARIANNE  | HELTON   | 4029986730 | 3066 SHADY LN,LITTLETON,CO 80126 | Ctl@Ctl.com | 4029986730 | STANDARD            |   02 |    02 | 1987 | 666150907 | 4485389438108352 |    37638 |Yes ($0.00/mo)| No                  | No               | No Work Is Needed ($0)    |
      #| E2E | MARIANNE  | HELTON   | 4029986730 | 819 SW Oak St,Portland,OR,97205  | Ctl@Ctl.com | 4029986730 | STANDARD            |   02 |    02 | 1987 | 666150907 | 4485389438108352 |    37638 | No         | No                    | No               | No Work Is Needed ($0)    |
       | E2E | MARIANNE  | HELTON   | 4029986730 | 334 W HATCHER RD,PHOENIX,AZ 85021,USA  | Ctl@Ctl.com | 4029986730 | STANDARD            |   02 |    02 | 1987 | 666150907 | 4485389438108352 |    37638 | No         | No                    | No               | No Work Is Needed ($0)    |
 
@Verify_HSI+POTS
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
    Then I select the number of device needed "<Device Quantity>"
     And I select "<Ease option>" Ease Option
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
    And I enter password "<password>"
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
    And I move to product offer page
    And I validate Product offer Page speed "<Select_speed>" device "<Device Quantity>" easeoption "<Ease option>" modem "<Modem option>" and jack "<Need new jacks or wiring?>"
	And I validate Product offer Page speed voicemail "<Voice Mail>" wire maintenance plan "<Wire Maintenance Plan>" port "<Port in a phone number?>" and jack "<Need new jacks or wiring?>"        
    And I click on continue button
    Then I should be in customize service page
    And I click again on contine button
    And I click to reserve appointment
    And I click on continue button of scheduling page
    And I click on account info Continue button
     And I selected Yes for the review in order summary page
    Then I clicked submit order button
    Then I should able to submit order successfully
    Then I get account number from application

    Examples: 
      | Env | firstName | lastName | phoneNo    | Matching Offers              | address                            | email       | SMSNo      | Installation_option | Date | Month | Year | SSN       | card             | zip code | Device Quantity | Voice Mail | Wire Maintenance Plan | Port in a phone number? | Need new jacks or wiring? |password|Ease option|Select_speed|Modem option|
      #| E2E | Jones  | Smith   | 4029986730 | Home Phone with Unlimited LD |3066 SHADY LN,LITTLETON,CO 80126| Ctl@Ctl.com | 4029986730 | STANDARD            |   02 |    02 | 1987 | 666150907 | 4485389438108352 |    37638 | 2 devices       | No         | No                    | No                      | No Work Is Needed ($0)    |Automation123|Basic ($0)|HSI Up to 12|Leased Modem|
      #| E2E | Jones  | Smith   | 4029986730 | Home Phone with Unlimited LD |11017 V ST,OMAHA,NE 68137,USA| Ctl@Ctl.com | 4029986730 | STANDARD            |   02 |    02 | 1987 | 666150907 | 4485389438108352 |    37638 | 2 devices       | No         | No                    | No                      | No Work Is Needed ($0)    |Automation123|Basic ($0)|HSI Up to 12|Leased Modem|
      | E2E | Jones  | Smith   | 4029986730 | Home Phone with Unlimited LD |334 W HATCHER RD,PHOENIX,AZ 85021,USA| Ctl@Ctl.com | 4029986730 | STANDARD            |   02 |    02 | 1987 | 666150907 | 4485389438108352 |    37638 | 2 devices       | No         | No                    | No                      | No Work Is Needed ($0)    |Automation123|Basic ($0)|HSI Up to 12|Leased Modem|
      
  @Verify_HSICVOIP
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
    Then I select Your "<Modem option>" Modem option
     And I select "<Ease option>" Ease Option
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
  	And I move to product offer page
    And I validate Product offer Page speed "<Select_speed>" device "<Device Quantity>" easeoption "<Ease option>" modem "<Modem option>" and jack "<Need new jacks or wiring?>"
    And I click on continue button
    Then I should be in customize service page
    And I click again on contine button
    And I click to reserve appointment
    And I click on continue button of scheduling page
    And I click on account info Continue button
    And I selected Yes for the review in order summary page
    Then I clicked submit order button
    Then I should able to submit order successfully
    Then I get account number from application

    Examples: 
      | Env | firstName | lastName | phoneNo    | address                            |Select_speed| email       | SMSNo      | Installation_option |Modem option| Date | Month | Year | SSN       | card             | zip code | Device Quantity |password|Ease option|Need new jacks or wiring? |
     # | E2E | Jones     | Smith    | 4899999343 | 3066 SHADY LN,LITTLETON,CO 80126,USA |HSI Up to 100| Ctl@Ctl.com | 4029986730 | STANDARD            | Leased Modem ($10/mo) | 02 |    02 | 1987 | 345038058 | 6011329842589845 |    37638 | 2 devices       |Automation123|Basic ($0)|No Work Is Needed ($0) |
      | E2E | Jones     | Smith    | 4899999343 | 3066 SHADY LN,LITTLETON,CO 80126,USA |HSI Up to 100| Ctl@Ctl.com | 4029986730 | STANDARD            | Leased Modem ($10/mo) | 02 |    02 | 1987 | 345038058 | 6011329842589845 |    37638 | 2 devices       |Automation123|Basic ($0)|No Work Is Needed ($0) |
      
      
  @Verify_HSIDTV
  Scenario Outline: Create a HSI + CVOIP new install Order with Payment 
    Given I should be on SFC login screen
    When I enter username and password
    Then I click on create new account
    Then I enter the "<firstName>" "<lastName>" "<phoneNo>" and "<address>" in new acquisition page
    Then I validate the address and save it
    Then I click on order eshop button
    Then I should be in Eshop Product offer page
    And I select DTV
   # And I select address info popup
    Then I select the number of device needed "<Device Quantity>"
    Then I select Your "<Modem option>" Modem option
     And I select "<Ease option>" Ease Option
    Then I select required option for Need new jacks or wiring? "<Need new jacks or wiring?>"  
    And I click on continue button
    Then I should be in customize service page
    And I click again on contine button
    And I click to reserve appointment
    And I click on continue button of scheduling page
    And I enter "<email>" and "<SMSNo>"
    #And I enter password "<password>"    
    And I enter date "<Date>" month "<Month>" and year "<Year>" of birth
    And I enter SSN number "<SSN>"
    And I select credit as "Yes"
    And I click on account Continue button
    #And I verify Password "<password>"
    And I enter dtv account id "<dtv_accountid>"
    And I click on payNow
    And I should be at make payment page
    And I fill all card details as "<card>" and "<zip code>"
    And I click submit button on verify InformationPage
    And I click again click Continue button on account
    And I selected Yes for the review in order summary page
	And I move to product offer page
    And I validate Product offer Page speed "<Select_speed>" device "<Device Quantity>" easeoption "<Ease option>" modem "<Modem option>" and jack "<Need new jacks or wiring?>"
    And I click on continue button
    Then I should be in customize service page
    And I click again on contine button
    And I click to reserve appointment
    And I click on continue button of scheduling page
    And I enter dtv account id "<dtv_accountid>"
    And I click on account info Continue button
    And I selected Yes for the review in order summary page
    Then I clicked submit order button
    Then I should able to submit order successfully
    Then I get account number from application

    Examples: 
      | Env | firstName | lastName | phoneNo    | address                            | email       | SMSNo      | Installation_option | Date | Month | Year | SSN       | card             | zip code | Device Quantity |password|Ease option|dtv_accountid|Need new jacks or wiring? |Modem option|
      | E2E | Jones     | Smith    | 4899999343 | 3066 SHADY LN,LITTLETON,CO 80126,USA | Ctl@Ctl.com | 4029986730 | STANDARD            |   02 |    02 | 1987 | 345038058 | 4485389438108352 |    37638 | 2 devices       |Automation123|Basic ($0)|12345|No Work Is Needed ($0) |Leased Modem ($10/mo)|
