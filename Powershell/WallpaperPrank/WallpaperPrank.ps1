#Varibles
$url = "https://raw.githubusercontent.com/TalynLeija/Code-storage/main/Powershell/WallpaperPrank/ProfesionalTroll.jpg"
$myPath = $PSCommandPath
$RegPath = "HKCU:\Control Panel\Desktop\"
$backgroundimage = "C:\SecretFolder\ProfesionalTroll.jpg"
$CurrentWallpaper = Get-ItemPropertyValue -Path $RegPath -Name Wallpaper
Write-Host $CurrentWallpaper

#Checks if the task is already scheduled if not it will schedule it
try{
    Get-ScheduledTask -TaskName "WallpaperPrank" -ErrorAction Stop
    Write-Host "Task is already scheduled"
}
catch {
    #Assuming this is the first run of the script this will download the image and create the folder
    #Create Directory
    md "C:\SecretFolder" -erroraction silentlycontinue

    #download images
    Invoke-WebRequest -Uri $url -OutFile "C:\SecretFolder\ProfesionalTroll.jpg"

    #Moves script to new folder
    Move-Item -Path $myPath -Destination "C:\SecretFolder"
    
    #the action running is this script itself
    $action = New-ScheduledTaskAction -Execute 'powershell.exe' -Argument '-ExecutionPolicy Bypass -WindowStyle Hidden -File "C:\SecretFolder\WallpaperPrank.ps1"'

    #Script will run every minute
    $trigger = New-ScheduledTaskTrigger -Once -At (Get-Date) `
        -RepetitionInterval (New-TimeSpan -Minutes 5)

    #Register the task
    Register-ScheduledTask -TaskName "WallpaperPrank" -Action $action -Trigger $trigger -Description "Changes wallpaper"
}


#This uses C# code from user32.dll libary to change the wallpaper
#I can change the wallpaper from registry but this is the only
#method that updates it instantly
$code = @' 
using System.Runtime.InteropServices; 
namespace Win32{ 
    
     public class Wallpaper{ 
        [DllImport("user32.dll", CharSet=CharSet.Auto)] 
         static extern int SystemParametersInfo (int uAction , int uParam , string lpvParam , int fuWinIni) ; 
         
         public static void SetWallpaper(string thePath){ 
            SystemParametersInfo(20,0,thePath,3); 
         }
    }
 } 
'@
#this adds the C# code somewhere on the computer
add-type $code -ErrorAction SilentlyContinue


#Checks if background image changed so it can change it back to the troll image
If ($CurrentWallpaper -ne $backgroundimage)
{
    #Changes background fit to tile
    Set-ItemProperty -Path $RegPath -Name TileWallpaper -Value 1

    #Apply the Change on the system 
    [Win32.Wallpaper]::SetWallpaper($backgroundimage)
}


#Get rid of it when you are done
#Unregister-ScheduledTask -TaskName 'WallpaperPrank' -Confirm:$false