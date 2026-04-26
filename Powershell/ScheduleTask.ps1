#$trigger = New-ScheduledTaskTrigger -At 3pm -Daily

#in order to have a " within a "" add a ` before it like `"
#Write-Host "test `"test`""
#$action = New-ScheduledTaskAction -Execute "powershell.exe" -Argument "-File `"C:\Scripts\TestSpaceX.ps1`""

#$settings = New-ScheduledTaskSettingsSet 
#Register-ScheduledTask -Action $action -Trigger $trigger -TaskName "Test Spacex" -Description "Tests connection with spacex.com" Settings $settings

#To see the scheduled task type this in powershell: Get-ScheduledTask
#To search for a specific task type: Get-ScheduledTask -TaskName "Task you want"
#To get info on task type: Get-ScheduledTask Info
#To remove task type: Unregister-ScheduledTask -TaskName "Task lol" -Confirm:$false
