
from operator import le


def countdown(num):
    array_num = []
    for i in range (num, -1, -1):
        array_num.append(i)
    return array_num
print(countdown(5))


num = [2,5]
def print_return(num):
    print(num[0])
    return num[1]
print(print_return(num))


num = [3,7,1,4,6]
def first_plus_length(num):
    return num[0] + len(num) 
print(first_plus_length(num))


num = [3,3,1,4,6]
def val_greater(num):
    newnum = []
    for i in range(0,len(num),1):
        if num[i] > num[1]:
            newnum.append(num[i])
    return newnum
print(val_greater(num))


def len_val(num1,num2):
    numlist = []
    for i in range (0,(num1),1):
        numlist.append(num2)
    return numlist
print(len_val(55,6))