from django.shortcuts import render, redirect
from .models import *
import bcrypt
from django.contrib import messages

def index(request):
    return render(request, "index.html")

def add_user(request):
    errors = User.objects.basic_validator(request.POST)
    if len(errors) > 0:
        for key, value in errors.items():
            messages.error(request, value)
        return redirect('/entry')
    else:
        password = request.POST['password']
        pw_hash = bcrypt.hashpw(password.encode(), bcrypt.gensalt()).decode()  
        print(pw_hash)   
        this_user = User.objects.create(
        first_name = request.POST['first_name'],
        last_name = request.POST['last_name'],
        user_dob = request.POST['dob'],
        useremail = request.POST['email'],
        userpassword = pw_hash,)
        request.session['userid'] = this_user.id
        request.session['userfirstname'] = this_user.first_name
        return redirect("/wall")

def user_login(request):
    logerrors = User.logins.basic_validator(request.POST)
    if len(logerrors) > 0:
        for key, value in logerrors.items():
            messages.error(request, value)
        return redirect('/entry')
    else:
        user = User.objects.filter(useremail=request.POST['email']) 
        if user: 
            logged_user = user[0]
            if bcrypt.checkpw(request.POST['password'].encode(), logged_user.userpassword.encode()):
                request.session['userid'] = logged_user.id
                request.session['userfirstname'] = logged_user.first_name
                return redirect("/wall")

# def success(request):
#     if 'userid' in request.session and 'userfirstname' in request.session:
#         return redirect('/')
#     else: 
#         return redirect('/entry')


def delete_session(request):
    if not 'userid' in request.session:
        request.session['userid'] = 0
    if not 'userid' in request.session:
        request.session['userfirstname'] = ""
    del request.session['userfirstname']
    del request.session['userid']
    return redirect("/entry")

def delete_database(request):
    users = User.objects.all()
    users.delete()
    return redirect("/entry")