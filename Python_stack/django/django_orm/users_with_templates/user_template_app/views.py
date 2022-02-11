from django.shortcuts import redirect, render
from .models import *

def index(request):
    data = User.objects.all()
    user_table = {
        "users": data
    }
    return render(request, "index.html", user_table )

def form(request):
    User.objects.create(
        first_name = request.POST['first_name'], 
        last_name = request.POST['last_name'],
        email_address = request.POST['email'],
        age = request.POST['age'])
    return redirect("/")