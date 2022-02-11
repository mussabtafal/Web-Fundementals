from django.urls import path
from . import views

urlpatterns = [
    path('', views.index),
    path('number_game', views.number_game),
    path('destroy_session', views.destroy),
    path('winner_leaderboard', views.winners),
]