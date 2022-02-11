from typing import Counter
from django.shortcuts import render, redirect
import random
import datetime

# Create your views here.
def index(request):
    if not "gold" in request.session:
        request.session['gold'] = 0
    if not "log" in request.session:
        request.session['log'] = []
    if not 'counter' in request.session :
        request.session['counter'] = 0
    return render(request,"index.html")

#Url location pass
def farmgold(request):
    request.session['counter'] += 1
    amount = random.randint(10, 20)
    request.session['gold'] += amount
    addtime = datetime.datetime.now()
    date_time = addtime.strftime("%m/%d/%Y, %H:%M:%p")
    activity = request.session['log'] 
    activity.append("Earned {} golds from the farm! {}".format(amount, date_time))
    print(random.randint(10, 20))
    print(request.session['gold'])
    return redirect("/")

def cavegold(request):
    request.session['counter'] += 1
    amount = random.randint(5, 10)
    request.session['gold'] += amount
    addtime = datetime.datetime.now()
    date_time = addtime.strftime("%m/%d/%Y, %H:%M:%p")
    activity = request.session['log'] 
    activity.append("Earned {} golds from the cave! {}".format(amount, date_time))
    print(random.randint(10, 20))
    print(request.session['gold'])
    return redirect("/")

def housegold(request):
    request.session['counter'] += 1
    amount = random.randint(2, 5)
    request.session['gold'] += amount
    addtime = datetime.datetime.now()
    date_time = addtime.strftime("%m/%d/%Y, %H:%M:%p")
    activity = request.session['log'] 
    activity.append("Earned {} golds from the house! {}".format(amount, date_time))
    print(random.randint(10, 20))
    print(request.session['gold'])
    return redirect("/")

def casinogold(request):
    request.session['counter'] += 1
    amount = random.randint(-50, 50)
    request.session['gold'] += amount
    if amount < 0:
        addtime = datetime.datetime.now()
        date_time = addtime.strftime("%m/%d/%Y, %H:%M:%p")
        activity = request.session['log'] 
        activity.append("Entered a casino and lost {} golds ... ouch.. {}".format(amount, date_time))
    elif amount >= 0:
        addtime = datetime.datetime.now()
        date_time = addtime.strftime("%m/%d/%Y, %H:%M:%p")
        activity = request.session['log'] 
        activity.append("Earned {} golds from the casino! {}".format(amount, date_time))
    print(random.randint(10, 20))
    print(request.session['gold'])
    return redirect("/")


#all the methods in one function
def addgold(request):   
    # if request.session['counter'] < request.POST["wincount"]:
    #     if request.session['gold'] < request.POST["wingold"]:
            if request.POST['gold'] == 'farm':
                request.session['counter'] += 1
                amount = random.randint(10, 20)
                request.session['gold'] += amount
                addtime = datetime.datetime.now()
                date_time = addtime.strftime("%m/%d/%Y, %H:%M:%p")
                activity = request.session['log'] 
                activity.append("Earned {} golds from the farm! {}".format(amount, date_time))
                print(random.randint(10, 20))
                print(request.session['gold'])
                return redirect("/")

            elif request.POST['gold'] == 'cave':
                request.session['counter'] += 1
                amount = random.randint(5, 10)
                request.session['gold'] += amount
                addtime = datetime.datetime.now()
                date_time = addtime.strftime("%m/%d/%Y, %H:%M:%p")
                activity = request.session['log'] 
                activity.append("Earned {} golds from the cave! {}".format(amount, date_time))
                print(random.randint(10, 20))
                print(request.session['gold'])
                return redirect("/")

            elif request.POST['gold'] == 'house':
                request.session['counter'] += 1
                amount = random.randint(2, 5)
                request.session['gold'] += amount
                addtime = datetime.datetime.now()
                date_time = addtime.strftime("%m/%d/%Y, %H:%M:%p")
                activity = request.session['log'] 
                activity.append("Earned {} golds from the house! {}".format(amount, date_time))
                print(random.randint(10, 20))
                print(request.session['gold'])
                return redirect("/")

            elif request.POST['gold'] == 'casino':
                request.session['counter'] += 1
                amount = random.randint(-50, 50)
                request.session['gold'] += amount
                if amount < 0:
                    addtime = datetime.datetime.now()
                    date_time = addtime.strftime("%m/%d/%Y, %H:%M:%p")
                    activity = request.session['log'] 
                    activity.append("Entered a casino and lost {} golds ... ouch.. {}".format(amount, date_time))
                elif amount >= 0:
                    addtime = datetime.datetime.now()
                    date_time = addtime.strftime("%m/%d/%Y, %H:%M:%p")
                    activity = request.session['log'] 
                    activity.append("Earned {} golds from the casino! {}".format(amount, date_time))
                print(random.randint(10, 20))
                print(request.session['gold'])
                return redirect("/")
    #     elif request.session['gold'] >= request.POST["wingold"]:
    #         activity = request.session['log'] 
    #         activity.append("You WIN !!")
    # elif request.session['counter'] == request.POST["wincount"]:
    #     activity = request.session['log'] 
    #     activity.append("You LOSE !! HA HA HA !!")



#destroy session functio
def delete(request):
    del request.session['gold']
    del request.session['log']
    del request.session['counter']
    return redirect("/")

