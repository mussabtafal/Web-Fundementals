
from django.shortcuts import render, redirect
import random
from time import localtime, strftime

# Create your views here.
def index(request):
    if 'random_number' not in request.session:
        request.session['random_number'] = random.randint(1, 100)
    if not 'counter' in request.session :
        request.session['counter'] = 0
    else:
        request.session['counter'] += 1
    if not 'name' in request.session :
        request.session['name'] = []
    if not 'winner_counter' in request.session :
        request.session['winner_counter'] = []
    return render(request,"index.html")

def number_game(request): 
    request.session['guess'] = int (request.POST["randomint"]) 
    print(request.session['random_number'])
    print(request.session['guess']) 
    if request.session['guess'] == request.session['random_number']:
        request.session['result'] = "Correct"
        return redirect("/")
    elif request.session['guess'] < request.session['random_number']:
        request.session['result'] = "Low"
        return redirect("/")
    elif request.session['guess'] > request.session['random_number']:
        request.session['result'] = "High"
        return redirect("/")

def destroy(request):
    del request.session['random_number']
    del request.session['guess']
    del request.session['result']
    del request.session['counter']
    # del request.session['name']
    return redirect("/")

def winners(request):
    listname = request.session['name'] 
    listname.append(request.POST["winner_name"])
    listcount = request.session['winner_counter'] 
    listcount.append(request.session['counter'])
    request.session['number_attempts'] = request.session['counter']
    print(request.session['name'])
    print(request.session['winner_counter'])
    return render(request,"winners.html")

