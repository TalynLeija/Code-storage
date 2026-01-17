#https://www.youtube.com/watch?v=DLAcS1kkFvY

#Hide useless warnings
import os
os.environ['TF_CPP_MIN_LOG_LEVEL'] = '3'
#
from time import sleep
from keras.models import load_model
from keras.callbacks import EarlyStopping
from keras.models import Sequential
from keras.layers import  Dense
# from keras.losses import MeanSquaredError
# from keras.metrics import RootMeanSquaredError
from keras.optimizers import Adam
import random
import numpy as np
import pandas as pd

#1. Collecting Data
#C:/Users/Lenovo/OneDrive/Documents/Exel sheets1/
df = pd.read_excel('addition_data.xlsx')
# print(df.head())

#2. Cleaning the data
#since i made the data It's already clean

#3. Train/Test split
Train=df.drop(columns=['sum'])
Test=df[['sum']]
# print(Test['sum'][0])

#for later testing
# test_data=[]
# for i in range(50):
#     templ=[]
#     for j in Train.iloc[i]:
#         test_data.append(j)
# print(test_data)

#4. createing model
# # since we saved it we don't need this
# model = Sequential()
# #experiment with nerons
# model.add(Dense(5, activation='relu', input_shape=(5,)))
# #neuron for every posible outcome 20*5 is 100
# model.add(Dense(100, activation='relu'))
# model.add(Dense(50, activation='relu'))
# model.add(Dense(1))
# # model.compile(loss=MeanSquaredError(), optimizer=Adam(learning_rate=0.0001), metrics=[RootMeanSquaredError()])
# model.compile(optimizer=Adam(learning_rate=0.005), loss='mean_squared_error')#optimizer='adam'

# #what early stoping means is if the model doesn't improve it stops early
# model.fit(Train, Test, epochs=150)#, callbacks=[EarlyStopping(patience=3)]


#5. save model
#only need to do this once
# model.save('simple_test.h5')
#put model in main to use
old_model = load_model('simple_test.h5')

#6. makeing predictions
#simple test
test_data = np.array([5,1,10,6,7])#Expected answer 29 #Add them all up
prediction = round(old_model.predict(test_data.reshape(1,5), batch_size=1)[0][0])#
print("prediction\t"+str(prediction))

#generate test data
# random.seed(4)
# data = []
# for i in range(10):
#     templist=[]
#     for j in range(5):
#         templist.append(random.randint(1, 21))
#     data.append(templist)

# def sum(list):
#     sum=0
#     for i in list:
#         sum+=i
#     return sum

# # print(data)

# for i in range(len(data)):
#     testl=np.array(data[i])
#     #prediction = round(old_model.predict(testl.reshape(1,5), batch_size=1)[0][0])
#     prediction = round(old_model.predict(testl.reshape(1,5), batch_size=1)[0][0])
#     print("prediction\t"+str(prediction))
#     print("actual data\t"+str(sum(data[i])))
#     sleep(4)

# print(round(old_model.predict(test_data.reshape(5))))
print("All is well")