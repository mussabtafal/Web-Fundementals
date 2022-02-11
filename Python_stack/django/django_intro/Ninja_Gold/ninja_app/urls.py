from django.urls import path
from . import views

urlpatterns = [
    path('', views.index),
    path('process_money',views.addgold),
    path('farm',views.farmgold),
    path('cave',views.cavegold),
    path('house',views.housegold),
    path('casino',views.casinogold),
    path('destroy_session',views.delete),
]