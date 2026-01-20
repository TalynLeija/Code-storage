import os
os.environ['TF_CPP_MIN_LOG_LEVEL'] = '3'
import openpyxl
import random
import numpy as np

wbook = openpyxl.Workbook()
ws = wbook.active
ws.append(['num1','num2','num3','num4','num5',])

epochs=400
random.seed(4)
for i in range(epochs):
    cordlist=[]
    for j in range(5):

        cordlist.append(random.randint(1, 35))
    ws.append([cordlist[0],cordlist[1],cordlist[2],cordlist[3],cordlist[4],])

wbook.save('RNG_data.xlsx') 
print("All is well")