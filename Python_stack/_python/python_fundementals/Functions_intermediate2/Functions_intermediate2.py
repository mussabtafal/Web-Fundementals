x = [ [5,2,3], [10,8,9] ] 
students = [
     {'first_name':  'Michael', 'last_name' : 'Jordan'},
     {'first_name' : 'John', 'last_name' : 'Rosales'}
]
sports_directory = {
    'basketball' : ['Kobe', 'Jordan', 'James', 'Curry'],
    'soccer' : ['Messi', 'Ronaldo', 'Rooney']
}
z = [ {'x': 10, 'y': 20} ]

# **
x[1][0]=15
print(x)
# **
students[0]['last_name']='Bryant'
print(students)
# **
sports_directory['soccer'][0]='Andres'
print(sports_directory)
# **
z[0]['y']=30
print(z)
students = [
{'first_name':  'Michael', 'last_name' : 'Jordan'},
{'first_name' : 'John', 'last_name' : 'Rosales'},
{'first_name' : 'Mark', 'last_name' : 'Guillen'},
{'first_name' : 'KB', 'last_name' : 'Tonel'}]


def  iterateDictionary(students):
    for i in range(0,len(students),1):
     print(students[i]['first_name'],students[i]['last_name']) 


iterateDictionary(students)



# should output: (it's okay if each key-value pair ends up on 2 separate lines;
# bonus to get them to appear exactly as below!)
# first_name - Michael, last_name - Jordan
# first_name - John, last_name - Rosales
# first_name - Mark, last_name - Guillen
# first_name - KB, last_name - Tonel

# **ITERATE DICTIONARY 2**


students = [
{'first_name':  'Michael', 'last_name' : 'Jordan'},
{'first_name' : 'John', 'last_name' : 'Rosales'},
{'first_name' : 'Mark', 'last_name' : 'Guillen'},
{'first_name' : 'KB', 'last_name' : 'Tonel'}]


def iterateDictionary2(a,b):
        for i in range(0,len(b),1):
            print(b[i][a])



iterateDictionary2('first_name',students)
iterateDictionary2('last_name',students)





# *Iterate Through a Dictionary with List Values**


dojo = {
   'locations': ['San Jose', 'Seattle', 'Dallas', 'Chicago', 'Tulsa', 'DC', 'Burbank'],
   'instructors': ['Michael', 'Amy', 'Eduardo', 'Josh', 'Graham', 'Patrick', 'Minh', 'Devon']
}


def iterate(a):
    count1=0
    count2=0
    x=len(dojo['locations'])
    y=len(dojo['instructors'])
    for i in range (0,x,1):
        count1+=1
        print(dojo['locations'][i] )
    print(count1 , 'locations')
    for j in range (0,y,1):
        count2+=1
        print(dojo['instructors'][j] )
    print(count2 , 'instrutors')



iterate(dojo)