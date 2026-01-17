from time import sleep
from selenium import webdriver
from selenium.webdriver.edge.service import Service
from selenium.webdriver.common.by import By
from selenium.webdriver.support.select import Select
from selenium.common.exceptions import TimeoutException

##
    # test1 = driver.find_element(By.XPATH, "/html/body/div[1]/div/div/div[1]/article/div[1]/div/div/div[1]/h1")
    # print(test1.text)    
    # month = driver.find_element(By.XPATH, "/html/body/div[1]/div/div/div[1]/article/div[1]/div/div/div[1]/div/span/div[1]/div[2]/div/div[1]")
    # print(month.text)
    # month = driver.find_element(By.XPATH, "/html/body/div[1]/div/div/div[1]/article/div[1]/div/div/div[1]/div/span/div[1]/div[2]/div/div[2]/span")
    # month.click()
    # print(month.text)

    # october = driver.find_element(By.XPATH, "/html/body/div[1]/div/div/div[1]/article/div[1]/div/div/div[1]/div/span/div[1]/div[2]/div/div[2]")
##
Path = Service("C:/Users/Talyn/Documents/Exclusion/msedgedriver.exe")
#get rid of uneasasary errors
Options = webdriver.EdgeOptions()
Options.add_experimental_option('excludeSwitches',['enable-logging'])
#
driver = webdriver.Edge(options=Options, service=Path)



try:
    driver.set_page_load_timeout(100)
    url = "https://scholarshipowl.com/?aff_sub=&aff_sub2=&aff_sub3=9028688_c_aud-1879558887787%3Akwd-29376314345&aff_sub4=&aff_sub5=322160521408&affiliate_id=1727&gb=%7Bgb%7D&offer_id=32&skey=gclid&transaction_id=102cc788d8a3c730b4339df76adf9f"
    driver.get(url)

    month = driver.find_element(By.XPATH, "/html/body/div[1]/div/div/div[1]/article/div[1]/div/div/div[1]/div/span/div[1]/div[2]/div/div[2]")
    month.click()
    sleep(4)    
    monthPr = driver.find_elements(By.XPATH, "/html/body/div[1]/div/div/div[1]/article/div[1]/div/div/div[1]/div/span/div[1]/div[2]/div/div[3]/ul/li")
    for i in range(12):
        print(monthPr[i].text)
    print("")

    Date = driver.find_element(By.XPATH, "/html/body/div[1]/div/div/div[1]/article/div[1]/div/div/div[1]/div/span/div[1]/div[2]/p[1]/input").send_keys(10)
    sleep(4)
    year = driver.find_element(By.XPATH, "/html/body/div[1]/div/div/div[1]/article/div[1]/div/div/div[1]/div/span/div[1]/div[2]/p[2]/input").send_keys(2001)   
    sleep(4) 

    gender = driver.find_element(By.XPATH, "/html/body/div[1]/div/div/div[1]/article/div[1]/div/div/div[1]/div/span/div[2]/div[1]/div[2]/div[2]")
    gender.click()
    sleep(4)    
    genderPr = driver.find_elements(By.XPATH, "/html/body/div[1]/div/div/div[1]/article/div[1]/div/div/div[1]/div/span/div[2]/div[1]/div[2]/div[3]/ul/li")
    for i in range(3):
        print(genderPr[i].text)        
    print("")

    school_leval = driver.find_element(By.XPATH, "/html/body/div[1]/div/div/div[1]/article/div[1]/div/div/div[1]/div/span/div[2]/div[2]/div[2]/div[2]")
    school_leval.click()
    sleep(4)
    school_levalPr = driver.find_elements(By.XPATH, "/html/body/div[1]/div/div/div[1]/article/div[1]/div/div/div[1]/div/span/div[2]/div[2]/div[2]/div[3]/ul/li")
    for i in range(10):
        print(school_levalPr[i].text)
    print("")

    major = driver.find_element(By.XPATH, "/html/body/div[1]/div/div/div[1]/article/div[1]/div/div/div[1]/div/span/div[3]/div[2]/div[2]")
    major.click()
    sleep(4)
    majorPr = driver.find_elements(By.XPATH, "/html/body/div[1]/div/div/div[1]/article/div[1]/div/div/div[1]/div/span/div[3]/div[2]/div[3]/ul/li")
    for i in range(37):
        print(majorPr[i].text)
    print("")


except Exception as ex:
    print("Either update edge or something is wrong\n"+str(ex))
    driver.close()
    

print("All is well")
# driver.quit()
