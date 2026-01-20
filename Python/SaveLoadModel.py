import pandas as pd
import numpy as np
from sklearn.preprocessing import StandardScaler
from keras.models import Sequential, load_model
from keras.layers import LSTM, Dense, Bidirectional, Dropout
import os
os.environ['TF_CPP_MIN_LOG_LEVEL'] = '3'
##pseudo random matrix
np.random.seed(5)
#                        randint(from 0,To 20, 100 list, 6 items in each)
Previous_Lotto_numbers = np.random.randint(0,20,size=(100,6))
df = pd.DataFrame(Previous_Lotto_numbers,columns=list("ABCDEF"))

#formats df into standard scaler form?
scaler = StandardScaler().fit(df.values)
transformed_dataset = scaler.transform(df.values)
transformed_df = pd.DataFrame(data=transformed_dataset, index=df.index)

#parameters???
number_of_rows = df.values.shape[0] #all our games?
window_length = 7 #amount of past games taken into consideration
number_of_features = df.values.shape[1]#balls count???

##np.empty([],float)
train = np.empty([number_of_rows-window_length, window_length, number_of_features], dtype=float)
label = np.empty([number_of_rows-window_length, number_of_features], dtype=float)
window_length = 7

for i in range(0, number_of_rows-window_length):
    train[i]=transformed_df.iloc[i:i+window_length,0: number_of_features]
    label[i]=transformed_df.iloc[i+window_length: i+window_length+1, 0: number_of_features]



##
# model = Sequential()
# model.add(Bidirectional(LSTM(240,
#     input_shape=(window_length,number_of_features),
#     return_sequences=True)))
# model.add(Dropout(0.2))
# model.add(Bidirectional(LSTM(240,
#     input_shape=(window_length,number_of_features),
#     return_sequences=True)))
# model.add(Dropout(0.2))
# model.add(Bidirectional(LSTM(240,
#     input_shape=(window_length,number_of_features),
#     return_sequences=True)))
# model.add(Bidirectional(LSTM(240,
#     input_shape=(window_length,number_of_features),
#     return_sequences=False)))

# model.add(Dense(19))#might need to change this from 59
# model.add(Dense(number_of_features))
# model.compile(loss='mse', optimizer='rmsprop',metrics=['accuracy'])
# ##
# # #Model training
# print("Start")
# model.fit(train,label,
#     batch_size=100,epochs=30)
# model.save('C:/Users/Talyn/Documents/VScode/Main/CurrentProjects/TestModel1.h5')
#   #   #   #

#   #   #   #
model = load_model('C:/Users/Talyn/Documents/VScode/Main/CurrentProjects/TestModel1.h5')
print("Start")
model.compile(loss='mse', optimizer='rmsprop',metrics=['accuracy'])
model.fit(train,label,
    batch_size=100,epochs=30)

to_predict = pd.DataFrame(Previous_Lotto_numbers,columns=list("ABCDEF"))
scaled_to_predict = scaler.transform(to_predict.values)
# print(to_predict.values)
# #np.random.randint(1,20,size=(100,6))
scaled_predicted_output1 = model.predict(np.array([scaled_to_predict]))
print(scaler.inverse_transform(scaled_predicted_output1).astype(int)[0])
print(Previous_Lotto_numbers[94])
print("All is well")


