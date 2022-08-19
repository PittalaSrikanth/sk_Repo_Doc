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

mkdir C:\OSSPROV\EShop
mkdir C:\OSSPROV\EShop\EShop_Framework

REM --------- To Check in all folders into Gitlab -------------

echo " change directory to the root of where the code you want to check in is "

cd C:\OSSPROV\EShop\EShop_Framework
echo "In source directory"

C:\Git\bin\git init
echo "Git Init completed"

C:\Git\bin\git remote add origin http://ossprov:Ri6nviv4@NE1ITCPRHAS62.ne1.savvis.net/ESHOP/Eshop_TST.git

echo "git remote - completed"

C:\Git\bin\git add .
echo "git add completed"

C:\Git\bin\git commit -m "Adding the Target folder"
echo "Git commit completed"

C:\Git\bin\git push -u origin master
echo "Git push completed"

echo "End Items added to Git repository...."
cd C:\OSSPROV\EShop

echo %date%:%time%

REM pause

