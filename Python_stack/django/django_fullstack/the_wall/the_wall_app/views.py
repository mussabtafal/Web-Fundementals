from django.shortcuts import redirect, render
from .models import *
import datetime

def root_page(request):
    if 'userid' not in request.session:
        return redirect("/entry")
    else:
        message_data = Message.objects.all().order_by("-created_at")
        data_table = {
            "messages": message_data,   
        }
        return render(request, "rootpage.html", data_table)

def msg_page(request):
    if 'userid' not in request.session:
        return redirect("/entry")
    else:
        message_data = Message.objects.all().order_by("-created_at")
        data_table = {
            "messages": message_data,   
        }
        return render(request, "wallpage.html", data_table)

def add_message(request):
    this_user = User.objects.get(id = request.session['userid'])
    Message.objects.create(
    message_text = request.POST['msg'],
    user = this_user)
    return redirect("/wall")

def add_comment(request, msg_id):
    this_user = User.objects.get(id = request.session['userid'])
    this_user_mes = Message.objects.get(id = msg_id)
    user_com = Comment.objects.create(
    comment_text = request.POST['com'],
    user = this_user,
    message = this_user_mes,)
    return redirect("/wall")

def logout(request):
    request.session.clear()
    return redirect("/entry")

def delete_msg_com(request, msg_id):
    this_msg = Message.objects.get(id = msg_id)
    theseComments = this_msg.comments.all()
    for com in theseComments:
        com.delete()
    this_msg.delete()
    return redirect("/wall")







