import os
os.environ['TF_CPP_MIN_LOG_LEVEL'] = '3'
import numpy as np
import keras
from keras.models import Sequential
from keras.layers import Dense

model = Sequential()
model.add(Dense(units=1,input_shape=[1]))
model.compile(optimizer='sgd', loss='mean_squared_error',metrics=['accuracy'])#,loss='mse'

array1= np.array([1, 2, 3, 4, 5, 6, 7],dtype=float)
array2= np.array([5, 10, 15, 20, 25, 30, 35],dtype=float)
model.fit(array1,array2,epochs=150) # what exactly happens in an epoch

result=model.predict([8]) #Should predict 8, 40
# This rounds the number and turns the float into a number
print(int(np.round(result[0][0])))
print("All is well")
