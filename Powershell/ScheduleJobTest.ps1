#A scheduled job is more advanced then task scheduler

#$Trigger = New-JobTrigger -Daily -At 3pm
#$Scriptblock = {C:\Scripts\TestSpaceX.ps1}
#Register-ScheduledJob -Name "TestSpaceX job" -ScriptBlock $Scriptblock -Trigger $Trigger
#Afterwards you run this script in cmd .\ScheduleJobTest.ps1

#To see the scheduled job type this in powershell: Get-ScheduledJob
#To search for a specific task type: Get-ScheduledJob -Name "job you want"
#To remove task type: Unregister-ScheduledJob -Name "job lol"
