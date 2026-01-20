import os
os.environ['TF_CPP_MIN_LOG_LEVEL'] = '3'
import numpy as np
import pandas as pd
from sklearn.preprocessing import StandardScaler
from keras.models import Sequential
from keras.layers import LSTM, Dense, Bidirectional, Dropout
from keras.optimizers import Adam
from keras.models import load_model
import RNG_Analyzer as ra
import random

#1. Collecting data
data_size = 1000
List_size = 5
#generating pseudo random numbers
np.random.seed(5)
Previous_Lotto_numbers = np.random.randint(1,36,size=(data_size,List_size))

#convert numbers into their size brackets
SB_Lotto_numbers = np.zeros((data_size,List_size))
for i in range(len(Previous_Lotto_numbers)):
    for j in range(List_size):
        SB_Lotto_numbers[i][j]=ra.SB(Previous_Lotto_numbers[i][j])
#Create data frame
df = pd.DataFrame(SB_Lotto_numbers,columns=list("ABCDE"))
# print(Previous_Lotto_numbers[:100])


#2. Formatting data
scaler = StandardScaler().fit(df.values)
#transform df values to formated ones
transformed_dataset = scaler.transform(df.values)
#turn data into a dataframe to be easyier
transformed_df = pd.DataFrame(data=transformed_dataset, index=df.index)
# print(df.values)

#parameters
number_of_rows = df.values.shape[0] #total of games 1000
window_length = 5 #amount of past games taken into consideration 2 or 7
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


#4. Createing model
def Lstm_ML(window,columns,train1,label1):
    model = Sequential()
    model.add(Bidirectional(LSTM(16807,
        input_shape=(window,columns),
        return_sequences=True)))
    model.add(Dropout(0.2))#
    model.add(Bidirectional(LSTM(16807,
        input_shape=(window,columns),
        return_sequences=True)))
    model.add(Dropout(0.2))#
    model.add(Bidirectional(LSTM(8192,
        input_shape=(window,columns),
        return_sequences=True)))
    model.add(Bidirectional(LSTM(4096,
        input_shape=(window,columns),
        return_sequences=True)))
    model.add(Bidirectional(LSTM(2048,
        input_shape=(window,columns),
        return_sequences=False)))
    model.add(Dense(128))#
    model.add(Dense(columns))#, activation='relu'
    model.compile(optimizer=Adam(learning_rate=0.0009), loss='mse', metrics=['accuracy'])

    #feeding model data
    model.fit(x=train1,y=label1,
        batch_size=64, epochs=50, verbose=1)
    print("==========Model_has_been_created==========")
    #saveing model
#     model.save('RNG_prediction.h5')    

# Lstm_ML(window_length,number_of_columns,train,label)


# #5. Making prediction
# RNG_model = load_model('RNG_prediction3.h5')
# testdata = df.tail(8)
# testdata.drop([df.index[-1]],axis=0, inplace=True)#drops the last one to predict with
# testdata = np.array(testdata)
# # print(testdata)
# # print(SB_Lotto_numbers[-3:])

# prediction = RNG_model.predict(np.array([testdata]))
# #this below is also good to use
# scaled_prediction = scaler.inverse_transform(prediction)

# #round up prediction
# simple_prediction = []
# for i in scaled_prediction[0]:
#     simple_prediction.append(round(i))
# # print(simple_prediction)

# print("Predicted result "+str(scaled_prediction[0]))#
# print("Actual result    "+str(SB_Lotto_numbers[-1]))#last list of numbers
print("All is well")