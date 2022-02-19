from django.urls import path
from . import views

urlpatterns = [
    path('', views.root_page),
    path('wall', views.msg_page),
    path('wall/message', views.add_message),
    path('wall/log_out', views.logout),
    path('wall/delete_msg/<int:msg_id>', views.delete_msg_com),
    path('wall/comment/<int:msg_id>', views.add_comment),
]