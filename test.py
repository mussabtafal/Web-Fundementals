def superDigit(n, k):
    # Write your code here
    sum = 0
    for i in range(k):
        sum +=  int (n[i])
    print(sum)
    return sum

superDigit("9875", 4)