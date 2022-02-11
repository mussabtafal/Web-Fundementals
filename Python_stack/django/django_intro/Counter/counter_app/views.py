from typing import Counter
from django.shortcuts import render, redirect

# Create your views here.
def index(request):
    return render(request,"index.html")

def number_views(request):
    
    if not "counter" in request.session:
        request.session['counter'] = 0
    else:
        request.session['counter'] += 1
    if not "actual_counter" in request.session:
        request.session['actual_counter'] = 0
    else:
        request.session['actual_counter'] += 1
    return render(request,"index.html")

def delete_counter(request):
    del request.session['counter']
    return redirect("/")

def addTwo(request):
    request.session['counter'] += 1
    return redirect("/")


def addRand(request):
    request.session['counter'] += int(request.POST["random_counter"]) - 1
    return redirect("/")



