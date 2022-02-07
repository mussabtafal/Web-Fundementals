from django.urls import path
from . import views

urlpatterns = [
    path('', views.get_time),
    path('time_display',views.get_time),
]