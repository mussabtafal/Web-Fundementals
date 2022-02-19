from django.urls import path
from . import views

urlpatterns = [
    path('', views.index),
    path('shows', views.view_all_shows),
    path('shows/new', views.add_showsform),
    path('shows/new/add', views.add_shows),
    path('shows/<int:show_id>', views.view_show),
    path('shows/<int:show_id>/destroy', views.delete_show),
    path('shows/<int:show_id>/edit', views.edit_showsform),
    path('shows/<int:show_id>/edit/process', views.edit_show),
]