#Size Bracket
def SB(num):
    #finds size braket for a given number
    if num<=5:
        return 1
    elif num<=10 and num>5:
        return 2
    elif num<=15 and num>10:
        return 3
    elif num<=20 and num>15:
        return 4
    elif num<=25 and num>20:
        return 5
    elif num<=30 and num>25:
        return 6
    else:
        return 7
    
def Dominant_SB(array):
    SB_count = {'s1': 0,'s2': 0,'s3': 0,'s4': 0,'s5': 0}
    for i in array:
        SB_count[SB(i)]+=1
    Sorted_SB = sorted(SB_count.items(), key=lambda x:x[1])
    # print(Sorted_SB)gggggggggggggggggg
    return int(Sorted_SB[-1][0][1])

#Size braket Variety amount
def SV(array):
    size_homogeneity=[]
    for i in array:
        size_bracket=SB(i)
        if size_bracket not in size_homogeneity:
            size_homogeneity.append(size_bracket)
    # print(size_homogeneity)
    return len(size_homogeneity)

#Evens amount
def EV(array):
    evens_amount=0
    for i in array:
        if i%2==0:
            evens_amount+=1
    return evens_amount

#Homogeneity combinations
def HC2(array):
    #asighns values to size bracket
    SB_value = {'s1': 0,'s2': 0,'s3': 0,'s4': 0,'s5': 0}
    S_value=int(Dominant_SB(array))
    for i in range(len(array)):
        if S_value==5:
            SB_value['s{}'.format(S_value)]+=i  
            S_value=1
        else:
            SB_value['s{}'.format(S_value)]+=i
            S_value+=1

    #Accounts for last sb
    if S_value-1==0:
        SB_value['s5']+=1
    else:
        SB_value['s{}'.format(S_value-1)]+=1

    point_value=0
    #set gets rid of duplicates
    for i in [*set(array)]:
        point_value+=SB_value[SB(i)]

    return point_value+(4*(SV(array)-1))-4

#turns hc number into useable prediction
def HC_analizer(hc_num,dominant_sb):
    # reverse size bracket value
    RSB_value = {'p2': None,'p3': None,'p4': None,'p5': None}#'p1': str(dominant_sb),
    SB_list = ['s1','s2','s3','s4','s5']
    for i in range(2,6):
        tempnum=int(dominant_sb[1])
        RSB_value['p{}'.format(i)]=SB_list[-5+tempnum+(i-2)]

    match (hc_num):
        case 0:
          print(dominant_sb+'//Full')  
        case 1:
            print(dominant_sb+'//'+RSB_value['p2'])
        case 2:
            print(dominant_sb+'//'+RSB_value['p3'])
        case 3:
            print(dominant_sb+'//'+RSB_value['p4'])
        case 5:
            print(dominant_sb+'//'+RSB_value['p5'])
        case 7:
            print(dominant_sb+'//'+RSB_value['p2']+'/'+RSB_value['p3'])
        case 8:
            print(dominant_sb+'//'+RSB_value['p2']+'/'+RSB_value['p4'])
        case 9:
            print(dominant_sb+'//'+RSB_value['p3']+'/'+RSB_value['p4'])
        case 10:
            print(dominant_sb+'//'+RSB_value['p2']+'/'+RSB_value['p5'])
        case 11:
            print(dominant_sb+'//'+RSB_value['p3']+'/'+RSB_value['p5'])
        case 12:
            print(dominant_sb+'//'+RSB_value['p4']+'/'+RSB_value['p5'])
        case 14:
            print(dominant_sb+'//'+RSB_value['p2']+'/'+RSB_value['p3']+'/'+RSB_value['p4'])
        case 16:
            print(dominant_sb+'//'+RSB_value['p2']+'/'+RSB_value['p3']+'/'+RSB_value['p5'])
        case 17:
            print(dominant_sb+'//'+RSB_value['p2']+'/'+RSB_value['p4']+'/'+RSB_value['p5'])
        case 18:
            print(dominant_sb+'//'+RSB_value['p5']+'/'+RSB_value['p4']+'/'+RSB_value['p3'])
        case 23:
            print(dominant_sb+'//'+RSB_value['p2']+'/'+RSB_value['p3']+'/'+RSB_value['p4']+'/'+RSB_value['p5'])   
        case _:
            print('Unkown')

#Size Bracket Homogeneity
def SHH(array):
    SB_count = {'s1': 0,'s2': 0,'s3': 0,'s4': 0,'s5': 0}
    for i in array:
        SB_count[SB(i)]+=1
    Sorted_SB = sorted(SB_count.items(), key=lambda x:x[1])
    print(Sorted_SB)
    if Sorted_SB[-1][1]==1:
        #print('No Homogeneity')
        print(Sorted_SB[-1][0])
    elif Sorted_SB[-1][1]==2 and Sorted_SB[-2][1]==1:
        #print('High Chaotic Homogeneity')
        print(Sorted_SB[-1][0])
    elif Sorted_SB[-1][1]==3 and Sorted_SB[-2][1]==1:
        #print('Low Chaotic Homogeneity')
        print(Sorted_SB[-1][0])
    elif Sorted_SB[-1][1]==2 and Sorted_SB[-2][1]==2:
        #print('Half-and-Half')
        print(Sorted_SB[-1][0])
    elif Sorted_SB[-1][1]==3 and Sorted_SB[-2][1]==2:
        #print('Mostly Homogeneity')
        print(Sorted_SB[-1][0])
    elif Sorted_SB[-1][1]==4 and Sorted_SB[-2][1]==1:
        #print('Homogeneity')
        print(Sorted_SB[-1][0])
    else:
        #print('Full Homogeneity')
        print(Sorted_SB[-1][0])

def SB2(num):
    #finds size braket for a given number
    if num<=5:
        return 's1'
    elif num<=10 and num>5:
        return 's2'
    elif num<=15 and num>10:
        return 's3'
    elif num<=20 and num>15:
        return 's4'
    elif num<=25 and num>20:
        return 's5'
    elif num<=30 and num>25:
        return 's6'
    else:
        return 's7'
    

#Test numbers
#s1 s2 s3 s4 s5
# 5 10 15 24 30

#
# HC_number = HC2([4,4,4,15,10])
# print(HC_number-4)
# HC_analizer(HC_number-4,'s1')
#

# testlist=[1,4,4,4,10]
# print(EV(testlist))
# print(Dominant_SB(testlist))
# print(HC2(testlist))