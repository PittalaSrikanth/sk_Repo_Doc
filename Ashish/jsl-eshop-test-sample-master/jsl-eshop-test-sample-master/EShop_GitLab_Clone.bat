REM # #############################################################################################
REM # Name:  EShop_Gitlab_Clone.bat
REM # Date: 01/24/2018
REM # Version: 1.0
REM # Author: Arun K.
REM #
REM # Overview: Checks out (clones) EShop Test Scripts code from Gitlab Master branch
REM #  
REM # Inputs: nothing
REM #
REM # Expected Output: Gitlab Clone output log file located in C:\OSSPROV\EShop\OutputLogs directory
REM #
REM ################################################################################################
cls
echo ON
REM **  jn - 2/7 - adding to EShop
REM **  After clone - this script will be copied up to c:\OSSPROV\EShop
echo %date%:%time%
REM Setup for checking out the OV automation code from GitLab to local directory structure
echo "-------- Cloning EShop Test Scripts into C:\OSSPROV\EShop from Gitlab Repository" 

REM **************************************************************************
REM Update the following Variables for your application specific values.

set Appl=EShop
set BaseOSS=C:\OSSPROV
set SplunkLogPath=%BaseOSS%\SplunkLogs
set BaseAppPath=%BaseOSS%\%Appl%
set EShop_FW=EShop_FrameWork
set EShop_BRANCH=master
set BaseCodePath=%BaseAppPath%\%EShop_FW%
set LogPath=%BaseAppPath%\OutputLogs
set SplunkLogPath=%BaseOSS%\SplunkLogs
set GitURL=https://ne1itcprhas62.ne1.savvis.net
set GitServer=ne1itcprhas62.ne1.savvis.net
set GitPath=%Appl%/%Appl%_TST.git
set GitLogin=ossprov
set GitPwd=Ri6nviv4

set hour=%time: =0%
set min=%time: =0%
set sec=%time: =0%
set DTM=%date:~-4%%date:~4,2%%date:~7,2%_%hour:~0,2%%min:~3,2%%sec:~6,2%
set EShop_FW_TMP=%EShop_FW%_%DTM%

cd %BaseAppPath%
C:

REM ******************************************************************************************

echo "-------- Cloning EShop Test Scripts from GitLab Repository"
echo "https://NE1ITCPRHAS62.ne1.savvis.net/ESHOP/Eshop_TST.git ------"

echo "Cleaning out existing EShop Test Scripts directories before Cloning...."

cd %BaseAppPath%

echo "Rename %EShop_FW% to %EShop_FW_TMP% before deleting it -- allows it to be deleted in the background and thus saves time...."
ren %EShop_FW% %EShop_FW_TMP%

echo "Delete %EShop_FW_TMP% directory in the background...."

@start /b cmd /c rmdir /s/q %EShop_FW_TMP%

REM rmdir /s/q %EShop_FW_TMP%

REM Following to make sure there is a directory, if already existing - a NOP

IF EXIST %BaseOSS% (echo %BaseOSS% already exists, skipping....) ELSE (mkdir %BaseOSS%)
IF EXIST %BaseAppPath% (echo %BaseAppPath% already exists, skipping....) ELSE (mkdir %BaseAppPath%)
IF EXIST %BaseAppPath%\%EShop_FW% (echo %BaseAppPath%\%EShop_FW% already exists, skipping....) ELSE (mkdir %BaseAppPath%\%EShop_FW%)
IF EXIST %BaseCodePath% (echo %BaseCodePath% already exists, skipping....) ELSE (mkdir %BaseCodePath%)
IF EXIST %LogPath% (echo %LogPath% already exists, skipping....) ELSE (mkdir %LogPath%)
IF EXIST %SplunkLogPath% (echo %SplunkLogPath% already exists, skipping....) ELSE (mkdir %SplunkLogPath%)

cd %BaseCodePath%
C:

echo "git clone...."
REM Temporarily turn OFF SSL Verification, until the CA issue has been resolved

C:\Git\bin\git config --global http.sslVerify false

REM C:\Git\bin\git config --global http.postBuffer 524288000

echo "Now clone EShop Repository from Gitlab......."
C:\Git\bin\git clone https://%GitLogin%:%GitPwd%@%GitServer%/%GitPath% %BaseCodePath%

cd %BaseAppPath%
C:

REM echo "Replace EShop_Gitlab_Clone.bat from Gitlab to EShop's Parent Directory"
REM copy /y %BaseCodePath%\EShop_GitLab_Clone.bat %BaseAppPath%\EShop_GitLab_Clone.bat

echo %date%:%time%: "  -------- Completed Cloning EShop Test Scripts into C:\OSSPROV\EShop from Gitlab Repository https://NE1ITCPRHAS62.ne1.savvis.net/ESHOP/Eshop_TST.git ---"
