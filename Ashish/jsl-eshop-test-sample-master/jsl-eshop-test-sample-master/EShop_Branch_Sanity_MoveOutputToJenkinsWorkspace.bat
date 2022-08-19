REM # ##################################################################################
REM # Name:  Eshop_Branch_Sanity_MoveOutputToJenkinsWorkspace.bat
REM # Date: 01/30/2018
REM # Version: 1.0
REM # Author: Arun K.
REM #
REM # Overview: Copies OmniVue Test execution output files, reports, etc. to a common directory for Jenkins server to recognize (C:\Jenkins\SlaveNode\workspave\JobName)
REM #  
REM # Inputs: EShop Sanity Test execution output files, reports, etc.
REM #
REM # Expected Output: All above Output files will be copied to C:\Jenkins\SlaveNode\workspace\JobName
REM #
REM ####################################################################################
cls
echo ON
echo %date%:%time%: " Executing Eshop_Branch_Sanity_MoveOutputToJenkinsWorkspace...."

set BranchName=%1
IF [%1] EQU [] echo "No Branch Parameter argument passed in, assuming 'master' branch...."
IF [%1] EQU [] set BranchName=master

set BaseAppPath=C:\OSSPROV
set AppName=Eshop
set BaseCodePath=%BaseAppPath%\%AppName%

set OutLogsPath=%BaseCodePath%\OutputLogs
set ReportsPath=%BaseCodePath%\%AppName%_Framework_%BranchName%\EshopTests\Reports
set SitePath=%BaseCodePath%\%AppName%_Framework_%BranchName%\EShopTests\target\site
set FailsafeReports=%BaseCodePath%\%AppName%_Framework_%BranchName%\EShopTests\target\failsafe-reports
set ScreenShotsPath=%BaseCodePath%\%AppName%_Framework_%BranchName%\EShopTests\ScreenShots
set JenkinsWorkspace=C:\Jenkins\SlaveNode\workspace

set JenkinsJob=%1%
echo "Jenkins JobName=" %JenkinsJob%

echo "Start Copying Output files to Jenkins Workspace created today, before copying it to Jenkins server"
echo "Copying Test-Scripts generated logs to Jenkins-Workspace on Win7 box for Jenkins Job: " %JenkinsJob%

cd %OutLogsPath%

echo "*** Copying Eshop Clone files from " %OutLogsPath% ....
FOR /F %%I IN ('DIR "%OutLogsPath%\*Eshop*Clone*%date:~-4%%date:~4,2%%date:~7,2%*.log" /B /O:D') DO (SET NewestFile=%%I)
echo "Newest file is:" %NewestFile%
xcopy /s %NewestFile% %JenkinsWorkspace%\%JenkinsJob% /E/K/Y

echo "*** Copying Eshop Tools files from " %OutLogsPath% ....
FOR /F %%I IN ('DIR "%OutLogsPath%\*Eshop*Tools*%date:~-4%%date:~4,2%%date:~7,2%*.log" /B /O:D') DO (SET NewestFile=%%I)
echo "Newest file is:" %NewestFile%
xcopy /s %NewestFile% %JenkinsWorkspace%\%JenkinsJob% /E/K/Y

echo "*** Copying Eshop Tests files from " %OutLogsPath% ....
FOR /F %%I IN ('DIR "%OutLogsPath%\*Eshop*Tests*%date:~-4%%date:~4,2%%date:~7,2%*.log" /B /O:D') DO (SET NewestFile=%%I)
echo "Newest file is:" %NewestFile%
xcopy /s %NewestFile% %JenkinsWorkspace%\%JenkinsJob% /E/K/Y

echo "*** Copying files from " %SitePath% ....
FOR /F %%I IN ('DIR "%SitePath%" /B /O:D') DO (SET NewestFile=%%I)
echo "Newest file is:" %NewestFile%
xcopy /s %SitePath% %JenkinsWorkspace%\%JenkinsJob% /E/K/Y

echo "*** Copying files from " %ReportsPath% ....
xcopy /s %ReportsPath% %JenkinsWorkspace%\%JenkinsJob% /E/K/Y

echo "*** Copying files from " %FailsafeReports% ....
xcopy /s %FailsafeReports% %JenkinsWorkspace%\%JenkinsJob% /E/K/Y

echo "*** Copying files from " %ScreenShotsPath% ....
xcopy /s %ScreenShotsPath% %JenkinsWorkspace%\%JenkinsJob% /E/K/Y

echo "End Copying Eshop_STAF_Sanity_MoveOutputToJenkinsWorkspace execution files to Jenkins Workspace, before copying it to Jenkins server"
cd %BaseCodePath%

echo %date%:%time%

echo OFF

