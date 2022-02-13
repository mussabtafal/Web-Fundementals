from django.urls import path
from . import views

urlpatterns = [
    path('', views.index),
    path('add_dojo', views.dojo_add),
    path('add_ninja', views.ninja_add),
    path('delete', views.dojo_deleteall),
    path('destroy_dojo', views.dojo_delete),
    
]