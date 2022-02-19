from platform import release
from django.shortcuts import redirect, render
from .models import *


# root route redirect to /shows.

def index(request):
    return redirect('/shows')

# Show main methods
def view_all_shows(request):
    showsdata = Show.objects.all()
    shows_table = {
        "shows": showsdata,     
    }
    return render(request, "shows.html", shows_table)

def add_showsform(request):
    return render(request, "showaddform.html")

def add_shows(request):
    this_show = Show.objects.create(
    title = request.POST['show_title'],
    network = request.POST['show_network'],
    release_date = request.POST['show_date'],
    desc = request.POST['show_desc'],
    )
    return redirect(f"/shows/{this_show.id}")

def view_show(request, show_id):
    selected_show = Show.objects.get(id = show_id)
    print(selected_show.title)
    this_showdata = {
        "sel": selected_show, 
    }
    return render(request, "showviewform.html", this_showdata)

def delete_show(request,show_id):
    show_to_delete = Show.objects.get(id=show_id)
    show_to_delete.delete()
    return redirect('/shows')

def edit_showsform(request,show_id):
    show_to_update = Show.objects.get(id=show_id)
    show_update_date = show_to_update.release_date
    print(show_to_update.release_date)
    this_showdata = {
        "sel": show_to_update,
        "time": show_update_date.strftime('%Y-%m-%d')
    }
    return render(request, "showeditform.html",this_showdata)

def edit_show(request, show_id):
    show_to_update = Show.objects.get(id=show_id)
    show_to_update.title = request.POST['show_title']	
    show_to_update.network = request.POST['show_network']
    show_to_update.release_date = request.POST['show_date']
    show_to_update.desc = request.POST['show_desc']
    show_to_update.save()
    print(request.POST['show_date'])
    return redirect(f'/shows/{show_to_update.id}')

