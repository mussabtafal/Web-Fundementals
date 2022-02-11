from django.urls import path
from . import views

urlpatterns = [
    path('', views.number_views),
    path('destroy_session', views.delete_counter),
    path('plus2', views.addTwo),
    path('random', views.addRand),
    
]