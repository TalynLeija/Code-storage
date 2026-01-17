import os
os.environ['TF_CPP_MIN_LOG_LEVEL'] = '3'
#
import numpy as np
from keras.models import Sequential
from keras.layers import LSTM
from keras.layers import Dense, Dropout
from keras.optimizers import Adam
from keras.callbacks import EarlyStopping
import pandas as pd
from matplotlib import pyplot as plt
from sklearn.preprocessing import StandardScaler
from keras.models import load_model
import numpy as np
import pandas as pd


#1. Collecting Data
#C:/Users/Lenovo/OneDrive/Documents/Exel sheets1/
df = pd.read_excel('Submarine_data.xlsx')

#2. Cleaning the data
#since i made the data It's already clean

#3. Train/Test split
#change strings into numbers
df.loc[df['X_Cord']=='A','X_Cord']=1
df.loc[df['X_Cord']=='B','X_Cord']=2
df.loc[df['X_Cord']=='C','X_Cord']=3
df.loc[df['X_Cord']=='D','X_Cord']=4
df.loc[df['Refueling']=='yes','Refueling']=1
df.loc[df['Refueling']=='no','Refueling']=0
# print(df.head())
Train_LSTM=list(df.drop(columns=['Time','Y_Cord']))
Train_ML=df['Time']
Test_ML=df['Y_Cord']

df_for_LSTM = df[Train_LSTM].astype(float)

#4. Formating for lstm
# LSTM uses sigmoid and tanh that are sensitive to magnitude so values need to be normalized
# normalize the dataset
scaler = StandardScaler()
scaler = scaler.fit(df_for_LSTM)
df_for_training_scaled = scaler.transform(df_for_LSTM)

Lstm_X = []
Lstm_Y = []

n_future = 1   # Number of days we want to look into the future based on the past days.
n_past = 5  # Number of past days we want to use to predict the future.

#
# print(df_for_training.shape)
for i in range(n_past, len(df_for_training_scaled) - n_future +1):
    Lstm_X.append(df_for_training_scaled[i - n_past:i, 0:df_for_LSTM.shape[1]])
    Lstm_Y.append(df_for_training_scaled[i + n_future - 1:i + n_future, 0])

Lstm_X, Lstm_Y = np.array(Lstm_X), np.array(Lstm_Y)


# print(scaler.inverse_transform(Lstm_X[0]))
# Y_copies = np.repeat(Lstm_Y, 2, axis=-1)
# print(scaler.inverse_transform(Y_copies)[0,0])


#5. Createing two models
def normal_ML(train,test):
    model = Sequential()
    #
    model.add(Dense(1, activation='relu', input_shape=(1,)))
    model.add(Dense(96, activation='relu'))
    model.add(Dense(64, activation='relu'))
    model.add(Dense(4, activation='relu'))
    model.add(Dense(1))#, activation='sigmoid'
    model.compile(optimizer=Adam(learning_rate=0.01), loss='mean_squared_error')#optimizer='adam'
    #feeding model data
    model.fit(train, test, epochs=160, batch_size=16)
    print("==========Model_has_been_created==========")    
    #saveing model
    # model.save('Y_test1.h5')

def Lstm_ML(lstm_x,lstm_y):
    model = Sequential()
    #return sequance is true because we need a sequance for next lstm
    model.add(LSTM(64, activation='relu', input_shape=(lstm_x.shape[1], lstm_x.shape[2]), return_sequences=True))
    model.add(LSTM(32, activation='relu', return_sequences=True))
    model.add(LSTM(8, activation='relu', return_sequences=False))#mabye 4 instead
    model.add(Dropout(0.2))
    model.add(Dense(1))#trainY.shape[1]
    model.compile(optimizer='adam', loss='mse')
    #feeding model data
    model.fit(lstm_x, lstm_y, epochs=160, batch_size=16)
    print("==========Model_has_been_created==========")    
    #saveing model
    # model.save('Lstm_test.h5')

# normal_ML(Train_ML,Test_ML)
# Lstm_ML(Lstm_X,Lstm_Y)

# #6. Making prediction
#Ml prediction
testnum=10 #works for all of them except 1

old_model1 = load_model('Y_test1.h5')
prediction_ml = round(old_model1.predict([testnum])[0][0])
# ####===============================####
#Lstm prediction
test_data=Lstm_X[-5:]#will grab last 5 in data sheet to test

oldmodel2 = load_model('Lstm_test.h5')
prediction_lstm = oldmodel2.predict(test_data)
L_copies = np.repeat(prediction_lstm, 2, axis=-1)
print(L_copies)
# ####===============================####
# #printing results
X_Cord_prediction = round(scaler.inverse_transform(L_copies)[-1,0])
Y_Cord_prediction = prediction_ml
print("Actual Cords: \t"+" [3,1]")
print("Predicted Cords: "+"["+str(X_Cord_prediction)+","+str(Y_Cord_prediction)+"]")

print("All is well")