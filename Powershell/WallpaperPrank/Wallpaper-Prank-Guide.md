<h1>Wallpaper Prank Setup</h1>
<!-- https://raw.githubusercontent.com/TalynLeija/Code-storage/main/Powershell/WallpaperPrank/ProfesionalTroll.jpg -->

<h2>Description</h2>
This project involves running a powershell script on a windows 10 computer that changes the wallpaper. Not only does it change the wallpaper but if the person tries changing it back it is scheduled to check the current wallpaper and change it back to the troll image.
<br />

<h2>Requirements</h2>

- <b>Windows 10</b>
- <b>WallpaperPrank.ps1</b>

<h2>How to use</h2>

<p align="center">
This is my wallpaper before I downloaded the script. Right click the script and hit run as powershell: <br/>
<img src="https://raw.githubusercontent.com/TalynLeija/MyImages/main/Screenshot%20(8).png" height="80%" width="80%"/>
<br />
Just like that the script is sceduled to keep changing the wallpaper. Also if you noticed the script disapeared thats because it moved itself to a seperate folder:  <br/>
<img src="https://raw.githubusercontent.com/TalynLeija/MyImages/main/Screenshot%20(9).png" height="80%" width="80%"/> 
</p>

<h2>Delete when done</h2>

<p align="center">
Running the script is easier then deleteing it, especially for those that are not tech savy. To unregister the script simply run the command below in powershell:<br />

```
Unregister-ScheduledTask -TaskName 'WallpaperPrank' -Confirm:$false
```

<img src="https://raw.githubusercontent.com/TalynLeija/MyImages/main/Ending_script.png" height="80%" width="80%"/>

Once the script stops running all that's left is to clean up the original script. Head over to **File Explorer** and type **C:\SecretFolder** and delete the folder were the image and script is being stored:<br />

<img src="https://raw.githubusercontent.com/TalynLeija/MyImages/main/Screenshot_of_Folder.png" height="80%" width="80%"/>
<img src="https://raw.githubusercontent.com/TalynLeija/MyImages/main/Screenshot_of_script.png" height="80%" width="80%"/> 
</p>

