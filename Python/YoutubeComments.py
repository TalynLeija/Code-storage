from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.chrome.options import Options
from webdriver_manager.chrome import ChromeDriverManager
import time

#Put any url here
url = 'https://www.youtube.com/watch?v=cbqVKKB5TMo&list=RDcbqVKKB5TMo&start_radio=1'

#Using this method there is no need to specify a path
options = Options()
options.add_argument("--start-maximized")
driver = webdriver.Chrome(service=Service(ChromeDriverManager().install()), options=options)

#getting the video
driver.get(url)
time.sleep(5)

#Scroll to comment section
driver.execute_script("window.scrollBy(0, 800);")
time.sleep(3)

        # if len(comment_elements) < limit:
        #     print("Test A")
        #     driver.quit()
        #     boolean = False
        # elif len(comments) >= limit:
        #     print(len(comments))
        #     print("Test B")
        #     driver.quit()
        #     boolean = False   

#this limits the amount of comments to 10
limit = 10
num = 0 #dont change this
boolean = True
comments = []

while boolean:
    #Automatic scrolling
    driver.execute_script("window.scrollTo(0, document.documentElement.scrollHeight);")
    time.sleep(2)

    #Collect imediate comments up to about 40
    comment_elements = driver.find_elements(By.CSS_SELECTOR, "#content #content-text")
    username_elements = driver.find_elements(By.CSS_SELECTOR, "#author-text span")

    #Put everything collected in the list
    #The reason for the loop is in case the limit is longer than usual
    for i in range(len(comments), min(len(comment_elements), len(username_elements))):
        username = username_elements[i].text.strip()
        comment = comment_elements[i].text.strip()
        comments.append(str(username)+": "+str(comment))

    driver.quit()
    boolean = False


for i in range(limit):
    print(comments[i]+"\n")