<h1>Scheduled screen shot capture</h1>

<h2>Description</h2>
This project uses a powershell script on Windows 10 to automate screenshot capture. With a little tweaking it would be a good tool to use to spy on someone. It takes screenshots every 30-minutes and saves them to a folder newly created folder on the C: drive.
<br />

<h2>Requirements</h2>

- <b>Windows 10</b>
- <b>ScreenShotCapture.ps1</b>

<h2>How to use</h2>

<p align="center">
Simply Right click the script wherever you put it and hit run as powershell: <br/>
<img src="https://raw.githubusercontent.com/TalynLeija/MyImages/main/SSC1.png" height="80%" width="80%"/>
<br />
  
Just like that the script is sceduled to take screenshots every 30 minutes. You can see the images in the new folder created a **C:\SecretFolder** Also you can see the script was re-located to that folder as well:<br/>  

<img src="https://raw.githubusercontent.com/TalynLeija/MyImages/main/SSC3.png" height="80%" width="80%"/> 
</p>

<h2>Delete when done</h2>

<p align="center">
To unregister the script simply run the command below in powershell:<br />

```
Unregister-ScheduledTask -TaskName 'ScreenCapture1' -Confirm:$false
```

<img src="https://raw.githubusercontent.com/TalynLeija/MyImages/main/SSC4.png" height="80%" width="80%"/>

Once the script stops running all that's left is to clean up the original script. Head over to **File Explorer** and type **C:\SecretFolder** and delete the folder were the screenshot and script is being stored:<br />

<img src="https://raw.githubusercontent.com/TalynLeija/MyImages/main/Screenshot_of_Folder.png" height="80%" width="80%"/>
<img src="https://raw.githubusercontent.com/TalynLeija/MyImages/main/SSC3.png" height="80%" width="80%"/> 
</p>
