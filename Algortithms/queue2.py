

def enque(qu,value):
    q = []
    if len(q) == 0:
        q[0] = qu[-1] 
    else:
        qu[value] = q[-1] 
        for i in range (len(qu),0,-1):
            q[i-1]=qu[i]
    return q
    

print(enque([1,2,3,5],4))
