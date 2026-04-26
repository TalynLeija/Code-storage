#create a new text file
#New-Item -path C:\Users\Lenovo\Scripts\ewok.txt -type "file" -value "praise CP30"
#New-Item -path C:\Users\Lenovo\Scripts\What.txt -type "file" -value "The jedi are taking over anikin!"

#Creates a folder
#New-Item -path C:\Users\Lenovo\Scripts\deathstar -type directory
#Asuming you cd into the correct file path here how you can view the file
#cat ewoks.txt reads the text file on the command terminal

#This command copies a file into a folder
#Copy-Item C:\Users\Lenovo\Scripts\ewok.txt -destination C:\Users\Lenovo\Scripts\deathstar

#for the next test make sure you are in the correct path
#cd C:\Users\Lenovo\Scripts
#then move What.txt to deathstar
#the dot in the .\What.txt means the current directory
#Move-Item -path .\What.txt  -destination C:\Users\Lenovo\Scripts\deathstar

#You can also delete files in directory
#Remove-Item What.txt

#This command can check if path is still aviable
#Test-Path C:\Users\Lenovo\Scripts\What.txt
#Test-Path C:\Users\Lenovo\Scripts\ewok.txt

#This next part is confusing but apparently you can import active directory.
#Which is confusing because I thought you needed a special version of windows.
#Wait I think im right these commands only work if you have ActiveDirectory

#Lets you use active directory commands
#Import-Module ActiveDirectory
#Get-ADuser gameTerminator

