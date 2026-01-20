"""
    Before using this program make sure you have the edge driver
    on the right path as well as LottoMemory.txt and Lotto_Data.xlsx
"""

import openpyxl
import re
from selenium import webdriver
from selenium.webdriver.edge.service import Service
from selenium.webdriver.common.by import By
# from selenium.webdriver.support.ui import WebDriverWait
# from selenium.webdriver.support import expected_conditions as EC
from selenium.common.exceptions import TimeoutException


Excel_Path = 'Lotto_Data.xlsx'
wbook = openpyxl.load_workbook(Excel_Path)
ws = wbook.active


Path = Service("msedgedriver.exe")
#get rid of uneasasary errors
Options = webdriver.EdgeOptions()
Options.add_experimental_option('excludeSwitches',['enable-logging'])
#
driver = webdriver.Edge(options=Options, service=Path)

try:
    driver.set_page_load_timeout(10)
    url = "https://www.lotterypost.com/results/tx/texastwostep/past"
    driver.get(url)    

    #If website changes check here
    Date = driver.find_elements(By.TAG_NAME, "time")

    Bonus = driver.find_elements(By.CLASS_NAME, "red")

    Numbers = []
    #
    for i in range(len(Date)):
        numlist = driver.find_elements(By.XPATH, '//*[@id="content"]/main/div[3]/div[{0}]/div/div/div/div[1]/ul/li'.format(i+1))
        Numbers.append("")
        for num in range(len(numlist)):
            Numbers[i]+=numlist[num].text+" "

    Months = {"January": 1, "February": 2, "March": 3, "April": 4, "May": 5, "June": 6
        , "July": 7, "August": 8, "September": 9, "October": 10, "November": 11, "December": 12}

    #function that check if there are new lottery numbers
    def isNewDate(index):
        
        with open("LottoMemory.txt", 'r') as Memory:
            line = Memory.read()
            monthRegex = re.compile(r", \D+\s")
            yearRegex = re.compile(r"\d{4}")
            dateRegex = re.compile(r"\s\d+,")

            findMonth = monthRegex.findall(line)[0][2:-1]
            findYear = yearRegex.findall(line)[0]
            findDate = dateRegex.findall(line)[0][1:-1]

            newMonth = monthRegex.findall(Date[index].text)[0][2:-1]
            newYear = yearRegex.findall(Date[index].text)[0]
            newDate = dateRegex.findall(Date[index].text)[0][1:-1]


            if int(newYear)>int(findYear):
                ws.append([Date[index].text,Numbers[index],Bonus[index].text])
                print("New number "+str(index))
            elif int(newYear)==int(findYear) and Months[newMonth]>Months[findMonth]:
                ws.append([Date[index].text,Numbers[index],Bonus[index].text])
                print("New number "+str(index))
            elif int(newYear)==int(findYear) and Months[newMonth]==Months[findMonth]:
                if int(newDate)>int(findDate):
                    ws.append([Date[index].text,Numbers[index],Bonus[index].text])
                    print("New number "+str(index))
            else:

                pass

            Memory.close()

    
    i=len(Date)-1
    while i>=0:
        isNewDate(i)
        i-=1

    with open("LottoMemory.txt", 'w') as Memory:
        Memory.write(Date[0].text)
        Memory.close()

except Exception as ex:
    print("Either website changed or update drivers" + str(ex))
    driver.close()


print("All is well")
wbook.save('Lotto_Data.xlsx')
driver.quit()
