REM # #####################################################################################################
REM # Name:  Run_EShop_Tools.bat
REM # Date: 06/21/2017
REM # Version: 1.0
REM # Author: Arun K.
REM #
REM # EShop Overview: Compiles EShop Tools Scripts code
REM #  
REM # Inputs: 	nothing
REM #		
REM #
REM # Expected Output: Run Branch EShop Tools output log file located in C:\OSSPROV\EShop\OutputLogs directory
REM #
REM ########################################################################################################
echo ON
echo %date%:%time%

set BranchName=%1
IF [%1] EQU [] echo "No Branch Parameter argument passed in, assuming 'master' branch...."
IF [%1] EQU [] set BranchName=master

echo "NOW RUNNING EShop Tools...."
cd C:\OSSPROV\EShop\EShop_Framework_%BranchName%\EshopTools
C:\Maven\apache-maven-3.3.9\bin\mvn clean install
set CLASSPATH=%CLASSPATH%;C:\OSSPROV\EShop\EShop_Framework_%BranchName%\EshopTools\target\EShopTools-0.0.1-SNAPSHOT.jar
echo "DONE RUNNING EShop Tools...."
echo " "
cd C:\OSSPROV\EShop

echo %date%:%time%
echo OFF