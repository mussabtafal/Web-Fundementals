from itertools import count
from django.shortcuts import render, redirect
from .models import *

# Create your views here.
def index(request):
    dojodata = Dojo.objects.all()
    data_table = {
        "dojos": dojodata,   
    }
    return render(request, "index.html", data_table)

def dojo_add(request):
    Dojo.objects.create(
        name = request.POST['dojoname'],
        city = request.POST['dojocity'],
        state = request.POST['dojostate'])
    return redirect('/')

def ninja_add(request):
    ninja_dojo_selection = Dojo.objects.get(name = request.POST['dojoselect'])
    Ninja.objects.create(
        first_name = request.POST['ninjafirstname'],
        last_name = request.POST['ninjalastname'],
        dojo = ninja_dojo_selection,)
    return redirect('/')

def dojo_deleteall(request):
    Dojo.objects.all().delete()
    Ninja.objects.all().delete()
    return redirect('/')

def dojo_delete(request):
    dojo_select = Dojo.objects.get(id = request.POST['table-id'])
    dojo_ninja = dojo_select.ninja.all()
    dojo_ninja.delete()
    dojo_select.delete()

    # Ninja.objects.all().delete()
    return redirect('/')