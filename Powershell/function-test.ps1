
#creating a function to ping spacex
function Test-Spacex {
    ping spacex.com
}
#Now call the function below just delete comment
#Test-Spacex

#This function allows you to specify how many pings you
#want to send
function Test-Spacex2 {
    #param meaning parameter, a space to be filled in function
    param(
        $PingCount
    )
    Test-Connection spacex.com -Count $PingCount
}
#Test-Spacex2 -PingCount 2
#Test-Spacex2

#This is th same function only the parameter is mandatory now and
#It asks for it
function Test-Spacex3 {
    [CmdletBinding()] #turns into advanced function
    param(
        [Parameter(Mandatory)]
        #why int32
        [int32]$PingCount
    )
    Test-Connection spacex.com -Count $PingCount
}
#Test-Spacex3

#In addition to functions lets use exceptions
function Test-Spacex4 {
    param(
        [Parameter(Mandatory)]
        [int32]$PingCount
    )
    Test-Connection spacex.com -Count $PingCount
}
#use this in catch to write real error message | write-Output $_
try{Test-Spacex4 -ErrorAction stop} catch {write-Output "Didnt use a real number"}
#To see the error message type -1 or 0 in the prompt
#The [int32] automatically doesn't accept anything that isnt
#a number, logic errors on the other hand can get through

try {
    # Code that might cause an error
    Get-Content "C:\MissingFile.txt" -ErrorAction Stop
}
catch {
    # Code that runs if an error is caught
    Write-Host "An error occurred: $($_.Exception.Message)" -ForegroundColor Red
}
finally {
    # Code that always runs (e.g., closing connections)
    Write-Host "Cleanup completed."
}
