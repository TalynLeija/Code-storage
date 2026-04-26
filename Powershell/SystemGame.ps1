#SystemGame

#User input
#-Prompt allows for message prompt
$PokemonNum = 25
#-ge greater than
#-le less than
#-eq equal to
#-ne Not
if($PokemonNum -ge 0 -and $PokemonNum -le 151){
    Write-Host "Your Pokemon is from Kanto!"
} Elseif ($PokemonNum -ge 152 -and $PokemonNum -le 251){
    Write-Host "Your Pokemon is from Johto!"
} Elseif ($PokemonNum -ge 252 -and $PokemonNum -le 386){
    Write-Host "Your Pokemon is from Hoenn!"
}

#Switch statement
$House = "Targaryen"
Switch($House){
   "Targaryen" {Write-Host "Your crazy"; break}
   "Lannister" {Write-Host "you always pay your debts"; break}
   "Stark" {Write-Host "Nothing bad is going to happen right!"; break}
}