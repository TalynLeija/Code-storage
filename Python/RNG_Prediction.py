import os
os.environ['TF_CPP_MIN_LOG_LEVEL'] = '3'
#
import numpy as np
import matplotlib.pyplot as plt
import pandas as pd
import RNG_Analyzer as ra
import random
from sklearn.preprocessing import StandardScaler
from keras.models import load_model


#1. Collecting data
#generating pseudo random numbers
np.random.seed(5)
Previous_Lotto_numbers = np.random.randint(1,35,size=(200,5))

#convert numbers into their size brackets
SB_Lotto_numbers = np.zeros((200,5))
for i in range(len(Previous_Lotto_numbers)):
    for j in range(5):
        SB_Lotto_numbers[i][j]=ra.SB(Previous_Lotto_numbers[i][j])
#Create data frame
df = pd.DataFrame(SB_Lotto_numbers,columns=list("ABCDE"))


#2. Formatting data
scaler = StandardScaler().fit(df.values)
#transform df values to formated ones
transformed_dataset = scaler.transform(df.values)
#turn data into a dataframe to be easyier
transformed_df = pd.DataFrame(data=transformed_dataset, index=df.index)

#parameters
number_of_rows = df.values.shape[0] #total of games 200
window_length = 5 #amount of past games taken into consideration 5 or 7
number_of_columns = df.values.shape[1] #columns  5


#3. Train/Test split
#[200-5, 5, 5]
#[200-5, 5]
train = np.empty([number_of_rows-window_length, window_length, number_of_columns], dtype=float)
label = np.empty([number_of_rows-window_length, number_of_columns], dtype=float)

#filling up the the empty train and label array
for i in range(0, number_of_rows-window_length):
    train[i]=transformed_df.iloc[i:i+window_length,0: number_of_columns]
    label[i]=transformed_df.iloc[i+window_length: i+window_length+1, 0: number_of_columns]
# print(label[0])
# print(SB_Lotto_numbers[0])
# print(scaler.inverse_transform(train[0])[0])


#4. Createing model
from keras.models import Sequential
from keras.layers import LSTM, Dense, Bidirectional, Dropout

def Lstm_ML(window,columns,train1,label1):
    model = Sequential()
    #(7^5)/7=2401 0r 343
    model.add(Bidirectional(LSTM(240,
        input_shape=(window,columns),
        return_sequences=True)))
    model.add(Dropout(0.2))#
    model.add(Bidirectional(LSTM(240,
        input_shape=(window,columns),
        return_sequences=True)))
    model.add(Dropout(0.2))#
    model.add(Bidirectional(LSTM(240,
        input_shape=(window,columns),
        return_sequences=True)))
    model.add(Bidirectional(LSTM(240,
        input_shape=(window,columns),
        return_sequences=False)))
    model.add(Dense(7))#probably 7 or 6
    model.add(Dense(columns, activation='relu'))
    model.compile(loss='mse', optimizer='rmsprop',metrics=['accuracy'])

    #feeding model data
    model.fit(train1,label1,
        batch_size=100,epochs=30)
    print("==========Model_has_been_created==========")
    #saveing model
    model.save('RNG_prediction.h5')    

Lstm_ML(window_length,number_of_columns,train,label)


#5. Making prediction
RNG_model = load_model('RNG_prediction.h5')
testdata = Previous_Lotto_numbers[-(window_length+1):199]#last 7 list of numbers

prediction = RNG_model.predict(np.array([testdata]))
#this below is also good to use
scaled_prediction = scaler.inverse_transform(prediction)

# #round up prediction
# simple_prediction = []
# for i in scaled_prediction[0]:
#     simple_prediction.append(round(i))
# # print(simple_prediction)

#Actual result
# lastList = Previous_Lotto_numbers[-1]
# Actual_result = []
# for num in lastList:
#     Actual_result.append(ra.SB(num))

print("Predicted result "+str(scaled_prediction))#
print("Actual result    "+str([3, 3, 3, 1, 3]))#last list of numbers
print("All is well")