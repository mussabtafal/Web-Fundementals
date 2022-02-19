from django.urls import path
from . import views

urlpatterns = [
    path('entry', views.index),
    path('add', views.add_user),
    path('login', views.user_login),
    path('delete', views.delete_session),
    path('deletedb', views.delete_database),
    # path('success', views.success),
]