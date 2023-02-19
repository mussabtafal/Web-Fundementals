import this
from django.shortcuts import render, redirect
from .models import *
from django.contrib import messages

# Create your views here.
def index(request):
    if 'userid' not in request.session:
        return redirect("/")
    else:
        this_user = User.objects.get(id = request.session['userid'])
        wish_list = this_user.wishes.all()
        granted_wishes = Granted_wish.objects.all()
        wish_data = {
            "user": this_user,
            "wishes": wish_list,
            "granted_wishes": granted_wishes
        }
        return render(request, "wish_page.html", wish_data)

def wish_addform(request):
    if 'userid' not in request.session:
        return redirect("/")
    else:
        this_user = User.objects.get(id=request.session['userid'])
        user_data = {
            'user': this_user
        }
        return render(request, 'wish_add.html', user_data)

def wish_addprocess(request):
    if 'userid' not in request.session:
        return redirect("/")
    else:
        errors = Wish.objects.basic_validator(request.POST)
        if len(errors) > 0:
            for key, value in errors.items():
                messages.error(request, value)
            return redirect('/wishes/new')
        else:
            this_user = User.objects.get(id=request.session['userid'])
            this_wish = Wish.objects.create(
                item = request.POST['item'],
                description = request.POST['description'],
                user = this_user
            )
            return redirect("/wishes")

def wish_editform(request, wish_id):
    if 'userid' not in request.session:
        return redirect("/")
    else:
        this_wish = Wish.objects.get(id = wish_id)
        this_user = User.objects.get(id=request.session['userid'])
        user_data = {
            'user': this_user,
            'wish': this_wish
        }
        return render(request, 'wish_edit.html', user_data)

def wish_editprocess(request, wish_id):
    if 'userid' not in request.session:
        return redirect("/")
    else:
        errors = Wish.objects.basic_validator(request.POST)
        if len(errors):
            for key, value in errors.items():
                messages.error(request, value)
                return redirect(f'/wishes/edit/{wish_id}')
        else:
            wish = Wish.objects.get(id= wish_id)
            wish.item = request.POST['item']
            wish.description = request.POST['description']
            wish.save()
            return redirect('/wishes') 

def grant_wish(request):
    if 'userid' not in request.session:
        return redirect("/")
    else:
        Granted_wish.objects.create(
            item = request.POST['wish_item'],
            user = User.objects.get(id=request.POST['user_id']),
            date_added = request.POST['wish_created'])
        wish = Wish.objects.get(id=request.POST['wish_id'])
        wish.delete()
        return redirect('/wishes')

def stat_page(request):
    if 'userid' not in request.session:
        return redirect("/")
    else:
        this_user = User.objects.get(id=request.session['userid'])
        granted_count = Granted_wish.objects.count()
        user_granted = User.objects.get(id=request.session['userid']).granted_wishes.count()
        user_pending = User.objects.get(id=request.session['userid']).wishes.count()
        stat_data = {
            'user': this_user,
            'granted_wishes': granted_count,
            'user_granted_wishes': user_granted,
            'user_pending_wishes': user_pending
        }
        return render(request, 'wishes_stats.html', stat_data)

def like(request):
    if request.method == 'POST':
        granted = Granted_wish.objects.get(id=request.POST['grant_id'])
        user = User.objects.get(id=request.POST['user_id'])
        if granted.user_id == user.id:
            messages.error(request, "Users may not like their own wishes.")
            return redirect('/wishes')
        if len(granted.likes.filter(id=request.POST['user_id'])) > 0:
            messages.error(request, "You have already liked this wish.")
            return redirect('/wishes')
        else:
            granted.likes.add(user)
            return redirect('/wishes')


def delete_wish(request, wish_id):
    this_wish = Wish.objects.get(id = wish_id)
    this_wish.delete()
    return redirect('/wishes')


def logout(request):
    request.session.clear()
    return redirect('/')



