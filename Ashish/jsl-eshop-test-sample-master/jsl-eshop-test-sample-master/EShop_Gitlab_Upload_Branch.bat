REM # ##################################################################################
REM # Name:  EShop_Gitlab_Upload.bat
REM # Date: 01/29/2018
REM # Version: 1.0
REM # Author: Arun K.
REM #
REM # Overview: Checks in (git add + git push) updated EShop Test Scripts code into Gitlab
REM #  
REM # Inputs: All files to be checked in (even those NOT modified)
REM #
REM # Expected Output: Status of "push"ing above files into Gitlab
REM #
REM ####################################################################################
cls
echo %date%:%time%
cd C:\OSSPROV\EShop


set GIT_HOME=C:\Git
set Appl=EShop
set LogPath=%BaseOSS%\OutputLogs
set BaseOSS=C:\OSSPROV
set BaseAppPath=%BaseOSS%\%Appl%
set BranchName=%1
IF [%1] EQU [] echo "No Branch Parameter argument passed in, exiting...."
IF [%1] EQU [] goto EXIT

set BaseCodePath=%BaseAppPath%\EShop_FrameWork_%BranchName%
set LogPath=%BaseAppPath%\OutputLogs
set OssUser=ossprov
set OssPword=Ri6nviv4
set GitURL=https://ne1itcprhas62.ne1.savvis.net
set GitServer=ne1itcprhas62.ne1.savvis.net
set GitPath=ESHOP/Eshop_TST.git

mkdir C:\OSSPROV\EShop
mkdir %BaseCodePath%

REM --------- To Check in all folders into Gitlab -------------

echo " change directory to the root of where the code you want to check in is "

cd %BaseCodePath%
C:
echo "In source directory"

%GIT_HOME%\bin\git init
echo "Git Init completed"

%GIT_HOME%\bin\git remote add origin http://%OssUser%:%OssPword%@%GitServer%/%GitPath%

echo "git remote - completed"

%GIT_HOME%\bin\git add .
echo "git add completed"

%GIT_HOME%\bin\git commit -m "Adding the Target folder"
echo "Git commit completed"

%GIT_HOME%\bin\git push -u origin %BranchName%
echo "Git push completed"

echo "End Items added to Git repository...."
cd C:\OSSPROV\EShop

echo %date%:%time%

:EXIT
 echo "Completed cloning from Gitlab...."
 