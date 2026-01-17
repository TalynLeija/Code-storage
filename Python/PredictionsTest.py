#Once I get rid of the excel sheet revisit this to make it work
#https://www.youtube.com/watch?v=7eh4d6sabA0&list=PLphju_7lCKniNj-AwvPYO3bFM7uF0G77l&index=97&t=334s

import pandas as pd
from sklearn.tree import DecisionTreeClassifier
from sklearn.model_selection import train_test_split
from sklearn.metrics import accuracy_score

#C:/Users/Lenovo/OneDrive/Documents/Exel sheets1/
music_data = pd.read_csv('music.csv')
#highlight drop() to see what can be droped
X = music_data.drop(columns=['genre'])#
Y = music_data['genre']
#This allocates 20% of data for testing 0.2
X_train, X_test, Y_train, Y_test = train_test_split(X, Y,  test_size=0.2)


# print(music_data)
# print('-'*25)
# print(X)
# print('-'*25)
# print(Y)

model = DecisionTreeClassifier()
#model.fit takes input set and output set
#make sure to put .values at the end
# model.fit(X.values,Y.values)
model.fit(X_train.values, Y_train.values)#X, Y

#asking the model to make predictions
#Here we are trying to predict what kind of music a 21 year old male likes
#male being represented by 1
predictions = model.predict(X_test.values)#[[21,1],[22,0]]
score = accuracy_score(Y_test.values, predictions)


print(predictions)
# print('-'*25)
# print(Y_test)
print(score)
print("All is well")