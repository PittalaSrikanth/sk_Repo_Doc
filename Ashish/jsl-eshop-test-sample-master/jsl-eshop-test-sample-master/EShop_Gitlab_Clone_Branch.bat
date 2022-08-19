cls
echo ON
echo %date%:%time%

REM Setup for checking out the OV automation code from GitLib to local directory structure
echo "-------- Cloning EShop Test Scripts into C:\OSSPROV2\EShop from Gitlab Repository" 

REM **************************************************************************
REM Update the following Variables for your application specific values.

set GIT_HOME=C:\Git
set Appl=EShop
set BaseOSS=C:\OSSPROV
set BranchName=%1
IF [%1] EQU [] echo "No Branch Parameter argument passed in, assuming 'master' branch...."
IF [%1] EQU [] set BranchName=master
set BaseAppPath=%BaseOSS%\%Appl%
set EShop_FW=EShop_FrameWork_%BranchName%
set EShop_FW_TMP=EShop_%BranchName%_%dtTmStr%
set BaseCodePath=%BaseAppPath%\%EShop_FW%
set LogPath=%BaseAppPath%\OutputLogs
set SplunkLogPath=%BaseOSS%\SplunkLogs
set OssUser=ossprov
set OssPword=Ri6nviv4
set GitURL=https://ne1itcprhas62.ne1.savvis.net
set GitServer=ne1itcprhas62.ne1.savvis.net
set GitPath=%Appl%/%Appl%_TST.git

set hour=%time: =0%
set min=%time:  =0%
set sec=%time:  =0%
set dtTmStr=%date:~-4%%date:~4,2%%date:~7,2%_%hour:~0,2%%min:~3,2%%sec:~6,2%
echo "Date-Time String:"%dtTmStr%


REM ******************************************************************************************

echo "-------- Cloning Test Scripts from GitLab Repository"
echo %GitURL%/%GitPath%

echo "Cleaning out existing EShop Test Scripts directories before Cloning...."

echo "Rename %EShop_FW% to  %EShop_FW_TMP% before deleting it -- allows it to be deleted in the background and thus saves time...."

cd %BaseAppPath%
C:

ren %EShop_FW% %EShop_FW_TMP%

echo "Deleting %EShop_FW_TMP% directory in the background...."
@start /b cmd /c rmdir /s/q %EShop_FW_TMP%

REM Following to make sure there is a directory, if already existing - a NOP

IF EXIST %BaseOSS% (echo %BaseOSS% already exists, skipping....) ELSE (mkdir %BaseOSS%)
IF EXIST %BaseAppPath% (echo %BaseAppPath% already exists, skipping....) ELSE (mkdir %BaseAppPath%)
IF EXIST %BaseAppPath%\%EShop_FW% (echo %BaseAppPath%\%EShop_FW% already exists, skipping....) ELSE (mkdir %BaseAppPath%\%EShop_FW%)
IF EXIST %BaseCodePath% (echo %BaseCodePath% already exists, skipping....) ELSE (mkdir %BaseCodePath%)
IF EXIST %LogPath% (echo %LogPath% already exists, skipping....) ELSE (mkdir %LogPath%)
IF EXIST %SplunkLogPath% (echo %SplunkLogPath% already exists, skipping....) ELSE (mkdir %SplunkLogPath%)

cd %BaseCodePath%
C:

echo "\%GIT_HOME%\bin\git clone %BranchName% branch...."
%GIT_HOME%\bin\git config --global http.sslVerify false

%GIT_HOME%\bin\git clone http://%OssUser%:%OssPword%@%GitServer%/%GitPath% --branch %BranchName% %BaseCodePath%

%GIT_HOME%\bin\git status

cd %BaseAppPath%

echo "-------- " %Appl% " Test Scripts Cloned into %BranchName% of %BaseCodePath% from Gitlab Repository %GitURL%/%GitPath% ---"

echo %date%:%time%
echo OFF