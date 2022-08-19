REM 01/18/2018
echo ON
echo %date%:%time% "Started Running EShop Tests...."
cd C:\OSSPROV\EShop\EShop_Framework\EShopTests

set MAVEN_HOME=C:\Maven\apache-maven-3.3.9

REM First argument passed in is Environment (ITV1, ITV2, ITV3, E2E)
set testEnv=%1
IF [%1] EQU [] echo "No Environment-Name argument passed in, assuming 'E2E'...."
IF [%1] EQU [] set testEnv=E2E
echo "===>TestEnv value="%testEnv% "<==="

REM Second argument passed in is Gherkin Feature file tag, default tag is @EShopSanity
set Tags=%2
REM List of Current Tags: set Tags=@EshopTestScripts @EShopFunctional @eshopCentral @EshopEastern @payNow @exactMatch @noMatch @nearMatch @CalculateEarliestDueDate @remarks @createAccount @EShopSanity @eshopcentral @eshopEastern @creditCheck @shopOptional
IF [%2] EQU [] echo "No Tag Parameters argument passed in, assuming '@EShopSanity' tag...."
IF [%2] EQU [] set Tags=@EShopSanity
echo "===>Tag value="%Tags% "<==="

REM Third argument passed in is TestType, default tag is Sanity 
set testType=%3
REM List of Current TestTypes set tag=(Sanity, Functional, Regression, IST, FTT)
IF [%3] EQU [] echo "No TestType Parameter argument passed in, assuming 'Sanity'..."
IF [%3] EQU [] set Tags=Sanity
echo "===>TestType value="%testType%"<===""

%MAVEN_HOME%\bin\mvn clean verify serenity:aggregate -DTestType=%testType% -Dstaf.environment.key=%testEnv% -Dwebdriver.driver=firefox -Dcucumber.options="src/test/resources/features --tags %Tags% --plugin json:target/EShopReports.json"

echo %date%:%time% Completed Running EShop Tests for Env=%testEnv%; Tags=%tag%; TestType=%testType%....

cd C:\OSSPROV\EShop
