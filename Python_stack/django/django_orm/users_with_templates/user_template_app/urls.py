from django.urls import path
from . import views

urlpatterns = [
    path('', views.index),
    path('user_form',views.form),
    path('delete',views.delete),
    path('deleteuser',views.deleteuser),
]