REM 01/18/2018
echo on
REM Arguments: #1=Branch-Name (default=master); #2=list of tag(s) (default=@EShopSanity); #3=Environment(Default=E2E)

set MAVEN_HOME=C:\Maven\apache-maven-3.3.9

echo "NOW RUNNING EShop Branch Tests...."
cd C:\OSSPROV\EShop\EShop_Framework_%BranchName%\EshopTests

REM First argument passed in is Gitlab BranchName (master, ArunsBranch, etc.)
set BranchName=%1
IF [%1] EQU [] echo "No Branch Parameter argument passed in, assuming 'master' branch...."
IF [%1] EQU [] set BranchName=master
echo "===>BranchName value="%BranchName% "<==="

REM Second argument passed in is Environment (ITV1, ITV2, ITV3, E2E)
set testenv=%2
IF [%2] EQU [] echo "No Environment-Name argument passed in, assuming 'E2E'...."
IF [%2] EQU [] set testenv=E2E
echo "===>TestEnv value="%testenv% "<==="

REM Third argument passed in is Gherkin Feature file tag, default tag is @EShopSanity
set tag=%3
REM List of Current Tags: set tag=@EshopTestScripts @EShopFunctional @eshopCentral @EshopEastern @payNow @exactMatch @noMatch @nearMatch @CalculateEarliestDueDate @remarks @createAccount @EShopSanity @eshopcentral @eshopEastern @creditCheck @shopOptional
IF [%3] EQU [] echo "No Tag Parameters argument passed in, assuming '@EShopSanity' tag...."
IF [%3] EQU [] set tag=@EShopSanity
echo "===>Tag value="%tag% "<==="

REM Fourth argument passed in is TestType, default tag is Sanity 
set testType=%4
REM List of Current TestTypes set tag=(Sanity, Functional, Regression, IST, FTT)
IF [%4] EQU [] echo "No TestType Parameter argument passed in, assuming 'Sanity'..."
IF [%4] EQU [] set tag=Sanity
echo "===>TestType value="%testType% "<==="

echo %date%:%time% Started running EShop Tests against Gitlab Branch: %BranchName% in %testenv% environment for TestType=%testType....

%MAVEN_HOME%\bin\mvn clean verify serenity:aggregate -Dstaf.environment.key=%testenv%  -Dwebdriver.driver=firefox -Dcucumber.options="src/test/resources/features --tags %tag% --plugin json:target/EShopReports.json"
REM %MAVEN_HOME%\bin\mvn clean install -Dtest=RunCukesTest

echo  %date%:%time% Completed running EShop Tests against Gitlab Branch: %BranchName% in %testenv% environment....
cd C:\OSSPROV\EShop