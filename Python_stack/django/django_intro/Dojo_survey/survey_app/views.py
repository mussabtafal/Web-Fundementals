from django.shortcuts import render, redirect

# Create your views here.
def index(request):
    return render(request,"index.html")

def create_user(request):
    print("Got Post Info....................")
    name_from_form = request.POST['name']
    location_from_form = request.POST['location']
    language_from_form = request.POST['language']
    radio_from_form = request.POST['gender']
    checkbox_from_form = request.POST['accept']
    comment_from_form = request.POST['comment']
    
    context = {
        "name_on_template" : name_from_form,
        "location_on_template" : location_from_form,
        "language_on_template" : language_from_form,
        "radio_on_template" : radio_from_form,
        "checkbox_on_template" : checkbox_from_form,
        "comment_on_template" : comment_from_form,
    }
    return render(request,"result.html",context)

def process(request):
    # this is the success route
    return render(request,"process.html")