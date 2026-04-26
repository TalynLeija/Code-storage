#simple loop
$HaloPeeps = @('Master Chief','Cortana','Captain Keyes','Arbitor')

#Simple for loop
#For($counter =0;$counter -le 3;$counter++){
#Write-Host "Holy smokes it's" $HaloPeeps[$counter]
#}
##Replace 3 in the loop with ($HaloPeeps.Length -1)
##-le means less than

Foreach ($peep in $HaloPeeps){
    Write-Host $peep "has arrived!"
}

$Xmen = @('Wolverine','Cyclops','Storm','Professor X','Gambit','Jean Grey')
$counter = 0
#-ne not
While($counter -ne 6){
    Write-Host $Xmen[$counter]
    $counter++;
}

#do loop doesn't seem useful