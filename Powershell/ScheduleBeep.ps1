
#Creates a simple Beep
[console]::beep(1000, 1000)

#Checks if the task is already scheduled if not it will schedule it

try{
    Get-ScheduledTask -TaskName "ScheduleBeep" -ErrorAction Stop
    Write-Host "Task is already scheduled"
}
catch {
    #the action running is this script itself
    $action = New-ScheduledTaskAction -Execute 'powershell.exe' -Argument '-NoProfile -WindowStyle Hidden -File "C:\Users\Lenovo\Scripts\ScheduleBeep.ps1"'

    #Script will run every minute
    $trigger = New-ScheduledTaskTrigger -Once -At (Get-Date) `
        -RepetitionInterval (New-TimeSpan -Minutes 1)

    #Register the task
    Register-ScheduledTask -TaskName "ScheduleBeep" -Action $action -Trigger $trigger -Description "Beeps every minute"
}
Write-Host "Beep"

#Get rid of it when you are done
#Unregister-ScheduledTask -TaskName 'ScheduleBeep' -Confirm:$false