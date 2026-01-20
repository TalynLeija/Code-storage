"""
The way this works is you copy everything on a webpage usually using
Ctrl + a and then running the program
"""
#example calculator website
#https://web2.0calc.com/imprint/

import pyperclip, re
from time import sleep
#Cell: 415-555-9999 Work: 212-555-0000
#1 915 888 7461 my email is talynone75@gmail.com
#+1 (915)-888-7461

def PhoneEmailFinder(Text):
    phoneregex = re.compile(r'''(
    (\d\s|\+\d\s)?               #country code         1
    (\d{3}|\(\d{3}\))            #area code           915
    (\s|-|\.)?                   #seperator            -
    \d{3}                        #extrange code       888
    (\s|-|\.)?                   #seperator            -
    \d{4}                        #subscriber number  7461
    )''', re.VERBOSE)
####
    emailregex = re.compile(r'\S+@\S+\.\S+')
####
    findphone=phoneregex.findall(Text)
    findemail=emailregex.findall(Text)
    print('Phonenumber          Email')
####
    num=0
    for phone, email in zip(findphone, findemail):
        num+=1
        print(phone[0], ' '*(21-len(phone[0]))+email)
    if len(findphone)>len(findemail):
        for i in findphone[num-len(findphone):]:
            print(i[0])
    elif len(findphone)<len(findemail):
        for i in findemail[num-len(findemail):]:
            print(' '*22+i[0])#why 22
####

while True:
    copy = str(pyperclip.paste())
    PhoneEmailFinder(copy)
    print('\nDo you wish to continue y/n')
    my_input=input()
    if my_input=='n':
        break
    else:
        continue