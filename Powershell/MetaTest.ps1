
#Location of current script
$myPath = $PSCommandPath

if (Test-Path "C:\Users\Lenovo\Scripts\TestFolder\MetaTest.ps1") {
    Write-Host "Its all good boss"
}
else {
    Move-Item -Path $myPath -Destination "C:\Users\Lenovo\Scripts\TestFolder"
    Write-Host "Moving script"
}

Write-Host "lol"
