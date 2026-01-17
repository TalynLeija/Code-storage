import openpyxl
import numpy as np
import os
os.environ['TF_CPP_MIN_LOG_LEVEL'] = '3'

wbook = openpyxl.Workbook()
ws = wbook.active
#labels
Heading = ['X_Cord','Y_Cord','Refueling','Time']
ws.append(Heading)

data_size=1000#amount of data you want generated
np.random.seed(5)
Time_data = np.random.randint(1,25,size=(data_size))

Refueling_data = []
#filling Refueling data
refueling_day=1 #mon=1,tue=2,wen=3,thr=4,fri=5
for i in range(data_size):
        if refueling_day!=5:
            for j in range(1,6):
                if j==refueling_day:
                    Refueling_data.append('yes')
                else:
                    Refueling_data.append('no')
            refueling_day+=1    
        else:
            for j in range(1,6):
                if j==refueling_day:
                    Refueling_data.append('yes')
                else:
                    Refueling_data.append('no')
            refueling_day=1    
# print(Refueling_data)

#filling X_Cords
X_Cords=[]
Y_Cords=[]
Sea_of_week='austra'
for i in range(data_size):#????
    if Sea_of_week=='austra':
        if Refueling_data[i]=='no':
            X_Cords.append('A')
        elif Refueling_data[i]=='yes':
            X_Cords.append('B')
    elif Sea_of_week=='taimo':
        if Refueling_data[i]=='yes':
            X_Cords.append('C')
        elif Refueling_data[i]=='no':
            X_Cords.append('D')
    #
    if (i+1)%5==0 and Sea_of_week=='austra':
        Sea_of_week='taimo'
    elif (i+1)%5==0 and Sea_of_week=='taimo':
        Sea_of_week='austra'
#filling Y_Cords
for i in range(data_size):
    if Time_data[i]>=7 and Time_data[i]<=13:
        Y_Cords.append(1)
    elif Time_data[i]>=14 and Time_data[i]<=20:
        Y_Cords.append(2)
    elif Time_data[i]>=21 and Time_data[i]<=24 or Time_data[i]==21:
        Y_Cords.append(3)
    else:
        Y_Cords.append(4)

#createing data sheet
for i in range(data_size):
    ws.append([X_Cords[i],Y_Cords[i],Refueling_data[i],Time_data[i]])

def rule_explain():
    print("""\nMission statement:
A rogue submarine has new technology that makes it impossible to catch.
So you must prepair an ambush. lucky for you it follows a strict schedule
    
every week it goes somewhere in Austra sea and the following week goes to Taimo 
sea. When it refuels it goes near the border of the two seas.

By useing time of day and week along with recorded previous sightings, use machine learning
find it's next location.
    \n""")
    return None

#C:/Users/Lenovo/OneDrive/Documents/Exel sheets1/
wbook.save('Submarine_data.xlsx') 
print("All is well")
