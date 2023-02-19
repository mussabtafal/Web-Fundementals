from django.urls import path
from . import views

urlpatterns = [
    path('wishes', views.index),
    path('wishes/new', views.wish_addform),
    path('wishes/grant', views.grant_wish),
    path('wishes/stats', views.stat_page),
    path('wishes/like', views.like),
    path('wishes/<int:wish_id>/delete', views.delete_wish),
    path('wishes/new/add', views.wish_addprocess),
    path('wishes/edit/<int:wish_id>', views.wish_editform),
    path('wishes/edit/<int:wish_id>/process', views.wish_editprocess),
    path('logout', views.logout),
]