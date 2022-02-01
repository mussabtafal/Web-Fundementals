from turtle import pos


num = [-3,5,-7,8,-2]
def biggie_size(num):
    for i in range (0,len(num),1):
        if num[i] > 0:
            num[i] = "big"
    return num
print(biggie_size(num))


num = [3,4,-7,8,-2]
def count_positives(num):
    pos_count = 0
    for i in range (0,len(num),1):
        if num[i] > 0:
            pos_count += 1
    num[len(num)-1] = pos_count
    return num
print(count_positives(num))


num = [3,4,-7,8,-2]
def sum(num):
    sum = 0
    for i in range (0,len(num),1):
        sum += num[i]
    return sum
print(sum(num))

num = []
def list_length(num):
    return len(num)
print(list_length(num))



num = [3,4,-7,8,-2]
def minimum(num):
    min = num[0]
    for i in range (1,len(num),1):
        if min> num[i]:
            min = num[i]
    return min
print(minimum(num))


num = [3,4,-7,8,-2]
def maximum(num):
    max = num[0]
    for i in range (1,len(num),1):
        if max < num[i]:
            max = num[i]
    return max
print(maximum(num))


num = [3,4,-7,8,-2]
def ultimate_analyst(num):
    sum = 0
    min = num[0]
    max = num[0]
    for i in range (0,len(num),1):
        sum += num[i]
        if max < num[i]:
            max = num[i]
        if min> num[i]:
            min = num[i]
    return "sumTotal:", sum, "Average:", sum/len(num), "min:", min, "max:", max, "length:", len(num)
print(ultimate_analyst(num))


num = [3,4,-7,8,-2]
def reverse(num):
    reversed_num = []
    for i in range (len(num)-1,-1,-1):
        reversed_num.append(num[i])
    return reversed_num
print(reverse(num))










